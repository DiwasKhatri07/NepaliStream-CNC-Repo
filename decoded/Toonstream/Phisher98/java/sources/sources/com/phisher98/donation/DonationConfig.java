package com.phisher98.donation;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: DonationData.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Toonstream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b4\b\u0086\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u000bHÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\u009f\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0005HÆ\u0001J\u0014\u0010=\u001a\u00020\u00032\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010?\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010@\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010*\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b+\u0010#R\u0011\u0010,\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\u0018¨\u0006B"}, d2 = {"Lcom/phisher98/donation/DonationConfig;", "", "enabled", "", "extensionName", "", "month", "title", "description", "currency", "targetAmount", "", "currentAmount", "supportersCount", "", "primaryDonateUrl", "primaryButtonText", "secondaryDonateUrl", "secondaryButtonText", "cooldownHours", "cooldownScope", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getEnabled", "()Z", "getExtensionName", "()Ljava/lang/String;", "getMonth", "getTitle", "getDescription", "getCurrency", "getTargetAmount", "()D", "getCurrentAmount", "getSupportersCount", "()I", "getPrimaryDonateUrl", "getPrimaryButtonText", "getSecondaryDonateUrl", "getSecondaryButtonText", "getCooldownHours", "getCooldownScope", "progressPercentage", "getProgressPercentage", "isGoalAchieved", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "Companion", "Toonstream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class DonationConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int cooldownHours;

    @NotNull
    private final String cooldownScope;

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
        this(false, null, null, null, null, null, 0.0d, 0.0d, 0, null, null, null, null, 0, null, 32767, null);
    }

    public static /* synthetic */ DonationConfig copy$default(DonationConfig donationConfig, boolean z, String str, String str2, String str3, String str4, String str5, double d, double d2, int i, String str6, String str7, String str8, String str9, int i2, String str10, int i3, Object obj) {
        boolean z2 = (i3 & 1) != 0 ? donationConfig.enabled : z;
        return donationConfig.copy(z2, (i3 & 2) != 0 ? donationConfig.extensionName : str, (i3 & 4) != 0 ? donationConfig.month : str2, (i3 & 8) != 0 ? donationConfig.title : str3, (i3 & 16) != 0 ? donationConfig.description : str4, (i3 & 32) != 0 ? donationConfig.currency : str5, (i3 & 64) != 0 ? donationConfig.targetAmount : d, (i3 & 128) != 0 ? donationConfig.currentAmount : d2, (i3 & 256) != 0 ? donationConfig.supportersCount : i, (i3 & 512) != 0 ? donationConfig.primaryDonateUrl : str6, (i3 & 1024) != 0 ? donationConfig.primaryButtonText : str7, (i3 & 2048) != 0 ? donationConfig.secondaryDonateUrl : str8, (i3 & 4096) != 0 ? donationConfig.secondaryButtonText : str9, (i3 & 8192) != 0 ? donationConfig.cooldownHours : i2, (i3 & 16384) != 0 ? donationConfig.cooldownScope : str10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPrimaryDonateUrl() {
        return this.primaryDonateUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPrimaryButtonText() {
        return this.primaryButtonText;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getSecondaryDonateUrl() {
        return this.secondaryDonateUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSecondaryButtonText() {
        return this.secondaryButtonText;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getCooldownHours() {
        return this.cooldownHours;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getCooldownScope() {
        return this.cooldownScope;
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
    public final DonationConfig copy(boolean enabled, @NotNull String extensionName, @NotNull String month, @NotNull String title, @NotNull String description, @NotNull String currency, double targetAmount, double currentAmount, int supportersCount, @NotNull String primaryDonateUrl, @NotNull String primaryButtonText, @NotNull String secondaryDonateUrl, @NotNull String secondaryButtonText, int cooldownHours, @NotNull String cooldownScope) {
        return new DonationConfig(enabled, extensionName, month, title, description, currency, targetAmount, currentAmount, supportersCount, primaryDonateUrl, primaryButtonText, secondaryDonateUrl, secondaryButtonText, cooldownHours, cooldownScope);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DonationConfig)) {
            return false;
        }
        DonationConfig donationConfig = (DonationConfig) other;
        return this.enabled == donationConfig.enabled && Intrinsics.areEqual(this.extensionName, donationConfig.extensionName) && Intrinsics.areEqual(this.month, donationConfig.month) && Intrinsics.areEqual(this.title, donationConfig.title) && Intrinsics.areEqual(this.description, donationConfig.description) && Intrinsics.areEqual(this.currency, donationConfig.currency) && Double.compare(this.targetAmount, donationConfig.targetAmount) == 0 && Double.compare(this.currentAmount, donationConfig.currentAmount) == 0 && this.supportersCount == donationConfig.supportersCount && Intrinsics.areEqual(this.primaryDonateUrl, donationConfig.primaryDonateUrl) && Intrinsics.areEqual(this.primaryButtonText, donationConfig.primaryButtonText) && Intrinsics.areEqual(this.secondaryDonateUrl, donationConfig.secondaryDonateUrl) && Intrinsics.areEqual(this.secondaryButtonText, donationConfig.secondaryButtonText) && this.cooldownHours == donationConfig.cooldownHours && Intrinsics.areEqual(this.cooldownScope, donationConfig.cooldownScope);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((DonationConfig$$ExternalSyntheticBackport0.m4m(this.enabled) * 31) + this.extensionName.hashCode()) * 31) + this.month.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.currency.hashCode()) * 31) + DonationConfig$$ExternalSyntheticBackport1.m5m(this.targetAmount)) * 31) + DonationConfig$$ExternalSyntheticBackport1.m5m(this.currentAmount)) * 31) + this.supportersCount) * 31) + this.primaryDonateUrl.hashCode()) * 31) + this.primaryButtonText.hashCode()) * 31) + this.secondaryDonateUrl.hashCode()) * 31) + this.secondaryButtonText.hashCode()) * 31) + this.cooldownHours) * 31) + this.cooldownScope.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DonationConfig(enabled=").append(this.enabled).append(", extensionName=").append(this.extensionName).append(", month=").append(this.month).append(", title=").append(this.title).append(", description=").append(this.description).append(", currency=").append(this.currency).append(", targetAmount=").append(this.targetAmount).append(", currentAmount=").append(this.currentAmount).append(", supportersCount=").append(this.supportersCount).append(", primaryDonateUrl=").append(this.primaryDonateUrl).append(", primaryButtonText=").append(this.primaryButtonText).append(", secondaryDonateUrl=");
        sb.append(this.secondaryDonateUrl).append(", secondaryButtonText=").append(this.secondaryButtonText).append(", cooldownHours=").append(this.cooldownHours).append(", cooldownScope=").append(this.cooldownScope).append(')');
        return sb.toString();
    }

    public DonationConfig(boolean enabled, @NotNull String extensionName, @NotNull String month, @NotNull String title, @NotNull String description, @NotNull String currency, double targetAmount, double currentAmount, int supportersCount, @NotNull String primaryDonateUrl, @NotNull String primaryButtonText, @NotNull String secondaryDonateUrl, @NotNull String secondaryButtonText, int cooldownHours, @NotNull String cooldownScope) {
        this.enabled = enabled;
        this.extensionName = extensionName;
        this.month = month;
        this.title = title;
        this.description = description;
        this.currency = currency;
        this.targetAmount = targetAmount;
        this.currentAmount = currentAmount;
        this.supportersCount = supportersCount;
        this.primaryDonateUrl = primaryDonateUrl;
        this.primaryButtonText = primaryButtonText;
        this.secondaryDonateUrl = secondaryDonateUrl;
        this.secondaryButtonText = secondaryButtonText;
        this.cooldownHours = cooldownHours;
        this.cooldownScope = cooldownScope;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DonationConfig(boolean z, String str, String str2, String str3, String str4, String str5, double d, double d2, int i, String str6, String str7, String str8, String str9, int i2, String str10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z2 = (i3 & 1) != 0 ? true : z;
        String str11 = (i3 & 2) != 0 ? "" : str;
        String str12 = (i3 & 4) != 0 ? "Monthly Goal" : str2;
        String str13 = (i3 & 8) != 0 ? "Help Keep This Extension Alive" : str3;
        String str14 = (i3 & 16) != 0 ? "" : str4;
        String str15 = (i3 & 32) != 0 ? "$" : str5;
        double d3 = (i3 & 64) != 0 ? 100.0d : d;
        double d4 = (i3 & 128) != 0 ? 0.0d : d2;
        int i4 = (i3 & 256) != 0 ? 0 : i;
        String str16 = (i3 & 512) != 0 ? "https://buymeacoffee.com/phisher98" : str6;
        String str17 = (i3 & 1024) != 0 ? "☕ Keep It Alive" : str7;
        String str18 = (i3 & 2048) == 0 ? str8 : "";
        this(z2, str11, str12, str13, str14, str15, d3, d4, i4, str16, str17, str18, (i3 & 4096) != 0 ? "⚡ Donate via UPI / Other" : str9, (i3 & 8192) != 0 ? 24 : i2, (i3 & 16384) != 0 ? "global" : str10);
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

    public final int getCooldownHours() {
        return this.cooldownHours;
    }

    @NotNull
    public final String getCooldownScope() {
        return this.cooldownScope;
    }

    public final int getProgressPercentage() {
        if (this.targetAmount > 0.0d) {
            return RangesKt.coerceIn((int) ((this.currentAmount / this.targetAmount) * 100.0d), 0, 100);
        }
        return 0;
    }

    public final boolean isGoalAchieved() {
        return this.targetAmount > 0.0d && this.currentAmount >= this.targetAmount;
    }

    /* JADX INFO: compiled from: DonationData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/phisher98/donation/DonationConfig$Companion;", "", "<init>", "()V", "fromJson", "Lcom/phisher98/donation/DonationConfig;", "jsonStr", "", "Toonstream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final DonationConfig fromJson(@NotNull String jsonStr) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                try {
                    JSONObject json = new JSONObject(jsonStr);
                    obj = Result.constructor-impl(new DonationConfig(json.optBoolean("enabled", true), null, json.optString("month", "Monthly Goal"), json.optString("title", "Help Keep This Extension Alive"), json.optString("description", "Help keep our extensions fast, ad-free, and updated!"), json.optString("currency", "$"), json.optDouble("target_amount", 100.0d), json.optDouble("current_amount", 0.0d), json.optInt("supporters_count", 0), json.optString("primary_donate_url", ""), json.optString("primary_button_text", "☕ Keep It Alive"), json.optString("secondary_donate_url", ""), json.optString("secondary_button_text", "⚡ Donate via UPI / Other"), json.optInt("cooldown_hours", 24), json.optString("cooldown_scope", "global"), 2, null));
                } catch (Throwable th) {
                    th = th;
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            return (DonationConfig) obj;
        }
    }
}
