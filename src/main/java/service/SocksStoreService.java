package service;

import model.Color;
import model.Size;
import model.SocksBatch;

public interface SocksStoreService  {
    void accept(SocksBatch socksBatch);
    int issuance(SocksBatch socksBatch);
    int reject(SocksBatch socksBatch);
    int getCount(Color color, Size size, int cottonMin, int cottonMax);

}
