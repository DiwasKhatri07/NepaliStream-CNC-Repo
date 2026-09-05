package com.PublicSportsIPTV;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PublicSportsIPTVParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/PublicSportsIPTV/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BË\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0016\b\u0001\u0010\r\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0016\b\u0001\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0016\b\u0001\u0010\u0011\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÍ\u0001\u0010(\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0016\b\u0003\u0010\r\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0016\b\u0003\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0016\b\u0003\u0010\u0011\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014HÆ\u0001J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018¨\u0006/"}, d2 = {"Lcom/PublicSportsIPTV/ImageCdn;", "", "tataplay", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "TATAPLAY", "app", "APP", "playback", "PLAYBACK", "logo", "LOGO", "sports", "SPORTS", "bgImage", "BG_IMAGE", "sportByImage", "SPORT_BY_IMAGE", "cloudfare", "CLOUDFARE", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTataplay", "()Ljava/lang/String;", "getApp", "getPlayback", "getLogo", "getSports", "getBgImage", "getSportByImage", "getCloudfare", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "PublicSportsIPTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ImageCdn {

    @NotNull
    private final String app;

    @NotNull
    private final String bgImage;

    @Nullable
    private final String cloudfare;

    @NotNull
    private final String logo;

    @Nullable
    private final String playback;

    @NotNull
    private final String sportByImage;

    @NotNull
    private final String sports;

    @NotNull
    private final String tataplay;

    public static /* synthetic */ ImageCdn copy$default(ImageCdn imageCdn, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageCdn.tataplay;
        }
        if ((i & 2) != 0) {
            str2 = imageCdn.app;
        }
        if ((i & 4) != 0) {
            str3 = imageCdn.playback;
        }
        if ((i & 8) != 0) {
            str4 = imageCdn.logo;
        }
        if ((i & 16) != 0) {
            str5 = imageCdn.sports;
        }
        if ((i & 32) != 0) {
            str6 = imageCdn.bgImage;
        }
        if ((i & 64) != 0) {
            str7 = imageCdn.sportByImage;
        }
        if ((i & 128) != 0) {
            str8 = imageCdn.cloudfare;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        return imageCdn.copy(str, str2, str3, str4, str11, str12, str9, str10);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTataplay() {
        return this.tataplay;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getApp() {
        return this.app;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPlayback() {
        return this.playback;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSports() {
        return this.sports;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBgImage() {
        return this.bgImage;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSportByImage() {
        return this.sportByImage;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCloudfare() {
        return this.cloudfare;
    }

    @NotNull
    public final ImageCdn copy(@JsonProperty("TATAPLAY") @NotNull String tataplay, @JsonProperty("APP") @NotNull String app, @JsonProperty("PLAYBACK") @Nullable String playback, @JsonProperty("LOGO") @NotNull String logo, @JsonProperty("SPORTS") @NotNull String sports, @JsonProperty("BG_IMAGE") @NotNull String bgImage, @JsonProperty("SPORT_BY_IMAGE") @NotNull String sportByImage, @JsonProperty("CLOUDFARE") @Nullable String cloudfare) {
        return new ImageCdn(tataplay, app, playback, logo, sports, bgImage, sportByImage, cloudfare);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageCdn)) {
            return false;
        }
        ImageCdn imageCdn = (ImageCdn) other;
        return Intrinsics.areEqual(this.tataplay, imageCdn.tataplay) && Intrinsics.areEqual(this.app, imageCdn.app) && Intrinsics.areEqual(this.playback, imageCdn.playback) && Intrinsics.areEqual(this.logo, imageCdn.logo) && Intrinsics.areEqual(this.sports, imageCdn.sports) && Intrinsics.areEqual(this.bgImage, imageCdn.bgImage) && Intrinsics.areEqual(this.sportByImage, imageCdn.sportByImage) && Intrinsics.areEqual(this.cloudfare, imageCdn.cloudfare);
    }

    public int hashCode() {
        return (((((((((((((this.tataplay.hashCode() * 31) + this.app.hashCode()) * 31) + (this.playback == null ? 0 : this.playback.hashCode())) * 31) + this.logo.hashCode()) * 31) + this.sports.hashCode()) * 31) + this.bgImage.hashCode()) * 31) + this.sportByImage.hashCode()) * 31) + (this.cloudfare != null ? this.cloudfare.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ImageCdn(tataplay=" + this.tataplay + ", app=" + this.app + ", playback=" + this.playback + ", logo=" + this.logo + ", sports=" + this.sports + ", bgImage=" + this.bgImage + ", sportByImage=" + this.sportByImage + ", cloudfare=" + this.cloudfare + ')';
    }

    public ImageCdn(@JsonProperty("TATAPLAY") @NotNull String tataplay, @JsonProperty("APP") @NotNull String app, @JsonProperty("PLAYBACK") @Nullable String playback, @JsonProperty("LOGO") @NotNull String logo, @JsonProperty("SPORTS") @NotNull String sports, @JsonProperty("BG_IMAGE") @NotNull String bgImage, @JsonProperty("SPORT_BY_IMAGE") @NotNull String sportByImage, @JsonProperty("CLOUDFARE") @Nullable String cloudfare) {
        this.tataplay = tataplay;
        this.app = app;
        this.playback = playback;
        this.logo = logo;
        this.sports = sports;
        this.bgImage = bgImage;
        this.sportByImage = sportByImage;
        this.cloudfare = cloudfare;
    }

    @NotNull
    public final String getTataplay() {
        return this.tataplay;
    }

    @NotNull
    public final String getApp() {
        return this.app;
    }

    @Nullable
    public final String getPlayback() {
        return this.playback;
    }

    @NotNull
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getSports() {
        return this.sports;
    }

    @NotNull
    public final String getBgImage() {
        return this.bgImage;
    }

    @NotNull
    public final String getSportByImage() {
        return this.sportByImage;
    }

    @Nullable
    public final String getCloudfare() {
        return this.cloudfare;
    }
}
