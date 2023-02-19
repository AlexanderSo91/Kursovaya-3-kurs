package repository;

import model.Socks;
import model.SocksBatch;

import java.util.Map;

public interface SocksRepository {
    void save(SocksBatch socksBatch);
    int remove(SocksBatch socksBatch);
    Map<Socks, Integer> getAll();
}
