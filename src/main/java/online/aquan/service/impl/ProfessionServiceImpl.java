package online.aquan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import online.aquan.QuanAddressBookApplication;
import online.aquan.convention.exception.ClientException;
import online.aquan.dao.entity.ProfessionDO;
import online.aquan.dao.mapper.ProfessionMapper;
import online.aquan.service.ProfessionService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProfessionServiceImpl implements ProfessionService {

    private final ProfessionMapper professionMapper;

    @Override
    public void save(String profession) {
        ProfessionDO professionDO = new ProfessionDO();
        professionDO.setProfession(profession);
        try {
            professionMapper.insert(professionDO);
        } catch (DuplicateKeyException e) {
            throw new ClientException("不可以添加重复的专业");
        }
    }

    @Override
    public List<ProfessionDO> getAll() {
        LambdaQueryWrapper<ProfessionDO> wrapper = Wrappers.lambdaQuery(ProfessionDO.class);
        return professionMapper.selectList(wrapper);
    }

    @Override
    public void delete(List<String> pids) {
        professionMapper.deleteBatchIds(pids);
    }
}
