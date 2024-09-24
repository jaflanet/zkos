package data;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import java.util.Set;

public class UserController  extends SelectorComposer<Component> {

    @Wire
    private Textbox keywordBox;

    @Wire
    private Listbox userListBox;

    @Wire
    private Label idLabel;

    @Wire
    private Label usernameLabel;

    @Wire
    private Label genderLabel;

    @Wire
    private Label birthdayLabel;

    @Wire
    private Label statusLabel;

    @Wire
    private Label anakLabel;
    private UserService userService = new UserServiceImpl();
    private ListModelList<User> dataModel = new ListModelList<>(userService.findAll());



    @Override
    public void doAfterCompose(Component comp) throws Exception{
        super.doAfterCompose(comp);
        userListBox.setModel(dataModel);
    }

    @Listen("onClick = #searchButton; onOk = window")
    public void search(){
        String keyword = keywordBox.getValue();
        dataModel.clear();
        dataModel.addAll(userService.search(keyword));
    }

    @Listen("onSelect = #userListBox")
    public void showDetail(){
        Set<User> selection = dataModel.getSelection();
        User selected = selection.iterator().next();
        idLabel.setValue(selected.getId().toString());
        usernameLabel.setValue(selected.getUsername());
        genderLabel.setValue(selected.getGender());
        birthdayLabel.setValue(selected.getBirthday());
        statusLabel.setValue(selected.getStatus());
        anakLabel.setValue(selected.getAnak().toString());
    }
}
