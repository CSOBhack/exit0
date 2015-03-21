import cz.csob.rest.NodeService;
import cz.csob.rest.model.node.Node;
import cz.csob.rest.model.node.NodeResponse;
import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by roman.zakutny on 21.3.2015.
 */
@Test
public class NodeServiceTest {

    public void test() {
        NodeResponse data = new NodeService().getData();
        Assert.assertTrue(data.get_embedded().getNodes().length > 0);
        for (Node node : data.get_embedded().getNodes()) {
            System.out.print(node.getIp_address());
        }
    }

}
