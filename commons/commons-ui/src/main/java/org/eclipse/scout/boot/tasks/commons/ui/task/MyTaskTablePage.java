package org.eclipse.scout.boot.tasks.commons.ui.task;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.scout.boot.tasks.commons.model.Task;
import org.eclipse.scout.boot.tasks.commons.model.service.TaskService;
import org.eclipse.scout.boot.tasks.commons.ui.task.AbstractTaskTablePage.Table.AcceptMenu;
import org.eclipse.scout.rt.shared.TEXTS;

public class MyTaskTablePage extends AbstractTaskTablePage {

  @Inject
  private TaskService taskService;

  public MyTaskTablePage() {
    getTable().getResponsibleColumn().setDisplayable(false);
    getTable().getAcceptedColumn().setDisplayable(false);
    getTable().getMenuByClass(AcceptMenu.class).setVisible(false);
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("MyTasks");
  }

  @Override
  protected Collection<Task> getTasks() {
    return taskService.getOwn(getUserId());
  }

  @Override
  protected void execPageActivated() {
    reloadPage();
  }
}
