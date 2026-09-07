package com.phisher98.donation;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainAPIKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DonationManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MassTamilanProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0002J\u0018\u0010I\u001a\u00020\u00052\u0006\u0010G\u001a\u00020H2\u0006\u0010J\u001a\u00020\u0013H\u0002J\u0018\u0010K\u001a\u00020L2\u0006\u0010G\u001a\u00020H2\u0006\u0010J\u001a\u00020\u0013H\u0002J\u0010\u0010M\u001a\u00020\u00052\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010N\u001a\u00020\u00052\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010O\u001a\u00020L2\u0006\u0010G\u001a\u00020HH\u0002J\u000e\u0010P\u001a\u00020L2\u0006\u0010G\u001a\u00020HJ\b\u0010Q\u001a\u00020\u0013H\u0002J\u0010\u0010R\u001a\u00020L2\b\b\u0002\u0010S\u001a\u00020\u0013J\u0018\u0010T\u001a\u00020L2\u0006\u0010U\u001a\u00020V2\b\b\u0002\u0010S\u001a\u00020\u0013J$\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u000206\u0018\u00010X2\u0006\u0010Y\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010ZR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001a\u0010&\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010)\u001a\u00020\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001a\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001a\u0010/\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001a\u00102\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/phisher98/donation/DonationManager;", "", "<init>", "()V", "testMode", "", "getTestMode", "()Z", "setTestMode", "(Z)V", "testProgressAmount", "", "getTestProgressAmount", "()D", "setTestProgressAmount", "(D)V", "isDialogShowing", "setDialogShowing", "OBFUSCATED_TOKEN", "", "getDecryptedBmcToken", "primaryDonateUrl", "getPrimaryDonateUrl", "()Ljava/lang/String;", "setPrimaryDonateUrl", "(Ljava/lang/String;)V", "primaryButtonText", "getPrimaryButtonText", "setPrimaryButtonText", "secondaryDonateUrl", "getSecondaryDonateUrl", "setSecondaryDonateUrl", "secondaryButtonText", "getSecondaryButtonText", "setSecondaryButtonText", "adSupportUrl", "getAdSupportUrl", "setAdSupportUrl", "adSupportButtonText", "getAdSupportButtonText", "setAdSupportButtonText", "targetAmount", "getTargetAmount", "setTargetAmount", "currency", "getCurrency", "setCurrency", "goalTitle", "getGoalTitle", "setGoalTitle", "goalDescription", "getGoalDescription", "setGoalDescription", "cooldownHours", "", "getCooldownHours", "()I", "setCooldownHours", "(I)V", "PREFS_NAME", "KEY_LAST_SHOWN", "KEY_ACHIEVED_SHOWN_MONTH", "KEY_CACHED_MONTH", "KEY_CACHED_AMOUNT", "KEY_CACHED_SUPPORTERS", "DIALOG_TAG", "gateLock", "lastTriggerTime", "", "getPrefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "hasShownAchievedThisMonth", "currentMonth", "recordAchievedShown", "", "isGoalReachedThisMonth", "isCooldownActive", "recordShown", "resetCooldown", "getCurrentMonthName", "checkAndShow", "providerName", "showNow", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "fetchBuyMeACoffeeMonthly", "Lkotlin/Pair;", "accessToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MassTamilanProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,489:1\n40#2,11:490\n40#2,11:501\n40#2,11:512\n1#3:523\n*S KotlinDebug\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager\n*L\n120#1:490,11\n150#1:501,11\n157#1:512,11\n*E\n"})
public final class DonationManager {

    @NotNull
    private static final String DIALOG_TAG = "phisher_donation_floating_dialog";

    @NotNull
    private static final String KEY_ACHIEVED_SHOWN_MONTH = "phisher_donation_achieved_shown_month";

    @NotNull
    private static final String KEY_CACHED_AMOUNT = "phisher_donation_cached_amount";

    @NotNull
    private static final String KEY_CACHED_MONTH = "phisher_donation_cached_month";

    @NotNull
    private static final String KEY_CACHED_SUPPORTERS = "phisher_donation_cached_supporters";

    @NotNull
    private static final String KEY_LAST_SHOWN = "phisher_donation_last_shown_v2";

    @NotNull
    private static final String OBFUSCATED_TOKEN = "FREjQw09MzYsBSU+MkIlGykiJzcAKgA2JAwzDGdKewc+ASNKRgALFQsIOCQNPB07UCw5Flc3JxYcKDpuWWlmUhskPSECPEASFyM4JB4pN0JULikeUiA3Cls/LThLfVhvGSQqORkBNTQKIwY/CD4eJ1E7BzMJIDQWHCgTN1p+AHgYJy02Eio2BQs1ODsOPUYgDS8pHhggDg4RKxMKSGpfcBklEzpdKzUJDiEFFh49GSNUOwcOUTckEhIqLRVefl9nCTEDKlwqJhpTNjgjDD4wGR84XwZRNzAWGCwUM1pUcX9GJT0QXCo2BlYhFTRXPh0FDAMAFQ8kCTATKwM4Bn5YXQolLRARKTEVDwknNA08HjdRLCkOGCAZGlsrAxpBeVx4QTEAOl4sGDQbISseUT4OPwwtLhUYNFFmHD8hElt/XkUZCwQlAD8xbhUOAg1ROhhDXE8qNwonFT0mJ0o2AAB4f10lXkIBAxoWEiMJFAIiPB4dOAptCxwMGzMIEiVCdV1sEh09MQ41PGo2A102XR8xJicUHgcpIiEQOAM3HlFvX1glARsrHQA7FigOMEAPKzA7MigrCltYIAU7Az8QUQFBckQZJyw8FkU9DD0IPw8APy0HOD8xKzUOEQ0/AS5eQHpzRCpcPDwHJyhSKFhNIhADNywjJx0uGTwJOS4WawcFd31dHz86WitKPjY7DRsGKUZADDMFMSw9JQwsNwxsVUcKfRoHJBlFVCoSCA0JLCsFA0UtUxg4NwlQbz4gDBxtRgpcAzBYHCc2Nm05Hw0PVTY3PwhXITEaI1cpXVEMCFVdB28EPw9GLRwVMCtVJywAJCMcSDgpaggeDzYzCB1sXGNZZQEnMT0NDyAGLTpfMkk6EQsxPi4QCjw3bgQ1VBxYdVFHPDskCSMUAgpTBgw0ACUsQTAkXjISBSRvLhEVcgt9RXsDIhgGLgQZGFc+DTw1Ghg6ESIMNANbDzMICzILAEUKYEYePTQdDDFsGiEaRjUCIUMdDikmIQAPazE9Cy9eUgB8XQ4INF4LQBRQKAYnCUYCBzpXODoHBTUSOQ0MPAEIZnIfLltEHyohBVUrISAXJ0xDSAJbLDg1KwYlAzYxf1VCZxocXBo7CxATOxQOOhE3IyIXIDIsOjUvBSEzAWlme0hTKkU5PxEkAxkWJjdMDitHOx00LwckPjEdGSsBLmZgS0wyRQAUKyktFiI+BD4tPRY6FA5ZJyw+IC8SKUEddwJfXAlYLEoANAIvEQYpPFEcWTkyMxcSJDU5FSArE2taB0VuHSI7FSI8OREBLVslNgtDOyQ+BCkTDBJnUyQbOXlUWEc4PVwhXVE+LAw5KgwhAUEWVSscGQAMJwpcMCYlcw==";

    @NotNull
    private static final String PREFS_NAME = "phisher_donation_prefs";
    private static volatile boolean isDialogShowing;
    private static volatile long lastTriggerTime;
    private static boolean testMode;
    private static double testProgressAmount;

    @NotNull
    public static final DonationManager INSTANCE = new DonationManager();

    @NotNull
    private static String primaryDonateUrl = "https://buymeacoffee.com/phisher98";

    @NotNull
    private static String primaryButtonText = "☕ Keep It Alive";

    @NotNull
    private static String secondaryDonateUrl = "";

    @NotNull
    private static String secondaryButtonText = "⚡ Donate via UPI / Other";

    @NotNull
    private static String adSupportUrl = "https://omg10.com/4/11733824";

    @NotNull
    private static String adSupportButtonText = "🎬 Can't donate? Watch an Ad to Support ↗";
    private static double targetAmount = 100.0d;

    @NotNull
    private static String currency = "$";

    @NotNull
    private static String goalTitle = "Help Keep This Extension Alive";

    @NotNull
    private static String goalDescription = "Support us to keep this extension maintained! Reaching the goal means faster updates and active maintenance. If not, updates will be slow, and the extension could become dead over time.";
    private static int cooldownHours = 24;

    @NotNull
    private static final Object gateLock = new Object();

    /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$fetchBuyMeACoffeeMonthly$1 */
    /* JADX INFO: compiled from: DonationManager.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.donation.DonationManager", f = "DonationManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {415, 461}, m = "fetchBuyMeACoffeeMonthly", n = {"accessToken", "now", "monthTotal", "supportersCount", "dateFormat", "currentYear", "currentMonth", "page", "hasMore", "accessToken", "now", "monthTotal", "supportersCount", "dateFormat", "$this$fetchBuyMeACoffeeMonthly_u24lambda_u243", "currentYear", "currentMonth", "page", "hasMore"}, nl = {424, 470}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DonationManager.this.fetchBuyMeACoffeeMonthly(null, (Continuation) this);
        }
    }

    private DonationManager() {
    }

    public final boolean getTestMode() {
        return testMode;
    }

    public final void setTestMode(boolean z) {
        testMode = z;
    }

    public final double getTestProgressAmount() {
        return testProgressAmount;
    }

    public final void setTestProgressAmount(double d) {
        testProgressAmount = d;
    }

    public final boolean isDialogShowing() {
        return isDialogShowing;
    }

    public final void setDialogShowing(boolean z) {
        isDialogShowing = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDecryptedBmcToken() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DonationManager donationManager = this;
            byte[] salt = "phisher_cloudstream_bmc_key_2026".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(salt, "getBytes(...)");
            byte[] bytes = MainAPIKt.base64DecodeArray(OBFUSCATED_TOKEN);
            byte[] result = new byte[bytes.length];
            int length = bytes.length;
            for (int i = 0; i < length; i++) {
                result[i] = (byte) (bytes[i] ^ salt[i % salt.length]);
            }
            obj = Result.constructor-impl(new String(result, Charsets.UTF_8));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = "";
        }
        return (String) obj;
    }

    @NotNull
    public final String getPrimaryDonateUrl() {
        return primaryDonateUrl;
    }

    public final void setPrimaryDonateUrl(@NotNull String str) {
        primaryDonateUrl = str;
    }

    @NotNull
    public final String getPrimaryButtonText() {
        return primaryButtonText;
    }

    public final void setPrimaryButtonText(@NotNull String str) {
        primaryButtonText = str;
    }

    @NotNull
    public final String getSecondaryDonateUrl() {
        return secondaryDonateUrl;
    }

    public final void setSecondaryDonateUrl(@NotNull String str) {
        secondaryDonateUrl = str;
    }

    @NotNull
    public final String getSecondaryButtonText() {
        return secondaryButtonText;
    }

    public final void setSecondaryButtonText(@NotNull String str) {
        secondaryButtonText = str;
    }

    @NotNull
    public final String getAdSupportUrl() {
        return adSupportUrl;
    }

    public final void setAdSupportUrl(@NotNull String str) {
        adSupportUrl = str;
    }

    @NotNull
    public final String getAdSupportButtonText() {
        return adSupportButtonText;
    }

    public final void setAdSupportButtonText(@NotNull String str) {
        adSupportButtonText = str;
    }

    public final void setTargetAmount(double d) {
        targetAmount = d;
    }

    public final double getTargetAmount() {
        try {
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            int year = cal.get(1);
            int month = cal.get(2);
            if (year > 2026 || (year == 2026 && month >= 9)) {
                return 200.0d;
            }
            return 100.0d;
        } catch (Throwable th) {
            return targetAmount;
        }
    }

    @NotNull
    public final String getCurrency() {
        return currency;
    }

    public final void setCurrency(@NotNull String str) {
        currency = str;
    }

    @NotNull
    public final String getGoalTitle() {
        return goalTitle;
    }

    public final void setGoalTitle(@NotNull String str) {
        goalTitle = str;
    }

    @NotNull
    public final String getGoalDescription() {
        return goalDescription;
    }

    public final void setGoalDescription(@NotNull String str) {
        goalDescription = str;
    }

    public final int getCooldownHours() {
        return cooldownHours;
    }

    public final void setCooldownHours(int i) {
        cooldownHours = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREFS_NAME, 0);
    }

    private final boolean hasShownAchievedThisMonth(Context context, String currentMonth) {
        if (testMode) {
            return false;
        }
        return Intrinsics.areEqual(getPrefs(context).getString(KEY_ACHIEVED_SHOWN_MONTH, ""), currentMonth);
    }

    private final void recordAchievedShown(Context context, String currentMonth) {
        SharedPreferences $this$edit$iv = getPrefs(context);
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putString(KEY_ACHIEVED_SHOWN_MONTH, currentMonth);
        editor$iv.apply();
    }

    private final boolean isGoalReachedThisMonth(Context context) {
        if (testProgressAmount > 0.0d || getTargetAmount() <= 0.0d) {
            return false;
        }
        SharedPreferences prefs = getPrefs(context);
        String string = prefs.getString(KEY_CACHED_MONTH, "");
        String cachedMonth = string != null ? string : "";
        String currentMonth = getCurrentMonthName();
        if (Intrinsics.areEqual(cachedMonth, currentMonth)) {
            double cachedAmount = prefs.getFloat(KEY_CACHED_AMOUNT, 0.0f);
            if (cachedAmount >= getTargetAmount()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCooldownActive(Context context) {
        if (testMode) {
            return false;
        }
        SharedPreferences prefs = getPrefs(context);
        long lastShown = prefs.getLong(KEY_LAST_SHOWN, 0L);
        if (lastShown <= 0) {
            return false;
        }
        long cooldownMillis = ((long) cooldownHours) * 60 * 60 * 1000;
        long elapsed = System.currentTimeMillis() - lastShown;
        return elapsed < cooldownMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordShown(Context context) {
        SharedPreferences $this$edit$iv = getPrefs(context);
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putLong(KEY_LAST_SHOWN, System.currentTimeMillis());
        editor$iv.apply();
    }

    public final void resetCooldown(@NotNull Context context) {
        SharedPreferences $this$edit$iv = getPrefs(context);
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.remove(KEY_LAST_SHOWN);
        editor$iv.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCurrentMonthName() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
        return format.format(cal.getTime());
    }

    public static /* synthetic */ void checkAndShow$default(DonationManager donationManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        donationManager.checkAndShow(str);
    }

    public final void checkAndShow(@NotNull String providerName) {
        Context context = CloudStreamApp.Companion.getContext();
        if (context == null) {
            Activity activity = CommonActivity.INSTANCE.getActivity();
            context = activity != null ? activity.getApplicationContext() : null;
            if (context == null) {
                return;
            }
        }
        Context appContext = context;
        String currentMonth = getCurrentMonthName();
        synchronized (gateLock) {
            long now = System.currentTimeMillis();
            if (now - lastTriggerTime >= 60000 && !INSTANCE.isCooldownActive(appContext)) {
                lastTriggerTime = now;
                Unit unit = Unit.INSTANCE;
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00062(appContext, providerName, currentMonth, null), 3, (Object) null);
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$checkAndShow$2 */
    /* JADX INFO: compiled from: DonationManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.donation.DonationManager$checkAndShow$2", f = "DonationManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {204, 254}, m = "invokeSuspend", n = {"prefs", "currentAmount", "supportersCount", "token", "prefs", "currentAmount", "supportersCount", "token", "dynamicTitle", "config", "isGoalAchieved"}, nl = {205, 289}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,489:1\n40#2,11:490\n*S KotlinDebug\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2\n*L\n210#1:490,11\n*E\n"})
    static final class C00062 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ String $currentMonth;
        final /* synthetic */ String $providerName;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(Context context, String str, String str2, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$appContext = context;
            this.$providerName = str;
            this.$currentMonth = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00062(this.$appContext, this.$providerName, this.$currentMonth, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x00a2 A[Catch: all -> 0x0246, TryCatch #0 {all -> 0x0246, blocks: (B:7:0x0033, B:10:0x0048, B:18:0x009e, B:20:0x00a2, B:24:0x00f2, B:26:0x00fe, B:28:0x010a, B:29:0x010d, B:31:0x0117, B:35:0x0126, B:37:0x0130, B:41:0x0138, B:44:0x0144, B:46:0x016b, B:51:0x019a, B:55:0x01ce, B:54:0x01c8, B:45:0x0158, B:47:0x0170, B:49:0x0178, B:50:0x0194, B:13:0x0052, B:15:0x0084), top: B:63:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:21:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:26:0x00fe A[Catch: all -> 0x0246, TryCatch #0 {all -> 0x0246, blocks: (B:7:0x0033, B:10:0x0048, B:18:0x009e, B:20:0x00a2, B:24:0x00f2, B:26:0x00fe, B:28:0x010a, B:29:0x010d, B:31:0x0117, B:35:0x0126, B:37:0x0130, B:41:0x0138, B:44:0x0144, B:46:0x016b, B:51:0x019a, B:55:0x01ce, B:54:0x01c8, B:45:0x0158, B:47:0x0170, B:49:0x0178, B:50:0x0194, B:13:0x0052, B:15:0x0084), top: B:63:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:28:0x010a A[Catch: all -> 0x0246, TryCatch #0 {all -> 0x0246, blocks: (B:7:0x0033, B:10:0x0048, B:18:0x009e, B:20:0x00a2, B:24:0x00f2, B:26:0x00fe, B:28:0x010a, B:29:0x010d, B:31:0x0117, B:35:0x0126, B:37:0x0130, B:41:0x0138, B:44:0x0144, B:46:0x016b, B:51:0x019a, B:55:0x01ce, B:54:0x01c8, B:45:0x0158, B:47:0x0170, B:49:0x0178, B:50:0x0194, B:13:0x0052, B:15:0x0084), top: B:63:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:34:0x0125  */
        /* JADX WARN: Code duplicated, block: B:37:0x0130 A[Catch: all -> 0x0246, TRY_LEAVE, TryCatch #0 {all -> 0x0246, blocks: (B:7:0x0033, B:10:0x0048, B:18:0x009e, B:20:0x00a2, B:24:0x00f2, B:26:0x00fe, B:28:0x010a, B:29:0x010d, B:31:0x0117, B:35:0x0126, B:37:0x0130, B:41:0x0138, B:44:0x0144, B:46:0x016b, B:51:0x019a, B:55:0x01ce, B:54:0x01c8, B:45:0x0158, B:47:0x0170, B:49:0x0178, B:50:0x0194, B:13:0x0052, B:15:0x0084), top: B:63:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:39:0x0133  */
        /* JADX WARN: Code duplicated, block: B:41:0x0138 A[Catch: all -> 0x0246, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0246, blocks: (B:7:0x0033, B:10:0x0048, B:18:0x009e, B:20:0x00a2, B:24:0x00f2, B:26:0x00fe, B:28:0x010a, B:29:0x010d, B:31:0x0117, B:35:0x0126, B:37:0x0130, B:41:0x0138, B:44:0x0144, B:46:0x016b, B:51:0x019a, B:55:0x01ce, B:54:0x01c8, B:45:0x0158, B:47:0x0170, B:49:0x0178, B:50:0x0194, B:13:0x0052, B:15:0x0084), top: B:63:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:44:0x0144 A[Catch: all -> 0x0246, TRY_ENTER, TryCatch #0 {all -> 0x0246, blocks: (B:7:0x0033, B:10:0x0048, B:18:0x009e, B:20:0x00a2, B:24:0x00f2, B:26:0x00fe, B:28:0x010a, B:29:0x010d, B:31:0x0117, B:35:0x0126, B:37:0x0130, B:41:0x0138, B:44:0x0144, B:46:0x016b, B:51:0x019a, B:55:0x01ce, B:54:0x01c8, B:45:0x0158, B:47:0x0170, B:49:0x0178, B:50:0x0194, B:13:0x0052, B:15:0x0084), top: B:63:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0158 A[Catch: all -> 0x0246, TryCatch #0 {all -> 0x0246, blocks: (B:7:0x0033, B:10:0x0048, B:18:0x009e, B:20:0x00a2, B:24:0x00f2, B:26:0x00fe, B:28:0x010a, B:29:0x010d, B:31:0x0117, B:35:0x0126, B:37:0x0130, B:41:0x0138, B:44:0x0144, B:46:0x016b, B:51:0x019a, B:55:0x01ce, B:54:0x01c8, B:45:0x0158, B:47:0x0170, B:49:0x0178, B:50:0x0194, B:13:0x0052, B:15:0x0084), top: B:63:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:47:0x0170 A[Catch: all -> 0x0246, TryCatch #0 {all -> 0x0246, blocks: (B:7:0x0033, B:10:0x0048, B:18:0x009e, B:20:0x00a2, B:24:0x00f2, B:26:0x00fe, B:28:0x010a, B:29:0x010d, B:31:0x0117, B:35:0x0126, B:37:0x0130, B:41:0x0138, B:44:0x0144, B:46:0x016b, B:51:0x019a, B:55:0x01ce, B:54:0x01c8, B:45:0x0158, B:47:0x0170, B:49:0x0178, B:50:0x0194, B:13:0x0052, B:15:0x0084), top: B:63:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:49:0x0178 A[Catch: all -> 0x0246, TryCatch #0 {all -> 0x0246, blocks: (B:7:0x0033, B:10:0x0048, B:18:0x009e, B:20:0x00a2, B:24:0x00f2, B:26:0x00fe, B:28:0x010a, B:29:0x010d, B:31:0x0117, B:35:0x0126, B:37:0x0130, B:41:0x0138, B:44:0x0144, B:46:0x016b, B:51:0x019a, B:55:0x01ce, B:54:0x01c8, B:45:0x0158, B:47:0x0170, B:49:0x0178, B:50:0x0194, B:13:0x0052, B:15:0x0084), top: B:63:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:50:0x0194 A[Catch: all -> 0x0246, TryCatch #0 {all -> 0x0246, blocks: (B:7:0x0033, B:10:0x0048, B:18:0x009e, B:20:0x00a2, B:24:0x00f2, B:26:0x00fe, B:28:0x010a, B:29:0x010d, B:31:0x0117, B:35:0x0126, B:37:0x0130, B:41:0x0138, B:44:0x0144, B:46:0x016b, B:51:0x019a, B:55:0x01ce, B:54:0x01c8, B:45:0x0158, B:47:0x0170, B:49:0x0178, B:50:0x0194, B:13:0x0052, B:15:0x0084), top: B:63:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:53:0x01c5  */
        /* JADX WARN: Code duplicated, block: B:54:0x01c8 A[Catch: all -> 0x0246, TryCatch #0 {all -> 0x0246, blocks: (B:7:0x0033, B:10:0x0048, B:18:0x009e, B:20:0x00a2, B:24:0x00f2, B:26:0x00fe, B:28:0x010a, B:29:0x010d, B:31:0x0117, B:35:0x0126, B:37:0x0130, B:41:0x0138, B:44:0x0144, B:46:0x016b, B:51:0x019a, B:55:0x01ce, B:54:0x01c8, B:45:0x0158, B:47:0x0170, B:49:0x0178, B:50:0x0194, B:13:0x0052, B:15:0x0084), top: B:63:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0240 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:58:0x0241  */
        public final Object invokeSuspend(Object $result) {
            SharedPreferences prefs;
            Ref.DoubleRef currentAmount;
            Ref.IntRef supportersCount;
            String token;
            String token2;
            Ref.IntRef supportersCount2;
            Ref.DoubleRef currentAmount2;
            SharedPreferences prefs2;
            Object objFetchBuyMeACoffeeMonthly;
            int i;
            String str;
            String goalTitle;
            DonationConfig config;
            String primaryButtonText;
            StringBuilder sbAppend;
            Pair bmcResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        prefs = DonationManager.INSTANCE.getPrefs(this.$appContext);
                        currentAmount = new Ref.DoubleRef();
                        currentAmount.element = prefs.getFloat(DonationManager.KEY_CACHED_AMOUNT, 0.0f);
                        supportersCount = new Ref.IntRef();
                        supportersCount.element = prefs.getInt(DonationManager.KEY_CACHED_SUPPORTERS, 0);
                        token = DonationManager.INSTANCE.getDecryptedBmcToken();
                        if (!StringsKt.isBlank(token)) {
                            this.L$0 = prefs;
                            this.L$1 = currentAmount;
                            this.L$2 = supportersCount;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(token);
                            this.label = 1;
                            objFetchBuyMeACoffeeMonthly = DonationManager.INSTANCE.fetchBuyMeACoffeeMonthly(token, (Continuation) this);
                            if (objFetchBuyMeACoffeeMonthly == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            bmcResult = (Pair) objFetchBuyMeACoffeeMonthly;
                            if (bmcResult != null) {
                                currentAmount.element = ((Number) bmcResult.getFirst()).doubleValue();
                                supportersCount.element = ((Number) bmcResult.getSecond()).intValue();
                                String str2 = this.$currentMonth;
                                SharedPreferences $this$edit$iv = prefs;
                                SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
                                Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
                                editor$iv.putString(DonationManager.KEY_CACHED_MONTH, str2).putFloat(DonationManager.KEY_CACHED_AMOUNT, (float) currentAmount.element).putInt(DonationManager.KEY_CACHED_SUPPORTERS, supportersCount.element);
                                editor$iv.apply();
                            }
                            token2 = token;
                            supportersCount2 = supportersCount;
                            currentAmount2 = currentAmount;
                            prefs2 = prefs;
                        } else {
                            token2 = token;
                            supportersCount2 = supportersCount;
                            currentAmount2 = currentAmount;
                            prefs2 = prefs;
                        }
                        if (DonationManager.INSTANCE.getTestProgressAmount() > 0.0d) {
                            currentAmount2.element = DonationManager.INSTANCE.getTestProgressAmount();
                            if (supportersCount2.element == 0) {
                                supportersCount2.element = 3;
                            }
                        }
                        if (DonationManager.INSTANCE.getTargetAmount() > 0.0d || currentAmount2.element < DonationManager.INSTANCE.getTargetAmount()) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        if (DonationManager.INSTANCE.isCooldownActive(this.$appContext)) {
                            return Unit.INSTANCE;
                        }
                        str = this.$providerName;
                        if (i != 0) {
                            if (StringsKt.isBlank(str)) {
                                sbAppend = new StringBuilder().append("Goal Achieved for ").append(this.$currentMonth).append('!');
                            } else {
                                sbAppend = new StringBuilder().append("Goal Achieved for ").append(this.$providerName).append('!');
                            }
                            goalTitle = sbAppend.toString();
                        } else if (StringsKt.isBlank(str)) {
                            goalTitle = DonationManager.INSTANCE.getGoalTitle();
                        } else {
                            goalTitle = "Help Keep " + this.$providerName + " Alive";
                        }
                        String dynamicTitle = goalTitle;
                        String str3 = this.$providerName;
                        String str4 = this.$currentMonth;
                        String goalDescription = DonationManager.INSTANCE.getGoalDescription();
                        String currency = DonationManager.INSTANCE.getCurrency();
                        double targetAmount = DonationManager.INSTANCE.getTargetAmount();
                        SharedPreferences prefs3 = prefs2;
                        double d = currentAmount2.element;
                        int i2 = supportersCount2.element;
                        String primaryDonateUrl = DonationManager.INSTANCE.getPrimaryDonateUrl();
                        if (i != 0) {
                            primaryButtonText = "☕ Send Extra Love";
                        } else {
                            primaryButtonText = DonationManager.INSTANCE.getPrimaryButtonText();
                        }
                        config = new DonationConfig(true, str3, str4, dynamicTitle, goalDescription, currency, targetAmount, d, i2, primaryDonateUrl, primaryButtonText, DonationManager.INSTANCE.getSecondaryDonateUrl(), DonationManager.INSTANCE.getSecondaryButtonText(), DonationManager.INSTANCE.getAdSupportUrl(), DonationManager.INSTANCE.getAdSupportButtonText(), DonationManager.INSTANCE.getCooldownHours(), null, 65536, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(prefs3);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(currentAmount2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(supportersCount2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(token2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(dynamicTitle);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(config);
                        this.I$0 = i;
                        this.label = 2;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$appContext, config, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        token = (String) this.L$3;
                        supportersCount = (Ref.IntRef) this.L$2;
                        currentAmount = (Ref.DoubleRef) this.L$1;
                        prefs = (SharedPreferences) this.L$0;
                        ResultKt.throwOnFailure($result);
                        objFetchBuyMeACoffeeMonthly = $result;
                        bmcResult = (Pair) objFetchBuyMeACoffeeMonthly;
                        if (bmcResult != null) {
                            currentAmount.element = ((Number) bmcResult.getFirst()).doubleValue();
                            supportersCount.element = ((Number) bmcResult.getSecond()).intValue();
                            String str5 = this.$currentMonth;
                            SharedPreferences $this$edit$iv2 = prefs;
                            SharedPreferences.Editor editor$iv2 = $this$edit$iv2.edit();
                            Intrinsics.checkExpressionValueIsNotNull(editor$iv2, "editor");
                            editor$iv2.putString(DonationManager.KEY_CACHED_MONTH, str5).putFloat(DonationManager.KEY_CACHED_AMOUNT, (float) currentAmount.element).putInt(DonationManager.KEY_CACHED_SUPPORTERS, supportersCount.element);
                            editor$iv2.apply();
                        }
                        token2 = token;
                        supportersCount2 = supportersCount;
                        currentAmount2 = currentAmount;
                        prefs2 = prefs;
                        if (DonationManager.INSTANCE.getTestProgressAmount() > 0.0d) {
                            currentAmount2.element = DonationManager.INSTANCE.getTestProgressAmount();
                            if (supportersCount2.element == 0) {
                                supportersCount2.element = 3;
                            }
                        }
                        if (DonationManager.INSTANCE.getTargetAmount() > 0.0d) {
                            i = 0;
                        } else {
                            i = 0;
                        }
                        if (DonationManager.INSTANCE.isCooldownActive(this.$appContext)) {
                            return Unit.INSTANCE;
                        }
                        str = this.$providerName;
                        if (i != 0) {
                            if (StringsKt.isBlank(str)) {
                                sbAppend = new StringBuilder().append("Goal Achieved for ").append(this.$providerName).append('!');
                            } else {
                                sbAppend = new StringBuilder().append("Goal Achieved for ").append(this.$currentMonth).append('!');
                            }
                            goalTitle = sbAppend.toString();
                        } else if (StringsKt.isBlank(str)) {
                            goalTitle = "Help Keep " + this.$providerName + " Alive";
                        } else {
                            goalTitle = DonationManager.INSTANCE.getGoalTitle();
                        }
                        String dynamicTitle2 = goalTitle;
                        String str6 = this.$providerName;
                        String str7 = this.$currentMonth;
                        String goalDescription2 = DonationManager.INSTANCE.getGoalDescription();
                        String currency2 = DonationManager.INSTANCE.getCurrency();
                        double targetAmount2 = DonationManager.INSTANCE.getTargetAmount();
                        SharedPreferences prefs4 = prefs2;
                        double d2 = currentAmount2.element;
                        int i3 = supportersCount2.element;
                        String primaryDonateUrl2 = DonationManager.INSTANCE.getPrimaryDonateUrl();
                        if (i != 0) {
                            primaryButtonText = "☕ Send Extra Love";
                        } else {
                            primaryButtonText = DonationManager.INSTANCE.getPrimaryButtonText();
                        }
                        config = new DonationConfig(true, str6, str7, dynamicTitle2, goalDescription2, currency2, targetAmount2, d2, i3, primaryDonateUrl2, primaryButtonText, DonationManager.INSTANCE.getSecondaryDonateUrl(), DonationManager.INSTANCE.getSecondaryButtonText(), DonationManager.INSTANCE.getAdSupportUrl(), DonationManager.INSTANCE.getAdSupportButtonText(), DonationManager.INSTANCE.getCooldownHours(), null, 65536, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(prefs4);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(currentAmount2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(supportersCount2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(token2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(dynamicTitle2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(config);
                        this.I$0 = i;
                        this.label = 2;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$appContext, config, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 2:
                        int i4 = this.I$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th) {
            }
        }

        /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$checkAndShow$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.donation.DonationManager$checkAndShow$2$2", f = "DonationManager.kt", i = {0, 0}, l = {261}, m = "invokeSuspend", n = {"currentActivity", "i"}, nl = {262}, s = {"L$0", "I$0"}, v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $appContext;
            final /* synthetic */ DonationConfig $config;
            int I$0;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Context context, DonationConfig donationConfig, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$appContext = context;
                this.$config = donationConfig;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$appContext, this.$config, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:25:0x0053  */
            /* JADX WARN: Code duplicated, block: B:27:0x0070 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:30:0x007b  */
            /* JADX WARN: Code duplicated, block: B:31:0x007e  */
            /* JADX WARN: Code duplicated, block: B:34:0x0082  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006e -> B:28:0x0071). Please report as a decompilation issue!!! */
            /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
                java.lang.StackOverflowError
                	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
                	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
                */
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    Method dump skipped, instruction units count: 244
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.phisher98.donation.DonationManager.C00062.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            static final Unit invokeSuspend$lambda$0() {
                DonationManager.INSTANCE.setDialogShowing(false);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$showNow$1 */
    /* JADX INFO: compiled from: DonationManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.donation.DonationManager$showNow$1", f = "DonationManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2}, l = {309, 348, 363}, m = "invokeSuspend", n = {"currentMonth", "prefs", "token", "currentAmount", "supportersCount", "currentMonth", "prefs", "token", "dynamicTitle", "config", "currentAmount", "supportersCount", "isGoalAchieved", "<unused var>"}, nl = {310, 362, 389}, s = {"L$0", "L$1", "L$2", "D$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "D$0", "I$0", "I$1", "L$0"}, v = 2)
    static final class C00081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatActivity $activity;
        final /* synthetic */ String $providerName;
        double D$0;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00081(AppCompatActivity appCompatActivity, String str, Continuation<? super C00081> continuation) {
            super(2, continuation);
            this.$activity = appCompatActivity;
            this.$providerName = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00081(this.$activity, this.$providerName, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x00ad A[Catch: all -> 0x020e, TryCatch #0 {all -> 0x020e, blocks: (B:8:0x0039, B:11:0x004e, B:19:0x00a9, B:21:0x00ad, B:24:0x00d1, B:26:0x00dd, B:31:0x00f0, B:33:0x00fa, B:40:0x010c, B:43:0x0118, B:45:0x013d, B:51:0x016e, B:55:0x019b, B:54:0x0195, B:44:0x012c, B:46:0x0143, B:48:0x014b, B:49:0x0167, B:14:0x0058, B:16:0x0089), top: B:67:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:22:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:26:0x00dd A[Catch: all -> 0x020e, TryCatch #0 {all -> 0x020e, blocks: (B:8:0x0039, B:11:0x004e, B:19:0x00a9, B:21:0x00ad, B:24:0x00d1, B:26:0x00dd, B:31:0x00f0, B:33:0x00fa, B:40:0x010c, B:43:0x0118, B:45:0x013d, B:51:0x016e, B:55:0x019b, B:54:0x0195, B:44:0x012c, B:46:0x0143, B:48:0x014b, B:49:0x0167, B:14:0x0058, B:16:0x0089), top: B:67:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:28:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:30:0x00ec  */
        /* JADX WARN: Code duplicated, block: B:37:0x0105  */
        /* JADX WARN: Code duplicated, block: B:40:0x010c A[Catch: all -> 0x020e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x020e, blocks: (B:8:0x0039, B:11:0x004e, B:19:0x00a9, B:21:0x00ad, B:24:0x00d1, B:26:0x00dd, B:31:0x00f0, B:33:0x00fa, B:40:0x010c, B:43:0x0118, B:45:0x013d, B:51:0x016e, B:55:0x019b, B:54:0x0195, B:44:0x012c, B:46:0x0143, B:48:0x014b, B:49:0x0167, B:14:0x0058, B:16:0x0089), top: B:67:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:43:0x0118 A[Catch: all -> 0x020e, TRY_ENTER, TryCatch #0 {all -> 0x020e, blocks: (B:8:0x0039, B:11:0x004e, B:19:0x00a9, B:21:0x00ad, B:24:0x00d1, B:26:0x00dd, B:31:0x00f0, B:33:0x00fa, B:40:0x010c, B:43:0x0118, B:45:0x013d, B:51:0x016e, B:55:0x019b, B:54:0x0195, B:44:0x012c, B:46:0x0143, B:48:0x014b, B:49:0x0167, B:14:0x0058, B:16:0x0089), top: B:67:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:44:0x012c A[Catch: all -> 0x020e, TryCatch #0 {all -> 0x020e, blocks: (B:8:0x0039, B:11:0x004e, B:19:0x00a9, B:21:0x00ad, B:24:0x00d1, B:26:0x00dd, B:31:0x00f0, B:33:0x00fa, B:40:0x010c, B:43:0x0118, B:45:0x013d, B:51:0x016e, B:55:0x019b, B:54:0x0195, B:44:0x012c, B:46:0x0143, B:48:0x014b, B:49:0x0167, B:14:0x0058, B:16:0x0089), top: B:67:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:46:0x0143 A[Catch: all -> 0x020e, TryCatch #0 {all -> 0x020e, blocks: (B:8:0x0039, B:11:0x004e, B:19:0x00a9, B:21:0x00ad, B:24:0x00d1, B:26:0x00dd, B:31:0x00f0, B:33:0x00fa, B:40:0x010c, B:43:0x0118, B:45:0x013d, B:51:0x016e, B:55:0x019b, B:54:0x0195, B:44:0x012c, B:46:0x0143, B:48:0x014b, B:49:0x0167, B:14:0x0058, B:16:0x0089), top: B:67:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:48:0x014b A[Catch: all -> 0x020e, TryCatch #0 {all -> 0x020e, blocks: (B:8:0x0039, B:11:0x004e, B:19:0x00a9, B:21:0x00ad, B:24:0x00d1, B:26:0x00dd, B:31:0x00f0, B:33:0x00fa, B:40:0x010c, B:43:0x0118, B:45:0x013d, B:51:0x016e, B:55:0x019b, B:54:0x0195, B:44:0x012c, B:46:0x0143, B:48:0x014b, B:49:0x0167, B:14:0x0058, B:16:0x0089), top: B:67:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:49:0x0167 A[Catch: all -> 0x020e, TryCatch #0 {all -> 0x020e, blocks: (B:8:0x0039, B:11:0x004e, B:19:0x00a9, B:21:0x00ad, B:24:0x00d1, B:26:0x00dd, B:31:0x00f0, B:33:0x00fa, B:40:0x010c, B:43:0x0118, B:45:0x013d, B:51:0x016e, B:55:0x019b, B:54:0x0195, B:44:0x012c, B:46:0x0143, B:48:0x014b, B:49:0x0167, B:14:0x0058, B:16:0x0089), top: B:67:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:53:0x0192  */
        /* JADX WARN: Code duplicated, block: B:54:0x0195 A[Catch: all -> 0x020e, TryCatch #0 {all -> 0x020e, blocks: (B:8:0x0039, B:11:0x004e, B:19:0x00a9, B:21:0x00ad, B:24:0x00d1, B:26:0x00dd, B:31:0x00f0, B:33:0x00fa, B:40:0x010c, B:43:0x0118, B:45:0x013d, B:51:0x016e, B:55:0x019b, B:54:0x0195, B:44:0x012c, B:46:0x0143, B:48:0x014b, B:49:0x0167, B:14:0x0058, B:16:0x0089), top: B:67:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0209 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:58:0x020a  */
        public final Object invokeSuspend(Object $result) {
            String currentMonth;
            SharedPreferences prefs;
            double currentAmount;
            int supportersCount;
            String token;
            String token2;
            SharedPreferences prefs2;
            String currentMonth2;
            Object objFetchBuyMeACoffeeMonthly;
            int supportersCount2;
            double currentAmount2;
            int i;
            String str;
            String goalTitle;
            String dynamicTitle;
            DonationConfig config;
            String primaryButtonText;
            StringBuilder sbAppend;
            Pair bmcResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        currentMonth = DonationManager.INSTANCE.getCurrentMonthName();
                        prefs = DonationManager.INSTANCE.getPrefs(this.$activity.getApplicationContext());
                        currentAmount = prefs.getFloat(DonationManager.KEY_CACHED_AMOUNT, 0.0f);
                        supportersCount = prefs.getInt(DonationManager.KEY_CACHED_SUPPORTERS, 0);
                        token = DonationManager.INSTANCE.getDecryptedBmcToken();
                        if (StringsKt.isBlank(token)) {
                            token2 = token;
                            prefs2 = prefs;
                            currentMonth2 = currentMonth;
                        } else {
                            this.L$0 = currentMonth;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(prefs);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(token);
                            this.D$0 = currentAmount;
                            this.I$0 = supportersCount;
                            this.label = 1;
                            objFetchBuyMeACoffeeMonthly = DonationManager.INSTANCE.fetchBuyMeACoffeeMonthly(token, (Continuation) this);
                            if (objFetchBuyMeACoffeeMonthly == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            bmcResult = (Pair) objFetchBuyMeACoffeeMonthly;
                            if (bmcResult != null) {
                                currentAmount = ((Number) bmcResult.getFirst()).doubleValue();
                                supportersCount = ((Number) bmcResult.getSecond()).intValue();
                                SharedPreferences sharedPreferences = prefs;
                                token2 = token;
                                prefs2 = sharedPreferences;
                                currentMonth2 = currentMonth;
                            } else {
                                SharedPreferences sharedPreferences2 = prefs;
                                token2 = token;
                                prefs2 = sharedPreferences2;
                                currentMonth2 = currentMonth;
                            }
                        }
                        if (DonationManager.INSTANCE.getTestProgressAmount() > 0.0d) {
                            double currentAmount3 = DonationManager.INSTANCE.getTestProgressAmount();
                            if (supportersCount == 0) {
                                supportersCount = 3;
                            }
                            supportersCount2 = supportersCount;
                            currentAmount2 = currentAmount3;
                        } else {
                            supportersCount2 = supportersCount;
                            currentAmount2 = currentAmount;
                        }
                        i = (DonationManager.INSTANCE.getTargetAmount() > 0.0d || currentAmount2 < DonationManager.INSTANCE.getTargetAmount()) ? 0 : 1;
                        str = this.$providerName;
                        if (i != 0) {
                            if (StringsKt.isBlank(str)) {
                                sbAppend = new StringBuilder().append("Goal Achieved for ").append(currentMonth2).append('!');
                            } else {
                                sbAppend = new StringBuilder().append("Goal Achieved for ").append(this.$providerName).append('!');
                            }
                            dynamicTitle = sbAppend.toString();
                        } else {
                            if (StringsKt.isBlank(str)) {
                                goalTitle = DonationManager.INSTANCE.getGoalTitle();
                            } else {
                                goalTitle = "Help Keep " + this.$providerName + " Alive";
                            }
                            dynamicTitle = goalTitle;
                        }
                        String str2 = this.$providerName;
                        String goalDescription = DonationManager.INSTANCE.getGoalDescription();
                        String currency = DonationManager.INSTANCE.getCurrency();
                        double targetAmount = DonationManager.INSTANCE.getTargetAmount();
                        String primaryDonateUrl = DonationManager.INSTANCE.getPrimaryDonateUrl();
                        if (i != 0) {
                            primaryButtonText = "☕ Send Extra Love";
                        } else {
                            primaryButtonText = DonationManager.INSTANCE.getPrimaryButtonText();
                        }
                        config = new DonationConfig(true, str2, currentMonth2, dynamicTitle, goalDescription, currency, targetAmount, currentAmount2, supportersCount2, primaryDonateUrl, primaryButtonText, DonationManager.INSTANCE.getSecondaryDonateUrl(), DonationManager.INSTANCE.getSecondaryButtonText(), DonationManager.INSTANCE.getAdSupportUrl(), DonationManager.INSTANCE.getAdSupportButtonText(), DonationManager.INSTANCE.getCooldownHours(), null, 65536, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(currentMonth2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(prefs2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(token2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(dynamicTitle);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(config);
                        this.D$0 = currentAmount2;
                        this.I$0 = supportersCount2;
                        this.I$1 = i;
                        this.label = 2;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$activity, config, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        supportersCount = this.I$0;
                        currentAmount = this.D$0;
                        token = (String) this.L$2;
                        prefs = (SharedPreferences) this.L$1;
                        currentMonth = (String) this.L$0;
                        ResultKt.throwOnFailure($result);
                        objFetchBuyMeACoffeeMonthly = $result;
                        bmcResult = (Pair) objFetchBuyMeACoffeeMonthly;
                        if (bmcResult != null) {
                            currentAmount = ((Number) bmcResult.getFirst()).doubleValue();
                            supportersCount = ((Number) bmcResult.getSecond()).intValue();
                            SharedPreferences sharedPreferences3 = prefs;
                            token2 = token;
                            prefs2 = sharedPreferences3;
                            currentMonth2 = currentMonth;
                        } else {
                            SharedPreferences sharedPreferences4 = prefs;
                            token2 = token;
                            prefs2 = sharedPreferences4;
                            currentMonth2 = currentMonth;
                        }
                        if (DonationManager.INSTANCE.getTestProgressAmount() > 0.0d) {
                            double currentAmount4 = DonationManager.INSTANCE.getTestProgressAmount();
                            if (supportersCount == 0) {
                                supportersCount = 3;
                            }
                            supportersCount2 = supportersCount;
                            currentAmount2 = currentAmount4;
                        } else {
                            supportersCount2 = supportersCount;
                            currentAmount2 = currentAmount;
                        }
                        i = (DonationManager.INSTANCE.getTargetAmount() > 0.0d || currentAmount2 < DonationManager.INSTANCE.getTargetAmount()) ? 0 : 1;
                        str = this.$providerName;
                        if (i != 0) {
                            if (StringsKt.isBlank(str)) {
                                sbAppend = new StringBuilder().append("Goal Achieved for ").append(this.$providerName).append('!');
                            } else {
                                sbAppend = new StringBuilder().append("Goal Achieved for ").append(currentMonth2).append('!');
                            }
                            dynamicTitle = sbAppend.toString();
                        } else {
                            if (StringsKt.isBlank(str)) {
                                goalTitle = "Help Keep " + this.$providerName + " Alive";
                            } else {
                                goalTitle = DonationManager.INSTANCE.getGoalTitle();
                            }
                            dynamicTitle = goalTitle;
                        }
                        String str3 = this.$providerName;
                        String goalDescription2 = DonationManager.INSTANCE.getGoalDescription();
                        String currency2 = DonationManager.INSTANCE.getCurrency();
                        double targetAmount2 = DonationManager.INSTANCE.getTargetAmount();
                        String primaryDonateUrl2 = DonationManager.INSTANCE.getPrimaryDonateUrl();
                        if (i != 0) {
                            primaryButtonText = "☕ Send Extra Love";
                        } else {
                            primaryButtonText = DonationManager.INSTANCE.getPrimaryButtonText();
                        }
                        config = new DonationConfig(true, str3, currentMonth2, dynamicTitle, goalDescription2, currency2, targetAmount2, currentAmount2, supportersCount2, primaryDonateUrl2, primaryButtonText, DonationManager.INSTANCE.getSecondaryDonateUrl(), DonationManager.INSTANCE.getSecondaryButtonText(), DonationManager.INSTANCE.getAdSupportUrl(), DonationManager.INSTANCE.getAdSupportButtonText(), DonationManager.INSTANCE.getCooldownHours(), null, 65536, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(currentMonth2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(prefs2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(token2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(dynamicTitle);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(config);
                        this.D$0 = currentAmount2;
                        this.I$0 = supportersCount2;
                        this.I$1 = i;
                        this.label = 2;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$activity, config, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 2:
                        int i2 = this.I$1;
                        int i3 = this.I$0;
                        double d = this.D$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(th);
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this.$activity, this.$providerName, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$showNow$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.donation.DonationManager$showNow$1$1", f = "DonationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AppCompatActivity $activity;
            final /* synthetic */ DonationConfig $config;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AppCompatActivity appCompatActivity, DonationConfig donationConfig, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$activity = appCompatActivity;
                this.$config = donationConfig;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$activity, this.$config, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (DonationManager.INSTANCE.isDialogShowing()) {
                            return Unit.INSTANCE;
                        }
                        if (this.$activity.isFinishing() || this.$activity.isDestroyed()) {
                            return Unit.INSTANCE;
                        }
                        FragmentManager fm = this.$activity.getSupportFragmentManager();
                        if (fm.isDestroyed() || fm.findFragmentByTag(DonationManager.DIALOG_TAG) != null) {
                            return Unit.INSTANCE;
                        }
                        DonationManager.INSTANCE.setDialogShowing(true);
                        Fragment donationDialogFragment = new DonationDialogFragment(this.$config, new Function0() { // from class: com.phisher98.donation.DonationManager$showNow$1$1$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                return DonationManager.C00081.AnonymousClass1.invokeSuspend$lambda$0();
                            }
                        });
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.add(donationDialogFragment, DonationManager.DIALOG_TAG);
                        ft.commitAllowingStateLoss();
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            static final Unit invokeSuspend$lambda$0() {
                DonationManager.INSTANCE.setDialogShowing(false);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$showNow$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.donation.DonationManager$showNow$1$3", f = "DonationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AppCompatActivity $activity;
            final /* synthetic */ String $providerName;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(AppCompatActivity appCompatActivity, String str, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$activity = appCompatActivity;
                this.$providerName = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$activity, this.$providerName, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (DonationManager.INSTANCE.isDialogShowing()) {
                            return Unit.INSTANCE;
                        }
                        if (this.$activity.isFinishing() || this.$activity.isDestroyed()) {
                            return Unit.INSTANCE;
                        }
                        FragmentManager fm = this.$activity.getSupportFragmentManager();
                        if (fm.isDestroyed()) {
                            return Unit.INSTANCE;
                        }
                        DonationManager.INSTANCE.setDialogShowing(true);
                        String dynamicTitle = !StringsKt.isBlank(this.$providerName) ? "Help Keep " + this.$providerName + " Alive" : DonationManager.INSTANCE.getGoalTitle();
                        Fragment donationDialogFragment = new DonationDialogFragment(new DonationConfig(false, this.$providerName, DonationManager.INSTANCE.getCurrentMonthName(), dynamicTitle, null, null, 0.0d, 0.0d, 0, DonationManager.INSTANCE.getPrimaryDonateUrl(), DonationManager.INSTANCE.getPrimaryButtonText(), null, null, DonationManager.INSTANCE.getAdSupportUrl(), DonationManager.INSTANCE.getAdSupportButtonText(), 0, null, 104945, null), new Function0() { // from class: com.phisher98.donation.DonationManager$showNow$1$3$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                return DonationManager.C00081.AnonymousClass3.invokeSuspend$lambda$0();
                            }
                        });
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.add(donationDialogFragment, DonationManager.DIALOG_TAG);
                        ft.commitAllowingStateLoss();
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            static final Unit invokeSuspend$lambda$0() {
                DonationManager.INSTANCE.setDialogShowing(false);
                return Unit.INSTANCE;
            }
        }
    }

    public static /* synthetic */ void showNow$default(DonationManager donationManager, AppCompatActivity appCompatActivity, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        donationManager.showNow(appCompatActivity, str);
    }

    public final void showNow(@NotNull AppCompatActivity activity, @NotNull String providerName) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00081(activity, providerName, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:152:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x02b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x0291 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x010a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0197 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x0198  */
    /* JADX WARN: Code duplicated, block: B:39:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:40:0x01c7 A[Catch: all -> 0x030b, TryCatch #7 {all -> 0x030b, blocks: (B:37:0x01a7, B:40:0x01c7, B:42:0x01cf, B:44:0x01db, B:50:0x0220, B:53:0x0228, B:55:0x022c, B:57:0x024a, B:59:0x0251, B:69:0x02a7, B:60:0x0277, B:62:0x0284, B:64:0x028a, B:71:0x02c5, B:49:0x0216, B:46:0x0205), top: B:158:0x01a7, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x01cf A[Catch: all -> 0x030b, TryCatch #7 {all -> 0x030b, blocks: (B:37:0x01a7, B:40:0x01c7, B:42:0x01cf, B:44:0x01db, B:50:0x0220, B:53:0x0228, B:55:0x022c, B:57:0x024a, B:59:0x0251, B:69:0x02a7, B:60:0x0277, B:62:0x0284, B:64:0x028a, B:71:0x02c5, B:49:0x0216, B:46:0x0205), top: B:158:0x01a7, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x01db A[Catch: all -> 0x030b, TRY_LEAVE, TryCatch #7 {all -> 0x030b, blocks: (B:37:0x01a7, B:40:0x01c7, B:42:0x01cf, B:44:0x01db, B:50:0x0220, B:53:0x0228, B:55:0x022c, B:57:0x024a, B:59:0x0251, B:69:0x02a7, B:60:0x0277, B:62:0x0284, B:64:0x028a, B:71:0x02c5, B:49:0x0216, B:46:0x0205), top: B:158:0x01a7, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0226  */
    /* JADX WARN: Code duplicated, block: B:55:0x022c A[Catch: all -> 0x030b, TryCatch #7 {all -> 0x030b, blocks: (B:37:0x01a7, B:40:0x01c7, B:42:0x01cf, B:44:0x01db, B:50:0x0220, B:53:0x0228, B:55:0x022c, B:57:0x024a, B:59:0x0251, B:69:0x02a7, B:60:0x0277, B:62:0x0284, B:64:0x028a, B:71:0x02c5, B:49:0x0216, B:46:0x0205), top: B:158:0x01a7, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x024a A[Catch: all -> 0x030b, TryCatch #7 {all -> 0x030b, blocks: (B:37:0x01a7, B:40:0x01c7, B:42:0x01cf, B:44:0x01db, B:50:0x0220, B:53:0x0228, B:55:0x022c, B:57:0x024a, B:59:0x0251, B:69:0x02a7, B:60:0x0277, B:62:0x0284, B:64:0x028a, B:71:0x02c5, B:49:0x0216, B:46:0x0205), top: B:158:0x01a7, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0277 A[Catch: all -> 0x030b, TryCatch #7 {all -> 0x030b, blocks: (B:37:0x01a7, B:40:0x01c7, B:42:0x01cf, B:44:0x01db, B:50:0x0220, B:53:0x0228, B:55:0x022c, B:57:0x024a, B:59:0x0251, B:69:0x02a7, B:60:0x0277, B:62:0x0284, B:64:0x028a, B:71:0x02c5, B:49:0x0216, B:46:0x0205), top: B:158:0x01a7, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0284 A[Catch: all -> 0x030b, TryCatch #7 {all -> 0x030b, blocks: (B:37:0x01a7, B:40:0x01c7, B:42:0x01cf, B:44:0x01db, B:50:0x0220, B:53:0x0228, B:55:0x022c, B:57:0x024a, B:59:0x0251, B:69:0x02a7, B:60:0x0277, B:62:0x0284, B:64:0x028a, B:71:0x02c5, B:49:0x0216, B:46:0x0205), top: B:158:0x01a7, inners: #12 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0294  */
    /* JADX WARN: Code duplicated, block: B:68:0x029f  */
    /* JADX WARN: Code duplicated, block: B:73:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:74:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0198 -> B:162:0x01a1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object fetchBuyMeACoffeeMonthly(java.lang.String r61, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Double, java.lang.Integer>> r62) {
        /*
            Method dump skipped, instruction units count: 1400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.donation.DonationManager.fetchBuyMeACoffeeMonthly(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
