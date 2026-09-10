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
import java.util.Date;
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
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DonationManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Desicinemas/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010I\u001a\u00020J2\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010K\u001a\u00020\u0013H\u0002J\u0010\u0010L\u001a\u00020J2\b\b\u0002\u0010M\u001a\u00020\u0013J\u0018\u0010N\u001a\u00020J2\u0006\u0010O\u001a\u00020P2\b\b\u0002\u0010M\u001a\u00020\u0013J$\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u000206\u0018\u00010R2\u0006\u0010S\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010TR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001a\u0010&\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010)\u001a\u00020\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR\u001a\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001a\u0010/\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001a\u00102\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/phisher98/donation/DonationManager;", "", "<init>", "()V", "testMode", "", "getTestMode", "()Z", "setTestMode", "(Z)V", "testProgressAmount", "", "getTestProgressAmount", "()D", "setTestProgressAmount", "(D)V", "isDialogShowing", "setDialogShowing", "OBFUSCATED_TOKEN", "", "getDecryptedBmcToken", "primaryDonateUrl", "getPrimaryDonateUrl", "()Ljava/lang/String;", "setPrimaryDonateUrl", "(Ljava/lang/String;)V", "primaryButtonText", "getPrimaryButtonText", "setPrimaryButtonText", "secondaryDonateUrl", "getSecondaryDonateUrl", "setSecondaryDonateUrl", "secondaryButtonText", "getSecondaryButtonText", "setSecondaryButtonText", "adSupportUrl", "getAdSupportUrl", "setAdSupportUrl", "adSupportButtonText", "getAdSupportButtonText", "setAdSupportButtonText", "targetAmount", "getTargetAmount", "setTargetAmount", "currency", "getCurrency", "setCurrency", "goalTitle", "getGoalTitle", "setGoalTitle", "goalDescription", "getGoalDescription", "setGoalDescription", "cooldownHours", "", "getCooldownHours", "()I", "setCooldownHours", "(I)V", "PREFS_NAME", "KEY_LAST_SHOWN", "KEY_CACHED_MONTH", "KEY_CACHED_AMOUNT", "KEY_CACHED_SUPPORTERS", "DIALOG_TAG", "gateLock", "lastTriggerTime", "", "getPrefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "isCooldownActive", "recordShown", "", "getCurrentMonthName", "checkAndShow", "providerName", "showNow", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "fetchBuyMeACoffeeMonthly", "Lkotlin/Pair;", "accessToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Desicinemas"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,492:1\n40#2,11:493\n1#3:504\n*S KotlinDebug\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager\n*L\n125#1:493,11\n*E\n"})
public final class DonationManager {

    @NotNull
    private static final String DIALOG_TAG = "phisher_donation_floating_dialog";

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
    private static String goalTitle = "Help Keep Phisher Repo Alive";

    @NotNull
    private static String goalDescription = "Support us to keep this extension maintained! Reaching the goal means faster updates and active maintenance. If not, updates will be slow, and the extension could become dead over time.";
    private static int cooldownHours = 24;

    @NotNull
    private static final Object gateLock = new Object();

    /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$fetchBuyMeACoffeeMonthly$1 */
    /* JADX INFO: compiled from: DonationManager.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.donation.DonationManager", f = "DonationManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {416, 464}, m = "fetchBuyMeACoffeeMonthly", n = {"accessToken", "now", "monthTotal", "supportersCount", "dateFormat", "currentYear", "currentMonth", "page", "hasMore", "accessToken", "now", "monthTotal", "supportersCount", "dateFormat", "$this$fetchBuyMeACoffeeMonthly_u24lambda_u244", "currentYear", "currentMonth", "page", "hasMore"}, nl = {425, 473}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 2)
    static final class C00221 extends ContinuationImpl {
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

        C00221(Continuation<? super C00221> continuation) {
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
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00212(appContext, currentMonth, providerName, null), 3, (Object) null);
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$checkAndShow$2 */
    /* JADX INFO: compiled from: DonationManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.donation.DonationManager$checkAndShow$2", f = "DonationManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {177, 196, 197, 250}, m = "invokeSuspend", n = {"prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "hasCachedData", "fetchSucceeded", "prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "hasCachedData", "fetchSucceeded", "attempt", "prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "hasCachedData", "fetchSucceeded", "attempt", "prefs", "cachedMonth", "currentAmount", "supportersCount", "token", "dynamicTitle", "config", "hasCachedData", "fetchSucceeded", "isGoalAchieved"}, nl = {178, 197, 198, 285}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "I$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,492:1\n40#2,11:493\n40#2,11:504\n*S KotlinDebug\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$checkAndShow$2\n*L\n184#1:493,11\n202#1:504,11\n*E\n"})
    static final class C00212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ String $currentMonth;
        final /* synthetic */ String $providerName;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00212(Context context, String str, String str2, Continuation<? super C00212> continuation) {
            super(2, continuation);
            this.$appContext = context;
            this.$currentMonth = str;
            this.$providerName = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00212(this.$appContext, this.$currentMonth, this.$providerName, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:115:0x01dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:51:0x0210 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:52:0x0211  */
        /* JADX WARN: Code duplicated, block: B:55:0x0224 A[Catch: all -> 0x02cb, TryCatch #5 {all -> 0x02cb, blocks: (B:58:0x0247, B:53:0x021b, B:55:0x0224), top: B:123:0x0247 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0246 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:60:0x0252  */
        /* JADX WARN: Code duplicated, block: B:62:0x0256 A[Catch: all -> 0x02b2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x02b2, blocks: (B:62:0x0256, B:47:0x01dc), top: B:115:0x01dc }] */
        /* JADX WARN: Code duplicated, block: B:70:0x02b9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0244 -> B:123:0x0247). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0252 -> B:59:0x0249). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r42) {
            /*
                Method dump skipped, instruction units count: 1042
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.donation.DonationManager.C00212.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$checkAndShow$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.donation.DonationManager$checkAndShow$2$3", f = "DonationManager.kt", i = {0, 0}, l = {257}, m = "invokeSuspend", n = {"currentActivity", "i"}, nl = {258}, s = {"L$0", "I$0"}, v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $appContext;
            final /* synthetic */ DonationConfig $config;
            int I$0;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(Context context, DonationConfig donationConfig, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$appContext = context;
                this.$config = donationConfig;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$appContext, this.$config, continuation);
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
                throw new UnsupportedOperationException("Method not decompiled: com.phisher98.donation.DonationManager.C00212.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
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
    @DebugMetadata(c = "com.phisher98.donation.DonationManager$showNow$1", f = "DonationManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2}, l = {305, 344, 359}, m = "invokeSuspend", n = {"currentMonth", "prefs", "currentAmount", "supportersCount", "token", "currentMonth", "prefs", "currentAmount", "supportersCount", "token", "dynamicTitle", "config", "isGoalAchieved", "<unused var>"}, nl = {306, 358, 384}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$showNow$1\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,492:1\n40#2,11:493\n*S KotlinDebug\n*F\n+ 1 DonationManager.kt\ncom/phisher98/donation/DonationManager$showNow$1\n*L\n309#1:493,11\n*E\n"})
    static final class C00231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatActivity $activity;
        final /* synthetic */ String $providerName;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00231(AppCompatActivity appCompatActivity, String str, Continuation<? super C00231> continuation) {
            super(2, continuation);
            this.$activity = appCompatActivity;
            this.$providerName = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00231(this.$activity, this.$providerName, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x00c0 A[Catch: all -> 0x0208, TryCatch #0 {all -> 0x0208, blocks: (B:8:0x0040, B:11:0x0059, B:19:0x00bc, B:21:0x00c0, B:24:0x0117, B:26:0x0123, B:28:0x012f, B:29:0x0132, B:31:0x013c, B:39:0x0157, B:43:0x0187, B:42:0x0181, B:38:0x0151, B:14:0x0063, B:16:0x00a0), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:26:0x0123 A[Catch: all -> 0x0208, TryCatch #0 {all -> 0x0208, blocks: (B:8:0x0040, B:11:0x0059, B:19:0x00bc, B:21:0x00c0, B:24:0x0117, B:26:0x0123, B:28:0x012f, B:29:0x0132, B:31:0x013c, B:39:0x0157, B:43:0x0187, B:42:0x0181, B:38:0x0151, B:14:0x0063, B:16:0x00a0), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:28:0x012f A[Catch: all -> 0x0208, TryCatch #0 {all -> 0x0208, blocks: (B:8:0x0040, B:11:0x0059, B:19:0x00bc, B:21:0x00c0, B:24:0x0117, B:26:0x0123, B:28:0x012f, B:29:0x0132, B:31:0x013c, B:39:0x0157, B:43:0x0187, B:42:0x0181, B:38:0x0151, B:14:0x0063, B:16:0x00a0), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:34:0x014a  */
        /* JADX WARN: Code duplicated, block: B:37:0x014e  */
        /* JADX WARN: Code duplicated, block: B:38:0x0151 A[Catch: all -> 0x0208, TryCatch #0 {all -> 0x0208, blocks: (B:8:0x0040, B:11:0x0059, B:19:0x00bc, B:21:0x00c0, B:24:0x0117, B:26:0x0123, B:28:0x012f, B:29:0x0132, B:31:0x013c, B:39:0x0157, B:43:0x0187, B:42:0x0181, B:38:0x0151, B:14:0x0063, B:16:0x00a0), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:41:0x017e  */
        /* JADX WARN: Code duplicated, block: B:42:0x0181 A[Catch: all -> 0x0208, TryCatch #0 {all -> 0x0208, blocks: (B:8:0x0040, B:11:0x0059, B:19:0x00bc, B:21:0x00c0, B:24:0x0117, B:26:0x0123, B:28:0x012f, B:29:0x0132, B:31:0x013c, B:39:0x0157, B:43:0x0187, B:42:0x0181, B:38:0x0151, B:14:0x0063, B:16:0x00a0), top: B:55:0x000e }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0202 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x0203  */
        public final Object invokeSuspend(Object $result) {
            String currentMonth;
            SharedPreferences prefs;
            Ref.DoubleRef currentAmount;
            Ref.IntRef supportersCount;
            String token;
            String token2;
            Ref.IntRef supportersCount2;
            Ref.DoubleRef currentAmount2;
            SharedPreferences prefs2;
            String currentMonth2;
            Object objFetchBuyMeACoffeeMonthly;
            int i;
            int i2;
            String goalTitle;
            DonationConfig config;
            String primaryButtonText;
            Pair bmcResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        currentMonth = DonationManager.INSTANCE.getCurrentMonthName();
                        prefs = DonationManager.INSTANCE.getPrefs(this.$activity.getApplicationContext());
                        currentAmount = new Ref.DoubleRef();
                        currentAmount.element = prefs.getFloat(DonationManager.KEY_CACHED_AMOUNT, 0.0f);
                        supportersCount = new Ref.IntRef();
                        supportersCount.element = prefs.getInt(DonationManager.KEY_CACHED_SUPPORTERS, 0);
                        token = DonationManager.INSTANCE.getDecryptedBmcToken();
                        if (StringsKt.isBlank(token)) {
                            token2 = token;
                            supportersCount2 = supportersCount;
                            currentAmount2 = currentAmount;
                            prefs2 = prefs;
                            currentMonth2 = currentMonth;
                        } else {
                            this.L$0 = currentMonth;
                            this.L$1 = prefs;
                            this.L$2 = currentAmount;
                            this.L$3 = supportersCount;
                            this.L$4 = SpillingKt.nullOutSpilledVariable(token);
                            this.label = 1;
                            objFetchBuyMeACoffeeMonthly = DonationManager.INSTANCE.fetchBuyMeACoffeeMonthly(token, (Continuation) this);
                            if (objFetchBuyMeACoffeeMonthly == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            bmcResult = (Pair) objFetchBuyMeACoffeeMonthly;
                            if (bmcResult != null) {
                                currentAmount.element = ((Number) bmcResult.getFirst()).doubleValue();
                                supportersCount.element = ((Number) bmcResult.getSecond()).intValue();
                                SharedPreferences $this$edit$iv = prefs;
                                SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
                                Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
                                editor$iv.putString(DonationManager.KEY_CACHED_MONTH, currentMonth).putFloat(DonationManager.KEY_CACHED_AMOUNT, (float) currentAmount.element).putInt(DonationManager.KEY_CACHED_SUPPORTERS, supportersCount.element);
                                editor$iv.apply();
                            }
                            token2 = token;
                            supportersCount2 = supportersCount;
                            currentAmount2 = currentAmount;
                            prefs2 = prefs;
                            currentMonth2 = currentMonth;
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
                        i2 = i;
                        if (i2 != 0) {
                            goalTitle = "Goal Achieved for Phisher Repo!";
                        } else {
                            goalTitle = DonationManager.INSTANCE.getGoalTitle();
                        }
                        String dynamicTitle = goalTitle;
                        String str = this.$providerName;
                        String goalDescription = DonationManager.INSTANCE.getGoalDescription();
                        String currency = DonationManager.INSTANCE.getCurrency();
                        double targetAmount = DonationManager.INSTANCE.getTargetAmount();
                        double d = currentAmount2.element;
                        int i3 = supportersCount2.element;
                        String primaryDonateUrl = DonationManager.INSTANCE.getPrimaryDonateUrl();
                        if (i2 != 0) {
                            primaryButtonText = "☕ Send Extra Love";
                        } else {
                            primaryButtonText = DonationManager.INSTANCE.getPrimaryButtonText();
                        }
                        config = new DonationConfig(true, str, currentMonth2, dynamicTitle, goalDescription, currency, targetAmount, d, i3, primaryDonateUrl, primaryButtonText, DonationManager.INSTANCE.getSecondaryDonateUrl(), DonationManager.INSTANCE.getSecondaryButtonText(), DonationManager.INSTANCE.getAdSupportUrl(), DonationManager.INSTANCE.getAdSupportButtonText(), DonationManager.INSTANCE.getCooldownHours(), null, 65536, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(currentMonth2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(prefs2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(currentAmount2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(supportersCount2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(token2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(dynamicTitle);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(config);
                        this.I$0 = i2;
                        this.label = 2;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$activity, config, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        token = (String) this.L$4;
                        supportersCount = (Ref.IntRef) this.L$3;
                        currentAmount = (Ref.DoubleRef) this.L$2;
                        prefs = (SharedPreferences) this.L$1;
                        currentMonth = (String) this.L$0;
                        ResultKt.throwOnFailure($result);
                        objFetchBuyMeACoffeeMonthly = $result;
                        bmcResult = (Pair) objFetchBuyMeACoffeeMonthly;
                        if (bmcResult != null) {
                            currentAmount.element = ((Number) bmcResult.getFirst()).doubleValue();
                            supportersCount.element = ((Number) bmcResult.getSecond()).intValue();
                            SharedPreferences $this$edit$iv2 = prefs;
                            SharedPreferences.Editor editor$iv2 = $this$edit$iv2.edit();
                            Intrinsics.checkExpressionValueIsNotNull(editor$iv2, "editor");
                            editor$iv2.putString(DonationManager.KEY_CACHED_MONTH, currentMonth).putFloat(DonationManager.KEY_CACHED_AMOUNT, (float) currentAmount.element).putInt(DonationManager.KEY_CACHED_SUPPORTERS, supportersCount.element);
                            editor$iv2.apply();
                        }
                        token2 = token;
                        supportersCount2 = supportersCount;
                        currentAmount2 = currentAmount;
                        prefs2 = prefs;
                        currentMonth2 = currentMonth;
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
                        i2 = i;
                        if (i2 != 0) {
                            goalTitle = "Goal Achieved for Phisher Repo!";
                        } else {
                            goalTitle = DonationManager.INSTANCE.getGoalTitle();
                        }
                        String dynamicTitle2 = goalTitle;
                        String str2 = this.$providerName;
                        String goalDescription2 = DonationManager.INSTANCE.getGoalDescription();
                        String currency2 = DonationManager.INSTANCE.getCurrency();
                        double targetAmount2 = DonationManager.INSTANCE.getTargetAmount();
                        double d2 = currentAmount2.element;
                        int i4 = supportersCount2.element;
                        String primaryDonateUrl2 = DonationManager.INSTANCE.getPrimaryDonateUrl();
                        if (i2 != 0) {
                            primaryButtonText = "☕ Send Extra Love";
                        } else {
                            primaryButtonText = DonationManager.INSTANCE.getPrimaryButtonText();
                        }
                        config = new DonationConfig(true, str2, currentMonth2, dynamicTitle2, goalDescription2, currency2, targetAmount2, d2, i4, primaryDonateUrl2, primaryButtonText, DonationManager.INSTANCE.getSecondaryDonateUrl(), DonationManager.INSTANCE.getSecondaryButtonText(), DonationManager.INSTANCE.getAdSupportUrl(), DonationManager.INSTANCE.getAdSupportButtonText(), DonationManager.INSTANCE.getCooldownHours(), null, 65536, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(currentMonth2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(prefs2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(currentAmount2);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(supportersCount2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(token2);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(dynamicTitle2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(config);
                        this.I$0 = i2;
                        this.label = 2;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$activity, config, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 2:
                        int i5 = this.I$0;
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
                this.L$5 = null;
                this.L$6 = null;
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass4(this.$activity, this.$providerName, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }

        /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$showNow$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.donation.DonationManager$showNow$1$2", f = "DonationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AppCompatActivity $activity;
            final /* synthetic */ DonationConfig $config;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AppCompatActivity appCompatActivity, DonationConfig donationConfig, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$activity = appCompatActivity;
                this.$config = donationConfig;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$activity, this.$config, continuation);
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
                        Fragment donationDialogFragment = new DonationDialogFragment(this.$config, new Function0() { // from class: com.phisher98.donation.DonationManager$showNow$1$2$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                return DonationManager.C00231.AnonymousClass2.invokeSuspend$lambda$0();
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

        /* JADX INFO: renamed from: com.phisher98.donation.DonationManager$showNow$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.donation.DonationManager$showNow$1$4", f = "DonationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AppCompatActivity $activity;
            final /* synthetic */ String $providerName;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(AppCompatActivity appCompatActivity, String str, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$activity = appCompatActivity;
                this.$providerName = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$activity, this.$providerName, continuation);
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
                        Fragment donationDialogFragment = new DonationDialogFragment(new DonationConfig(false, this.$providerName, DonationManager.INSTANCE.getCurrentMonthName(), DonationManager.INSTANCE.getGoalTitle(), null, null, 0.0d, 0.0d, 0, DonationManager.INSTANCE.getPrimaryDonateUrl(), DonationManager.INSTANCE.getPrimaryButtonText(), null, null, DonationManager.INSTANCE.getAdSupportUrl(), DonationManager.INSTANCE.getAdSupportButtonText(), 0, null, 104945, null), new Function0() { // from class: com.phisher98.donation.DonationManager$showNow$1$4$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                return DonationManager.C00231.AnonymousClass4.invokeSuspend$lambda$0();
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
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new C00231(activity, providerName, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:141:0x01e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x029b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x0276 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x010b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0198 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x0199  */
    /* JADX WARN: Code duplicated, block: B:39:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:41:0x01bf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:43:0x01cc A[Catch: all -> 0x02f4, TryCatch #7 {all -> 0x02f4, blocks: (B:37:0x01ab, B:43:0x01cc, B:45:0x01d6), top: B:149:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:45:0x01d6 A[Catch: all -> 0x02f4, TRY_LEAVE, TryCatch #7 {all -> 0x02f4, blocks: (B:37:0x01ab, B:43:0x01cc, B:45:0x01d6), top: B:149:0x01ab }] */
    /* JADX WARN: Code duplicated, block: B:50:0x020b A[Catch: all -> 0x02c9, TryCatch #3 {all -> 0x02c9, blocks: (B:48:0x01e4, B:50:0x020b, B:52:0x0211, B:54:0x022f, B:56:0x0236, B:66:0x028b, B:57:0x025c, B:59:0x0269, B:61:0x026f, B:68:0x02a9), top: B:141:0x01e4 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0211 A[Catch: all -> 0x02c9, TryCatch #3 {all -> 0x02c9, blocks: (B:48:0x01e4, B:50:0x020b, B:52:0x0211, B:54:0x022f, B:56:0x0236, B:66:0x028b, B:57:0x025c, B:59:0x0269, B:61:0x026f, B:68:0x02a9), top: B:141:0x01e4 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x022f A[Catch: all -> 0x02c9, TryCatch #3 {all -> 0x02c9, blocks: (B:48:0x01e4, B:50:0x020b, B:52:0x0211, B:54:0x022f, B:56:0x0236, B:66:0x028b, B:57:0x025c, B:59:0x0269, B:61:0x026f, B:68:0x02a9), top: B:141:0x01e4 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x025c A[Catch: all -> 0x02c9, TryCatch #3 {all -> 0x02c9, blocks: (B:48:0x01e4, B:50:0x020b, B:52:0x0211, B:54:0x022f, B:56:0x0236, B:66:0x028b, B:57:0x025c, B:59:0x0269, B:61:0x026f, B:68:0x02a9), top: B:141:0x01e4 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0269 A[Catch: all -> 0x02c9, TryCatch #3 {all -> 0x02c9, blocks: (B:48:0x01e4, B:50:0x020b, B:52:0x0211, B:54:0x022f, B:56:0x0236, B:66:0x028b, B:57:0x025c, B:59:0x0269, B:61:0x026f, B:68:0x02a9), top: B:141:0x01e4 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0278  */
    /* JADX WARN: Code duplicated, block: B:65:0x0283  */
    /* JADX WARN: Code duplicated, block: B:70:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0199 -> B:165:0x01a3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object fetchBuyMeACoffeeMonthly(java.lang.String r60, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Double, java.lang.Integer>> r61) {
        /*
            Method dump skipped, instruction units count: 1334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.donation.DonationManager.fetchBuyMeACoffeeMonthly(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Date fetchBuyMeACoffeeMonthly$parseDate(SimpleDateFormat dateFormat, String raw) {
        Object obj;
        Object obj2;
        if (StringsKt.isBlank(raw)) {
            return null;
        }
        if (new Regex("\\d+").matches(raw)) {
            long millis = Long.parseLong(raw) * (raw.length() > 10 ? 1L : 1000L);
            DonationManager donationManager = INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                obj2 = Result.constructor-impl(new Date(millis));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return (Date) (Result.isFailure-impl(obj2) ? null : obj2);
        }
        DonationManager donationManager2 = INSTANCE;
        try {
            Result.Companion companion3 = Result.Companion;
            obj = Result.constructor-impl(dateFormat.parse(raw));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        return (Date) (Result.isFailure-impl(obj) ? null : obj);
    }
}
