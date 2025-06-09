package service;

import model.User;
import util.Constants;

import java.util.Scanner;

public class UserDataCollector {

    private Scanner scanner = new Scanner(System.in);

    private String userName;
    private String name;
    private String email;
    private String password;
    private String birthDate;

    public void getUserName() {
        System.out.print("Como devemos te chamar: ");
        this.userName = scanner.nextLine();
    }

    public void getName() {
        System.out.print("Digite seu NOME COMPLETO: ");
        this.name = scanner.nextLine();
    }

    public void getEmail() {
        System.out.print("Digite seu EMAIL: ");
        this.email = scanner.nextLine();
    }

    public void getPassword() {
        System.out.print("Digite sua SENHA: ");
        this.password = scanner.nextLine();
    }

    public void getBirthDate() {
        while (true) {
            System.out.print("Digite sua DATA DE NASCIMENTO " + Constants.dateSeparationFormat.BIRTH_DATE_FORMAT_GUIDE + ": ");
            String input = scanner.nextLine();

            String[] parts = input.trim().split(Constants.dateSeparationFormat.formatRegex);
            if (parts.length == 3) {
                try {
                    int day = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);

                    // Verificação básica
                    if (day < 1 || day > 31 || month < 1 || month > 12) {
                        System.out.println("Data inválida. Tente novamente.");
                        continue;
                    }

                    this.birthDate = input;
                    break;

                } catch (NumberFormatException e) {
                    System.out.println("A data deve conter apenas números. Tente novamente.");
                }
            } else {
                System.out.println("Formato inválido. " + Constants.dateSeparationFormat.BIRTH_DATE_FORMAT_GUIDE);
            }
        }
    }


    public void reDoValue(String campo) {
        switch (campo.toLowerCase()) {
            case "username" -> getUserName();
            case "name"     -> getName();
            case "email"    -> getEmail();
            case "password" -> getPassword();
            case "birthdate"-> getBirthDate();
            default         -> System.out.println("Campo inválido. Tente novamente.");
        }
    }

    public void initCollection() {
        getUserName();
        getName();
        getEmail();
        getPassword();
        getBirthDate();

        while (true) {
            showValues();

            System.out.print("Os dados estão corretos? (s/n): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("s")) {
                break;
            }

            System.out.print("Qual campo deseja refazer? (userName, name, email, password, birthDate): ");
            String campo = scanner.nextLine();
            reDoValue(campo);
        }

        createAccount();
    }

    ///Caso completemos a criação da conta prosseguimos
    private void createAccount(){
        new User(userName, name, email, password, birthDate);
    }


    private void showValues() {
        System.out.println("\n===== RESUMO DOS DADOS =====");
        System.out.println("Nome de usuário: " + userName);
        System.out.println("Nome completo:   " + name);
        System.out.println("Email:           " + email);
        System.out.println("Senha:           " + password);
        System.out.println("Data nascimento: " + birthDate);
        System.out.println("============================");
    }

    // Getters se você quiser usar esses valores depois:
    public String getUserNameFinal() { return userName; }
    public String getNameFinal() { return name; }
    public String getEmailFinal() { return email; }
    public String getPasswordFinal() { return password; }
    public String getBirthDateFinal() { return birthDate; }
}
