package src.ObjectProperites;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ActionLibrary{
    public static class Jump extends AbstractAction{
        private TestObject testObject;
        public Jump(int key, TestObject testObject) {
            putValue(MNEMONIC_KEY, key);
            this.testObject = testObject;
        }
        public void actionPerformed(ActionEvent e) {
            if(this.testObject.getYVelocity() == 0)
            this.testObject.addYVelocity(12);
        }
        
    }
    
    public static class MoveLeft extends AbstractAction{
        private TestObject testObject;
        public MoveLeft(int key, TestObject testObject) {
            putValue(MNEMONIC_KEY, key);
            this.testObject = testObject;
        }
        public void actionPerformed(ActionEvent e) {
            this.testObject.addXVelocity(-3);
        }
        
    }
    
    public static class MoveRight extends AbstractAction{
        private TestObject testObject;
        public MoveRight(int key, TestObject testObject) {
            putValue(MNEMONIC_KEY, key);
            this.testObject = testObject;
        }
        public void actionPerformed(ActionEvent e) {
            this.testObject.addXVelocity(3);
        }
        
    }
}



