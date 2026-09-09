package com.cncverse.donation;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: DonationManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TamilDhoolProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020\u0011J\u000e\u0010N\u001a\u00020I2\u0006\u0010M\u001a\u00020\u0011J\u000e\u0010O\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u001e\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020:2\u0006\u0010M\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010SJ\u0018\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010U2\u0006\u0010V\u001a\u00020WH\u0002J\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00010U2\u0006\u0010V\u001a\u00020WH\u0002J\u0018\u0010Y\u001a\u00020I2\u0006\u0010R\u001a\u00020:2\u0006\u0010Z\u001a\u00020QH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001a\u0010(\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001a\u0010+\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u00104\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b5\u0010\rR\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020=X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/cncverse/donation/DonationManager;", "", "<init>", "()V", "testMode", "", "getTestMode", "()Z", "setTestMode", "(Z)V", "testProgressAmount", "", "getTestProgressAmount", "()D", "setTestProgressAmount", "(D)V", "primaryDonateUrl", "", "getPrimaryDonateUrl", "()Ljava/lang/String;", "setPrimaryDonateUrl", "(Ljava/lang/String;)V", "primaryButtonText", "getPrimaryButtonText", "setPrimaryButtonText", "secondaryDonateUrl", "getSecondaryDonateUrl", "setSecondaryDonateUrl", "secondaryButtonText", "getSecondaryButtonText", "setSecondaryButtonText", "adSupportUrl", "getAdSupportUrl", "setAdSupportUrl", "adSupportButtonText", "getAdSupportButtonText", "setAdSupportButtonText", "currency", "getCurrency", "setCurrency", "goalTitle", "getGoalTitle", "setGoalTitle", "goalDescription", "getGoalDescription", "setGoalDescription", "cooldownHours", "", "getCooldownHours", "()I", "setCooldownHours", "(I)V", "targetAmount", "getTargetAmount", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroidx/appcompat/app/AppCompatActivity;", "gateLock", "lastTriggerMs", "", "GATE_WINDOW_MS", "PREFS", "KEY_LAST_SHOWN_DAY", "KEY_ACHIEVED_MONTH", "KEY_CACHED_MONTH", "KEY_CACHED_AMOUNT", "KEY_CACHED_GOAL", "KEY_CACHED_SUPPORT", "KEY_CACHED_PERCENT", "STATS_URL", "setActivity", "", "context", "Landroid/content/Context;", "checkAndShow", "providerName", "showNow", "resetCooldown", "buildConfig", "Lcom/cncverse/donation/DonationConfig;", "activity", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchStats", "", "prefs", "Landroid/content/SharedPreferences;", "readCache", "showDialog", "config", "TamilDhoolProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDonationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DonationManager.kt\ncom/cncverse/donation/DonationManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,200:1\n1#2:201\n*E\n"})
public final class DonationManager {
    private static final long GATE_WINDOW_MS = 60000;

    @NotNull
    private static final String KEY_ACHIEVED_MONTH = "cncverse_donation_achieved_shown_month";

    @NotNull
    private static final String KEY_CACHED_AMOUNT = "cncverse_donation_cached_amount";

    @NotNull
    private static final String KEY_CACHED_GOAL = "cncverse_donation_cached_goal";

    @NotNull
    private static final String KEY_CACHED_MONTH = "cncverse_donation_cached_month";

    @NotNull
    private static final String KEY_CACHED_PERCENT = "cncverse_donation_cached_percent";

    @NotNull
    private static final String KEY_CACHED_SUPPORT = "cncverse_donation_cached_supporters";

    @NotNull
    private static final String KEY_LAST_SHOWN_DAY = "last_shown_day";

    @NotNull
    private static final String PREFS = "cncverse_donation";

    @NotNull
    private static final String STATS_URL = "https://cncverse.pages.dev/api/stats";

    @Nullable
    private static WeakReference<AppCompatActivity> activityRef;
    private static volatile long lastTriggerMs;
    private static boolean testMode;
    private static double testProgressAmount;

    @NotNull
    public static final DonationManager INSTANCE = new DonationManager();

    @NotNull
    private static String primaryDonateUrl = "https://cncverse.pages.dev";

    @NotNull
    private static String primaryButtonText = "☕ Keep It Alive";

    @NotNull
    private static String secondaryDonateUrl = "";

    @NotNull
    private static String secondaryButtonText = "⚡ Donate via UPI / Other";

    @NotNull
    private static String adSupportUrl = DonationConfig.INSTANCE.decodeOmg10();

    @NotNull
    private static String adSupportButtonText = "🎬 Can't donate? Watch an Ad to Support ↗";

    @NotNull
    private static String currency = "$";

    @NotNull
    private static String goalTitle = "Help Keep CNCVerse Alive";

    @NotNull
    private static String goalDescription = "";
    private static int cooldownHours = 24;

    @NotNull
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    @NotNull
    private static final Object gateLock = new Object();

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

    public final double getTargetAmount() {
        return DonationConfig.INSTANCE.dynamicTargetAmount();
    }

    public final void setActivity(@NotNull Context context) {
        AppCompatActivity it = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (it != null) {
            activityRef = new WeakReference<>(it);
        }
    }

    public final void checkAndShow(@NotNull String providerName) {
        AppCompatActivity activity;
        long now = System.currentTimeMillis();
        synchronized (gateLock) {
            if (now - lastTriggerMs < GATE_WINDOW_MS) {
                return;
            }
            lastTriggerMs = now;
            Unit unit = Unit.INSTANCE;
            WeakReference<AppCompatActivity> weakReference = activityRef;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            if (!testMode) {
                String today = new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date());
                SharedPreferences prefs = activity.getSharedPreferences(PREFS, 0);
                String lastShown = prefs.getString(KEY_LAST_SHOWN_DAY, "");
                if (Intrinsics.areEqual(today, lastShown)) {
                    return;
                }
            }
            BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new C00112(activity, providerName, null), 3, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.donation.DonationManager$checkAndShow$2 */
    /* JADX INFO: compiled from: DonationManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.donation.DonationManager$checkAndShow$2", f = "DonationManager.kt", i = {1}, l = {97, 98}, m = "invokeSuspend", n = {"config"}, nl = {98, 101}, s = {"L$0"}, v = 2)
    static final class C00112 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatActivity $activity;
        final /* synthetic */ String $providerName;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00112(AppCompatActivity appCompatActivity, String str, Continuation<? super C00112> continuation) {
            super(2, continuation);
            this.$activity = appCompatActivity;
            this.$providerName = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00112(this.$activity, this.$providerName, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0058 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0059  */
        public final Object invokeSuspend(Object $result) {
            Object objBuildConfig;
            DonationConfig config;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    objBuildConfig = DonationManager.INSTANCE.buildConfig(this.$activity, this.$providerName, (Continuation) this);
                    if (objBuildConfig == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    config = (DonationConfig) objBuildConfig;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(config);
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$activity, config, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objBuildConfig = $result;
                    config = (DonationConfig) objBuildConfig;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(config);
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$activity, config, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.cncverse.donation.DonationManager$checkAndShow$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.cncverse.donation.DonationManager$checkAndShow$2$1", f = "DonationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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
                        DonationManager.INSTANCE.showDialog(this.$activity, this.$config);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.donation.DonationManager$showNow$1 */
    /* JADX INFO: compiled from: DonationManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.donation.DonationManager$showNow$1", f = "DonationManager.kt", i = {1}, l = {110, 111}, m = "invokeSuspend", n = {"config"}, nl = {111, 114}, s = {"L$0"}, v = 2)
    static final class C00121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatActivity $activity;
        final /* synthetic */ String $providerName;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00121(AppCompatActivity appCompatActivity, String str, Continuation<? super C00121> continuation) {
            super(2, continuation);
            this.$activity = appCompatActivity;
            this.$providerName = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00121(this.$activity, this.$providerName, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0058 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0059  */
        public final Object invokeSuspend(Object $result) {
            Object objBuildConfig;
            DonationConfig config;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    objBuildConfig = DonationManager.INSTANCE.buildConfig(this.$activity, this.$providerName, (Continuation) this);
                    if (objBuildConfig == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    config = (DonationConfig) objBuildConfig;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(config);
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$activity, config, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objBuildConfig = $result;
                    config = (DonationConfig) objBuildConfig;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(config);
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$activity, config, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.cncverse.donation.DonationManager$showNow$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: DonationManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.cncverse.donation.DonationManager$showNow$1$1", f = "DonationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
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
                        DonationManager.INSTANCE.showDialog(this.$activity, this.$config);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    public final void showNow(@NotNull String providerName) {
        AppCompatActivity activity;
        WeakReference<AppCompatActivity> weakReference = activityRef;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new C00121(activity, providerName, null), 3, (Object) null);
    }

    public final void resetCooldown(@NotNull Context context) {
        context.getSharedPreferences(PREFS, 0).edit().remove(KEY_LAST_SHOWN_DAY).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object buildConfig(AppCompatActivity activity, String providerName, Continuation<? super DonationConfig> continuation) {
        List<Object> listFetchStats;
        SharedPreferences prefs = activity.getSharedPreferences(PREFS, 0);
        if (testMode && testProgressAmount > 0.0d) {
            double fakeGoal = getTargetAmount();
            int fakePct = RangesKt.coerceIn((int) ((testProgressAmount / fakeGoal) * ((double) 100)), 0, 100);
            listFetchStats = CollectionsKt.listOf(new Object[]{Boxing.boxDouble(testProgressAmount), Boxing.boxDouble(fakeGoal), Boxing.boxDouble(fakePct), Boxing.boxDouble(12.0d), "September"});
        } else {
            listFetchStats = fetchStats(prefs);
            if (listFetchStats == null) {
                listFetchStats = readCache(prefs);
            }
        }
        Object amount = listFetchStats.get(0);
        Object goal = listFetchStats.get(1);
        Object percent = listFetchStats.get(2);
        Object supporters = listFetchStats.get(3);
        Object month = listFetchStats.get(4);
        if (!testMode) {
            String today = new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date());
            prefs.edit().putString(KEY_LAST_SHOWN_DAY, today).apply();
        }
        Intrinsics.checkNotNull(month, "null cannot be cast to non-null type kotlin.String");
        String str = goalTitle;
        String str2 = goalDescription;
        String str3 = currency;
        Intrinsics.checkNotNull(goal, "null cannot be cast to non-null type kotlin.Double");
        double dDoubleValue = ((Double) goal).doubleValue();
        Intrinsics.checkNotNull(amount, "null cannot be cast to non-null type kotlin.Double");
        double dDoubleValue2 = ((Double) amount).doubleValue();
        Intrinsics.checkNotNull(supporters, "null cannot be cast to non-null type kotlin.Double");
        int iDoubleValue = (int) ((Double) supporters).doubleValue();
        Intrinsics.checkNotNull(percent, "null cannot be cast to non-null type kotlin.Double");
        return new DonationConfig(false, providerName, (String) month, str, str2, str3, dDoubleValue, dDoubleValue2, iDoubleValue, (int) ((Double) percent).doubleValue(), primaryDonateUrl, primaryButtonText, secondaryDonateUrl, secondaryButtonText, adSupportUrl, adSupportButtonText, cooldownHours, 1, null);
    }

    private final List<Object> fetchStats(SharedPreferences prefs) {
        try {
            JSONObject json = new JSONObject(new String(TextStreamsKt.readBytes(new URL(STATS_URL)), Charsets.UTF_8));
            double amount = json.optDouble("totalUsd", 0.0d);
            double goal = json.optDouble("targetGoalUsd", getTargetAmount());
            int pct = json.optInt("percent", -1);
            int sup = json.optInt("supporterCount", 0);
            String month = json.optString("month", "Monthly Goal");
            prefs.edit().putFloat(KEY_CACHED_AMOUNT, (float) amount).putFloat(KEY_CACHED_GOAL, (float) goal).putInt(KEY_CACHED_SUPPORT, sup).putInt(KEY_CACHED_PERCENT, pct).putString(KEY_CACHED_MONTH, month).apply();
            return CollectionsKt.listOf(new Object[]{Double.valueOf(amount), Double.valueOf(goal), Double.valueOf(pct), Double.valueOf(sup), month});
        } catch (Exception e) {
            return null;
        }
    }

    private final List<Object> readCache(SharedPreferences prefs) {
        Double dValueOf = Double.valueOf(prefs.getFloat(KEY_CACHED_AMOUNT, 0.0f));
        Double dValueOf2 = Double.valueOf(prefs.getFloat(KEY_CACHED_GOAL, (float) getTargetAmount()));
        Double dValueOf3 = Double.valueOf(prefs.getInt(KEY_CACHED_PERCENT, -1));
        Double dValueOf4 = Double.valueOf(prefs.getInt(KEY_CACHED_SUPPORT, 0));
        String string = prefs.getString(KEY_CACHED_MONTH, "Monthly Goal");
        return CollectionsKt.listOf(new Object[]{dValueOf, dValueOf2, dValueOf3, dValueOf4, string != null ? string : "Monthly Goal"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialog(AppCompatActivity activity, DonationConfig config) {
        try {
            Fragment existing = activity.getSupportFragmentManager().findFragmentByTag("donation_dialog");
            if (existing != null) {
                return;
            }
            DonationDialogFragment.INSTANCE.newInstance(config).show(activity.getSupportFragmentManager(), "donation_dialog");
        } catch (Exception e) {
        }
    }
}
