package sistemadevotaciones;

/**
 *
 * @author Joseph
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaDeVotaciones {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido al SISTEMA DE VOTACIONES");
        System.out.println("Ingrese una contrasena para el Sistema");

        //declaracion de variables
        String nombre, apellido, usuario, pass, email, formAcademica, experienciaProfesional, estado, datoModificar, direccion, departamento, municipio;
        int l, opc, opcionAdmin;
        long cui;

        // creacion de archivos para guardar registros
        File archivo;
        File datosAdmin;
        File datosRegVotantes;
        File datosAuditor;
        File datosVotantes;
        File eleccion;
        File candidato;
        File votos;

        FileWriter escribir;
        PrintWriter linea;

        archivo = new File("passSistema.txt");
        datosAdmin = new File("datosAdmin.txt");
        datosVotantes = new File("datosVotantes.txt");
        eleccion = new File("Elecciones.txt");
        candidato = new File("candidato.txt");
        datosRegVotantes = new File("cuentasRegistrador.txt");
        datosAuditor = new File("cuentasAuditor.txt");

        if (!archivo.exists()) {
            String passSistem = scan.nextLine();
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println(passSistem);
                escribir.close();
                linea.close();

            } catch (IOException ex) {
                Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int opcion1 = 0;
        // ciclo principal
        int i = 1;
        while (i < 2) {
            System.out.println("SISTEMA DE VOTACIONES");
            System.out.println("1. Iniciar Sesion.");
            System.out.println("2. Crear Usuario.");
            System.out.println("3. Modificar Usuario");
            System.out.println("4. Desabilitar Usuario");
            System.out.println("5. Salir.");
            if (opcion1 > 0) {
            } else {
                opcion1 = scan.nextInt();
            }
            // casos del primer menu
            switch (opcion1) {
                case 1:
                    int o = 0;
                    while (o < 1) {
//*************************************1.INICIAR SESION********************************************************//                        
//*************************************SUB MENU INICIAR SESION***************************************************//
                        System.out.println("SISTEMA DE VOTACIONES");
                        System.out.println("Iniciar Sesion.");
                        System.out.println("1. Administrador.");
                        System.out.println("2. Registrador de Votantes.");
                        System.out.println("3. Votante.");
                        System.out.println("4. Auditor.");
                        System.out.println("5. Regresar.");
                        System.out.println("6. Salir.");
                        System.out.println("Ingrese una opcion: ");
                        int p = 0; // restableciendo variable para no ejecutar los while amarrados a esta variable
                        int opcI = scan.nextInt();
                        switch (opcI) {
                            case 1:
                                try {
                                System.out.println("Iniciar Sesion como Administrador");
                                System.out.println("Ingrese No. DPI");
                                scan.nextLine();
                                String dpi = scan.nextLine();
                                System.out.println("Ingrese Contraseña");
                                pass = scan.nextLine();
                                FileReader leer = new FileReader(datosAdmin);
                                BufferedReader br = new BufferedReader(leer);
                                String leyendoDato = "";

                                while ((leyendoDato = br.readLine()) != null) {
                                    String[] dat = leyendoDato.split("\\|");

                                    if (dat[0].compareTo(dpi) == 0 && dat[5].compareTo(pass) == 0) {

                                        int co = 0;
                                        while (p == 0) {
                                            System.out.println("SISTEMA DE VOTACIONES");
                                            System.out.println("Administrador de Elecciones");
                                            System.out.println("Bienvenido " + dat[4]);
                                            System.out.println("1. Gestionar Elecciones");
                                            System.out.println("2. Gestionar Candidatos");
                                            System.out.println("3. Configurar opciones de Eleccion");
                                            System.out.println("4. Regresar");
                                            System.out.println("5. Salir");
                                            int opAdm = scan.nextInt();
                                            int w = 1;
                                            while (w == 1) {
                                                switch (opAdm) {
                                                    case 1:
                                                        System.out.println("SISTEMA DE VOTACIONES");
                                                        System.out.println("Gestion de Elecciones");
                                                        System.out.println("1. Crear Elecciones:");
                                                        System.out.println("2. Eliminar Elecciones.");
                                                        System.out.println("3. Regresar.");
                                                        System.out.println("4. Salir del Sistema.");
                                                        opc = scan.nextInt();
                                                        switch (opc) {
                                                            case 1:
                                                                //********************************************//
                                                                //****Creacion de Elecciones en el Sistema****//
                                                                //********************************************//
                                                                System.out.println("SISTEMA DE VOTACIONES");
                                                                System.out.println("Sesion Iniciada como " + dat[4]);
                                                                System.out.println("Nueva Eleccion");
                                                                System.out.println("Ingrese los siguientes Datos");
                                                                System.out.println("Ingrese el Titulo de Eleccion:");
                                                                scan.nextLine();
                                                                String titulo = scan.nextLine();
                                                                System.out.println("Ingrese el Proposito de la Eleccion:");
                                                                String proposito = scan.nextLine();
                                                                System.out.println("Ingrese una breve Descripcion de la Eleccion:");
                                                                String descripcion = scan.nextLine();
                                                                System.out.println("Codigo Generado");
                                                                long codigoEleccion = (long) (Math.random() * 100000000 + 1);
                                                                System.out.println(codigoEleccion);
                                                                //fecha de Inicio y Finalizacion de Inscripñcion de Candidato
                                                                System.out.println("Ingrese la fecha de Inicio de Eleccion de Candidatos");
                                                                System.out.print("Dia:");
                                                                int dia = scan.nextInt();
                                                                System.out.print("Mes:");
                                                                int mes = scan.nextInt();
                                                                System.out.print("Año:");
                                                                int anio = scan.nextInt();
                                                                System.out.println("Ingrese la hora de Inicio.");
                                                                int hora = scan.nextInt();
                                                                System.out.println("1. am \n2. pm");
                                                                int am = scan.nextInt();
                                                                System.out.println("Ingrese la fecha de Finalizaccion de Eleccion de Candidatos");
                                                                System.out.print("Dia:");
                                                                int diaF = scan.nextInt();
                                                                System.out.print("Mes:");
                                                                int mesF = scan.nextInt();
                                                                System.out.print("Año:");
                                                                int anioF = scan.nextInt();
                                                                System.out.println("Ingrese la hora de Finalizacion .");
                                                                int horaF = scan.nextInt();
                                                                int s = 0;
                                                                String amF = "";
                                                                while (s == 0) {
                                                                    System.out.println("1. am \n2. pm");
                                                                    int f = scan.nextInt();
                                                                    if (f == 1) {
                                                                        amF = "am";
                                                                        s = 2;
                                                                    } else if (f == 2) {
                                                                        amF = "pm";
                                                                        s = 2;
                                                                    } else {
                                                                        System.out.println("Opcion Incorrecta \n Ingrese una opcion Correcta");
                                                                    }
                                                                }
                                                                //Ingreso de Fecha de Inicio y Finalizacion de Votacion
                                                                System.out.println("Ingrese la fecha de Inicio de votacion");
                                                                System.out.print("Dia:");
                                                                int diaV = scan.nextInt();
                                                                System.out.print("Mes:");
                                                                int mesV = scan.nextInt();
                                                                System.out.print("Año:");
                                                                int anioV = scan.nextInt();
                                                                System.out.println("Ingrese la hora de Inicio de votacion.");
                                                                int horaV = scan.nextInt();
                                                                System.out.println("1. am \n2. pm");
                                                                int amV = scan.nextInt();
                                                                System.out.println("Ingrese la fecha de Finalizaccion de Votacion");
                                                                System.out.print("Dia:");
                                                                int diaFv = scan.nextInt();
                                                                System.out.print("Mes:");
                                                                int mesFv = scan.nextInt();
                                                                System.out.print("Año:");
                                                                int anioFv = scan.nextInt();
                                                                System.out.println("Ingrese la hora de Finalizacion.");
                                                                int horaFv = scan.nextInt();
                                                                int ss = 0;
                                                                String amFv = "";
                                                                while (ss == 0) {
                                                                    System.out.println("1. am \n2. pm");
                                                                    int f = scan.nextInt();
                                                                    if (f == 1) {
                                                                        amFv = "am";
                                                                        ss = 2;
                                                                    } else if (f == 2) {
                                                                        amFv = "pm";
                                                                        ss = 2;
                                                                    } else {
                                                                        System.out.println("Opcion Incorrecta \n Ingrese una opcion Correcta");
                                                                    }
                                                                }
                                                                try {
                                                                    if (!eleccion.exists()) {
                                                                        eleccion.createNewFile();
                                                                        escribir = new FileWriter(eleccion);
                                                                        linea = new PrintWriter(escribir);
                                                                        linea.print(codigoEleccion + "|" + titulo + "|" + proposito + "|" + descripcion + "|" + dia + "|" + mes + "|" + anio + "|" + hora + "|" + diaF + "|" + mesF + "|" + anioF + "|" + horaF + "|");
                                                                        linea.print(diaV + "|" + mesV + "|" + anioV + "|" + horaV + "|" + diaFv + "|" + mesFv + "|" + anioFv + "|" + horaFv + "\n");
                                                                        escribir.close();
                                                                        linea.close();
                                                                        System.out.println("Creacion de Eleccion Exitosa");
                                                                    } else {
                                                                        escribir = new FileWriter(eleccion);
                                                                        linea = new PrintWriter(escribir);
                                                                        linea.print(codigoEleccion + "|" + titulo + "|" + proposito + "|" + descripcion + "|" + dia + "|" + mes + "|" + anio + "|" + hora + "|" + diaF + "|" + mesF + "|" + anioF + "|" + horaF + "|");
                                                                        linea.print(diaV + "|" + mesV + "|" + anioV + "|" + horaV + "|" + diaFv + "|" + mesFv + "|" + anioFv + "|" + horaFv + "\n");
                                                                        escribir.close();
                                                                        linea.close();
                                                                        System.out.println("Creacion de Eleccion Exitosa");

                                                                    }

                                                                } catch (IOException ex) {

                                                                }

                                                                break;
                                                            case 2:
                                                                //********************************************//
                                                                //****Eliminar Elecciones en el Sistema****//
                                                                //********************************************//
                                                                System.out.println("Ingrese el Codigo de Eleccion");
                                                                scan.nextLine();
                                                                String codigoEleccionn = scan.nextLine();
                                                                try {
                                                                    FileReader leerEl = new FileReader(eleccion);
                                                                    BufferedReader leyendoEl = new BufferedReader(leerEl);

                                                                    File xArchivo = new File("temp.txt");
                                                                    FileWriter es = new FileWriter(xArchivo);
                                                                    BufferedWriter ess = new BufferedWriter(es);

                                                                    String lineaEl = "";
                                                                    while ((lineaEl = leyendoEl.readLine()) != null) {
                                                                        String[] array = lineaEl.split("\\|");
                                                                        System.out.println(lineaEl);
                                                                        System.out.println(array);
                                                                        if (array[0].compareTo(codigoEleccionn) == 0) {
                                                                            System.out.println("No. Eleccion " + codigoEleccionn + " = " + array[1]);

                                                                            System.out.println("Eliminar Eleccion");
                                                                            System.out.println("1. Si.");
                                                                            System.out.println("2. No.");
                                                                            System.out.println("Ingrese Una Opcion");

                                                                        }

                                                                    }
                                                                    leyendoEl.close();
                                                                    ess.close();

                                                                    Files.move(xArchivo.toPath(), eleccion.toPath(), REPLACE_EXISTING);

                                                                } catch (FileNotFoundException ex) {
                                                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                                                } catch (IOException ex) {
                                                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                                                }

                                                                break;
                                                            case 3:
                                                                w = 5;
                                                                break;
                                                            case 4:
                                                                //*************REGRESAR MENU****/////
                                                                w = 5;
                                                                p = 5;
                                                                o = 5;
                                                                i = 5;
                                                                break;

                                                            default:
                                                                break;

                                                        }

                                                        break;

                                                    case 2:
                                                        //**************************************//
                                                        //****Menu de Gestionar Candidatos*****//
                                                        //*************************************//
                                                        System.out.println("SISTEMA DE VOTACIONES");
                                                        System.out.println("Gestionar Candidatos");
                                                        System.out.println("1. Registrar Candidato.");
                                                        System.out.println("2. Modificar Candidato.");
                                                        System.out.println("3. Eliminar Candidato.");
                                                        System.out.println("4. Regresar.");
                                                        System.out.println("5. Salir.");
                                                        int opG = scan.nextInt();
                                                        switch (opG) {
                                                            case 1:
                                                                //**********************************************//
                                                                //****Verificacion de Codigo De Eleccion********//
                                                                //**********************************************//
                                                                System.out.println("SISTEMA DE VOTACIONES");
                                                                System.out.println("-Registro de Candidato-");
                                                                System.out.println("Ingrese el Codigo de Eleccion");
                                                                scan.nextLine();
                                                                String codigoEleccion = scan.nextLine();
                                                                try {
                                                                    FileReader x = new FileReader(eleccion);
                                                                    BufferedReader xl = new BufferedReader(x);
                                                                    String leyenRegCandidato = "";
                                                                    while ((leyenRegCandidato = xl.readLine()) != null) {
                                                                        String[] lineas1 = leyenRegCandidato.split("\\|");
                                                                        if (lineas1[0].compareTo(codigoEleccion) == 0) {
                                                                            System.out.println(lineas1[0] + " = " + lineas1[1]);
                                                                            //**********************************************//
                                                                            //***********Registro de Candidato**************//
                                                                            //**********************************************//
                                                                            System.out.println("1. Registrarse como Presidente.");
                                                                            System.out.println("2. Registrarse como Diputado.");
                                                                            System.out.println("3. Registrarse como Alcalde");
                                                                            int xC = scan.nextInt();
                                                                            String tipoCandidato = scan.nextLine();
                                                                            while (xC < 4) {
                                                                                if (xC == 1) {
                                                                                    tipoCandidato = "Presidente.";
                                                                                    xC = 5;
                                                                                } else if (xC == 2) {
                                                                                    tipoCandidato = "Diputado";
                                                                                    xC = 5;
                                                                                } else if (xC == 3) {
                                                                                    tipoCandidato = "Alcalde";
                                                                                    xC = 5;
                                                                                } else {
                                                                                    System.out.println("Opcion Incorrecta Vuelva a Intentarlo");
                                                                                }
                                                                            }

                                                                            if (!candidato.exists()) {
                                                                                try {
                                                                                    candidato.createNewFile();
                                                                                    System.out.println("Registrarse como " + tipoCandidato);
                                                                                    System.out.println("Ingrese Nombre/s:");

                                                                                    nombre = scan.nextLine();
                                                                                    System.out.println("Ingrese Apellido/s");
                                                                                    apellido = scan.nextLine();
                                                                                    System.out.println("Ingrese No DPI:");
                                                                                    cui = scan.nextInt();
                                                                                    System.out.println("Ingrese Su Email:");
                                                                                    scan.nextLine();
                                                                                    email = scan.nextLine();
                                                                                    System.out.println("Ingrese una Contraseña");
                                                                                    pass = scan.nextLine();
                                                                                    System.out.println("Ingrese Formacion Academica:");
                                                                                    formAcademica = scan.nextLine();
                                                                                    System.out.println("Ingrese Experiencia Profesional:");
                                                                                    experienciaProfesional = scan.nextLine();

                                                                                    escribir = new FileWriter(candidato);
                                                                                    linea = new PrintWriter(escribir);
                                                                                    linea.print(cui + "|" + lineas1[0] + "|" + nombre + "|" + apellido + "|" + email + "|" + "|" + pass + "|" + formAcademica + "|" + experienciaProfesional + "|" + tipoCandidato + "|habilitado\n");
                                                                                    escribir.close();
                                                                                    linea.close();
                                                                                } catch (IOException ex) {

                                                                                }
                                                                            } else {
                                                                                try {
                                                                                    System.out.println("Ingrese Nombre/s:");
                                                                                    nombre = scan.nextLine();
                                                                                    System.out.println("Ingrese Apellido/s");
                                                                                    apellido = scan.nextLine();
                                                                                    System.out.println("Ingrese No DPI:");
                                                                                    cui = scan.nextInt();
                                                                                    System.out.println("Ingrese Su Email:");
                                                                                    scan.nextLine();
                                                                                    email = scan.nextLine();
                                                                                    System.out.println("Ingrese una Contraseña");
                                                                                    pass = scan.nextLine();
                                                                                    System.out.println("Ingrese Formacion Academica:");
                                                                                    formAcademica = scan.nextLine();
                                                                                    System.out.println("Ingrese Experiencia Profesional:");
                                                                                    experienciaProfesional = scan.nextLine();
                                                                                    escribir = new FileWriter(candidato);
                                                                                    linea = new PrintWriter(escribir);
                                                                                    linea.print(cui + "|" + lineas1[0] + "|" + nombre + "|" + apellido + "|" + email + "|" + "|" + pass + "|" + formAcademica + "|" + experienciaProfesional + "|" + tipoCandidato + "|habilitado\n");
                                                                                    escribir.close();
                                                                                    linea.close();
                                                                                    System.out.println("Registro Exitoso");
                                                                                } catch (IOException ex) {

                                                                                }
                                                                            }
                                                                        }

                                                                    }
                                                                    xl.close();
                                                                } catch (IOException ex) {

                                                                }

                                                                break;
                                                            case 2:
                                                                //**************************************//
                                                                //*********Modificar Candidatos*********//
                                                                //*************************************//
                                                                int ciclo = 0;
                                                                while (ciclo == 0) {
                                                                    System.out.println("SISTEMA DE VOTACIONES");
                                                                    System.out.println("Modificar Datos de Candidato");
                                                                    System.out.println("Ingrese Contraseña del (sistema o Administrador) para continuar.");
                                                                    pass = scan.nextLine();

                                                                    int ciclo2 = 0;
                                                                    while (ciclo2 == 0) {
                                                                        int ver = 0;
                                                                        scan.nextLine();
                                                                        String buscar = "";

                                                                        if (ver == 0) {
                                                                            System.out.println("Ingrese El No. DPI del usuario a modificar");
                                                                            buscar = scan.nextLine();
                                                                        } else {

                                                                        }
                                                                        try {
                                                                            FileReader leerArchivo = new FileReader(candidato);
                                                                            BufferedReader iniciarLectura = new BufferedReader(leerArchivo);

                                                                            File fc = new File("temp.txt");
                                                                            FileWriter escribirEnArchivo = new FileWriter(fc);
                                                                            BufferedWriter escribiendo = new BufferedWriter(escribirEnArchivo);

                                                                            String lineas = "";
                                                                            String nos = "";
                                                                            int x = 0;
                                                                            while ((lineas = iniciarLectura.readLine()) != null) {
                                                                                String[] datos = lineas.split("\\|");
                                                                                nos = datos[0];

                                                                                if (datos[0].compareTo(buscar) == 0) {
                                                                                    String[] listasss = lineas.split("\\|", -1);

                                                                                    System.out.println("OPCIONES DISPONIBLES");
                                                                                    System.out.println("1. Modificar Nombre:");
                                                                                    System.out.println("2. Modificar Apellidos:");
                                                                                    System.out.println("3. Modificar CUI");
                                                                                    System.out.println("4. Modificar Email:");
                                                                                    System.out.println("5. Modificar Contraseña");
                                                                                    System.out.println("6. Modificar Formacion Academica");
                                                                                    System.out.println("7. Modificar Experiencia Profesional");
                                                                                    System.out.println("Ingrese una Opcion:");
                                                                                    int z = scan.nextInt();
                                                                                    if (z == 1) {
                                                                                        System.out.println("Ingrese el nuevo Nombre/s:");

                                                                                    } else if (z == 2) {
                                                                                        System.out.println("Ingrese el nuevo Apellido/s:");

                                                                                    } else if (z == 3) {
                                                                                        System.out.println("Ingrese el nuevo CUI:");

                                                                                    } else if (z == 4) {
                                                                                        System.out.println("Ingrese el nuevo Email:");

                                                                                    } else if (z == 5) {
                                                                                        System.out.println("Ingrese la nueva contraseña");
                                                                                    } else if (z == 6) {
                                                                                        System.out.println("Ingrese Formacion Academica:");

                                                                                    } else if (z == 7) {
                                                                                        System.out.println("Ingrese Experiencia Profesional:");

                                                                                    }

                                                                                    scan.nextLine();
                                                                                    datoModificar = scan.nextLine();

                                                                                    for (int m = 0; m < listasss.length; m++) {
                                                                                        listasss[z] = datoModificar;
                                                                                        //System.out.println(listasss[m]);

                                                                                    }

                                                                                    lineas = String.join("|", listasss);
                                                                                    //System.out.println("conversion de array " + lineas);
                                                                                    x = 10;
                                                                                }

                                                                                escribiendo.write(lineas + "\n");

                                                                            }
                                                                            if (nos != buscar) {
                                                                                if (x == 10) {
                                                                                    System.out.println("Cambio Exitoso");
                                                                                } else {
                                                                                    System.out.println("No. DPI No Registrado");
                                                                                }
                                                                            }
                                                                            escribiendo.close();
                                                                            iniciarLectura.close();

                                                                            Files.move(fc.toPath(), datosAdmin.toPath(), REPLACE_EXISTING);
                                                                        } catch (FileNotFoundException ex) {
                                                                            Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                                                        } catch (IOException ex) {
                                                                            Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                                                        }
                                                                        int cic = 0;
                                                                        while (cic == 0) {
                                                                            System.out.println("1. Modificar Otro Usuario");
                                                                            System.out.println("2. Modificar Nuevo Dato del Usuario");
                                                                            System.out.println("3. Regresar Menu Principal");
                                                                            System.out.println("4. Salir");
                                                                            int opcionModificar = scan.nextInt();
                                                                            switch (opcionModificar) {
                                                                                case 1:
                                                                                    cic = 2;
                                                                                    break;
                                                                                case 2:
                                                                                    ver = 2;
                                                                                    cic = 2;
                                                                                    break;
                                                                                case 3:
                                                                                    ciclo = 2;
                                                                                    ciclo2 = 2;
                                                                                    ver = 0;
                                                                                    cic = 2;
                                                                                    break;
                                                                                case 4:
                                                                                    ciclo = 2;
                                                                                    ciclo2 = 2;
                                                                                    ciclo = 2;
                                                                                    ver = 0;
                                                                                    cic = 2;
                                                                                    i = 5;
                                                                                    break;
                                                                                default:
                                                                                    System.out.println("Opcion Incorrecta");
                                                                                    break;
                                                                            }
                                                                        }

                                                                    }

                                                                }
                                                                break;
                                                            case 3:
                                                                //**************************************//
                                                                //*********Eliminar Candidatos*********//
                                                                //*************************************//

                                                                break;
                                                            case 4:
                                                                w = 5;
                                                                break;
                                                            case 5:
                                                                w = 5;
                                                                p = 5;
                                                                o = 5;
                                                                i = 5;
                                                                break;
                                                            default:
                                                                break;
                                                        }

                                                        //
                                                        break;
                                                    case 3:
                                                        System.out.println("SISTEMA DE VOTACIONES");
                                                        System.out.println("Configurar Opciones de Eleccion");
                                                    case 4:
                                                        w = 5;
                                                        p = 5;
                                                        break;
                                                    case 5:
                                                        w = 5;
                                                        p = 5;
                                                        o = 5;
                                                        i = 5;
                                                        break;
                                                    default:
                                                        System.out.println("Opcion Incorrecta");
                                                        System.out.println("Ingrese de nuevo una Opcion");
                                                        opAdm = scan.nextInt();
                                                        break;
                                                }
                                            }

                                        }

                                    }
                                    int x = 0;
                                    if (leyendoDato == null) {
                                        if (x == 0) {
                                            System.out.println("Usuario no Registrado.");
                                        }
                                    }

                                }
                                br.close();
                            } catch (IOException ex) {

                            }

                            break;
//******************************************1.INICIAR SESION********************************************************//  
//*************************************SUB MENU REGISTRADOR DE VOTANTES***************************************************//
                            case 2:
                                System.out.println("Iniciar Sesion - Registrador de votantes");
                                System.out.println("Ingrese No. DPI");
                                cui = scan.nextLong();
                                System.out.println("Ingrese Contraseña");
                                scan.nextLine();
                                pass = scan.nextLine();
                                p = 0;
                                while (p == 0) {
                                    System.out.println("SISTEMA DE VOTACIONES");
                                    System.out.println("Registro de Votantes");
                                    System.out.println("Bienvenido");
                                    System.out.println("OPCIONES DISPONIBLES:");
                                    System.out.println("1. Registrar Votante.");
                                    System.out.println("2. Modificar Datos de Votante.");
                                    System.out.println("3. Reiniciar Contraseña de Votante.");
                                    System.out.println("4. Registrar Fallecimineto de Votante.");
                                    System.out.println("5. Regresar.");
                                    System.out.println("6. Salir.");

                                    opcionAdmin = scan.nextInt();

                                    switch (opcionAdmin) {
                                        case 1:
                                            System.out.println("SISTEMA DE VOTACIONES");
                                            System.out.println("Registrar Nuevo Votante");
                                            System.out.println("Ingrese los siguientes Datos:");
                                            System.out.println("Ingrese Nombre/s (Completo):");
                                            scan.nextLine();
                                            nombre = scan.nextLine();
                                            System.out.println("Ingrese Apellido/s (Completo):");
                                            apellido = scan.nextLine();
                                            System.out.println("Ingrese CUI:");
                                            cui = scan.nextLong();
                                            System.out.println("Ingrese sexo:");
                                            System.out.println("1. Hombre.");
                                            System.out.println("2. Mujer.");
                                            int op = scan.nextInt();
                                            String sexo = "";
                                            int siclo = 0;
                                            while (siclo == 0) {
                                                System.out.println(sexo);
                                                if (op == 1) {
                                                    sexo = "hombre";
                                                    siclo = 2;
                                                } else if (op == 2) {
                                                    sexo = "mujer";
                                                    siclo = 2;
                                                } else {
                                                    System.out.println("Opcion Incorrecta");
                                                    System.out.println("1. Hombre.");
                                                    System.out.println("2. Mujer.");
                                                    op = scan.nextInt();

                                                }
                                            }
                                            System.out.println("Ingrese Fecha de Nacimiento:");
                                            System.out.println("Ingrese Dia:");
                                            int dia = scan.nextInt();
                                            System.out.println("Ingrese Mes:");
                                            int mes = scan.nextInt();
                                            System.out.println("Ingrese Año:");
                                            int anio = scan.nextInt();
                                            scan.nextLine();
                                            System.out.println("Ingrese Direccion de Residencia:");
                                            direccion = scan.nextLine();
                                            System.out.println("Ingrese Departamento de Residencia:");
                                            departamento = scan.nextLine();
                                            System.out.println("Ingrese Municipio de Residencia:");
                                            municipio = scan.nextLine();
                                            System.out.println("Ingrese un Correo Electronico:");
                                            email = scan.nextLine();

                                            long codigoEleccion = (long) (Math.random() * 10000000 + 1);
                                            String passGenerico = codigoEleccion + "sdf5sdfd";

                                            FileWriter fWescribir;
                                            PrintWriter pWescribir;

                                            if (!datosVotantes.exists()) {
                                                try {
                                                    datosVotantes.createNewFile();
                                                    fWescribir = new FileWriter(datosVotantes, true);
                                                    pWescribir = new PrintWriter(fWescribir);

                                                    pWescribir.print(nombre + "|");
                                                    pWescribir.print(apellido + "|");
                                                    pWescribir.print(cui + "|");
                                                    pWescribir.print(sexo + "|");
                                                    pWescribir.print(dia + "|" + mes + "|" + anio + "|");
                                                    pWescribir.print(direccion + "|");
                                                    pWescribir.print(departamento + "|");
                                                    pWescribir.print(municipio + "|");
                                                    pWescribir.print(email + "|");
                                                    pWescribir.print(passGenerico + "|");
                                                    pWescribir.print("habilitado");
                                                    pWescribir.print("\n");

                                                    fWescribir.close();
                                                    pWescribir.close();
                                                    System.out.println("Registro Exitoso.");
                                                    System.out.println("Datos de Usuario:");
                                                    System.out.println("Email: " + email);
                                                    System.out.println("Contraseña de Usuario: " + passGenerico);

                                                } catch (IOException ex) {

                                                }
                                            } else {
                                                fWescribir = new FileWriter(datosVotantes, true);
                                                pWescribir = new PrintWriter(fWescribir);

                                                pWescribir.print(cui + "|");
                                                pWescribir.print(nombre + "|");
                                                pWescribir.print(apellido + "|");
                                                pWescribir.print(sexo + "|");
                                                pWescribir.print(dia + "|" + mes + "|" + anio + "|");
                                                pWescribir.print(direccion + "|");
                                                pWescribir.print(departamento + "|");
                                                pWescribir.print(municipio + "|");
                                                pWescribir.print(email + "|");
                                                pWescribir.print(passGenerico + "|");
                                                pWescribir.print("habilitado");
                                                pWescribir.print("\n");

                                                fWescribir.close();
                                                pWescribir.close();

                                                System.out.println("Registro Exitoso.");
                                                System.out.println("Datos de Usuario:");
                                                System.out.println("Email: " + email);
                                                System.out.println("Contraseña de Usuario: " + passGenerico);
                                            }

                                            p = 2;

                                            break;
                                        case 2:
                                            int ciclo2 = 0;
                                            while (ciclo2 == 0) {
                                                int ver = 0;
                                                scan.nextLine();
                                                String buscar = "";

                                                if (ver == 0) {
                                                    System.out.println("Ingrese El No. DPI del usuario a modificar");
                                                    buscar = scan.nextLine();
                                                } else {

                                                }
                                                try {
                                                    FileReader leerArchivo = new FileReader(datosVotantes);
                                                    BufferedReader iniciarLectura = new BufferedReader(leerArchivo);

                                                    File fc = new File("tempVotantes.txt");
                                                    FileWriter escribirEnArchivo = new FileWriter(fc);
                                                    BufferedWriter escribiendo = new BufferedWriter(escribirEnArchivo);

                                                    String lineas = "";
                                                    String nos = "";
                                                    int x = 0;
                                                    while ((lineas = iniciarLectura.readLine()) != null) {
                                                        String[] datos = lineas.split("\\|");
                                                        nos = datos[3];

                                                        if (datos[3].compareTo(buscar) == 0) {
                                                            String[] listasss = lineas.split("\\|", -1);

                                                            System.out.println("OPCIONES DISPONIBLES");
                                                            System.out.println("1. Cambiar Nombre:");
                                                            System.out.println("2. Cambiar Apellidos:");
                                                            System.out.println("3. Cambiar Sexo:");
                                                            System.out.println("4. Cambiar Fecha de nacimiento:");
                                                            System.out.println("5. Cambiar Direccion:");
                                                            System.out.println("6. Cambiar Departamento:");
                                                            System.out.println("7. Cambiar Municipio:");
                                                            System.out.println("8. Cambiar Email:");
                                                            System.out.println("9. Cambiar Contraseña:");
                                                            System.out.println("Ingrese una Opcion:");
                                                            int z = scan.nextInt();
                                                            switch (z) {
                                                                case 1:
                                                                    System.out.println("Ingrese el nuevo Nombre/s:");
                                                                    break;
                                                                case 2:
                                                                    System.out.println("Ingrese el nuevo Apellido/s:");
                                                                    break;
                                                                case 3:
                                                                    System.out.println("Elegir sexo:");
                                                                    break;
                                                                case 4:
                                                                    System.out.println("Ingrese Fecha de nacimiento:");
                                                                    break;
                                                                case 5:
                                                                    System.out.println("Ingrese la nueva direccion:");

                                                                    break;
                                                                case 6:
                                                                    System.out.println("Ingrese Departamento:");

                                                                    break;
                                                                case 7:
                                                                    System.out.println("Ingrese Municipio:");
                                                                    break;
                                                                case 8:
                                                                    System.out.println("Ingrese el nuevo Email:");
                                                                    break;
                                                                case 9:
                                                                    System.out.println("Ingrese la nueva Contraseña:");
                                                                    break;
                                                                default:
                                                                    break;
                                                            }

                                                            scan.nextLine();
                                                            datoModificar = scan.nextLine();

                                                            for (int m = 0; m < listasss.length; m++) {
                                                                listasss[z] = datoModificar;
                                                                //System.out.println(listasss[m]);

                                                            }

                                                            lineas = String.join("|", listasss);
                                                            //System.out.println("conversion de array " + lineas);
                                                            x = 10;
                                                        }

                                                        escribiendo.write(lineas + "\n");

                                                    }
                                                    if (nos != buscar) {
                                                        if (x == 10) {
                                                            System.out.println("Cambio Exitoso");
                                                        } else {
                                                            System.out.println("No. DPI No Registrado");
                                                        }
                                                    }
                                                    escribiendo.close();
                                                    iniciarLectura.close();

                                                    Files.move(fc.toPath(), datosAdmin.toPath(), REPLACE_EXISTING);
                                                } catch (FileNotFoundException ex) {
                                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                                } catch (IOException ex) {
                                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                                //agregar while con  opciones de retorno

                                            }
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            break;
                                        case 5:
                                            p = 2;
                                            o = 2;
                                            i = 2;
                                            break;
                                        case 6:
                                            break;

                                        default:
                                            break;
                                    };
                                }
                                break;
//*************************************1.INICIAR SESION********************************************************//  
//*************************************SUB MENU VOTANTE***************************************************//
                            case 3:
                                System.out.println("SISTEMA DE VOTACIONES");
                                System.out.println("Iniciar sesion como Votante");
                                System.out.println("Ingrese Correo Electronico:");
                                scan.nextLine();
                                email = scan.nextLine();
                                System.out.println("Ingrese Contraseña:");
                                pass = scan.nextLine();

                                try {
                                    FileReader leer = new FileReader(datosVotantes);
                                    BufferedReader br = new BufferedReader(leer);
                                    String leyendoDato = "";

                                    while ((leyendoDato = br.readLine()) != null) {
                                        String[] dat = leyendoDato.split("\\|", -1);

                                        if (dat[10].compareTo(email) == 0 && dat[11].compareTo(pass) == 0) {
                                            if (dat[12].compareTo("habilitado") == 0) {
                                                System.out.println("Bienvenido " + dat[1]);
                                                System.out.println("INGRESE No. CUI");
                                                String dpi = scan.nextLine();

                                                FileReader verifDpi = new FileReader(datosVotantes);
                                                BufferedReader br2 = new BufferedReader(verifDpi);
                                                String leyendoDato2 = "";
                                                while ((leyendoDato2 = br2.readLine()) != null) {
                                                    if (dat[0].compareTo(dpi) == 0);
                                                    System.out.println("Elecciones Diponibles.");

                                                    FileReader elecci = new FileReader(eleccion);
                                                    BufferedReader br3 = new BufferedReader(elecci);
                                                    String leyendoDato3 = "";

                                                    while ((leyendoDato3 = br3.readLine()) != null) {
                                                        String[] elecciones = leyendoDato3.split("\\|");
                                                        System.out.println("1. Codigo Eleccion: " + elecciones[0] + " " + elecciones[1]);
                                                        System.out.println("Ingrese el Codigo de Eleccion. ");
                                                        System.out.println("Para realizar su voto.");
                                                        String voto = scan.nextLine();
//*********************************************************REALIZANDO VOTO***************************************//////////                                         
                                                        FileReader lecturadeCodigo = new FileReader(eleccion);
                                                        BufferedReader br4 = new BufferedReader(lecturadeCodigo);

                                                        String leyendoDato4 = "";
                                                        while ((leyendoDato4 = br4.readLine()) != null) {
                                                            String[] codigo = leyendoDato4.split("\\|");
                                                            if (codigo[0].compareTo(voto) == 0) {
                                                                votos = new File(voto + ".txt");
                                                                try {
                                                                    if (!votos.exists()) {
                                                                        votos.createNewFile();
                                                                        escribir = new FileWriter(votos, true);
                                                                        linea = new PrintWriter(escribir);
                                                                        linea.print(dpi + "|" + dat[1] + "|" + dat[2] + "|" + dat[3] + "|" + dat[4] + "|" + dat[5] + "|" + dat[6] + "|" + dat[7] + "|" + dat[8] + "|" + dat[9] + "|" + dat[10] + "|" + "1" + "\n");
                                                                        escribir.close();
                                                                        linea.close();
                                                                        System.out.println("VOTO REALIZADO CON EXITO.");
                                                                    } else {
                                                                        escribir = new FileWriter(votos, true);
                                                                        linea = new PrintWriter(escribir);
                                                                        linea.print(dpi + "|" + dat[1] + "|" + dat[2] + "|" + dat[3] + "|" + dat[4] + "|" + dat[5] + "|" + dat[6] + "|" + dat[7] + "|" + dat[8] + "|" + dat[9] + "|" + dat[10] + "|" + "1" + "\n");

                                                                        escribir.close();
                                                                        linea.close();
                                                                        System.out.println("VOTO REALIZADO CON EXITO.");

                                                                    }
                                                                    escribir.close();
                                                                    linea.close();
                                                                } catch (IOException ex) {

                                                                }
                                                            }
                                                        };

                                                    }
                                                }
                                            } else {
                                                System.out.println("Usuario Desabilitado");
                                            };
                                        }

                                    }

                                    br.close();

                                } catch (IOException ex) {

                                }

                                break;
//*************************************1.INICIAR SESION********************************************************//  
//*************************************SUB MENU AUDITOR***************************************************//
                            case 4:
                                System.out.println("Iniciar Sesion - Auditor");
                                System.out.println("Ingrese No. DPI");
                                scan.nextLine();
                                String dpi = scan.nextLine();
                                System.out.println("Ingrese Contraseña");
                                pass = scan.nextLine();
                                try {
                                    FileReader leerArchivo = new FileReader(datosAuditor);
                                    BufferedReader iniciarLectura = new BufferedReader(leerArchivo);
                                    String lineas = "";
                                    String nos = "";
                                    int x = 0;
                                    while ((lineas = iniciarLectura.readLine()) != null) {
                                        String[] datos = lineas.split("\\|");
                                        nos = datos[0];

                                        if (datos[0].compareTo(dpi) == 0 && datos[5].compareTo(pass)==0) {
                                            String[] listasss = lineas.split("\\|", -1);
                                            System.out.println("1. Ver Elecciones.");
                                            System.out.println("2. Ver total de Votos.");
                                            System.out.println("3. Regresar.");
                                            System.out.println("4. salir.");
                                            int opA = scan.nextInt();
                                            switch(opA){
                                                case 1:
                                                    
                                                    break;
                                                case 2:
                                                    break;
                                                case 3:
                                                    break;
                                                default:
                                                    break;
                                                    
                                            
                                            };
                                            
                                            x = 10;// variable para corroborar si se realizo un cambio o no
                                        }

                                        

                                    }
                                    if (nos != dpi) {
                                        if (x == 10) {
                                            System.out.println("Cambio Exitoso");
                                        } else {
                                            System.out.println("Cambio no realizado");
                                        }
                                    }
                                    
                                    iniciarLectura.close();

                                    
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                break;

                            case 5:
                                // regresar al menu anterior
                                o = 2;
                                opcion1 = 0;
                                break;
                            case 6:
                                // salir del sistema
                                o = 2;
                                i = 2;
                                break;
                            default:
                                System.out.println("Opcion Incorrecta");
                                break;
                        }
                    }
                    break;
//***************************************1.MENU DE CREACION DE USUARIO********************************************************//                     

                case 2:
                    System.out.println("SISTEMA DE VOTACIONES");
                    System.out.println("Registro de Usuarios");
                    System.out.println("1. Agregar Usuario");
                    System.out.println("2. Restablecer Contraseña");
                    System.out.println("3. Modificar Usuario");
                    System.out.println("4. Desabilitar Usuario");
                    System.out.println("5. Regresar");
                    System.out.println("6. Salir");
                    int opcR = scan.nextInt();

                    if (opcR == 5) {
                        opcion1 = 2;
                    } else if (opcR == 6) {
                        i = 6;
                    }
                    ;

                    // ciclo para registro de Usuarios;                    
                    int c = 1;
                    while (c < 2) {
                        switch (opcR) {
                            //******************************************1.CREACION DE USUARIO********************************************************//                     
//*****************************************SUB_MENU REGISTRO DE VOTANTES***********************************************//
                            case 1:
                                System.out.println("SISTEMA DE VOTACIONES");
                                System.out.println("Tipo de Usuario");
                                System.out.println("1. Administrador");
                                System.out.println("2. Registrador de Votantes");
                                System.out.println("3. Auditor");
                                System.out.println("4. Regresar");
                                System.out.println("5. Salir.");
                                int opcT = scan.nextInt();

                                if (opcT == 4) {
                                    opcion1 = 2;
                                    c = 2;
                                } else if (opcT == 5) {
                                    opcion1 = 3;
                                    c = 2;
                                } else {

                                }
                                switch (opcT) {
                                    //******************************************1.CREACION DE USUARIO********************************************************//                     
//*****************************************SUB_MENU REGISTRO DE VOTANTES***********************************************//
                                    //*****CREACION DE CUENTA ADMINISTRADOR****//
                                    case 1:

                                        System.out.println("Ingrese los datos para la Cuenta Administrador");
                                        scan.nextLine();
                                        System.out.println("Ingrese Nombres:");
                                        nombre = scan.nextLine();
                                        System.out.println("Ingrese Apellidos");
                                        apellido = scan.nextLine();
                                        System.out.println("Ingrese No DPI:");
                                        cui = scan.nextInt();
                                        System.out.println("Ingrese Su Email:");
                                        scan.nextLine();
                                        email = scan.nextLine();
                                        System.out.println("Ingrese Nombre Usuario:");
                                        usuario = scan.nextLine();
                                        System.out.println("Ingrese una contraseña:");
                                        pass = scan.nextLine();

                                        if (!datosAdmin.exists()) {
                                            try {
                                                datosAdmin.createNewFile();
                                                escribir = new FileWriter(datosAdmin, true);
                                                linea = new PrintWriter(escribir);
                                                linea.print(cui + "|");
                                                linea.print(nombre + "|");
                                                linea.print(apellido + "|");
                                                linea.print(email + "|");
                                                linea.print(usuario + "|");
                                                linea.print(pass + "|");
                                                linea.print("habilitado");
                                                linea.print("\n");
                                                escribir.close();
                                                linea.close();
                                            } catch (IOException ex) {
                                                Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } else {
                                            try {
                                                escribir = new FileWriter(datosAdmin, true);
                                                linea = new PrintWriter(escribir);
                                                linea.print(cui + "|");
                                                linea.print(nombre + "|");
                                                linea.print(apellido + "|");
                                                linea.print(email + "|");
                                                linea.print(usuario + "|");
                                                linea.print(pass + "|");
                                                linea.print("habilitado");
                                                linea.print("\n");
                                                escribir.close();
                                                linea.close();
                                            } catch (IOException ex) {
                                            }
                                        }
                                        ;
                                        System.out.println("Usuario Creado Exitosamente");
                                        break;
//****************************************CREACION DE CUENTA REGISTRADOR DE VOTANTES**********************************************//
                                    case 2:
                                        System.out.println("Ingrese los datos para la cuenta de Registrador de Votantes");
                                        System.out.println("Ingrese su nombre Completo");
                                        scan.nextLine();//limpiar buffer
                                        System.out.println("Ingrese Nombres:");
                                        nombre = scan.nextLine();
                                        System.out.println("Ingrese Apellidos");
                                        apellido = scan.nextLine();
                                        System.out.println("Ingrese No DPI:");
                                        cui = scan.nextLong();
                                        System.out.println("Ingrese Su Email:");
                                        email = scan.nextLine();
                                        System.out.println("Ingrese Nombre Usuario:");
                                        usuario = scan.nextLine();
                                        System.out.println("Ingrese una contraseña:");
                                        pass = scan.nextLine();

                                        if (!datosRegVotantes.exists()) {
                                            try {
                                                datosRegVotantes.createNewFile();
                                                escribir = new FileWriter(datosRegVotantes, true);
                                                linea = new PrintWriter(escribir);
                                                linea.print(cui + "|");
                                                linea.print(nombre + "|");
                                                linea.print(apellido + "|");
                                                linea.print(email + "|");
                                                linea.print(usuario + "|");
                                                linea.print(pass + "|");
                                                linea.print("habilitado");
                                                linea.print("\n");
                                                escribir.close();
                                                linea.close();
                                            } catch (IOException ex) {
                                                Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } else {
                                            try {
                                                escribir = new FileWriter(datosRegVotantes, true);
                                                linea = new PrintWriter(escribir);
                                                linea.print(cui + "|");
                                                linea.print(nombre + "|");
                                                linea.print(apellido + "|");
                                                linea.print(email + "|");
                                                linea.print(usuario + "|");
                                                linea.print(pass + "|");
                                                linea.print("habilitado");
                                                linea.print("\n");
                                                escribir.close();
                                                linea.close();
                                            } catch (IOException ex) {
                                            }
                                        }
                                        ;
                                        System.out.println("Usuario Creado Exitosamente");
                                        break;
                                    case 3:
//********************************************CREACION DE CUENTA DE AUDITOR********************************///////////////////
                                        System.out.println("Ingrese los datos para la Cuenta Auditor");
                                        System.out.println("Ingrese Nombre Completo:");
                                        scan.nextLine();
                                        System.out.println("Ingrese Nombres:");
                                        nombre = scan.nextLine();
                                        System.out.println("Ingrese Apellidos");
                                        apellido = scan.nextLine();
                                        System.out.println("Ingrese No DPI:");
                                        cui = scan.nextLong();
                                        System.out.println("Ingrese Su Email:");
                                        email = scan.nextLine();
                                        System.out.println("Ingrese Nombre Usuario:");
                                        usuario = scan.nextLine();
                                        System.out.println("Ingrese una contraseña:");
                                        pass = scan.nextLine();

                                        if (!datosAuditor.exists()) {
                                            try {
                                                datosAuditor.createNewFile();
                                                escribir = new FileWriter(datosAuditor, true);
                                                linea = new PrintWriter(escribir);
                                                linea.print(cui + "|");
                                                linea.print(nombre + "|");
                                                linea.print(apellido + "|");
                                                linea.print(email + "|");
                                                linea.print(usuario + "|");
                                                linea.print(pass + "|");
                                                linea.print("habilitado");
                                                linea.print("\n");
                                                escribir.close();
                                                linea.close();
                                            } catch (IOException ex) {
                                                Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } else {
                                            try {
                                                escribir = new FileWriter(datosAuditor, true);
                                                linea = new PrintWriter(escribir);
                                                linea.print(cui + "|");
                                                linea.print(nombre + "|");
                                                linea.print(apellido + "|");
                                                linea.print(email + "|");
                                                linea.print(usuario + "|");
                                                linea.print(pass + "|");
                                                linea.print("habilitado");
                                                linea.print("\n");
                                                escribir.close();
                                                linea.close();
                                            } catch (IOException ex) {
                                            }
                                        }
                                        ;
                                        System.out.println("Usuario Creado Exitosamente");
                                        break;
                                    case 4:
                                        c = 2;
                                        opcion1 = 2;
                                        break;
                                    case 5:
                                        i = 2;
                                        break;
                                    default:
                                        break;
                                }
                                ;
                                break;// fin primer caso                            
                            case 2:
                                System.out.println("SISTEMA DE VOTACIONES");
                                System.out.println("Restablecer Contraseña");
                                System.out.println("Ingrese su Email");
                                email = scan.nextLine();

                                c = 2;
                                break;
                            //fin segundo caso
                            case 3:
                                System.out.println("SISTEMA DE VOTACIONES");
                                System.out.println("Modificar Usuario");
                                System.out.println("Ingrese su Email");
                                scan.nextLine();
                                email = scan.nextLine();
                                System.out.println("Ingrese Contraseña");
                                pass = scan.nextLine();
                                try {
                                    FileReader leer = new FileReader(datosVotantes);
                                    BufferedReader br = new BufferedReader(leer);
                                    String d = "";
                                    while ((d = br.readLine()) != null) {
                                        System.out.println(d);
                                    }
                                    br.close();
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                c = 2;
                                break;
                            //fin tercer caso
                            case 4:
                                System.out.println("SISTEMA DE VOTACIONES");
                                System.out.println("Desabilitar Usuario");
                                System.out.println("Ingrese su DPI");
                                System.out.println("Ingrese pass");
                                break;
                        }
                    } // cierre de switch y while
                    break;

//*****************************************MENU MODIFICAR USUARIO***********************************************//
                case 3:
                    int ciclo = 0;
                    while (ciclo == 0) {
                        System.out.println("SISTEMA DE VOTACIONES");
                        System.out.println("Modificar Datos de Usuario");
                        System.out.println("Ingrese Contraseña del (sistema o Administrador) para continuar.");
                        pass = scan.nextLine();

                        int ciclo2 = 0;
                        while (ciclo2 == 0) {
                            int ver = 0;
                            scan.nextLine();
                            String buscar = "";

                            if (ver == 0) {
                                System.out.println("Ingrese El No. DPI del usuario a modificar");
                                buscar = scan.nextLine();
                            } else {

                            }
                            try {
                                FileReader leerArchivo = new FileReader(datosAdmin);
                                BufferedReader iniciarLectura = new BufferedReader(leerArchivo);

                                File fc = new File("archivo_texto_copia.txt");
                                FileWriter escribirEnArchivo = new FileWriter(fc);
                                BufferedWriter escribiendo = new BufferedWriter(escribirEnArchivo);

                                String lineas = "";
                                String nos = "";
                                int x = 0;
                                while ((lineas = iniciarLectura.readLine()) != null) {
                                    String[] datos = lineas.split("\\|");
                                    nos = datos[3];

                                    if (datos[3].compareTo(buscar) == 0) {
                                        String[] listasss = lineas.split("\\|", -1);

                                        System.out.println("OPCIONES DISPONIBLES");
                                        System.out.println("1. Cambiar Nombre:");
                                        System.out.println("2. Cambiar Apellidos:");
                                        System.out.println("3. Cambiar Email:");
                                        System.out.println("4. Cambiar Nombre Usuario");
                                        System.out.println("5. Cambiar Contraseña:");
                                        System.out.println("Ingrese una Opcion:");
                                        int z = scan.nextInt();
                                        if (z == 1) {
                                            String opM = "Ingrese el nuevo Nombre/s:";
                                            System.out.println(opM);
                                        } else if (z == 2) {
                                            String opM = "Ingrese el nuevo Apellido/s:";
                                            System.out.println(opM);
                                        } else if (z == 3) {
                                            String opM = "Ingrese el nuevo Email/s:";
                                            System.out.println(opM);
                                        } else if (z == 4) {
                                            String opM = "Ingrese el nuevo Nombre de Usuario:";
                                            System.out.println(opM);
                                        } else if (z == 5) {
                                            String opM = "Ingrese la nueva Contraseña:";
                                            System.out.println(opM);
                                        }

                                        scan.nextLine();
                                        datoModificar = scan.nextLine();

                                        for (int m = 0; m < listasss.length; m++) {
                                            listasss[z] = datoModificar;
                                            //System.out.println(listasss[m]);

                                        }

                                        lineas = String.join("|", listasss);
                                        //System.out.println("conversion de array " + lineas);
                                        x = 10;
                                    }

                                    escribiendo.write(lineas + "\n");

                                }
                                if (nos != buscar) {
                                    if (x == 10) {
                                        System.out.println("Cambio Exitoso");
                                    } else {
                                        System.out.println("No. DPI No Registrado");
                                    }
                                }
                                escribiendo.close();
                                iniciarLectura.close();

                                Files.move(fc.toPath(), datosAdmin.toPath(), REPLACE_EXISTING);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            int cic = 0;
                            while (cic == 0) {
                                System.out.println("1. Modificar Otro Usuario");
                                System.out.println("2. Modificar Nuevo Dato del Usuario");
                                System.out.println("3. Regresar Menu Principal");
                                System.out.println("4. Salir");
                                int opcionModificar = scan.nextInt();
                                switch (opcionModificar) {
                                    case 1:
                                        cic = 2;
                                        break;
                                    case 2:
                                        ver = 2;
                                        cic = 2;
                                        break;
                                    case 3:
                                        ciclo = 2;
                                        ciclo2 = 2;
                                        ver = 0;
                                        cic = 2;
                                        break;
                                    case 4:
                                        ciclo = 2;
                                        ciclo2 = 2;
                                        ciclo = 2;
                                        ver = 0;
                                        cic = 2;
                                        i = 5;
                                        break;
                                    default:
                                        System.out.println("Opcion Incorrecta");
                                        break;
                                }
                            }

                        }

                    }
                    break;
//*****************************************MENU DESABILITAR USUARIO***********************************************//
                case 4:
                    int cc = 0;
                    while (cc == 0) {
                        System.out.println("SISTEMA DE VOTACIONES");
                        System.out.println("Desabilitar Usuario:");
                        System.out.println("Ingrese contraseña de Administrador");
                        pass = scan.nextLine();

                        int ciclo2 = 0;
                        while (ciclo2 == 0) {
                            int ver = 0;
                            scan.nextLine();
                            String buscar = "";
                            System.out.println("1. Habilitar/Deshabilitar (Usuario Registrador de Votantes).");
                            System.out.println("2. Habilitar/Deshabilitar (Usuario Votante).");
                            System.out.println("3. Habilitar/Deshabilitar (Usuario Auditor).");
                            int h = scan.nextInt();
                            System.out.println("Ingrese El No. CUI del usuario para Habilitar/deshabilitar");
                            buscar = scan.nextLine();
                            switch (h) {
                                case 1:
                                    try {
                                    FileReader leerArchivo = new FileReader(datosRegVotantes);
                                    BufferedReader iniciarLectura = new BufferedReader(leerArchivo);

                                    File fc = new File("archivo_texto_copia.txt");
                                    FileWriter escribirEnArchivo = new FileWriter(fc);
                                    BufferedWriter escribiendo = new BufferedWriter(escribirEnArchivo);

                                    String lineas = "";
                                    String nos = "";
                                    int x = 0;
                                    while ((lineas = iniciarLectura.readLine()) != null) {
                                        String[] datos = lineas.split("\\|");
                                        nos = datos[0];

                                        if (datos[0].compareTo(buscar) == 0) {
                                            String[] listasss = lineas.split("\\|", -1);

                                            System.out.println("OPCIONES DISPONIBLES");
                                            System.out.println("1. Habilitar");
                                            System.out.println("2. Deshabilitar");
                                            System.out.println("Ingrese una Opcion:");
                                            int jj = scan.nextInt();
                                            datoModificar = "";

                                            if (jj == 1) {
                                                datoModificar = "habilitado";

                                            } else if (jj == 2) {
                                                datoModificar = "deshabilitado";

                                            }

                                            for (int m = 0; m < listasss.length; m++) {
                                                listasss[7] = datoModificar;
                                                //System.out.println(listasss[m]);

                                            }

                                            lineas = String.join("|", listasss);
                                            //System.out.println("conversion de array " + lineas);
                                            x = 10;
                                        }

                                        escribiendo.write(lineas + "\n");

                                    }
                                    if (nos != buscar) {
                                        if (x == 10) {
                                            System.out.println("Cambio Exitoso");
                                        } else {
                                            System.out.println("Cambio no realizado");
                                        }
                                    }
                                    escribiendo.close();
                                    iniciarLectura.close();

                                    Files.move(fc.toPath(), datosRegVotantes.toPath(), REPLACE_EXISTING);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                                case 2:
                                    try {
                                    FileReader leerArchivo = new FileReader(datosVotantes);
                                    BufferedReader iniciarLectura = new BufferedReader(leerArchivo);

                                    File fc = new File("archivo_texto_copia.txt");
                                    FileWriter escribirEnArchivo = new FileWriter(fc);
                                    BufferedWriter escribiendo = new BufferedWriter(escribirEnArchivo);

                                    String lineas = "";
                                    String nos = "";
                                    int x = 0;
                                    while ((lineas = iniciarLectura.readLine()) != null) {
                                        String[] datos = lineas.split("\\|");
                                        nos = datos[0];

                                        if (datos[0].compareTo(buscar) == 0) {
                                            String[] listasss = lineas.split("\\|", -1);

                                            System.out.println("OPCIONES DISPONIBLES");
                                            System.out.println("1. Habilitar");
                                            System.out.println("2. Deshabilitar");
                                            System.out.println("Ingrese una Opcion:");
                                            int jj = scan.nextInt();
                                            datoModificar = "";

                                            if (jj == 1) {
                                                datoModificar = "habilitado";

                                            } else if (jj == 2) {
                                                datoModificar = "deshabilitado";

                                            }

                                            for (int m = 0; m < listasss.length; m++) {
                                                listasss[12] = datoModificar;
                                                //System.out.println(listasss[m]);

                                            }

                                            lineas = String.join("|", listasss);
                                            //System.out.println("conversion de array " + lineas);
                                            x = 10;
                                        }

                                        escribiendo.write(lineas + "\n");

                                    }
                                    if (nos != buscar) {
                                        if (x == 10) {
                                            System.out.println("Cambio Exitoso");
                                        } else {
                                            System.out.println("Cambio no realizado");
                                        }
                                    }
                                    escribiendo.close();
                                    iniciarLectura.close();

                                    Files.move(fc.toPath(), datosVotantes.toPath(), REPLACE_EXISTING);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                                case 3:
                                    try {
                                    FileReader leerArchivo = new FileReader(datosAuditor);
                                    BufferedReader iniciarLectura = new BufferedReader(leerArchivo);

                                    File fc = new File("archivo_texto_copia.txt");
                                    FileWriter escribirEnArchivo = new FileWriter(fc);
                                    BufferedWriter escribiendo = new BufferedWriter(escribirEnArchivo);

                                    String lineas = "";
                                    String nos = "";
                                    int x = 0;
                                    while ((lineas = iniciarLectura.readLine()) != null) {
                                        String[] datos = lineas.split("\\|");
                                        nos = datos[0];

                                        if (datos[0].compareTo(buscar) == 0) {
                                            String[] listasss = lineas.split("\\|", -1);

                                            System.out.println("OPCIONES DISPONIBLES");
                                            System.out.println("1. Habilitar");
                                            System.out.println("2. Deshabilitar");
                                            System.out.println("Ingrese una Opcion:");
                                            int jj = scan.nextInt();
                                            datoModificar = "";

                                            if (jj == 1) {
                                                datoModificar = "habilitado";

                                            } else if (jj == 2) {
                                                datoModificar = "deshabilitado";

                                            }

                                            for (int m = 0; m < listasss.length; m++) {
                                                listasss[7] = datoModificar;
                                                //System.out.println(listasss[m]);

                                            }

                                            lineas = String.join("|", listasss);
                                            //System.out.println("conversion de array " + lineas);
                                            x = 10;
                                        }

                                        escribiendo.write(lineas + "\n");

                                    }
                                    if (nos != buscar) {
                                        if (x == 10) {
                                            System.out.println("Cambio Exitoso");
                                        } else {
                                            System.out.println("Cambio no realizado");
                                        }
                                    }
                                    escribiendo.close();
                                    iniciarLectura.close();

                                    Files.move(fc.toPath(), datosAuditor.toPath(), REPLACE_EXISTING);
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;

                                default:
                                    break;

                            };

                        }

                    }

                    break;
                case 5:
                    i = 2;
                    break;

                default:
                    System.out.println("Opcion Incorrecta");
                    opcion1 = 0;
                    break;
            }// cierre de switch
        } //cierre de switch y while
        System.out.println(
                "Programa Finalizado");

    }
}
