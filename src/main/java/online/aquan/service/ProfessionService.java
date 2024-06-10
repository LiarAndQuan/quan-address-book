package online.aquan.service;


import online.aquan.dao.entity.ProfessionDO;

import java.util.List;

public interface ProfessionService {
    void save(String profession);

    void delete(List<String> pids);

    List<ProfessionDO> getAll();
}
