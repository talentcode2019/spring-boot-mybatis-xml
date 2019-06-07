package com.neo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import com.neo.mapper.IndividualtrangleMapper;
import com.neo.mapper.QueryMapper;
import com.neo.model.Individual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.User;
import com.neo.mapper.UserMapper;

@RestController
public class UserController {

    @Autowired
    private IndividualtrangleMapper individualtrangleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QueryMapper queryMapper;


    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }

//    @GetMapping("/calDemo")
//
//    public String calDemo(int individualId, String date) {
//        return create_individualTalent(individualId, date);
//    }
//
//    public String calDemo(int userid, String name, int gender, int relationshipid, String dateofbirth) {
//            return create_individual(userid, name, gender, relationshipid, dateofbirth);
//    }
//
//    public String calDemo(String nickname, String openId, String wxId) {
//        return create_user(nickname, openId,  wxId);
//    }
//
//    @GetMapping("/queryUserId")
//    public int queryUserId(String wxId) {
//       return query_userId( wxId);
//   }
@RequestMapping(value = "create_user")
    public String create_user(String nickname, String openId, String wxId) {
        Map map_user= new HashMap();
        map_user.put("nickname",nickname);
        map_user.put("openId",openId);
        map_user.put("wxId",wxId);

        individualtrangleMapper.insertUser(map_user);
        return "1";
    }
    @RequestMapping(value = "create_individual")
    public String create_individual(int userid, String name, int gender, int relationshipid, String dateofbirth) {
        Map map_individual = new HashMap();
        map_individual.put("userid",userid);
        map_individual.put("name",name);
        map_individual.put("gender",gender);
        map_individual.put("relationshipid",relationshipid);
        map_individual.put("dateofbirth",dateofbirth);

        int k=individualtrangleMapper.insertIndividual(map_individual);
        return "1";

    }
    @RequestMapping(value = "query_userId")
    public int query_userId(String wxId){
        Map map_getUserId= new HashMap();
        map_getUserId.put("wxId",wxId);

        int user_id=queryMapper.getUserId(map_getUserId);
        return user_id;
    }
//
//    public static int[] query_individualprofile(int individualId){
//        Map map_getindividualprofile = new HashMap();
//        map_getindividualprofile.put("individualId",individualId);
//
//
//    }
//
    @RequestMapping(value = "create_individualTalent")
    public String create_individualTalent(int individualId, String date) {
        int D1 = Integer.parseInt(date.charAt(0) + "");
        int D2 = Integer.parseInt(date.charAt(1) + "");
        int M1 = Integer.parseInt(date.charAt(2) + "");
        int M2 = Integer.parseInt(date.charAt(3) + "");
        int Y1 = Integer.parseInt(date.charAt(4) + "");
        int Y2 = Integer.parseInt(date.charAt(5) + "");
        int Y3 = Integer.parseInt(date.charAt(6) + "");
        int Y4 = Integer.parseInt(date.charAt(7) + "");
        int A1 = (D1 + D2) % 9;
        int A2 = (M1 + M2) % 9;
        int A3 = (Y1 + Y2) % 9;
        int A4 = (Y3 + Y4) % 9;
        int B1 = (D1 + D2 + M1 + M2) % 9;
        int B2 = (Y1 + Y2 + Y3 + Y4) % 9;
        int C1 = (D1 + D2 + M1 + M2 + Y1 + Y2 + Y3 + Y4) % 9;
        int E2 = (2 * D1 + 2 * D2 + M1 + M2) % 9;
        int E3 = (D1 + D2 + 2 * M1 + 2 * M2) % 9;
        int E1 = (3 * D1 + 3 * D2 + 3 * M1 + 3 * M2) % 9;
        int F2 = (2 * Y1 + 2 * Y2 + Y3 + Y4) % 9;
        int F3 = (Y1 + Y2 + 2 * Y3 + 2 * Y4) % 9;
        int F1 = (3 * Y1 + 3 * Y2 + 3 * Y3 + 3 * Y4) % 9;
        int G1 = (D1 + D2 + M1 + M2 + 2 * Y1 + 2 * Y2 + 2 * Y3 + 2 * Y4) % 9;
        int G2 = (2 * D1 + 2 * D2 + 2 * M1 + 2 * M2 + Y1 + Y2 + Y3 + Y4) % 9;
        int H1 = (3 * D1 + 3 * D2 + 3 * M1 + 3 * M2 + 3 * Y1 + 3 * Y2 + 3 * Y3 + 3 * Y4) % 9;

        if (A1 == 0) {
            A1 = 9;
        }
        if (A2 == 0) {
            A2 = 9;
        }
        if (A3 == 0) {
            A3 = 9;
        }
        if (A4 == 0) {
            A4 = 9;
        }
        if (B1 == 0) {
            B1 = 9;
        }
        if (B2 == 0) {
            B2 = 9;
        }
        if (C1 == 0) {
            C1 = 9;
        }
        if (E1 == 0) {
            E1 = 9;
        }
        if (E2 == 0) {
            E1 = 9;
        }
        if (E3 == 0) {
            E1 = 9;
        }
        if (F1 == 0) {
            F1 = 9;
        }
        if (F2 == 0) {
            F2 = 9;
        }
        if (F3 == 0) {
            F3 = 9;
        }
        if (G1 == 0) {
            G1 = 9;
        }
        if (G2 == 0) {
            F2 = 9;
        }
        if (H1 == 0) {
            H1 = 9;
        }
/*
        System.out.println(D1);
        */

        Map map_trangle = new HashMap();
        map_trangle.put("individualid", individualId);
        map_trangle.put("D1", D1);
        map_trangle.put("D2", D2);
        map_trangle.put("M1", M1);
        map_trangle.put("M2", M2);
        map_trangle.put("Y1", Y1);
        map_trangle.put("Y2", Y2);
        map_trangle.put("Y3", Y3);
        map_trangle.put("Y4", Y4);
        map_trangle.put("A1", A1);
        map_trangle.put("A2", A2);
        map_trangle.put("A3", A3);
        map_trangle.put("A4", A4);
        map_trangle.put("B1", B1);
        map_trangle.put("B2", B2);
        map_trangle.put("C1", C1);
        map_trangle.put("E1", E1);
        map_trangle.put("E2", E2);
        map_trangle.put("E3", E3);
        map_trangle.put("F1", F1);
        map_trangle.put("F2", F2);
        map_trangle.put("F3", F3);
        map_trangle.put("G1", G1);
        map_trangle.put("G2", G2);
        map_trangle.put("H1", H1);
        int i = individualtrangleMapper.insertTrangle(map_trangle);

        String TC_I_1 = "" + A1 + A2 + B1;
        String TC_I_2 = "" + A3 + A4 + B2;
        String TC_I_3 = "" + B1 + B2 + C1;
        String TC_L_1 = "" + A1 + B1 + E2;
        String TC_L_2 = "" + A2 + B2 + E3;
        String TC_L_3 = "" + E2 + E3 + E1;
        String TC_U_1 = "" + B2 + C1 + G1;
        String TC_U_2 = "" + B1 + C1 + G2;
        String TC_U_3 = "" + G1 + G2 + H1;
        String TC_R_1 = "" + A3 + B2 + F2;
        String TC_R_2 = "" + A4 + B2 + F3;
        String TC_R_3 = "" + F2 + F3 + F1;

        Map map_talentcode = new HashMap();
        map_talentcode.put("individualid", individualId);
        map_talentcode.put("TC_I_1", TC_I_1);
        map_talentcode.put("TC_I_2", TC_I_2);
        map_talentcode.put("TC_I_3", TC_I_3);
        map_talentcode.put("TC_L_1", TC_L_1);
        map_talentcode.put("TC_L_2", TC_L_2);
        map_talentcode.put("TC_L_3", TC_L_3);
        map_talentcode.put("TC_U_1", TC_U_1);
        map_talentcode.put("TC_U_2", TC_U_2);
        map_talentcode.put("TC_U_3", TC_U_3);
        map_talentcode.put("TC_R_1", TC_R_1);
        map_talentcode.put("TC_R_2", TC_R_2);
        map_talentcode.put("TC_R_3", TC_R_3);


        int j = individualtrangleMapper.insertTalentcode(map_talentcode);

        return "计算成功";

    }

    @RequestMapping(value = "query_user_individual")
    public List<Individual> query_user_individual(String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        List<Individual> userindividual = this.queryMapper.getUserindividual(map);
        return userindividual;
    }

    @RequestMapping(value = "query_individual_profile")
    public Map query_individual_profile(String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        Map individualprofile = this.queryMapper.getindividualprofile(map);
        return individualprofile;
    }

    @RequestMapping(value = "query_individualShortTalent")
    public Map query_individualShortTalent(String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        Map individualShortTalent = this.queryMapper.getindividualShortTalent(map);
        return individualShortTalent;
    }

    @RequestMapping(value = "query_ExampleFigure")
    public Map query_ExampleFigure(String C1) {
        Map<String, String> map = new HashMap<>();
        map.put("C1", C1);
        Map ExampleFigure = this.queryMapper.getExampleFigure(map);
        return ExampleFigure;
    }
}
