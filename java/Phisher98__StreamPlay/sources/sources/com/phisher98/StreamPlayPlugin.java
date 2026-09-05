package com.phisher98;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainActivity;
import com.lagradost.cloudstream3.extractors.DoodYtExtractor;
import com.lagradost.cloudstream3.extractors.FileMoon;
import com.lagradost.cloudstream3.extractors.FilemoonV2;
import com.lagradost.cloudstream3.extractors.MixDrop;
import com.lagradost.cloudstream3.extractors.Mp4Upload;
import com.lagradost.cloudstream3.extractors.OkRuHTTP;
import com.lagradost.cloudstream3.extractors.OkRuSSL;
import com.lagradost.cloudstream3.extractors.StreamSB;
import com.lagradost.cloudstream3.extractors.StreamSB8;
import com.lagradost.cloudstream3.extractors.StreamTape;
import com.lagradost.cloudstream3.extractors.StreamWishExtractor;
import com.lagradost.cloudstream3.extractors.Streamlare;
import com.lagradost.cloudstream3.extractors.VidHidePro6;
import com.lagradost.cloudstream3.extractors.VidStack;
import com.lagradost.cloudstream3.extractors.Vidmolyme;
import com.lagradost.cloudstream3.extractors.Voe;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import com.lagradost.cloudstream3.plugins.PluginData;
import com.lagradost.cloudstream3.plugins.PluginManager;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: StreamPlayPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000Ê\u0001\u0002\b\u0011¨\u0006\u0010"}, d2 = {"Lcom/phisher98/StreamPlayPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "registeredMainApis", "", "Lcom/lagradost/cloudstream3/MainAPI;", "PREF_FILE", "", "PREF_KEY_LINKS", "load", "", "context", "Landroid/content/Context;", "reload", "LinkEntry", "StreamPlay", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@CloudstreamPlugin
@SourceDebugExtension({"SMAP\nStreamPlayPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayPlugin.kt\ncom/phisher98/StreamPlayPlugin\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,305:1\n40#2,11:306\n40#2,11:317\n40#2,11:332\n1739#3:328\n1814#3,3:329\n*S KotlinDebug\n*F\n+ 1 StreamPlayPlugin.kt\ncom/phisher98/StreamPlayPlugin\n*L\n43#1:306,11\n60#1:317,11\n88#1:332,11\n72#1:328\n72#1:329,3\n*E\n"})
public final class StreamPlayPlugin extends Plugin {

    @NotNull
    private final List<MainAPI> registeredMainApis = new ArrayList();

    @NotNull
    private final String PREF_FILE = "StreamPlay";

    @NotNull
    private final String PREF_KEY_LINKS = "streamplay_stremio_saved_links";

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public void load(@NotNull Context context) throws NoWhenBranchMatchedException {
        char c;
        char c2;
        final SharedPreferences sharedPref = context.getSharedPreferences(this.PREF_FILE, 0);
        SharedPreferences febboxPref = context.getSharedPreferences("SuperStream", 0);
        String febboxToken = febboxPref.getString("token", null);
        String str = febboxToken;
        if (!(str == null || StringsKt.isBlank(str))) {
            String string = sharedPref.getString("token", null);
            if (string == null || StringsKt.isBlank(string)) {
                SharedPreferences.Editor editor$iv = sharedPref.edit();
                Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
                editor$iv.putString("token", febboxToken);
                editor$iv.apply();
            }
        }
        Log.INSTANCE.d("StreamPlay", "🚀 Initializing StreamPlay optimizations...");
        StreamPlayCache.INSTANCE.loadProviderStats(sharedPref);
        StreamPlayConcurrency.DeviceProfile deviceProfile = StreamPlayConcurrency.INSTANCE.detectDeviceProfile(context);
        Log.INSTANCE.d("StreamPlay", "📱 Device profile: " + deviceProfile);
        int currentConcurrency = sharedPref.getInt("provider_concurrency", -1);
        if (currentConcurrency != -1) {
            c = 0;
            c2 = 1;
        } else {
            int recommended = deviceProfile.getRecommendedConcurrency();
            c = 0;
            SharedPreferences.Editor editor$iv2 = sharedPref.edit();
            Intrinsics.checkExpressionValueIsNotNull(editor$iv2, "editor");
            c2 = 1;
            editor$iv2.putInt("provider_concurrency", recommended);
            editor$iv2.apply();
            Log.INSTANCE.d("StreamPlay", "⚙️ Set recommended concurrency: " + recommended);
        }
        StreamPlay mainStreamPlay = new StreamPlay(sharedPref);
        MainAPI[] mainAPIArr = new MainAPI[2];
        mainAPIArr[c] = mainStreamPlay;
        mainAPIArr[c2] = new StreamPlayAnime();
        List<MainAPI> mainApis = CollectionsKt.listOf(mainAPIArr);
        Set<String> stringSet = sharedPref.getStringSet("enabled_plugins_saved", null);
        List $this$map$iv = mainApis;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            MainAPI it = (MainAPI) item$iv$iv;
            destination$iv$iv.add(it.getName());
        }
        Set<String> set = CollectionsKt.toSet((List) destination$iv$iv);
        Set<String> set2 = stringSet == null ? set : stringSet;
        Log.INSTANCE.d("StreamPlay", "SavedSet: " + stringSet + ", DefaultEnabled: " + set);
        Log.INSTANCE.d("StreamPlay", "Final enabled set: " + set2);
        for (MainAPI api : mainApis) {
            if (set2.contains(api.getName())) {
                registerMainAPI(api);
                this.registeredMainApis.add(api);
                Log.INSTANCE.d("StreamPlay", "Registered plugin: " + api.getName());
                set = set;
                mainStreamPlay = mainStreamPlay;
            } else {
                Log.INSTANCE.d("StreamPlay", "Not enabled: " + api.getName());
                set = set;
                mainStreamPlay = mainStreamPlay;
            }
        }
        SharedPreferences.Editor editor$iv3 = sharedPref.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv3, "editor");
        editor$iv3.remove("enabled_plugins_set");
        editor$iv3.apply();
        reload(context);
        registerExtractorAPI((ExtractorApi) new Animefever());
        registerExtractorAPI(new Multimovies());
        registerExtractorAPI((ExtractorApi) new MultimoviesSB());
        registerExtractorAPI((ExtractorApi) new Yipsu());
        registerExtractorAPI((ExtractorApi) new Mwish());
        registerExtractorAPI(new Playm4u());
        registerExtractorAPI((ExtractorApi) new FileMoon());
        registerExtractorAPI(new VCloud());
        registerExtractorAPI(new Kwik());
        registerExtractorAPI(new VCloudGDirect());
        registerExtractorAPI((ExtractorApi) new Filelions());
        registerExtractorAPI((ExtractorApi) new Snolaxstream());
        registerExtractorAPI((ExtractorApi) new Pixeldra());
        registerExtractorAPI((ExtractorApi) new Mp4Upload());
        registerExtractorAPI((ExtractorApi) new Graceaddresscommunity());
        registerExtractorAPI(new M4ufree());
        registerExtractorAPI(new Streamruby());
        registerExtractorAPI((ExtractorApi) new StreamWishExtractor());
        registerExtractorAPI((ExtractorApi) new Filelion());
        registerExtractorAPI((ExtractorApi) new DoodYtExtractor());
        registerExtractorAPI((ExtractorApi) new dlions());
        registerExtractorAPI((ExtractorApi) new MixDrop());
        registerExtractorAPI((ExtractorApi) new dwish());
        registerExtractorAPI(new UqloadsXyz());
        registerExtractorAPI(new Uploadever());
        registerExtractorAPI(new Netembed());
        registerExtractorAPI(new Flaswish());
        registerExtractorAPI((ExtractorApi) new Comedyshow());
        registerExtractorAPI(new Ridoo());
        registerExtractorAPI(new Streamvid());
        registerExtractorAPI((ExtractorApi) new StreamTape());
        registerExtractorAPI((ExtractorApi) new do0od());
        registerExtractorAPI((ExtractorApi) new doodre());
        registerExtractorAPI(new Embedrise());
        registerExtractorAPI(new GDMirrorbot());
        registerExtractorAPI(new FilemoonNl());
        registerExtractorAPI(new Alions());
        registerExtractorAPI((ExtractorApi) new Vidmolyme());
        registerExtractorAPI((ExtractorApi) new AllinoneDownloader());
        registerExtractorAPI(new Tellygossips());
        registerExtractorAPI(new Tvlogy());
        registerExtractorAPI((ExtractorApi) new Voe());
        registerExtractorAPI(new Gofile());
        registerExtractorAPI((ExtractorApi) new Animezia());
        registerExtractorAPI(new PixelDrain());
        registerExtractorAPI(new Modflix());
        registerExtractorAPI((ExtractorApi) new Sethniceletter());
        registerExtractorAPI(new GDFlix());
        registerExtractorAPI(new fastdlserver());
        registerExtractorAPI(new GDFlix1());
        registerExtractorAPI(new GDFlix2());
        registerExtractorAPI(new GDFlixApp());
        registerExtractorAPI(new GDLink());
        registerExtractorAPI(new GDFlixNet());
        registerExtractorAPI((ExtractorApi) new furher());
        registerExtractorAPI((ExtractorApi) new Servertwo());
        registerExtractorAPI((ExtractorApi) new MultimoviesAIO());
        registerExtractorAPI(new HubCloud());
        registerExtractorAPI(new Driveseed());
        registerExtractorAPI(new Driveleech());
        registerExtractorAPI((ExtractorApi) new VidHidePro6());
        registerExtractorAPI((ExtractorApi) new MixDropSi());
        registerExtractorAPI((ExtractorApi) new MixDropPs());
        registerExtractorAPI((ExtractorApi) new Streamlare());
        registerExtractorAPI((ExtractorApi) new StreamSB8());
        registerExtractorAPI((ExtractorApi) new StreamSB());
        registerExtractorAPI((ExtractorApi) new OkRuSSL());
        registerExtractorAPI((ExtractorApi) new OkRuHTTP());
        registerExtractorAPI(new Embtaku());
        registerExtractorAPI((ExtractorApi) new bulbasaur());
        registerExtractorAPI(new Cdnstreame());
        registerExtractorAPI((ExtractorApi) new Rapidplayers());
        registerExtractorAPI((ExtractorApi) new Maxfinishseveral());
        registerExtractorAPI(new Pahe());
        registerExtractorAPI(new OFile());
        registerExtractorAPI(new Hblinks());
        registerExtractorAPI((ExtractorApi) new VidStack());
        registerExtractorAPI(new Videostr());
        registerExtractorAPI(new DriveleechPro());
        registerExtractorAPI(new DriveleechNet());
        registerExtractorAPI(new Molop());
        registerExtractorAPI((ExtractorApi) new Embedwish());
        registerExtractorAPI((ExtractorApi) new Rubyvidhub());
        registerExtractorAPI((ExtractorApi) new smoothpre());
        registerExtractorAPI(new Akirabox());
        registerExtractorAPI(new BuzzServer());
        registerExtractorAPI((ExtractorApi) new FilemoonV2());
        registerExtractorAPI((ExtractorApi) new StreamwishHG());
        registerExtractorAPI((ExtractorApi) new PixelServer());
        registerExtractorAPI(new Vidora());
        registerExtractorAPI(new XdMoviesExtractor());
        registerExtractorAPI(new Hubdrive());
        registerExtractorAPI((ExtractorApi) new HdStream4u());
        registerExtractorAPI((ExtractorApi) new Hubstream());
        registerExtractorAPI(new HUBCDN());
        registerExtractorAPI((ExtractorApi) new PixelDrainDev());
        registerExtractorAPI(new Krakenfiles());
        registerExtractorAPI((ExtractorApi) new Movearnpre());
        registerExtractorAPI((ExtractorApi) new StreamwishTO());
        registerExtractorAPI((ExtractorApi) new mixdrop21());
        registerExtractorAPI((ExtractorApi) new m1xdrop());
        registerExtractorAPI(new PpzjYoutube());
        registerExtractorAPI(new Filesdl());
        registerExtractorAPI(new HDm2());
        registerExtractorAPI(new ZenCloudExtractor());
        registerExtractorAPI((ExtractorApi) new KumiUns());
        registerExtractorAPI(new Rapid());
        registerExtractorAPI((ExtractorApi) new Allanimeups());
        registerExtractorAPI(new Wootly());
        registerExtractorAPI((ExtractorApi) new Luluvdo());
        registerExtractorAPI(new Iqsmartgames());
        registerExtractorAPI(new Shikshakdaak());
        registerExtractorAPI(new Gdshine());
        registerExtractorAPI(new FlixCloud());
        registerExtractorAPI(new Bysekoze());
        registerExtractorAPI(new ByseSX());
        registerExtractorAPI(new Hubcloudone());
        setOpenSettings(new Function1() { // from class: com.phisher98.StreamPlayPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return StreamPlayPlugin.load$lambda$4(this.f$0, sharedPref, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$4(StreamPlayPlugin this$0, SharedPreferences $sharedPref, Context ctx) {
        Intrinsics.checkNotNull(ctx, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity act = (AppCompatActivity) ctx;
        if (!act.isFinishing() && !act.isDestroyed()) {
            MainSettingsFragment frag = new MainSettingsFragment(this$0, $sharedPref);
            frag.show(act.getSupportFragmentManager(), "Frag");
        } else {
            Log.INSTANCE.e("Plugin", "Activity is not valid anymore, cannot show settings dialog");
        }
        return Unit.INSTANCE;
    }

    public final void reload(@NotNull Context context) {
        PluginData found;
        try {
            try {
                SharedPreferences prefs = context.getSharedPreferences(this.PREF_FILE, 0);
                String string = prefs.getString(this.PREF_KEY_LINKS, null);
                if (string == null) {
                    string = "[]";
                }
                String json = string;
                JSONArray arr = new JSONArray(json);
                List links = new ArrayList();
                int length = arr.length();
                for (int i = 0; i < length; i++) {
                    JSONObject obj = arr.optJSONObject(i);
                    if (obj != null) {
                        links.add(new LinkEntry(obj.optLong("id", System.currentTimeMillis()), obj.optString("name", ""), obj.optString("link", ""), obj.optString("type", "StremioX")));
                    }
                }
                Iterator it = links.iterator();
                while (it.hasNext()) {
                    LinkEntry item = (LinkEntry) it.next();
                    PluginData[] pluginsOnline = PluginManager.INSTANCE.getPluginsOnline();
                    PluginData found2 = null;
                    int length2 = pluginsOnline.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            found = found2;
                            it = it;
                            break;
                        }
                        PluginData p = pluginsOnline[i2];
                        PluginData found3 = found2;
                        it = it;
                        if (!StringsKt.contains(p.getInternalName(), item.getName(), true)) {
                            i2++;
                            it = it;
                            found2 = found3;
                        } else {
                            found = p;
                            break;
                        }
                    }
                    if (found != null) {
                        try {
                            PluginManager.INSTANCE.unloadPlugin(found.getFilePath());
                        } catch (Throwable e) {
                            Log.INSTANCE.e("StreamplayStremioXPlugin", "unload failed " + e.getMessage());
                        }
                    } else {
                        try {
                            if (Intrinsics.areEqual(item.getType(), "StremioC")) {
                                try {
                                    registerMainAPI(new StreamPlayStremioCatelog(item.getLink(), item.getName(), prefs));
                                } catch (Throwable th) {
                                    registerMainAPI(new StreamPlayStremioCatelog("", item.getName(), prefs));
                                }
                            } else {
                                registerMainAPI(new StreamPlayStremioCatelog(item.getLink(), item.getName(), prefs));
                            }
                        } catch (Throwable e2) {
                            Log.INSTANCE.e("StreamplayStremioXPlugin", "register failed " + e2.getMessage());
                        }
                    }
                }
                try {
                    MainActivity.Companion.getAfterPluginsLoadedEvent().invoke(true);
                } catch (Throwable e3) {
                    Log.INSTANCE.w("StreamplayStremioXPlugin", "afterPluginsLoaded invoke failed " + e3.getMessage());
                }
            } catch (Throwable th2) {
                e = th2;
                Log.INSTANCE.e("StreamplayStremioXPlugin", "reload error " + e.getMessage());
            }
        } catch (Throwable th3) {
            e = th3;
        }
    }

    /* JADX INFO: compiled from: StreamPlayPlugin.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/phisher98/StreamPlayPlugin$LinkEntry;", "", "id", "", "name", "", "link", "type", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getLink", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkEntry {
        private final long id;

        @NotNull
        private final String link;

        @NotNull
        private final String name;

        @NotNull
        private final String type;

        public static /* synthetic */ LinkEntry copy$default(LinkEntry linkEntry, long j, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = linkEntry.id;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = linkEntry.name;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = linkEntry.link;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = linkEntry.type;
            }
            return linkEntry.copy(j2, str4, str5, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final LinkEntry copy(long id, @NotNull String name, @NotNull String link, @NotNull String type) {
            return new LinkEntry(id, name, link, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkEntry)) {
                return false;
            }
            LinkEntry linkEntry = (LinkEntry) other;
            return this.id == linkEntry.id && Intrinsics.areEqual(this.name, linkEntry.name) && Intrinsics.areEqual(this.link, linkEntry.link) && Intrinsics.areEqual(this.type, linkEntry.type);
        }

        public int hashCode() {
            return (((((StreamPlayPlugin$LinkEntry$$ExternalSyntheticBackport0.m28m(this.id) * 31) + this.name.hashCode()) * 31) + this.link.hashCode()) * 31) + this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "LinkEntry(id=" + this.id + ", name=" + this.name + ", link=" + this.link + ", type=" + this.type + ')';
        }

        public LinkEntry(long id, @NotNull String name, @NotNull String link, @NotNull String type) {
            this.id = id;
            this.name = name;
            this.link = link;
            this.type = type;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getLink() {
            return this.link;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }
}
