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
import java.util.Arrays;

public class SistemaDeVotaciones {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de Votaciones");
        System.out.println("Ingrese una contrasena para el Sistema");

        //declaracion de variables
        String nombre, apellido, usuario, pass, email, estado, datoModificar, direccion, departamento, municipio;
        int l, opc;
        long cui;

        File archivo;
        File datosAdmin;
        File datosRegVotantes;
        File datosAuditor;
        File datosVotantes;

        FileWriter escribir;
        PrintWriter linea;

        archivo = new File("passSistema.txt");
        datosAdmin = new File("datosAdmin.txt");
        datosVotantes = new File("datosVotantes.txt");

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
        int i = 1;
        while (i < 2) {
            System.out.println("Sistema de Votaciones");
            System.out.println("1. Iniciar Sesion.");
            System.out.println("2. Crear Usuario.");
            System.out.println("3. Modificar Usuario");
            System.out.println("4. Desabilitar Usuario");
            System.out.println("5. Salir.");
            if (opcion1 > 0) {
            } else {
                opcion1 = scan.nextInt();
            }
            switch (opcion1) {
                case 1:
                    int o = 0;
                    while (o < 1) {
                        System.out.println("Sistema de Votaciones");
                        System.out.println("Iniciar Sesion");
                        System.out.println("1. Administrador");
                        System.out.println("2. Registrador de Votantes");
                        System.out.println("3. Votante");
                        System.out.println("4. Auditor");
                        System.out.println("5. Regresar");
                        System.out.println("6. Salir");
                        System.out.println("Ingrese una opcion: ");
                        int p = 0; // restableciendo variable para no ejecutar los while amarrados a esta variable
                        int opcI = scan.nextInt();
                        switch (opcI) {
                            case 1:
                                System.out.println("Iniciar Sesion - Administrador");
                                System.out.println("Ingrese No. DPI");
                                scan.nextLine();
                                cui = scan.nextLong();
                                System.out.println("Ingrese Contraseña");
                                pass = scan.nextLine();
                                p = 0;
                                int opcionAdmin = 0;
                                while (p == 0) {

                                    System.out.println("Sistema de Votaciones");
                                    System.out.println("Administrador de Elecciones");
                                    System.out.println("Bienvenido Pepe");
                                    System.out.println("1. Gestionar Elecciones");
                                    System.out.println("2. Gestionar Candidatos");
                                    System.out.println("3. Configurar opciones de Eleccion");
                                    System.out.println("4. Regresar");
                                    System.out.println("5. Salir");

                                    if (opcionAdmin == 0) {
                                        opcionAdmin = scan.nextInt();
                                    }
                                    switch (opcionAdmin) {
                                        case 1:
                                            System.out.println("Sistema de Votaciones");
                                            System.out.println("Gestionar Elecciones");
                                            System.out.println("1. Crear Elecciones:");
                                            System.out.println("2. Regresar.");
                                            System.out.println("3. Salir del Sistema.");
                                            opc = scan.nextInt();
                                            switch(opc){
                                                case 1:
                                                    
                                                    break;
                                                case 2:
                                                    break;
                                                case 3:
                                                    break;
                                                default:
                                                    break;
                                                    
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Sistema de Votaciones");
                                            System.out.println("Gestionar Candidatos");
                                            break;
                                        case 3:
                                            System.out.println("Sistema de Votaciones");
                                            System.out.println("Configurar Opciones de Eleccion");
                                        case 4:
                                            p = 2;
                                            break;
                                        case 5:
                                            p = 2;
                                            o = 2;
                                            i = 2;
                                            break;
                                        default:
                                            System.out.println("Opcion Incorrecta");
                                            System.out.println("Ingrese de nuevo una Opcion");
                                            opcionAdmin = scan.nextInt();
                                            break;
                                    };
                                }

                                break;
                            case 2:
                                System.out.println("Iniciar Sesion - Registrador de votantes");
                                System.out.println("Ingrese No. DPI");
                                cui = scan.nextLong();
                                System.out.println("Ingrese Contraseña");
                                scan.nextLine();
                                pass = scan.nextLine();
                                p = 0;
                                while (p == 0) {
                                    System.out.println("Bienvenido nombre");
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
                                            System.out.println("Sistema de Votaciones");
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
                                            int sexo = scan.nextInt();
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

                                            FileWriter fWescribir;
                                            PrintWriter pWescribir;

                                            if (!datosVotantes.exists()) {
                                                try {
                                                    datosVotantes.createNewFile();
                                                    fWescribir = new FileWriter(datosVotantes, true);
                                                    pWescribir = new PrintWriter(fWescribir);

                                                    pWescribir.println(nombre + "|");
                                                    pWescribir.println(apellido + "|");
                                                    pWescribir.println(cui + "|");
                                                    pWescribir.println(sexo + "|");
                                                    pWescribir.println(dia + "/" + mes + "/" + anio + "|");
                                                    pWescribir.println(direccion + "|");
                                                    pWescribir.println(departamento + "|");
                                                    pWescribir.println(municipio + "|");
                                                    pWescribir.print("habilitado");
                                                    pWescribir.print("\n");

                                                    fWescribir.close();
                                                    pWescribir.close();

                                                } catch (IOException ex) {

                                                }
                                            } else {
                                                fWescribir = new FileWriter(datosVotantes, true);
                                                pWescribir = new PrintWriter(fWescribir);

                                                pWescribir.print(nombre + "|");
                                                pWescribir.print(apellido + "|");
                                                pWescribir.print(cui + "|");
                                                pWescribir.print(sexo + "|");
                                                pWescribir.print(dia + "/" + mes + "/" + anio + "|");
                                                pWescribir.print(direccion + "|");
                                                pWescribir.print(departamento + "|");
                                                pWescribir.print(municipio + "|");
                                                pWescribir.print("habilitado");
                                                pWescribir.print("\n");

                                                fWescribir.close();
                                                pWescribir.close();

                                            }
                                            System.out.println("Registro Exitoso.");
                                            p = 2;

                                            break;
                                        case 2:
                                            p = 2;
                                            o = 2;
                                            i = 2;
                                            break;
                                        default:
                                            break;
                                    };
                                }
                                break;
                            case 3:
                                System.out.println("Iniciar Sesion - Votante");
                                System.out.println("Ingreso al Sistema");
                                System.out.println("Ingrese Correo Electronico:");
                                scan.nextLine();
                                cui = scan.nextLong();
                                System.out.println("Ingrese Contraseña:");
                                pass = scan.nextLine();
                                System.out.println("Ingrese CUI:");
                                p = 0;
                                while (p == 0) {
                                    System.out.println("Sistema de Votaciones");
                                    System.out.println("Ejecucion de Eleccion");
                                    System.out.println("Bienvenido Pepe");
                                    System.out.println("1. Eleccion Presidente");
                                    System.out.println("2. Eleccion de Diputado");
                                    System.out.println("3. Eleccion de Alcalde");
                                    System.out.println("4. Regresar");
                                    System.out.println("5. Salir");

                                    opcionAdmin = scan.nextInt();

                                    switch (opcionAdmin) {
                                        case 1:
                                            System.out.println("Sistema de Votaciones");

                                            break;
                                        case 2:
                                            System.out.println("Sistema de Votaciones");
                                            break;
                                        case 3:
                                            System.out.println("Sistema de Votaciones");
                                            break;
                                        case 4:
                                            p = 2;

                                            break;
                                        case 5:
                                            p = 2;
                                            o = 2;
                                            i = 2;
                                            break;
                                        default:
                                            break;
                                    };
                                }
                                break;
                            case 4:
                                System.out.println("Iniciar Sesion - Auditor");
                                System.out.println("Ingrese No. DPI");
                                scan.nextLine();
                                cui = scan.nextLong();
                                System.out.println("Ingrese Contraseña");
                                pass = scan.nextLine();
                                p = 0;
                                while (p == 0) {
                                    System.out.println("Bienvenido Pepe");
                                    System.out.println("1. Ver Datos de Votantes");
                                    System.out.println("2. Regresar");
                                    System.out.println("3. Salir");

                                    opcionAdmin = scan.nextInt();

                                    switch (opcionAdmin) {
                                        case 1:
                                            try {
                                            FileReader iniciarLectura = new FileReader(datosAdmin);
                                            BufferedReader br = new BufferedReader(iniciarLectura);
                                            String lineas = "";
                                            while ((lineas = br.readLine()) != null) {
                                                System.out.println(lineas);
                                            }
                                            br.close();
                                        } catch (FileNotFoundException ex) {
                                            Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (IOException ex) {
                                            Logger.getLogger(SistemaDeVotaciones.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        break;

                                        case 2:
                                            p = 2;

                                            break;
                                        case 3:
                                            p = 2;
                                            o = 2;
                                            i = 2;
                                            break;
                                        default:
                                            break;
                                    };
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
                case 2:
                    System.out.println("Sistema de Votaciones");
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
                            case 1:
                                System.out.println("Sistema de Votaciones");
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
                                    case 3:
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
                                System.out.println("Sistema de Votaciones");
                                System.out.println("Restablecer Contraseña");
                                System.out.println("Ingrese su Email");
                                email = scan.nextLine();

                                c = 2;
                                break;
                            //fin segundo caso
                            case 3:
                                System.out.println("Sistema de Votaciones");
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
                                System.out.println("Sistema de Votaciones");
                                System.out.println("Desabilitar Usuario");
                                System.out.println("Ingrese su DPI");
                                System.out.println("Ingrese pass");
                                break;
                        }
                    } // cierre de switch y while
                    break;
                //fin segundo caso
                case 3:
                    int ciclo = 0;
                    while (ciclo == 0) {
                        System.out.println("Sistema de Votaciones");
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
                                    nos = datos[0];

                                    if (datos[0].compareTo(buscar) == 0) {
                                        String[] listasss = lineas.split("\\|", -1);

                                        System.out.println("OPCIONES DISPONIBLES");
                                        System.out.println("1. Cambiar Nombre:");
                                        System.out.println("2. Cambiar Apellidos:");
                                        System.out.println("3. Cambiar Email:");
                                        System.out.println("4. Cambiar Nombre Usuario");
                                        System.out.println("5. Cambiar Contraseña:");
                                        System.out.println("Ingrese una Opcion:");
                                        int z = scan.nextInt();

                                        scan.nextLine();
                                        System.out.println("Ingrese el nuevo Nombre/s:");
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

                case 4:
                    System.out.println("Sistema De Votaciones");
                    System.out.println("Desabilitar Usuario:");

                    break;
                case 5:
                    i = 2;
                    break;

                default:
                    System.out.println("Opcion Incorrecta");
                    opcion1 = 0;
                    break;
            }
        } //cierre de switch y while
        System.out.println("Programa Finalizado");

    }
}
