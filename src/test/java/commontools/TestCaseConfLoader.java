/**
 * Copyright (c) 2017, TP-Link Co.,Ltd.
 * Author:  jiangdanyang <jiangdanyang@tp-link.com.cn>
 * Created: 2017-08-25
 */
package commontools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCaseConfLoader {
    private static final Logger logger = LoggerFactory.getLogger(TestCaseConfLoader.class);
    private JSONObject jsonConfiguration;
    private String readFile(String filePath) throws Exception {
        BufferedReader reader;
        String fileStr = "";
        FileInputStream inputFile = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputFile, "UTF-8");
        reader = new BufferedReader(inputStreamReader);
        String tempString;

        while ((tempString = reader.readLine()) != null) {
            fileStr += tempString;
        }
        reader.close();
        logger.info("readFile success");
        return fileStr;
    }

    private JSONObject loadConfig(String path) {
        try {
            String baseDirString = TestCaseConfLoader.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String absolutePath = baseDirString + File.separator + path;
            jsonConfiguration = new JSONObject(readFile(absolutePath));
        } catch (Exception e) {
            logger.error("read file failed!", e);
            return null;
        }
        logger.debug("[Configurations] " + path);
        return jsonConfiguration;

    }

    public JSONObject getTestCases(String path) {
//        JSONObject testEmailFormatCases = registerTestCases.getJSONObject("testEmailFormat");
//        JSONObject defaultTestCase = testEmailFormatCases.getJSONObject("default");
//        for (Object testObj : testEmailFormatCases.getJSONArray("cases")) {
//            JSONObject jsonObject = (JSONObject)testObj;
//            String comment = jsonObject.getString("comment");
//            JSONObject body_params = jsonObject.getJSONObject("body_params");
//            int expectedStatus = jsonObject.getJSONObject("expectation").getInt("status_code");
//            JSONObject expectedBody = jsonObject.getJSONObject("expectation").getJSONObject("result");
//
//            JSONObject testCase = new JSONObject(defaultTestCase);
//            //Iterator iterator=body_params.keys();
//            for(Iterator<String> iterator = body_params.keys(); iterator.hasNext();) {
//                String key = iterator.next();
//                expectedBody.put(key,body_params.get(key));
//            }
        return loadConfig(path);

    }

    public JSONObject getTestCase(String testCaseName) {

        try {
            return jsonConfiguration.getJSONObject(testCaseName);
        } catch (JSONException e) {
            logger.error("get jsonObject failed!");
            return null;
        }
    }
}
