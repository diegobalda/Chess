package backend;

import java.util.List;

/**
 * Created by Diego Baldassare on 10/10/16.
 */
public interface BoardListener {

    void boardUpdated(List<Position> positions);
}
