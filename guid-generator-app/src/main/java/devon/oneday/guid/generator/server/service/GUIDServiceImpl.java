package devon.oneday.guid.generator.server.service;

import devon.oneday.guid.generator.server.storage.RandomStorage;
import devon.oneday.guid.generator.server.util.DateUtil;
import devon.oneday.guid.generator.server.util.RandomUtil;
import org.springframework.stereotype.Service;

@Service
public class GUIDServiceImpl implements GUIDService {

    @Override
    public String getGUID(String apiId) {
        return new StringBuilder()
                .append(DateUtil.getCurrentNanoDate())
                .append(RandomUtil.getRandomString(4))
//                .append(RandomStorage.getInstance().poll())
                .append("001")
                .append("Y")
                .append(apiId)
                .toString();
    }

}
