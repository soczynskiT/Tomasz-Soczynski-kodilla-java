package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        final User millenialsUser = new Millenials("Millenials");
        final User yGenerationUser = new YGeneration("YGeneration");
        final User zGenerationUser = new ZGeneration("ZGeneration");

        //When
        final String millenialUserSharePost = millenialsUser.sharePost();
        System.out.println(millenialsUser.getName() + " use: " + millenialUserSharePost);
        final String yGenerationUserSharePost = yGenerationUser.sharePost();
        System.out.println(yGenerationUser.getName() + " use: " + yGenerationUserSharePost);
        final String zGenerationUSerSharePOst = zGenerationUser.sharePost();
        System.out.println(zGenerationUser.getName() + " use: " + zGenerationUSerSharePOst);

        //Then
        Assert.assertEquals("Facebook", millenialUserSharePost);
        Assert.assertEquals("Tweeter", yGenerationUserSharePost);
        Assert.assertEquals("Snapchat", zGenerationUSerSharePOst);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        final User millenialUser = new Millenials("Millenials");
        millenialUser.setSocialPublisher(new TweeterPublisher());
        final User yGenerationUser = new YGeneration("YGeneration");
        yGenerationUser.setSocialPublisher(new SnapchatPublisher());
        final User zGenerationUser = new ZGeneration("ZGeneration");
        zGenerationUser.setSocialPublisher(new FacebookPublisher());

        //When
        final String millenialUserSharePost = millenialUser.sharePost();
        System.out.println(millenialUser.getName() + " normally use Facebook, but today: " + millenialUserSharePost);
        final String yGenerationUserSharePost = yGenerationUser.sharePost();
        System.out.println(yGenerationUser.getName() + " normally use Tweeter, but today: " + yGenerationUserSharePost);
        final String zGenerationUSerSharePOst = zGenerationUser.sharePost();
        System.out.println(zGenerationUser.getName() + " normally use Snapchat, but today: " + zGenerationUSerSharePOst);

        //Then
        Assert.assertEquals("Tweeter", millenialUserSharePost);
        Assert.assertEquals("Snapchat", yGenerationUserSharePost);
        Assert.assertEquals("Facebook", zGenerationUSerSharePOst);
    }
}
