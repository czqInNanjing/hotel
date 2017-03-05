package cn.edu.nju.service.impl;

import cn.edu.nju.service.MemberQualifiedService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qiang
 * @since 05/03/2017
 */
@Service
public class MemberQualifiedServiceImpl implements MemberQualifiedService {

    @Scheduled(fixedDelay=5000)
    @Override
    public void memberQualifiedExecutor() {
        subtractAllRemainDays();
        List<Integer> dueIds = getAllDueMemberId();




    }

    @Override
    public List<Integer> getAllDueMemberId() {
        return null;
    }

    @Override
    public void subtractAllRemainDays() {

    }
}
