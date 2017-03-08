package org.clayman.hollow.common;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.netflix.hollow.api.codegen.HollowAPIGenerator;
import com.netflix.hollow.core.write.HollowWriteStateEngine;
import com.netflix.hollow.core.write.objectmapper.HollowObjectMapper;

import java.io.File;

public class ApiGenerator {

    public static void main(String[] args) throws Exception {
        HollowWriteStateEngine writeEngine = new HollowWriteStateEngine();
        HollowObjectMapper mapper = new HollowObjectMapper(writeEngine);

        ClassPath classPath = ClassPath.from(ApiGenerator.class.getClassLoader());
        ImmutableSet<ClassPath.ClassInfo> topLevelClasses = classPath.getTopLevelClasses("org.clayman.hollow.common.data");
        for (ClassPath.ClassInfo aClass : topLevelClasses) {
            Class<?> load = aClass.load();
            mapper.initializeTypeState(load);
        }

        HollowAPIGenerator generator =
                new HollowAPIGenerator(
                        "APIfacade",
                        "org.clayman.hollow.producer.api",
                        writeEngine
                );

        String folderPath = "/home/baltor/IdeaProjects/hollow/result-producer/src/main/java/org/clayman/hollow/producer/api";

        File apiCodeFolder = new File(folderPath);

        apiCodeFolder.mkdirs();

        for(File f : apiCodeFolder.listFiles())
            f.delete();

        generator.generateFiles(folderPath);
    }
}
