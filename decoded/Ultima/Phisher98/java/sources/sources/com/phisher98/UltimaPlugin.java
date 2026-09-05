package com.phisher98;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainActivity;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import com.lagradost.cloudstream3.ui.home.HomeViewModel;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaPlugin.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0012H\u0002J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\u001206H\u0002J\b\u00107\u001a\u000203H\u0002J \u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\u0002032\u0006\u00109\u001a\u00020:H\u0082@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u000203H\u0002J\u0010\u0010@\u001a\u0002032\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010A\u001a\u0002032\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u0016J\b\u0010B\u001a\u00020\u0018H\u0002J\u0016\u0010C\u001a\u0002032\u0006\u00109\u001a\u00020:H\u0086@¢\u0006\u0002\u0010>J\u0006\u0010D\u001a\u000203J&\u0010E\u001a\u0002032\u0006\u00109\u001a\u00020:2\u0006\u00104\u001a\u00020\u00122\u0006\u0010F\u001a\u00020GH\u0082@¢\u0006\u0002\u0010HJ\u0016\u0010I\u001a\u0002032\u0006\u00109\u001a\u00020:H\u0086@¢\u0006\u0002\u0010>R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0018\u00010$j\u0004\u0018\u0001`%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0018\u00010$j\u0004\u0018\u0001`%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\u0002\bL¨\u0006K"}, d2 = {"Lcom/phisher98/UltimaPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "setActivity", "(Landroidx/appcompat/app/AppCompatActivity;)V", "lifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "registeredApp", "Landroid/app/Application;", "pluginScope", "Lkotlinx/coroutines/CoroutineScope;", "dirtyCategories", "", "Lcom/phisher98/SyncCategory;", "dirtyCategoriesLock", "", "isRestoring", "", "restoringUntil", "", "RESTORE_GUARD_MS", "sseLock", "pullMutex", "Lkotlinx/coroutines/sync/Mutex;", "syncMutex", "dataPrefsListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "defaultPrefsListener", "mainHandler", "Landroid/os/Handler;", "pushRunnable", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "ssePullRunnable", "sseCall", "Lokhttp3/Call;", "isSseConnected", "lastSseSyncKey", "", "lastSseUrl", "sseRetryCount", "", "SSE_MAX_BACKOFF_MS", "SSE_BASE_DELAY_MS", "lastPushTimestamp", "markDirty", "", "category", "consumeDirtyCategories", "", "scheduleDebouncedPush", "pullChangedCategories", "context", "Landroid/content/Context;", "force", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrateFromV1", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "load", "startSseListener", "calculateSseBackoff", "pushAllCategories", "reload", "restoreAndReload", "backupFile", "Lcom/phisher98/BackupFile;", "(Landroid/content/Context;Lcom/phisher98/SyncCategory;Lcom/phisher98/BackupFile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergeAndSyncAllCategories", "Companion", "Ultima", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@CloudstreamPlugin
@SourceDebugExtension({"SMAP\nUltimaPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaPlugin.kt\ncom/phisher98/UltimaPlugin\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,866:1\n1#2:867\n117#3,7:868\n125#3,2:877\n50#4:875\n43#4:876\n50#4:882\n43#4:883\n777#5:879\n873#5,2:880\n1739#5:884\n1814#5,3:885\n*S KotlinDebug\n*F\n+ 1 UltimaPlugin.kt\ncom/phisher98/UltimaPlugin\n*L\n133#1:868,7\n133#1:877,2\n179#1:875\n179#1:876\n747#1:882\n747#1:883\n710#1:879\n710#1:880,2\n854#1:884\n854#1:885,3\n*E\n"})
public final class UltimaPlugin extends Plugin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long IGNORE_OWN_PUSH_MS = 5000;
    private static final long PUSH_DEBOUNCE_MS = 2000;
    private static final long SSE_PULL_DEBOUNCE_MS = 3000;

    @NotNull
    private static final String TAG = "UltimaSync";

    @Nullable
    private static UltimaPlugin instance;

    @Nullable
    private AppCompatActivity activity;

    @Nullable
    private SharedPreferences.OnSharedPreferenceChangeListener dataPrefsListener;

    @Nullable
    private SharedPreferences.OnSharedPreferenceChangeListener defaultPrefsListener;
    private volatile boolean isRestoring;
    private volatile boolean isSseConnected;
    private volatile long lastPushTimestamp;

    @Nullable
    private String lastSseSyncKey;

    @Nullable
    private String lastSseUrl;

    @Nullable
    private Application.ActivityLifecycleCallbacks lifecycleCallbacks;

    @Nullable
    private Runnable pushRunnable;

    @Nullable
    private Application registeredApp;
    private volatile long restoringUntil;

    @Nullable
    private Call sseCall;

    @Nullable
    private Runnable ssePullRunnable;
    private volatile int sseRetryCount;

    @NotNull
    private CoroutineScope pluginScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));

    @NotNull
    private final Set<SyncCategory> dirtyCategories = new LinkedHashSet();

    @NotNull
    private final Object dirtyCategoriesLock = new Object();
    private final long RESTORE_GUARD_MS = IGNORE_OWN_PUSH_MS;

    @NotNull
    private final Object sseLock = new Object();

    @NotNull
    private final Mutex pullMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private final Mutex syncMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final long SSE_MAX_BACKOFF_MS = 60000;
    private final long SSE_BASE_DELAY_MS = IGNORE_OWN_PUSH_MS;

    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SyncCategory.values().length];
            try {
                iArr[SyncCategory.EXTENSIONS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SyncCategory.BOOKMARKS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SyncCategory.SETTINGS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$mergeAndSyncAllCategories$1 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin", f = "UltimaPlugin.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, l = {706, 707, 714, 769, 773, 773, 813, 817, 817, 849}, m = "mergeAndSyncAllCategories", n = {"context", "appContext", "creds", "currentDirtyCategories", "context", "appContext", "creds", "currentDirtyCategories", "manifest", "context", "appContext", "creds", "currentDirtyCategories", "manifest", "resumeWatching", "enabledCategories", "context", "appContext", "creds", "currentDirtyCategories", "manifest", "resumeWatching", "enabledCategories", "cloudPayloads", "categoriesToPush", "category", "cloudPayload", "cloudBackup", "localBackup", "cloudMeta", "cloudHash", "localHash", "restoredAny", "isBackup", "isRestore", "isLocalEmpty", "isCloudEmpty", "context", "appContext", "creds", "currentDirtyCategories", "manifest", "resumeWatching", "enabledCategories", "cloudPayloads", "categoriesToPush", "category", "cloudPayload", "cloudBackup", "localBackup", "cloudMeta", "cloudHash", "localHash", "restoredAny", "isBackup", "isRestore", "isLocalEmpty", "isCloudEmpty", "context", "appContext", "creds", "currentDirtyCategories", "manifest", "resumeWatching", "enabledCategories", "cloudPayloads", "categoriesToPush", "category", "cloudPayload", "cloudBackup", "localBackup", "cloudMeta", "cloudHash", "localHash", "restoredAny", "isBackup", "isRestore", "isLocalEmpty", "isCloudEmpty", "context", "appContext", "creds", "currentDirtyCategories", "manifest", "resumeWatching", "enabledCategories", "cloudPayloads", "categoriesToPush", "category", "cloudPayload", "cloudBackup", "localBackup", "mergedBackup", "data", "hash", "liveLocalData", "liveLocalHash", "cloudMeta", "cloudHash", "restoredAny", "isBackup", "isRestore", "isLocalEmpty", "isCloudEmpty", "localCategoryTs", "cloudPayloadTs", "isLocallyDirty", "context", "appContext", "creds", "currentDirtyCategories", "manifest", "resumeWatching", "enabledCategories", "cloudPayloads", "categoriesToPush", "category", "cloudPayload", "cloudBackup", "localBackup", "mergedBackup", "data", "hash", "liveLocalData", "liveLocalHash", "cloudMeta", "cloudHash", "restoredAny", "isBackup", "isRestore", "isLocalEmpty", "isCloudEmpty", "localCategoryTs", "cloudPayloadTs", "isLocallyDirty", "context", "appContext", "creds", "currentDirtyCategories", "manifest", "resumeWatching", "enabledCategories", "cloudPayloads", "categoriesToPush", "category", "cloudPayload", "cloudBackup", "localBackup", "mergedBackup", "data", "hash", "liveLocalData", "liveLocalHash", "cloudMeta", "cloudHash", "restoredAny", "isBackup", "isRestore", "isLocalEmpty", "isCloudEmpty", "localCategoryTs", "cloudPayloadTs", "isLocallyDirty", "context", "appContext", "creds", "currentDirtyCategories", "manifest", "resumeWatching", "enabledCategories", "cloudPayloads", "categoriesToPush", "restoredAny"}, nl = {707, 710, 736, 770, 776, 777, 814, 820, 821, 850}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "I$0", "Z$0", "Z$1", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "I$0", "Z$0", "Z$1", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "I$0", "Z$0", "Z$1", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "I$0", "Z$0", "Z$1", "I$1", "I$2", "J$0", "J$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "I$0", "Z$0", "Z$1", "I$1", "I$2", "J$0", "J$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "I$0", "Z$0", "Z$1", "I$1", "I$2", "J$0", "J$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaPlugin.this.mergeAndSyncAllCategories(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$migrateFromV1$1 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin", f = "UltimaPlugin.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5}, l = {239, 243, 247, 263, 267, 270}, m = "migrateFromV1", n = {"context", "creds", "context", "creds", "oldData", "context", "creds", "oldData", "context", "creds", "oldData", "resumeWatching", "categoryData", "context", "creds", "oldData", "resumeWatching", "categoryData", "context", "creds", "oldData", "resumeWatching", "categoryData"}, nl = {240, 247, 250, 267, 268, 274}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaPlugin.this.migrateFromV1(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$pullChangedCategories$1 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin", f = "UltimaPlugin.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {871, 134, 154, 184, 188, 215, 215}, m = "pullChangedCategories", n = {"context", "appContext", "creds", "$this$withLock_u24default$iv", "force", "context", "appContext", "creds", "$this$withLock_u24default$iv", "force", "context", "appContext", "creds", "$this$withLock_u24default$iv", "manifest", "categoriesToFetch", "force", "context", "appContext", "creds", "$this$withLock_u24default$iv", "manifest", "categoriesToFetch", "fetchedPayloads", "category", "cloudMeta", "payload", "backupFile", "force", "restoredAny", "context", "appContext", "creds", "$this$withLock_u24default$iv", "manifest", "categoriesToFetch", "fetchedPayloads", "category", "cloudMeta", "payload", "backupFile", "force", "restoredAny", "context", "appContext", "creds", "$this$withLock_u24default$iv", "manifest", "categoriesToFetch", "fetchedPayloads", "force", "restoredAny", "context", "appContext", "creds", "$this$withLock_u24default$iv", "manifest", "categoriesToFetch", "fetchedPayloads", "force", "restoredAny"}, nl = {872, 135, 170, 187, 198, 218, 220}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0"}, v = 2)
    static final class C00151 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaPlugin.this.pullChangedCategories(null, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$pushAllCategories$1 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin", f = "UltimaPlugin.kt", i = {0, 0, 1, 1, 1, 1}, l = {620, 640}, m = "pushAllCategories", n = {"context", "creds", "context", "creds", "resumeWatching", "categoryData"}, nl = {623, 641}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00161(Continuation<? super C00161> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaPlugin.this.pushAllCategories(null, (Continuation) this);
        }
    }

    @Nullable
    public final AppCompatActivity getActivity() {
        return this.activity;
    }

    public final void setActivity(@Nullable AppCompatActivity appCompatActivity) {
        this.activity = appCompatActivity;
    }

    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/phisher98/UltimaPlugin$Companion;", "", "<init>", "()V", "instance", "Lcom/phisher98/UltimaPlugin;", "getInstance", "()Lcom/phisher98/UltimaPlugin;", "setInstance", "(Lcom/phisher98/UltimaPlugin;)V", "TAG", "", "PUSH_DEBOUNCE_MS", "", "SSE_PULL_DEBOUNCE_MS", "IGNORE_OWN_PUSH_MS", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final UltimaPlugin getInstance() {
            return UltimaPlugin.instance;
        }

        public final void setInstance(@Nullable UltimaPlugin ultimaPlugin) {
            UltimaPlugin.instance = ultimaPlugin;
        }
    }

    private final void markDirty(SyncCategory category) {
        synchronized (this.dirtyCategoriesLock) {
            this.dirtyCategories.add(category);
        }
        scheduleDebouncedPush();
    }

    private final Set<SyncCategory> consumeDirtyCategories() {
        Set<SyncCategory> set;
        synchronized (this.dirtyCategoriesLock) {
            set = CollectionsKt.toSet(this.dirtyCategories);
            this.dirtyCategories.clear();
        }
        return set;
    }

    private final void scheduleDebouncedPush() {
        final Context ctx = CloudStreamApp.Companion.getContext();
        if (ctx == null) {
            AppCompatActivity appCompatActivity = this.activity;
            if (appCompatActivity == null) {
                return;
            } else {
                ctx = (Context) appCompatActivity;
            }
        }
        AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
        if (creds == null || !creds.isLoggedIn() || !creds.getBackupDevice()) {
            return;
        }
        Runnable it = this.pushRunnable;
        if (it != null) {
            this.mainHandler.removeCallbacks(it);
        }
        Runnable runnable = new Runnable() { // from class: com.phisher98.UltimaPlugin$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UltimaPlugin ultimaPlugin = this.f$0;
                BuildersKt.launch$default(ultimaPlugin.pluginScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaPlugin$scheduleDebouncedPush$runnable$1$1(ultimaPlugin, ctx, null), 3, (Object) null);
            }
        };
        this.pushRunnable = runnable;
        this.mainHandler.postDelayed(runnable, PUSH_DEBOUNCE_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:127:0x042c A[Catch: all -> 0x0a09, TRY_LEAVE, TryCatch #31 {all -> 0x0a09, blocks: (B:125:0x0426, B:127:0x042c, B:129:0x044b), top: B:312:0x0426 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x05fd A[Catch: all -> 0x06c9, Exception -> 0x06e0, TRY_LEAVE, TryCatch #42 {Exception -> 0x06e0, all -> 0x06c9, blocks: (B:136:0x048a, B:186:0x06fa, B:150:0x04d7, B:172:0x05fd), top: B:338:0x048a }] */
    /* JADX WARN: Code duplicated, block: B:174:0x0653 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:175:0x0654  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 28101. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:61)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:298)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
     */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0169: MOVE (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$withLock' int)]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('restoredAny' boolean)]), block:B:29:0x0155 */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0178: MOVE (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$withLock' int)]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('restoredAny' boolean)]), block:B:31:0x016f */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x015a: MOVE (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('force' boolean)]), block:B:29:0x0155 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0173: MOVE (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-withLock$default-UltimaPlugin$pullChangedCategories$2' int)]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('force' boolean)]), block:B:31:0x016f */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0179: MOVE (r10 I:??[OBJECT, ARRAY] A[D('restoredAny' boolean)]) = (r15 I:??[OBJECT, ARRAY]), block:B:31:0x016f */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x016a: MOVE (r10 I:??[OBJECT, ARRAY] A[D('restoredAny' boolean)]) = (r18 I:??[OBJECT, ARRAY] A[D('categoriesToFetch' java.util.List)]), block:B:29:0x0155 */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x017e: MOVE (r9 I:??[OBJECT, ARRAY] A[D('fetchedPayloads' java.util.List)]) = (r18 I:??[OBJECT, ARRAY] A[D('categoriesToFetch' java.util.List)]), block:B:31:0x016f */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x015b: MOVE (r11 I:??[OBJECT, ARRAY] A[D('force' boolean)]) = (r19 I:??[OBJECT, ARRAY] A[D('manifest' com.phisher98.SyncManifest)]), block:B:29:0x0155 */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x015d: MOVE (r12 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY] A[D('owner$iv' java.lang.Object)]), block:B:29:0x0155 */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x015f: MOVE (r13 I:??[OBJECT, ARRAY]) = (r21 I:??[OBJECT, ARRAY] A[D('$this$withLock_u24default$iv' kotlinx.coroutines.sync.Mutex)]), block:B:29:0x0155 */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x0161: MOVE (r14 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY] A[D('creds' com.phisher98.AppSettingsSyncCreds)]), block:B:29:0x0155 */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x017a: MOVE (r15 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY] A[D('creds' com.phisher98.AppSettingsSyncCreds)]), block:B:31:0x016f */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x0163: MOVE (r15 I:??[OBJECT, ARRAY]) = (r23 I:??[OBJECT, ARRAY] A[D('appContext' android.content.Context)]), block:B:29:0x0155 */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x0174: MOVE (r11 I:??[OBJECT, ARRAY] A[D('force' boolean)]) = (r23 I:??[OBJECT, ARRAY] A[D('appContext' android.content.Context)]), block:B:31:0x016f */
    /* JADX WARN: Not initialized variable reg: 24, insn: 0x0165: MOVE (r17 I:??[OBJECT, ARRAY]) = (r24 I:??[OBJECT, ARRAY] A[D('context' android.content.Context)]), block:B:29:0x0155 */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0167: MOVE (r20 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('owner$iv' java.lang.Object)]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$withLock' int)]), block:B:29:0x0155 */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0176: MOVE (r23 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('appContext' android.content.Context)]) = (r6 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$withLock' int)]), block:B:31:0x016f */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0155: MOVE (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
      (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-withLock$default-UltimaPlugin$pullChangedCategories$2' int)])
    , block:B:29:0x0155 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0172: MOVE (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$continuation' kotlin.coroutines.Continuation)]) = 
      (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-withLock$default-UltimaPlugin$pullChangedCategories$2' int)])
    , block:B:31:0x016f */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x017c: MOVE (r22 I:??[OBJECT, ARRAY] A[D('creds' com.phisher98.AppSettingsSyncCreds)]) = (r9 I:??[OBJECT, ARRAY] A[D('fetchedPayloads' java.util.List)]), block:B:31:0x016f */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:153:0x04f1 -> B:154:0x0511). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:177:0x0676 -> B:188:0x0718). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:187:0x06fd -> B:188:0x0718). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:223:0x08e5 -> B:312:0x0426). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object pullChangedCategories(android.content.Context r29, boolean r30, kotlin.coroutines.Continuation<? super java.lang.Boolean> r31) {
        /*
            Method dump skipped, instruction units count: 2810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.UltimaPlugin.pullChangedCategories(android.content.Context, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object pullChangedCategories$default(UltimaPlugin ultimaPlugin, Context context, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return ultimaPlugin.pullChangedCategories(context, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:121:0x01b7 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x018f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0115 A[Catch: Exception -> 0x0275, TryCatch #5 {Exception -> 0x0275, blocks: (B:68:0x0151, B:55:0x0111, B:57:0x0115, B:59:0x011d, B:65:0x0129), top: B:116:0x0111 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0126  */
    /* JADX WARN: Code duplicated, block: B:65:0x0129 A[Catch: Exception -> 0x0275, TryCatch #5 {Exception -> 0x0275, blocks: (B:68:0x0151, B:55:0x0111, B:57:0x0115, B:59:0x011d, B:65:0x0129), top: B:116:0x0111 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0150 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x0166 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x0167  */
    /* JADX WARN: Code duplicated, block: B:75:0x0183 A[Catch: Exception -> 0x00cc, TryCatch #0 {Exception -> 0x00cc, blocks: (B:89:0x0200, B:72:0x016c, B:73:0x017d, B:75:0x0183, B:77:0x018f, B:79:0x0197, B:82:0x01bc, B:84:0x01c2, B:32:0x00c6), top: B:109:0x00c6 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c2 A[Catch: Exception -> 0x00cc, TryCatch #0 {Exception -> 0x00cc, blocks: (B:89:0x0200, B:72:0x016c, B:73:0x017d, B:75:0x0183, B:77:0x018f, B:79:0x0197, B:82:0x01bc, B:84:0x01c2, B:32:0x00c6), top: B:109:0x00c6 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01eb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:87:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:91:0x0229 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:92:0x022a  */
    /* JADX WARN: Code duplicated, block: B:95:0x026a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:96:0x026b  */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00ba: MOVE (r5 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY] A[D('context' android.content.Context)]), block:B:30:0x00ba */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0089: MOVE (r9 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY] A[D('creds' com.phisher98.AppSettingsSyncCreds)]), block:B:22:0x0089 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x008a: MOVE (r5 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY] A[D('context' android.content.Context)]), block:B:22:0x0089 */
    public final Object migrateFromV1(Context context, Continuation<? super Unit> continuation) {
        C00121 c00121;
        AppSettingsSyncCreds creds;
        AppSettingsSyncCreds creds2;
        AppSettingsSyncCreds appSettingsSyncCreds;
        Object obj;
        Context context2;
        AppSettingsSyncCreds creds3;
        FirebaseSharedData oldData;
        String syncedData;
        boolean z;
        CoroutineContext main;
        C00132 c00132;
        Object resumeWatching;
        FirebaseSharedData oldData2;
        List<DataStoreHelper.ResumeWatchingResult> list;
        LinkedHashMap linkedHashMap;
        UltimaSettingsSyncUtils ultimaSettingsSyncUtils;
        Context context3;
        Map<SyncCategory, Pair<String, String>> map;
        AppSettingsSyncCreds creds4;
        List<DataStoreHelper.ResumeWatchingResult> list2;
        BackupFile categoryBackup;
        UltimaSettingsSyncUtils ultimaSettingsSyncUtils2;
        AppSettingsSyncCreds creds5;
        List<DataStoreHelper.ResumeWatchingResult> list3;
        FirebaseSharedData oldData3;
        CoroutineContext main2;
        C00143 c00143;
        Context context4;
        AppSettingsSyncCreds creds6;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = new C00121(continuation);
            }
        } else {
            c00121 = new C00121(continuation);
        }
        C00121 c00122 = c00121;
        Object $result = c00122.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (c00122.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!UltimaStorageManager.INSTANCE.getSyncV2Migrated() && (appSettingsSyncCreds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds()) != null) {
                            creds2 = appSettingsSyncCreds;
                            if (!creds2.isLoggedIn()) {
                                return Unit.INSTANCE;
                            }
                            Log.INSTANCE.d(TAG, "Checking for v1 data to migrate...");
                            try {
                                UltimaSettingsSyncUtils ultimaSettingsSyncUtils3 = UltimaSettingsSyncUtils.INSTANCE;
                                try {
                                    c00122.L$0 = context;
                                    c00122.L$1 = creds2;
                                    c00122.label = 1;
                                    Object objFetchSharedData = ultimaSettingsSyncUtils3.fetchSharedData(c00122);
                                    if (objFetchSharedData == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj = objFetchSharedData;
                                    context2 = context;
                                    creds3 = creds2;
                                    try {
                                        oldData = (FirebaseSharedData) obj;
                                        if (oldData != null) {
                                            syncedData = oldData.getSyncedData();
                                            if (syncedData != null || StringsKt.isBlank(syncedData)) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            if (!z) {
                                                Log.INSTANCE.d(TAG, "Found v1 shared_data, migrating to v2 categories...");
                                                main = Dispatchers.getMain();
                                                c00132 = new C00132(null);
                                                c00122.L$0 = context2;
                                                c00122.L$1 = creds3;
                                                c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData);
                                                c00122.label = 2;
                                                if (BuildersKt.withContext(main, c00132, c00122) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                HomeViewModel.Companion companion = HomeViewModel.Companion;
                                                c00122.L$0 = context2;
                                                c00122.L$1 = creds3;
                                                c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData);
                                                c00122.label = 3;
                                                resumeWatching = companion.getResumeWatching(c00122);
                                                if (resumeWatching == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                AppSettingsSyncCreds appSettingsSyncCreds2 = creds3;
                                                oldData2 = oldData;
                                                creds2 = appSettingsSyncCreds2;
                                                list = (List) resumeWatching;
                                                linkedHashMap = new LinkedHashMap();
                                                for (SyncCategory category : SyncCategory.getEntries()) {
                                                    if (creds2.isBackupEnabled(category) && (categoryBackup = UltimaBackupUtils.INSTANCE.getBackupForCategory(context2, category, list)) != null) {
                                                        String data = UltimaBackupUtilsKt.toJsonSorted(categoryBackup);
                                                        String hash = UltimaBackupUtils.INSTANCE.computeHash(data);
                                                        linkedHashMap.put(category, new Pair<>(data, hash));
                                                    }
                                                }
                                                if (!linkedHashMap.isEmpty()) {
                                                    ultimaSettingsSyncUtils = UltimaSettingsSyncUtils.INSTANCE;
                                                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds2);
                                                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData2);
                                                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(list);
                                                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                                                    c00122.label = 4;
                                                    if (ultimaSettingsSyncUtils.pushCategories(linkedHashMap, c00122) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    context3 = context2;
                                                    map = linkedHashMap;
                                                    creds4 = creds2;
                                                    list2 = list;
                                                    Context context5 = context3;
                                                    linkedHashMap = map;
                                                    context2 = context5;
                                                    AppSettingsSyncCreds appSettingsSyncCreds3 = creds4;
                                                    list = list2;
                                                    creds2 = appSettingsSyncCreds3;
                                                }
                                                ultimaSettingsSyncUtils2 = UltimaSettingsSyncUtils.INSTANCE;
                                                c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                                c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds2);
                                                c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData2);
                                                c00122.L$3 = SpillingKt.nullOutSpilledVariable(list);
                                                c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                                                c00122.label = 5;
                                                if (ultimaSettingsSyncUtils2.deleteSharedData(c00122) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                List<DataStoreHelper.ResumeWatchingResult> list4 = list;
                                                creds5 = creds2;
                                                list3 = list4;
                                                oldData3 = oldData2;
                                                try {
                                                    Log.INSTANCE.d(TAG, "Deleted old v1 shared_data");
                                                    main2 = Dispatchers.getMain();
                                                    c00143 = new C00143(null);
                                                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds5);
                                                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData3);
                                                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                                                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                                                    c00122.label = 6;
                                                    if (BuildersKt.withContext(main2, c00143, c00122) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    context4 = context2;
                                                    creds6 = creds5;
                                                } catch (Exception e) {
                                                    e = e;
                                                    creds2 = creds5;
                                                    Log.INSTANCE.e(TAG, "v1→v2 migration error: " + e.getMessage());
                                                }
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        creds2 = creds3;
                                        Log.INSTANCE.e(TAG, "v1→v2 migration error: " + e.getMessage());
                                        UltimaStorageManager.INSTANCE.setSyncV2Migrated(true);
                                        return Unit.INSTANCE;
                                    }
                                    UltimaStorageManager.INSTANCE.setSyncV2Migrated(true);
                                    return Unit.INSTANCE;
                                } catch (Exception e3) {
                                    e = e3;
                                    Log.INSTANCE.e(TAG, "v1→v2 migration error: " + e.getMessage());
                                    UltimaStorageManager.INSTANCE.setSyncV2Migrated(true);
                                    return Unit.INSTANCE;
                                }
                            } catch (Exception e4) {
                                e = e4;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        creds2 = (AppSettingsSyncCreds) c00122.L$1;
                        context2 = (Context) c00122.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            creds3 = creds2;
                            obj = $result;
                            oldData = (FirebaseSharedData) obj;
                            if (oldData != null) {
                                syncedData = oldData.getSyncedData();
                                if (syncedData != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (!z) {
                                    Log.INSTANCE.d(TAG, "Found v1 shared_data, migrating to v2 categories...");
                                    main = Dispatchers.getMain();
                                    c00132 = new C00132(null);
                                    c00122.L$0 = context2;
                                    c00122.L$1 = creds3;
                                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData);
                                    c00122.label = 2;
                                    if (BuildersKt.withContext(main, c00132, c00122) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    HomeViewModel.Companion companion2 = HomeViewModel.Companion;
                                    c00122.L$0 = context2;
                                    c00122.L$1 = creds3;
                                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData);
                                    c00122.label = 3;
                                    resumeWatching = companion2.getResumeWatching(c00122);
                                    if (resumeWatching == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    AppSettingsSyncCreds appSettingsSyncCreds4 = creds3;
                                    oldData2 = oldData;
                                    creds2 = appSettingsSyncCreds4;
                                    list = (List) resumeWatching;
                                    linkedHashMap = new LinkedHashMap();
                                    while (r13.hasNext()) {
                                        if (creds2.isBackupEnabled(category)) {
                                            String data2 = UltimaBackupUtilsKt.toJsonSorted(categoryBackup);
                                            String hash2 = UltimaBackupUtils.INSTANCE.computeHash(data2);
                                            linkedHashMap.put(category, new Pair<>(data2, hash2));
                                        }
                                    }
                                    if (!linkedHashMap.isEmpty()) {
                                        ultimaSettingsSyncUtils = UltimaSettingsSyncUtils.INSTANCE;
                                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds2);
                                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData2);
                                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(list);
                                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                                        c00122.label = 4;
                                        if (ultimaSettingsSyncUtils.pushCategories(linkedHashMap, c00122) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        context3 = context2;
                                        map = linkedHashMap;
                                        creds4 = creds2;
                                        list2 = list;
                                        Context context6 = context3;
                                        linkedHashMap = map;
                                        context2 = context6;
                                        AppSettingsSyncCreds appSettingsSyncCreds5 = creds4;
                                        list = list2;
                                        creds2 = appSettingsSyncCreds5;
                                    }
                                    ultimaSettingsSyncUtils2 = UltimaSettingsSyncUtils.INSTANCE;
                                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds2);
                                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData2);
                                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(list);
                                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                                    c00122.label = 5;
                                    if (ultimaSettingsSyncUtils2.deleteSharedData(c00122) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    List<DataStoreHelper.ResumeWatchingResult> list5 = list;
                                    creds5 = creds2;
                                    list3 = list5;
                                    oldData3 = oldData2;
                                    Log.INSTANCE.d(TAG, "Deleted old v1 shared_data");
                                    main2 = Dispatchers.getMain();
                                    c00143 = new C00143(null);
                                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds5);
                                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData3);
                                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                                    c00122.label = 6;
                                    if (BuildersKt.withContext(main2, c00143, c00122) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    context4 = context2;
                                    creds6 = creds5;
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            Log.INSTANCE.e(TAG, "v1→v2 migration error: " + e.getMessage());
                            UltimaStorageManager.INSTANCE.setSyncV2Migrated(true);
                            return Unit.INSTANCE;
                        }
                        UltimaStorageManager.INSTANCE.setSyncV2Migrated(true);
                        return Unit.INSTANCE;
                    case 2:
                        FirebaseSharedData oldData4 = (FirebaseSharedData) c00122.L$2;
                        AppSettingsSyncCreds creds7 = (AppSettingsSyncCreds) c00122.L$1;
                        Context context7 = (Context) c00122.L$0;
                        ResultKt.throwOnFailure($result);
                        oldData = oldData4;
                        context2 = context7;
                        creds3 = creds7;
                        HomeViewModel.Companion companion3 = HomeViewModel.Companion;
                        c00122.L$0 = context2;
                        c00122.L$1 = creds3;
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData);
                        c00122.label = 3;
                        resumeWatching = companion3.getResumeWatching(c00122);
                        if (resumeWatching == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AppSettingsSyncCreds appSettingsSyncCreds6 = creds3;
                        oldData2 = oldData;
                        creds2 = appSettingsSyncCreds6;
                        list = (List) resumeWatching;
                        linkedHashMap = new LinkedHashMap();
                        while (r13.hasNext()) {
                            if (creds2.isBackupEnabled(category)) {
                                String data3 = UltimaBackupUtilsKt.toJsonSorted(categoryBackup);
                                String hash3 = UltimaBackupUtils.INSTANCE.computeHash(data3);
                                linkedHashMap.put(category, new Pair<>(data3, hash3));
                            }
                        }
                        if (!linkedHashMap.isEmpty()) {
                            ultimaSettingsSyncUtils = UltimaSettingsSyncUtils.INSTANCE;
                            c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                            c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds2);
                            c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData2);
                            c00122.L$3 = SpillingKt.nullOutSpilledVariable(list);
                            c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                            c00122.label = 4;
                            if (ultimaSettingsSyncUtils.pushCategories(linkedHashMap, c00122) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            context3 = context2;
                            map = linkedHashMap;
                            creds4 = creds2;
                            list2 = list;
                            Context context8 = context3;
                            linkedHashMap = map;
                            context2 = context8;
                            AppSettingsSyncCreds appSettingsSyncCreds7 = creds4;
                            list = list2;
                            creds2 = appSettingsSyncCreds7;
                        }
                        ultimaSettingsSyncUtils2 = UltimaSettingsSyncUtils.INSTANCE;
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds2);
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData2);
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(list);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                        c00122.label = 5;
                        if (ultimaSettingsSyncUtils2.deleteSharedData(c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        List<DataStoreHelper.ResumeWatchingResult> list6 = list;
                        creds5 = creds2;
                        list3 = list6;
                        oldData3 = oldData2;
                        Log.INSTANCE.d(TAG, "Deleted old v1 shared_data");
                        main2 = Dispatchers.getMain();
                        c00143 = new C00143(null);
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds5);
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData3);
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                        c00122.label = 6;
                        if (BuildersKt.withContext(main2, c00143, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        context4 = context2;
                        creds6 = creds5;
                        UltimaStorageManager.INSTANCE.setSyncV2Migrated(true);
                        return Unit.INSTANCE;
                    case 3:
                        FirebaseSharedData oldData5 = (FirebaseSharedData) c00122.L$2;
                        creds2 = (AppSettingsSyncCreds) c00122.L$1;
                        Context context9 = (Context) c00122.L$0;
                        ResultKt.throwOnFailure($result);
                        oldData2 = oldData5;
                        context2 = context9;
                        resumeWatching = $result;
                        list = (List) resumeWatching;
                        linkedHashMap = new LinkedHashMap();
                        while (r13.hasNext()) {
                            if (creds2.isBackupEnabled(category)) {
                                String data4 = UltimaBackupUtilsKt.toJsonSorted(categoryBackup);
                                String hash4 = UltimaBackupUtils.INSTANCE.computeHash(data4);
                                linkedHashMap.put(category, new Pair<>(data4, hash4));
                            }
                        }
                        if (!linkedHashMap.isEmpty()) {
                            ultimaSettingsSyncUtils = UltimaSettingsSyncUtils.INSTANCE;
                            c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                            c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds2);
                            c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData2);
                            c00122.L$3 = SpillingKt.nullOutSpilledVariable(list);
                            c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                            c00122.label = 4;
                            if (ultimaSettingsSyncUtils.pushCategories(linkedHashMap, c00122) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            context3 = context2;
                            map = linkedHashMap;
                            creds4 = creds2;
                            list2 = list;
                            Context context10 = context3;
                            linkedHashMap = map;
                            context2 = context10;
                            AppSettingsSyncCreds appSettingsSyncCreds8 = creds4;
                            list = list2;
                            creds2 = appSettingsSyncCreds8;
                        }
                        ultimaSettingsSyncUtils2 = UltimaSettingsSyncUtils.INSTANCE;
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds2);
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData2);
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(list);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                        c00122.label = 5;
                        if (ultimaSettingsSyncUtils2.deleteSharedData(c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        List<DataStoreHelper.ResumeWatchingResult> list7 = list;
                        creds5 = creds2;
                        list3 = list7;
                        oldData3 = oldData2;
                        Log.INSTANCE.d(TAG, "Deleted old v1 shared_data");
                        main2 = Dispatchers.getMain();
                        c00143 = new C00143(null);
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds5);
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData3);
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                        c00122.label = 6;
                        if (BuildersKt.withContext(main2, c00143, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        context4 = context2;
                        creds6 = creds5;
                        UltimaStorageManager.INSTANCE.setSyncV2Migrated(true);
                        return Unit.INSTANCE;
                    case 4:
                        map = (Map) c00122.L$4;
                        list2 = (List) c00122.L$3;
                        oldData2 = (FirebaseSharedData) c00122.L$2;
                        creds4 = (AppSettingsSyncCreds) c00122.L$1;
                        context3 = (Context) c00122.L$0;
                        ResultKt.throwOnFailure($result);
                        Context context11 = context3;
                        linkedHashMap = map;
                        context2 = context11;
                        AppSettingsSyncCreds appSettingsSyncCreds9 = creds4;
                        list = list2;
                        creds2 = appSettingsSyncCreds9;
                        ultimaSettingsSyncUtils2 = UltimaSettingsSyncUtils.INSTANCE;
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds2);
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData2);
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(list);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                        c00122.label = 5;
                        if (ultimaSettingsSyncUtils2.deleteSharedData(c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        List<DataStoreHelper.ResumeWatchingResult> list8 = list;
                        creds5 = creds2;
                        list3 = list8;
                        oldData3 = oldData2;
                        Log.INSTANCE.d(TAG, "Deleted old v1 shared_data");
                        main2 = Dispatchers.getMain();
                        c00143 = new C00143(null);
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds5);
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData3);
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                        c00122.label = 6;
                        if (BuildersKt.withContext(main2, c00143, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        context4 = context2;
                        creds6 = creds5;
                        UltimaStorageManager.INSTANCE.setSyncV2Migrated(true);
                        return Unit.INSTANCE;
                    case 5:
                        Map<SyncCategory, Pair<String, String>> map2 = (Map) c00122.L$4;
                        list3 = (List) c00122.L$3;
                        FirebaseSharedData oldData6 = (FirebaseSharedData) c00122.L$2;
                        creds5 = (AppSettingsSyncCreds) c00122.L$1;
                        Context context12 = (Context) c00122.L$0;
                        ResultKt.throwOnFailure($result);
                        linkedHashMap = map2;
                        context2 = context12;
                        oldData3 = oldData6;
                        Log.INSTANCE.d(TAG, "Deleted old v1 shared_data");
                        main2 = Dispatchers.getMain();
                        c00143 = new C00143(null);
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(context2);
                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(creds5);
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(oldData3);
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                        c00122.label = 6;
                        if (BuildersKt.withContext(main2, c00143, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        context4 = context2;
                        creds6 = creds5;
                        UltimaStorageManager.INSTANCE.setSyncV2Migrated(true);
                        return Unit.INSTANCE;
                    case 6:
                        creds6 = (AppSettingsSyncCreds) c00122.L$1;
                        context4 = (Context) c00122.L$0;
                        ResultKt.throwOnFailure($result);
                        UltimaStorageManager.INSTANCE.setSyncV2Migrated(true);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Exception e7) {
            e = e7;
            creds2 = creds;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$migrateFromV1$2 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin$migrateFromV1$2", f = "UltimaPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00132 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00132(Continuation<? super C00132> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00132(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CommonActivity.showToast$default(CommonActivity.INSTANCE, "Migrating sync data to v2...", (Integer) null, 2, (Object) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$migrateFromV1$3 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin$migrateFromV1$3", f = "UltimaPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00143 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00143(Continuation<? super C00143> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00143(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CommonActivity.showToast$default(CommonActivity.INSTANCE, "Sync migration complete!", (Integer) null, 2, (Object) null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void cleanup() {
        Application application;
        Context context;
        SharedPreferences defaultSharedPrefs;
        Context context2;
        SharedPreferences sharedPrefs;
        Runnable it = this.pushRunnable;
        if (it != null) {
            this.mainHandler.removeCallbacks(it);
        }
        this.pushRunnable = null;
        Runnable it2 = this.ssePullRunnable;
        if (it2 != null) {
            this.mainHandler.removeCallbacks(it2);
        }
        this.ssePullRunnable = null;
        Call call = this.sseCall;
        if (call != null) {
            call.cancel();
        }
        CoroutineScopeKt.cancel$default(this.pluginScope, (CancellationException) null, 1, (Object) null);
        try {
            SharedPreferences.OnSharedPreferenceChangeListener listener = this.dataPrefsListener;
            if (listener != null && (context2 = CloudStreamApp.Companion.getContext()) != null && (sharedPrefs = DataStore.INSTANCE.getSharedPrefs(context2)) != null) {
                sharedPrefs.unregisterOnSharedPreferenceChangeListener(listener);
            }
            SharedPreferences.OnSharedPreferenceChangeListener listener2 = this.defaultPrefsListener;
            if (listener2 != null && (context = CloudStreamApp.Companion.getContext()) != null && (defaultSharedPrefs = DataStore.INSTANCE.getDefaultSharedPrefs(context)) != null) {
                defaultSharedPrefs.unregisterOnSharedPreferenceChangeListener(listener2);
            }
        } catch (Exception e) {
        }
        this.dataPrefsListener = null;
        this.defaultPrefsListener = null;
        Application.ActivityLifecycleCallbacks cb = this.lifecycleCallbacks;
        if (cb != null && (application = this.registeredApp) != null) {
            application.unregisterActivityLifecycleCallbacks(cb);
        }
        this.lifecycleCallbacks = null;
        this.registeredApp = null;
        this.activity = null;
    }

    public void load(@NotNull final Context context) {
        instance = this;
        cleanup();
        this.pluginScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        this.activity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        registerMainAPI(new Ultima(this));
        setOpenSettings(new Function1() { // from class: com.phisher98.UltimaPlugin$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return UltimaPlugin.load$lambda$0((Context) obj);
            }
        });
        AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
        if (creds != null && creds.isLoggedIn()) {
            BuildersKt.launch$default(this.pluginScope, (CoroutineContext) null, (CoroutineStart) null, new C00082(context, creds, null), 3, (Object) null);
        }
        SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.phisher98.UltimaPlugin$$ExternalSyntheticLambda2
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                UltimaPlugin.load$lambda$1(this.f$0, context, sharedPreferences, str);
            }
        };
        this.dataPrefsListener = listener;
        this.defaultPrefsListener = listener;
        try {
            DataStore.INSTANCE.getSharedPrefs(context).registerOnSharedPreferenceChangeListener(listener);
            DataStore.INSTANCE.getDefaultSharedPrefs(context).registerOnSharedPreferenceChangeListener(listener);
            Log.INSTANCE.d(TAG, "Registered preference change listeners");
        } catch (Exception e) {
            Log.INSTANCE.e(TAG, "Failed to register preference change listeners: " + e.getMessage());
        }
        MainActivity.Companion.getBookmarksUpdatedEvent().plusAssign(new Function1() { // from class: com.phisher98.UltimaPlugin$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return UltimaPlugin.load$lambda$2(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        Context applicationContext = context.getApplicationContext();
        Application appInstance = applicationContext instanceof Application ? (Application) applicationContext : null;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.phisher98.UltimaPlugin$load$callback$1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (activity instanceof MainActivity) {
                    this.this$0.setActivity(activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null);
                    BuildersKt.launch$default(this.this$0.pluginScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaPlugin$load$callback$1$onActivityResumed$1(this.this$0, activity, null), 3, (Object) null);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity == this.this$0.getActivity()) {
                    this.this$0.setActivity(null);
                }
            }
        };
        this.lifecycleCallbacks = activityLifecycleCallbacks;
        this.registeredApp = appInstance;
        if (appInstance != null) {
            appInstance.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        startSseListener$default(this, context, false, 2, null);
    }

    static final Unit load$lambda$0(Context ctx) {
        AppCompatActivity act = ctx instanceof AppCompatActivity ? (AppCompatActivity) ctx : null;
        if (act != null && !act.isFinishing() && !act.isDestroyed()) {
            UltimaSettings settingsDialog = new UltimaSettings(act);
            settingsDialog.show();
        } else {
            Log.INSTANCE.e("Plugin", "Activity is not valid anymore, cannot show settings dialog");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$load$2 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin$load$2", f = "UltimaPlugin.kt", i = {2, 4}, l = {340, 343, 345, 353, 356}, m = "invokeSuspend", n = {"restored", "manifest"}, nl = {342, 344, 352, 354, 359}, s = {"Z$0", "L$0"}, v = 2)
    static final class C00082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ AppSettingsSyncCreds $creds;
        Object L$0;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00082(Context context, AppSettingsSyncCreds appSettingsSyncCreds, Continuation<? super C00082> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$creds = appSettingsSyncCreds;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UltimaPlugin.this.new C00082(this.$context, this.$creds, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0051 A[Catch: Exception -> 0x0031, TryCatch #0 {Exception -> 0x0031, blocks: (B:7:0x0017, B:8:0x001c, B:37:0x00a2, B:39:0x00a6, B:11:0x0024, B:32:0x008b, B:34:0x0093, B:12:0x0028, B:26:0x0065, B:28:0x006d, B:13:0x002d, B:21:0x0049, B:23:0x0051, B:18:0x0038), top: B:47:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:25:0x0064 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:28:0x006d A[Catch: Exception -> 0x0031, TryCatch #0 {Exception -> 0x0031, blocks: (B:7:0x0017, B:8:0x001c, B:37:0x00a2, B:39:0x00a6, B:11:0x0024, B:32:0x008b, B:34:0x0093, B:12:0x0028, B:26:0x0065, B:28:0x006d, B:13:0x002d, B:21:0x0049, B:23:0x0051, B:18:0x0038), top: B:47:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x0089 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x008b A[Catch: Exception -> 0x0031, TryCatch #0 {Exception -> 0x0031, blocks: (B:7:0x0017, B:8:0x001c, B:37:0x00a2, B:39:0x00a6, B:11:0x0024, B:32:0x008b, B:34:0x0093, B:12:0x0028, B:26:0x0065, B:28:0x006d, B:13:0x002d, B:21:0x0049, B:23:0x0051, B:18:0x0038), top: B:47:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x0093 A[Catch: Exception -> 0x0031, TryCatch #0 {Exception -> 0x0031, blocks: (B:7:0x0017, B:8:0x001c, B:37:0x00a2, B:39:0x00a6, B:11:0x0024, B:32:0x008b, B:34:0x0093, B:12:0x0028, B:26:0x0065, B:28:0x006d, B:13:0x002d, B:21:0x0049, B:23:0x0051, B:18:0x0038), top: B:47:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00a1 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:39:0x00a6 A[Catch: Exception -> 0x0031, TRY_LEAVE, TryCatch #0 {Exception -> 0x0031, blocks: (B:7:0x0017, B:8:0x001c, B:37:0x00a2, B:39:0x00a6, B:11:0x0024, B:32:0x008b, B:34:0x0093, B:12:0x0028, B:26:0x0065, B:28:0x006d, B:13:0x002d, B:21:0x0049, B:23:0x0051, B:18:0x0038), top: B:47:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x00c3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:42:0x00c4  */
        public final Object invokeSuspend(Object $result) {
            Object objPullChangedCategories$default;
            boolean restored;
            Object objFetchManifest;
            SyncManifest manifest;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (UltimaPlugin.this.migrateFromV1(this.$context, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (this.$creds.getRestoreDevice()) {
                            this.label = 2;
                            objPullChangedCategories$default = UltimaPlugin.pullChangedCategories$default(UltimaPlugin.this, this.$context, false, (Continuation) this, 2, null);
                            if (objPullChangedCategories$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            restored = ((Boolean) objPullChangedCategories$default).booleanValue();
                            if (restored) {
                                this.Z$0 = restored;
                                this.label = 3;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            if (this.$creds.getBackupDevice()) {
                                this.label = 4;
                                objFetchManifest = UltimaSettingsSyncUtils.INSTANCE.fetchManifest((Continuation) this);
                                if (objFetchManifest == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                manifest = (SyncManifest) objFetchManifest;
                                if (manifest == null) {
                                    Log.INSTANCE.d(UltimaPlugin.TAG, "No manifest in cloud — performing initial push");
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(manifest);
                                    this.label = 5;
                                    if (UltimaPlugin.this.pushAllCategories(this.$context, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                        } else if (this.$creds.getBackupDevice()) {
                            this.label = 4;
                            objFetchManifest = UltimaSettingsSyncUtils.INSTANCE.fetchManifest((Continuation) this);
                            if (objFetchManifest == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            manifest = (SyncManifest) objFetchManifest;
                            if (manifest == null) {
                                Log.INSTANCE.d(UltimaPlugin.TAG, "No manifest in cloud — performing initial push");
                                this.L$0 = SpillingKt.nullOutSpilledVariable(manifest);
                                this.label = 5;
                                if (UltimaPlugin.this.pushAllCategories(this.$context, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        if (this.$creds.getRestoreDevice()) {
                            this.label = 2;
                            objPullChangedCategories$default = UltimaPlugin.pullChangedCategories$default(UltimaPlugin.this, this.$context, false, (Continuation) this, 2, null);
                            if (objPullChangedCategories$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            restored = ((Boolean) objPullChangedCategories$default).booleanValue();
                            if (restored) {
                                this.Z$0 = restored;
                                this.label = 3;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            if (this.$creds.getBackupDevice()) {
                                this.label = 4;
                                objFetchManifest = UltimaSettingsSyncUtils.INSTANCE.fetchManifest((Continuation) this);
                                if (objFetchManifest == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                manifest = (SyncManifest) objFetchManifest;
                                if (manifest == null) {
                                    Log.INSTANCE.d(UltimaPlugin.TAG, "No manifest in cloud — performing initial push");
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(manifest);
                                    this.label = 5;
                                    if (UltimaPlugin.this.pushAllCategories(this.$context, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                        } else if (this.$creds.getBackupDevice()) {
                            this.label = 4;
                            objFetchManifest = UltimaSettingsSyncUtils.INSTANCE.fetchManifest((Continuation) this);
                            if (objFetchManifest == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            manifest = (SyncManifest) objFetchManifest;
                            if (manifest == null) {
                                Log.INSTANCE.d(UltimaPlugin.TAG, "No manifest in cloud — performing initial push");
                                this.L$0 = SpillingKt.nullOutSpilledVariable(manifest);
                                this.label = 5;
                                if (UltimaPlugin.this.pushAllCategories(this.$context, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        objPullChangedCategories$default = $result;
                        restored = ((Boolean) objPullChangedCategories$default).booleanValue();
                        if (restored) {
                            this.Z$0 = restored;
                            this.label = 3;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(null), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (this.$creds.getBackupDevice()) {
                            this.label = 4;
                            objFetchManifest = UltimaSettingsSyncUtils.INSTANCE.fetchManifest((Continuation) this);
                            if (objFetchManifest == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            manifest = (SyncManifest) objFetchManifest;
                            if (manifest == null) {
                                Log.INSTANCE.d(UltimaPlugin.TAG, "No manifest in cloud — performing initial push");
                                this.L$0 = SpillingKt.nullOutSpilledVariable(manifest);
                                this.label = 5;
                                if (UltimaPlugin.this.pushAllCategories(this.$context, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 3:
                        boolean z = this.Z$0;
                        ResultKt.throwOnFailure($result);
                        if (this.$creds.getBackupDevice()) {
                            this.label = 4;
                            objFetchManifest = UltimaSettingsSyncUtils.INSTANCE.fetchManifest((Continuation) this);
                            if (objFetchManifest == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            manifest = (SyncManifest) objFetchManifest;
                            if (manifest == null) {
                                Log.INSTANCE.d(UltimaPlugin.TAG, "No manifest in cloud — performing initial push");
                                this.L$0 = SpillingKt.nullOutSpilledVariable(manifest);
                                this.label = 5;
                                if (UltimaPlugin.this.pushAllCategories(this.$context, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    case 4:
                        ResultKt.throwOnFailure($result);
                        objFetchManifest = $result;
                        manifest = (SyncManifest) objFetchManifest;
                        if (manifest == null) {
                            Log.INSTANCE.d(UltimaPlugin.TAG, "No manifest in cloud — performing initial push");
                            this.L$0 = SpillingKt.nullOutSpilledVariable(manifest);
                            this.label = 5;
                            if (UltimaPlugin.this.pushAllCategories(this.$context, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    case 5:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e) {
                Log.INSTANCE.e(UltimaPlugin.TAG, "Startup sync failed: " + e.getMessage());
            }
        }

        /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$load$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: UltimaPlugin.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.UltimaPlugin$load$2$1", f = "UltimaPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Synced from cloud", (Integer) null, 2, (Object) null);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static final void load$lambda$1(UltimaPlugin this$0, Context $context, SharedPreferences sharedPreferences, String key) {
        SyncCategory category;
        if (key != null) {
            switch (key.hashCode()) {
                case -1564857568:
                    if (key.equals("ULTIMA_APP_SETTINGS_SYNC_CREDS")) {
                        Log.INSTANCE.d(TAG, "Sync configuration changed, restarting SSE listener");
                        startSseListener$default(this$0, $context, false, 2, null);
                        return;
                    }
                    break;
            }
            if (!this$0.isRestoring && System.currentTimeMillis() > this$0.restoringUntil && (category = UltimaBackupUtils.INSTANCE.classifyKey(key)) != null) {
                Log.INSTANCE.d(TAG, "Pref changed: " + key + " → category " + category.getKey());
                this$0.markDirty(category);
            }
        }
    }

    static final Unit load$lambda$2(UltimaPlugin this$0, boolean z) {
        if (!this$0.isRestoring && System.currentTimeMillis() > this$0.restoringUntil) {
            this$0.markDirty(SyncCategory.BOOKMARKS);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void startSseListener$default(UltimaPlugin ultimaPlugin, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        ultimaPlugin.startSseListener(context, z);
    }

    public final void startSseListener(@NotNull Context context, boolean force) {
        Context appContext = context.getApplicationContext();
        synchronized (this.sseLock) {
            AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
            if (creds != null && creds.isLoggedIn() && creds.getRestoreDevice()) {
                String activeUrl = creds.getActiveUrl();
                String syncKey = creds.getSyncKey();
                if (force || !this.isSseConnected || !Intrinsics.areEqual(this.lastSseSyncKey, syncKey) || !Intrinsics.areEqual(this.lastSseUrl, activeUrl)) {
                    Call call = this.sseCall;
                    if (call != null) {
                        call.cancel();
                    }
                    this.isSseConnected = false;
                    this.lastSseSyncKey = syncKey;
                    this.lastSseUrl = activeUrl;
                    String url = activeUrl + "sync/" + syncKey + "/manifest.json?alt=sse";
                    Request request = new Request.Builder().url(url).addHeader("Accept", "text/event-stream").build();
                    Log.INSTANCE.d(TAG, "Starting SSE listener for URL: " + url);
                    OkHttpClient sseClient = MainActivityKt.getApp().getBaseClient().newBuilder().readTimeout(0L, TimeUnit.MILLISECONDS).build();
                    Call call2 = sseClient.newCall(request);
                    this.sseCall = call2;
                    call2.enqueue(new UltimaPlugin$startSseListener$1$1(this, appContext));
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                Log.INSTANCE.d(TAG, "SSE listener already connected to correct URL and key, skipping restart");
            } else {
                Call call3 = this.sseCall;
                if (call3 != null) {
                    call3.cancel();
                }
                this.sseCall = null;
                this.isSseConnected = false;
                this.lastSseSyncKey = null;
                this.lastSseUrl = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long calculateSseBackoff() {
        long backoff = this.SSE_BASE_DELAY_MS * (1 << Math.min(this.sseRetryCount, 4));
        return Math.min(backoff, this.SSE_MAX_BACKOFF_MS);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:28:0x0091  */
    /* JADX WARN: Code duplicated, block: B:38:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:40:0x0110 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x0111  */
    /* JADX WARN: Code duplicated, block: B:45:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x008b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x008b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object pushAllCategories(@NotNull Context context, @NotNull Continuation<? super Unit> continuation) throws NoWhenBranchMatchedException {
        C00161 c00161;
        AppSettingsSyncCreds creds;
        Object resumeWatching;
        List<DataStoreHelper.ResumeWatchingResult> list;
        Map categoryData;
        Object objPushCategories;
        AppSettingsSyncCreds creds2;
        List<DataStoreHelper.ResumeWatchingResult> list2;
        Map categoryData2;
        BackupFile backup;
        if (continuation instanceof C00161) {
            c00161 = (C00161) continuation;
            if ((c00161.label & Integer.MIN_VALUE) != 0) {
                c00161.label -= Integer.MIN_VALUE;
            } else {
                c00161 = new C00161(continuation);
            }
        } else {
            c00161 = new C00161(continuation);
        }
        Object $result = c00161.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00161.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
                if (creds != null && creds.isLoggedIn()) {
                    HomeViewModel.Companion companion = HomeViewModel.Companion;
                    c00161.L$0 = context;
                    c00161.L$1 = creds;
                    c00161.label = 1;
                    resumeWatching = companion.getResumeWatching(c00161);
                    if (resumeWatching == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list = (List) resumeWatching;
                    categoryData = new LinkedHashMap();
                    for (SyncCategory category : SyncCategory.getEntries()) {
                        if (creds.isBackupEnabled(category)) {
                            try {
                                backup = UltimaBackupUtils.INSTANCE.getBackupForCategory(context, category, list);
                                if (backup != null) {
                                    String data = UltimaBackupUtilsKt.toJsonSorted(backup);
                                    String hash = UltimaBackupUtils.INSTANCE.computeHash(data);
                                    categoryData.put(category, new Pair(data, hash));
                                }
                            } catch (Exception e) {
                                Log.INSTANCE.e(TAG, "Error preparing " + category.getKey() + ": " + e.getMessage());
                            }
                        }
                    }
                    if (!categoryData.isEmpty()) {
                        this.lastPushTimestamp = System.currentTimeMillis();
                        UltimaSettingsSyncUtils ultimaSettingsSyncUtils = UltimaSettingsSyncUtils.INSTANCE;
                        c00161.L$0 = SpillingKt.nullOutSpilledVariable(context);
                        c00161.L$1 = SpillingKt.nullOutSpilledVariable(creds);
                        c00161.L$2 = SpillingKt.nullOutSpilledVariable(list);
                        c00161.L$3 = categoryData;
                        c00161.label = 2;
                        objPushCategories = ultimaSettingsSyncUtils.pushCategories(categoryData, c00161);
                        if (objPushCategories == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        creds2 = creds;
                        list2 = list;
                        categoryData2 = categoryData;
                        Set pushed = (Set) objPushCategories;
                        this.lastPushTimestamp = System.currentTimeMillis();
                        Log.INSTANCE.d(TAG, "Force-pushed " + pushed.size() + '/' + categoryData2.size() + " categories");
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                creds = (AppSettingsSyncCreds) c00161.L$1;
                context = (Context) c00161.L$0;
                ResultKt.throwOnFailure($result);
                resumeWatching = $result;
                list = (List) resumeWatching;
                categoryData = new LinkedHashMap();
                while (r7.hasNext()) {
                    if (creds.isBackupEnabled(category)) {
                        backup = UltimaBackupUtils.INSTANCE.getBackupForCategory(context, category, list);
                        if (backup != null) {
                            String data2 = UltimaBackupUtilsKt.toJsonSorted(backup);
                            String hash2 = UltimaBackupUtils.INSTANCE.computeHash(data2);
                            categoryData.put(category, new Pair(data2, hash2));
                        }
                    }
                }
                if (!categoryData.isEmpty()) {
                    this.lastPushTimestamp = System.currentTimeMillis();
                    UltimaSettingsSyncUtils ultimaSettingsSyncUtils2 = UltimaSettingsSyncUtils.INSTANCE;
                    c00161.L$0 = SpillingKt.nullOutSpilledVariable(context);
                    c00161.L$1 = SpillingKt.nullOutSpilledVariable(creds);
                    c00161.L$2 = SpillingKt.nullOutSpilledVariable(list);
                    c00161.L$3 = categoryData;
                    c00161.label = 2;
                    objPushCategories = ultimaSettingsSyncUtils2.pushCategories(categoryData, c00161);
                    if (objPushCategories == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    creds2 = creds;
                    list2 = list;
                    categoryData2 = categoryData;
                    Set pushed2 = (Set) objPushCategories;
                    this.lastPushTimestamp = System.currentTimeMillis();
                    Log.INSTANCE.d(TAG, "Force-pushed " + pushed2.size() + '/' + categoryData2.size() + " categories");
                }
                return Unit.INSTANCE;
            case 2:
                categoryData2 = (Map) c00161.L$3;
                list2 = (List) c00161.L$2;
                creds2 = (AppSettingsSyncCreds) c00161.L$1;
                ResultKt.throwOnFailure($result);
                objPushCategories = $result;
                Set pushed3 = (Set) objPushCategories;
                this.lastPushTimestamp = System.currentTimeMillis();
                Log.INSTANCE.d(TAG, "Force-pushed " + pushed3.size() + '/' + categoryData2.size() + " categories");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$reload$1 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin$reload$1", f = "UltimaPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00171(Continuation<? super C00171> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UltimaPlugin.this.new C00171(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AppCompatActivity act = UltimaPlugin.this.getActivity();
                    if (act == null || act.isFinishing() || act.isDestroyed() || !act.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                        return Unit.INSTANCE;
                    }
                    try {
                        MainActivity.Companion.getBookmarksUpdatedEvent().invoke(Boxing.boxBoolean(true));
                        MainActivity.Companion.getReloadLibraryEvent().invoke(Boxing.boxBoolean(true));
                        break;
                    } catch (Throwable e) {
                        Log.INSTANCE.e(UltimaPlugin.TAG, "reload events invoke failed: " + e.getMessage());
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void reload() {
        BuildersKt.launch$default(this.pluginScope, Dispatchers.getMain(), (CoroutineStart) null, new C00171(null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object restoreAndReload(Context context, SyncCategory category, BackupFile backupFile, Continuation<? super Unit> continuation) {
        switch (WhenMappings.$EnumSwitchMapping$0[category.ordinal()]) {
            case 1:
                UltimaBackupUtils.INSTANCE.restoreCategory(context, category, backupFile);
                return UltimaBackupUtils.INSTANCE.restoreExtensionsCategory(context, backupFile, continuation);
            case 2:
                UltimaBackupUtils.INSTANCE.restoreCategory(context, category, backupFile);
                Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new C00182(null), continuation);
                return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
            case 3:
                UltimaBackupUtils.INSTANCE.restoreCategory(context, category, backupFile);
                Object objWithContext2 = BuildersKt.withContext(Dispatchers.getMain(), new C00193(null), continuation);
                return objWithContext2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext2 : Unit.INSTANCE;
            default:
                UltimaBackupUtils.INSTANCE.restoreCategory(context, category, backupFile);
                return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$restoreAndReload$2 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin$restoreAndReload$2", f = "UltimaPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00182 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00182(Continuation<? super C00182> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UltimaPlugin.this.new C00182(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        AppCompatActivity act = UltimaPlugin.this.getActivity();
                        if (act != null && act.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                            MainActivity.Companion.getBookmarksUpdatedEvent().invoke(Boxing.boxBoolean(true));
                        }
                        break;
                    } catch (Throwable th) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$restoreAndReload$3 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin$restoreAndReload$3", f = "UltimaPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00193 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00193(Continuation<? super C00193> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UltimaPlugin.this.new C00193(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        AppCompatActivity act = UltimaPlugin.this.getActivity();
                        if (act != null && act.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                            act.recreate();
                        }
                        break;
                    } catch (Throwable e) {
                        Log.INSTANCE.e(UltimaPlugin.TAG, "Failed to recreate activity on settings sync: " + e.getMessage());
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 13 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:645:0x1928
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:143)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object mergeAndSyncAllCategories(@org.jetbrains.annotations.NotNull android.content.Context r50, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r51) {
        /*
            Method dump skipped, instruction units count: 7208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.UltimaPlugin.mergeAndSyncAllCategories(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$mergeAndSyncAllCategories$2 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin$mergeAndSyncAllCategories$2", f = "UltimaPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00102 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00102(Continuation<? super C00102> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UltimaPlugin.this.new C00102(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    UltimaPlugin.this.isRestoring = false;
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaPlugin$mergeAndSyncAllCategories$3 */
    /* JADX INFO: compiled from: UltimaPlugin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaPlugin$mergeAndSyncAllCategories$3", f = "UltimaPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00113 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C00113(Continuation<? super C00113> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UltimaPlugin.this.new C00113(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    UltimaPlugin.this.isRestoring = false;
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
