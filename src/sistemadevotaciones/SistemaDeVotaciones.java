package sistemadevotaciones;

/**
 *
 * @author Joseph
 */
import java.io.File;
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

        File archivo;
        FileWriter escribir;
        PrintWriter linea;

        archivo = new File("passSistema.txt");

        if (!archivo.exists()) {
            String passSistem = scan.nextLine();
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println(passSistem);

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
                                    i = 1;
                                    opcion1 = 2;
                                } else if (opcT == 5) {
                                    opcion1 = 3;
                                }

                                switch (opcR) {
                                    case 1:
                                        int d = 0;
                                        while (d < 2) {
                                            System.out.println("Ingrese su DPI");
                                            String dpi = scan.nextLine();
                                            System.out.println("Ingrese su nombre completo");
                                            

                                        }// fin while de Registro de Cuenta Administrador
                                        break;
                                }
                                c = 6;
                                break;
                            case 2:
                                System.out.println("Sistema de Votaciones");
                                System.out.println("Restablecer Contraseña");
                                System.out.println("Ingrese su Email");
                                String email = scan.nextLine();
                                break;
                            case 3:
                                System.out.println("Sistema de Votaciones");
                                System.out.println("Modificar Usuario");
                                System.out.println("Ingrese su Email");
                                email = scan.nextLine();
                                System.out.println("Ingrese Contraseña");
                                String pass = scan.nextLine();
                                break;
                            case 4:
                                System.out.println("Sistema de Votaciones");
                                System.out.println("Desabilitar Usuario");
                                System.out.println("Ingrese su DPI");
                                System.out.println("Ingrese pass");

                        };
                        //finalizacion de switch Tipo de Usuario
                    }
                    ;
                    // finalizacion de while Tipo de Usuario;

                    break;
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