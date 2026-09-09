package com.cncverse.donation;

import android.util.Base64;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DonationData.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Watch32/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b:\b\u0086\b\u0018\u0000 G2\u00020\u0001:\u0001GB±\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u000eHÆ\u0003J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u000eHÆ\u0003J³\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u000eHÆ\u0001J\u0014\u0010C\u001a\u00020\u00032\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010E\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010F\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010.\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b/\u0010%R\u0011\u00100\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u001a¨\u0006H"}, d2 = {"Lcom/cncverse/donation/DonationConfig;", "", "enabled", "", "extensionName", "", "month", "title", "description", "currency", "targetAmount", "", "currentAmount", "supportersCount", "", "apiPercent", "primaryDonateUrl", "primaryButtonText", "secondaryDonateUrl", "secondaryButtonText", "adSupportUrl", "adSupportButtonText", "cooldownHours", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEnabled", "()Z", "getExtensionName", "()Ljava/lang/String;", "getMonth", "getTitle", "getDescription", "getCurrency", "getTargetAmount", "()D", "getCurrentAmount", "getSupportersCount", "()I", "getApiPercent", "getPrimaryDonateUrl", "getPrimaryButtonText", "getSecondaryDonateUrl", "getSecondaryButtonText", "getAdSupportUrl", "getAdSupportButtonText", "getCooldownHours", "progressPercentage", "getProgressPercentage", "isGoalAchieved", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "Companion", "Watch32_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DonationConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @NotNull
    private final String adSupportButtonText;

    @NotNull
    private final String adSupportUrl;
    private final int apiPercent;
    private final int cooldownHours;

    @NotNull
    private final String currency;
    private final double currentAmount;

    @NotNull
    private final String description;
    private final boolean enabled;

    @NotNull
    private final String extensionName;

    @NotNull
    private final String month;

    @NotNull
    private final String primaryButtonText;

    @NotNull
    private final String primaryDonateUrl;

    @NotNull
    private final String secondaryButtonText;

    @NotNull
    private final String secondaryDonateUrl;
    private final int supportersCount;
    private final double targetAmount;

    @NotNull
    private final String title;

    public DonationConfig() {
        this(false, null, null, null, null, null, 0.0d, 0.0d, 0, 0, null, null, null, null, null, null, 0, 131071, null);
    }

    public static /* synthetic */ DonationConfig copy$default(DonationConfig donationConfig, boolean z, String str, String str2, String str3, String str4, String str5, double d, double d2, int i, int i2, String str6, String str7, String str8, String str9, String str10, String str11, int i3, int i4, Object obj) {
        int i5;
        String str12;
        boolean z2 = (i4 & 1) != 0 ? donationConfig.enabled : z;
        String str13 = (i4 & 2) != 0 ? donationConfig.extensionName : str;
        String str14 = (i4 & 4) != 0 ? donationConfig.month : str2;
        String str15 = (i4 & 8) != 0 ? donationConfig.title : str3;
        String str16 = (i4 & 16) != 0 ? donationConfig.description : str4;
        String str17 = (i4 & 32) != 0 ? donationConfig.currency : str5;
        double d3 = (i4 & 64) != 0 ? donationConfig.targetAmount : d;
        double d4 = (i4 & 128) != 0 ? donationConfig.currentAmount : d2;
        int i6 = (i4 & 256) != 0 ? donationConfig.supportersCount : i;
        int i7 = (i4 & 512) != 0 ? donationConfig.apiPercent : i2;
        String str18 = (i4 & 1024) != 0 ? donationConfig.primaryDonateUrl : str6;
        String str19 = (i4 & 2048) != 0 ? donationConfig.primaryButtonText : str7;
        boolean z3 = z2;
        String str20 = (i4 & 4096) != 0 ? donationConfig.secondaryDonateUrl : str8;
        String str21 = (i4 & 8192) != 0 ? donationConfig.secondaryButtonText : str9;
        String str22 = (i4 & 16384) != 0 ? donationConfig.adSupportUrl : str10;
        String str23 = (i4 & 32768) != 0 ? donationConfig.adSupportButtonText : str11;
        if ((i4 & 65536) != 0) {
            str12 = str23;
            i5 = donationConfig.cooldownHours;
        } else {
            i5 = i3;
            str12 = str23;
        }
        return donationConfig.copy(z3, str13, str14, str15, str16, str17, d3, d4, i6, i7, str18, str19, str20, str21, str22, str12, i5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getApiPercent() {
        return this.apiPercent;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPrimaryDonateUrl() {
        return this.primaryDonateUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getPrimaryButtonText() {
        return this.primaryButtonText;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSecondaryDonateUrl() {
        return this.secondaryDonateUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getSecondaryButtonText() {
        return this.secondaryButtonText;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getAdSupportUrl() {
        return this.adSupportUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getAdSupportButtonText() {
        return this.adSupportButtonText;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getCooldownHours() {
        return this.cooldownHours;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getExtensionName() {
        return this.extensionName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMonth() {
        return this.month;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final double getTargetAmount() {
        return this.targetAmount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final double getCurrentAmount() {
        return this.currentAmount;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getSupportersCount() {
        return this.supportersCount;
    }

    @NotNull
    public final DonationConfig copy(boolean enabled, @NotNull String extensionName, @NotNull String month, @NotNull String title, @NotNull String description, @NotNull String currency, double targetAmount, double currentAmount, int supportersCount, int apiPercent, @NotNull String primaryDonateUrl, @NotNull String primaryButtonText, @NotNull String secondaryDonateUrl, @NotNull String secondaryButtonText, @NotNull String adSupportUrl, @NotNull String adSupportButtonText, int cooldownHours) {
        return new DonationConfig(enabled, extensionName, month, title, description, currency, targetAmount, currentAmount, supportersCount, apiPercent, primaryDonateUrl, primaryButtonText, secondaryDonateUrl, secondaryButtonText, adSupportUrl, adSupportButtonText, cooldownHours);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DonationConfig)) {
            return false;
        }
        DonationConfig donationConfig = (DonationConfig) other;
        return this.enabled == donationConfig.enabled && Intrinsics.areEqual(this.extensionName, donationConfig.extensionName) && Intrinsics.areEqual(this.month, donationConfig.month) && Intrinsics.areEqual(this.title, donationConfig.title) && Intrinsics.areEqual(this.description, donationConfig.description) && Intrinsics.areEqual(this.currency, donationConfig.currency) && Double.compare(this.targetAmount, donationConfig.targetAmount) == 0 && Double.compare(this.currentAmount, donationConfig.currentAmount) == 0 && this.supportersCount == donationConfig.supportersCount && this.apiPercent == donationConfig.apiPercent && Intrinsics.areEqual(this.primaryDonateUrl, donationConfig.primaryDonateUrl) && Intrinsics.areEqual(this.primaryButtonText, donationConfig.primaryButtonText) && Intrinsics.areEqual(this.secondaryDonateUrl, donationConfig.secondaryDonateUrl) && Intrinsics.areEqual(this.secondaryButtonText, donationConfig.secondaryButtonText) && Intrinsics.areEqual(this.adSupportUrl, donationConfig.adSupportUrl) && Intrinsics.areEqual(this.adSupportButtonText, donationConfig.adSupportButtonText) && this.cooldownHours == donationConfig.cooldownHours;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((DonationConfig$$ExternalSyntheticBackport0.m2m(this.enabled) * 31) + this.extensionName.hashCode()) * 31) + this.month.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.currency.hashCode()) * 31) + DonationConfig$$ExternalSyntheticBackport1.m3m(this.targetAmount)) * 31) + DonationConfig$$ExternalSyntheticBackport1.m3m(this.currentAmount)) * 31) + this.supportersCount) * 31) + this.apiPercent) * 31) + this.primaryDonateUrl.hashCode()) * 31) + this.primaryButtonText.hashCode()) * 31) + this.secondaryDonateUrl.hashCode()) * 31) + this.secondaryButtonText.hashCode()) * 31) + this.adSupportUrl.hashCode()) * 31) + this.adSupportButtonText.hashCode()) * 31) + this.cooldownHours;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DonationConfig(enabled=").append(this.enabled).append(", extensionName=").append(this.extensionName).append(", month=").append(this.month).append(", title=").append(this.title).append(", description=").append(this.description).append(", currency=").append(this.currency).append(", targetAmount=").append(this.targetAmount).append(", currentAmount=").append(this.currentAmount).append(", supportersCount=").append(this.supportersCount).append(", apiPercent=").append(this.apiPercent).append(", primaryDonateUrl=").append(this.primaryDonateUrl).append(", primaryButtonText=");
        sb.append(this.primaryButtonText).append(", secondaryDonateUrl=").append(this.secondaryDonateUrl).append(", secondaryButtonText=").append(this.secondaryButtonText).append(", adSupportUrl=").append(this.adSupportUrl).append(", adSupportButtonText=").append(this.adSupportButtonText).append(", cooldownHours=").append(this.cooldownHours).append(')');
        return sb.toString();
    }

    public DonationConfig(boolean enabled, @NotNull String extensionName, @NotNull String month, @NotNull String title, @NotNull String description, @NotNull String currency, double targetAmount, double currentAmount, int supportersCount, int apiPercent, @NotNull String primaryDonateUrl, @NotNull String primaryButtonText, @NotNull String secondaryDonateUrl, @NotNull String secondaryButtonText, @NotNull String adSupportUrl, @NotNull String adSupportButtonText, int cooldownHours) {
        this.enabled = enabled;
        this.extensionName = extensionName;
        this.month = month;
        this.title = title;
        this.description = description;
        this.currency = currency;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.supportersCount = supportersCount;
        this.apiPercent = apiPercent;
        this.primaryDonateUrl = primaryDonateUrl;
        this.primaryButtonText = primaryButtonText;
        this.secondaryDonateUrl = secondaryDonateUrl;
        this.secondaryButtonText = secondaryButtonText;
        this.adSupportUrl = adSupportUrl;
        this.adSupportButtonText = adSupportButtonText;
        this.cooldownHours = cooldownHours;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DonationConfig(boolean z, String str, String str2, String str3, String str4, String str5, double d, double d2, int i, int i2, String str6, String str7, String str8, String str9, String str10, String str11, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z2 = (i4 & 1) != 0 ? true : z;
        String str12 = (i4 & 2) != 0 ? "" : str;
        String str13 = (i4 & 4) != 0 ? "Monthly Goal" : str2;
        String str14 = (i4 & 8) != 0 ? "Help Keep CNCVerse Alive" : str3;
        String str15 = (i4 & 16) != 0 ? "" : str4;
        String str16 = (i4 & 32) != 0 ? "$" : str5;
        double dDynamicTargetAmount = (i4 & 64) != 0 ? INSTANCE.dynamicTargetAmount() : d;
        double d3 = (i4 & 128) != 0 ? 0.0d : d2;
        int i5 = (i4 & 256) != 0 ? 0 : i;
        int i6 = (i4 & 512) != 0 ? -1 : i2;
        String str17 = (i4 & 1024) != 0 ? "https://cncverse.pages.dev" : str6;
        String str18 = (i4 & 2048) != 0 ? "☕ Keep It Alive" : str7;
        boolean z3 = z2;
        String str19 = (i4 & 4096) == 0 ? str8 : "";
        this(z3, str12, str13, str14, str15, str16, dDynamicTargetAmount, d3, i5, i6, str17, str18, str19, (i4 & 8192) != 0 ? "⚡ Donate via UPI / Other" : str9, (i4 & 16384) != 0 ? INSTANCE.decodeOmg10() : str10, (i4 & 32768) != 0 ? "🎬 Can't donate? Watch an Ad to Support ↗" : str11, (i4 & 65536) != 0 ? 24 : i3);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    public final String getExtensionName() {
        return this.extensionName;
    }

    @NotNull
    public final String getMonth() {
        return this.month;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getCurrency() {
        return this.currency;
    }

    public final double getTargetAmount() {
        return this.targetAmount;
    }

    public final double getCurrentAmount() {
        return this.currentAmount;
    }

    public final int getSupportersCount() {
        return this.supportersCount;
    }

    public final int getApiPercent() {
        return this.apiPercent;
    }

    @NotNull
    public final String getPrimaryDonateUrl() {
        return this.primaryDonateUrl;
    }

    @NotNull
    public final String getPrimaryButtonText() {
        return this.primaryButtonText;
    }

    @NotNull
    public final String getSecondaryDonateUrl() {
        return this.secondaryDonateUrl;
    }

    @NotNull
    public final String getSecondaryButtonText() {
        return this.secondaryButtonText;
    }

    @NotNull
    public final String getAdSupportUrl() {
        return this.adSupportUrl;
    }

    @NotNull
    public final String getAdSupportButtonText() {
        return this.adSupportButtonText;
    }

    public final int getCooldownHours() {
        return this.cooldownHours;
    }

    public final int getProgressPercentage() {
        int i = this.apiPercent;
        if (i >= 0 && i < 101) {
            return this.apiPercent;
        }
        if (this.targetAmount <= 0.0d) {
            return 0;
        }
        return RangesKt.coerceIn((int) ((this.currentAmount / this.targetAmount) * ((double) 100)), 0, 100);
    }

    public final boolean isGoalAchieved() {
        return getProgressPercentage() >= 100;
    }

    /* JADX INFO: compiled from: DonationData.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/cncverse/donation/DonationConfig$Companion;", "", "<init>", "()V", "OMG10", "", "decodeOmg10", "dynamicTargetAmount", "", "Watch32_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String decodeOmg10() {
            try {
                return StringsKt.trim(new String(Base64.decode(DonationConfig.OMG10, 0), Charsets.UTF_8)).toString();
            } catch (Exception e) {
                return "";
            }
        }

        public final double dynamicTargetAmount() {
            Calendar cal = Calendar.getInstance();
            int y = cal.get(1);
            int m = cal.get(2);
            return (y > 2026 || (y == 2026 && m >= 9)) ? 200.0d : 100.0d;
        }
    }
}
