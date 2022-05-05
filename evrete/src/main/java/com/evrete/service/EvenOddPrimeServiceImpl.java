package com.evrete.service;

import org.evrete.KnowledgeService;
import org.evrete.api.Knowledge;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Service
public class EvenOddPrimeServiceImpl implements EvenOddPrimeService {

     public void evenPrime(Integer n) throws IOException {
         KnowledgeService service = new KnowledgeService();
         URL rulesetUrl =new File("C:\\Users\\Divya_Intern\\Desktop\\Evrete\\evrete\\src\\main\\resources\\rules\\ruleFile").toURI().toURL();

         Knowledge knowledge = service
                 .newKnowledge(
                         "JAVA-SOURCE",
                         rulesetUrl
                 );
             boolean flag = false;

             if (n == 0 || n == 1)
                 flag = true;

             for (int i = 2; i <= n / 2; ++i) {

                 if (n % i == 0) {
                     flag = true;
                     break;
                 }
             }

         knowledge
                .newStatelessSession()
                .insert(n,flag)
                .fire();
     }

}
