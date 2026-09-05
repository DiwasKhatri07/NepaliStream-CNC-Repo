package com.phisher98;

import android.content.Context;
import android.content.SharedPreferences;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.plugins.PluginData;
import com.lagradost.cloudstream3.plugins.PluginWrapper;
import com.lagradost.cloudstream3.plugins.RepositoryManager;
import com.lagradost.cloudstream3.ui.settings.extensions.RepositoryData;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaBackupUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\u00020\u000b*\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0005J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J*\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\r2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0007J \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00052\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0007H\u0002J\u001a\u0010\u001f\u001a\u00020 2\u0010\u0010\u0017\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030!H\u0002J\u001e\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0019J(\u0010%\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u000bH\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0002J\u001e\u0010*\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0019H\u0002J\u001e\u0010-\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010+J\u0018\u0010.\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u00100\u001a\u00020\u000bJ\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u0005022\u0006\u0010$\u001a\u00020\u0019J\u000e\u00103\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\rJ\u0015\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u00106J.\u00107\u001a\u0002082\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\r2\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010!H\u0002J\u0096\u0001\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H;\u0018\u00010!\"\u0004\b\u0000\u0010;2\u0006\u0010\u0012\u001a\u00020\r2\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H;\u0018\u00010!2\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H;\u0018\u00010!2\u0006\u0010>\u001a\u0002082\u0006\u0010?\u001a\u0002082\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010!2\u0014\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010!2\b\b\u0002\u0010B\u001a\u00020\u000bH\u0002J6\u0010C\u001a\u0004\u0018\u00010\u00192\b\u0010<\u001a\u0004\u0018\u00010\u00192\b\u0010=\u001a\u0004\u0018\u00010\u00192\u0006\u0010>\u001a\u0002082\u0006\u0010?\u001a\u0002082\b\b\u0002\u0010B\u001a\u00020\u000bJ8\u0010D\u001a\u00020 2\u0006\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u0002082\u0006\u0010?\u001a\u0002082\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0012\u0010E\u001a\u0002082\b\u0010F\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010G\u001a\u00020\u000b*\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006H"}, d2 = {"Lcom/phisher98/UltimaBackupUtils;", "", "<init>", "()V", "TAG", "", "nonTransferableKeys", "", "getNonTransferableKeys", "()Ljava/util/List;", "isTransferable", "", "classifyKey", "Lcom/phisher98/SyncCategory;", "key", "classifySettingsKey", "Lcom/phisher98/SettingsSubCategory;", "isKeyBackupEnabled", "category", "creds", "Lcom/phisher98/AppSettingsSyncCreds;", "isKeyRestoreEnabled", "computeHash", "data", "getBackupForCategory", "Lcom/phisher98/BackupFile;", "context", "Landroid/content/Context;", "resumeWatching", "Lcom/lagradost/cloudstream3/utils/DataStoreHelper$ResumeWatchingResult;", "isResumeWatchingRelevant", "buildBackupVars", "Lcom/phisher98/BackupVars;", "", "restoreCategory", "", "backupFile", "restoreBackupVars", "vars", "isSettings", "forceConvertRawGitUrl", "url", "restoreExtensionsCategory", "(Landroid/content/Context;Lcom/phisher98/BackupFile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergeRepositories", "downloadAndLoadPlugins", "editor", "Lcom/phisher98/UltimaEditor;", "isEditingAppSettings", "getBackupFileKeys", "", "isDynamicCategory", "extractIdFromKey", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "getSpecificKeyTimestamp", "", "stringMap", "mergeCategoryMap", "T", "local", "cloud", "localCategoryTs", "cloudPayloadTs", "localStrings", "cloudStrings", "isLocallyDirty", "mergeBackupFiles", "mergeBackupVars", "extractTimestamp", "json", "isEmpty", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUltimaBackupUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaBackupUtils.kt\ncom/phisher98/UltimaBackupUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 8 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 9 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,949:1\n1960#2,3:950\n1960#2,3:967\n1960#2,3:970\n1960#2,3:973\n684#3:953\n669#3,6:954\n684#3:960\n669#3,6:961\n684#3:976\n669#3,6:977\n684#3:983\n669#3,6:984\n684#3:990\n669#3,6:991\n684#3:997\n669#3,6:998\n684#3:1004\n669#3,6:1005\n684#3:1011\n669#3,6:1012\n684#3:1123\n669#3,6:1124\n684#3:1130\n669#3,6:1131\n1#4:1018\n221#5,2:1019\n221#5,2:1021\n221#5,2:1023\n221#5,2:1025\n221#5,2:1027\n221#5,2:1029\n221#5,2:1031\n221#5,2:1121\n50#6:1033\n43#6:1034\n50#6:1095\n43#6:1096\n50#6:1097\n43#6:1098\n13368#7,8:1035\n12746#7:1099\n13093#7,3:1100\n3938#7:1103\n4474#7,2:1104\n37#8,2:1043\n37#8,2:1067\n37#8,2:1069\n37#8,2:1071\n37#8,2:1106\n37#8,2:1119\n40#9,11:1045\n40#9,11:1056\n40#9,11:1073\n40#9,11:1084\n40#9,11:1108\n*S KotlinDebug\n*F\n+ 1 UltimaBackupUtils.kt\ncom/phisher98/UltimaBackupUtils\n*L\n170#1:950,3\n307#1:967,3\n312#1:970,3\n317#1:973,3\n282#1:953\n282#1:954,6\n287#1:960\n287#1:961,6\n326#1:976\n326#1:977,6\n327#1:983\n327#1:984,6\n328#1:990\n328#1:991,6\n329#1:997\n329#1:998,6\n330#1:1004\n330#1:1005,6\n331#1:1011\n331#1:1012,6\n774#1:1123\n774#1:1124,6\n787#1:1130\n787#1:1131,6\n366#1:1019,2\n376#1:1021,2\n377#1:1023,2\n378#1:1025,2\n379#1:1027,2\n380#1:1029,2\n382#1:1031,2\n742#1:1121,2\n436#1:1033\n436#1:1034\n475#1:1095\n475#1:1096\n492#1:1097\n492#1:1098\n438#1:1035,8\n519#1:1099\n519#1:1100,3\n520#1:1103\n520#1:1104,2\n440#1:1043,2\n454#1:1067,2\n456#1:1069,2\n457#1:1071,2\n624#1:1106,2\n627#1:1119,2\n442#1:1045,11\n448#1:1056,11\n464#1:1073,11\n469#1:1084,11\n625#1:1108,11\n*E\n"})
public final class UltimaBackupUtils {

    @NotNull
    private static final String TAG = "UltimaSync";

    @NotNull
    public static final UltimaBackupUtils INSTANCE = new UltimaBackupUtils();

    @NotNull
    private static final List<String> nonTransferableKeys = CollectionsKt.listOf(new String[]{"anilist_unixtime", "anilist_token", "anilist_user", "anilist_cached_list", "anilist_accounts", "anilist_active", "mal_user", "mal_cached_list", "mal_unixtime", "mal_refresh_token", "mal_token", "mal_accounts", "mal_active", "simkl_token", "simkl_user", "simkl_cached_list", "simkl_cached_time", "simkl_accounts", "simkl_active", "SIMKL_API_CACHE", "ANIWAVE_SIMKL_SYNC", "open_subtitles_user", "opensubtitles_accounts", "opensubtitles_active", "subdl_user", "subdl_accounts", "subdl_active", "biometric_key", "nginx_user", "download_path_key", "download_path_key_visual", "backup_path_key", "backup_dir_path_key", "cs3-votes", "last_sync_api", "last_click_action", "last_opened_id", "library_folder", "result_resume_watching_migrated", "jsdelivr_proxy_key", "fshare_setup", "fshare_token", "bluphim_token", "device_id", "sync_token", "sync_project_num", "sync_project_id", "sync_item_id", "sync_device_id", "restore_device", "backup_device", "download_info", "download_resume", "download_q_resume", "download_episode_cache", "prerelease_update", "stable_update", "inappupdater", "data_store_helper/account_key_index", "VERSION_NAME", "FILES_TO_DELETE_KEY", "HAS_DONE_SETUP", "ULTIMA_WATCH_SYNC_CREDS", "ULTIMA_APP_SETTINGS_SYNC_CREDS", "used_fstream_providers_v3", "fstream_version", "home_api_used", "home_api", "user_selected_homepage_api", "last_sync_api_key", "home_pref_homepage", "library_sorting_mode", "results_sorting_mode", "library_folder", "viewpager_item_key"});

    /* JADX INFO: compiled from: UltimaBackupUtils.kt */
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
                iArr[SyncCategory.RESUME_WATCHING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SyncCategory.SEARCH_HISTORY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SyncCategory.SETTINGS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaBackupUtils$downloadAndLoadPlugins$1 */
    /* JADX INFO: compiled from: UltimaBackupUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaBackupUtils", f = "UltimaBackupUtils.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {501, 534, 643, 643}, m = "downloadAndLoadPlugins", n = {"context", "backupFile", "pluginsJson", "pluginsList", "allOnlinePlugins", "repositories", "context", "backupFile", "pluginsJson", "pluginsList", "allOnlinePlugins", "repositories", "currentLocalPlugins", "incomingNames", "deletedPlugins", "updatedPluginsList", "ultimaPlugin", "newlyDownloaded", "downloadedAny", "downloadSemaphore", "context", "backupFile", "pluginsJson", "pluginsList", "allOnlinePlugins", "repositories", "currentLocalPlugins", "incomingNames", "deletedPlugins", "updatedPluginsList", "ultimaPlugin", "newlyDownloaded", "downloadedAny", "downloadSemaphore", "updatedJson", "plugin", "apiName", "loadedAny", "isLoaded", "isNew", "context", "backupFile", "pluginsJson", "pluginsList", "allOnlinePlugins", "repositories", "currentLocalPlugins", "incomingNames", "deletedPlugins", "updatedPluginsList", "ultimaPlugin", "newlyDownloaded", "downloadedAny", "downloadSemaphore", "updatedJson", "plugin", "apiName", "loadedAny", "isLoaded", "isNew"}, nl = {518, 612, 643, 644}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "I$0", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "I$0", "Z$0", "Z$1"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
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
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaBackupUtils.this.downloadAndLoadPlugins(null, null, (Continuation) this);
        }
    }

    private UltimaBackupUtils() {
    }

    @NotNull
    public final List<String> getNonTransferableKeys() {
        return nonTransferableKeys;
    }

    private final boolean isTransferable(String $this$isTransferable) {
        String lower = $this$isTransferable.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        Iterable $this$any$iv = nonTransferableKeys;
        boolean z = false;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            for (Object element$iv : $this$any$iv) {
                String it = (String) element$iv;
                String lowerCase = it.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.contains$default(lower, lowerCase, false, 2, (Object) null)) {
                    z = true;
                    break;
                }
            }
        }
        return !z;
    }

    @Nullable
    public final SyncCategory classifyKey(@NotNull String key) {
        String lowerKey = key.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerKey, "toLowerCase(...)");
        if (!isTransferable(key)) {
            return null;
        }
        if (StringsKt.contains$default(lowerKey, "result_favorites_state_data", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "result_watch_state", false, 2, (Object) null)) {
            return SyncCategory.BOOKMARKS;
        }
        if (StringsKt.contains$default(lowerKey, "result_resume_watching", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "video_pos_dur", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "download_header_cache", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "result_season", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "result_dub", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "result_episode", false, 2, (Object) null)) {
            return SyncCategory.RESUME_WATCHING;
        }
        if (StringsKt.contains$default(lowerKey, "search_history", false, 2, (Object) null)) {
            return SyncCategory.SEARCH_HISTORY;
        }
        if (StringsKt.contains$default(lowerKey, "plugins_key_local", false, 2, (Object) null)) {
            return null;
        }
        if (StringsKt.contains$default(lowerKey, "plugins_key", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "plugins_repositories", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "repositories", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "ultima_extensions_list", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "ultima_current_meta_providers", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "ultima_current_media_providers", false, 2, (Object) null) || StringsKt.equals(key, "REPOSITORIES_KEY", true)) {
            return SyncCategory.EXTENSIONS;
        }
        return SyncCategory.SETTINGS;
    }

    @NotNull
    public final SettingsSubCategory classifySettingsKey(@NotNull String key) {
        String lowerKey = key.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerKey, "toLowerCase(...)");
        if (StringsKt.contains$default(lowerKey, "player", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "video", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "play", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "buffer", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "resize", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "skip", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "volume", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "brightness", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "gesture", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "speed", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "decoder", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "render", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "fit", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "aspect", false, 2, (Object) null)) {
            return SettingsSubCategory.PLAYER;
        }
        if (StringsKt.contains$default(lowerKey, "subtitle", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "sub", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "caption", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "lang", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "font", false, 2, (Object) null)) {
            return SettingsSubCategory.SUBTITLES;
        }
        if (StringsKt.contains$default(lowerKey, "theme", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "dark", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "color", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "accent", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "primary", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "style", false, 2, (Object) null)) {
            return SettingsSubCategory.THEME;
        }
        if (StringsKt.contains$default(lowerKey, "layout", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "view", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "grid", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "list", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "home", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "card", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "tab", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "row", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "show_", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "homepage", false, 2, (Object) null)) {
            return SettingsSubCategory.LAYOUT;
        }
        if (StringsKt.contains$default(lowerKey, "download", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "down", false, 2, (Object) null) || StringsKt.contains$default(lowerKey, "path", false, 2, (Object) null)) {
            return SettingsSubCategory.DOWNLOADS;
        }
        return SettingsSubCategory.GENERAL;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final boolean isKeyBackupEnabled(@NotNull String key, @NotNull SyncCategory category, @NotNull AppSettingsSyncCreds creds) throws NoWhenBranchMatchedException {
        switch (WhenMappings.$EnumSwitchMapping$0[category.ordinal()]) {
            case 1:
                return creds.getBackupExtensions();
            case 2:
                return creds.getBackupBookmarks();
            case 3:
                return creds.getBackupResumeWatching();
            case 4:
                return creds.getBackupSearchHistory();
            case 5:
                SettingsSubCategory sub = classifySettingsKey(key);
                return creds.isSettingsBackupEnabled(sub);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public final boolean isKeyRestoreEnabled(@NotNull String key, @NotNull SyncCategory category, @NotNull AppSettingsSyncCreds creds) throws NoWhenBranchMatchedException {
        switch (WhenMappings.$EnumSwitchMapping$0[category.ordinal()]) {
            case 1:
                return creds.getRestoreExtensions();
            case 2:
                return creds.getRestoreBookmarks();
            case 3:
                return creds.getRestoreResumeWatching();
            case 4:
                return creds.getRestoreSearchHistory();
            case 5:
                SettingsSubCategory sub = classifySettingsKey(key);
                return creds.isSettingsRestoreEnabled(sub);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final String computeHash(@NotNull String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] bytes = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bytes2 = digest.digest(bytes);
        return ArraysKt.joinToString$default(bytes2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.UltimaBackupUtils$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return UltimaBackupUtils.computeHash$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence computeHash$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackupFile getBackupForCategory$default(UltimaBackupUtils ultimaBackupUtils, Context context, SyncCategory syncCategory, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        return ultimaBackupUtils.getBackupForCategory(context, syncCategory, list);
    }

    @Nullable
    public final BackupFile getBackupForCategory(@NotNull Context context, @NotNull SyncCategory category, @Nullable List<DataStoreHelper.ResumeWatchingResult> resumeWatching) {
        AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
        if (creds == null) {
            creds = new AppSettingsSyncCreds(false, null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, -1, null);
        }
        Map<String, ?> all = DataStore.INSTANCE.getSharedPrefs(context).getAll();
        Map<String, ?> allData = new LinkedHashMap<>();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (INSTANCE.isTransferable(entry.getKey()) && INSTANCE.classifyKey(entry.getKey()) == category && INSTANCE.isResumeWatchingRelevant(entry.getKey(), resumeWatching) && INSTANCE.isKeyBackupEnabled(entry.getKey(), category, creds)) {
                allData.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, ?> all2 = DataStore.INSTANCE.getDefaultSharedPrefs(context).getAll();
        Map<String, ?> allSettings = new LinkedHashMap<>();
        for (Map.Entry<String, ?> entry2 : all2.entrySet()) {
            if (INSTANCE.isTransferable(entry2.getKey()) && INSTANCE.classifyKey(entry2.getKey()) == category && INSTANCE.isResumeWatchingRelevant(entry2.getKey(), resumeWatching) && INSTANCE.isKeyBackupEnabled(entry2.getKey(), category, creds)) {
                allSettings.put(entry2.getKey(), entry2.getValue());
            }
        }
        if (allData.isEmpty() && allSettings.isEmpty()) {
            return null;
        }
        return new BackupFile(buildBackupVars(allData), buildBackupVars(allSettings));
    }

    private final boolean isResumeWatchingRelevant(String key, List<DataStoreHelper.ResumeWatchingResult> resumeWatching) {
        Integer id;
        Integer id2;
        Integer parentId;
        boolean z = true;
        if (resumeWatching == null) {
            return true;
        }
        String lowerKey = key.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerKey, "toLowerCase(...)");
        if (StringsKt.contains$default(lowerKey, "download_header_cache", false, 2, (Object) null)) {
            String str = (String) CollectionsKt.getOrNull(StringsKt.split$default(key, new String[]{"/"}, false, 0, 6, (Object) null), 1);
            id = str != null ? StringsKt.toIntOrNull(str) : null;
            if (id == null) {
                return false;
            }
            int intId = id.intValue();
            List<DataStoreHelper.ResumeWatchingResult> $this$any$iv = resumeWatching;
            if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
                z = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    DataStoreHelper.ResumeWatchingResult it = (DataStoreHelper.ResumeWatchingResult) element$iv;
                    if (it.getParentId() == null ? (id2 = it.getId()) != null && id2.intValue() == intId : (parentId = it.getParentId()) != null && parentId.intValue() == intId) {
                    }
                }
                z = false;
            }
            return z;
        }
        if (StringsKt.contains$default(lowerKey, "video_pos_dur", false, 2, (Object) null)) {
            String str2 = (String) CollectionsKt.getOrNull(StringsKt.split$default(key, new String[]{"/"}, false, 0, 6, (Object) null), 2);
            id = str2 != null ? StringsKt.toIntOrNull(str2) : null;
            if (id == null) {
                return false;
            }
            int intId2 = id.intValue();
            List<DataStoreHelper.ResumeWatchingResult> $this$any$iv2 = resumeWatching;
            if (($this$any$iv2 instanceof Collection) && $this$any$iv2.isEmpty()) {
                z = false;
            } else {
                for (Object element$iv2 : $this$any$iv2) {
                    DataStoreHelper.ResumeWatchingResult it2 = (DataStoreHelper.ResumeWatchingResult) element$iv2;
                    Integer id3 = it2.getId();
                    if (id3 != null && id3.intValue() == intId2) {
                    }
                }
                z = false;
            }
            return z;
        }
        if (!StringsKt.contains$default(lowerKey, "result_season", false, 2, (Object) null) && !StringsKt.contains$default(lowerKey, "result_dub", false, 2, (Object) null) && !StringsKt.contains$default(lowerKey, "result_episode", false, 2, (Object) null)) {
            return true;
        }
        String str3 = (String) CollectionsKt.getOrNull(StringsKt.split$default(key, new String[]{"/"}, false, 0, 6, (Object) null), 2);
        id = str3 != null ? StringsKt.toIntOrNull(str3) : null;
        if (id == null) {
            return false;
        }
        int intId3 = id.intValue();
        List<DataStoreHelper.ResumeWatchingResult> $this$any$iv3 = resumeWatching;
        if (($this$any$iv3 instanceof Collection) && $this$any$iv3.isEmpty()) {
            z = false;
        } else {
            for (Object element$iv3 : $this$any$iv3) {
                DataStoreHelper.ResumeWatchingResult it3 = (DataStoreHelper.ResumeWatchingResult) element$iv3;
                Integer parentId2 = it3.getParentId();
                if (parentId2 != null && parentId2.intValue() == intId3) {
                }
            }
            z = false;
        }
        return z;
    }

    private final BackupVars buildBackupVars(Map<String, ?> data) {
        Map destination$iv$iv = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : data.entrySet()) {
            if (entry.getValue() instanceof Boolean) {
                destination$iv$iv.put(entry.getKey(), entry.getValue());
            }
        }
        Map map = destination$iv$iv instanceof Map ? destination$iv$iv : null;
        Map destination$iv$iv2 = new LinkedHashMap();
        for (Map.Entry<String, ?> entry2 : data.entrySet()) {
            if (entry2.getValue() instanceof Integer) {
                destination$iv$iv2.put(entry2.getKey(), entry2.getValue());
            }
        }
        Map map2 = destination$iv$iv2 instanceof Map ? destination$iv$iv2 : null;
        Map destination$iv$iv3 = new LinkedHashMap();
        for (Map.Entry<String, ?> entry3 : data.entrySet()) {
            if (entry3.getValue() instanceof String) {
                destination$iv$iv3.put(entry3.getKey(), entry3.getValue());
            }
        }
        Map map3 = destination$iv$iv3 instanceof Map ? destination$iv$iv3 : null;
        Map destination$iv$iv4 = new LinkedHashMap();
        for (Map.Entry<String, ?> entry4 : data.entrySet()) {
            if (entry4.getValue() instanceof Float) {
                destination$iv$iv4.put(entry4.getKey(), entry4.getValue());
            }
        }
        Map map4 = destination$iv$iv4 instanceof Map ? destination$iv$iv4 : null;
        Map destination$iv$iv5 = new LinkedHashMap();
        for (Map.Entry<String, ?> entry5 : data.entrySet()) {
            if (entry5.getValue() instanceof Long) {
                destination$iv$iv5.put(entry5.getKey(), entry5.getValue());
            }
        }
        Map map5 = destination$iv$iv5 instanceof Map ? destination$iv$iv5 : null;
        Map destination$iv$iv6 = new LinkedHashMap();
        for (Map.Entry<String, ?> entry6 : data.entrySet()) {
            Object value = entry6.getValue();
            if ((value instanceof Set ? (Set) value : null) != null) {
                destination$iv$iv6.put(entry6.getKey(), entry6.getValue());
            }
        }
        return new BackupVars(map, map2, map3, map4, map5, destination$iv$iv6 instanceof Map ? destination$iv$iv6 : null);
    }

    public final void restoreCategory(@NotNull Context context, @NotNull SyncCategory category, @NotNull BackupFile backupFile) {
        Log.INSTANCE.d(TAG, "Restoring category: " + category.getKey());
        restoreBackupVars(context, category, backupFile.getDatastore(), false);
        restoreBackupVars(context, category, backupFile.getSettings(), true);
        try {
            UltimaStorageManager.INSTANCE.setCategorySyncedKeys(category, getBackupFileKeys(backupFile));
        } catch (Exception e) {
            Log.INSTANCE.e(TAG, "Failed to save synced keys on restore: " + e.getMessage());
        }
    }

    private final void restoreBackupVars(Context context, SyncCategory category, BackupVars vars, boolean isSettings) {
        Map<String, String> map;
        Set<String> setKeySet;
        Set<String> setKeySet2;
        Set<String> setKeySet3;
        Set<String> setKeySet4;
        Set<String> setKeySet5;
        Set<String> setKeySet6;
        AppSettingsSyncCreds creds = UltimaStorageManager.INSTANCE.getAppSettingsSyncCreds();
        if (creds == null) {
            creds = new AppSettingsSyncCreds(false, null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, -1, null);
        }
        DataStore dataStore = DataStore.INSTANCE;
        SharedPreferences prefs = isSettings ? dataStore.getDefaultSharedPrefs(context) : dataStore.getSharedPrefs(context);
        UltimaEditor editor = editor(context, isSettings);
        if (isDynamicCategory(category)) {
            Set incomingKeys = new LinkedHashSet();
            Map<String, Boolean> bool = vars.getBool();
            if (bool != null && (setKeySet6 = bool.keySet()) != null) {
                incomingKeys.addAll(setKeySet6);
            }
            Map<String, Integer> map2 = vars.getInt();
            if (map2 != null && (setKeySet5 = map2.keySet()) != null) {
                incomingKeys.addAll(setKeySet5);
            }
            Map<String, Float> map3 = vars.getFloat();
            if (map3 != null && (setKeySet4 = map3.keySet()) != null) {
                incomingKeys.addAll(setKeySet4);
            }
            Map<String, Long> map4 = vars.getLong();
            if (map4 != null && (setKeySet3 = map4.keySet()) != null) {
                incomingKeys.addAll(setKeySet3);
            }
            Map<String, Set<String>> stringSet = vars.getStringSet();
            if (stringSet != null && (setKeySet2 = stringSet.keySet()) != null) {
                incomingKeys.addAll(setKeySet2);
            }
            Map<String, String> string = vars.getString();
            if (string != null && (setKeySet = string.keySet()) != null) {
                incomingKeys.addAll(setKeySet);
            }
            Iterator<Map.Entry<String, ?>> it = prefs.getAll().entrySet().iterator();
            while (it.hasNext()) {
                String k = it.next().getKey();
                if (INSTANCE.isTransferable(k) && INSTANCE.classifyKey(k) == category && INSTANCE.isKeyRestoreEnabled(k, category, creds) && !incomingKeys.contains(k)) {
                    Log.INSTANCE.d(TAG, "Removing deleted local key: " + k);
                    editor.getEditor().remove(k);
                }
            }
        }
        Map<String, Boolean> bool2 = vars.getBool();
        if (bool2 != null) {
            for (Map.Entry<String, Boolean> entry : bool2.entrySet()) {
                String k2 = entry.getKey();
                boolean v = entry.getValue().booleanValue();
                if (INSTANCE.isTransferable(k2) && INSTANCE.isKeyRestoreEnabled(k2, category, creds)) {
                    editor.setKeyRaw(k2, Boolean.valueOf(v));
                }
            }
        }
        Map<String, Integer> map5 = vars.getInt();
        if (map5 != null) {
            for (Map.Entry<String, Integer> entry2 : map5.entrySet()) {
                String k3 = entry2.getKey();
                int v2 = entry2.getValue().intValue();
                if (INSTANCE.isTransferable(k3) && INSTANCE.isKeyRestoreEnabled(k3, category, creds)) {
                    editor.setKeyRaw(k3, Integer.valueOf(v2));
                }
            }
        }
        Map<String, Float> map6 = vars.getFloat();
        if (map6 != null) {
            for (Map.Entry<String, Float> entry3 : map6.entrySet()) {
                String k4 = entry3.getKey();
                float v3 = entry3.getValue().floatValue();
                if (INSTANCE.isTransferable(k4) && INSTANCE.isKeyRestoreEnabled(k4, category, creds)) {
                    editor.setKeyRaw(k4, Float.valueOf(v3));
                }
            }
        }
        Map<String, Long> map7 = vars.getLong();
        if (map7 != null) {
            for (Map.Entry<String, Long> entry4 : map7.entrySet()) {
                String k5 = entry4.getKey();
                long v4 = entry4.getValue().longValue();
                if (INSTANCE.isTransferable(k5) && INSTANCE.isKeyRestoreEnabled(k5, category, creds)) {
                    editor.setKeyRaw(k5, Long.valueOf(v4));
                }
            }
        }
        Map<String, Set<String>> stringSet2 = vars.getStringSet();
        if (stringSet2 != null) {
            for (Map.Entry<String, Set<String>> entry5 : stringSet2.entrySet()) {
                String k6 = entry5.getKey();
                Set<String> value = entry5.getValue();
                if (INSTANCE.isTransferable(k6) && INSTANCE.isKeyRestoreEnabled(k6, category, creds)) {
                    editor.setKeyRaw(k6, value);
                }
            }
        }
        Map<String, String> string2 = vars.getString();
        if (string2 != null) {
            for (Map.Entry<String, String> entry6 : string2.entrySet()) {
                String k7 = entry6.getKey();
                String v5 = entry6.getValue();
                if (!INSTANCE.isTransferable(k7)) {
                    map = string2;
                } else if (StringsKt.equals(k7, "PLUGINS_KEY", true)) {
                    map = string2;
                } else if (StringsKt.equals(k7, "REPOSITORIES_KEY", true)) {
                    map = string2;
                } else if (StringsKt.equals(k7, "plugins_repositories", true)) {
                    map = string2;
                } else if (StringsKt.equals(k7, "repositories", true)) {
                    map = string2;
                } else if (INSTANCE.isKeyRestoreEnabled(k7, category, creds)) {
                    String localVal = prefs.getString(k7, null);
                    long cloudTs = INSTANCE.extractTimestamp(v5);
                    map = string2;
                    long localTs = INSTANCE.extractTimestamp(localVal);
                    if (localVal == null || ((cloudTs == 0 && localTs == 0) || cloudTs > localTs)) {
                        editor.setKeyRaw(k7, v5);
                    }
                } else {
                    map = string2;
                }
                string2 = map;
            }
        }
        editor.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String forceConvertRawGitUrl(String url) {
        Regex ghRegex = new Regex("^https://raw\\.githubusercontent\\.com/([A-Za-z0-9_-]+)/([A-Za-z0-9_.-]+)/(.*)$");
        MatchResult match = Regex.find$default(ghRegex, url, 0, 2, (Object) null);
        if (match == null) {
            return url;
        }
        MatchResult.Destructured destructured = match.getDestructured();
        String user = (String) destructured.getMatch().getGroupValues().get(1);
        String repo = (String) destructured.getMatch().getGroupValues().get(2);
        String rest = (String) destructured.getMatch().getGroupValues().get(3);
        return "https://cdn.jsdelivr.net/gh/" + user + '/' + repo + '@' + rest;
    }

    @Nullable
    public final Object restoreExtensionsCategory(@NotNull Context context, @NotNull BackupFile backupFile, @NotNull Continuation<? super Unit> continuation) {
        Log.INSTANCE.d(TAG, "Restoring extensions category with download/load logic");
        mergeRepositories(context, backupFile);
        return downloadAndLoadPlugins(context, backupFile, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006f A[Catch: Exception -> 0x02a8, TryCatch #1 {Exception -> 0x02a8, blocks: (B:3:0x0008, B:6:0x001a, B:8:0x0020, B:9:0x0026, B:11:0x002c, B:13:0x0040, B:15:0x004c, B:23:0x0060, B:25:0x0065, B:51:0x00ce, B:53:0x00d4, B:73:0x0225, B:28:0x006f, B:30:0x007a, B:32:0x0080, B:33:0x0086, B:35:0x008c, B:37:0x00a0, B:39:0x00ac, B:47:0x00c0, B:49:0x00c5, B:58:0x00df, B:60:0x010f, B:62:0x013b, B:64:0x0143, B:65:0x0148, B:69:0x01e9), top: B:83:0x0008, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x008c A[Catch: Exception -> 0x02a8, TryCatch #1 {Exception -> 0x02a8, blocks: (B:3:0x0008, B:6:0x001a, B:8:0x0020, B:9:0x0026, B:11:0x002c, B:13:0x0040, B:15:0x004c, B:23:0x0060, B:25:0x0065, B:51:0x00ce, B:53:0x00d4, B:73:0x0225, B:28:0x006f, B:30:0x007a, B:32:0x0080, B:33:0x0086, B:35:0x008c, B:37:0x00a0, B:39:0x00ac, B:47:0x00c0, B:49:0x00c5, B:58:0x00df, B:60:0x010f, B:62:0x013b, B:64:0x0143, B:65:0x0148, B:69:0x01e9), top: B:83:0x0008, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c5 A[Catch: Exception -> 0x02a8, TryCatch #1 {Exception -> 0x02a8, blocks: (B:3:0x0008, B:6:0x001a, B:8:0x0020, B:9:0x0026, B:11:0x002c, B:13:0x0040, B:15:0x004c, B:23:0x0060, B:25:0x0065, B:51:0x00ce, B:53:0x00d4, B:73:0x0225, B:28:0x006f, B:30:0x007a, B:32:0x0080, B:33:0x0086, B:35:0x008c, B:37:0x00a0, B:39:0x00ac, B:47:0x00c0, B:49:0x00c5, B:58:0x00df, B:60:0x010f, B:62:0x013b, B:64:0x0143, B:65:0x0148, B:69:0x01e9), top: B:83:0x0008, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x00bf A[SYNTHETIC] */
    private final void mergeRepositories(Context context, BackupFile backupFile) {
        Map<String, String> string;
        Set<Map.Entry<String, String>> setEntrySet;
        Iterator<T> it;
        Object next;
        Map.Entry entry;
        Map.Entry it2;
        boolean z;
        Set<Map.Entry<String, String>> setEntrySet2;
        Object next2;
        String str;
        Map.Entry it3;
        try {
            Map<String, String> string2 = backupFile.getSettings().getString();
            String repoValue = null;
            boolean z2 = true;
            if (string2 == null || (setEntrySet2 = string2.entrySet()) == null) {
                string = backupFile.getDatastore().getString();
                if (string != null && (setEntrySet = string.entrySet()) != null) {
                    it = setEntrySet.iterator();
                    do {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        it2 = (Map.Entry) next;
                        if (!StringsKt.equals((String) it2.getKey(), "REPOSITORIES_KEY", true) || StringsKt.equals((String) it2.getKey(), "plugins_repositories", true) || StringsKt.equals((String) it2.getKey(), "repositories", true)) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } while (!z);
                    entry = (Map.Entry) next;
                    if (entry != null) {
                        repoValue = (String) entry.getValue();
                    }
                }
            } else {
                Iterator<T> it4 = setEntrySet2.iterator();
                do {
                    if (!it4.hasNext()) {
                        next2 = null;
                        break;
                    } else {
                        next2 = it4.next();
                        it3 = (Map.Entry) next2;
                    }
                } while (!(StringsKt.equals((String) it3.getKey(), "REPOSITORIES_KEY", true) || StringsKt.equals((String) it3.getKey(), "plugins_repositories", true) || StringsKt.equals((String) it3.getKey(), "repositories", true)));
                Map.Entry entry2 = (Map.Entry) next2;
                if (entry2 == null || (str = (String) entry2.getValue()) == null) {
                    string = backupFile.getDatastore().getString();
                    if (string != null) {
                        it = setEntrySet.iterator();
                        do {
                            if (it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            it2 = (Map.Entry) next;
                            if (StringsKt.equals((String) it2.getKey(), "REPOSITORIES_KEY", true)) {
                                z = true;
                            } else {
                                z = true;
                            }
                        } while (!z);
                        entry = (Map.Entry) next;
                        if (entry != null) {
                            repoValue = (String) entry.getValue();
                        }
                    }
                } else {
                    repoValue = str;
                }
            }
            String str2 = repoValue;
            if (str2 != null && !StringsKt.isBlank(str2)) {
                z2 = false;
            }
            if (z2) {
                return;
            }
            try {
                ObjectMapper $this$readValue$iv = MainAPIKt.getMapper();
                String content$iv = repoValue;
                RepositoryData[] incomingRepos = (RepositoryData[]) $this$readValue$iv.readValue(content$iv, new TypeReference<RepositoryData[]>() { // from class: com.phisher98.UltimaBackupUtils$mergeRepositories$$inlined$readValue$1
                });
                RepositoryData[] currentRepos = RepositoryManager.INSTANCE.getRepositories();
                Object[] $this$distinctBy$iv = ArraysKt.plus(currentRepos, incomingRepos);
                HashSet set$iv = new HashSet();
                ArrayList list$iv = new ArrayList();
                int length = $this$distinctBy$iv.length;
                int i = 0;
                while (i < length) {
                    Object e$iv = $this$distinctBy$iv[i];
                    Object[] $this$distinctBy$iv2 = $this$distinctBy$iv;
                    String lowerCase = StringsKt.trim(((RepositoryData) e$iv).getUrl()).toString().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (set$iv.add(lowerCase)) {
                        list$iv.add(e$iv);
                    }
                    i++;
                    $this$distinctBy$iv = $this$distinctBy$iv2;
                }
                ArrayList mergedRepos = list$iv;
                ArrayList $this$toTypedArray$iv = mergedRepos;
                String mergedReposJson = AppUtils.INSTANCE.toJson($this$toTypedArray$iv.toArray(new RepositoryData[0]));
                SharedPreferences $this$edit$iv = DataStore.INSTANCE.getDefaultSharedPrefs(context);
                SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
                Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
                editor$iv.putString("REPOSITORIES_KEY", mergedReposJson).putString("plugins_repositories", mergedReposJson).putString("repositories", mergedReposJson);
                editor$iv.apply();
                SharedPreferences $this$edit$iv2 = DataStore.INSTANCE.getSharedPrefs(context);
                SharedPreferences.Editor editor$iv2 = $this$edit$iv2.edit();
                Intrinsics.checkExpressionValueIsNotNull(editor$iv2, "editor");
                editor$iv2.putString("REPOSITORIES_KEY", mergedReposJson).putString("plugins_repositories", mergedReposJson).putString("repositories", mergedReposJson);
                editor$iv2.apply();
                ArrayList $this$toTypedArray$iv2 = mergedRepos;
                CloudStreamApp.Companion.setKey("REPOSITORIES_KEY", $this$toTypedArray$iv2.toArray(new RepositoryData[0]));
                try {
                    ArrayList $this$toTypedArray$iv3 = mergedRepos;
                    CloudStreamApp.Companion.setKey("plugins_repositories", $this$toTypedArray$iv3.toArray(new RepositoryData[0]));
                    ArrayList $this$toTypedArray$iv4 = mergedRepos;
                    CloudStreamApp.Companion.setKey("repositories", $this$toTypedArray$iv4.toArray(new RepositoryData[0]));
                } catch (Exception e) {
                }
                Log.INSTANCE.d(TAG, "Merged repos: " + currentRepos.length + " local + " + incomingRepos.length + " incoming = " + mergedRepos.size() + " merged");
            } catch (Exception e2) {
                Log.INSTANCE.e(TAG, "Failed to merge repos: " + e2.getMessage());
                SharedPreferences $this$edit$iv3 = DataStore.INSTANCE.getDefaultSharedPrefs(context);
                SharedPreferences.Editor editor$iv3 = $this$edit$iv3.edit();
                Intrinsics.checkExpressionValueIsNotNull(editor$iv3, "editor");
                editor$iv3.putString("REPOSITORIES_KEY", repoValue).putString("plugins_repositories", repoValue).putString("repositories", repoValue);
                editor$iv3.apply();
                SharedPreferences $this$edit$iv4 = DataStore.INSTANCE.getSharedPrefs(context);
                SharedPreferences.Editor editor$iv4 = $this$edit$iv4.edit();
                Intrinsics.checkExpressionValueIsNotNull(editor$iv4, "editor");
                editor$iv4.putString("REPOSITORIES_KEY", repoValue).putString("plugins_repositories", repoValue).putString("repositories", repoValue);
                editor$iv4.apply();
                try {
                    ObjectMapper $this$readValue$iv2 = MainAPIKt.getMapper();
                    String content$iv2 = repoValue;
                    RepositoryData[] repoArray = (RepositoryData[]) $this$readValue$iv2.readValue(content$iv2, new TypeReference<RepositoryData[]>() { // from class: com.phisher98.UltimaBackupUtils$mergeRepositories$$inlined$readValue$2
                    });
                    CloudStreamApp.Companion.setKey("REPOSITORIES_KEY", repoArray);
                } catch (Exception e3) {
                }
            }
        } catch (Exception e4) {
            Log.INSTANCE.e(TAG, "Repository merge error: " + e4.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:134:0x0524  */
    /* JADX WARN: Code duplicated, block: B:139:0x0548 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:149:0x0578  */
    /* JADX WARN: Code duplicated, block: B:151:0x057e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:160:0x0600 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:161:0x0601  */
    /* JADX WARN: Code duplicated, block: B:164:0x0616 A[Catch: Exception -> 0x0727, TRY_LEAVE, TryCatch #17 {Exception -> 0x0727, blocks: (B:162:0x060e, B:164:0x0616), top: B:266:0x060e }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0683 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:173:0x0684  */
    /* JADX WARN: Code duplicated, block: B:176:0x0699  */
    /* JADX WARN: Code duplicated, block: B:177:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:189:0x070b  */
    /* JADX WARN: Code duplicated, block: B:190:0x0719  */
    /* JADX WARN: Code duplicated, block: B:206:0x07cb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:212:0x07db A[Catch: all -> 0x0816, TryCatch #13 {all -> 0x0816, blocks: (B:210:0x07d7, B:212:0x07db, B:215:0x07e2, B:217:0x07ec, B:222:0x07f6, B:224:0x0806), top: B:258:0x07d7 }] */
    /* JADX WARN: Code duplicated, block: B:213:0x07df  */
    /* JADX WARN: Code duplicated, block: B:215:0x07e2 A[Catch: all -> 0x0816, TryCatch #13 {all -> 0x0816, blocks: (B:210:0x07d7, B:212:0x07db, B:215:0x07e2, B:217:0x07ec, B:222:0x07f6, B:224:0x0806), top: B:258:0x07d7 }] */
    /* JADX WARN: Code duplicated, block: B:217:0x07ec A[Catch: all -> 0x0816, TryCatch #13 {all -> 0x0816, blocks: (B:210:0x07d7, B:212:0x07db, B:215:0x07e2, B:217:0x07ec, B:222:0x07f6, B:224:0x0806), top: B:258:0x07d7 }] */
    /* JADX WARN: Code duplicated, block: B:218:0x07f0  */
    /* JADX WARN: Code duplicated, block: B:219:0x07f2  */
    /* JADX WARN: Code duplicated, block: B:222:0x07f6 A[Catch: all -> 0x0816, TryCatch #13 {all -> 0x0816, blocks: (B:210:0x07d7, B:212:0x07db, B:215:0x07e2, B:217:0x07ec, B:222:0x07f6, B:224:0x0806), top: B:258:0x07d7 }] */
    /* JADX WARN: Code duplicated, block: B:258:0x07d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:0x07bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:284:0x0345 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x021e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0228  */
    /* JADX WARN: Code duplicated, block: B:52:0x0255  */
    /* JADX WARN: Code duplicated, block: B:53:0x025c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:84:0x0342  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:173:0x0684 -> B:234:0x0691). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:186:0x06e9 -> B:187:0x06f5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:203:0x078a -> B:132:0x051e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object downloadAndLoadPlugins(android.content.Context r33, com.phisher98.BackupFile r34, kotlin.coroutines.Continuation<? super kotlin.Unit> r35) {
        /*
            Method dump skipped, instruction units count: 2128
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.UltimaBackupUtils.downloadAndLoadPlugins(android.content.Context, com.phisher98.BackupFile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaBackupUtils$downloadAndLoadPlugins$2 */
    /* JADX INFO: compiled from: UltimaBackupUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaBackupUtils$downloadAndLoadPlugins$2", f = "UltimaBackupUtils.kt", i = {0, 0}, l = {512}, m = "invokeSuspend", n = {"$this$coroutineScope", "deferreds"}, nl = {954}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nUltimaBackupUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaBackupUtils.kt\ncom/phisher98/UltimaBackupUtils$downloadAndLoadPlugins$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,949:1\n12746#2:950\n13093#2,3:951\n2068#3,2:954\n*S KotlinDebug\n*F\n+ 1 UltimaBackupUtils.kt\ncom/phisher98/UltimaBackupUtils$downloadAndLoadPlugins$2\n*L\n502#1:950\n502#1:951,3\n512#1:954,2\n*E\n"})
    static final class C00042 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<PluginWrapper> $allOnlinePlugins;
        final /* synthetic */ RepositoryData[] $repositories;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(RepositoryData[] repositoryDataArr, List<PluginWrapper> list, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$repositories = repositoryDataArr;
            this.$allOnlinePlugins = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$repositories, this.$allOnlinePlugins, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objAwaitAll;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    RepositoryData[] repositoryDataArr = this.$repositories;
                    Collection destination$iv$iv = new ArrayList(repositoryDataArr.length);
                    for (RepositoryData repositoryData : repositoryDataArr) {
                        destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new UltimaBackupUtils$downloadAndLoadPlugins$2$deferreds$1$1(repositoryData, null), 2, (Object) null));
                    }
                    List deferreds = (List) destination$iv$iv;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(deferreds);
                    this.label = 1;
                    objAwaitAll = AwaitKt.awaitAll(deferreds, (Continuation) this);
                    if (objAwaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objAwaitAll = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Iterable $this$forEach$iv = (Iterable) objAwaitAll;
            List<PluginWrapper> list = this.$allOnlinePlugins;
            for (Object element$iv : $this$forEach$iv) {
                List result = (List) element$iv;
                if (result != null) {
                    list.addAll(result);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaBackupUtils$downloadAndLoadPlugins$3 */
    /* JADX INFO: compiled from: UltimaBackupUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaBackupUtils$downloadAndLoadPlugins$3", f = "UltimaBackupUtils.kt", i = {0}, l = {599}, m = "invokeSuspend", n = {"$this$coroutineScope"}, nl = {535}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nUltimaBackupUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UltimaBackupUtils.kt\ncom/phisher98/UltimaBackupUtils$downloadAndLoadPlugins$3\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,949:1\n3938#2:950\n4474#2,2:951\n1739#3:953\n1814#3,3:954\n*S KotlinDebug\n*F\n+ 1 UltimaBackupUtils.kt\ncom/phisher98/UltimaBackupUtils$downloadAndLoadPlugins$3\n*L\n535#1:950\n535#1:951,2\n537#1:953\n537#1:954,3\n*E\n"})
    static final class C00053 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<PluginWrapper> $allOnlinePlugins;
        final /* synthetic */ Context $context;
        final /* synthetic */ Semaphore $downloadSemaphore;
        final /* synthetic */ Ref.BooleanRef $downloadedAny;
        final /* synthetic */ Set<String> $newlyDownloaded;
        final /* synthetic */ PluginData[] $pluginsList;
        final /* synthetic */ List<PluginData> $updatedPluginsList;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(PluginData[] pluginDataArr, List<PluginData> list, Set<String> set, Ref.BooleanRef booleanRef, Semaphore semaphore, List<PluginWrapper> list2, Context context, Continuation<? super C00053> continuation) {
            super(2, continuation);
            this.$pluginsList = pluginDataArr;
            this.$updatedPluginsList = list;
            this.$newlyDownloaded = set;
            this.$downloadedAny = booleanRef;
            this.$downloadSemaphore = semaphore;
            this.$allOnlinePlugins = list2;
            this.$context = context;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00053 = new C00053(this.$pluginsList, this.$updatedPluginsList, this.$newlyDownloaded, this.$downloadedAny, this.$downloadSemaphore, this.$allOnlinePlugins, this.$context, continuation);
            c00053.L$0 = obj;
            return c00053;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objAwaitAll;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PluginData[] pluginDataArr = this.$pluginsList;
                    Collection destination$iv$iv = new ArrayList();
                    for (PluginData pluginData : pluginDataArr) {
                        if (!StringsKt.equals(pluginData.getInternalName(), "Ultima", true)) {
                            destination$iv$iv.add(pluginData);
                        }
                    }
                    Iterable $this$map$iv = (List) destination$iv$iv;
                    Semaphore semaphore = this.$downloadSemaphore;
                    List<PluginWrapper> list = this.$allOnlinePlugins;
                    Context context = this.$context;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        PluginData plugin = (PluginData) item$iv$iv;
                        Collection destination$iv$iv3 = destination$iv$iv2;
                        destination$iv$iv3.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new UltimaBackupUtils$downloadAndLoadPlugins$3$downloadResults$2$1(semaphore, list, context, plugin, null), 2, (Object) null));
                        destination$iv$iv2 = destination$iv$iv3;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.label = 1;
                    objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv2, (Continuation) this);
                    if (objAwaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objAwaitAll = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List<Triple> downloadResults = (List) objAwaitAll;
            for (Triple result : downloadResults) {
                if (result != null) {
                    PluginData pluginData2 = (PluginData) result.component1();
                    boolean isNewlyDownloaded = ((Boolean) result.component2()).booleanValue();
                    boolean wasDownloaded = ((Boolean) result.component3()).booleanValue();
                    this.$updatedPluginsList.add(pluginData2);
                    if (isNewlyDownloaded) {
                        this.$newlyDownloaded.add(pluginData2.getInternalName());
                    }
                    if (wasDownloaded) {
                        this.$downloadedAny.element = true;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ UltimaEditor editor$default(UltimaBackupUtils ultimaBackupUtils, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return ultimaBackupUtils.editor(context, z);
    }

    @NotNull
    public final UltimaEditor editor(@NotNull Context context, boolean isEditingAppSettings) {
        DataStore dataStore = DataStore.INSTANCE;
        SharedPreferences.Editor editor = (isEditingAppSettings ? dataStore.getDefaultSharedPrefs(context) : dataStore.getSharedPrefs(context)).edit();
        return new UltimaEditor(editor);
    }

    @NotNull
    public final Set<String> getBackupFileKeys(@NotNull BackupFile backupFile) {
        Set<String> setKeySet;
        Set<String> setKeySet2;
        Set<String> setKeySet3;
        Set<String> setKeySet4;
        Set<String> setKeySet5;
        Set<String> setKeySet6;
        Set<String> setKeySet7;
        Set<String> setKeySet8;
        Set<String> setKeySet9;
        Set<String> setKeySet10;
        Set<String> setKeySet11;
        Set<String> setKeySet12;
        Set keys = new LinkedHashSet();
        Map<String, Boolean> bool = backupFile.getDatastore().getBool();
        if (bool != null && (setKeySet12 = bool.keySet()) != null) {
            keys.addAll(setKeySet12);
        }
        Map<String, Integer> map = backupFile.getDatastore().getInt();
        if (map != null && (setKeySet11 = map.keySet()) != null) {
            keys.addAll(setKeySet11);
        }
        Map<String, Float> map2 = backupFile.getDatastore().getFloat();
        if (map2 != null && (setKeySet10 = map2.keySet()) != null) {
            keys.addAll(setKeySet10);
        }
        Map<String, Long> map3 = backupFile.getDatastore().getLong();
        if (map3 != null && (setKeySet9 = map3.keySet()) != null) {
            keys.addAll(setKeySet9);
        }
        Map<String, Set<String>> stringSet = backupFile.getDatastore().getStringSet();
        if (stringSet != null && (setKeySet8 = stringSet.keySet()) != null) {
            keys.addAll(setKeySet8);
        }
        Map<String, String> string = backupFile.getDatastore().getString();
        if (string != null && (setKeySet7 = string.keySet()) != null) {
            keys.addAll(setKeySet7);
        }
        Map<String, Boolean> bool2 = backupFile.getSettings().getBool();
        if (bool2 != null && (setKeySet6 = bool2.keySet()) != null) {
            keys.addAll(setKeySet6);
        }
        Map<String, Integer> map4 = backupFile.getSettings().getInt();
        if (map4 != null && (setKeySet5 = map4.keySet()) != null) {
            keys.addAll(setKeySet5);
        }
        Map<String, Float> map5 = backupFile.getSettings().getFloat();
        if (map5 != null && (setKeySet4 = map5.keySet()) != null) {
            keys.addAll(setKeySet4);
        }
        Map<String, Long> map6 = backupFile.getSettings().getLong();
        if (map6 != null && (setKeySet3 = map6.keySet()) != null) {
            keys.addAll(setKeySet3);
        }
        Map<String, Set<String>> stringSet2 = backupFile.getSettings().getStringSet();
        if (stringSet2 != null && (setKeySet2 = stringSet2.keySet()) != null) {
            keys.addAll(setKeySet2);
        }
        Map<String, String> string2 = backupFile.getSettings().getString();
        if (string2 != null && (setKeySet = string2.keySet()) != null) {
            keys.addAll(setKeySet);
        }
        return keys;
    }

    public final boolean isDynamicCategory(@NotNull SyncCategory category) {
        return category == SyncCategory.BOOKMARKS || category == SyncCategory.RESUME_WATCHING || category == SyncCategory.SEARCH_HISTORY;
    }

    @Nullable
    public final Integer extractIdFromKey(@NotNull String key) {
        String str;
        String lower = key.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        if (StringsKt.contains$default(lower, "download_header_cache", false, 2, (Object) null)) {
            String str2 = (String) CollectionsKt.getOrNull(StringsKt.split$default(key, new String[]{"/"}, false, 0, 6, (Object) null), 1);
            if (str2 != null) {
                return StringsKt.toIntOrNull(str2);
            }
            return null;
        }
        if (StringsKt.contains$default(lower, "video_pos_dur", false, 2, (Object) null)) {
            String str3 = (String) CollectionsKt.getOrNull(StringsKt.split$default(key, new String[]{"/"}, false, 0, 6, (Object) null), 2);
            if (str3 != null) {
                return StringsKt.toIntOrNull(str3);
            }
            return null;
        }
        if (StringsKt.contains$default(lower, "result_season", false, 2, (Object) null)) {
            String str4 = (String) CollectionsKt.getOrNull(StringsKt.split$default(key, new String[]{"/"}, false, 0, 6, (Object) null), 2);
            if (str4 != null) {
                return StringsKt.toIntOrNull(str4);
            }
            return null;
        }
        if (StringsKt.contains$default(lower, "result_dub", false, 2, (Object) null)) {
            String str5 = (String) CollectionsKt.getOrNull(StringsKt.split$default(key, new String[]{"/"}, false, 0, 6, (Object) null), 2);
            if (str5 != null) {
                return StringsKt.toIntOrNull(str5);
            }
            return null;
        }
        if (StringsKt.contains$default(lower, "result_episode", false, 2, (Object) null)) {
            String str6 = (String) CollectionsKt.getOrNull(StringsKt.split$default(key, new String[]{"/"}, false, 0, 6, (Object) null), 2);
            if (str6 != null) {
                return StringsKt.toIntOrNull(str6);
            }
            return null;
        }
        if (StringsKt.contains$default(lower, "result_favorites_state_data", false, 2, (Object) null)) {
            String str7 = (String) CollectionsKt.getOrNull(StringsKt.split$default(key, new String[]{"/"}, false, 0, 6, (Object) null), 1);
            if (str7 != null) {
                return StringsKt.toIntOrNull(str7);
            }
            return null;
        }
        if (StringsKt.contains$default(lower, "result_watch_state", false, 2, (Object) null)) {
            String str8 = (String) CollectionsKt.getOrNull(StringsKt.split$default(key, new String[]{"/"}, false, 0, 6, (Object) null), 1);
            if (str8 != null) {
                return StringsKt.toIntOrNull(str8);
            }
            return null;
        }
        if (!StringsKt.contains$default(lower, "result_resume_watching", false, 2, (Object) null) || (str = (String) CollectionsKt.getOrNull(StringsKt.split$default(key, new String[]{"/"}, false, 0, 6, (Object) null), 1)) == null) {
            return null;
        }
        return StringsKt.toIntOrNull(str);
    }

    private final long getSpecificKeyTimestamp(String key, SyncCategory category, Map<String, String> stringMap) {
        List<String> relatedKeys;
        long j = 0;
        if (stringMap == null) {
            return 0L;
        }
        String directVal = stringMap.get(key);
        if (directVal != null) {
            long ts = extractTimestamp(directVal);
            if (ts > 0) {
                return ts;
            }
        }
        Integer numExtractIdFromKey = extractIdFromKey(key);
        if (numExtractIdFromKey == null) {
            return 0L;
        }
        int id = numExtractIdFromKey.intValue();
        switch (WhenMappings.$EnumSwitchMapping$0[category.ordinal()]) {
            case 2:
                relatedKeys = CollectionsKt.listOf("result_favorites_state_data/" + id);
                break;
            case 3:
                relatedKeys = CollectionsKt.listOf(new String[]{"result_resume_watching/" + id, "video_pos_dur/" + id});
                break;
            default:
                relatedKeys = CollectionsKt.emptyList();
                break;
        }
        for (String relKey : relatedKeys) {
            String v = stringMap.get(relKey);
            if (v != null) {
                long ts2 = extractTimestamp(v);
                if (ts2 > 0) {
                    return ts2;
                }
            }
        }
        if (category != SyncCategory.RESUME_WATCHING) {
            return 0L;
        }
        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            String k = entry.getKey();
            String v2 = entry.getValue();
            long j2 = j;
            if (StringsKt.contains$default(k, "video_pos_dur", false, 2, (Object) null) && StringsKt.contains$default(k, new StringBuilder().append('/').append(id).toString(), false, 2, (Object) null)) {
                long ts3 = INSTANCE.extractTimestamp(v2);
                if (ts3 > j2) {
                    return ts3;
                }
            }
            j = j2;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Map<String, T> mergeCategoryMap(SyncCategory category, Map<String, ? extends T> local, Map<String, ? extends T> cloud, long localCategoryTs, long cloudPayloadTs, Map<String, String> localStrings, Map<String, String> cloudStrings, boolean isLocallyDirty) {
        Set<String> setEmptySet;
        boolean z;
        boolean z2;
        if (local == null && cloud == 0) {
            return null;
        }
        if (isDynamicCategory(category)) {
            setEmptySet = UltimaStorageManager.INSTANCE.getCategorySyncedKeys(category);
        } else {
            setEmptySet = SetsKt.emptySet();
        }
        long itemTs = 0;
        if (local == null) {
            if (cloud == 0) {
                return null;
            }
            if (localCategoryTs == 0 || !isDynamicCategory(category) || setEmptySet.isEmpty()) {
                return cloud;
            }
            Map destination$iv$iv = new LinkedHashMap();
            for (Map.Entry element$iv$iv : cloud.entrySet()) {
                String key = (String) element$iv$iv.getKey();
                boolean inLastSync = setEmptySet.contains(key);
                if (!inLastSync) {
                    z2 = true;
                } else {
                    long itemTs2 = INSTANCE.getSpecificKeyTimestamp(key, category, cloudStrings);
                    z2 = itemTs2 > localCategoryTs;
                }
                if (z2) {
                    destination$iv$iv.put(element$iv$iv.getKey(), element$iv$iv.getValue());
                }
            }
            return destination$iv$iv;
        }
        if (cloud == 0) {
            Map nonNullLocal = local;
            if (localCategoryTs == 0 || !isDynamicCategory(category)) {
                return nonNullLocal;
            }
            if (setEmptySet.isEmpty()) {
                return nonNullLocal;
            }
            Map $this$filter$iv = nonNullLocal;
            Map destination$iv$iv2 = new LinkedHashMap();
            for (Map.Entry element$iv$iv2 : $this$filter$iv.entrySet()) {
                nonNullLocal = nonNullLocal;
                String key2 = (String) element$iv$iv2.getKey();
                boolean inLastSync2 = setEmptySet.contains(key2);
                if (!inLastSync2) {
                    $this$filter$iv = $this$filter$iv;
                    z = true;
                } else {
                    $this$filter$iv = $this$filter$iv;
                    long itemTs3 = INSTANCE.getSpecificKeyTimestamp(key2, category, localStrings);
                    z = itemTs3 > localCategoryTs;
                }
                if (z) {
                    destination$iv$iv2.put(element$iv$iv2.getKey(), element$iv$iv2.getValue());
                }
            }
            return destination$iv$iv2;
        }
        HashMap merged = new HashMap();
        for (Map.Entry<String, ? extends T> entry : local.entrySet()) {
            String key3 = entry.getKey();
            T value = entry.getValue();
            Object cloudVal = cloud.get(key3);
            if (cloudVal != null) {
                long localTs = getSpecificKeyTimestamp(key3, category, localStrings);
                long cloudTs = getSpecificKeyTimestamp(key3, category, cloudStrings);
                if (localTs > itemTs || cloudTs > itemTs) {
                    if (cloudTs > localTs) {
                        merged.put(key3, cloudVal);
                        itemTs = itemTs;
                    } else {
                        merged.put(key3, value);
                        itemTs = itemTs;
                    }
                } else if (cloudPayloadTs > localCategoryTs && !isLocallyDirty) {
                    merged.put(key3, cloudVal);
                    itemTs = itemTs;
                } else {
                    merged.put(key3, value);
                    itemTs = itemTs;
                }
            } else {
                long j = itemTs;
                long itemTs4 = getSpecificKeyTimestamp(key3, category, localStrings);
                if (itemTs4 > j) {
                    if (localCategoryTs == j || setEmptySet.isEmpty()) {
                        merged.put(key3, value);
                        itemTs = j;
                    } else {
                        boolean inLastSync3 = setEmptySet.contains(key3);
                        if (!inLastSync3) {
                            merged.put(key3, value);
                            itemTs = j;
                        } else if (itemTs4 <= localCategoryTs) {
                            itemTs = j;
                        } else {
                            merged.put(key3, value);
                            itemTs = j;
                        }
                    }
                } else if (localCategoryTs == j) {
                    merged.put(key3, value);
                    itemTs = j;
                } else if (cloudPayloadTs <= localCategoryTs || isLocallyDirty || !setEmptySet.contains(key3)) {
                    merged.put(key3, value);
                    itemTs = j;
                } else {
                    itemTs = j;
                }
            }
        }
        long j2 = itemTs;
        for (Map.Entry entry2 : cloud.entrySet()) {
            String key4 = (String) entry2.getKey();
            Object cloudVal2 = entry2.getValue();
            if (!local.containsKey(key4)) {
                long itemTs5 = getSpecificKeyTimestamp(key4, category, cloudStrings);
                if (itemTs5 > j2) {
                    if (localCategoryTs == j2 || setEmptySet.isEmpty()) {
                        merged.put(key4, cloudVal2);
                    } else {
                        boolean inLastSync4 = setEmptySet.contains(key4);
                        if (!inLastSync4) {
                            merged.put(key4, cloudVal2);
                        } else if (itemTs5 > localCategoryTs) {
                            merged.put(key4, cloudVal2);
                        }
                    }
                } else if (localCategoryTs == j2) {
                    merged.put(key4, cloudVal2);
                } else if (cloudPayloadTs > localCategoryTs && !isLocallyDirty) {
                    merged.put(key4, cloudVal2);
                }
            }
        }
        return merged;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00b8  */
    @Nullable
    public final BackupFile mergeBackupFiles(@Nullable BackupFile local, @Nullable BackupFile cloud, long localCategoryTs, long cloudPayloadTs, boolean isLocallyDirty) {
        String sampleKey;
        Set<String> setKeySet;
        Set<String> setKeySet2;
        Set<String> setKeySet3;
        Set<String> setKeySet4;
        Set<String> setKeySet5;
        SyncCategory syncCategoryClassifyKey;
        Set<String> setKeySet6;
        if (local == null) {
            return cloud;
        }
        if (cloud == null) {
            return local;
        }
        Map<String, String> string = local.getDatastore().getString();
        if (string == null || (setKeySet6 = string.keySet()) == null || (sampleKey = (String) CollectionsKt.firstOrNull(setKeySet6)) == null) {
            Map<String, String> string2 = local.getSettings().getString();
            sampleKey = (string2 == null || (setKeySet5 = string2.keySet()) == null) ? null : (String) CollectionsKt.firstOrNull(setKeySet5);
            if (sampleKey == null) {
                Map<String, Boolean> bool = local.getDatastore().getBool();
                sampleKey = (bool == null || (setKeySet4 = bool.keySet()) == null) ? null : (String) CollectionsKt.firstOrNull(setKeySet4);
                if (sampleKey == null) {
                    Map<String, Boolean> bool2 = local.getSettings().getBool();
                    sampleKey = (bool2 == null || (setKeySet3 = bool2.keySet()) == null) ? null : (String) CollectionsKt.firstOrNull(setKeySet3);
                    if (sampleKey == null) {
                        Map<String, String> string3 = cloud.getDatastore().getString();
                        sampleKey = (string3 == null || (setKeySet2 = string3.keySet()) == null) ? null : (String) CollectionsKt.firstOrNull(setKeySet2);
                        if (sampleKey == null) {
                            Map<String, String> string4 = cloud.getSettings().getString();
                            sampleKey = (string4 == null || (setKeySet = string4.keySet()) == null) ? null : (String) CollectionsKt.firstOrNull(setKeySet);
                        }
                    }
                }
            }
        }
        if (sampleKey != null) {
            String it = sampleKey;
            syncCategoryClassifyKey = INSTANCE.classifyKey(it);
            if (syncCategoryClassifyKey == null) {
                syncCategoryClassifyKey = SyncCategory.SETTINGS;
            }
        } else {
            syncCategoryClassifyKey = SyncCategory.SETTINGS;
        }
        SyncCategory category = syncCategoryClassifyKey;
        return new BackupFile(mergeBackupVars(local.getDatastore(), cloud.getDatastore(), localCategoryTs, cloudPayloadTs, category, isLocallyDirty), mergeBackupVars(local.getSettings(), cloud.getSettings(), localCategoryTs, cloudPayloadTs, category, isLocallyDirty));
    }

    private final BackupVars mergeBackupVars(BackupVars local, BackupVars cloud, long localCategoryTs, long cloudPayloadTs, SyncCategory category, boolean isLocallyDirty) {
        return new BackupVars(mergeCategoryMap(category, local.getBool(), cloud.getBool(), localCategoryTs, cloudPayloadTs, local.getString(), cloud.getString(), isLocallyDirty), mergeCategoryMap(category, local.getInt(), cloud.getInt(), localCategoryTs, cloudPayloadTs, local.getString(), cloud.getString(), isLocallyDirty), mergeCategoryMap(category, local.getString(), cloud.getString(), localCategoryTs, cloudPayloadTs, local.getString(), cloud.getString(), isLocallyDirty), mergeCategoryMap(category, local.getFloat(), cloud.getFloat(), localCategoryTs, cloudPayloadTs, local.getString(), cloud.getString(), isLocallyDirty), mergeCategoryMap(category, local.getLong(), cloud.getLong(), localCategoryTs, cloudPayloadTs, local.getString(), cloud.getString(), isLocallyDirty), mergeCategoryMap(category, local.getStringSet(), cloud.getStringSet(), localCategoryTs, cloudPayloadTs, local.getString(), cloud.getString(), isLocallyDirty));
    }

    private final long extractTimestamp(String json) {
        if (json == null) {
            return 0L;
        }
        try {
            MatchResult updateTimeMatch = Regex.find$default(new Regex("\"updateTime\":\\s*(\\d+)"), json, 0, 2, (Object) null);
            if (updateTimeMatch != null) {
                return Long.parseLong((String) updateTimeMatch.getGroupValues().get(1));
            }
            MatchResult latestUpdatedTimeMatch = Regex.find$default(new Regex("\"latestUpdatedTime\":\\s*(\\d+)"), json, 0, 2, (Object) null);
            if (latestUpdatedTimeMatch != null) {
                return Long.parseLong((String) latestUpdatedTimeMatch.getGroupValues().get(1));
            }
            MatchResult searchedAtMatch = Regex.find$default(new Regex("\"searchedAt\":\\s*(\\d+)"), json, 0, 2, (Object) null);
            if (searchedAtMatch != null) {
                return Long.parseLong((String) searchedAtMatch.getGroupValues().get(1));
            }
            return 0L;
        } catch (Exception e) {
        }
    }

    public final boolean isEmpty(@NotNull BackupVars $this$isEmpty) {
        Map<String, Boolean> bool = $this$isEmpty.getBool();
        if (!(bool == null || bool.isEmpty())) {
            return false;
        }
        Map<String, Integer> map = $this$isEmpty.getInt();
        if (!(map == null || map.isEmpty())) {
            return false;
        }
        Map<String, String> string = $this$isEmpty.getString();
        if (!(string == null || string.isEmpty())) {
            return false;
        }
        Map<String, Float> map2 = $this$isEmpty.getFloat();
        if (!(map2 == null || map2.isEmpty())) {
            return false;
        }
        Map<String, Long> map3 = $this$isEmpty.getLong();
        if (!(map3 == null || map3.isEmpty())) {
            return false;
        }
        Map<String, Set<String>> stringSet = $this$isEmpty.getStringSet();
        return stringSet == null || stringSet.isEmpty();
    }
}
