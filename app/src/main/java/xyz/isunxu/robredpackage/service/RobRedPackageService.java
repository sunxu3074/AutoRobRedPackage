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

    //private List<String> completedList = new ArrayList<>();

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
                //if (previousAccessibilityNodeInfo == null) {
                //    previousAccessibilityNodeInfo = info;
                //    info.getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
                //}
                //else if (previousAccessibilityNodeInfo != null && previousAccessibilityNodeInfo != info) {
                //    info.getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
                //}
                //else {
                //    return;
                //}
                //if (completedList.size()!=0 && completedList.contains(getHongbaoHash(info))) {
                //    //info.getParent().performAction(GLOBAL_ACTION_BACK);
                //    Log.d("sunxu_log", getHongbaoHash(info));
                //    return;
                //}
                //else  {
                //    Log.d("sunxu_log", completedList.toString());
                //    completedList.add(getHongbaoHash(info));
                    info.getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
                //}

            }

        }

        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {

            List<AccessibilityNodeInfo> infos = mAccessibilityNodeInfo.findAccessibilityNodeInfosByText("拆红包");
            if (infos != null && infos.size() > 0) {
                AccessibilityNodeInfo accessibilityNodeInfo = infos.get(infos.size() - 1);
                //completedList.add(getHongbaoHash(accessibilityNodeInfo));
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
                //if (completedList.contains(getHongbaoHash(accessibilityNodeInfo))) {return;}
                accessibilityNodeInfo.getParent().getChild(3).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                return;
            }

            List<AccessibilityNodeInfo> infoKais = mAccessibilityNodeInfo.findAccessibilityNodeInfosByText("发了一个红包");
            if (infoKais != null && infoKais.size() > 0) {
                AccessibilityNodeInfo accessibilityNodeInfo = infoKais.get(infoKais.size() - 1);
                int size = accessibilityNodeInfo.getParent().getChildCount();
<<<<<<< Updated upstream
                
=======

>>>>>>> Stashed changes
                for (int i = 0; i < accessibilityNodeInfo.getParent().getChildCount(); i++) {
                    accessibilityNodeInfo.getParent().getChild(i).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
                //completedList.add(getHongbaoHash(accessibilityNodeInfo));
            }
        }
    }


    /**
     * 获取节点对象唯一的id，通过正则表达式匹配
     * AccessibilityNodeInfo@后的十六进制数字
     *
     * @param node AccessibilityNodeInfo对象
     * @return id字符串
     */
  /*  private String getNodeId(AccessibilityNodeInfo node) {
        *//* 用正则表达式匹配节点Object *//*
        Pattern objHashPattern = Pattern.compile("(?<=@)[0-9|a-z]+(?=;)");
        Matcher objHashMatcher = objHashPattern.matcher(node.toString());

        // AccessibilityNodeInfo必然有且只有一次匹配，因此不再作判断
        objHashMatcher.find();

        return objHashMatcher.group(0);
    }*/

    /**
     * 将节点对象的id和红包上的内容合并
     * 用于表示一个唯一的红包
     *
     * @param node 任意对象
     * @return 红包标识字符串
     */
   /* private String getHongbaoHash(AccessibilityNodeInfo node) {
        *//* 获取红包上的文本 *//*
        String content;
        try {
            AccessibilityNodeInfo i = node.getParent().getChild(0);
            content = i.getText().toString();
        } catch (NullPointerException npr) {
            return null;
        }

        return content + "@" + getNodeId(node);
    }
*/

    @Override public void onInterrupt() {

    }


}
