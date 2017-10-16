package com.i034114.taller_quiz.Models;

/**
 * Created by aula7 on 12/10/17.
 */

public class ModelsUsers {

    private int id;
    private String name;
    private String username;
    private String address;
    private String company;
    private  String[] arrayPhotosU;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getArrayPhotosU() {
        arrayPhotosU = new String[10];
        arrayPhotosU[0]="http://helpmybusinesspos.info/wp-content/uploads/2015/02/Usuario-permisos_mybusinesspos-300x200.png";
        arrayPhotosU[1]="https://nebul4ck.files.wordpress.com/2015/06/usuarios.png?w=350&h=200&crop=1";
        arrayPhotosU[2]="http://www.iaipanama.org/images/img-demo/usuario-registrados.png";
        arrayPhotosU[3]="http://static.freepik.com/foto-gratis/usuarios-del-sistema-de-tango_17-329084610.jpg";
        arrayPhotosU[4]="https://ayudawp.com/wp-content/uploads/2014/02/usuario-registrado.jpg";
        arrayPhotosU[5]="https://www.snsmarketing.es/blog/wp-content/uploads/2015/11/experiencia-de-usuario.jpg";
        arrayPhotosU[6]="http://ubuntuserver.dabensoft.com/usuarios.png";
        arrayPhotosU[7]="http://www.doctanet.com/images/img_elearning.jpg";
        arrayPhotosU[8]="http://www.managementjournal.net/images/stories/perfilesdeusuarios.jpg";
        arrayPhotosU[9]="http://restrepoospina.com.ec/consultas/img/registrado.png";
        int numero = (int) (Math.random() * 9);

        return arrayPhotosU[numero];
    }
}
