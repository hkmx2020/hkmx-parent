package com.hkmx.common.imagemerge;

import com.alibaba.fastjson.JSONObject;
import com.freewayso.image.combiner.ImageCombiner;
import com.freewayso.image.combiner.element.ImageElement;
import com.freewayso.image.combiner.element.RectangleElement;
import com.freewayso.image.combiner.enums.BaseLine;
import com.freewayso.image.combiner.enums.Direction;
import com.freewayso.image.combiner.enums.OutputFormat;
import com.freewayso.image.combiner.enums.ZoomMode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author maoxingwen
 * @date 2023/2/24 16:54
 * @description
 */
public class ImageCombine {

    public static void main(String[] args) throws Exception {
        // combineRectangleInput();
        combineEllipseInput();
        // combineEllipse();
        // combineImageText();
    }

    private static void combineEllipse() throws IOException {
        int width = 800;
        int height = 600;
        Color bgColor = Color.decode("#1890ff");
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.getGraphics();

        // PNG要做透明度处理
        image = g.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        g = image.createGraphics();

        // 抗锯齿
        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setStroke(new BasicStroke(1)); //BasicStroke(线条粗细)
        g.setColor(bgColor);
        g.fillOval(15, 15, width / 2, height / 4);//涂椭圆
        g.dispose();

        FileOutputStream out = new FileOutputStream("D:\\wall\\纯色椭圆-合成.png");
        ImageIO.write(image, "png", out);
    }

    private static void combineRectangleInput() throws Exception {
        ImageCombiner combiner = new ImageCombiner(1920, 1080, OutputFormat.PNG);
        // 添加输入源背景
        Double x = 143.71929824561403D;
        Double y = 110.03508771929825D;
        Double width = 100D;
        Double weight = 100D;
        Double scaleX = 5.715789473684218D;
        Double scaleY = 4.256140350877196D;
        float alpha = 1f;
        Color bgColor = Color.decode("#1ab370");
        RectangleElement rectangleElement = combiner.addRectangleElement(x.intValue(), y.intValue(), (int) (width * scaleX), (int) (weight * scaleY))
                .setColor(bgColor)
                .setAlpha(alpha);

        // 添加输入源占位图
        String placeholderImageUrl = "http://1500014901.vod2.myqcloud.com/6cabe117vodcq1500014901/5ece4031243791576340610873/dCXtz9Joc9gA.png";
        int placeholderX = (int) (rectangleElement.getX() + 10 * scaleX);
        int placeholderY = (int) (rectangleElement.getY() + 16 * scaleY);
        int placeholderWidth = (int) (80 * scaleX);
        int placeholderHeight = (int) (62 * scaleY);
        combiner.addImageElement(placeholderImageUrl, placeholderX, placeholderY, placeholderWidth, placeholderHeight, ZoomMode.WidthHeight);

        // 添加输入源固定文字 “共享源”
        int textPlaceholderX = (int) (rectangleElement.getX() + rectangleElement.getWidth() / 2);
        int textPlaceholderY = (int) (rectangleElement.getY() + rectangleElement.getHeight() / 2);
        combiner.addTextElement("共享源", "黑色", 80, textPlaceholderX, textPlaceholderY)
                .setAlpha(1f).setColor(Color.WHITE).setDirection(Direction.CenterLeftRight).setBaseLine(BaseLine.Middle);


        // 添加字体
        Double textX = 121.26315789473682D;
        Double textY = 689.4035087719296D;
        Double textWidth = 549.2631578947367D;
        Double textheight = 250.45614035087715D;
        int fontSize = 80;
        combiner.addRectangleElement(textX.intValue(), textY.intValue(), textWidth.intValue(), textheight.intValue()).setBorderSize(3).setColor(Color.RED);
        combiner.addTextElement("主标题", "黑色", fontSize, textX.intValue(), textY.intValue()).setAlpha(1f);

        // 添加图片
        String imageUrl = "https://material-123-1257099670.cos.ap-beijing.myqcloud.com/dev/material_manager/carbon.png";
        Double imageX = 898.245614035087D;
        Double imageY = 141.4736842105263D;
        int imageWith = 704;
        int imageHeight = 558;
        combiner.addImageElement(imageUrl, imageX.intValue(), imageY.intValue(), imageWith, imageHeight, ZoomMode.WidthHeight);

        combiner.combine();
        combiner.save("D:\\wall\\矩形输入源.png");
    }

    private static void combineEllipseInput() throws Exception {
        Double x = 258.2456140350877D;
        Double y = 300.9122807017544D;
        Double width = 100D;
        Double weight = 100D;
        Double scaleX = 6.075087719298257D;
        Double scaleY = 2.077894736842105D;
        float alpha = 1f;
        Color bgColor = Color.decode("#1890ff");

        ImageCombiner combiner = new ImageCombiner(1920, 1080, null, OutputFormat.PNG);

        // 先生成椭圆背景图片
        int ellipseWidth = (int) (width * scaleX);
        int ellipseWeight = (int) (weight * scaleY);
        BufferedImage ellipseImage = new BufferedImage(ellipseWidth, ellipseWeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) ellipseImage.getGraphics();
        // PNG要做透明度处理
        ellipseImage = g.getDeviceConfiguration().createCompatibleImage(ellipseWidth, ellipseWeight, Transparency.TRANSLUCENT);
        g = ellipseImage.createGraphics();
        // 抗锯齿
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.white);

        g.setStroke(new BasicStroke(1)); //BasicStroke(线条粗细)
        g.setColor(bgColor);
        g.fillOval(0, 0, ellipseWidth, ellipseWeight);//涂椭圆
        g.dispose();

        ImageIO.write(ellipseImage, "png", new FileOutputStream("D:\\wall\\背景纯色椭圆-合成.png"));
        ImageElement imageElement = combiner.addImageElement(ellipseImage, x.intValue(), y.intValue());

        // 添加输入源占位图
        String placeholderImageUrl = "http://1500014901.vod2.myqcloud.com/6cabe117vodcq1500014901/5ece4031243791576340610873/dCXtz9Joc9gA.png";
        int placeholderX = (int) (imageElement.getX() + 10 * scaleX);
        int placeholderY = (int) (imageElement.getY() + 16 * scaleY);
        int placeholderWidth = (int) (80 * scaleX);
        int placeholderHeight = (int) (62 * scaleY);
        combiner.addImageElement(placeholderImageUrl, placeholderX, placeholderY, placeholderWidth, placeholderHeight, ZoomMode.WidthHeight);

        // 添加输入源固定文字 “共享源”
        int textPlaceholderX = (int) (imageElement.getX() + imageElement.getWidth() / 2);
        int textPlaceholderY = (int) (imageElement.getY() + imageElement.getHeight() / 2);
        combiner.addTextElement("神雕侠侣,绝迹江湖", "黑体", 80, textPlaceholderX, textPlaceholderY)
                .setAutoBreakLine(10)
                .setAlpha(1f).setColor(Color.WHITE).setDirection(Direction.CenterLeftRight).setBaseLine(BaseLine.Middle);

        combiner.combine();
        combiner.save("D:\\wall\\椭圆输入源.png");
    }

    private static void combineImageText() throws Exception {
        // 黑体
        // String metedata = "[{\"textList\":[{\"fontType\":\"黑体\",\"yPos\":15,\"bBold\":false,\"xPos\":10,\"shadowSize\":1,\"content\":\"医百科技\",\"bShadow\":false,\"layerId\":1,\"slideMode\":0,\"name\":\"text1\",\"width\":300,\"fontSize\":36,\"alphaValue\":1,\"fontColor\":\"0xffffff\"},{\"fontType\":\"黑体\",\"yPos\":82,\"bBold\":false,\"xPos\":10,\"shadowSize\":1,\"content\":\"www.100doc.com.cn\",\"bShadow\":false,\"layerId\":2,\"slideMode\":0,\"name\":\"text2\",\"width\":300,\"fontSize\":24,\"alphaValue\":1,\"fontColor\":\"0x006600\"}],\"yPos\":0,\"gradualValue\":[],\"xPos\":0,\"exitAnimation\":0,\"animationList\":[],\"displayDuration\":100,\"enterAnimation\":0,\"picList\":[{\"layerId\":0,\"yPos\":0,\"name\":\"背景图\",\"width\":320,\"xPos\":0,\"alphaValue\":1,\"content\":\"https://switcher-7-1259387452.file.myqcloud.com/素材库/图文字幕模版/绿白桌卡320x117.png\",\"height\":117}],\"width\":320,\"gradualAngle\":0,\"alphaValue\":1,\"height\":117,\"type\":\"\",\"x\":812.9122807017544,\"y\":422.1754385964916,\"scaleX\":2.073684210526319,\"scaleY\":2.7082021292547616,\"alpha\":1,\"content\":\"\",\"domType\":\"div\",\"clientResourceClassify\":1,\"children\":[{\"layerId\":0,\"yPos\":0,\"name\":\"背景图\",\"width\":320,\"xPos\":0,\"alphaValue\":1,\"content\":\"https://switcher-7-1259387452.file.myqcloud.com/素材库/图文字幕模版/绿白桌卡320x117.png\",\"height\":117,\"type\":\"img\",\"x\":0,\"y\":0,\"scaleX\":1,\"scaleY\":1,\"alpha\":1,\"domType\":\"img\",\"clientResourceClassify\":2,\"children\":[]},{\"fontType\":\"黑体\",\"yPos\":15,\"bBold\":false,\"xPos\":10,\"shadowSize\":1,\"content\":\"医百科技\",\"bShadow\":false,\"layerId\":1,\"slideMode\":0,\"name\":\"text1\",\"width\":300,\"fontSize\":36,\"alphaValue\":1,\"fontColor\":\"0xffffff\",\"type\":\"span\",\"textShowType\":0,\"x\":10,\"y\":15,\"height\":100,\"scaleX\":1,\"scaleY\":1,\"alpha\":1,\"domType\":\"span\",\"clientResourceClassify\":1,\"children\":[]},{\"fontType\":\"黑体\",\"yPos\":82,\"bBold\":false,\"xPos\":10,\"shadowSize\":1,\"content\":\"www.100doc.com.cn\",\"bShadow\":false,\"layerId\":2,\"slideMode\":0,\"name\":\"text2\",\"width\":300,\"fontSize\":24,\"alphaValue\":1,\"fontColor\":\"0x006600\",\"type\":\"span\",\"textShowType\":0,\"x\":10,\"y\":82,\"height\":100,\"scaleX\":1,\"scaleY\":1,\"alpha\":1,\"domType\":\"span\",\"clientResourceClassify\":1,\"children\":[]}],\"templateThumbnail\":\"https://switcher-7-1259387452.file.myqcloud.com/素材库/图文字幕模版/绿白桌卡320x117_样例.png\",\"thumbnail\":\"https://switcher-7-1259387452.file.myqcloud.com/素材库/图文字幕模版/绿白桌卡320x117_样例.png\",\"id\":\"7c81730e-f154-4d68-b7a5-04d19b48a2a9\",\"loop\":false,\"configType\":\"basic_config\"}]";
        // 宋体
        String metedata = "[{\"textList\":[{\"fontType\":\"黑体\",\"yPos\":15,\"bBold\":false,\"xPos\":10,\"shadowSize\":1,\"content\":\"医百科技\",\"bShadow\":false,\"layerId\":1,\"slideMode\":0,\"name\":\"text1\",\"width\":300,\"fontSize\":36,\"alphaValue\":1,\"fontColor\":\"0xffffff\"},{\"fontType\":\"黑体\",\"yPos\":82,\"bBold\":false,\"xPos\":10,\"shadowSize\":1,\"content\":\"www.100doc.com.cn\",\"bShadow\":false,\"layerId\":2,\"slideMode\":0,\"name\":\"text2\",\"width\":300,\"fontSize\":24,\"alphaValue\":1,\"fontColor\":\"0x006600\"}],\"yPos\":0,\"gradualValue\":[],\"xPos\":0,\"exitAnimation\":0,\"animationList\":[],\"displayDuration\":100,\"enterAnimation\":0,\"picList\":[{\"layerId\":0,\"yPos\":0,\"name\":\"背景图\",\"width\":320,\"xPos\":0,\"alphaValue\":1,\"content\":\"https://switcher-7-1259387452.file.myqcloud.com/素材库/图文字幕模版/绿白桌卡320x117.png\",\"height\":117}],\"width\":320,\"gradualAngle\":0,\"alphaValue\":1,\"height\":117,\"type\":\"\",\"x\":812.9122807017544,\"y\":422.1754385964916,\"scaleX\":2.073684210526319,\"scaleY\":2.7082021292547616,\"alpha\":1,\"content\":\"\",\"domType\":\"div\",\"clientResourceClassify\":1,\"children\":[{\"layerId\":0,\"yPos\":0,\"name\":\"背景图\",\"width\":320,\"xPos\":0,\"alphaValue\":1,\"content\":\"https://switcher-7-1259387452.file.myqcloud.com/素材库/图文字幕模版/绿白桌卡320x117.png\",\"height\":117,\"type\":\"img\",\"x\":0,\"y\":0,\"scaleX\":1,\"scaleY\":1,\"alpha\":1,\"domType\":\"img\",\"clientResourceClassify\":2,\"children\":[]},{\"fontType\":\"宋体\",\"yPos\":15,\"bBold\":false,\"xPos\":10,\"shadowSize\":1,\"content\":\"医百科技\",\"bShadow\":false,\"layerId\":1,\"slideMode\":0,\"name\":\"text1\",\"width\":300,\"fontSize\":36,\"alphaValue\":1,\"fontColor\":\"0xffffff\",\"type\":\"span\",\"textShowType\":0,\"x\":10,\"y\":15,\"height\":100,\"scaleX\":1,\"scaleY\":1,\"alpha\":1,\"domType\":\"span\",\"clientResourceClassify\":1,\"children\":[]},{\"fontType\":\"宋体\",\"yPos\":82,\"bBold\":false,\"xPos\":10,\"shadowSize\":1,\"content\":\"www.100doc.com.cn\",\"bShadow\":false,\"layerId\":2,\"slideMode\":0,\"name\":\"text2\",\"width\":300,\"fontSize\":24,\"alphaValue\":1,\"fontColor\":\"0x006600\",\"type\":\"span\",\"textShowType\":0,\"x\":10,\"y\":82,\"height\":100,\"scaleX\":1,\"scaleY\":1,\"alpha\":1,\"domType\":\"span\",\"clientResourceClassify\":1,\"children\":[]}],\"templateThumbnail\":\"https://switcher-7-1259387452.file.myqcloud.com/素材库/图文字幕模版/绿白桌卡320x117_样例.png\",\"thumbnail\":\"https://switcher-7-1259387452.file.myqcloud.com/素材库/图文字幕模版/绿白桌卡320x117_样例.png\",\"id\":\"7c81730e-f154-4d68-b7a5-04d19b48a2a9\",\"loop\":false,\"configType\":\"basic_config\"}]";
        ImageCombiner combiner = new ImageCombiner(1920, 1080, null, OutputFormat.PNG);

        List<Element> elements = JSONObject.parseArray(metedata, Element.class);
        for (Element element : elements) {
            List<Element> children = element.getChildren();
            for (Element child : children) {
                String domType = child.getDomType();
                if (domType.equals("img")) {
                    fillImage(combiner, element, child);
                }
                if (domType.equals("span")) {
                    fillText(combiner, element, child);
                }

            }
        }
        combiner.combine();
        // combiner.save("D:\\wall\\图文合成-黑体.png");
        combiner.save("D:\\wall\\图文合成-宋体.png");
    }

    private static void fillImage(ImageCombiner combiner, Element element, Element child) {
        // x y 为相对位置
        int x = element.getX().add(child.getX().multiply(child.getScaleX())).intValue();
        int y = element.getY().add(child.getY().multiply(child.getScaleY())).intValue();
        int width = child.getWidth().multiply(element.getScaleX()).intValue();
        int height = child.getHeight().multiply(element.getScaleY()).intValue();
        combiner.addImageElement(child.getContent(), x, y, width, height, ZoomMode.WidthHeight)
                .setAlpha(element.getAlpha().floatValue());
    }

    private static void fillText(ImageCombiner combiner, Element element, Element child) {
        int x = element.getX().add(child.getX().multiply(element.getScaleX())).intValue();
        int y = element.getY().add(child.getY().multiply(element.getScaleY())).intValue();
        int fontSize =  new BigDecimal(child.getFontSize()).multiply(element.getScaleX()).intValue();
        Color color = Color.decode(child.getFontColor());
        combiner.addTextElement(child.getContent(), child.getFontType(), fontSize, x, y)
                .setColor(color).setAlpha(child.getAlpha().floatValue());
    }


}
