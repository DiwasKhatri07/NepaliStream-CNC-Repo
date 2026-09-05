package com.phisher98;

import android.content.SharedPreferences;
import android.util.Base64;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.metaproviders.TraktProvider;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.syncproviders.SyncIdName;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TorraStreamTrakt.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JF\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001d2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020(0&H\u0096@¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u001e\u0010-\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f¨\u00061"}, d2 = {"Lcom/phisher98/TorraStreamTrakt;", "Lcom/lagradost/cloudstream3/metaproviders/TraktProvider;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "setSupportedTypes", "(Ljava/util/Set;)V", "lang", "getLang", "setLang", "supportedSyncNames", "Lcom/lagradost/cloudstream3/syncproviders/SyncIdName;", "getSupportedSyncNames", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildTorrentioApiUrl", "buildMeteorUrl", "baseUrl", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LoadDataTrakt", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTorraStreamTrakt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamTrakt.kt\ncom/phisher98/TorraStreamTrakt\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,227:1\n63#2:228\n64#2,15:230\n1#3:229\n1#3:247\n50#4:245\n43#4:246\n*S KotlinDebug\n*F\n+ 1 TorraStreamTrakt.kt\ncom/phisher98/TorraStreamTrakt\n*L\n40#1:228\n40#1:230,15\n40#1:229\n40#1:245\n40#1:246\n*E\n"})
public final class TorraStreamTrakt extends TraktProvider {
    private final boolean hasQuickSearch;

    @NotNull
    private final SharedPreferences sharedPref;

    @NotNull
    private String name = "TorraStream";

    @NotNull
    private String mainUrl = "https://torrentio.strem.fun";

    @NotNull
    private Set<? extends TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.AsianDrama, TvType.Torrent});

    @NotNull
    private String lang = "en";

    @NotNull
    private final Set<SyncIdName> supportedSyncNames = SetsKt.setOf(SyncIdName.Trakt);
    private final boolean hasMainPage = true;

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$buildMeteorUrl$1 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt", f = "TorraStreamTrakt.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {155}, m = "buildMeteorUrl", n = {"sharedPref", "baseUrl", "debridProvider", "debridKey", "languagesPref", "limit", "sizeFilter", "$this$buildMeteorUrl_u24lambda_u240"}, nl = {157}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8"}, v = 2)
    static final class C00581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C00581(Continuation<? super C00581> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamTrakt.this.buildMeteorUrl(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$1 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt", f = "TorraStreamTrakt.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {47, 61, 65, 74, 80, 116}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "$this$loadLinks_u24lambda_u240", "isCasting", "isAnime", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid"}, nl = {47, 62, 71, 80, 116, 117}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1"}, v = 2)
    static final class C00591 extends ContinuationImpl {
        int I$0;
        int I$1;
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

        C00591(Continuation<? super C00591> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamTrakt.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    public TorraStreamTrakt(@NotNull SharedPreferences sharedPref) {
        this.sharedPref = sharedPref;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    public void setSupportedTypes(@NotNull Set<? extends TvType> set) {
        this.supportedTypes = set;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @NotNull
    public Set<SyncIdName> getSupportedSyncNames() {
        return this.supportedSyncNames;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x05fa  */
    /* JADX WARN: Code duplicated, block: B:103:0x05ff  */
    /* JADX WARN: Code duplicated, block: B:104:0x0608  */
    /* JADX WARN: Code duplicated, block: B:106:0x060d  */
    /* JADX WARN: Code duplicated, block: B:107:0x061a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0622  */
    /* JADX WARN: Code duplicated, block: B:112:0x062c  */
    /* JADX WARN: Code duplicated, block: B:114:0x063b  */
    /* JADX WARN: Code duplicated, block: B:115:0x063d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0640  */
    /* JADX WARN: Code duplicated, block: B:121:0x064b  */
    /* JADX WARN: Code duplicated, block: B:122:0x0652  */
    /* JADX WARN: Code duplicated, block: B:125:0x0662  */
    /* JADX WARN: Code duplicated, block: B:126:0x0667  */
    /* JADX WARN: Code duplicated, block: B:129:0x06cb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:130:0x06cc  */
    /* JADX WARN: Code duplicated, block: B:133:0x06fc  */
    /* JADX WARN: Code duplicated, block: B:137:0x0706  */
    /* JADX WARN: Code duplicated, block: B:139:0x070a  */
    /* JADX WARN: Code duplicated, block: B:141:0x0713  */
    /* JADX WARN: Code duplicated, block: B:143:0x07a6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:144:0x07a7  */
    /* JADX WARN: Code duplicated, block: B:146:0x07cc  */
    /* JADX WARN: Code duplicated, block: B:147:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:151:0x080d  */
    /* JADX WARN: Code duplicated, block: B:155:0x0816  */
    /* JADX WARN: Code duplicated, block: B:157:0x0819  */
    /* JADX WARN: Code duplicated, block: B:159:0x081f  */
    /* JADX WARN: Code duplicated, block: B:163:0x0828  */
    /* JADX WARN: Code duplicated, block: B:165:0x082c  */
    /* JADX WARN: Code duplicated, block: B:167:0x0835  */
    /* JADX WARN: Code duplicated, block: B:169:0x08c1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:170:0x08c2  */
    /* JADX WARN: Code duplicated, block: B:172:0x08d5  */
    /* JADX WARN: Code duplicated, block: B:176:0x09fe A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:177:0x09ff  */
    /* JADX WARN: Code duplicated, block: B:180:0x0a94 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:181:0x0a95  */
    /* JADX WARN: Code duplicated, block: B:79:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:83:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:84:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:87:0x05c9  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws JSONException {
        C00591 c00591;
        String key;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        Ref.ObjectRef episode;
        Object obj3;
        boolean isAnime;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        LoadDataTrakt dataObj;
        boolean isAnime2;
        String title;
        Integer season;
        String id;
        Integer year;
        String provider;
        String data2;
        Object obj4;
        Object obj5;
        Object obj6;
        Integer year2;
        String provider2;
        Function1<? super SubtitleFile, Unit> function5;
        String key2;
        Object obj7;
        NiceResponse aniResponse;
        String text;
        Object obj8;
        String anijson;
        boolean isAnime3;
        String anijson2;
        Object obj9;
        JSONObject aniJson;
        JSONObject mappings;
        Integer kitsuId;
        Integer kitsuId2;
        JSONObject mappings2;
        int i;
        Integer numBoxInt;
        Integer anidbEid;
        int anidbEid2;
        String anijson3;
        String torrentioapiUrl;
        int anidbEid3;
        TorraStreamTrakt torraStreamTrakt;
        Object objBuildMeteorUrl;
        Object obj10;
        LoadDataTrakt dataObj2;
        Ref.ObjectRef episode2;
        Object obj11;
        boolean isCasting2;
        JSONObject aniJson2;
        int i2;
        Function1<? super ExtractorLink, Unit> function6;
        String title2;
        NiceResponse aniResponse2;
        boolean isAnime4;
        JSONObject mappings3;
        String torrentioapiUrl2;
        Integer season2;
        Integer kitsuId3;
        String id2;
        int anidbEid4;
        String strOptString;
        String meteorUrl;
        Function1<ExtractorLink, Unit> function1FilteredCallback;
        String str;
        boolean z;
        String torrentioapiUrl3;
        Object obj12;
        char c;
        NiceResponse aniResponse3;
        String title3;
        Integer year3;
        Integer kitsuId4;
        Function1<ExtractorLink, Unit> function7;
        int i3;
        String torrentioapiUrl4;
        String meteorUrl2;
        int anidbEid5;
        String data3;
        boolean isAnime5;
        String key3;
        String torrentioapiUrl5;
        Ref.ObjectRef episode3;
        LoadDataTrakt dataObj3;
        Integer season3;
        Function1<? super ExtractorLink, Unit> function8;
        String str2;
        int anidbEid6;
        String torrentioapiUrl6;
        boolean isAnime6;
        Function1<? super ExtractorLink, Unit> function9;
        int i4;
        LoadDataTrakt dataObj4;
        Object objRunAllAsync;
        String torrentioapiUrl7;
        String torrentioapiUrl8;
        Function1<ExtractorLink, Unit> function10;
        boolean isAnime7;
        boolean isAnime8;
        int i5;
        String str3;
        boolean z2;
        String key4;
        Function1[] function1Arr;
        String torrentioapiUrl9;
        String provider3;
        Ref.ObjectRef episode4;
        Integer season4;
        String id3;
        NiceResponse aniResponse4;
        Integer kitsuId5;
        boolean isAnime9;
        String data4;
        String anijson4;
        String torrentioapiUrl10;
        String torrentioapiUrl11;
        NiceResponse aniResponse5;
        String str4;
        boolean z3;
        Function1[] function1Arr2;
        String key5;
        String provider4;
        String meteorUrl3;
        String anijson5;
        String provider5;
        Integer num;
        if (continuation instanceof C00591) {
            c00591 = (C00591) continuation;
            if ((c00591.label & Integer.MIN_VALUE) != 0) {
                c00591.label -= Integer.MIN_VALUE;
            } else {
                c00591 = new C00591(continuation);
            }
        } else {
            c00591 = new C00591(continuation);
        }
        C00591 c00592 = c00591;
        Object $result = c00592.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str5 = "AIO Streams";
        switch (c00592.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String provider6 = this.sharedPref.getString("debrid_provider", null);
                key = this.sharedPref.getString("debrid_key", null);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LoadDataTrakt.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) == null) {
                    obj2 = null;
                } else {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj2 = null;
                        try {
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadDataTrakt.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = null;
                    }
                }
                if (Result.isFailure-impl(obj)) {
                    obj = obj2;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LoadDataTrakt>() { // from class: com.phisher98.TorraStreamTrakt$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th4) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LoadDataTrakt>() { // from class: com.phisher98.TorraStreamTrakt$loadLinks$$inlined$parseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LoadDataTrakt>() { // from class: com.phisher98.TorraStreamTrakt$loadLinks$$inlined$parseJson$1
                    });
                }
                LoadDataTrakt dataObj5 = (LoadDataTrakt) objDecodeFromString;
                boolean isAnime10 = dataObj5.is_anime();
                String title4 = dataObj5.getTitle();
                Integer season5 = dataObj5.getSeason();
                episode = new Ref.ObjectRef();
                episode.element = dataObj5.getEpisode();
                String id4 = dataObj5.getImdb_id();
                Integer year4 = dataObj5.getYear();
                try {
                    Result.Companion companion5 = Result.Companion;
                    TorraStreamTrakt $this$loadLinks_u24lambda_u240 = this;
                    Requests app = MainActivityKt.getApp();
                    String str6 = "https://api.ani.zip/mappings?imdb_id=" + id4;
                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00592.L$1 = function1;
                    try {
                        c00592.L$2 = function2;
                        c00592.L$3 = provider6;
                        c00592.L$4 = key;
                        c00592.L$5 = dataObj5;
                        c00592.L$6 = title4;
                        c00592.L$7 = season5;
                        c00592.L$8 = episode;
                        c00592.L$9 = id4;
                        c00592.L$10 = year4;
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable($this$loadLinks_u24lambda_u240);
                        c00592.Z$0 = isCasting;
                        c00592.Z$1 = isAnime10;
                        try {
                            c00592.label = 1;
                            key = key;
                            obj3 = coroutine_suspended;
                            str5 = "AIO Streams";
                            try {
                                Object $result2 = Requests.get$default(app, str6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00592, 4094, (Object) null);
                                c00592 = c00592;
                                if ($result2 == obj3) {
                                    return obj3;
                                }
                                isAnime = isCasting;
                                function3 = function1;
                                obj4 = $result2;
                                dataObj = dataObj5;
                                isAnime2 = isAnime10;
                                title = title4;
                                season = season5;
                                episode = episode;
                                id = id4;
                                year = year4;
                                provider = provider6;
                                data2 = data;
                                function4 = function2;
                                try {
                                    obj5 = Result.constructor-impl((NiceResponse) obj4);
                                    break;
                                } catch (Throwable th5) {
                                    th = th5;
                                    Result.Companion companion6 = Result.Companion;
                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                obj6 = obj5;
                                year2 = year;
                                provider2 = provider;
                                function5 = function3;
                                key2 = key;
                                if (Result.isFailure-impl(obj6)) {
                                    obj7 = null;
                                } else {
                                    obj7 = obj6;
                                }
                                aniResponse = (NiceResponse) obj7;
                                if (aniResponse != null) {
                                    text = aniResponse.getText();
                                } else {
                                    text = null;
                                }
                                obj8 = obj3;
                                if (text == null) {
                                    text = "";
                                }
                                anijson = text;
                                try {
                                    Result.Companion companion7 = Result.Companion;
                                    TorraStreamTrakt torraStreamTrakt2 = this;
                                    isAnime3 = isAnime2;
                                    anijson2 = anijson;
                                    try {
                                        obj9 = Result.constructor-impl(new JSONObject(anijson2));
                                    } catch (Throwable th6) {
                                        th = th6;
                                        Result.Companion companion8 = Result.Companion;
                                        obj9 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                    break;
                                } catch (Throwable th7) {
                                    th = th7;
                                    isAnime3 = isAnime2;
                                    anijson2 = anijson;
                                }
                                if (Result.isFailure-impl(obj9)) {
                                    obj9 = null;
                                }
                                aniJson = (JSONObject) obj9;
                                if (aniJson != null) {
                                    mappings = aniJson.optJSONObject("mappings");
                                } else {
                                    mappings = null;
                                }
                                if (mappings != null) {
                                    kitsuId = Boxing.boxInt(mappings.optInt("kitsu_id"));
                                } else {
                                    kitsuId = null;
                                }
                                if (mappings != null) {
                                    kitsuId2 = kitsuId;
                                    strOptString = mappings.optString("type", "");
                                    if (strOptString != null) {
                                        mappings2 = mappings;
                                        i = StringsKt.contains(strOptString, "MOVIE", true) ? 1 : 0;
                                        if (i != 0) {
                                            numBoxInt = Boxing.boxInt(1);
                                        } else {
                                            numBoxInt = (Integer) episode.element;
                                        }
                                        episode.element = numBoxInt;
                                        anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                                        if (anidbEid != null) {
                                            anidbEid2 = anidbEid.intValue();
                                        } else {
                                            anidbEid2 = 0;
                                        }
                                        anijson3 = anijson2;
                                        torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                                        SharedPreferences sharedPreferences = this.sharedPref;
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = function4;
                                        c00592.L$3 = provider2;
                                        c00592.L$4 = key2;
                                        c00592.L$5 = dataObj;
                                        c00592.L$6 = title;
                                        c00592.L$7 = season;
                                        c00592.L$8 = episode;
                                        c00592.L$9 = id;
                                        c00592.L$10 = year2;
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                                        c00592.L$15 = kitsuId2;
                                        c00592.L$16 = torrentioapiUrl;
                                        c00592.Z$0 = isAnime;
                                        c00592.Z$1 = isAnime3;
                                        c00592.I$0 = i;
                                        c00592.I$1 = anidbEid2;
                                        c00592.label = 2;
                                        anidbEid3 = anidbEid2;
                                        torraStreamTrakt = this;
                                        objBuildMeteorUrl = torraStreamTrakt.buildMeteorUrl(sharedPreferences, TorraStream.Meteorfortheweebs, c00592);
                                        if (objBuildMeteorUrl == obj8) {
                                            return obj8;
                                        }
                                        Ref.ObjectRef objectRef = episode;
                                        obj10 = objBuildMeteorUrl;
                                        dataObj2 = dataObj;
                                        episode2 = objectRef;
                                        obj11 = obj8;
                                        isCasting2 = isAnime;
                                        aniJson2 = aniJson;
                                        i2 = i;
                                        function6 = function4;
                                        title2 = title;
                                        aniResponse2 = aniResponse;
                                        isAnime4 = isAnime3;
                                        mappings3 = mappings2;
                                        torrentioapiUrl2 = torrentioapiUrl;
                                        season2 = season;
                                        kitsuId3 = kitsuId2;
                                        id2 = id;
                                        anidbEid4 = anidbEid3;
                                        meteorUrl = (String) obj10;
                                        function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStreamTrakt.sharedPref, function6);
                                        str = key2;
                                        if (str != null || str.length() == 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            torrentioapiUrl3 = torrentioapiUrl2;
                                        } else {
                                            str2 = str5;
                                            if (!Intrinsics.areEqual(provider2, str2)) {
                                                str5 = str2;
                                                anidbEid6 = anidbEid4;
                                                torrentioapiUrl6 = torrentioapiUrl2;
                                                Function1 filtered = new C00643(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                                Function1[] function1Arr3 = {new C00632(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered};
                                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00592.L$1 = function5;
                                                c00592.L$2 = function6;
                                                c00592.L$3 = provider2;
                                                c00592.L$4 = key2;
                                                c00592.L$5 = dataObj2;
                                                c00592.L$6 = title2;
                                                c00592.L$7 = season2;
                                                c00592.L$8 = episode2;
                                                c00592.L$9 = id2;
                                                c00592.L$10 = year2;
                                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00592.L$15 = kitsuId3;
                                                c00592.L$16 = torrentioapiUrl6;
                                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                                c00592.L$18 = function1FilteredCallback;
                                                c00592.Z$0 = isCasting2;
                                                isAnime6 = isAnime4;
                                                c00592.Z$1 = isAnime6;
                                                function9 = function6;
                                                i4 = i2;
                                                c00592.I$0 = i4;
                                                c00592.I$1 = anidbEid6;
                                                dataObj4 = dataObj2;
                                                c00592.label = 3;
                                                c = 3;
                                                objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr3, c00592);
                                                obj12 = obj11;
                                                if (objRunAllAsync == obj12) {
                                                    return obj12;
                                                }
                                                aniResponse3 = aniResponse2;
                                                torrentioapiUrl7 = torrentioapiUrl6;
                                                torrentioapiUrl8 = title2;
                                                anidbEid5 = anidbEid6;
                                                data3 = provider2;
                                                function10 = function1FilteredCallback;
                                                isAnime7 = isAnime6;
                                                isAnime8 = isCasting2;
                                                i5 = i4;
                                                meteorUrl2 = meteorUrl;
                                                year3 = year2;
                                                kitsuId4 = kitsuId3;
                                                function7 = function10;
                                                i3 = i5;
                                                isAnime5 = isAnime7;
                                                isCasting2 = isAnime8;
                                                torrentioapiUrl4 = torrentioapiUrl7;
                                                title3 = torrentioapiUrl8;
                                                key3 = key2;
                                                torrentioapiUrl5 = id2;
                                                season3 = season2;
                                                episode3 = episode2;
                                                function8 = function9;
                                                dataObj3 = dataObj4;
                                                str3 = data3;
                                                if (str3 != null || str3.length() == 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                if (!z2) {
                                                    str4 = key3;
                                                    if (str4 != null || str4.length() == 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    if (!z3) {
                                                        if (Intrinsics.areEqual(data3, str5)) {
                                                            Function1<ExtractorLink, Unit> function11 = function7;
                                                            key5 = key3;
                                                            function7 = function11;
                                                            function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function11, null)};
                                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                            c00592.L$1 = function5;
                                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                            c00592.L$7 = season3;
                                                            c00592.L$8 = episode3;
                                                            c00592.L$9 = torrentioapiUrl5;
                                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                            c00592.Z$0 = isCasting2;
                                                            c00592.Z$1 = isAnime5;
                                                            c00592.I$0 = i3;
                                                            c00592.I$1 = anidbEid5;
                                                            c00592.label = 4;
                                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                                return obj12;
                                                            }
                                                            provider4 = data3;
                                                            meteorUrl3 = meteorUrl2;
                                                            anijson5 = anijson3;
                                                            provider5 = data2;
                                                            data2 = provider5;
                                                            meteorUrl2 = meteorUrl3;
                                                            anijson3 = anijson5;
                                                            data3 = provider4;
                                                            key3 = key5;
                                                        }
                                                        Unit unit = Unit.INSTANCE;
                                                        torrentioapiUrl11 = data3;
                                                        kitsuId5 = kitsuId4;
                                                        data4 = torrentioapiUrl5;
                                                        anijson4 = anijson3;
                                                        torrentioapiUrl10 = torrentioapiUrl4;
                                                        aniResponse5 = aniResponse3;
                                                    }
                                                    num = (Integer) episode3.element;
                                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00592.Z$0 = isCasting2;
                                                    c00592.Z$1 = isAnime5;
                                                    c00592.I$0 = i3;
                                                    c00592.I$1 = anidbEid5;
                                                    c00592.label = 6;
                                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                                        return obj12;
                                                    }
                                                    return Boxing.boxBoolean(true);
                                                }
                                                key4 = key3;
                                                function1Arr = new Function1[8];
                                                torrentioapiUrl9 = torrentioapiUrl4;
                                                function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                                provider3 = data3;
                                                Function1<? super ExtractorLink, Unit> function12 = function8;
                                                episode4 = episode3;
                                                season4 = season3;
                                                id3 = torrentioapiUrl5;
                                                LoadDataTrakt dataObj6 = dataObj3;
                                                C00676 c00676 = new C00676(dataObj6, id3, season4, episode4, function12, null);
                                                function8 = function12;
                                                function1Arr[1] = c00676;
                                                aniResponse4 = aniResponse3;
                                                function1Arr[2] = new C00687(dataObj6, anidbEid5, function8, null);
                                                Integer kitsuId6 = kitsuId4;
                                                function1Arr[c] = new C00698(kitsuId6, season4, episode4, function7, null);
                                                Function1<ExtractorLink, Unit> function13 = function7;
                                                function7 = function13;
                                                function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function13, null);
                                                function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                                kitsuId5 = kitsuId6;
                                                function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                                isAnime9 = isAnime5;
                                                function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00592.L$1 = function5;
                                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                c00592.L$7 = season4;
                                                c00592.L$8 = episode4;
                                                c00592.L$9 = id3;
                                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                c00592.Z$0 = isCasting2;
                                                c00592.Z$1 = isAnime9;
                                                c00592.I$0 = i3;
                                                c00592.I$1 = anidbEid5;
                                                c00592.label = 5;
                                                if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                                    return obj12;
                                                }
                                                data4 = id3;
                                                isAnime5 = isAnime9;
                                                season3 = season4;
                                                episode3 = episode4;
                                                key3 = key4;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl9;
                                                torrentioapiUrl11 = provider3;
                                                aniResponse5 = aniResponse4;
                                                num = (Integer) episode3.element;
                                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                c00592.Z$0 = isCasting2;
                                                c00592.Z$1 = isAnime5;
                                                c00592.I$0 = i3;
                                                c00592.I$1 = anidbEid5;
                                                c00592.label = 6;
                                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                                    return obj12;
                                                }
                                                return Boxing.boxBoolean(true);
                                            }
                                            torrentioapiUrl3 = torrentioapiUrl2;
                                            str5 = str2;
                                        }
                                        obj12 = obj11;
                                        int i6 = i2;
                                        c = 3;
                                        LoadDataTrakt dataObj7 = dataObj2;
                                        aniResponse3 = aniResponse2;
                                        title3 = title2;
                                        year3 = year2;
                                        kitsuId4 = kitsuId3;
                                        function7 = function1FilteredCallback;
                                        i3 = i6;
                                        torrentioapiUrl4 = torrentioapiUrl3;
                                        meteorUrl2 = meteorUrl;
                                        anidbEid5 = anidbEid4;
                                        data3 = provider2;
                                        isAnime5 = isAnime4;
                                        key3 = key2;
                                        torrentioapiUrl5 = id2;
                                        episode3 = episode2;
                                        dataObj3 = dataObj7;
                                        season3 = season2;
                                        function8 = function6;
                                        str3 = data3;
                                        if (str3 != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            str4 = key3;
                                            if (str4 != null) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                if (Intrinsics.areEqual(data3, str5)) {
                                                    Function1<ExtractorLink, Unit> function14 = function7;
                                                    key5 = key3;
                                                    function7 = function14;
                                                    function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function14, null)};
                                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00592.L$1 = function5;
                                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00592.L$7 = season3;
                                                    c00592.L$8 = episode3;
                                                    c00592.L$9 = torrentioapiUrl5;
                                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00592.Z$0 = isCasting2;
                                                    c00592.Z$1 = isAnime5;
                                                    c00592.I$0 = i3;
                                                    c00592.I$1 = anidbEid5;
                                                    c00592.label = 4;
                                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                        return obj12;
                                                    }
                                                    provider4 = data3;
                                                    meteorUrl3 = meteorUrl2;
                                                    anijson5 = anijson3;
                                                    provider5 = data2;
                                                    data2 = provider5;
                                                    meteorUrl2 = meteorUrl3;
                                                    anijson3 = anijson5;
                                                    data3 = provider4;
                                                    key3 = key5;
                                                }
                                                Unit unit2 = Unit.INSTANCE;
                                                torrentioapiUrl11 = data3;
                                                kitsuId5 = kitsuId4;
                                                data4 = torrentioapiUrl5;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl4;
                                                aniResponse5 = aniResponse3;
                                            }
                                            num = (Integer) episode3.element;
                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                            c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                            c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00592.Z$0 = isCasting2;
                                            c00592.Z$1 = isAnime5;
                                            c00592.I$0 = i3;
                                            c00592.I$1 = anidbEid5;
                                            c00592.label = 6;
                                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                                return obj12;
                                            }
                                            return Boxing.boxBoolean(true);
                                        }
                                        key4 = key3;
                                        function1Arr = new Function1[8];
                                        torrentioapiUrl9 = torrentioapiUrl4;
                                        function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                        provider3 = data3;
                                        Function1<? super ExtractorLink, Unit> function15 = function8;
                                        episode4 = episode3;
                                        season4 = season3;
                                        id3 = torrentioapiUrl5;
                                        LoadDataTrakt dataObj8 = dataObj3;
                                        C00676 c00677 = new C00676(dataObj8, id3, season4, episode4, function15, null);
                                        function8 = function15;
                                        function1Arr[1] = c00677;
                                        aniResponse4 = aniResponse3;
                                        function1Arr[2] = new C00687(dataObj8, anidbEid5, function8, null);
                                        Integer kitsuId7 = kitsuId4;
                                        function1Arr[c] = new C00698(kitsuId7, season4, episode4, function7, null);
                                        Function1<ExtractorLink, Unit> function16 = function7;
                                        function7 = function16;
                                        function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function16, null);
                                        function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                        kitsuId5 = kitsuId7;
                                        function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                        isAnime9 = isAnime5;
                                        function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = season4;
                                        c00592.L$8 = episode4;
                                        c00592.L$9 = id3;
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime9;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 5;
                                        if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                            return obj12;
                                        }
                                        data4 = id3;
                                        isAnime5 = isAnime9;
                                        season3 = season4;
                                        episode3 = episode4;
                                        key3 = key4;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl9;
                                        torrentioapiUrl11 = provider3;
                                        aniResponse5 = aniResponse4;
                                        num = (Integer) episode3.element;
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime5;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    mappings2 = mappings;
                                } else {
                                    kitsuId2 = kitsuId;
                                    mappings2 = mappings;
                                }
                                if (i != 0) {
                                    numBoxInt = Boxing.boxInt(1);
                                } else {
                                    numBoxInt = (Integer) episode.element;
                                }
                                episode.element = numBoxInt;
                                anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                                if (anidbEid != null) {
                                    anidbEid2 = anidbEid.intValue();
                                } else {
                                    anidbEid2 = 0;
                                }
                                anijson3 = anijson2;
                                torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                                SharedPreferences sharedPreferences2 = this.sharedPref;
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = function5;
                                c00592.L$2 = function4;
                                c00592.L$3 = provider2;
                                c00592.L$4 = key2;
                                c00592.L$5 = dataObj;
                                c00592.L$6 = title;
                                c00592.L$7 = season;
                                c00592.L$8 = episode;
                                c00592.L$9 = id;
                                c00592.L$10 = year2;
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                                c00592.L$15 = kitsuId2;
                                c00592.L$16 = torrentioapiUrl;
                                c00592.Z$0 = isAnime;
                                c00592.Z$1 = isAnime3;
                                c00592.I$0 = i;
                                c00592.I$1 = anidbEid2;
                                c00592.label = 2;
                                anidbEid3 = anidbEid2;
                                torraStreamTrakt = this;
                                objBuildMeteorUrl = torraStreamTrakt.buildMeteorUrl(sharedPreferences2, TorraStream.Meteorfortheweebs, c00592);
                                if (objBuildMeteorUrl == obj8) {
                                    return obj8;
                                }
                                Ref.ObjectRef objectRef2 = episode;
                                obj10 = objBuildMeteorUrl;
                                dataObj2 = dataObj;
                                episode2 = objectRef2;
                                obj11 = obj8;
                                isCasting2 = isAnime;
                                aniJson2 = aniJson;
                                i2 = i;
                                function6 = function4;
                                title2 = title;
                                aniResponse2 = aniResponse;
                                isAnime4 = isAnime3;
                                mappings3 = mappings2;
                                torrentioapiUrl2 = torrentioapiUrl;
                                season2 = season;
                                kitsuId3 = kitsuId2;
                                id2 = id;
                                anidbEid4 = anidbEid3;
                                meteorUrl = (String) obj10;
                                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStreamTrakt.sharedPref, function6);
                                str = key2;
                                if (str != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    str2 = str5;
                                    if (!Intrinsics.areEqual(provider2, str2)) {
                                        str5 = str2;
                                        anidbEid6 = anidbEid4;
                                        torrentioapiUrl6 = torrentioapiUrl2;
                                        Function1 filtered2 = new C00643(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                        Function1[] function1Arr4 = {new C00632(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered2};
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = function6;
                                        c00592.L$3 = provider2;
                                        c00592.L$4 = key2;
                                        c00592.L$5 = dataObj2;
                                        c00592.L$6 = title2;
                                        c00592.L$7 = season2;
                                        c00592.L$8 = episode2;
                                        c00592.L$9 = id2;
                                        c00592.L$10 = year2;
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = kitsuId3;
                                        c00592.L$16 = torrentioapiUrl6;
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                        c00592.L$18 = function1FilteredCallback;
                                        c00592.Z$0 = isCasting2;
                                        isAnime6 = isAnime4;
                                        c00592.Z$1 = isAnime6;
                                        function9 = function6;
                                        i4 = i2;
                                        c00592.I$0 = i4;
                                        c00592.I$1 = anidbEid6;
                                        dataObj4 = dataObj2;
                                        c00592.label = 3;
                                        c = 3;
                                        objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr4, c00592);
                                        obj12 = obj11;
                                        if (objRunAllAsync == obj12) {
                                            return obj12;
                                        }
                                        aniResponse3 = aniResponse2;
                                        torrentioapiUrl7 = torrentioapiUrl6;
                                        torrentioapiUrl8 = title2;
                                        anidbEid5 = anidbEid6;
                                        data3 = provider2;
                                        function10 = function1FilteredCallback;
                                        isAnime7 = isAnime6;
                                        isAnime8 = isCasting2;
                                        i5 = i4;
                                        meteorUrl2 = meteorUrl;
                                        year3 = year2;
                                        kitsuId4 = kitsuId3;
                                        function7 = function10;
                                        i3 = i5;
                                        isAnime5 = isAnime7;
                                        isCasting2 = isAnime8;
                                        torrentioapiUrl4 = torrentioapiUrl7;
                                        title3 = torrentioapiUrl8;
                                        key3 = key2;
                                        torrentioapiUrl5 = id2;
                                        season3 = season2;
                                        episode3 = episode2;
                                        function8 = function9;
                                        dataObj3 = dataObj4;
                                        str3 = data3;
                                        if (str3 != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            str4 = key3;
                                            if (str4 != null) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                if (Intrinsics.areEqual(data3, str5)) {
                                                    Function1<ExtractorLink, Unit> function17 = function7;
                                                    key5 = key3;
                                                    function7 = function17;
                                                    function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function17, null)};
                                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00592.L$1 = function5;
                                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00592.L$7 = season3;
                                                    c00592.L$8 = episode3;
                                                    c00592.L$9 = torrentioapiUrl5;
                                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00592.Z$0 = isCasting2;
                                                    c00592.Z$1 = isAnime5;
                                                    c00592.I$0 = i3;
                                                    c00592.I$1 = anidbEid5;
                                                    c00592.label = 4;
                                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                        return obj12;
                                                    }
                                                    provider4 = data3;
                                                    meteorUrl3 = meteorUrl2;
                                                    anijson5 = anijson3;
                                                    provider5 = data2;
                                                    data2 = provider5;
                                                    meteorUrl2 = meteorUrl3;
                                                    anijson3 = anijson5;
                                                    data3 = provider4;
                                                    key3 = key5;
                                                }
                                                Unit unit3 = Unit.INSTANCE;
                                                torrentioapiUrl11 = data3;
                                                kitsuId5 = kitsuId4;
                                                data4 = torrentioapiUrl5;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl4;
                                                aniResponse5 = aniResponse3;
                                            }
                                            num = (Integer) episode3.element;
                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                            c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                            c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00592.Z$0 = isCasting2;
                                            c00592.Z$1 = isAnime5;
                                            c00592.I$0 = i3;
                                            c00592.I$1 = anidbEid5;
                                            c00592.label = 6;
                                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                                return obj12;
                                            }
                                            return Boxing.boxBoolean(true);
                                        }
                                        key4 = key3;
                                        function1Arr = new Function1[8];
                                        torrentioapiUrl9 = torrentioapiUrl4;
                                        function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                        provider3 = data3;
                                        Function1<? super ExtractorLink, Unit> function18 = function8;
                                        episode4 = episode3;
                                        season4 = season3;
                                        id3 = torrentioapiUrl5;
                                        LoadDataTrakt dataObj9 = dataObj3;
                                        C00676 c00678 = new C00676(dataObj9, id3, season4, episode4, function18, null);
                                        function8 = function18;
                                        function1Arr[1] = c00678;
                                        aniResponse4 = aniResponse3;
                                        function1Arr[2] = new C00687(dataObj9, anidbEid5, function8, null);
                                        Integer kitsuId8 = kitsuId4;
                                        function1Arr[c] = new C00698(kitsuId8, season4, episode4, function7, null);
                                        Function1<ExtractorLink, Unit> function19 = function7;
                                        function7 = function19;
                                        function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function19, null);
                                        function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                        kitsuId5 = kitsuId8;
                                        function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                        isAnime9 = isAnime5;
                                        function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = season4;
                                        c00592.L$8 = episode4;
                                        c00592.L$9 = id3;
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime9;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 5;
                                        if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                            return obj12;
                                        }
                                        data4 = id3;
                                        isAnime5 = isAnime9;
                                        season3 = season4;
                                        episode3 = episode4;
                                        key3 = key4;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl9;
                                        torrentioapiUrl11 = provider3;
                                        aniResponse5 = aniResponse4;
                                        num = (Integer) episode3.element;
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime5;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                    str5 = str2;
                                } else {
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                }
                                obj12 = obj11;
                                int i7 = i2;
                                c = 3;
                                LoadDataTrakt dataObj10 = dataObj2;
                                aniResponse3 = aniResponse2;
                                title3 = title2;
                                year3 = year2;
                                kitsuId4 = kitsuId3;
                                function7 = function1FilteredCallback;
                                i3 = i7;
                                torrentioapiUrl4 = torrentioapiUrl3;
                                meteorUrl2 = meteorUrl;
                                anidbEid5 = anidbEid4;
                                data3 = provider2;
                                isAnime5 = isAnime4;
                                key3 = key2;
                                torrentioapiUrl5 = id2;
                                episode3 = episode2;
                                dataObj3 = dataObj10;
                                season3 = season2;
                                function8 = function6;
                                str3 = data3;
                                if (str3 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    str4 = key3;
                                    if (str4 != null) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        if (Intrinsics.areEqual(data3, str5)) {
                                            Function1<ExtractorLink, Unit> function110 = function7;
                                            key5 = key3;
                                            function7 = function110;
                                            function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function110, null)};
                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00592.L$1 = function5;
                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00592.L$7 = season3;
                                            c00592.L$8 = episode3;
                                            c00592.L$9 = torrentioapiUrl5;
                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00592.Z$0 = isCasting2;
                                            c00592.Z$1 = isAnime5;
                                            c00592.I$0 = i3;
                                            c00592.I$1 = anidbEid5;
                                            c00592.label = 4;
                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                return obj12;
                                            }
                                            provider4 = data3;
                                            meteorUrl3 = meteorUrl2;
                                            anijson5 = anijson3;
                                            provider5 = data2;
                                            data2 = provider5;
                                            meteorUrl2 = meteorUrl3;
                                            anijson3 = anijson5;
                                            data3 = provider4;
                                            key3 = key5;
                                        }
                                        Unit unit4 = Unit.INSTANCE;
                                        torrentioapiUrl11 = data3;
                                        kitsuId5 = kitsuId4;
                                        data4 = torrentioapiUrl5;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl4;
                                        aniResponse5 = aniResponse3;
                                    }
                                    num = (Integer) episode3.element;
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00592.Z$0 = isCasting2;
                                    c00592.Z$1 = isAnime5;
                                    c00592.I$0 = i3;
                                    c00592.I$1 = anidbEid5;
                                    c00592.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                key4 = key3;
                                function1Arr = new Function1[8];
                                torrentioapiUrl9 = torrentioapiUrl4;
                                function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                provider3 = data3;
                                Function1<? super ExtractorLink, Unit> function111 = function8;
                                episode4 = episode3;
                                season4 = season3;
                                id3 = torrentioapiUrl5;
                                LoadDataTrakt dataObj11 = dataObj3;
                                C00676 c00679 = new C00676(dataObj11, id3, season4, episode4, function111, null);
                                function8 = function111;
                                function1Arr[1] = c00679;
                                aniResponse4 = aniResponse3;
                                function1Arr[2] = new C00687(dataObj11, anidbEid5, function8, null);
                                Integer kitsuId9 = kitsuId4;
                                function1Arr[c] = new C00698(kitsuId9, season4, episode4, function7, null);
                                Function1<ExtractorLink, Unit> function112 = function7;
                                function7 = function112;
                                function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function112, null);
                                function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                kitsuId5 = kitsuId9;
                                function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                isAnime9 = isAnime5;
                                function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = function5;
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = season4;
                                c00592.L$8 = episode4;
                                c00592.L$9 = id3;
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime9;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 5;
                                if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                    return obj12;
                                }
                                data4 = id3;
                                isAnime5 = isAnime9;
                                season3 = season4;
                                episode3 = episode4;
                                key3 = key4;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl9;
                                torrentioapiUrl11 = provider3;
                                aniResponse5 = aniResponse4;
                                num = (Integer) episode3.element;
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime5;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            } catch (Throwable th8) {
                                th = th8;
                                c00592 = c00592;
                                isAnime = isCasting;
                                function3 = function1;
                                function4 = function2;
                                dataObj = dataObj5;
                                isAnime2 = isAnime10;
                                title = title4;
                                season = season5;
                                episode = episode;
                                id = id4;
                                year = year4;
                                provider = provider6;
                                data2 = data;
                                Result.Companion companion9 = Result.Companion;
                                obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                obj6 = obj5;
                                year2 = year;
                                provider2 = provider;
                                function5 = function3;
                                key2 = key;
                                if (Result.isFailure-impl(obj6)) {
                                    obj7 = null;
                                } else {
                                    obj7 = obj6;
                                }
                                aniResponse = (NiceResponse) obj7;
                                if (aniResponse != null) {
                                    text = aniResponse.getText();
                                } else {
                                    text = null;
                                }
                                obj8 = obj3;
                                if (text == null) {
                                    text = "";
                                }
                                anijson = text;
                                Result.Companion companion10 = Result.Companion;
                                TorraStreamTrakt torraStreamTrakt3 = this;
                                isAnime3 = isAnime2;
                                anijson2 = anijson;
                                obj9 = Result.constructor-impl(new JSONObject(anijson2));
                                if (Result.isFailure-impl(obj9)) {
                                    obj9 = null;
                                }
                                aniJson = (JSONObject) obj9;
                                if (aniJson != null) {
                                    mappings = aniJson.optJSONObject("mappings");
                                } else {
                                    mappings = null;
                                }
                                if (mappings != null) {
                                    kitsuId = Boxing.boxInt(mappings.optInt("kitsu_id"));
                                } else {
                                    kitsuId = null;
                                }
                                if (mappings != null) {
                                    kitsuId2 = kitsuId;
                                    strOptString = mappings.optString("type", "");
                                    if (strOptString != null) {
                                        mappings2 = mappings;
                                        if (StringsKt.contains(strOptString, "MOVIE", true)) {
                                        }
                                        if (i != 0) {
                                            numBoxInt = Boxing.boxInt(1);
                                        } else {
                                            numBoxInt = (Integer) episode.element;
                                        }
                                        episode.element = numBoxInt;
                                        anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                                        if (anidbEid != null) {
                                            anidbEid2 = anidbEid.intValue();
                                        } else {
                                            anidbEid2 = 0;
                                        }
                                        anijson3 = anijson2;
                                        torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                                        SharedPreferences sharedPreferences3 = this.sharedPref;
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = function4;
                                        c00592.L$3 = provider2;
                                        c00592.L$4 = key2;
                                        c00592.L$5 = dataObj;
                                        c00592.L$6 = title;
                                        c00592.L$7 = season;
                                        c00592.L$8 = episode;
                                        c00592.L$9 = id;
                                        c00592.L$10 = year2;
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                                        c00592.L$15 = kitsuId2;
                                        c00592.L$16 = torrentioapiUrl;
                                        c00592.Z$0 = isAnime;
                                        c00592.Z$1 = isAnime3;
                                        c00592.I$0 = i;
                                        c00592.I$1 = anidbEid2;
                                        c00592.label = 2;
                                        anidbEid3 = anidbEid2;
                                        torraStreamTrakt = this;
                                        objBuildMeteorUrl = torraStreamTrakt.buildMeteorUrl(sharedPreferences3, TorraStream.Meteorfortheweebs, c00592);
                                        if (objBuildMeteorUrl == obj8) {
                                            return obj8;
                                        }
                                        Ref.ObjectRef objectRef3 = episode;
                                        obj10 = objBuildMeteorUrl;
                                        dataObj2 = dataObj;
                                        episode2 = objectRef3;
                                        obj11 = obj8;
                                        isCasting2 = isAnime;
                                        aniJson2 = aniJson;
                                        i2 = i;
                                        function6 = function4;
                                        title2 = title;
                                        aniResponse2 = aniResponse;
                                        isAnime4 = isAnime3;
                                        mappings3 = mappings2;
                                        torrentioapiUrl2 = torrentioapiUrl;
                                        season2 = season;
                                        kitsuId3 = kitsuId2;
                                        id2 = id;
                                        anidbEid4 = anidbEid3;
                                        meteorUrl = (String) obj10;
                                        function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStreamTrakt.sharedPref, function6);
                                        str = key2;
                                        if (str != null) {
                                            z = true;
                                        } else {
                                            z = true;
                                        }
                                        if (z) {
                                            str2 = str5;
                                            if (!Intrinsics.areEqual(provider2, str2)) {
                                                str5 = str2;
                                                anidbEid6 = anidbEid4;
                                                torrentioapiUrl6 = torrentioapiUrl2;
                                                Function1 filtered3 = new C00643(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                                Function1[] function1Arr5 = {new C00632(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered3};
                                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00592.L$1 = function5;
                                                c00592.L$2 = function6;
                                                c00592.L$3 = provider2;
                                                c00592.L$4 = key2;
                                                c00592.L$5 = dataObj2;
                                                c00592.L$6 = title2;
                                                c00592.L$7 = season2;
                                                c00592.L$8 = episode2;
                                                c00592.L$9 = id2;
                                                c00592.L$10 = year2;
                                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00592.L$15 = kitsuId3;
                                                c00592.L$16 = torrentioapiUrl6;
                                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                                c00592.L$18 = function1FilteredCallback;
                                                c00592.Z$0 = isCasting2;
                                                isAnime6 = isAnime4;
                                                c00592.Z$1 = isAnime6;
                                                function9 = function6;
                                                i4 = i2;
                                                c00592.I$0 = i4;
                                                c00592.I$1 = anidbEid6;
                                                dataObj4 = dataObj2;
                                                c00592.label = 3;
                                                c = 3;
                                                objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr5, c00592);
                                                obj12 = obj11;
                                                if (objRunAllAsync == obj12) {
                                                    return obj12;
                                                }
                                                aniResponse3 = aniResponse2;
                                                torrentioapiUrl7 = torrentioapiUrl6;
                                                torrentioapiUrl8 = title2;
                                                anidbEid5 = anidbEid6;
                                                data3 = provider2;
                                                function10 = function1FilteredCallback;
                                                isAnime7 = isAnime6;
                                                isAnime8 = isCasting2;
                                                i5 = i4;
                                                meteorUrl2 = meteorUrl;
                                                year3 = year2;
                                                kitsuId4 = kitsuId3;
                                                function7 = function10;
                                                i3 = i5;
                                                isAnime5 = isAnime7;
                                                isCasting2 = isAnime8;
                                                torrentioapiUrl4 = torrentioapiUrl7;
                                                title3 = torrentioapiUrl8;
                                                key3 = key2;
                                                torrentioapiUrl5 = id2;
                                                season3 = season2;
                                                episode3 = episode2;
                                                function8 = function9;
                                                dataObj3 = dataObj4;
                                                str3 = data3;
                                                if (str3 != null) {
                                                    z2 = true;
                                                } else {
                                                    z2 = true;
                                                }
                                                if (!z2) {
                                                    str4 = key3;
                                                    if (str4 != null) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    if (!z3) {
                                                        if (Intrinsics.areEqual(data3, str5)) {
                                                            Function1<ExtractorLink, Unit> function113 = function7;
                                                            key5 = key3;
                                                            function7 = function113;
                                                            function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function113, null)};
                                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                            c00592.L$1 = function5;
                                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                            c00592.L$7 = season3;
                                                            c00592.L$8 = episode3;
                                                            c00592.L$9 = torrentioapiUrl5;
                                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                            c00592.Z$0 = isCasting2;
                                                            c00592.Z$1 = isAnime5;
                                                            c00592.I$0 = i3;
                                                            c00592.I$1 = anidbEid5;
                                                            c00592.label = 4;
                                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                                return obj12;
                                                            }
                                                            provider4 = data3;
                                                            meteorUrl3 = meteorUrl2;
                                                            anijson5 = anijson3;
                                                            provider5 = data2;
                                                            data2 = provider5;
                                                            meteorUrl2 = meteorUrl3;
                                                            anijson3 = anijson5;
                                                            data3 = provider4;
                                                            key3 = key5;
                                                        }
                                                        Unit unit5 = Unit.INSTANCE;
                                                        torrentioapiUrl11 = data3;
                                                        kitsuId5 = kitsuId4;
                                                        data4 = torrentioapiUrl5;
                                                        anijson4 = anijson3;
                                                        torrentioapiUrl10 = torrentioapiUrl4;
                                                        aniResponse5 = aniResponse3;
                                                    }
                                                    num = (Integer) episode3.element;
                                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00592.Z$0 = isCasting2;
                                                    c00592.Z$1 = isAnime5;
                                                    c00592.I$0 = i3;
                                                    c00592.I$1 = anidbEid5;
                                                    c00592.label = 6;
                                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                                        return obj12;
                                                    }
                                                    return Boxing.boxBoolean(true);
                                                }
                                                key4 = key3;
                                                function1Arr = new Function1[8];
                                                torrentioapiUrl9 = torrentioapiUrl4;
                                                function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                                provider3 = data3;
                                                Function1<? super ExtractorLink, Unit> function114 = function8;
                                                episode4 = episode3;
                                                season4 = season3;
                                                id3 = torrentioapiUrl5;
                                                LoadDataTrakt dataObj12 = dataObj3;
                                                C00676 c006710 = new C00676(dataObj12, id3, season4, episode4, function114, null);
                                                function8 = function114;
                                                function1Arr[1] = c006710;
                                                aniResponse4 = aniResponse3;
                                                function1Arr[2] = new C00687(dataObj12, anidbEid5, function8, null);
                                                Integer kitsuId10 = kitsuId4;
                                                function1Arr[c] = new C00698(kitsuId10, season4, episode4, function7, null);
                                                Function1<ExtractorLink, Unit> function115 = function7;
                                                function7 = function115;
                                                function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function115, null);
                                                function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                                kitsuId5 = kitsuId10;
                                                function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                                isAnime9 = isAnime5;
                                                function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00592.L$1 = function5;
                                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                c00592.L$7 = season4;
                                                c00592.L$8 = episode4;
                                                c00592.L$9 = id3;
                                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                c00592.Z$0 = isCasting2;
                                                c00592.Z$1 = isAnime9;
                                                c00592.I$0 = i3;
                                                c00592.I$1 = anidbEid5;
                                                c00592.label = 5;
                                                if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                                    return obj12;
                                                }
                                                data4 = id3;
                                                isAnime5 = isAnime9;
                                                season3 = season4;
                                                episode3 = episode4;
                                                key3 = key4;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl9;
                                                torrentioapiUrl11 = provider3;
                                                aniResponse5 = aniResponse4;
                                                num = (Integer) episode3.element;
                                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                c00592.Z$0 = isCasting2;
                                                c00592.Z$1 = isAnime5;
                                                c00592.I$0 = i3;
                                                c00592.I$1 = anidbEid5;
                                                c00592.label = 6;
                                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                                    return obj12;
                                                }
                                                return Boxing.boxBoolean(true);
                                            }
                                            torrentioapiUrl3 = torrentioapiUrl2;
                                            str5 = str2;
                                        } else {
                                            torrentioapiUrl3 = torrentioapiUrl2;
                                        }
                                        obj12 = obj11;
                                        int i8 = i2;
                                        c = 3;
                                        LoadDataTrakt dataObj13 = dataObj2;
                                        aniResponse3 = aniResponse2;
                                        title3 = title2;
                                        year3 = year2;
                                        kitsuId4 = kitsuId3;
                                        function7 = function1FilteredCallback;
                                        i3 = i8;
                                        torrentioapiUrl4 = torrentioapiUrl3;
                                        meteorUrl2 = meteorUrl;
                                        anidbEid5 = anidbEid4;
                                        data3 = provider2;
                                        isAnime5 = isAnime4;
                                        key3 = key2;
                                        torrentioapiUrl5 = id2;
                                        episode3 = episode2;
                                        dataObj3 = dataObj13;
                                        season3 = season2;
                                        function8 = function6;
                                        str3 = data3;
                                        if (str3 != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            str4 = key3;
                                            if (str4 != null) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                if (Intrinsics.areEqual(data3, str5)) {
                                                    Function1<ExtractorLink, Unit> function116 = function7;
                                                    key5 = key3;
                                                    function7 = function116;
                                                    function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function116, null)};
                                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00592.L$1 = function5;
                                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00592.L$7 = season3;
                                                    c00592.L$8 = episode3;
                                                    c00592.L$9 = torrentioapiUrl5;
                                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00592.Z$0 = isCasting2;
                                                    c00592.Z$1 = isAnime5;
                                                    c00592.I$0 = i3;
                                                    c00592.I$1 = anidbEid5;
                                                    c00592.label = 4;
                                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                        return obj12;
                                                    }
                                                    provider4 = data3;
                                                    meteorUrl3 = meteorUrl2;
                                                    anijson5 = anijson3;
                                                    provider5 = data2;
                                                    data2 = provider5;
                                                    meteorUrl2 = meteorUrl3;
                                                    anijson3 = anijson5;
                                                    data3 = provider4;
                                                    key3 = key5;
                                                }
                                                Unit unit6 = Unit.INSTANCE;
                                                torrentioapiUrl11 = data3;
                                                kitsuId5 = kitsuId4;
                                                data4 = torrentioapiUrl5;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl4;
                                                aniResponse5 = aniResponse3;
                                            }
                                            num = (Integer) episode3.element;
                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                            c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                            c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00592.Z$0 = isCasting2;
                                            c00592.Z$1 = isAnime5;
                                            c00592.I$0 = i3;
                                            c00592.I$1 = anidbEid5;
                                            c00592.label = 6;
                                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                                return obj12;
                                            }
                                            return Boxing.boxBoolean(true);
                                        }
                                        key4 = key3;
                                        function1Arr = new Function1[8];
                                        torrentioapiUrl9 = torrentioapiUrl4;
                                        function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                        provider3 = data3;
                                        Function1<? super ExtractorLink, Unit> function117 = function8;
                                        episode4 = episode3;
                                        season4 = season3;
                                        id3 = torrentioapiUrl5;
                                        LoadDataTrakt dataObj14 = dataObj3;
                                        C00676 c006711 = new C00676(dataObj14, id3, season4, episode4, function117, null);
                                        function8 = function117;
                                        function1Arr[1] = c006711;
                                        aniResponse4 = aniResponse3;
                                        function1Arr[2] = new C00687(dataObj14, anidbEid5, function8, null);
                                        Integer kitsuId11 = kitsuId4;
                                        function1Arr[c] = new C00698(kitsuId11, season4, episode4, function7, null);
                                        Function1<ExtractorLink, Unit> function118 = function7;
                                        function7 = function118;
                                        function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function118, null);
                                        function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                        kitsuId5 = kitsuId11;
                                        function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                        isAnime9 = isAnime5;
                                        function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = season4;
                                        c00592.L$8 = episode4;
                                        c00592.L$9 = id3;
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime9;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 5;
                                        if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                            return obj12;
                                        }
                                        data4 = id3;
                                        isAnime5 = isAnime9;
                                        season3 = season4;
                                        episode3 = episode4;
                                        key3 = key4;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl9;
                                        torrentioapiUrl11 = provider3;
                                        aniResponse5 = aniResponse4;
                                        num = (Integer) episode3.element;
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime5;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    mappings2 = mappings;
                                } else {
                                    kitsuId2 = kitsuId;
                                    mappings2 = mappings;
                                }
                                if (i != 0) {
                                    numBoxInt = Boxing.boxInt(1);
                                } else {
                                    numBoxInt = (Integer) episode.element;
                                }
                                episode.element = numBoxInt;
                                anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                                if (anidbEid != null) {
                                    anidbEid2 = anidbEid.intValue();
                                } else {
                                    anidbEid2 = 0;
                                }
                                anijson3 = anijson2;
                                torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                                SharedPreferences sharedPreferences4 = this.sharedPref;
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = function5;
                                c00592.L$2 = function4;
                                c00592.L$3 = provider2;
                                c00592.L$4 = key2;
                                c00592.L$5 = dataObj;
                                c00592.L$6 = title;
                                c00592.L$7 = season;
                                c00592.L$8 = episode;
                                c00592.L$9 = id;
                                c00592.L$10 = year2;
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                                c00592.L$15 = kitsuId2;
                                c00592.L$16 = torrentioapiUrl;
                                c00592.Z$0 = isAnime;
                                c00592.Z$1 = isAnime3;
                                c00592.I$0 = i;
                                c00592.I$1 = anidbEid2;
                                c00592.label = 2;
                                anidbEid3 = anidbEid2;
                                torraStreamTrakt = this;
                                objBuildMeteorUrl = torraStreamTrakt.buildMeteorUrl(sharedPreferences4, TorraStream.Meteorfortheweebs, c00592);
                                if (objBuildMeteorUrl == obj8) {
                                    return obj8;
                                }
                                Ref.ObjectRef objectRef4 = episode;
                                obj10 = objBuildMeteorUrl;
                                dataObj2 = dataObj;
                                episode2 = objectRef4;
                                obj11 = obj8;
                                isCasting2 = isAnime;
                                aniJson2 = aniJson;
                                i2 = i;
                                function6 = function4;
                                title2 = title;
                                aniResponse2 = aniResponse;
                                isAnime4 = isAnime3;
                                mappings3 = mappings2;
                                torrentioapiUrl2 = torrentioapiUrl;
                                season2 = season;
                                kitsuId3 = kitsuId2;
                                id2 = id;
                                anidbEid4 = anidbEid3;
                                meteorUrl = (String) obj10;
                                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStreamTrakt.sharedPref, function6);
                                str = key2;
                                if (str != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    str2 = str5;
                                    if (!Intrinsics.areEqual(provider2, str2)) {
                                        str5 = str2;
                                        anidbEid6 = anidbEid4;
                                        torrentioapiUrl6 = torrentioapiUrl2;
                                        Function1 filtered4 = new C00643(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                        Function1[] function1Arr6 = {new C00632(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered4};
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = function6;
                                        c00592.L$3 = provider2;
                                        c00592.L$4 = key2;
                                        c00592.L$5 = dataObj2;
                                        c00592.L$6 = title2;
                                        c00592.L$7 = season2;
                                        c00592.L$8 = episode2;
                                        c00592.L$9 = id2;
                                        c00592.L$10 = year2;
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = kitsuId3;
                                        c00592.L$16 = torrentioapiUrl6;
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                        c00592.L$18 = function1FilteredCallback;
                                        c00592.Z$0 = isCasting2;
                                        isAnime6 = isAnime4;
                                        c00592.Z$1 = isAnime6;
                                        function9 = function6;
                                        i4 = i2;
                                        c00592.I$0 = i4;
                                        c00592.I$1 = anidbEid6;
                                        dataObj4 = dataObj2;
                                        c00592.label = 3;
                                        c = 3;
                                        objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr6, c00592);
                                        obj12 = obj11;
                                        if (objRunAllAsync == obj12) {
                                            return obj12;
                                        }
                                        aniResponse3 = aniResponse2;
                                        torrentioapiUrl7 = torrentioapiUrl6;
                                        torrentioapiUrl8 = title2;
                                        anidbEid5 = anidbEid6;
                                        data3 = provider2;
                                        function10 = function1FilteredCallback;
                                        isAnime7 = isAnime6;
                                        isAnime8 = isCasting2;
                                        i5 = i4;
                                        meteorUrl2 = meteorUrl;
                                        year3 = year2;
                                        kitsuId4 = kitsuId3;
                                        function7 = function10;
                                        i3 = i5;
                                        isAnime5 = isAnime7;
                                        isCasting2 = isAnime8;
                                        torrentioapiUrl4 = torrentioapiUrl7;
                                        title3 = torrentioapiUrl8;
                                        key3 = key2;
                                        torrentioapiUrl5 = id2;
                                        season3 = season2;
                                        episode3 = episode2;
                                        function8 = function9;
                                        dataObj3 = dataObj4;
                                        str3 = data3;
                                        if (str3 != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            str4 = key3;
                                            if (str4 != null) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                if (Intrinsics.areEqual(data3, str5)) {
                                                    Function1<ExtractorLink, Unit> function119 = function7;
                                                    key5 = key3;
                                                    function7 = function119;
                                                    function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function119, null)};
                                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00592.L$1 = function5;
                                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00592.L$7 = season3;
                                                    c00592.L$8 = episode3;
                                                    c00592.L$9 = torrentioapiUrl5;
                                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00592.Z$0 = isCasting2;
                                                    c00592.Z$1 = isAnime5;
                                                    c00592.I$0 = i3;
                                                    c00592.I$1 = anidbEid5;
                                                    c00592.label = 4;
                                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                        return obj12;
                                                    }
                                                    provider4 = data3;
                                                    meteorUrl3 = meteorUrl2;
                                                    anijson5 = anijson3;
                                                    provider5 = data2;
                                                    data2 = provider5;
                                                    meteorUrl2 = meteorUrl3;
                                                    anijson3 = anijson5;
                                                    data3 = provider4;
                                                    key3 = key5;
                                                }
                                                Unit unit7 = Unit.INSTANCE;
                                                torrentioapiUrl11 = data3;
                                                kitsuId5 = kitsuId4;
                                                data4 = torrentioapiUrl5;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl4;
                                                aniResponse5 = aniResponse3;
                                            }
                                            num = (Integer) episode3.element;
                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                            c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                            c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00592.Z$0 = isCasting2;
                                            c00592.Z$1 = isAnime5;
                                            c00592.I$0 = i3;
                                            c00592.I$1 = anidbEid5;
                                            c00592.label = 6;
                                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                                return obj12;
                                            }
                                            return Boxing.boxBoolean(true);
                                        }
                                        key4 = key3;
                                        function1Arr = new Function1[8];
                                        torrentioapiUrl9 = torrentioapiUrl4;
                                        function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                        provider3 = data3;
                                        Function1<? super ExtractorLink, Unit> function1110 = function8;
                                        episode4 = episode3;
                                        season4 = season3;
                                        id3 = torrentioapiUrl5;
                                        LoadDataTrakt dataObj15 = dataObj3;
                                        C00676 c006712 = new C00676(dataObj15, id3, season4, episode4, function1110, null);
                                        function8 = function1110;
                                        function1Arr[1] = c006712;
                                        aniResponse4 = aniResponse3;
                                        function1Arr[2] = new C00687(dataObj15, anidbEid5, function8, null);
                                        Integer kitsuId12 = kitsuId4;
                                        function1Arr[c] = new C00698(kitsuId12, season4, episode4, function7, null);
                                        Function1<ExtractorLink, Unit> function1111 = function7;
                                        function7 = function1111;
                                        function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function1111, null);
                                        function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                        kitsuId5 = kitsuId12;
                                        function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                        isAnime9 = isAnime5;
                                        function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = season4;
                                        c00592.L$8 = episode4;
                                        c00592.L$9 = id3;
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime9;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 5;
                                        if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                            return obj12;
                                        }
                                        data4 = id3;
                                        isAnime5 = isAnime9;
                                        season3 = season4;
                                        episode3 = episode4;
                                        key3 = key4;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl9;
                                        torrentioapiUrl11 = provider3;
                                        aniResponse5 = aniResponse4;
                                        num = (Integer) episode3.element;
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime5;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                    str5 = str2;
                                } else {
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                }
                                obj12 = obj11;
                                int i9 = i2;
                                c = 3;
                                LoadDataTrakt dataObj16 = dataObj2;
                                aniResponse3 = aniResponse2;
                                title3 = title2;
                                year3 = year2;
                                kitsuId4 = kitsuId3;
                                function7 = function1FilteredCallback;
                                i3 = i9;
                                torrentioapiUrl4 = torrentioapiUrl3;
                                meteorUrl2 = meteorUrl;
                                anidbEid5 = anidbEid4;
                                data3 = provider2;
                                isAnime5 = isAnime4;
                                key3 = key2;
                                torrentioapiUrl5 = id2;
                                episode3 = episode2;
                                dataObj3 = dataObj16;
                                season3 = season2;
                                function8 = function6;
                                str3 = data3;
                                if (str3 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    str4 = key3;
                                    if (str4 != null) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        if (Intrinsics.areEqual(data3, str5)) {
                                            Function1<ExtractorLink, Unit> function1112 = function7;
                                            key5 = key3;
                                            function7 = function1112;
                                            function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function1112, null)};
                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00592.L$1 = function5;
                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00592.L$7 = season3;
                                            c00592.L$8 = episode3;
                                            c00592.L$9 = torrentioapiUrl5;
                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00592.Z$0 = isCasting2;
                                            c00592.Z$1 = isAnime5;
                                            c00592.I$0 = i3;
                                            c00592.I$1 = anidbEid5;
                                            c00592.label = 4;
                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                return obj12;
                                            }
                                            provider4 = data3;
                                            meteorUrl3 = meteorUrl2;
                                            anijson5 = anijson3;
                                            provider5 = data2;
                                            data2 = provider5;
                                            meteorUrl2 = meteorUrl3;
                                            anijson3 = anijson5;
                                            data3 = provider4;
                                            key3 = key5;
                                        }
                                        Unit unit8 = Unit.INSTANCE;
                                        torrentioapiUrl11 = data3;
                                        kitsuId5 = kitsuId4;
                                        data4 = torrentioapiUrl5;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl4;
                                        aniResponse5 = aniResponse3;
                                    }
                                    num = (Integer) episode3.element;
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00592.Z$0 = isCasting2;
                                    c00592.Z$1 = isAnime5;
                                    c00592.I$0 = i3;
                                    c00592.I$1 = anidbEid5;
                                    c00592.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                key4 = key3;
                                function1Arr = new Function1[8];
                                torrentioapiUrl9 = torrentioapiUrl4;
                                function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                provider3 = data3;
                                Function1<? super ExtractorLink, Unit> function1113 = function8;
                                episode4 = episode3;
                                season4 = season3;
                                id3 = torrentioapiUrl5;
                                LoadDataTrakt dataObj17 = dataObj3;
                                C00676 c006713 = new C00676(dataObj17, id3, season4, episode4, function1113, null);
                                function8 = function1113;
                                function1Arr[1] = c006713;
                                aniResponse4 = aniResponse3;
                                function1Arr[2] = new C00687(dataObj17, anidbEid5, function8, null);
                                Integer kitsuId13 = kitsuId4;
                                function1Arr[c] = new C00698(kitsuId13, season4, episode4, function7, null);
                                Function1<ExtractorLink, Unit> function1114 = function7;
                                function7 = function1114;
                                function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function1114, null);
                                function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                kitsuId5 = kitsuId13;
                                function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                isAnime9 = isAnime5;
                                function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = function5;
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = season4;
                                c00592.L$8 = episode4;
                                c00592.L$9 = id3;
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime9;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 5;
                                if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                    return obj12;
                                }
                                data4 = id3;
                                isAnime5 = isAnime9;
                                season3 = season4;
                                episode3 = episode4;
                                key3 = key4;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl9;
                                torrentioapiUrl11 = provider3;
                                aniResponse5 = aniResponse4;
                                num = (Integer) episode3.element;
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime5;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            str5 = "AIO Streams";
                            key = key;
                            obj3 = coroutine_suspended;
                            isAnime = isCasting;
                            function3 = function1;
                            function4 = function2;
                            dataObj = dataObj5;
                            isAnime2 = isAnime10;
                            title = title4;
                            season = season5;
                            id = id4;
                            year = year4;
                            provider = provider6;
                            data2 = data;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        obj3 = coroutine_suspended;
                        isAnime = isCasting;
                        function3 = function1;
                        function4 = function2;
                        dataObj = dataObj5;
                        isAnime2 = isAnime10;
                        title = title4;
                        season = season5;
                        id = id4;
                        year = year4;
                        provider = provider6;
                        data2 = data;
                        Result.Companion companion11 = Result.Companion;
                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                        obj6 = obj5;
                        year2 = year;
                        provider2 = provider;
                        function5 = function3;
                        key2 = key;
                        if (Result.isFailure-impl(obj6)) {
                            obj7 = null;
                        } else {
                            obj7 = obj6;
                        }
                        aniResponse = (NiceResponse) obj7;
                        if (aniResponse != null) {
                            text = aniResponse.getText();
                        } else {
                            text = null;
                        }
                        obj8 = obj3;
                        if (text == null) {
                            text = "";
                        }
                        anijson = text;
                        Result.Companion companion12 = Result.Companion;
                        TorraStreamTrakt torraStreamTrakt4 = this;
                        isAnime3 = isAnime2;
                        anijson2 = anijson;
                        obj9 = Result.constructor-impl(new JSONObject(anijson2));
                        if (Result.isFailure-impl(obj9)) {
                            obj9 = null;
                        }
                        aniJson = (JSONObject) obj9;
                        if (aniJson != null) {
                            mappings = aniJson.optJSONObject("mappings");
                        } else {
                            mappings = null;
                        }
                        if (mappings != null) {
                            kitsuId = Boxing.boxInt(mappings.optInt("kitsu_id"));
                        } else {
                            kitsuId = null;
                        }
                        if (mappings != null) {
                            kitsuId2 = kitsuId;
                            strOptString = mappings.optString("type", "");
                            if (strOptString != null) {
                                mappings2 = mappings;
                                if (StringsKt.contains(strOptString, "MOVIE", true)) {
                                }
                                if (i != 0) {
                                    numBoxInt = Boxing.boxInt(1);
                                } else {
                                    numBoxInt = (Integer) episode.element;
                                }
                                episode.element = numBoxInt;
                                anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                                if (anidbEid != null) {
                                    anidbEid2 = anidbEid.intValue();
                                } else {
                                    anidbEid2 = 0;
                                }
                                anijson3 = anijson2;
                                torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                                SharedPreferences sharedPreferences5 = this.sharedPref;
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = function5;
                                c00592.L$2 = function4;
                                c00592.L$3 = provider2;
                                c00592.L$4 = key2;
                                c00592.L$5 = dataObj;
                                c00592.L$6 = title;
                                c00592.L$7 = season;
                                c00592.L$8 = episode;
                                c00592.L$9 = id;
                                c00592.L$10 = year2;
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                                c00592.L$15 = kitsuId2;
                                c00592.L$16 = torrentioapiUrl;
                                c00592.Z$0 = isAnime;
                                c00592.Z$1 = isAnime3;
                                c00592.I$0 = i;
                                c00592.I$1 = anidbEid2;
                                c00592.label = 2;
                                anidbEid3 = anidbEid2;
                                torraStreamTrakt = this;
                                objBuildMeteorUrl = torraStreamTrakt.buildMeteorUrl(sharedPreferences5, TorraStream.Meteorfortheweebs, c00592);
                                if (objBuildMeteorUrl == obj8) {
                                    return obj8;
                                }
                                Ref.ObjectRef objectRef5 = episode;
                                obj10 = objBuildMeteorUrl;
                                dataObj2 = dataObj;
                                episode2 = objectRef5;
                                obj11 = obj8;
                                isCasting2 = isAnime;
                                aniJson2 = aniJson;
                                i2 = i;
                                function6 = function4;
                                title2 = title;
                                aniResponse2 = aniResponse;
                                isAnime4 = isAnime3;
                                mappings3 = mappings2;
                                torrentioapiUrl2 = torrentioapiUrl;
                                season2 = season;
                                kitsuId3 = kitsuId2;
                                id2 = id;
                                anidbEid4 = anidbEid3;
                                meteorUrl = (String) obj10;
                                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStreamTrakt.sharedPref, function6);
                                str = key2;
                                if (str != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    str2 = str5;
                                    if (!Intrinsics.areEqual(provider2, str2)) {
                                        str5 = str2;
                                        anidbEid6 = anidbEid4;
                                        torrentioapiUrl6 = torrentioapiUrl2;
                                        Function1 filtered5 = new C00643(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                        Function1[] function1Arr7 = {new C00632(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered5};
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = function6;
                                        c00592.L$3 = provider2;
                                        c00592.L$4 = key2;
                                        c00592.L$5 = dataObj2;
                                        c00592.L$6 = title2;
                                        c00592.L$7 = season2;
                                        c00592.L$8 = episode2;
                                        c00592.L$9 = id2;
                                        c00592.L$10 = year2;
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = kitsuId3;
                                        c00592.L$16 = torrentioapiUrl6;
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                        c00592.L$18 = function1FilteredCallback;
                                        c00592.Z$0 = isCasting2;
                                        isAnime6 = isAnime4;
                                        c00592.Z$1 = isAnime6;
                                        function9 = function6;
                                        i4 = i2;
                                        c00592.I$0 = i4;
                                        c00592.I$1 = anidbEid6;
                                        dataObj4 = dataObj2;
                                        c00592.label = 3;
                                        c = 3;
                                        objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr7, c00592);
                                        obj12 = obj11;
                                        if (objRunAllAsync == obj12) {
                                            return obj12;
                                        }
                                        aniResponse3 = aniResponse2;
                                        torrentioapiUrl7 = torrentioapiUrl6;
                                        torrentioapiUrl8 = title2;
                                        anidbEid5 = anidbEid6;
                                        data3 = provider2;
                                        function10 = function1FilteredCallback;
                                        isAnime7 = isAnime6;
                                        isAnime8 = isCasting2;
                                        i5 = i4;
                                        meteorUrl2 = meteorUrl;
                                        year3 = year2;
                                        kitsuId4 = kitsuId3;
                                        function7 = function10;
                                        i3 = i5;
                                        isAnime5 = isAnime7;
                                        isCasting2 = isAnime8;
                                        torrentioapiUrl4 = torrentioapiUrl7;
                                        title3 = torrentioapiUrl8;
                                        key3 = key2;
                                        torrentioapiUrl5 = id2;
                                        season3 = season2;
                                        episode3 = episode2;
                                        function8 = function9;
                                        dataObj3 = dataObj4;
                                        str3 = data3;
                                        if (str3 != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            str4 = key3;
                                            if (str4 != null) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                if (Intrinsics.areEqual(data3, str5)) {
                                                    Function1<ExtractorLink, Unit> function1115 = function7;
                                                    key5 = key3;
                                                    function7 = function1115;
                                                    function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function1115, null)};
                                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00592.L$1 = function5;
                                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00592.L$7 = season3;
                                                    c00592.L$8 = episode3;
                                                    c00592.L$9 = torrentioapiUrl5;
                                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00592.Z$0 = isCasting2;
                                                    c00592.Z$1 = isAnime5;
                                                    c00592.I$0 = i3;
                                                    c00592.I$1 = anidbEid5;
                                                    c00592.label = 4;
                                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                        return obj12;
                                                    }
                                                    provider4 = data3;
                                                    meteorUrl3 = meteorUrl2;
                                                    anijson5 = anijson3;
                                                    provider5 = data2;
                                                    data2 = provider5;
                                                    meteorUrl2 = meteorUrl3;
                                                    anijson3 = anijson5;
                                                    data3 = provider4;
                                                    key3 = key5;
                                                }
                                                Unit unit9 = Unit.INSTANCE;
                                                torrentioapiUrl11 = data3;
                                                kitsuId5 = kitsuId4;
                                                data4 = torrentioapiUrl5;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl4;
                                                aniResponse5 = aniResponse3;
                                            }
                                            num = (Integer) episode3.element;
                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                            c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                            c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00592.Z$0 = isCasting2;
                                            c00592.Z$1 = isAnime5;
                                            c00592.I$0 = i3;
                                            c00592.I$1 = anidbEid5;
                                            c00592.label = 6;
                                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                                return obj12;
                                            }
                                            return Boxing.boxBoolean(true);
                                        }
                                        key4 = key3;
                                        function1Arr = new Function1[8];
                                        torrentioapiUrl9 = torrentioapiUrl4;
                                        function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                        provider3 = data3;
                                        Function1<? super ExtractorLink, Unit> function1116 = function8;
                                        episode4 = episode3;
                                        season4 = season3;
                                        id3 = torrentioapiUrl5;
                                        LoadDataTrakt dataObj18 = dataObj3;
                                        C00676 c006714 = new C00676(dataObj18, id3, season4, episode4, function1116, null);
                                        function8 = function1116;
                                        function1Arr[1] = c006714;
                                        aniResponse4 = aniResponse3;
                                        function1Arr[2] = new C00687(dataObj18, anidbEid5, function8, null);
                                        Integer kitsuId14 = kitsuId4;
                                        function1Arr[c] = new C00698(kitsuId14, season4, episode4, function7, null);
                                        Function1<ExtractorLink, Unit> function1117 = function7;
                                        function7 = function1117;
                                        function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function1117, null);
                                        function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                        kitsuId5 = kitsuId14;
                                        function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                        isAnime9 = isAnime5;
                                        function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = season4;
                                        c00592.L$8 = episode4;
                                        c00592.L$9 = id3;
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime9;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 5;
                                        if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                            return obj12;
                                        }
                                        data4 = id3;
                                        isAnime5 = isAnime9;
                                        season3 = season4;
                                        episode3 = episode4;
                                        key3 = key4;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl9;
                                        torrentioapiUrl11 = provider3;
                                        aniResponse5 = aniResponse4;
                                        num = (Integer) episode3.element;
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime5;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                    str5 = str2;
                                } else {
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                }
                                obj12 = obj11;
                                int i10 = i2;
                                c = 3;
                                LoadDataTrakt dataObj19 = dataObj2;
                                aniResponse3 = aniResponse2;
                                title3 = title2;
                                year3 = year2;
                                kitsuId4 = kitsuId3;
                                function7 = function1FilteredCallback;
                                i3 = i10;
                                torrentioapiUrl4 = torrentioapiUrl3;
                                meteorUrl2 = meteorUrl;
                                anidbEid5 = anidbEid4;
                                data3 = provider2;
                                isAnime5 = isAnime4;
                                key3 = key2;
                                torrentioapiUrl5 = id2;
                                episode3 = episode2;
                                dataObj3 = dataObj19;
                                season3 = season2;
                                function8 = function6;
                                str3 = data3;
                                if (str3 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    str4 = key3;
                                    if (str4 != null) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        if (Intrinsics.areEqual(data3, str5)) {
                                            Function1<ExtractorLink, Unit> function1118 = function7;
                                            key5 = key3;
                                            function7 = function1118;
                                            function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function1118, null)};
                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00592.L$1 = function5;
                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00592.L$7 = season3;
                                            c00592.L$8 = episode3;
                                            c00592.L$9 = torrentioapiUrl5;
                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00592.Z$0 = isCasting2;
                                            c00592.Z$1 = isAnime5;
                                            c00592.I$0 = i3;
                                            c00592.I$1 = anidbEid5;
                                            c00592.label = 4;
                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                return obj12;
                                            }
                                            provider4 = data3;
                                            meteorUrl3 = meteorUrl2;
                                            anijson5 = anijson3;
                                            provider5 = data2;
                                            data2 = provider5;
                                            meteorUrl2 = meteorUrl3;
                                            anijson3 = anijson5;
                                            data3 = provider4;
                                            key3 = key5;
                                        }
                                        Unit unit10 = Unit.INSTANCE;
                                        torrentioapiUrl11 = data3;
                                        kitsuId5 = kitsuId4;
                                        data4 = torrentioapiUrl5;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl4;
                                        aniResponse5 = aniResponse3;
                                    }
                                    num = (Integer) episode3.element;
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00592.Z$0 = isCasting2;
                                    c00592.Z$1 = isAnime5;
                                    c00592.I$0 = i3;
                                    c00592.I$1 = anidbEid5;
                                    c00592.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                key4 = key3;
                                function1Arr = new Function1[8];
                                torrentioapiUrl9 = torrentioapiUrl4;
                                function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                provider3 = data3;
                                Function1<? super ExtractorLink, Unit> function1119 = function8;
                                episode4 = episode3;
                                season4 = season3;
                                id3 = torrentioapiUrl5;
                                LoadDataTrakt dataObj110 = dataObj3;
                                C00676 c006715 = new C00676(dataObj110, id3, season4, episode4, function1119, null);
                                function8 = function1119;
                                function1Arr[1] = c006715;
                                aniResponse4 = aniResponse3;
                                function1Arr[2] = new C00687(dataObj110, anidbEid5, function8, null);
                                Integer kitsuId15 = kitsuId4;
                                function1Arr[c] = new C00698(kitsuId15, season4, episode4, function7, null);
                                Function1<ExtractorLink, Unit> function11110 = function7;
                                function7 = function11110;
                                function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function11110, null);
                                function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                kitsuId5 = kitsuId15;
                                function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                isAnime9 = isAnime5;
                                function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = function5;
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = season4;
                                c00592.L$8 = episode4;
                                c00592.L$9 = id3;
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime9;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 5;
                                if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                    return obj12;
                                }
                                data4 = id3;
                                isAnime5 = isAnime9;
                                season3 = season4;
                                episode3 = episode4;
                                key3 = key4;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl9;
                                torrentioapiUrl11 = provider3;
                                aniResponse5 = aniResponse4;
                                num = (Integer) episode3.element;
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime5;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            mappings2 = mappings;
                        } else {
                            kitsuId2 = kitsuId;
                            mappings2 = mappings;
                        }
                        if (i != 0) {
                            numBoxInt = Boxing.boxInt(1);
                        } else {
                            numBoxInt = (Integer) episode.element;
                        }
                        episode.element = numBoxInt;
                        anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                        if (anidbEid != null) {
                            anidbEid2 = anidbEid.intValue();
                        } else {
                            anidbEid2 = 0;
                        }
                        anijson3 = anijson2;
                        torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                        SharedPreferences sharedPreferences6 = this.sharedPref;
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = function5;
                        c00592.L$2 = function4;
                        c00592.L$3 = provider2;
                        c00592.L$4 = key2;
                        c00592.L$5 = dataObj;
                        c00592.L$6 = title;
                        c00592.L$7 = season;
                        c00592.L$8 = episode;
                        c00592.L$9 = id;
                        c00592.L$10 = year2;
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                        c00592.L$15 = kitsuId2;
                        c00592.L$16 = torrentioapiUrl;
                        c00592.Z$0 = isAnime;
                        c00592.Z$1 = isAnime3;
                        c00592.I$0 = i;
                        c00592.I$1 = anidbEid2;
                        c00592.label = 2;
                        anidbEid3 = anidbEid2;
                        torraStreamTrakt = this;
                        objBuildMeteorUrl = torraStreamTrakt.buildMeteorUrl(sharedPreferences6, TorraStream.Meteorfortheweebs, c00592);
                        if (objBuildMeteorUrl == obj8) {
                            return obj8;
                        }
                        Ref.ObjectRef objectRef6 = episode;
                        obj10 = objBuildMeteorUrl;
                        dataObj2 = dataObj;
                        episode2 = objectRef6;
                        obj11 = obj8;
                        isCasting2 = isAnime;
                        aniJson2 = aniJson;
                        i2 = i;
                        function6 = function4;
                        title2 = title;
                        aniResponse2 = aniResponse;
                        isAnime4 = isAnime3;
                        mappings3 = mappings2;
                        torrentioapiUrl2 = torrentioapiUrl;
                        season2 = season;
                        kitsuId3 = kitsuId2;
                        id2 = id;
                        anidbEid4 = anidbEid3;
                        meteorUrl = (String) obj10;
                        function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStreamTrakt.sharedPref, function6);
                        str = key2;
                        if (str != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            str2 = str5;
                            if (!Intrinsics.areEqual(provider2, str2)) {
                                str5 = str2;
                                anidbEid6 = anidbEid4;
                                torrentioapiUrl6 = torrentioapiUrl2;
                                Function1 filtered6 = new C00643(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                Function1[] function1Arr8 = {new C00632(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered6};
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = function5;
                                c00592.L$2 = function6;
                                c00592.L$3 = provider2;
                                c00592.L$4 = key2;
                                c00592.L$5 = dataObj2;
                                c00592.L$6 = title2;
                                c00592.L$7 = season2;
                                c00592.L$8 = episode2;
                                c00592.L$9 = id2;
                                c00592.L$10 = year2;
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = kitsuId3;
                                c00592.L$16 = torrentioapiUrl6;
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                c00592.L$18 = function1FilteredCallback;
                                c00592.Z$0 = isCasting2;
                                isAnime6 = isAnime4;
                                c00592.Z$1 = isAnime6;
                                function9 = function6;
                                i4 = i2;
                                c00592.I$0 = i4;
                                c00592.I$1 = anidbEid6;
                                dataObj4 = dataObj2;
                                c00592.label = 3;
                                c = 3;
                                objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr8, c00592);
                                obj12 = obj11;
                                if (objRunAllAsync == obj12) {
                                    return obj12;
                                }
                                aniResponse3 = aniResponse2;
                                torrentioapiUrl7 = torrentioapiUrl6;
                                torrentioapiUrl8 = title2;
                                anidbEid5 = anidbEid6;
                                data3 = provider2;
                                function10 = function1FilteredCallback;
                                isAnime7 = isAnime6;
                                isAnime8 = isCasting2;
                                i5 = i4;
                                meteorUrl2 = meteorUrl;
                                year3 = year2;
                                kitsuId4 = kitsuId3;
                                function7 = function10;
                                i3 = i5;
                                isAnime5 = isAnime7;
                                isCasting2 = isAnime8;
                                torrentioapiUrl4 = torrentioapiUrl7;
                                title3 = torrentioapiUrl8;
                                key3 = key2;
                                torrentioapiUrl5 = id2;
                                season3 = season2;
                                episode3 = episode2;
                                function8 = function9;
                                dataObj3 = dataObj4;
                                str3 = data3;
                                if (str3 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    str4 = key3;
                                    if (str4 != null) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        if (Intrinsics.areEqual(data3, str5)) {
                                            Function1<ExtractorLink, Unit> function11111 = function7;
                                            key5 = key3;
                                            function7 = function11111;
                                            function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function11111, null)};
                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00592.L$1 = function5;
                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00592.L$7 = season3;
                                            c00592.L$8 = episode3;
                                            c00592.L$9 = torrentioapiUrl5;
                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00592.Z$0 = isCasting2;
                                            c00592.Z$1 = isAnime5;
                                            c00592.I$0 = i3;
                                            c00592.I$1 = anidbEid5;
                                            c00592.label = 4;
                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                return obj12;
                                            }
                                            provider4 = data3;
                                            meteorUrl3 = meteorUrl2;
                                            anijson5 = anijson3;
                                            provider5 = data2;
                                            data2 = provider5;
                                            meteorUrl2 = meteorUrl3;
                                            anijson3 = anijson5;
                                            data3 = provider4;
                                            key3 = key5;
                                        }
                                        Unit unit11 = Unit.INSTANCE;
                                        torrentioapiUrl11 = data3;
                                        kitsuId5 = kitsuId4;
                                        data4 = torrentioapiUrl5;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl4;
                                        aniResponse5 = aniResponse3;
                                    }
                                    num = (Integer) episode3.element;
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00592.Z$0 = isCasting2;
                                    c00592.Z$1 = isAnime5;
                                    c00592.I$0 = i3;
                                    c00592.I$1 = anidbEid5;
                                    c00592.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                key4 = key3;
                                function1Arr = new Function1[8];
                                torrentioapiUrl9 = torrentioapiUrl4;
                                function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                provider3 = data3;
                                Function1<? super ExtractorLink, Unit> function11112 = function8;
                                episode4 = episode3;
                                season4 = season3;
                                id3 = torrentioapiUrl5;
                                LoadDataTrakt dataObj111 = dataObj3;
                                C00676 c006716 = new C00676(dataObj111, id3, season4, episode4, function11112, null);
                                function8 = function11112;
                                function1Arr[1] = c006716;
                                aniResponse4 = aniResponse3;
                                function1Arr[2] = new C00687(dataObj111, anidbEid5, function8, null);
                                Integer kitsuId16 = kitsuId4;
                                function1Arr[c] = new C00698(kitsuId16, season4, episode4, function7, null);
                                Function1<ExtractorLink, Unit> function11113 = function7;
                                function7 = function11113;
                                function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function11113, null);
                                function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                kitsuId5 = kitsuId16;
                                function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                isAnime9 = isAnime5;
                                function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = function5;
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = season4;
                                c00592.L$8 = episode4;
                                c00592.L$9 = id3;
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime9;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 5;
                                if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                    return obj12;
                                }
                                data4 = id3;
                                isAnime5 = isAnime9;
                                season3 = season4;
                                episode3 = episode4;
                                key3 = key4;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl9;
                                torrentioapiUrl11 = provider3;
                                aniResponse5 = aniResponse4;
                                num = (Integer) episode3.element;
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime5;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            torrentioapiUrl3 = torrentioapiUrl2;
                            str5 = str2;
                        } else {
                            torrentioapiUrl3 = torrentioapiUrl2;
                        }
                        obj12 = obj11;
                        int i11 = i2;
                        c = 3;
                        LoadDataTrakt dataObj112 = dataObj2;
                        aniResponse3 = aniResponse2;
                        title3 = title2;
                        year3 = year2;
                        kitsuId4 = kitsuId3;
                        function7 = function1FilteredCallback;
                        i3 = i11;
                        torrentioapiUrl4 = torrentioapiUrl3;
                        meteorUrl2 = meteorUrl;
                        anidbEid5 = anidbEid4;
                        data3 = provider2;
                        isAnime5 = isAnime4;
                        key3 = key2;
                        torrentioapiUrl5 = id2;
                        episode3 = episode2;
                        dataObj3 = dataObj112;
                        season3 = season2;
                        function8 = function6;
                        str3 = data3;
                        if (str3 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            str4 = key3;
                            if (str4 != null) {
                                z3 = true;
                            } else {
                                z3 = true;
                            }
                            if (!z3) {
                                if (Intrinsics.areEqual(data3, str5)) {
                                    Function1<ExtractorLink, Unit> function11114 = function7;
                                    key5 = key3;
                                    function7 = function11114;
                                    function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function11114, null)};
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = function5;
                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00592.L$7 = season3;
                                    c00592.L$8 = episode3;
                                    c00592.L$9 = torrentioapiUrl5;
                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00592.Z$0 = isCasting2;
                                    c00592.Z$1 = isAnime5;
                                    c00592.I$0 = i3;
                                    c00592.I$1 = anidbEid5;
                                    c00592.label = 4;
                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                        return obj12;
                                    }
                                    provider4 = data3;
                                    meteorUrl3 = meteorUrl2;
                                    anijson5 = anijson3;
                                    provider5 = data2;
                                    data2 = provider5;
                                    meteorUrl2 = meteorUrl3;
                                    anijson3 = anijson5;
                                    data3 = provider4;
                                    key3 = key5;
                                }
                                Unit unit12 = Unit.INSTANCE;
                                torrentioapiUrl11 = data3;
                                kitsuId5 = kitsuId4;
                                data4 = torrentioapiUrl5;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl4;
                                aniResponse5 = aniResponse3;
                            }
                            num = (Integer) episode3.element;
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00592.Z$0 = isCasting2;
                            c00592.Z$1 = isAnime5;
                            c00592.I$0 = i3;
                            c00592.I$1 = anidbEid5;
                            c00592.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        key4 = key3;
                        function1Arr = new Function1[8];
                        torrentioapiUrl9 = torrentioapiUrl4;
                        function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                        provider3 = data3;
                        Function1<? super ExtractorLink, Unit> function11115 = function8;
                        episode4 = episode3;
                        season4 = season3;
                        id3 = torrentioapiUrl5;
                        LoadDataTrakt dataObj113 = dataObj3;
                        C00676 c006717 = new C00676(dataObj113, id3, season4, episode4, function11115, null);
                        function8 = function11115;
                        function1Arr[1] = c006717;
                        aniResponse4 = aniResponse3;
                        function1Arr[2] = new C00687(dataObj113, anidbEid5, function8, null);
                        Integer kitsuId17 = kitsuId4;
                        function1Arr[c] = new C00698(kitsuId17, season4, episode4, function7, null);
                        Function1<ExtractorLink, Unit> function11116 = function7;
                        function7 = function11116;
                        function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function11116, null);
                        function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                        kitsuId5 = kitsuId17;
                        function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                        isAnime9 = isAnime5;
                        function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = function5;
                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00592.L$7 = season4;
                        c00592.L$8 = episode4;
                        c00592.L$9 = id3;
                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00592.Z$0 = isCasting2;
                        c00592.Z$1 = isAnime9;
                        c00592.I$0 = i3;
                        c00592.I$1 = anidbEid5;
                        c00592.label = 5;
                        if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                            return obj12;
                        }
                        data4 = id3;
                        isAnime5 = isAnime9;
                        season3 = season4;
                        episode3 = episode4;
                        key3 = key4;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl9;
                        torrentioapiUrl11 = provider3;
                        aniResponse5 = aniResponse4;
                        num = (Integer) episode3.element;
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                        c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                        c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00592.Z$0 = isCasting2;
                        c00592.Z$1 = isAnime5;
                        c00592.I$0 = i3;
                        c00592.I$1 = anidbEid5;
                        c00592.label = 6;
                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                            return obj12;
                        }
                        return Boxing.boxBoolean(true);
                    }
                } catch (Throwable th11) {
                    th = th11;
                    obj3 = coroutine_suspended;
                }
                break;
            case 1:
                isAnime2 = c00592.Z$1;
                isAnime = c00592.Z$0;
                year = (Integer) c00592.L$10;
                id = (String) c00592.L$9;
                episode = (Ref.ObjectRef) c00592.L$8;
                season = (Integer) c00592.L$7;
                title = (String) c00592.L$6;
                dataObj = (LoadDataTrakt) c00592.L$5;
                String key6 = (String) c00592.L$4;
                provider = (String) c00592.L$3;
                Function1<? super ExtractorLink, Unit> function20 = (Function1) c00592.L$2;
                function3 = (Function1) c00592.L$1;
                data2 = (String) c00592.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj3 = coroutine_suspended;
                    str5 = "AIO Streams";
                    key = key6;
                    obj4 = $result;
                    function4 = function20;
                    obj5 = Result.constructor-impl((NiceResponse) obj4);
                    break;
                } catch (Throwable th12) {
                    th = th12;
                    obj3 = coroutine_suspended;
                    str5 = "AIO Streams";
                    key = key6;
                    function4 = function20;
                    Result.Companion companion13 = Result.Companion;
                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                    obj6 = obj5;
                    year2 = year;
                    provider2 = provider;
                    function5 = function3;
                    key2 = key;
                    if (Result.isFailure-impl(obj6)) {
                        obj7 = null;
                    } else {
                        obj7 = obj6;
                    }
                    aniResponse = (NiceResponse) obj7;
                    if (aniResponse != null) {
                        text = aniResponse.getText();
                    } else {
                        text = null;
                    }
                    obj8 = obj3;
                    if (text == null) {
                        text = "";
                    }
                    anijson = text;
                    Result.Companion companion14 = Result.Companion;
                    TorraStreamTrakt torraStreamTrakt5 = this;
                    isAnime3 = isAnime2;
                    anijson2 = anijson;
                    obj9 = Result.constructor-impl(new JSONObject(anijson2));
                    if (Result.isFailure-impl(obj9)) {
                        obj9 = null;
                    }
                    aniJson = (JSONObject) obj9;
                    if (aniJson != null) {
                        mappings = aniJson.optJSONObject("mappings");
                    } else {
                        mappings = null;
                    }
                    if (mappings != null) {
                        kitsuId = Boxing.boxInt(mappings.optInt("kitsu_id"));
                    } else {
                        kitsuId = null;
                    }
                    if (mappings != null) {
                        kitsuId2 = kitsuId;
                        strOptString = mappings.optString("type", "");
                        if (strOptString != null) {
                            mappings2 = mappings;
                            if (StringsKt.contains(strOptString, "MOVIE", true)) {
                            }
                            if (i != 0) {
                                numBoxInt = Boxing.boxInt(1);
                            } else {
                                numBoxInt = (Integer) episode.element;
                            }
                            episode.element = numBoxInt;
                            anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                            if (anidbEid != null) {
                                anidbEid2 = anidbEid.intValue();
                            } else {
                                anidbEid2 = 0;
                            }
                            anijson3 = anijson2;
                            torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                            SharedPreferences sharedPreferences7 = this.sharedPref;
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = function5;
                            c00592.L$2 = function4;
                            c00592.L$3 = provider2;
                            c00592.L$4 = key2;
                            c00592.L$5 = dataObj;
                            c00592.L$6 = title;
                            c00592.L$7 = season;
                            c00592.L$8 = episode;
                            c00592.L$9 = id;
                            c00592.L$10 = year2;
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                            c00592.L$15 = kitsuId2;
                            c00592.L$16 = torrentioapiUrl;
                            c00592.Z$0 = isAnime;
                            c00592.Z$1 = isAnime3;
                            c00592.I$0 = i;
                            c00592.I$1 = anidbEid2;
                            c00592.label = 2;
                            anidbEid3 = anidbEid2;
                            torraStreamTrakt = this;
                            objBuildMeteorUrl = torraStreamTrakt.buildMeteorUrl(sharedPreferences7, TorraStream.Meteorfortheweebs, c00592);
                            if (objBuildMeteorUrl == obj8) {
                                return obj8;
                            }
                            Ref.ObjectRef objectRef7 = episode;
                            obj10 = objBuildMeteorUrl;
                            dataObj2 = dataObj;
                            episode2 = objectRef7;
                            obj11 = obj8;
                            isCasting2 = isAnime;
                            aniJson2 = aniJson;
                            i2 = i;
                            function6 = function4;
                            title2 = title;
                            aniResponse2 = aniResponse;
                            isAnime4 = isAnime3;
                            mappings3 = mappings2;
                            torrentioapiUrl2 = torrentioapiUrl;
                            season2 = season;
                            kitsuId3 = kitsuId2;
                            id2 = id;
                            anidbEid4 = anidbEid3;
                            meteorUrl = (String) obj10;
                            function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStreamTrakt.sharedPref, function6);
                            str = key2;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (z) {
                                str2 = str5;
                                if (!Intrinsics.areEqual(provider2, str2)) {
                                    str5 = str2;
                                    anidbEid6 = anidbEid4;
                                    torrentioapiUrl6 = torrentioapiUrl2;
                                    Function1 filtered7 = new C00643(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                    Function1[] function1Arr9 = {new C00632(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered7};
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = function5;
                                    c00592.L$2 = function6;
                                    c00592.L$3 = provider2;
                                    c00592.L$4 = key2;
                                    c00592.L$5 = dataObj2;
                                    c00592.L$6 = title2;
                                    c00592.L$7 = season2;
                                    c00592.L$8 = episode2;
                                    c00592.L$9 = id2;
                                    c00592.L$10 = year2;
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = kitsuId3;
                                    c00592.L$16 = torrentioapiUrl6;
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                    c00592.L$18 = function1FilteredCallback;
                                    c00592.Z$0 = isCasting2;
                                    isAnime6 = isAnime4;
                                    c00592.Z$1 = isAnime6;
                                    function9 = function6;
                                    i4 = i2;
                                    c00592.I$0 = i4;
                                    c00592.I$1 = anidbEid6;
                                    dataObj4 = dataObj2;
                                    c00592.label = 3;
                                    c = 3;
                                    objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr9, c00592);
                                    obj12 = obj11;
                                    if (objRunAllAsync == obj12) {
                                        return obj12;
                                    }
                                    aniResponse3 = aniResponse2;
                                    torrentioapiUrl7 = torrentioapiUrl6;
                                    torrentioapiUrl8 = title2;
                                    anidbEid5 = anidbEid6;
                                    data3 = provider2;
                                    function10 = function1FilteredCallback;
                                    isAnime7 = isAnime6;
                                    isAnime8 = isCasting2;
                                    i5 = i4;
                                    meteorUrl2 = meteorUrl;
                                    year3 = year2;
                                    kitsuId4 = kitsuId3;
                                    function7 = function10;
                                    i3 = i5;
                                    isAnime5 = isAnime7;
                                    isCasting2 = isAnime8;
                                    torrentioapiUrl4 = torrentioapiUrl7;
                                    title3 = torrentioapiUrl8;
                                    key3 = key2;
                                    torrentioapiUrl5 = id2;
                                    season3 = season2;
                                    episode3 = episode2;
                                    function8 = function9;
                                    dataObj3 = dataObj4;
                                    str3 = data3;
                                    if (str3 != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (!z2) {
                                        str4 = key3;
                                        if (str4 != null) {
                                            z3 = true;
                                        } else {
                                            z3 = true;
                                        }
                                        if (!z3) {
                                            if (Intrinsics.areEqual(data3, str5)) {
                                                Function1<ExtractorLink, Unit> function11117 = function7;
                                                key5 = key3;
                                                function7 = function11117;
                                                function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function11117, null)};
                                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00592.L$1 = function5;
                                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                c00592.L$7 = season3;
                                                c00592.L$8 = episode3;
                                                c00592.L$9 = torrentioapiUrl5;
                                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                c00592.Z$0 = isCasting2;
                                                c00592.Z$1 = isAnime5;
                                                c00592.I$0 = i3;
                                                c00592.I$1 = anidbEid5;
                                                c00592.label = 4;
                                                if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                    return obj12;
                                                }
                                                provider4 = data3;
                                                meteorUrl3 = meteorUrl2;
                                                anijson5 = anijson3;
                                                provider5 = data2;
                                                data2 = provider5;
                                                meteorUrl2 = meteorUrl3;
                                                anijson3 = anijson5;
                                                data3 = provider4;
                                                key3 = key5;
                                            }
                                            Unit unit13 = Unit.INSTANCE;
                                            torrentioapiUrl11 = data3;
                                            kitsuId5 = kitsuId4;
                                            data4 = torrentioapiUrl5;
                                            anijson4 = anijson3;
                                            torrentioapiUrl10 = torrentioapiUrl4;
                                            aniResponse5 = aniResponse3;
                                        }
                                        num = (Integer) episode3.element;
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime5;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    key4 = key3;
                                    function1Arr = new Function1[8];
                                    torrentioapiUrl9 = torrentioapiUrl4;
                                    function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                    provider3 = data3;
                                    Function1<? super ExtractorLink, Unit> function11118 = function8;
                                    episode4 = episode3;
                                    season4 = season3;
                                    id3 = torrentioapiUrl5;
                                    LoadDataTrakt dataObj114 = dataObj3;
                                    C00676 c006718 = new C00676(dataObj114, id3, season4, episode4, function11118, null);
                                    function8 = function11118;
                                    function1Arr[1] = c006718;
                                    aniResponse4 = aniResponse3;
                                    function1Arr[2] = new C00687(dataObj114, anidbEid5, function8, null);
                                    Integer kitsuId18 = kitsuId4;
                                    function1Arr[c] = new C00698(kitsuId18, season4, episode4, function7, null);
                                    Function1<ExtractorLink, Unit> function11119 = function7;
                                    function7 = function11119;
                                    function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function11119, null);
                                    function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                    kitsuId5 = kitsuId18;
                                    function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                    isAnime9 = isAnime5;
                                    function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = function5;
                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00592.L$7 = season4;
                                    c00592.L$8 = episode4;
                                    c00592.L$9 = id3;
                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00592.Z$0 = isCasting2;
                                    c00592.Z$1 = isAnime9;
                                    c00592.I$0 = i3;
                                    c00592.I$1 = anidbEid5;
                                    c00592.label = 5;
                                    if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                        return obj12;
                                    }
                                    data4 = id3;
                                    isAnime5 = isAnime9;
                                    season3 = season4;
                                    episode3 = episode4;
                                    key3 = key4;
                                    anijson4 = anijson3;
                                    torrentioapiUrl10 = torrentioapiUrl9;
                                    torrentioapiUrl11 = provider3;
                                    aniResponse5 = aniResponse4;
                                    num = (Integer) episode3.element;
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00592.Z$0 = isCasting2;
                                    c00592.Z$1 = isAnime5;
                                    c00592.I$0 = i3;
                                    c00592.I$1 = anidbEid5;
                                    c00592.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                torrentioapiUrl3 = torrentioapiUrl2;
                                str5 = str2;
                            } else {
                                torrentioapiUrl3 = torrentioapiUrl2;
                            }
                            obj12 = obj11;
                            int i12 = i2;
                            c = 3;
                            LoadDataTrakt dataObj115 = dataObj2;
                            aniResponse3 = aniResponse2;
                            title3 = title2;
                            year3 = year2;
                            kitsuId4 = kitsuId3;
                            function7 = function1FilteredCallback;
                            i3 = i12;
                            torrentioapiUrl4 = torrentioapiUrl3;
                            meteorUrl2 = meteorUrl;
                            anidbEid5 = anidbEid4;
                            data3 = provider2;
                            isAnime5 = isAnime4;
                            key3 = key2;
                            torrentioapiUrl5 = id2;
                            episode3 = episode2;
                            dataObj3 = dataObj115;
                            season3 = season2;
                            function8 = function6;
                            str3 = data3;
                            if (str3 != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (!z2) {
                                str4 = key3;
                                if (str4 != null) {
                                    z3 = true;
                                } else {
                                    z3 = true;
                                }
                                if (!z3) {
                                    if (Intrinsics.areEqual(data3, str5)) {
                                        Function1<ExtractorLink, Unit> function111110 = function7;
                                        key5 = key3;
                                        function7 = function111110;
                                        function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function111110, null)};
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = season3;
                                        c00592.L$8 = episode3;
                                        c00592.L$9 = torrentioapiUrl5;
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime5;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 4;
                                        if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                            return obj12;
                                        }
                                        provider4 = data3;
                                        meteorUrl3 = meteorUrl2;
                                        anijson5 = anijson3;
                                        provider5 = data2;
                                        data2 = provider5;
                                        meteorUrl2 = meteorUrl3;
                                        anijson3 = anijson5;
                                        data3 = provider4;
                                        key3 = key5;
                                    }
                                    Unit unit14 = Unit.INSTANCE;
                                    torrentioapiUrl11 = data3;
                                    kitsuId5 = kitsuId4;
                                    data4 = torrentioapiUrl5;
                                    anijson4 = anijson3;
                                    torrentioapiUrl10 = torrentioapiUrl4;
                                    aniResponse5 = aniResponse3;
                                }
                                num = (Integer) episode3.element;
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime5;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            key4 = key3;
                            function1Arr = new Function1[8];
                            torrentioapiUrl9 = torrentioapiUrl4;
                            function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                            provider3 = data3;
                            Function1<? super ExtractorLink, Unit> function111111 = function8;
                            episode4 = episode3;
                            season4 = season3;
                            id3 = torrentioapiUrl5;
                            LoadDataTrakt dataObj116 = dataObj3;
                            C00676 c006719 = new C00676(dataObj116, id3, season4, episode4, function111111, null);
                            function8 = function111111;
                            function1Arr[1] = c006719;
                            aniResponse4 = aniResponse3;
                            function1Arr[2] = new C00687(dataObj116, anidbEid5, function8, null);
                            Integer kitsuId19 = kitsuId4;
                            function1Arr[c] = new C00698(kitsuId19, season4, episode4, function7, null);
                            Function1<ExtractorLink, Unit> function111112 = function7;
                            function7 = function111112;
                            function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function111112, null);
                            function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                            kitsuId5 = kitsuId19;
                            function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                            isAnime9 = isAnime5;
                            function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = function5;
                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00592.L$7 = season4;
                            c00592.L$8 = episode4;
                            c00592.L$9 = id3;
                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00592.Z$0 = isCasting2;
                            c00592.Z$1 = isAnime9;
                            c00592.I$0 = i3;
                            c00592.I$1 = anidbEid5;
                            c00592.label = 5;
                            if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                return obj12;
                            }
                            data4 = id3;
                            isAnime5 = isAnime9;
                            season3 = season4;
                            episode3 = episode4;
                            key3 = key4;
                            anijson4 = anijson3;
                            torrentioapiUrl10 = torrentioapiUrl9;
                            torrentioapiUrl11 = provider3;
                            aniResponse5 = aniResponse4;
                            num = (Integer) episode3.element;
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00592.Z$0 = isCasting2;
                            c00592.Z$1 = isAnime5;
                            c00592.I$0 = i3;
                            c00592.I$1 = anidbEid5;
                            c00592.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        mappings2 = mappings;
                    } else {
                        kitsuId2 = kitsuId;
                        mappings2 = mappings;
                    }
                    if (i != 0) {
                        numBoxInt = Boxing.boxInt(1);
                    } else {
                        numBoxInt = (Integer) episode.element;
                    }
                    episode.element = numBoxInt;
                    anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                    if (anidbEid != null) {
                        anidbEid2 = anidbEid.intValue();
                    } else {
                        anidbEid2 = 0;
                    }
                    anijson3 = anijson2;
                    torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                    SharedPreferences sharedPreferences8 = this.sharedPref;
                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00592.L$1 = function5;
                    c00592.L$2 = function4;
                    c00592.L$3 = provider2;
                    c00592.L$4 = key2;
                    c00592.L$5 = dataObj;
                    c00592.L$6 = title;
                    c00592.L$7 = season;
                    c00592.L$8 = episode;
                    c00592.L$9 = id;
                    c00592.L$10 = year2;
                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                    c00592.L$15 = kitsuId2;
                    c00592.L$16 = torrentioapiUrl;
                    c00592.Z$0 = isAnime;
                    c00592.Z$1 = isAnime3;
                    c00592.I$0 = i;
                    c00592.I$1 = anidbEid2;
                    c00592.label = 2;
                    anidbEid3 = anidbEid2;
                    torraStreamTrakt = this;
                    objBuildMeteorUrl = torraStreamTrakt.buildMeteorUrl(sharedPreferences8, TorraStream.Meteorfortheweebs, c00592);
                    if (objBuildMeteorUrl == obj8) {
                        return obj8;
                    }
                    Ref.ObjectRef objectRef8 = episode;
                    obj10 = objBuildMeteorUrl;
                    dataObj2 = dataObj;
                    episode2 = objectRef8;
                    obj11 = obj8;
                    isCasting2 = isAnime;
                    aniJson2 = aniJson;
                    i2 = i;
                    function6 = function4;
                    title2 = title;
                    aniResponse2 = aniResponse;
                    isAnime4 = isAnime3;
                    mappings3 = mappings2;
                    torrentioapiUrl2 = torrentioapiUrl;
                    season2 = season;
                    kitsuId3 = kitsuId2;
                    id2 = id;
                    anidbEid4 = anidbEid3;
                    meteorUrl = (String) obj10;
                    function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStreamTrakt.sharedPref, function6);
                    str = key2;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        str2 = str5;
                        if (!Intrinsics.areEqual(provider2, str2)) {
                            str5 = str2;
                            anidbEid6 = anidbEid4;
                            torrentioapiUrl6 = torrentioapiUrl2;
                            Function1 filtered8 = new C00643(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                            Function1[] function1Arr10 = {new C00632(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered8};
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = function5;
                            c00592.L$2 = function6;
                            c00592.L$3 = provider2;
                            c00592.L$4 = key2;
                            c00592.L$5 = dataObj2;
                            c00592.L$6 = title2;
                            c00592.L$7 = season2;
                            c00592.L$8 = episode2;
                            c00592.L$9 = id2;
                            c00592.L$10 = year2;
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = kitsuId3;
                            c00592.L$16 = torrentioapiUrl6;
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                            c00592.L$18 = function1FilteredCallback;
                            c00592.Z$0 = isCasting2;
                            isAnime6 = isAnime4;
                            c00592.Z$1 = isAnime6;
                            function9 = function6;
                            i4 = i2;
                            c00592.I$0 = i4;
                            c00592.I$1 = anidbEid6;
                            dataObj4 = dataObj2;
                            c00592.label = 3;
                            c = 3;
                            objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr10, c00592);
                            obj12 = obj11;
                            if (objRunAllAsync == obj12) {
                                return obj12;
                            }
                            aniResponse3 = aniResponse2;
                            torrentioapiUrl7 = torrentioapiUrl6;
                            torrentioapiUrl8 = title2;
                            anidbEid5 = anidbEid6;
                            data3 = provider2;
                            function10 = function1FilteredCallback;
                            isAnime7 = isAnime6;
                            isAnime8 = isCasting2;
                            i5 = i4;
                            meteorUrl2 = meteorUrl;
                            year3 = year2;
                            kitsuId4 = kitsuId3;
                            function7 = function10;
                            i3 = i5;
                            isAnime5 = isAnime7;
                            isCasting2 = isAnime8;
                            torrentioapiUrl4 = torrentioapiUrl7;
                            title3 = torrentioapiUrl8;
                            key3 = key2;
                            torrentioapiUrl5 = id2;
                            season3 = season2;
                            episode3 = episode2;
                            function8 = function9;
                            dataObj3 = dataObj4;
                            str3 = data3;
                            if (str3 != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (!z2) {
                                str4 = key3;
                                if (str4 != null) {
                                    z3 = true;
                                } else {
                                    z3 = true;
                                }
                                if (!z3) {
                                    if (Intrinsics.areEqual(data3, str5)) {
                                        Function1<ExtractorLink, Unit> function111113 = function7;
                                        key5 = key3;
                                        function7 = function111113;
                                        function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function111113, null)};
                                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00592.L$1 = function5;
                                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00592.L$7 = season3;
                                        c00592.L$8 = episode3;
                                        c00592.L$9 = torrentioapiUrl5;
                                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00592.Z$0 = isCasting2;
                                        c00592.Z$1 = isAnime5;
                                        c00592.I$0 = i3;
                                        c00592.I$1 = anidbEid5;
                                        c00592.label = 4;
                                        if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                            return obj12;
                                        }
                                        provider4 = data3;
                                        meteorUrl3 = meteorUrl2;
                                        anijson5 = anijson3;
                                        provider5 = data2;
                                        data2 = provider5;
                                        meteorUrl2 = meteorUrl3;
                                        anijson3 = anijson5;
                                        data3 = provider4;
                                        key3 = key5;
                                    }
                                    Unit unit15 = Unit.INSTANCE;
                                    torrentioapiUrl11 = data3;
                                    kitsuId5 = kitsuId4;
                                    data4 = torrentioapiUrl5;
                                    anijson4 = anijson3;
                                    torrentioapiUrl10 = torrentioapiUrl4;
                                    aniResponse5 = aniResponse3;
                                }
                                num = (Integer) episode3.element;
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime5;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            key4 = key3;
                            function1Arr = new Function1[8];
                            torrentioapiUrl9 = torrentioapiUrl4;
                            function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                            provider3 = data3;
                            Function1<? super ExtractorLink, Unit> function111114 = function8;
                            episode4 = episode3;
                            season4 = season3;
                            id3 = torrentioapiUrl5;
                            LoadDataTrakt dataObj117 = dataObj3;
                            C00676 c0067110 = new C00676(dataObj117, id3, season4, episode4, function111114, null);
                            function8 = function111114;
                            function1Arr[1] = c0067110;
                            aniResponse4 = aniResponse3;
                            function1Arr[2] = new C00687(dataObj117, anidbEid5, function8, null);
                            Integer kitsuId110 = kitsuId4;
                            function1Arr[c] = new C00698(kitsuId110, season4, episode4, function7, null);
                            Function1<ExtractorLink, Unit> function111115 = function7;
                            function7 = function111115;
                            function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function111115, null);
                            function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                            kitsuId5 = kitsuId110;
                            function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                            isAnime9 = isAnime5;
                            function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = function5;
                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00592.L$7 = season4;
                            c00592.L$8 = episode4;
                            c00592.L$9 = id3;
                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00592.Z$0 = isCasting2;
                            c00592.Z$1 = isAnime9;
                            c00592.I$0 = i3;
                            c00592.I$1 = anidbEid5;
                            c00592.label = 5;
                            if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                return obj12;
                            }
                            data4 = id3;
                            isAnime5 = isAnime9;
                            season3 = season4;
                            episode3 = episode4;
                            key3 = key4;
                            anijson4 = anijson3;
                            torrentioapiUrl10 = torrentioapiUrl9;
                            torrentioapiUrl11 = provider3;
                            aniResponse5 = aniResponse4;
                            num = (Integer) episode3.element;
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00592.Z$0 = isCasting2;
                            c00592.Z$1 = isAnime5;
                            c00592.I$0 = i3;
                            c00592.I$1 = anidbEid5;
                            c00592.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        torrentioapiUrl3 = torrentioapiUrl2;
                        str5 = str2;
                    } else {
                        torrentioapiUrl3 = torrentioapiUrl2;
                    }
                    obj12 = obj11;
                    int i13 = i2;
                    c = 3;
                    LoadDataTrakt dataObj118 = dataObj2;
                    aniResponse3 = aniResponse2;
                    title3 = title2;
                    year3 = year2;
                    kitsuId4 = kitsuId3;
                    function7 = function1FilteredCallback;
                    i3 = i13;
                    torrentioapiUrl4 = torrentioapiUrl3;
                    meteorUrl2 = meteorUrl;
                    anidbEid5 = anidbEid4;
                    data3 = provider2;
                    isAnime5 = isAnime4;
                    key3 = key2;
                    torrentioapiUrl5 = id2;
                    episode3 = episode2;
                    dataObj3 = dataObj118;
                    season3 = season2;
                    function8 = function6;
                    str3 = data3;
                    if (str3 != null) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        str4 = key3;
                        if (str4 != null) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (!z3) {
                            if (Intrinsics.areEqual(data3, str5)) {
                                Function1<ExtractorLink, Unit> function111116 = function7;
                                key5 = key3;
                                function7 = function111116;
                                function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function111116, null)};
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = function5;
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = season3;
                                c00592.L$8 = episode3;
                                c00592.L$9 = torrentioapiUrl5;
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime5;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 4;
                                if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                    return obj12;
                                }
                                provider4 = data3;
                                meteorUrl3 = meteorUrl2;
                                anijson5 = anijson3;
                                provider5 = data2;
                                data2 = provider5;
                                meteorUrl2 = meteorUrl3;
                                anijson3 = anijson5;
                                data3 = provider4;
                                key3 = key5;
                            }
                            Unit unit16 = Unit.INSTANCE;
                            torrentioapiUrl11 = data3;
                            kitsuId5 = kitsuId4;
                            data4 = torrentioapiUrl5;
                            anijson4 = anijson3;
                            torrentioapiUrl10 = torrentioapiUrl4;
                            aniResponse5 = aniResponse3;
                        }
                        num = (Integer) episode3.element;
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                        c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                        c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00592.Z$0 = isCasting2;
                        c00592.Z$1 = isAnime5;
                        c00592.I$0 = i3;
                        c00592.I$1 = anidbEid5;
                        c00592.label = 6;
                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                            return obj12;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    key4 = key3;
                    function1Arr = new Function1[8];
                    torrentioapiUrl9 = torrentioapiUrl4;
                    function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                    provider3 = data3;
                    Function1<? super ExtractorLink, Unit> function111117 = function8;
                    episode4 = episode3;
                    season4 = season3;
                    id3 = torrentioapiUrl5;
                    LoadDataTrakt dataObj119 = dataObj3;
                    C00676 c0067111 = new C00676(dataObj119, id3, season4, episode4, function111117, null);
                    function8 = function111117;
                    function1Arr[1] = c0067111;
                    aniResponse4 = aniResponse3;
                    function1Arr[2] = new C00687(dataObj119, anidbEid5, function8, null);
                    Integer kitsuId111 = kitsuId4;
                    function1Arr[c] = new C00698(kitsuId111, season4, episode4, function7, null);
                    Function1<ExtractorLink, Unit> function111118 = function7;
                    function7 = function111118;
                    function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function111118, null);
                    function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                    kitsuId5 = kitsuId111;
                    function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                    isAnime9 = isAnime5;
                    function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00592.L$1 = function5;
                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00592.L$7 = season4;
                    c00592.L$8 = episode4;
                    c00592.L$9 = id3;
                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                    c00592.Z$0 = isCasting2;
                    c00592.Z$1 = isAnime9;
                    c00592.I$0 = i3;
                    c00592.I$1 = anidbEid5;
                    c00592.label = 5;
                    if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                        return obj12;
                    }
                    data4 = id3;
                    isAnime5 = isAnime9;
                    season3 = season4;
                    episode3 = episode4;
                    key3 = key4;
                    anijson4 = anijson3;
                    torrentioapiUrl10 = torrentioapiUrl9;
                    torrentioapiUrl11 = provider3;
                    aniResponse5 = aniResponse4;
                    num = (Integer) episode3.element;
                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                    c00592.Z$0 = isCasting2;
                    c00592.Z$1 = isAnime5;
                    c00592.I$0 = i3;
                    c00592.I$1 = anidbEid5;
                    c00592.label = 6;
                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                        return obj12;
                    }
                    return Boxing.boxBoolean(true);
                }
                obj6 = obj5;
                year2 = year;
                provider2 = provider;
                function5 = function3;
                key2 = key;
                if (Result.isFailure-impl(obj6)) {
                    obj7 = null;
                } else {
                    obj7 = obj6;
                }
                aniResponse = (NiceResponse) obj7;
                if (aniResponse != null) {
                    text = aniResponse.getText();
                } else {
                    text = null;
                }
                obj8 = obj3;
                if (text == null) {
                    text = "";
                }
                anijson = text;
                Result.Companion companion15 = Result.Companion;
                TorraStreamTrakt torraStreamTrakt6 = this;
                isAnime3 = isAnime2;
                anijson2 = anijson;
                obj9 = Result.constructor-impl(new JSONObject(anijson2));
                if (Result.isFailure-impl(obj9)) {
                    obj9 = null;
                }
                aniJson = (JSONObject) obj9;
                if (aniJson != null) {
                    mappings = aniJson.optJSONObject("mappings");
                } else {
                    mappings = null;
                }
                if (mappings != null) {
                    kitsuId = Boxing.boxInt(mappings.optInt("kitsu_id"));
                } else {
                    kitsuId = null;
                }
                if (mappings != null) {
                    kitsuId2 = kitsuId;
                    strOptString = mappings.optString("type", "");
                    if (strOptString != null) {
                        mappings2 = mappings;
                        if (StringsKt.contains(strOptString, "MOVIE", true)) {
                        }
                        if (i != 0) {
                            numBoxInt = Boxing.boxInt(1);
                        } else {
                            numBoxInt = (Integer) episode.element;
                        }
                        episode.element = numBoxInt;
                        anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                        if (anidbEid != null) {
                            anidbEid2 = anidbEid.intValue();
                        } else {
                            anidbEid2 = 0;
                        }
                        anijson3 = anijson2;
                        torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                        SharedPreferences sharedPreferences9 = this.sharedPref;
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = function5;
                        c00592.L$2 = function4;
                        c00592.L$3 = provider2;
                        c00592.L$4 = key2;
                        c00592.L$5 = dataObj;
                        c00592.L$6 = title;
                        c00592.L$7 = season;
                        c00592.L$8 = episode;
                        c00592.L$9 = id;
                        c00592.L$10 = year2;
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                        c00592.L$15 = kitsuId2;
                        c00592.L$16 = torrentioapiUrl;
                        c00592.Z$0 = isAnime;
                        c00592.Z$1 = isAnime3;
                        c00592.I$0 = i;
                        c00592.I$1 = anidbEid2;
                        c00592.label = 2;
                        anidbEid3 = anidbEid2;
                        torraStreamTrakt = this;
                        objBuildMeteorUrl = torraStreamTrakt.buildMeteorUrl(sharedPreferences9, TorraStream.Meteorfortheweebs, c00592);
                        if (objBuildMeteorUrl == obj8) {
                            return obj8;
                        }
                        Ref.ObjectRef objectRef9 = episode;
                        obj10 = objBuildMeteorUrl;
                        dataObj2 = dataObj;
                        episode2 = objectRef9;
                        obj11 = obj8;
                        isCasting2 = isAnime;
                        aniJson2 = aniJson;
                        i2 = i;
                        function6 = function4;
                        title2 = title;
                        aniResponse2 = aniResponse;
                        isAnime4 = isAnime3;
                        mappings3 = mappings2;
                        torrentioapiUrl2 = torrentioapiUrl;
                        season2 = season;
                        kitsuId3 = kitsuId2;
                        id2 = id;
                        anidbEid4 = anidbEid3;
                        meteorUrl = (String) obj10;
                        function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStreamTrakt.sharedPref, function6);
                        str = key2;
                        if (str != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            str2 = str5;
                            if (!Intrinsics.areEqual(provider2, str2)) {
                                str5 = str2;
                                anidbEid6 = anidbEid4;
                                torrentioapiUrl6 = torrentioapiUrl2;
                                Function1 filtered9 = new C00643(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                Function1[] function1Arr11 = {new C00632(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered9};
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = function5;
                                c00592.L$2 = function6;
                                c00592.L$3 = provider2;
                                c00592.L$4 = key2;
                                c00592.L$5 = dataObj2;
                                c00592.L$6 = title2;
                                c00592.L$7 = season2;
                                c00592.L$8 = episode2;
                                c00592.L$9 = id2;
                                c00592.L$10 = year2;
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = kitsuId3;
                                c00592.L$16 = torrentioapiUrl6;
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                c00592.L$18 = function1FilteredCallback;
                                c00592.Z$0 = isCasting2;
                                isAnime6 = isAnime4;
                                c00592.Z$1 = isAnime6;
                                function9 = function6;
                                i4 = i2;
                                c00592.I$0 = i4;
                                c00592.I$1 = anidbEid6;
                                dataObj4 = dataObj2;
                                c00592.label = 3;
                                c = 3;
                                objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr11, c00592);
                                obj12 = obj11;
                                if (objRunAllAsync == obj12) {
                                    return obj12;
                                }
                                aniResponse3 = aniResponse2;
                                torrentioapiUrl7 = torrentioapiUrl6;
                                torrentioapiUrl8 = title2;
                                anidbEid5 = anidbEid6;
                                data3 = provider2;
                                function10 = function1FilteredCallback;
                                isAnime7 = isAnime6;
                                isAnime8 = isCasting2;
                                i5 = i4;
                                meteorUrl2 = meteorUrl;
                                year3 = year2;
                                kitsuId4 = kitsuId3;
                                function7 = function10;
                                i3 = i5;
                                isAnime5 = isAnime7;
                                isCasting2 = isAnime8;
                                torrentioapiUrl4 = torrentioapiUrl7;
                                title3 = torrentioapiUrl8;
                                key3 = key2;
                                torrentioapiUrl5 = id2;
                                season3 = season2;
                                episode3 = episode2;
                                function8 = function9;
                                dataObj3 = dataObj4;
                                str3 = data3;
                                if (str3 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    str4 = key3;
                                    if (str4 != null) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        if (Intrinsics.areEqual(data3, str5)) {
                                            Function1<ExtractorLink, Unit> function111119 = function7;
                                            key5 = key3;
                                            function7 = function111119;
                                            function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function111119, null)};
                                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00592.L$1 = function5;
                                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00592.L$7 = season3;
                                            c00592.L$8 = episode3;
                                            c00592.L$9 = torrentioapiUrl5;
                                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00592.Z$0 = isCasting2;
                                            c00592.Z$1 = isAnime5;
                                            c00592.I$0 = i3;
                                            c00592.I$1 = anidbEid5;
                                            c00592.label = 4;
                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                                return obj12;
                                            }
                                            provider4 = data3;
                                            meteorUrl3 = meteorUrl2;
                                            anijson5 = anijson3;
                                            provider5 = data2;
                                            data2 = provider5;
                                            meteorUrl2 = meteorUrl3;
                                            anijson3 = anijson5;
                                            data3 = provider4;
                                            key3 = key5;
                                        }
                                        Unit unit17 = Unit.INSTANCE;
                                        torrentioapiUrl11 = data3;
                                        kitsuId5 = kitsuId4;
                                        data4 = torrentioapiUrl5;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl4;
                                        aniResponse5 = aniResponse3;
                                    }
                                    num = (Integer) episode3.element;
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00592.Z$0 = isCasting2;
                                    c00592.Z$1 = isAnime5;
                                    c00592.I$0 = i3;
                                    c00592.I$1 = anidbEid5;
                                    c00592.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                key4 = key3;
                                function1Arr = new Function1[8];
                                torrentioapiUrl9 = torrentioapiUrl4;
                                function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                provider3 = data3;
                                Function1<? super ExtractorLink, Unit> function1111110 = function8;
                                episode4 = episode3;
                                season4 = season3;
                                id3 = torrentioapiUrl5;
                                LoadDataTrakt dataObj1110 = dataObj3;
                                C00676 c0067112 = new C00676(dataObj1110, id3, season4, episode4, function1111110, null);
                                function8 = function1111110;
                                function1Arr[1] = c0067112;
                                aniResponse4 = aniResponse3;
                                function1Arr[2] = new C00687(dataObj1110, anidbEid5, function8, null);
                                Integer kitsuId112 = kitsuId4;
                                function1Arr[c] = new C00698(kitsuId112, season4, episode4, function7, null);
                                Function1<ExtractorLink, Unit> function1111111 = function7;
                                function7 = function1111111;
                                function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function1111111, null);
                                function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                                kitsuId5 = kitsuId112;
                                function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                                isAnime9 = isAnime5;
                                function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = function5;
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = season4;
                                c00592.L$8 = episode4;
                                c00592.L$9 = id3;
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime9;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 5;
                                if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                                    return obj12;
                                }
                                data4 = id3;
                                isAnime5 = isAnime9;
                                season3 = season4;
                                episode3 = episode4;
                                key3 = key4;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl9;
                                torrentioapiUrl11 = provider3;
                                aniResponse5 = aniResponse4;
                                num = (Integer) episode3.element;
                                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00592.Z$0 = isCasting2;
                                c00592.Z$1 = isAnime5;
                                c00592.I$0 = i3;
                                c00592.I$1 = anidbEid5;
                                c00592.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            torrentioapiUrl3 = torrentioapiUrl2;
                            str5 = str2;
                        } else {
                            torrentioapiUrl3 = torrentioapiUrl2;
                        }
                        obj12 = obj11;
                        int i14 = i2;
                        c = 3;
                        LoadDataTrakt dataObj1111 = dataObj2;
                        aniResponse3 = aniResponse2;
                        title3 = title2;
                        year3 = year2;
                        kitsuId4 = kitsuId3;
                        function7 = function1FilteredCallback;
                        i3 = i14;
                        torrentioapiUrl4 = torrentioapiUrl3;
                        meteorUrl2 = meteorUrl;
                        anidbEid5 = anidbEid4;
                        data3 = provider2;
                        isAnime5 = isAnime4;
                        key3 = key2;
                        torrentioapiUrl5 = id2;
                        episode3 = episode2;
                        dataObj3 = dataObj1111;
                        season3 = season2;
                        function8 = function6;
                        str3 = data3;
                        if (str3 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            str4 = key3;
                            if (str4 != null) {
                                z3 = true;
                            } else {
                                z3 = true;
                            }
                            if (!z3) {
                                if (Intrinsics.areEqual(data3, str5)) {
                                    Function1<ExtractorLink, Unit> function1111112 = function7;
                                    key5 = key3;
                                    function7 = function1111112;
                                    function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function1111112, null)};
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = function5;
                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00592.L$7 = season3;
                                    c00592.L$8 = episode3;
                                    c00592.L$9 = torrentioapiUrl5;
                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00592.Z$0 = isCasting2;
                                    c00592.Z$1 = isAnime5;
                                    c00592.I$0 = i3;
                                    c00592.I$1 = anidbEid5;
                                    c00592.label = 4;
                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                        return obj12;
                                    }
                                    provider4 = data3;
                                    meteorUrl3 = meteorUrl2;
                                    anijson5 = anijson3;
                                    provider5 = data2;
                                    data2 = provider5;
                                    meteorUrl2 = meteorUrl3;
                                    anijson3 = anijson5;
                                    data3 = provider4;
                                    key3 = key5;
                                }
                                Unit unit18 = Unit.INSTANCE;
                                torrentioapiUrl11 = data3;
                                kitsuId5 = kitsuId4;
                                data4 = torrentioapiUrl5;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl4;
                                aniResponse5 = aniResponse3;
                            }
                            num = (Integer) episode3.element;
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00592.Z$0 = isCasting2;
                            c00592.Z$1 = isAnime5;
                            c00592.I$0 = i3;
                            c00592.I$1 = anidbEid5;
                            c00592.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        key4 = key3;
                        function1Arr = new Function1[8];
                        torrentioapiUrl9 = torrentioapiUrl4;
                        function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                        provider3 = data3;
                        Function1<? super ExtractorLink, Unit> function1111113 = function8;
                        episode4 = episode3;
                        season4 = season3;
                        id3 = torrentioapiUrl5;
                        LoadDataTrakt dataObj1112 = dataObj3;
                        C00676 c0067113 = new C00676(dataObj1112, id3, season4, episode4, function1111113, null);
                        function8 = function1111113;
                        function1Arr[1] = c0067113;
                        aniResponse4 = aniResponse3;
                        function1Arr[2] = new C00687(dataObj1112, anidbEid5, function8, null);
                        Integer kitsuId113 = kitsuId4;
                        function1Arr[c] = new C00698(kitsuId113, season4, episode4, function7, null);
                        Function1<ExtractorLink, Unit> function1111114 = function7;
                        function7 = function1111114;
                        function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function1111114, null);
                        function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                        kitsuId5 = kitsuId113;
                        function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                        isAnime9 = isAnime5;
                        function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = function5;
                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00592.L$7 = season4;
                        c00592.L$8 = episode4;
                        c00592.L$9 = id3;
                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00592.Z$0 = isCasting2;
                        c00592.Z$1 = isAnime9;
                        c00592.I$0 = i3;
                        c00592.I$1 = anidbEid5;
                        c00592.label = 5;
                        if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                            return obj12;
                        }
                        data4 = id3;
                        isAnime5 = isAnime9;
                        season3 = season4;
                        episode3 = episode4;
                        key3 = key4;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl9;
                        torrentioapiUrl11 = provider3;
                        aniResponse5 = aniResponse4;
                        num = (Integer) episode3.element;
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                        c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                        c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00592.Z$0 = isCasting2;
                        c00592.Z$1 = isAnime5;
                        c00592.I$0 = i3;
                        c00592.I$1 = anidbEid5;
                        c00592.label = 6;
                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                            return obj12;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    mappings2 = mappings;
                } else {
                    kitsuId2 = kitsuId;
                    mappings2 = mappings;
                }
                if (i != 0) {
                    numBoxInt = Boxing.boxInt(1);
                } else {
                    numBoxInt = (Integer) episode.element;
                }
                episode.element = numBoxInt;
                anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                if (anidbEid != null) {
                    anidbEid2 = anidbEid.intValue();
                } else {
                    anidbEid2 = 0;
                }
                anijson3 = anijson2;
                torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                SharedPreferences sharedPreferences10 = this.sharedPref;
                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00592.L$1 = function5;
                c00592.L$2 = function4;
                c00592.L$3 = provider2;
                c00592.L$4 = key2;
                c00592.L$5 = dataObj;
                c00592.L$6 = title;
                c00592.L$7 = season;
                c00592.L$8 = episode;
                c00592.L$9 = id;
                c00592.L$10 = year2;
                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                c00592.L$15 = kitsuId2;
                c00592.L$16 = torrentioapiUrl;
                c00592.Z$0 = isAnime;
                c00592.Z$1 = isAnime3;
                c00592.I$0 = i;
                c00592.I$1 = anidbEid2;
                c00592.label = 2;
                anidbEid3 = anidbEid2;
                torraStreamTrakt = this;
                objBuildMeteorUrl = torraStreamTrakt.buildMeteorUrl(sharedPreferences10, TorraStream.Meteorfortheweebs, c00592);
                if (objBuildMeteorUrl == obj8) {
                    return obj8;
                }
                Ref.ObjectRef objectRef10 = episode;
                obj10 = objBuildMeteorUrl;
                dataObj2 = dataObj;
                episode2 = objectRef10;
                obj11 = obj8;
                isCasting2 = isAnime;
                aniJson2 = aniJson;
                i2 = i;
                function6 = function4;
                title2 = title;
                aniResponse2 = aniResponse;
                isAnime4 = isAnime3;
                mappings3 = mappings2;
                torrentioapiUrl2 = torrentioapiUrl;
                season2 = season;
                kitsuId3 = kitsuId2;
                id2 = id;
                anidbEid4 = anidbEid3;
                meteorUrl = (String) obj10;
                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStreamTrakt.sharedPref, function6);
                str = key2;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    str2 = str5;
                    if (!Intrinsics.areEqual(provider2, str2)) {
                        str5 = str2;
                        anidbEid6 = anidbEid4;
                        torrentioapiUrl6 = torrentioapiUrl2;
                        Function1 filtered10 = new C00643(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                        Function1[] function1Arr12 = {new C00632(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered10};
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = function5;
                        c00592.L$2 = function6;
                        c00592.L$3 = provider2;
                        c00592.L$4 = key2;
                        c00592.L$5 = dataObj2;
                        c00592.L$6 = title2;
                        c00592.L$7 = season2;
                        c00592.L$8 = episode2;
                        c00592.L$9 = id2;
                        c00592.L$10 = year2;
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00592.L$15 = kitsuId3;
                        c00592.L$16 = torrentioapiUrl6;
                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                        c00592.L$18 = function1FilteredCallback;
                        c00592.Z$0 = isCasting2;
                        isAnime6 = isAnime4;
                        c00592.Z$1 = isAnime6;
                        function9 = function6;
                        i4 = i2;
                        c00592.I$0 = i4;
                        c00592.I$1 = anidbEid6;
                        dataObj4 = dataObj2;
                        c00592.label = 3;
                        c = 3;
                        objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr12, c00592);
                        obj12 = obj11;
                        if (objRunAllAsync == obj12) {
                            return obj12;
                        }
                        aniResponse3 = aniResponse2;
                        torrentioapiUrl7 = torrentioapiUrl6;
                        torrentioapiUrl8 = title2;
                        anidbEid5 = anidbEid6;
                        data3 = provider2;
                        function10 = function1FilteredCallback;
                        isAnime7 = isAnime6;
                        isAnime8 = isCasting2;
                        i5 = i4;
                        meteorUrl2 = meteorUrl;
                        year3 = year2;
                        kitsuId4 = kitsuId3;
                        function7 = function10;
                        i3 = i5;
                        isAnime5 = isAnime7;
                        isCasting2 = isAnime8;
                        torrentioapiUrl4 = torrentioapiUrl7;
                        title3 = torrentioapiUrl8;
                        key3 = key2;
                        torrentioapiUrl5 = id2;
                        season3 = season2;
                        episode3 = episode2;
                        function8 = function9;
                        dataObj3 = dataObj4;
                        str3 = data3;
                        if (str3 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            str4 = key3;
                            if (str4 != null) {
                                z3 = true;
                            } else {
                                z3 = true;
                            }
                            if (!z3) {
                                if (Intrinsics.areEqual(data3, str5)) {
                                    Function1<ExtractorLink, Unit> function1111115 = function7;
                                    key5 = key3;
                                    function7 = function1111115;
                                    function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function1111115, null)};
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = function5;
                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00592.L$7 = season3;
                                    c00592.L$8 = episode3;
                                    c00592.L$9 = torrentioapiUrl5;
                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00592.Z$0 = isCasting2;
                                    c00592.Z$1 = isAnime5;
                                    c00592.I$0 = i3;
                                    c00592.I$1 = anidbEid5;
                                    c00592.label = 4;
                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                        return obj12;
                                    }
                                    provider4 = data3;
                                    meteorUrl3 = meteorUrl2;
                                    anijson5 = anijson3;
                                    provider5 = data2;
                                    data2 = provider5;
                                    meteorUrl2 = meteorUrl3;
                                    anijson3 = anijson5;
                                    data3 = provider4;
                                    key3 = key5;
                                }
                                Unit unit19 = Unit.INSTANCE;
                                torrentioapiUrl11 = data3;
                                kitsuId5 = kitsuId4;
                                data4 = torrentioapiUrl5;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl4;
                                aniResponse5 = aniResponse3;
                            }
                            num = (Integer) episode3.element;
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00592.Z$0 = isCasting2;
                            c00592.Z$1 = isAnime5;
                            c00592.I$0 = i3;
                            c00592.I$1 = anidbEid5;
                            c00592.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        key4 = key3;
                        function1Arr = new Function1[8];
                        torrentioapiUrl9 = torrentioapiUrl4;
                        function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                        provider3 = data3;
                        Function1<? super ExtractorLink, Unit> function1111116 = function8;
                        episode4 = episode3;
                        season4 = season3;
                        id3 = torrentioapiUrl5;
                        LoadDataTrakt dataObj1113 = dataObj3;
                        C00676 c0067114 = new C00676(dataObj1113, id3, season4, episode4, function1111116, null);
                        function8 = function1111116;
                        function1Arr[1] = c0067114;
                        aniResponse4 = aniResponse3;
                        function1Arr[2] = new C00687(dataObj1113, anidbEid5, function8, null);
                        Integer kitsuId114 = kitsuId4;
                        function1Arr[c] = new C00698(kitsuId114, season4, episode4, function7, null);
                        Function1<ExtractorLink, Unit> function1111117 = function7;
                        function7 = function1111117;
                        function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function1111117, null);
                        function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                        kitsuId5 = kitsuId114;
                        function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                        isAnime9 = isAnime5;
                        function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = function5;
                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00592.L$7 = season4;
                        c00592.L$8 = episode4;
                        c00592.L$9 = id3;
                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00592.Z$0 = isCasting2;
                        c00592.Z$1 = isAnime9;
                        c00592.I$0 = i3;
                        c00592.I$1 = anidbEid5;
                        c00592.label = 5;
                        if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                            return obj12;
                        }
                        data4 = id3;
                        isAnime5 = isAnime9;
                        season3 = season4;
                        episode3 = episode4;
                        key3 = key4;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl9;
                        torrentioapiUrl11 = provider3;
                        aniResponse5 = aniResponse4;
                        num = (Integer) episode3.element;
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                        c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                        c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00592.Z$0 = isCasting2;
                        c00592.Z$1 = isAnime5;
                        c00592.I$0 = i3;
                        c00592.I$1 = anidbEid5;
                        c00592.label = 6;
                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                            return obj12;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    torrentioapiUrl3 = torrentioapiUrl2;
                    str5 = str2;
                } else {
                    torrentioapiUrl3 = torrentioapiUrl2;
                }
                obj12 = obj11;
                int i15 = i2;
                c = 3;
                LoadDataTrakt dataObj1114 = dataObj2;
                aniResponse3 = aniResponse2;
                title3 = title2;
                year3 = year2;
                kitsuId4 = kitsuId3;
                function7 = function1FilteredCallback;
                i3 = i15;
                torrentioapiUrl4 = torrentioapiUrl3;
                meteorUrl2 = meteorUrl;
                anidbEid5 = anidbEid4;
                data3 = provider2;
                isAnime5 = isAnime4;
                key3 = key2;
                torrentioapiUrl5 = id2;
                episode3 = episode2;
                dataObj3 = dataObj1114;
                season3 = season2;
                function8 = function6;
                str3 = data3;
                if (str3 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    str4 = key3;
                    if (str4 != null) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        if (Intrinsics.areEqual(data3, str5)) {
                            Function1<ExtractorLink, Unit> function1111118 = function7;
                            key5 = key3;
                            function7 = function1111118;
                            function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function1111118, null)};
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = function5;
                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00592.L$7 = season3;
                            c00592.L$8 = episode3;
                            c00592.L$9 = torrentioapiUrl5;
                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00592.Z$0 = isCasting2;
                            c00592.Z$1 = isAnime5;
                            c00592.I$0 = i3;
                            c00592.I$1 = anidbEid5;
                            c00592.label = 4;
                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                return obj12;
                            }
                            provider4 = data3;
                            meteorUrl3 = meteorUrl2;
                            anijson5 = anijson3;
                            provider5 = data2;
                            data2 = provider5;
                            meteorUrl2 = meteorUrl3;
                            anijson3 = anijson5;
                            data3 = provider4;
                            key3 = key5;
                        }
                        Unit unit110 = Unit.INSTANCE;
                        torrentioapiUrl11 = data3;
                        kitsuId5 = kitsuId4;
                        data4 = torrentioapiUrl5;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl4;
                        aniResponse5 = aniResponse3;
                    }
                    num = (Integer) episode3.element;
                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                    c00592.Z$0 = isCasting2;
                    c00592.Z$1 = isAnime5;
                    c00592.I$0 = i3;
                    c00592.I$1 = anidbEid5;
                    c00592.label = 6;
                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                        return obj12;
                    }
                    return Boxing.boxBoolean(true);
                }
                key4 = key3;
                function1Arr = new Function1[8];
                torrentioapiUrl9 = torrentioapiUrl4;
                function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                provider3 = data3;
                Function1<? super ExtractorLink, Unit> function1111119 = function8;
                episode4 = episode3;
                season4 = season3;
                id3 = torrentioapiUrl5;
                LoadDataTrakt dataObj1115 = dataObj3;
                C00676 c0067115 = new C00676(dataObj1115, id3, season4, episode4, function1111119, null);
                function8 = function1111119;
                function1Arr[1] = c0067115;
                aniResponse4 = aniResponse3;
                function1Arr[2] = new C00687(dataObj1115, anidbEid5, function8, null);
                Integer kitsuId115 = kitsuId4;
                function1Arr[c] = new C00698(kitsuId115, season4, episode4, function7, null);
                Function1<ExtractorLink, Unit> function11111110 = function7;
                function7 = function11111110;
                function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function11111110, null);
                function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                kitsuId5 = kitsuId115;
                function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                isAnime9 = isAnime5;
                function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00592.L$1 = function5;
                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00592.L$7 = season4;
                c00592.L$8 = episode4;
                c00592.L$9 = id3;
                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00592.Z$0 = isCasting2;
                c00592.Z$1 = isAnime9;
                c00592.I$0 = i3;
                c00592.I$1 = anidbEid5;
                c00592.label = 5;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                    return obj12;
                }
                data4 = id3;
                isAnime5 = isAnime9;
                season3 = season4;
                episode3 = episode4;
                key3 = key4;
                anijson4 = anijson3;
                torrentioapiUrl10 = torrentioapiUrl9;
                torrentioapiUrl11 = provider3;
                aniResponse5 = aniResponse4;
                num = (Integer) episode3.element;
                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00592.Z$0 = isCasting2;
                c00592.Z$1 = isAnime5;
                c00592.I$0 = i3;
                c00592.I$1 = anidbEid5;
                c00592.label = 6;
                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                    return obj12;
                }
                return Boxing.boxBoolean(true);
            case 2:
                int anidbEid7 = c00592.I$1;
                int i16 = c00592.I$0;
                boolean isAnime11 = c00592.Z$1;
                boolean isCasting3 = c00592.Z$0;
                String torrentioapiUrl12 = (String) c00592.L$16;
                Integer kitsuId20 = (Integer) c00592.L$15;
                JSONObject mappings4 = (JSONObject) c00592.L$14;
                JSONObject aniJson3 = (JSONObject) c00592.L$13;
                String anijson6 = (String) c00592.L$12;
                NiceResponse aniResponse6 = (NiceResponse) c00592.L$11;
                Integer year5 = (Integer) c00592.L$10;
                String id5 = (String) c00592.L$9;
                Ref.ObjectRef episode5 = (Ref.ObjectRef) c00592.L$8;
                Integer season6 = (Integer) c00592.L$7;
                String title5 = (String) c00592.L$6;
                LoadDataTrakt dataObj20 = (LoadDataTrakt) c00592.L$5;
                String key7 = (String) c00592.L$4;
                String provider7 = (String) c00592.L$3;
                Function1<? super ExtractorLink, Unit> function21 = (Function1) c00592.L$2;
                Function1<? super SubtitleFile, Unit> function22 = (Function1) c00592.L$1;
                String data5 = (String) c00592.L$0;
                ResultKt.throwOnFailure($result);
                torraStreamTrakt = this;
                obj11 = coroutine_suspended;
                str5 = "AIO Streams";
                torrentioapiUrl2 = torrentioapiUrl12;
                mappings3 = mappings4;
                anijson3 = anijson6;
                aniResponse2 = aniResponse6;
                episode2 = episode5;
                season2 = season6;
                dataObj2 = dataObj20;
                key2 = key7;
                provider2 = provider7;
                year2 = year5;
                data2 = data5;
                obj10 = $result;
                isAnime4 = isAnime11;
                isCasting2 = isCasting3;
                aniJson2 = aniJson3;
                id2 = id5;
                function5 = function22;
                function6 = function21;
                title2 = title5;
                i2 = i16;
                kitsuId3 = kitsuId20;
                anidbEid4 = anidbEid7;
                meteorUrl = (String) obj10;
                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStreamTrakt.sharedPref, function6);
                str = key2;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    str2 = str5;
                    if (!Intrinsics.areEqual(provider2, str2)) {
                        str5 = str2;
                        anidbEid6 = anidbEid4;
                        torrentioapiUrl6 = torrentioapiUrl2;
                        Function1 filtered11 = new C00643(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                        Function1[] function1Arr13 = {new C00632(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered11};
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = function5;
                        c00592.L$2 = function6;
                        c00592.L$3 = provider2;
                        c00592.L$4 = key2;
                        c00592.L$5 = dataObj2;
                        c00592.L$6 = title2;
                        c00592.L$7 = season2;
                        c00592.L$8 = episode2;
                        c00592.L$9 = id2;
                        c00592.L$10 = year2;
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00592.L$15 = kitsuId3;
                        c00592.L$16 = torrentioapiUrl6;
                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                        c00592.L$18 = function1FilteredCallback;
                        c00592.Z$0 = isCasting2;
                        isAnime6 = isAnime4;
                        c00592.Z$1 = isAnime6;
                        function9 = function6;
                        i4 = i2;
                        c00592.I$0 = i4;
                        c00592.I$1 = anidbEid6;
                        dataObj4 = dataObj2;
                        c00592.label = 3;
                        c = 3;
                        objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr13, c00592);
                        obj12 = obj11;
                        if (objRunAllAsync == obj12) {
                            return obj12;
                        }
                        aniResponse3 = aniResponse2;
                        torrentioapiUrl7 = torrentioapiUrl6;
                        torrentioapiUrl8 = title2;
                        anidbEid5 = anidbEid6;
                        data3 = provider2;
                        function10 = function1FilteredCallback;
                        isAnime7 = isAnime6;
                        isAnime8 = isCasting2;
                        i5 = i4;
                        meteorUrl2 = meteorUrl;
                        year3 = year2;
                        kitsuId4 = kitsuId3;
                        function7 = function10;
                        i3 = i5;
                        isAnime5 = isAnime7;
                        isCasting2 = isAnime8;
                        torrentioapiUrl4 = torrentioapiUrl7;
                        title3 = torrentioapiUrl8;
                        key3 = key2;
                        torrentioapiUrl5 = id2;
                        season3 = season2;
                        episode3 = episode2;
                        function8 = function9;
                        dataObj3 = dataObj4;
                        str3 = data3;
                        if (str3 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            str4 = key3;
                            if (str4 != null) {
                                z3 = true;
                            } else {
                                z3 = true;
                            }
                            if (!z3) {
                                if (Intrinsics.areEqual(data3, str5)) {
                                    Function1<ExtractorLink, Unit> function11111111 = function7;
                                    key5 = key3;
                                    function7 = function11111111;
                                    function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function11111111, null)};
                                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00592.L$1 = function5;
                                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00592.L$7 = season3;
                                    c00592.L$8 = episode3;
                                    c00592.L$9 = torrentioapiUrl5;
                                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00592.Z$0 = isCasting2;
                                    c00592.Z$1 = isAnime5;
                                    c00592.I$0 = i3;
                                    c00592.I$1 = anidbEid5;
                                    c00592.label = 4;
                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                        return obj12;
                                    }
                                    provider4 = data3;
                                    meteorUrl3 = meteorUrl2;
                                    anijson5 = anijson3;
                                    provider5 = data2;
                                    data2 = provider5;
                                    meteorUrl2 = meteorUrl3;
                                    anijson3 = anijson5;
                                    data3 = provider4;
                                    key3 = key5;
                                }
                                Unit unit111 = Unit.INSTANCE;
                                torrentioapiUrl11 = data3;
                                kitsuId5 = kitsuId4;
                                data4 = torrentioapiUrl5;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl4;
                                aniResponse5 = aniResponse3;
                            }
                            num = (Integer) episode3.element;
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00592.Z$0 = isCasting2;
                            c00592.Z$1 = isAnime5;
                            c00592.I$0 = i3;
                            c00592.I$1 = anidbEid5;
                            c00592.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        key4 = key3;
                        function1Arr = new Function1[8];
                        torrentioapiUrl9 = torrentioapiUrl4;
                        function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                        provider3 = data3;
                        Function1<? super ExtractorLink, Unit> function11111112 = function8;
                        episode4 = episode3;
                        season4 = season3;
                        id3 = torrentioapiUrl5;
                        LoadDataTrakt dataObj1116 = dataObj3;
                        C00676 c0067116 = new C00676(dataObj1116, id3, season4, episode4, function11111112, null);
                        function8 = function11111112;
                        function1Arr[1] = c0067116;
                        aniResponse4 = aniResponse3;
                        function1Arr[2] = new C00687(dataObj1116, anidbEid5, function8, null);
                        Integer kitsuId116 = kitsuId4;
                        function1Arr[c] = new C00698(kitsuId116, season4, episode4, function7, null);
                        Function1<ExtractorLink, Unit> function11111113 = function7;
                        function7 = function11111113;
                        function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function11111113, null);
                        function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                        kitsuId5 = kitsuId116;
                        function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                        isAnime9 = isAnime5;
                        function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = function5;
                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00592.L$7 = season4;
                        c00592.L$8 = episode4;
                        c00592.L$9 = id3;
                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00592.Z$0 = isCasting2;
                        c00592.Z$1 = isAnime9;
                        c00592.I$0 = i3;
                        c00592.I$1 = anidbEid5;
                        c00592.label = 5;
                        if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                            return obj12;
                        }
                        data4 = id3;
                        isAnime5 = isAnime9;
                        season3 = season4;
                        episode3 = episode4;
                        key3 = key4;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl9;
                        torrentioapiUrl11 = provider3;
                        aniResponse5 = aniResponse4;
                        num = (Integer) episode3.element;
                        c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                        c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                        c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                        c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                        c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                        c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                        c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                        c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                        c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00592.Z$0 = isCasting2;
                        c00592.Z$1 = isAnime5;
                        c00592.I$0 = i3;
                        c00592.I$1 = anidbEid5;
                        c00592.label = 6;
                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                            return obj12;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    torrentioapiUrl3 = torrentioapiUrl2;
                    str5 = str2;
                } else {
                    torrentioapiUrl3 = torrentioapiUrl2;
                }
                obj12 = obj11;
                int i17 = i2;
                c = 3;
                LoadDataTrakt dataObj1117 = dataObj2;
                aniResponse3 = aniResponse2;
                title3 = title2;
                year3 = year2;
                kitsuId4 = kitsuId3;
                function7 = function1FilteredCallback;
                i3 = i17;
                torrentioapiUrl4 = torrentioapiUrl3;
                meteorUrl2 = meteorUrl;
                anidbEid5 = anidbEid4;
                data3 = provider2;
                isAnime5 = isAnime4;
                key3 = key2;
                torrentioapiUrl5 = id2;
                episode3 = episode2;
                dataObj3 = dataObj1117;
                season3 = season2;
                function8 = function6;
                str3 = data3;
                if (str3 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    str4 = key3;
                    if (str4 != null) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        if (Intrinsics.areEqual(data3, str5)) {
                            Function1<ExtractorLink, Unit> function11111114 = function7;
                            key5 = key3;
                            function7 = function11111114;
                            function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function11111114, null)};
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = function5;
                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00592.L$7 = season3;
                            c00592.L$8 = episode3;
                            c00592.L$9 = torrentioapiUrl5;
                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00592.Z$0 = isCasting2;
                            c00592.Z$1 = isAnime5;
                            c00592.I$0 = i3;
                            c00592.I$1 = anidbEid5;
                            c00592.label = 4;
                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                return obj12;
                            }
                            provider4 = data3;
                            meteorUrl3 = meteorUrl2;
                            anijson5 = anijson3;
                            provider5 = data2;
                            data2 = provider5;
                            meteorUrl2 = meteorUrl3;
                            anijson3 = anijson5;
                            data3 = provider4;
                            key3 = key5;
                        }
                        Unit unit112 = Unit.INSTANCE;
                        torrentioapiUrl11 = data3;
                        kitsuId5 = kitsuId4;
                        data4 = torrentioapiUrl5;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl4;
                        aniResponse5 = aniResponse3;
                    }
                    num = (Integer) episode3.element;
                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                    c00592.Z$0 = isCasting2;
                    c00592.Z$1 = isAnime5;
                    c00592.I$0 = i3;
                    c00592.I$1 = anidbEid5;
                    c00592.label = 6;
                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                        return obj12;
                    }
                    return Boxing.boxBoolean(true);
                }
                key4 = key3;
                function1Arr = new Function1[8];
                torrentioapiUrl9 = torrentioapiUrl4;
                function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                provider3 = data3;
                Function1<? super ExtractorLink, Unit> function11111115 = function8;
                episode4 = episode3;
                season4 = season3;
                id3 = torrentioapiUrl5;
                LoadDataTrakt dataObj1118 = dataObj3;
                C00676 c0067117 = new C00676(dataObj1118, id3, season4, episode4, function11111115, null);
                function8 = function11111115;
                function1Arr[1] = c0067117;
                aniResponse4 = aniResponse3;
                function1Arr[2] = new C00687(dataObj1118, anidbEid5, function8, null);
                Integer kitsuId117 = kitsuId4;
                function1Arr[c] = new C00698(kitsuId117, season4, episode4, function7, null);
                Function1<ExtractorLink, Unit> function11111116 = function7;
                function7 = function11111116;
                function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function11111116, null);
                function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                kitsuId5 = kitsuId117;
                function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                isAnime9 = isAnime5;
                function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00592.L$1 = function5;
                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00592.L$7 = season4;
                c00592.L$8 = episode4;
                c00592.L$9 = id3;
                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00592.Z$0 = isCasting2;
                c00592.Z$1 = isAnime9;
                c00592.I$0 = i3;
                c00592.I$1 = anidbEid5;
                c00592.label = 5;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                    return obj12;
                }
                data4 = id3;
                isAnime5 = isAnime9;
                season3 = season4;
                episode3 = episode4;
                key3 = key4;
                anijson4 = anijson3;
                torrentioapiUrl10 = torrentioapiUrl9;
                torrentioapiUrl11 = provider3;
                aniResponse5 = aniResponse4;
                num = (Integer) episode3.element;
                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00592.Z$0 = isCasting2;
                c00592.Z$1 = isAnime5;
                c00592.I$0 = i3;
                c00592.I$1 = anidbEid5;
                c00592.label = 6;
                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                    return obj12;
                }
                return Boxing.boxBoolean(true);
            case 3:
                int anidbEid8 = c00592.I$1;
                i5 = c00592.I$0;
                isAnime7 = c00592.Z$1;
                isAnime8 = c00592.Z$0;
                Function1<ExtractorLink, Unit> function23 = (Function1) c00592.L$18;
                String meteorUrl4 = (String) c00592.L$17;
                String torrentioapiUrl13 = (String) c00592.L$16;
                kitsuId3 = (Integer) c00592.L$15;
                JSONObject mappings5 = (JSONObject) c00592.L$14;
                JSONObject aniJson4 = (JSONObject) c00592.L$13;
                String anijson7 = (String) c00592.L$12;
                NiceResponse aniResponse7 = (NiceResponse) c00592.L$11;
                Integer year6 = (Integer) c00592.L$10;
                String id6 = (String) c00592.L$9;
                Ref.ObjectRef episode6 = (Ref.ObjectRef) c00592.L$8;
                Integer season7 = (Integer) c00592.L$7;
                torrentioapiUrl8 = (String) c00592.L$6;
                LoadDataTrakt dataObj21 = (LoadDataTrakt) c00592.L$5;
                String key8 = (String) c00592.L$4;
                String provider8 = (String) c00592.L$3;
                Function1<? super ExtractorLink, Unit> function24 = (Function1) c00592.L$2;
                Function1<? super SubtitleFile, Unit> function25 = (Function1) c00592.L$1;
                String data6 = (String) c00592.L$0;
                ResultKt.throwOnFailure($result);
                anidbEid5 = anidbEid8;
                anijson3 = anijson7;
                function9 = function24;
                obj12 = coroutine_suspended;
                str5 = "AIO Streams";
                mappings3 = mappings5;
                function10 = function23;
                meteorUrl2 = meteorUrl4;
                torrentioapiUrl7 = torrentioapiUrl13;
                aniResponse3 = aniResponse7;
                year2 = year6;
                id2 = id6;
                episode2 = episode6;
                season2 = season7;
                dataObj4 = dataObj21;
                c = 3;
                function5 = function25;
                data2 = data6;
                aniJson2 = aniJson4;
                key2 = key8;
                data3 = provider8;
                year3 = year2;
                kitsuId4 = kitsuId3;
                function7 = function10;
                i3 = i5;
                isAnime5 = isAnime7;
                isCasting2 = isAnime8;
                torrentioapiUrl4 = torrentioapiUrl7;
                title3 = torrentioapiUrl8;
                key3 = key2;
                torrentioapiUrl5 = id2;
                season3 = season2;
                episode3 = episode2;
                function8 = function9;
                dataObj3 = dataObj4;
                str3 = data3;
                if (str3 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    str4 = key3;
                    if (str4 != null) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        if (Intrinsics.areEqual(data3, str5)) {
                            Function1<ExtractorLink, Unit> function11111117 = function7;
                            key5 = key3;
                            function7 = function11111117;
                            function1Arr2 = new Function1[]{new C00654(key3, torrentioapiUrl5, season3, episode3, function11111117, null)};
                            c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00592.L$1 = function5;
                            c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00592.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                            c00592.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                            c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00592.L$7 = season3;
                            c00592.L$8 = episode3;
                            c00592.L$9 = torrentioapiUrl5;
                            c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                            c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                            c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                            c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00592.Z$0 = isCasting2;
                            c00592.Z$1 = isAnime5;
                            c00592.I$0 = i3;
                            c00592.I$1 = anidbEid5;
                            c00592.label = 4;
                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00592) == obj12) {
                                return obj12;
                            }
                            provider4 = data3;
                            meteorUrl3 = meteorUrl2;
                            anijson5 = anijson3;
                            provider5 = data2;
                            data2 = provider5;
                            meteorUrl2 = meteorUrl3;
                            anijson3 = anijson5;
                            data3 = provider4;
                            key3 = key5;
                        }
                        Unit unit113 = Unit.INSTANCE;
                        torrentioapiUrl11 = data3;
                        kitsuId5 = kitsuId4;
                        data4 = torrentioapiUrl5;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl4;
                        aniResponse5 = aniResponse3;
                    }
                    num = (Integer) episode3.element;
                    c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                    c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                    c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                    c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                    c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                    c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                    c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                    c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                    c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                    c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                    c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                    c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                    c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                    c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                    c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                    c00592.Z$0 = isCasting2;
                    c00592.Z$1 = isAnime5;
                    c00592.I$0 = i3;
                    c00592.I$1 = anidbEid5;
                    c00592.label = 6;
                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                        return obj12;
                    }
                    return Boxing.boxBoolean(true);
                }
                key4 = key3;
                function1Arr = new Function1[8];
                torrentioapiUrl9 = torrentioapiUrl4;
                function1Arr[0] = new C00665(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                provider3 = data3;
                Function1<? super ExtractorLink, Unit> function11111118 = function8;
                episode4 = episode3;
                season4 = season3;
                id3 = torrentioapiUrl5;
                LoadDataTrakt dataObj1119 = dataObj3;
                C00676 c0067118 = new C00676(dataObj1119, id3, season4, episode4, function11111118, null);
                function8 = function11111118;
                function1Arr[1] = c0067118;
                aniResponse4 = aniResponse3;
                function1Arr[2] = new C00687(dataObj1119, anidbEid5, function8, null);
                Integer kitsuId118 = kitsuId4;
                function1Arr[c] = new C00698(kitsuId118, season4, episode4, function7, null);
                Function1<ExtractorLink, Unit> function11111119 = function7;
                function7 = function11111119;
                function1Arr[4] = new C00709(dataObj3, title3, year3, season4, episode4, function11111119, null);
                function1Arr[5] = new C006010(id3, season4, episode4, function8, null);
                kitsuId5 = kitsuId118;
                function1Arr[6] = new C006111(dataObj3, kitsuId5, season4, episode4, function7, null);
                isAnime9 = isAnime5;
                function1Arr[7] = new C006212(isAnime9, title3, year3, season4, episode4, function7, null);
                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00592.L$1 = function5;
                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00592.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00592.L$7 = season4;
                c00592.L$8 = episode4;
                c00592.L$9 = id3;
                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00592.Z$0 = isCasting2;
                c00592.Z$1 = isAnime9;
                c00592.I$0 = i3;
                c00592.I$1 = anidbEid5;
                c00592.label = 5;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00592) == obj12) {
                    return obj12;
                }
                data4 = id3;
                isAnime5 = isAnime9;
                season3 = season4;
                episode3 = episode4;
                key3 = key4;
                anijson4 = anijson3;
                torrentioapiUrl10 = torrentioapiUrl9;
                torrentioapiUrl11 = provider3;
                aniResponse5 = aniResponse4;
                num = (Integer) episode3.element;
                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00592.Z$0 = isCasting2;
                c00592.Z$1 = isAnime5;
                c00592.I$0 = i3;
                c00592.I$1 = anidbEid5;
                c00592.label = 6;
                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                    return obj12;
                }
                return Boxing.boxBoolean(true);
            case 4:
                int anidbEid9 = c00592.I$1;
                i3 = c00592.I$0;
                isAnime5 = c00592.Z$1;
                isCasting2 = c00592.Z$0;
                Function1<ExtractorLink, Unit> function26 = (Function1) c00592.L$18;
                meteorUrl3 = (String) c00592.L$17;
                String torrentioapiUrl14 = (String) c00592.L$16;
                Integer kitsuId21 = (Integer) c00592.L$15;
                JSONObject mappings6 = (JSONObject) c00592.L$14;
                JSONObject aniJson5 = (JSONObject) c00592.L$13;
                anijson5 = (String) c00592.L$12;
                NiceResponse aniResponse8 = (NiceResponse) c00592.L$11;
                Integer year7 = (Integer) c00592.L$10;
                String id7 = (String) c00592.L$9;
                Ref.ObjectRef episode7 = (Ref.ObjectRef) c00592.L$8;
                Integer season8 = (Integer) c00592.L$7;
                String title6 = (String) c00592.L$6;
                LoadDataTrakt dataObj22 = (LoadDataTrakt) c00592.L$5;
                String key9 = (String) c00592.L$4;
                provider4 = (String) c00592.L$3;
                Function1<? super ExtractorLink, Unit> function27 = (Function1) c00592.L$2;
                Function1<? super SubtitleFile, Unit> function28 = (Function1) c00592.L$1;
                provider5 = (String) c00592.L$0;
                ResultKt.throwOnFailure($result);
                aniResponse3 = aniResponse8;
                obj12 = coroutine_suspended;
                function7 = function26;
                torrentioapiUrl4 = torrentioapiUrl14;
                kitsuId4 = kitsuId21;
                year3 = year7;
                torrentioapiUrl5 = id7;
                season3 = season8;
                title3 = title6;
                dataObj3 = dataObj22;
                function5 = function28;
                mappings3 = mappings6;
                aniJson2 = aniJson5;
                anidbEid5 = anidbEid9;
                episode3 = episode7;
                key5 = key9;
                function8 = function27;
                data2 = provider5;
                meteorUrl2 = meteorUrl3;
                anijson3 = anijson5;
                data3 = provider4;
                key3 = key5;
                Unit unit114 = Unit.INSTANCE;
                torrentioapiUrl11 = data3;
                kitsuId5 = kitsuId4;
                data4 = torrentioapiUrl5;
                anijson4 = anijson3;
                torrentioapiUrl10 = torrentioapiUrl4;
                aniResponse5 = aniResponse3;
                num = (Integer) episode3.element;
                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00592.Z$0 = isCasting2;
                c00592.Z$1 = isAnime5;
                c00592.I$0 = i3;
                c00592.I$1 = anidbEid5;
                c00592.label = 6;
                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                    return obj12;
                }
                return Boxing.boxBoolean(true);
            case 5:
                int anidbEid10 = c00592.I$1;
                i3 = c00592.I$0;
                isAnime5 = c00592.Z$1;
                boolean isCasting4 = c00592.Z$0;
                Function1<ExtractorLink, Unit> function29 = (Function1) c00592.L$18;
                String meteorUrl5 = (String) c00592.L$17;
                String torrentioapiUrl15 = (String) c00592.L$16;
                Integer kitsuId22 = (Integer) c00592.L$15;
                JSONObject mappings7 = (JSONObject) c00592.L$14;
                JSONObject aniJson6 = (JSONObject) c00592.L$13;
                String anijson8 = (String) c00592.L$12;
                NiceResponse aniResponse9 = (NiceResponse) c00592.L$11;
                Integer year8 = (Integer) c00592.L$10;
                String id8 = (String) c00592.L$9;
                Ref.ObjectRef episode8 = (Ref.ObjectRef) c00592.L$8;
                Integer season9 = (Integer) c00592.L$7;
                String title7 = (String) c00592.L$6;
                LoadDataTrakt dataObj23 = (LoadDataTrakt) c00592.L$5;
                String key10 = (String) c00592.L$4;
                torrentioapiUrl11 = (String) c00592.L$3;
                Function1<? super ExtractorLink, Unit> function30 = (Function1) c00592.L$2;
                Function1<? super SubtitleFile, Unit> function31 = (Function1) c00592.L$1;
                String data7 = (String) c00592.L$0;
                ResultKt.throwOnFailure($result);
                data2 = data7;
                obj12 = coroutine_suspended;
                function7 = function29;
                meteorUrl2 = meteorUrl5;
                torrentioapiUrl10 = torrentioapiUrl15;
                kitsuId5 = kitsuId22;
                year3 = year8;
                data4 = id8;
                episode3 = episode8;
                season3 = season9;
                title3 = title7;
                dataObj3 = dataObj23;
                key3 = key10;
                aniResponse5 = aniResponse9;
                mappings3 = mappings7;
                aniJson2 = aniJson6;
                anidbEid5 = anidbEid10;
                function8 = function30;
                anijson4 = anijson8;
                isCasting2 = isCasting4;
                function5 = function31;
                num = (Integer) episode3.element;
                c00592.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00592.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c00592.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00592.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                c00592.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                c00592.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00592.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00592.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                c00592.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                c00592.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                c00592.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00592.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                c00592.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                c00592.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00592.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00592.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00592.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                c00592.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00592.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00592.Z$0 = isCasting2;
                c00592.Z$1 = isAnime5;
                c00592.I$0 = i3;
                c00592.I$1 = anidbEid5;
                c00592.label = 6;
                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00592) == obj12) {
                    return obj12;
                }
                return Boxing.boxBoolean(true);
            case 6:
                int i18 = c00592.I$1;
                int i19 = c00592.I$0;
                boolean z4 = c00592.Z$1;
                boolean z5 = c00592.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$2 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt$loadLinks$2", f = "TorraStreamTrakt.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00632 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ String $id;
        final /* synthetic */ Integer $season;
        final /* synthetic */ String $torrentioapiUrl;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00632(String str, String str2, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00632> continuation) {
            super(1, continuation);
            this.$torrentioapiUrl = str;
            this.$id = str2;
            this.$season = num;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00632(this.$torrentioapiUrl, this.$id, this.$season, this.$episode, this.$filtered, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (TorraStreamExtractorKt.invokeTorrentioDebian(this.$torrentioapiUrl, this.$id, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$3 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt$loadLinks$3", f = "TorraStreamTrakt.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00643 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ String $id;
        final /* synthetic */ String $meteorUrl;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00643(String str, String str2, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00643> continuation) {
            super(1, continuation);
            this.$meteorUrl = str;
            this.$id = str2;
            this.$season = num;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00643(this.$meteorUrl, this.$id, this.$season, this.$episode, this.$filtered, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (TorraStreamExtractorKt.invokeMeteorDebian(this.$meteorUrl, this.$id, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$4 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt$loadLinks$4", f = "TorraStreamTrakt.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00654 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ String $id;
        final /* synthetic */ String $key;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00654(String str, String str2, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00654> continuation) {
            super(1, continuation);
            this.$key = str;
            this.$id = str2;
            this.$season = num;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00654(this.$key, this.$id, this.$season, this.$episode, this.$filtered, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (TorraStreamExtractorKt.invokeAIOStreamsDebian(this.$key, this.$id, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$5 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt$loadLinks$5", f = "TorraStreamTrakt.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00665 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ String $id;
        final /* synthetic */ Integer $season;
        final /* synthetic */ String $torrentioapiUrl;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00665(String str, String str2, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00665> continuation) {
            super(1, continuation);
            this.$torrentioapiUrl = str;
            this.$id = str2;
            this.$season = num;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00665(this.$torrentioapiUrl, this.$id, this.$season, this.$episode, this.$filtered, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (TorraStreamExtractorKt.invokeTorrentio(this.$torrentioapiUrl, this.$id, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$6 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt$loadLinks$6", f = "TorraStreamTrakt.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, nl = {90}, s = {}, v = 2)
    static final class C00676 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadDataTrakt $dataObj;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ String $id;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00676(LoadDataTrakt loadDataTrakt, String str, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00676> continuation) {
            super(1, continuation);
            this.$dataObj = loadDataTrakt;
            this.$id = str;
            this.$season = num;
            this.$episode = objectRef;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00676(this.$dataObj, this.$id, this.$season, this.$episode, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (!this.$dataObj.is_anime()) {
                        this.label = 1;
                        if (TorraStreamExtractorKt.invokeThepiratebay(TorraStream.ThePirateBayApi, this.$id, this.$season, (Integer) this.$episode.element, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$7 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt$loadLinks$7", f = "TorraStreamTrakt.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00687 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $anidbEid;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadDataTrakt $dataObj;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00687(LoadDataTrakt loadDataTrakt, int i, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00687> continuation) {
            super(1, continuation);
            this.$dataObj = loadDataTrakt;
            this.$anidbEid = i;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00687(this.$dataObj, this.$anidbEid, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$dataObj.is_anime()) {
                        this.label = 1;
                        if (TorraStreamExtractorKt.invokeAnimetosho(Boxing.boxInt(this.$anidbEid), this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$8 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt$loadLinks$8", f = "TorraStreamTrakt.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00698 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Integer $kitsuId;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00698(Integer num, Integer num2, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00698> continuation) {
            super(1, continuation);
            this.$kitsuId = num;
            this.$season = num2;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00698(this.$kitsuId, this.$season, this.$episode, this.$filtered, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (TorraStreamExtractorKt.invokeTorrentioAnime(TorraStream.TorrentioAnimeAPI, this.$kitsuId, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$9 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt$loadLinks$9", f = "TorraStreamTrakt.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, nl = {102}, s = {}, v = 2)
    static final class C00709 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadDataTrakt $dataObj;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Integer $season;
        final /* synthetic */ String $title;
        final /* synthetic */ Integer $year;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00709(LoadDataTrakt loadDataTrakt, String str, Integer num, Integer num2, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00709> continuation) {
            super(1, continuation);
            this.$dataObj = loadDataTrakt;
            this.$title = str;
            this.$year = num;
            this.$season = num2;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00709(this.$dataObj, this.$title, this.$year, this.$season, this.$episode, this.$filtered, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (!this.$dataObj.is_anime()) {
                        this.label = 1;
                        if (TorraStreamExtractorKt.invokeUindex(TorraStream.Uindex, this.$title, this.$year, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$10 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt$loadLinks$10", f = "TorraStreamTrakt.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C006010 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ String $id;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C006010(String str, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C006010> continuation) {
            super(1, continuation);
            this.$id = str;
            this.$season = num;
            this.$episode = objectRef;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C006010(this.$id, this.$season, this.$episode, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (TorraStreamExtractorKt.invokeTorrentsDB(TorraStream.TorrentsDB, this.$id, this.$season, (Integer) this.$episode.element, this.$callback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$11 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt$loadLinks$11", f = "TorraStreamTrakt.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, nl = {112}, s = {}, v = 2)
    static final class C006111 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadDataTrakt $dataObj;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Integer $kitsuId;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C006111(LoadDataTrakt loadDataTrakt, Integer num, Integer num2, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C006111> continuation) {
            super(1, continuation);
            this.$dataObj = loadDataTrakt;
            this.$kitsuId = num;
            this.$season = num2;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C006111(this.$dataObj, this.$kitsuId, this.$season, this.$episode, this.$filtered, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$dataObj.is_anime()) {
                        this.label = 1;
                        if (TorraStreamExtractorKt.invokeTorrentsDBAnime(TorraStream.TorrentsDB, this.$kitsuId, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamTrakt$loadLinks$12 */
    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamTrakt$loadLinks$12", f = "TorraStreamTrakt.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C006212 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ boolean $isAnime;
        final /* synthetic */ Integer $season;
        final /* synthetic */ String $title;
        final /* synthetic */ Integer $year;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C006212(boolean z, String str, Integer num, Integer num2, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C006212> continuation) {
            super(1, continuation);
            this.$isAnime = z;
            this.$title = str;
            this.$year = num;
            this.$season = num2;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C006212(this.$isAnime, this.$title, this.$year, this.$season, this.$episode, this.$filtered, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (TorraStreamExtractorKt.invokeKnaben(TorraStream.Knaben, this.$isAnime, this.$title, this.$year, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    private final String buildTorrentioApiUrl(SharedPreferences sharedPref, String mainUrl) {
        String sort = sharedPref.getString("sort", "qualitysize");
        String languageOption = sharedPref.getString("language", "");
        String qualityFilter = sharedPref.getString("qualityfilter", "");
        String limit = sharedPref.getString("limit", "");
        String sizeFilter = sharedPref.getString("sizefilter", "");
        String debridProvider = sharedPref.getString("debrid_provider", "");
        String debridKey = sharedPref.getString("debrid_key", "");
        List params = new ArrayList();
        String str = sort;
        if (!(str == null || str.length() == 0)) {
            params.add("sort=" + sort);
        }
        String str2 = languageOption;
        if (!(str2 == null || str2.length() == 0)) {
            StringBuilder sbAppend = new StringBuilder().append("language=");
            String lowerCase = languageOption.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            params.add(sbAppend.append(lowerCase).toString());
        }
        String str3 = qualityFilter;
        if (!(str3 == null || str3.length() == 0)) {
            params.add("qualityfilter=" + qualityFilter);
        }
        String str4 = limit;
        if (!(str4 == null || str4.length() == 0)) {
            params.add("limit=" + limit);
        }
        String str5 = sizeFilter;
        if (!(str5 == null || str5.length() == 0)) {
            params.add("sizefilter=" + sizeFilter);
        }
        String str6 = debridProvider;
        if (!(str6 == null || str6.length() == 0)) {
            String str7 = debridKey;
            if (!(str7 == null || str7.length() == 0)) {
                params.add(debridProvider + '=' + debridKey);
            }
        }
        String query = CollectionsKt.joinToString$default(params, "%7C", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return mainUrl + '/' + query;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x017c  */
    /* JADX WARN: Code duplicated, block: B:44:0x0181  */
    /* JADX WARN: Code duplicated, block: B:47:0x0193  */
    /* JADX WARN: Code duplicated, block: B:48:0x0198  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public final Object buildMeteorUrl(@NotNull SharedPreferences sharedPref, @NotNull String baseUrl, @NotNull Continuation<? super String> continuation) throws JSONException {
        C00581 c00581;
        String debridProvider;
        String debridKey;
        String limit;
        String sizeFilter;
        JSONArray preferredLanguages;
        SharedPreferences sharedPref2;
        String baseUrl2;
        int i;
        Integer intOrNull;
        int iIntValue;
        Integer intOrNull2;
        int iIntValue2;
        if (continuation instanceof C00581) {
            c00581 = (C00581) continuation;
            if ((c00581.label & Integer.MIN_VALUE) != 0) {
                c00581.label -= Integer.MIN_VALUE;
            } else {
                c00581 = new C00581(continuation);
            }
        } else {
            c00581 = new C00581(continuation);
        }
        Object $result = c00581.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00581.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String string = sharedPref.getString("debrid_provider", "");
                if (string == null) {
                    string = "";
                }
                debridProvider = string;
                String string2 = sharedPref.getString("debrid_key", "");
                if (string2 == null) {
                    string2 = "";
                }
                debridKey = string2;
                String string3 = sharedPref.getString("language", "");
                String languagesPref = string3 != null ? string3 : "";
                String string4 = sharedPref.getString("limit", "0");
                if (string4 == null) {
                    string4 = "0";
                }
                limit = string4;
                String string5 = sharedPref.getString("sizefilter", "0");
                sizeFilter = string5 != null ? string5 : "0";
                preferredLanguages = new JSONArray();
                if (languagesPref.length() > 0) {
                    List listSplit$default = StringsKt.split$default(languagesPref, new String[]{","}, false, 0, 6, (Object) null);
                    TorraStreamTrakt$buildMeteorUrl$preferredLanguages$1$1 torraStreamTrakt$buildMeteorUrl$preferredLanguages$1$1 = new TorraStreamTrakt$buildMeteorUrl$preferredLanguages$1$1(preferredLanguages, null);
                    c00581.L$0 = SpillingKt.nullOutSpilledVariable(sharedPref);
                    c00581.L$1 = baseUrl;
                    c00581.L$2 = debridProvider;
                    c00581.L$3 = debridKey;
                    c00581.L$4 = SpillingKt.nullOutSpilledVariable(languagesPref);
                    c00581.L$5 = limit;
                    c00581.L$6 = sizeFilter;
                    c00581.L$7 = preferredLanguages;
                    c00581.L$8 = SpillingKt.nullOutSpilledVariable(preferredLanguages);
                    c00581.label = 1;
                    if (ParCollectionsKt.amap(listSplit$default, torraStreamTrakt$buildMeteorUrl$preferredLanguages$1$1, c00581) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sharedPref2 = sharedPref;
                    baseUrl2 = baseUrl;
                    i = 0;
                } else {
                    preferredLanguages.put("en");
                    preferredLanguages.put("multi");
                    sharedPref2 = sharedPref;
                    baseUrl2 = baseUrl;
                }
                JSONObject languages = new JSONObject();
                languages.put("preferred", preferredLanguages);
                languages.put("required", new JSONArray());
                languages.put("exclude", new JSONArray());
                JSONObject $this$buildMeteorUrl_u24lambda_u242 = new JSONObject();
                Object lowerCase = debridProvider.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                $this$buildMeteorUrl_u24lambda_u242.put("debridService", lowerCase);
                $this$buildMeteorUrl_u24lambda_u242.put("debridApiKey", debridKey);
                $this$buildMeteorUrl_u24lambda_u242.put("cachedOnly", false);
                $this$buildMeteorUrl_u24lambda_u242.put("removeTrash", true);
                $this$buildMeteorUrl_u24lambda_u242.put("removeSamples", true);
                $this$buildMeteorUrl_u24lambda_u242.put("removeAdult", false);
                $this$buildMeteorUrl_u24lambda_u242.put("exclude3D", false);
                $this$buildMeteorUrl_u24lambda_u242.put("enableSeaDex", false);
                $this$buildMeteorUrl_u24lambda_u242.put("minSeeders", 0);
                intOrNull = StringsKt.toIntOrNull(limit);
                if (intOrNull != null) {
                    iIntValue = intOrNull.intValue();
                } else {
                    iIntValue = 0;
                }
                $this$buildMeteorUrl_u24lambda_u242.put("maxResults", iIntValue);
                $this$buildMeteorUrl_u24lambda_u242.put("maxResultsPerRes", 0);
                intOrNull2 = StringsKt.toIntOrNull(sizeFilter);
                if (intOrNull2 != null) {
                    iIntValue2 = intOrNull2.intValue();
                } else {
                    iIntValue2 = 0;
                }
                $this$buildMeteorUrl_u24lambda_u242.put("maxSize", iIntValue2);
                $this$buildMeteorUrl_u24lambda_u242.put("resolutions", new JSONArray());
                $this$buildMeteorUrl_u24lambda_u242.put("languages", languages);
                JSONArray $this$buildMeteorUrl_u24lambda_u242_u240 = new JSONArray();
                $this$buildMeteorUrl_u24lambda_u242_u240.put("title");
                $this$buildMeteorUrl_u24lambda_u242_u240.put("quality");
                $this$buildMeteorUrl_u24lambda_u242_u240.put("size");
                $this$buildMeteorUrl_u24lambda_u242_u240.put("audio");
                Unit unit = Unit.INSTANCE;
                $this$buildMeteorUrl_u24lambda_u242.put("resultFormat", $this$buildMeteorUrl_u24lambda_u242_u240);
                JSONArray $this$buildMeteorUrl_u24lambda_u242_u241 = new JSONArray();
                $this$buildMeteorUrl_u24lambda_u242_u241.put("cached");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("resolution");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("quality");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("seeders");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("size");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("pack");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("language");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("seadex");
                Unit unit2 = Unit.INSTANCE;
                $this$buildMeteorUrl_u24lambda_u242.put("sortOrder", $this$buildMeteorUrl_u24lambda_u242_u241);
                byte[] bytes = $this$buildMeteorUrl_u24lambda_u242.toString().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                String encoded = Base64.encodeToString(bytes, 10);
                return baseUrl2 + '/' + encoded;
            case 1:
                i = 0;
                preferredLanguages = (JSONArray) c00581.L$7;
                sizeFilter = (String) c00581.L$6;
                limit = (String) c00581.L$5;
                debridKey = (String) c00581.L$3;
                debridProvider = (String) c00581.L$2;
                baseUrl2 = (String) c00581.L$1;
                sharedPref2 = (SharedPreferences) c00581.L$0;
                ResultKt.throwOnFailure($result);
                JSONObject languages2 = new JSONObject();
                languages2.put("preferred", preferredLanguages);
                languages2.put("required", new JSONArray());
                languages2.put("exclude", new JSONArray());
                JSONObject $this$buildMeteorUrl_u24lambda_u243 = new JSONObject();
                Object lowerCase2 = debridProvider.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                $this$buildMeteorUrl_u24lambda_u243.put("debridService", lowerCase2);
                $this$buildMeteorUrl_u24lambda_u243.put("debridApiKey", debridKey);
                $this$buildMeteorUrl_u24lambda_u243.put("cachedOnly", false);
                $this$buildMeteorUrl_u24lambda_u243.put("removeTrash", true);
                $this$buildMeteorUrl_u24lambda_u243.put("removeSamples", true);
                $this$buildMeteorUrl_u24lambda_u243.put("removeAdult", false);
                $this$buildMeteorUrl_u24lambda_u243.put("exclude3D", false);
                $this$buildMeteorUrl_u24lambda_u243.put("enableSeaDex", false);
                $this$buildMeteorUrl_u24lambda_u243.put("minSeeders", 0);
                intOrNull = StringsKt.toIntOrNull(limit);
                if (intOrNull != null) {
                    iIntValue = intOrNull.intValue();
                } else {
                    iIntValue = 0;
                }
                $this$buildMeteorUrl_u24lambda_u243.put("maxResults", iIntValue);
                $this$buildMeteorUrl_u24lambda_u243.put("maxResultsPerRes", 0);
                intOrNull2 = StringsKt.toIntOrNull(sizeFilter);
                if (intOrNull2 != null) {
                    iIntValue2 = intOrNull2.intValue();
                } else {
                    iIntValue2 = 0;
                }
                $this$buildMeteorUrl_u24lambda_u243.put("maxSize", iIntValue2);
                $this$buildMeteorUrl_u24lambda_u243.put("resolutions", new JSONArray());
                $this$buildMeteorUrl_u24lambda_u243.put("languages", languages2);
                JSONArray $this$buildMeteorUrl_u24lambda_u242_u242 = new JSONArray();
                $this$buildMeteorUrl_u24lambda_u242_u242.put("title");
                $this$buildMeteorUrl_u24lambda_u242_u242.put("quality");
                $this$buildMeteorUrl_u24lambda_u242_u242.put("size");
                $this$buildMeteorUrl_u24lambda_u242_u242.put("audio");
                Unit unit3 = Unit.INSTANCE;
                $this$buildMeteorUrl_u24lambda_u243.put("resultFormat", $this$buildMeteorUrl_u24lambda_u242_u242);
                JSONArray $this$buildMeteorUrl_u24lambda_u242_u243 = new JSONArray();
                $this$buildMeteorUrl_u24lambda_u242_u243.put("cached");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("resolution");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("quality");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("seeders");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("size");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("pack");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("language");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("seadex");
                Unit unit4 = Unit.INSTANCE;
                $this$buildMeteorUrl_u24lambda_u243.put("sortOrder", $this$buildMeteorUrl_u24lambda_u242_u243);
                byte[] bytes2 = $this$buildMeteorUrl_u24lambda_u243.toString().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                String encoded2 = Base64.encodeToString(bytes2, 10);
                return baseUrl2 + '/' + encoded2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: TorraStreamTrakt.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010JT\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Lcom/phisher98/TorraStreamTrakt$LoadDataTrakt;", "", "title", "", "year", "", "is_anime", "", "imdb_id", "season", "episode", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", "getYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "getImdb_id", "getSeason", "getEpisode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/TorraStreamTrakt$LoadDataTrakt;", "equals", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LoadDataTrakt {

        @Nullable
        private final Integer episode;

        @Nullable
        private final String imdb_id;
        private final boolean is_anime;

        @Nullable
        private final Integer season;

        @Nullable
        private final String title;

        @Nullable
        private final Integer year;

        public LoadDataTrakt() {
            this(null, null, false, null, null, null, 63, null);
        }

        public static /* synthetic */ LoadDataTrakt copy$default(LoadDataTrakt loadDataTrakt, String str, Integer num, boolean z, String str2, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadDataTrakt.title;
            }
            if ((i & 2) != 0) {
                num = loadDataTrakt.year;
            }
            if ((i & 4) != 0) {
                z = loadDataTrakt.is_anime;
            }
            if ((i & 8) != 0) {
                str2 = loadDataTrakt.imdb_id;
            }
            if ((i & 16) != 0) {
                num2 = loadDataTrakt.season;
            }
            if ((i & 32) != 0) {
                num3 = loadDataTrakt.episode;
            }
            Integer num4 = num2;
            Integer num5 = num3;
            return loadDataTrakt.copy(str, num, z, str2, num4, num5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIs_anime() {
            return this.is_anime;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @NotNull
        public final LoadDataTrakt copy(@Nullable String title, @Nullable Integer year, boolean is_anime, @Nullable String imdb_id, @Nullable Integer season, @Nullable Integer episode) {
            return new LoadDataTrakt(title, year, is_anime, imdb_id, season, episode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadDataTrakt)) {
                return false;
            }
            LoadDataTrakt loadDataTrakt = (LoadDataTrakt) other;
            return Intrinsics.areEqual(this.title, loadDataTrakt.title) && Intrinsics.areEqual(this.year, loadDataTrakt.year) && this.is_anime == loadDataTrakt.is_anime && Intrinsics.areEqual(this.imdb_id, loadDataTrakt.imdb_id) && Intrinsics.areEqual(this.season, loadDataTrakt.season) && Intrinsics.areEqual(this.episode, loadDataTrakt.episode);
        }

        public int hashCode() {
            return ((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + TorraStreamTrakt$LoadDataTrakt$$ExternalSyntheticBackport0.m10m(this.is_anime)) * 31) + (this.imdb_id == null ? 0 : this.imdb_id.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode != null ? this.episode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LoadDataTrakt(title=" + this.title + ", year=" + this.year + ", is_anime=" + this.is_anime + ", imdb_id=" + this.imdb_id + ", season=" + this.season + ", episode=" + this.episode + ')';
        }

        public LoadDataTrakt(@Nullable String title, @Nullable Integer year, boolean is_anime, @Nullable String imdb_id, @Nullable Integer season, @Nullable Integer episode) {
            this.title = title;
            this.year = year;
            this.is_anime = is_anime;
            this.imdb_id = imdb_id;
            this.season = season;
            this.episode = episode;
        }

        public /* synthetic */ LoadDataTrakt(String str, Integer num, boolean z, String str2, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3);
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        public final boolean is_anime() {
            return this.is_anime;
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }
    }
}
