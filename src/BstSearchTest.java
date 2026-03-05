import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BstSearchTest {
    @Test
    void testTargetInSingleNode() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        assertTrue(BstSearch.contains(root, 10));
    }

    @Test
    void testTargetInLeftSubtree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(15);

        assertTrue(BstSearch.contains(root, 5));
    }

    @Test
    void testTargetInRightSubtree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(15);

        assertTrue(BstSearch.contains(root, 15));
    }

    @Test
    void testTargetNotFound() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(15);

        assertFalse(BstSearch.contains(root, 99));
    }

    @Test
    void testEmptyTree() {
        assertFalse(BstSearch.contains(null, 10));
    }

    @Test
    void testNullTarget() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);

        assertThrows(NullPointerException.class, () -> {
            BstSearch.contains(root, null);
        });
    }

    @Test
    void testMultipleLevels() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(20);
        root.left = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(5);
        root.left.left.left = new BinaryTreeNode<>(2);

        assertTrue(BstSearch.contains(root, 2));
    }

    @Test
    void testGenericString() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("g");
        root.left = new BinaryTreeNode<>("f");
        root.right = new BinaryTreeNode<>("r");

        assertTrue(BstSearch.contains(root, "f"));
        assertFalse(BstSearch.contains(root, "l"));
    }
}
