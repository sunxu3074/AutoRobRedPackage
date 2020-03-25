package xyz.isunxu.robredpackage.service;


import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobRedPackageService extends AccessibilityService {

    private AccessibilityNodeInfo mAccessibilityNodeInfo = null;

    @Override public void onAccessibilityEvent(AccessibilityEvent event) {

        AccessibilityNodeInfo previousAccessibilityNodeInfo = null;

        mAccessibilityNodeInfo = event.getSource();

        if (mAccessibilityNodeInfo == null) {
            return;
        }


        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
            List<AccessibilityNodeInfo> accessibilityNodeInfos
                    = mAccessibilityNodeInfo.findAccessibilityNodeInfosByText("微信红包");
            if (accessibilityNodeInfos != null && accessibilityNodeInfos.size() > 0) {
                AccessibilityNodeInfo info = accessibilityNodeInfos.get(accessibilityNodeInfos.size() - 1);
                info.getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }

        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {

            List<AccessibilityNodeInfo> infos = mAccessibilityNodeInfo.findAccessibilityNodeInfosByText("拆红包");
            if (infos != null && infos.size() > 0) {
                AccessibilityNodeInfo accessibilityNodeInfo = infos.get(infos.size() - 1);
                accessibilityNodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }

            List<AccessibilityNodeInfo> infoDetails = mAccessibilityNodeInfo.findAccessibilityNodeInfosByText("红包详情");
            if (infoDetails != null && infoDetails.size() > 0) {
                AccessibilityNodeInfo accessibilityNodeInfo = infoDetails.get(infoDetails.size() - 1);
                accessibilityNodeInfo.getParent().getChild(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                return;
            }

            List<AccessibilityNodeInfo> infoSlows = mAccessibilityNodeInfo.findAccessibilityNodeInfosByText("手慢了");
            if (infoSlows != null && infoSlows.size() > 0) {
                AccessibilityNodeInfo accessibilityNodeInfo = infoSlows.get(infoSlows.size() - 1);
                accessibilityNodeInfo.getParent().getChild(3).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                return;
            }

            List<AccessibilityNodeInfo> infoKais = mAccessibilityNodeInfo.findAccessibilityNodeInfosByText("发了一个红包");
            if (infoKais != null && infoKais.size() > 0) {
                AccessibilityNodeInfo accessibilityNodeInfo = infoKais.get(infoKais.size() - 1);
                int size = accessibilityNodeInfo.getParent().getChildCount();
                for (int i = 0; i < accessibilityNodeInfo.getParent().getChildCount(); i++) {
                    accessibilityNodeInfo.getParent().getChild(i).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }
    }


    @Override public void onInterrupt() {

    }


}
