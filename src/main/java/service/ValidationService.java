package service;

import model.Color;
import model.Size;
import model.SocksBatch;

public interface ValidationService {
    boolean validate(SocksBatch socksBatch);
    boolean validate(Color color, Size size, int cottonMin, int cottonMax);
}
