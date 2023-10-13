package sistemadevotaciones;

/**
 *
 * @author Joseph
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Scanner;

public class SistemaDeVotaciones {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de Votaciones");
        System.out.println("Ingrese una contrasena para el Sistema");
        

        //declaracion de variables
        String nombre, apellido, usuario, pass, email, estado, datoModificar, direccion, departamento, municipio;
        int l;
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
                }
        }
        int opcion1 = 0;
        int i = 1;
        while (i < 2) {
            System.out.println("Sistema de Votaciones");
            System.out.println("1. Iniciar Sesion.");
            System.out.println("2. Crear Usuario.");
            System.out.println("3. Salir.");

            if (opcion1 <= 0) {
                opcion1 = scan.nextInt();
            };

            switch (opcion1) {
                case 1:
                    System.out.println("Sistema de Votaciones");
                    System.out.println("Iniciar Sesion");
                    System.out.println("1. Administrador");
                    System.out.println("2. Registrador de Votantes");
                    System.out.println("3. Votante");
                    System.out.println("4. Auditor");
                    System.out.println("5. Regresar;");
                    System.out.println("6. Salir");
                    System.out.println("Ingrese una opcion: ");
                    int opcI = scan.nextInt();
                    if (opcI == 5) {
                        i = 1;
                    } else if (opcI == 6) {
                        i = 6;
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
                                    } catch (IOException ex) {
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
                    i = 5;
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    System.out.println("Ingrese de nuevo una Opcion ");
                    System.out.println("1. Iniciar Sesion.");
                    System.out.println("2. Crear Usuario.");
                    System.out.println("3. Salir.");
                    int retor = scan.nextInt();
                    opcion1 = retor;

            };
        };

    }

}