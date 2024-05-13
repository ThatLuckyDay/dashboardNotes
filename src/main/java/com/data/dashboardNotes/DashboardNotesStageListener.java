package com.data.dashboardNotes;

import com.data.dashboardNotes.DashboardNotesUIStarter.StageReadyEvent;
import com.data.dashboardNotes.controllers.MainWindowController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DashboardNotesStageListener implements ApplicationListener<StageReadyEvent> {

    private MainWindowController mainWindowController;

    @Autowired
    public DashboardNotesStageListener(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        mainWindowController.loadView(event);
    }
}
