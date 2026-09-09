package com.cncverse;

import android.content.Context;
import com.cncverse.donation.DonationManager;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.network.CloudflareKiller;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
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
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: TamilDhoolProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TamilDhoolProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u0004\u0018\u00010)*\u00020*H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001e2\u0006\u0010,\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010-J\u001a\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u0007H\u0002J\u0018\u00104\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0002JF\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00102\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006A"}, d2 = {"Lcom/cncverse/TamilDhoolProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "cfInterceptor", "Lcom/lagradost/cloudstream3/network/CloudflareKiller;", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "normaliseHref", "href", "label", "classifySourceName", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "TamilDhoolLinks", "TamilDhoolProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTamilDhoolProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TamilDhoolProvider.kt\ncom/cncverse/TamilDhoolProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,234:1\n1642#2,10:235\n1915#2:245\n1916#2:247\n1652#2:248\n1642#2,10:249\n1915#2:259\n1916#2:261\n1652#2:262\n1642#2,10:263\n1915#2:273\n1916#2:276\n1652#2:277\n1642#2,10:278\n1915#2:288\n1916#2:290\n1652#2:291\n1696#2,8:292\n1915#2,2:319\n1#3:246\n1#3:260\n1#3:274\n1#3:275\n1#3:289\n1#3:301\n63#4:300\n64#4,15:302\n50#5:317\n43#5:318\n*S KotlinDebug\n*F\n+ 1 TamilDhoolProvider.kt\ncom/cncverse/TamilDhoolProvider\n*L\n70#1:235,10\n70#1:245\n70#1:247\n70#1:248\n92#1:249,10\n92#1:259\n92#1:261\n92#1:262\n106#1:263,10\n106#1:273\n106#1:276\n106#1:277\n114#1:278,10\n114#1:288\n114#1:290\n114#1:291\n124#1:292,8\n176#1:319,2\n70#1:246\n92#1:260\n106#1:275\n114#1:289\n173#1:301\n173#1:300\n173#1:302,15\n173#1:317\n173#1:318\n*E\n"})
public final class TamilDhoolProvider extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Context context;

    @NotNull
    private final CloudflareKiller cfInterceptor = new CloudflareKiller();

    @NotNull
    private String mainUrl = "https://www.tamildhool.tech";

    @NotNull
    private String name = "TamilDhool";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.TvSeries);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("zee-tamil", "Zee Tamil TV"), TuplesKt.to("sun-tv", "Sun TV"), TuplesKt.to("vijay-tv", "Vijay TV"), TuplesKt.to("kalaignar-tv", "Kalaignar TV"), TuplesKt.to("news-gossips", "News Gossips TV")});

    /* JADX INFO: renamed from: com.cncverse.TamilDhoolProvider$getMainPage$1 */
    /* JADX INFO: compiled from: TamilDhoolProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilDhoolProvider", f = "TamilDhoolProvider.kt", i = {0, 0, 0}, l = {64}, m = "getMainPage", n = {"request", "query", "page"}, nl = {69}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilDhoolProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.TamilDhoolProvider$load$1 */
    /* JADX INFO: compiled from: TamilDhoolProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilDhoolProvider", f = "TamilDhoolProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {99, 135}, m = "load", n = {"url", "url", "doc", "title", "posterRegex", "posterRaw", "poster", "cardLinks", "legacyLinks", "link", "episodes"}, nl = {100, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilDhoolProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.TamilDhoolProvider$loadLinks$1 */
    /* JADX INFO: compiled from: TamilDhoolProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilDhoolProvider", f = "TamilDhoolProvider.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {181}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "link", "totalCounts", "currentCounts", "isCasting"}, nl = {230}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilDhoolProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.TamilDhoolProvider$search$1 */
    /* JADX INFO: compiled from: TamilDhoolProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilDhoolProvider", f = "TamilDhoolProvider.kt", i = {0, 0}, l = {91}, m = "search", n = {"query", "encodedQuery"}, nl = {92}, s = {"L$0", "L$1"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TamilDhoolProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: TamilDhoolProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/cncverse/TamilDhoolProvider$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "TamilDhoolProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return TamilDhoolProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            TamilDhoolProvider.context = context;
        }
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: compiled from: TamilDhoolProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/TamilDhoolProvider$TamilDhoolLinks;", "", "sourceName", "", "sourceLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSourceName", "()Ljava/lang/String;", "getSourceLink", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "TamilDhoolProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class TamilDhoolLinks {

        @JsonProperty("sourceLink")
        @NotNull
        private final String sourceLink;

        @JsonProperty("sourceName")
        @NotNull
        private final String sourceName;

        public static /* synthetic */ TamilDhoolLinks copy$default(TamilDhoolLinks tamilDhoolLinks, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tamilDhoolLinks.sourceName;
            }
            if ((i & 2) != 0) {
                str2 = tamilDhoolLinks.sourceLink;
            }
            return tamilDhoolLinks.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSourceName() {
            return this.sourceName;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSourceLink() {
            return this.sourceLink;
        }

        @NotNull
        public final TamilDhoolLinks copy(@JsonProperty("sourceName") @NotNull String sourceName, @JsonProperty("sourceLink") @NotNull String sourceLink) {
            return new TamilDhoolLinks(sourceName, sourceLink);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TamilDhoolLinks)) {
                return false;
            }
            TamilDhoolLinks tamilDhoolLinks = (TamilDhoolLinks) other;
            return Intrinsics.areEqual(this.sourceName, tamilDhoolLinks.sourceName) && Intrinsics.areEqual(this.sourceLink, tamilDhoolLinks.sourceLink);
        }

        public int hashCode() {
            return (this.sourceName.hashCode() * 31) + this.sourceLink.hashCode();
        }

        @NotNull
        public String toString() {
            return "TamilDhoolLinks(sourceName=" + this.sourceName + ", sourceLink=" + this.sourceLink + ')';
        }

        public TamilDhoolLinks(@JsonProperty("sourceName") @NotNull String sourceName, @JsonProperty("sourceLink") @NotNull String sourceLink) {
            this.sourceName = sourceName;
            this.sourceLink = sourceLink;
        }

        @NotNull
        public final String getSourceName() {
            return this.sourceName;
        }

        @NotNull
        public final String getSourceLink() {
            return this.sourceLink;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00011 c00011;
        MainPageRequest request2;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = new C00011(continuation);
            }
        } else {
            c00011 = new C00011(continuation);
        }
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                String query = String.format(request.getData(), Arrays.copyOf(new Object[]{Boxing.boxInt(page)}, 1));
                Intrinsics.checkNotNullExpressionValue(query, "format(...)");
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + '/' + query + '/';
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
                String str2 = getMainUrl() + '/';
                Interceptor interceptor = this.cfInterceptor;
                c00011.L$0 = request;
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00011.I$0 = page;
                c00011.label = 1;
                $result = Requests.post$default(app, str, mapMapOf, str2, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, interceptor, false, (ResponseParser) null, c00011, 57336, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article.regular-post");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(CollectionsKt.arrayListOf(new HomePageList[]{new HomePageList(request2.getName(), home, true)}), Boxing.boxBoolean(true));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String strText;
        String title;
        final String posterUrl;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("section.entry-body > h3 > a");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
            return null;
        }
        TamilDhoolProvider tamilDhoolProvider = this;
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("section.entry-body > h3 > a");
        String href = MainAPIKt.fixUrl(tamilDhoolProvider, String.valueOf(elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null));
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("div.post-thumb > a > picture > img");
        if (elementSelectFirst3 == null || (posterUrl = elementSelectFirst3.attr("src")) == null) {
            TamilDhoolProvider tamilDhoolProvider2 = this;
            Element elementSelectFirst4 = $this$toSearchResult.selectFirst("div.post-thumb > a > img");
            posterUrl = MainAPIKt.fixUrlNull(tamilDhoolProvider2, elementSelectFirst4 != null ? elementSelectFirst4.attr("src") : null);
        }
        return MainAPIKt.newTvSeriesSearchResponse$default(this, title, href, TvType.TvSeries, false, new Function1() { // from class: com.cncverse.TamilDhoolProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return TamilDhoolProvider.toSearchResult$lambda$0(posterUrl, this, (TvSeriesSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$0(String $posterUrl, TamilDhoolProvider this$0, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($posterUrl);
        $this$newTvSeriesSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("referer", this$0.getMainUrl() + '/')));
        $this$newTvSeriesSearchResponse.setQuality(SearchQuality.HD);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00071 c00071;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = new C00071(continuation);
            }
        } else {
            c00071 = new C00071(continuation);
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String encodedQuery = StringsKt.replace$default(query, " ", "+", false, 4, (Object) null).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(encodedQuery, "toLowerCase(...)");
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/?s=" + encodedQuery;
                String str2 = getMainUrl() + '/';
                Interceptor interceptor = this.cfInterceptor;
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00071.L$1 = SpillingKt.nullOutSpilledVariable(encodedQuery);
                c00071.label = 1;
                $result = Requests.get$default(app, str, (Map) null, str2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, interceptor, false, (ResponseParser) null, c00071, 3578, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article.regular-post");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00021 c00021;
        Object obj;
        Object obj2;
        String url2;
        String strText;
        List cardLinks;
        Regex posterRegex;
        String posterRaw;
        List legacyLinks;
        String str;
        String rawUrl;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Regex posterRegex2;
        String posterRaw2;
        TamilDhoolLinks tamilDhoolLinks;
        TamilDhoolLinks tamilDhoolLinks2;
        String rawHref;
        String strText2;
        String value;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = new C00021(continuation);
            }
        } else {
            c00021 = new C00021(continuation);
        }
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Interceptor interceptor = this.cfInterceptor;
                c00022.L$0 = url;
                c00022.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, interceptor, false, (ResponseParser) null, c00022, 3582, (Object) null);
                c00022 = c00022;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                break;
                break;
            case 1:
                String url3 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url3;
                obj2 = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) obj2).getDocument();
        Element elementSelectFirst = doc.selectFirst("h1.entry-title");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null) {
            return null;
        }
        final String title = StringsKt.trim(strText).toString();
        if (title == null) {
            return null;
        }
        Regex posterRegex3 = new Regex("(https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\/\\/=]*jpg))");
        Element elementSelectFirst2 = doc.selectFirst("div.entry-cover");
        String posterRaw3 = String.valueOf(elementSelectFirst2 != null ? elementSelectFirst2.attr("style") : null);
        MatchResult matchResultFind$default = Regex.find$default(posterRegex3, posterRaw3, 0, 2, (Object) null);
        final String poster = (matchResultFind$default == null || (value = matchResultFind$default.getValue()) == null) ? null : StringsKt.trim(value).toString();
        Iterable $this$mapNotNull$iv2 = doc.select("figure.td-featured-thumb");
        Collection destination$iv$iv = new ArrayList();
        Iterator it = $this$mapNotNull$iv2.iterator();
        while (true) {
            String str2 = "href";
            if (!it.hasNext()) {
                String url4 = url2;
                List cardLinks2 = (List) destination$iv$iv;
                if (cardLinks2.isEmpty()) {
                    Iterable $this$mapNotNull$iv3 = doc.select("div.entry-content link[rel=prefetch][href], div.entry-content a[href], div.entry-content iframe[src]");
                    int $i$f$mapNotNull2 = 0;
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv3) {
                        List cardLinks3 = cardLinks2;
                        Element element = (Element) element$iv$iv$iv;
                        String it2 = element.attr(str2);
                        if (StringsKt.isBlank(it2)) {
                            it2 = null;
                        }
                        if (it2 == null) {
                            str = str2;
                            rawUrl = element.attr("src");
                            if (StringsKt.isBlank(rawUrl)) {
                                rawUrl = null;
                            }
                        } else {
                            str = str2;
                            rawUrl = it2;
                        }
                        String str3 = rawUrl;
                        if (str3 == null || StringsKt.isBlank(str3)) {
                            $this$mapNotNull$iv = $this$mapNotNull$iv3;
                            $i$f$mapNotNull = $i$f$mapNotNull2;
                            posterRegex2 = posterRegex3;
                            posterRaw2 = posterRaw3;
                            tamilDhoolLinks = null;
                        } else {
                            $this$mapNotNull$iv = $this$mapNotNull$iv3;
                            $i$f$mapNotNull = $i$f$mapNotNull2;
                            posterRegex2 = posterRegex3;
                            if (StringsKt.startsWith$default(rawUrl, getMainUrl(), false, 2, (Object) null)) {
                                posterRaw2 = posterRaw3;
                                if (!StringsKt.contains$default(rawUrl, "?video=", false, 2, (Object) null)) {
                                    tamilDhoolLinks = null;
                                }
                            } else {
                                posterRaw2 = posterRaw3;
                            }
                            tamilDhoolLinks = new TamilDhoolLinks(classifySourceName(rawUrl, ""), normaliseHref(rawUrl, ""));
                        }
                        if (tamilDhoolLinks != null) {
                            destination$iv$iv2.add(tamilDhoolLinks);
                        }
                        $i$f$mapNotNull2 = $i$f$mapNotNull;
                        cardLinks2 = cardLinks3;
                        str2 = str;
                        $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                        posterRegex3 = posterRegex2;
                        posterRaw3 = posterRaw2;
                    }
                    cardLinks = cardLinks2;
                    posterRegex = posterRegex3;
                    posterRaw = posterRaw3;
                    legacyLinks = (List) destination$iv$iv2;
                } else {
                    cardLinks = cardLinks2;
                    posterRegex = posterRegex3;
                    posterRaw = posterRaw3;
                    legacyLinks = CollectionsKt.emptyList();
                }
                Iterable $this$distinctBy$iv = CollectionsKt.plus(cardLinks, legacyLinks);
                HashSet set$iv = new HashSet();
                ArrayList list$iv = new ArrayList();
                for (Object e$iv : $this$distinctBy$iv) {
                    if (set$iv.add(((TamilDhoolLinks) e$iv).getSourceLink())) {
                        list$iv.add(e$iv);
                    }
                }
                ArrayList $this$distinctBy$iv2 = list$iv;
                List episodes = CollectionsKt.listOf(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson($this$distinctBy$iv2), new Function1() { // from class: com.cncverse.TamilDhoolProvider$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj3) {
                        return TamilDhoolProvider.load$lambda$3(title, poster, (Episode) obj3);
                    }
                }));
                TvType tvType = TvType.TvSeries;
                C00032 c00032 = new C00032(poster, this, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(title);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(posterRegex);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(posterRaw);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(cardLinks);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(legacyLinks);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable($this$distinctBy$iv2);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(episodes);
                c00022.label = 2;
                Object objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title, url4, tvType, episodes, c00032, c00022);
                return objNewTvSeriesLoadResponse == obj ? obj : objNewTvSeriesLoadResponse;
            }
            Object element$iv$iv$iv2 = it.next();
            Element fig = (Element) element$iv$iv$iv2;
            Object $result2 = $result;
            Element elementSelectFirst3 = fig.selectFirst("a[href]");
            if (elementSelectFirst3 == null || (rawHref = elementSelectFirst3.attr("href")) == null) {
                tamilDhoolLinks2 = null;
            } else {
                if (StringsKt.isBlank(rawHref)) {
                    rawHref = null;
                }
                if (rawHref != null) {
                    Element elementSelectFirst4 = fig.selectFirst("div.td-source-label");
                    String string = (elementSelectFirst4 == null || (strText2 = elementSelectFirst4.text()) == null) ? null : StringsKt.trim(strText2).toString();
                    String label = string != null ? string : "";
                    url2 = url2;
                    $this$mapNotNull$iv2 = $this$mapNotNull$iv2;
                    tamilDhoolLinks2 = new TamilDhoolLinks(classifySourceName(rawHref, label), normaliseHref(rawHref, label));
                } else {
                    tamilDhoolLinks2 = null;
                }
            }
            if (tamilDhoolLinks2 != null) {
                destination$iv$iv.add(tamilDhoolLinks2);
            }
            $result = $result2;
            url2 = url2;
            $this$mapNotNull$iv2 = $this$mapNotNull$iv2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3(String $title, String $poster, Episode $this$newEpisode) {
        $this$newEpisode.setName($title);
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(1);
        $this$newEpisode.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cncverse.TamilDhoolProvider$load$2 */
    /* JADX INFO: compiled from: TamilDhoolProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilDhoolProvider$load$2", f = "TamilDhoolProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00032 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TamilDhoolProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(String str, TamilDhoolProvider tamilDhoolProvider, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.this$0 = tamilDhoolProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$poster, this.this$0, continuation);
            c00032.L$0 = obj;
            return c00032;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$poster;
                    $this$newTvSeriesLoadResponse.setPosterUrl(str != null ? StringsKt.trim(str).toString() : null);
                    $this$newTvSeriesLoadResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("referer", this.this$0.getMainUrl() + '/')));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    static /* synthetic */ String normaliseHref$default(TamilDhoolProvider tamilDhoolProvider, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return tamilDhoolProvider.normaliseHref(str, str2);
    }

    private final String normaliseHref(String href, String label) {
        if (StringsKt.contains(href, "?video=", true)) {
            String id = StringsKt.substringBefore$default(StringsKt.substringAfter$default(href, "?video=", (String) null, 2, (Object) null), "&", (String) null, 2, (Object) null);
            if (StringsKt.contains(label, "Dailymotion", true)) {
                return "https://www.dailymotion.com/embed/video/" + id;
            }
            if (StringsKt.contains(label, "Youtube", true)) {
                return "https://www.youtube.com/watch?v=" + id;
            }
        }
        if (StringsKt.startsWith$default(href, "https://dai.ly/", false, 2, (Object) null)) {
            return "https://www.dailymotion.com/embed/video/" + StringsKt.removePrefix(href, "https://dai.ly/");
        }
        return href;
    }

    private final String classifySourceName(String href, String label) {
        if (!StringsKt.isBlank(label)) {
            return label;
        }
        if (StringsKt.contains(href, "thirai", true)) {
            return "ThiraiOne";
        }
        if (StringsKt.contains(href, "dailymotion", true) || StringsKt.contains(href, "dai.ly", true)) {
            return "Dailymotion";
        }
        if (StringsKt.contains(href, "youtube", true) || StringsKt.contains(href, "youtu.be", true)) {
            return "Youtube";
        }
        return StringsKt.contains(href, "?video=", true) ? "TeamsToday" : "Unknown";
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        TamilDhoolProvider tamilDhoolProvider;
        Object obj;
        Object objDecodeFromString;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
                tamilDhoolProvider = this;
            } else {
                tamilDhoolProvider = this;
                c00041 = tamilDhoolProvider.new C00041(continuation);
            }
        } else {
            tamilDhoolProvider = this;
            c00041 = tamilDhoolProvider.new C00041(continuation);
        }
        C00041 c00042 = c00041;
        Object $result = c00042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(ArrayList.class, KTypeProjection.Companion.invariant(Reflection.typeOf(TamilDhoolLinks.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ArrayList.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj) ? null : obj);
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<ArrayList<TamilDhoolLinks>>() { // from class: com.cncverse.TamilDhoolProvider$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<ArrayList<TamilDhoolLinks>>() { // from class: com.cncverse.TamilDhoolProvider$loadLinks$$inlined$parseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<ArrayList<TamilDhoolLinks>>() { // from class: com.cncverse.TamilDhoolProvider$loadLinks$$inlined$parseJson$1
                    });
                }
                ArrayList link = (ArrayList) objDecodeFromString;
                Map totalCounts = new LinkedHashMap();
                ArrayList $this$forEach$iv = link;
                for (Object element$iv : $this$forEach$iv) {
                    TamilDhoolLinks src = (TamilDhoolLinks) element$iv;
                    String sourceName = src.getSourceName();
                    Integer num = (Integer) totalCounts.get(src.getSourceName());
                    totalCounts.put(sourceName, Boxing.boxInt((num != null ? num.intValue() : 0) + 1));
                }
                Map currentCounts = new LinkedHashMap();
                C00053 c00053 = new C00053(link, totalCounts, currentCounts, function1, function2, tamilDhoolProvider, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(link);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(totalCounts);
                c00042.L$5 = SpillingKt.nullOutSpilledVariable(currentCounts);
                c00042.Z$0 = isCasting;
                c00042.label = 1;
                if (ArchComponentExtKt.safeApiCall(c00053, c00042) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                boolean z = c00042.Z$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: renamed from: com.cncverse.TamilDhoolProvider$loadLinks$3 */
    /* JADX INFO: compiled from: TamilDhoolProvider.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.TamilDhoolProvider$loadLinks$3", f = "TamilDhoolProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {190, 209, 213, 225}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "src", "displayName", "$i$f$forEach", "$i$a$-forEach-TamilDhoolProvider$loadLinks$3$1", "count", "total", "$this$forEach$iv", "element$iv", "src", "displayName", "$i$f$forEach", "$i$a$-forEach-TamilDhoolProvider$loadLinks$3$1", "count", "total", "$this$forEach$iv", "element$iv", "src", "displayName", "$i$f$forEach", "$i$a$-forEach-TamilDhoolProvider$loadLinks$3$1", "count", "total", "$this$forEach$iv", "element$iv", "src", "displayName", "extractor", "$i$f$forEach", "$i$a$-forEach-TamilDhoolProvider$loadLinks$3$1", "count", "total"}, nl = {208, 211, 212, 228}, s = {"L$0", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "L$0", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "L$0", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "L$0", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3"}, v = 2)
    @SourceDebugExtension({"SMAP\nTamilDhoolProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TamilDhoolProvider.kt\ncom/cncverse/TamilDhoolProvider$loadLinks$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,234:1\n1915#2,2:235\n*S KotlinDebug\n*F\n+ 1 TamilDhoolProvider.kt\ncom/cncverse/TamilDhoolProvider$loadLinks$3\n*L\n182#1:235,2\n*E\n"})
    static final class C00053 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Map<String, Integer> $currentCounts;
        final /* synthetic */ ArrayList<TamilDhoolLinks> $link;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ Map<String, Integer> $totalCounts;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ TamilDhoolProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(ArrayList<TamilDhoolLinks> arrayList, Map<String, Integer> map, Map<String, Integer> map2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, TamilDhoolProvider tamilDhoolProvider, Continuation<? super C00053> continuation) {
            super(1, continuation);
            this.$link = arrayList;
            this.$totalCounts = map;
            this.$currentCounts = map2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.this$0 = tamilDhoolProvider;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00053(this.$link, this.$totalCounts, this.$currentCounts, this.$subtitleCallback, this.$callback, this.this$0, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x013b  */
        /* JADX WARN: Code duplicated, block: B:15:0x0150  */
        /* JADX WARN: Code duplicated, block: B:16:0x0155  */
        /* JADX WARN: Code duplicated, block: B:19:0x0164  */
        /* JADX WARN: Code duplicated, block: B:20:0x0169  */
        /* JADX WARN: Code duplicated, block: B:23:0x017d  */
        /* JADX WARN: Code duplicated, block: B:24:0x0199  */
        /* JADX WARN: Code duplicated, block: B:27:0x01b9  */
        /* JADX WARN: Code duplicated, block: B:29:0x01fa A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x01fb  */
        /* JADX WARN: Code duplicated, block: B:32:0x0216  */
        /* JADX WARN: Code duplicated, block: B:34:0x0227  */
        /* JADX WARN: Code duplicated, block: B:36:0x0263 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:37:0x0264  */
        /* JADX WARN: Code duplicated, block: B:39:0x027f  */
        /* JADX WARN: Code duplicated, block: B:41:0x0293  */
        /* JADX WARN: Code duplicated, block: B:43:0x02ff A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:44:0x0300  */
        /* JADX WARN: Code duplicated, block: B:46:0x0323  */
        /* JADX WARN: Code duplicated, block: B:48:0x0389 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:49:0x038a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x038a -> B:50:0x0399). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:27:0x01b9
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                Method dump skipped, instruction units count: 964
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cncverse.TamilDhoolProvider.C00053.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(Function1 $callback, String $displayName, ExtractorLink extractedLink) {
            BuildersKt.runBlocking$default((CoroutineContext) null, new TamilDhoolProvider$loadLinks$3$1$1$1($callback, extractedLink, $displayName, null), 1, (Object) null);
            return Unit.INSTANCE;
        }
    }
}
