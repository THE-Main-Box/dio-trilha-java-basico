package model;

import util.Constants;

public class User {
    private String userName, name, email, passWord;
    private int birthDay,birthMonth, birthYear;

    public User(String userName, String name, String email, String passWord, String birthDate) {
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.passWord = passWord;

        this.convertBirthDate(birthDate);
        showValues();
    }

    private void showValues(){
        System.out.println("\nConta criada com sucesso!");
        System.out.println("======= DADOS DA CONTA =======");
        System.out.println("Usuário: " + getUserName());
        System.out.println("Nome: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Senha: " + getPassWord());
        System.out.println("Data de nascimento: " +
                String.format("%02d/%02d/%04d",
                        getBirthDay(),
                        getBirthMonth(),
                        getBirthYear()));
        System.out.println("===============================");
    }

    private void convertBirthDate(String bd){
        String[] parts = bd.split(Constants.dateSeparationFormat.formatRegex);
        if (parts.length == 3) {
            this.birthDay = Integer.parseInt(parts[0]);
            this.birthMonth = Integer.parseInt(parts[1]);
            this.birthYear = Integer.parseInt(parts[2]);
        } else {
            throw new IllegalArgumentException("Data de nascimento inválida. Use o formato: 'dia mês ano'");
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassWord() {
        return passWord;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
