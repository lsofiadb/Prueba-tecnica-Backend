package com.teclogi.prueba.tecnica.service;

import com.teclogi.prueba.tecnica.model.Position;
import com.teclogi.prueba.tecnica.model.Satellite;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VehicleService {
    public Position getLocation(ArrayList<Satellite> satellites) {
        Position vehiclePosition = new Position();

        /*-----Via Cramer's rule----*/
        double x1 = satellites.get(0).getPosition().getX();
        double x2 = satellites.get(1).getPosition().getX();
        double x3 = satellites.get(2).getPosition().getX();
        double y1 = satellites.get(0).getPosition().getY();
        double y2 = satellites.get(1).getPosition().getY();
        double y3 = satellites.get(2).getPosition().getY();
        double r1 = satellites.get(0).getDistance();
        double r2 = satellites.get(1).getDistance();
        double r3 = satellites.get(2).getDistance();
        double a = 2 * (x2 - x1);
        double b = 2 * (y2 - y1);
        double c = 2 * (x3 - x2);
        double d = 2 * (y3 - y2);
        double e = (double) (Math.pow(r1, 2) - Math.pow(r2, 2) - Math.pow(x1, 2) + Math.pow(x2, 2) - Math.pow(y1, 2) + Math.pow(y2, 2));
        double f = (double) (Math.pow(r2, 2) - Math.pow(r3, 2) - Math.pow(x2, 2) + Math.pow(x3, 2) - Math.pow(y2, 2) + Math.pow(y3, 2));
        if(Math.abs((a*d)-(b*c)) >=Math.pow(10,-4)){
            double x = ((e * d) - (b * f)) / ((a * d) - (b * c));
            double y = ((a * f) - (e * c)) / ((a * d) - (b * c));
            double equation1 = (double) (Math.pow((x - x1), 2) + Math.pow((y - y1), 2));
            double equation2 = (double) (Math.pow((x - x2), 2) + Math.pow((y - y2), 2));
            double equation3 = (double) (Math.pow((x - x3), 2) + Math.pow((y - y3), 2));
            double equality1 = (double) Math.pow(r1, 2) - equation1;
            double equality2 = (double) Math.pow(r2, 2) - equation2;
            double equality3 = (double) Math.pow(r3, 2) - equation3;

            if (Math.abs(equality1) < Math.pow(10, -2) & Math.abs(equality2) < Math.pow(10, -2) & Math.abs(equality3) < Math.pow(10, -2)) {
                vehiclePosition.setX(roundNumber((double) x, 1));
                vehiclePosition.setY(roundNumber((double) y, 1));
                return vehiclePosition;
            } else {
                return null;
            }
        }else{
            return null;
        }
    }

    public double roundNumber(double number, int digitsNumber) {
        double result = number * (double) Math.pow(10, digitsNumber);
        result = Math.round(result);
        result = result / (double) Math.pow(10, digitsNumber);
        return result;
    }

    public boolean isInDanger(String[] messages) {
        boolean danger = false;
        int sequences = 0;
        char[][] matrix = new char[messages.length][messages.length];

        System.out.println("MATRIX");
        for (int i = 0; i < messages.length; i++) {
            for (int j = 0; j < messages.length; j++) {
                matrix[i][j] = messages[i].charAt(j);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        /*-----PATH 1: HORIZONTAL -------*/
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j + 1] == matrix[i][j + 2] & matrix[i][j + 2] == matrix[i][j + 3]) {
                    sequences++;
                }
            }
        }

        /*-----PATH 2: VERTICAL ------*/
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[j][i] == matrix[j + 1][i] && matrix[j + 1][i] == matrix[j + 2][i] & matrix[j + 2][i] == matrix[j + 3][i]) {
                    sequences++;
                }
            }
        }

        /*-------PATH 3: DIAGONALS FROM LEFT TO RIGHT------*/
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == matrix[i + 1][j + 1] & matrix[i][j] == matrix[i + 2][j + 2] & matrix[i][j] == matrix[i + 3][j + 3]) {
                    sequences++;
                }
            }
        }

        /*----------------MIRROR MATRIX-------------------*/
        char mirrorMatrix[][] = new char[matrix.length][matrix.length];
        for (int i = 0; i < mirrorMatrix.length; i++) {
            for (int j = 0; j < mirrorMatrix.length; j++) {
                mirrorMatrix[i][j] = matrix[5 - i][j];
            }
        }

        /*-------PATH 4: DIAGONALS FROM RIGHT TO LEFT------*/
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mirrorMatrix[i][j] == mirrorMatrix[i + 1][j + 1] & mirrorMatrix[i][j] == mirrorMatrix[i + 2][j + 2] & mirrorMatrix[i][j] == mirrorMatrix[i + 3][j + 3]) {
                    sequences++;
                }
            }
        }

        System.out.println("sequences");
        System.out.println(sequences);

        if (sequences > 1) {
            return true;
        } else {
            return false;
        }
    }
}