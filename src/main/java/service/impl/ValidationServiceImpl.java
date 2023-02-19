package service.impl;

import model.Color;
import model.Size;
import model.SocksBatch;
import org.springframework.stereotype.Service;
import service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(SocksBatch socksBatch) {
        return socksBatch.getSocks() != null &&
                socksBatch.getQuantity() > 0 &&
                socksBatch.getSocks().getColor() != null &&
                socksBatch.getSocks().getSize() != null &&
                checkCotton(socksBatch.getSocks().getCottonPark(), socksBatch.getSocks().getCottonPark());
    }

    @Override
    public boolean validate(Color color, Size size, int cottonMin, int cottonMax) {
        return color != null && size !=null && checkCotton(cottonMin,cottonMax);
    }

    private boolean checkCotton(int cottonMin, int cottonMax){
        return cottonMin >= 0 && cottonMax <= 100;
    }
}
