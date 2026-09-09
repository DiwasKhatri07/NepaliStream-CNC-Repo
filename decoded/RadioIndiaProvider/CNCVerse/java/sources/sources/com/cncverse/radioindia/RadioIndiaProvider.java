package com.cncverse.radioindia;

import android.content.Context;
import android.util.Base64;
import com.cncverse.donation.DonationManager;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LiveSearchResponse;
import com.lagradost.cloudstream3.LiveStreamLoadResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: RadioIndiaProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/RadioIndiaProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001c2\u0006\u0010+\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010,J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0002J\"\u00105\u001a\u0004\u0018\u00010\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005H\u0002JF\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u000e2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020?0=H\u0096@¢\u0006\u0002\u0010BR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006D"}, d2 = {"Lcom/cncverse/radioindia/RadioIndiaProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/lagradost/cloudstream3/LiveSearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "genk", "str", "parseHex", "", "hexStr", "decryptMytuner", "cipherTextBase64", "ivHex", "timestampData", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "RadioIndiaProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRadioIndiaProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RadioIndiaProvider.kt\ncom/cncverse/radioindia/RadioIndiaProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,203:1\n1642#2,10:204\n1915#2:214\n1916#2:216\n1652#2:217\n1642#2,10:219\n1915#2:229\n1916#2:231\n1652#2:232\n1#3:215\n1#3:218\n1#3:230\n1342#4,2:233\n*S KotlinDebug\n*F\n+ 1 RadioIndiaProvider.kt\ncom/cncverse/radioindia/RadioIndiaProvider\n*L\n51#1:204,10\n51#1:214\n51#1:216\n51#1:217\n80#1:219,10\n80#1:229\n80#1:231\n80#1:232\n51#1:215\n80#1:230\n178#1:233,2\n*E\n"})
public final class RadioIndiaProvider extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Context context;
    private final boolean hasDownloadSupport;

    @NotNull
    private String mainUrl = "https://www.radioindia.in";

    @NotNull
    private String name = "Radio India";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Live);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(String.valueOf(getMainUrl()), "Top Stations"), TuplesKt.to(getMainUrl() + "/radio/discover-180", "Recommended Stations"), TuplesKt.to(getMainUrl() + "/genre/local", "Local"), TuplesKt.to(getMainUrl() + "/genre/oldies", "Oldies"), TuplesKt.to(getMainUrl() + "/genre/religious-spirituality", "Religious & Spirituality"), TuplesKt.to(getMainUrl() + "/genre/talk", "Talk"), TuplesKt.to(getMainUrl() + "/genre/christian", "Christian"), TuplesKt.to(getMainUrl() + "/genre/folk", "Folk"), TuplesKt.to(getMainUrl() + "/genre/indian-music", "Indian Music"), TuplesKt.to(getMainUrl() + "/genre/bollywood", "Bollywood"), TuplesKt.to(getMainUrl() + "/genre/90s", "90s"), TuplesKt.to(getMainUrl() + "/genre/80s", "80s"), TuplesKt.to(getMainUrl() + "/radio/tamil-nadu", "Tamil Nadu"), TuplesKt.to(getMainUrl() + "/radio/kerala", "Kerala")});

    /* JADX INFO: renamed from: com.cncverse.radioindia.RadioIndiaProvider$getMainPage$1 */
    /* JADX INFO: compiled from: RadioIndiaProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.radioindia.RadioIndiaProvider", f = "RadioIndiaProvider.kt", i = {0, 0}, l = {50}, m = "getMainPage", n = {"request", "page"}, nl = {51}, s = {"L$0", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RadioIndiaProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.radioindia.RadioIndiaProvider$load$1 */
    /* JADX INFO: compiled from: RadioIndiaProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.radioindia.RadioIndiaProvider", f = "RadioIndiaProvider.kt", i = {0, 1, 1, 1, 1, 1}, l = {87, 98}, m = "load", n = {"url", "url", "document", "title", "poster", "description"}, nl = {89, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RadioIndiaProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.radioindia.RadioIndiaProvider$loadLinks$1 */
    /* JADX INFO: compiled from: RadioIndiaProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.radioindia.RadioIndiaProvider", f = "RadioIndiaProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {166, 187}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "timestampData", "streamsJson", "itemRegex", "found", "$this$forEach$iv", "element$iv", "m", "cipher", "iv", "decryptedUrl", "isCasting", "$i$f$forEach", "$i$a$-forEach-RadioIndiaProvider$loadLinks$2"}, nl = {170, 186}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00051 extends ContinuationImpl {
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

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RadioIndiaProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.radioindia.RadioIndiaProvider$search$1 */
    /* JADX INFO: compiled from: RadioIndiaProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.radioindia.RadioIndiaProvider", f = "RadioIndiaProvider.kt", i = {0}, l = {79}, m = "search", n = {"query"}, nl = {80}, s = {"L$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RadioIndiaProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: RadioIndiaProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/cncverse/radioindia/RadioIndiaProvider$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "RadioIndiaProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return RadioIndiaProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            RadioIndiaProvider.context = context;
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

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00021 c00021;
        MainPageRequest request2;
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
        Object $result = c00021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00021.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                Requests app = MainActivityKt.getApp();
                String data = request.getData();
                c00021.L$0 = request;
                c00021.I$0 = page;
                c00021.label = 1;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00021.I$0;
                request2 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("a.radio-card__link, a.radio-list-row");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            LiveSearchResponse searchResponse = toSearchResponse(it);
            if (searchResponse != null) {
                destination$iv$iv.add(searchResponse);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(new HomePageList(request2.getName(), home, true), (Boolean) null, 2, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    private final LiveSearchResponse toSearchResponse(Element $this$toSearchResponse) {
        String it;
        String it2;
        Element elementSelectFirst = $this$toSearchResponse.selectFirst(".radio-card__name, .radio-list-row__name");
        final String posterUrl = null;
        if (elementSelectFirst == null || (it = elementSelectFirst.text()) == null) {
            it = $this$toSearchResponse.attr("title");
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it == null) {
                return null;
            }
        }
        String title = it;
        String href = MainAPIKt.fixUrlNull(this, $this$toSearchResponse.attr("href"));
        if (href == null) {
            return null;
        }
        Element imgEl = $this$toSearchResponse.selectFirst("img.radio-card__logo, img.radio-list-row__logo");
        if (imgEl != null && (it2 = imgEl.attr("data-src")) != null) {
            if (StringsKt.isBlank(it2)) {
                it2 = null;
            }
            if (it2 != null) {
                posterUrl = it2;
            } else if (imgEl != null) {
                posterUrl = imgEl.attr("src");
            }
        } else if (imgEl != null) {
            posterUrl = imgEl.attr("src");
        }
        return MainAPIKt.newLiveSearchResponse$default(this, title, href, TvType.Live, false, new Function1() { // from class: com.cncverse.radioindia.RadioIndiaProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return RadioIndiaProvider.toSearchResponse$lambda$2(this.f$0, posterUrl, (LiveSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResponse$lambda$2(RadioIndiaProvider this$0, String $posterUrl, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl(MainAPIKt.fixUrlNull(this$0, $posterUrl));
        $this$newLiveSearchResponse.setLang("hi");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuation);
            }
        } else {
            c00061 = new C00061(continuation);
        }
        Object $result = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00061.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/search?q=" + query;
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00061.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061, 4094, (Object) null);
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
        Iterable $this$mapNotNull$iv = document.select("a.radio-card__link");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            LiveSearchResponse searchResponse = toSearchResponse(it);
            if (searchResponse != null) {
                destination$iv$iv.add(searchResponse);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00031 c00031;
        Object obj;
        Object obj2;
        String url2;
        String title;
        String strAttr;
        List listSplit$default;
        String str;
        String string;
        String strAttr2;
        String strText;
        String strText2;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = new C00031(continuation);
            }
        } else {
            c00031 = new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00032.L$0 = url;
                c00032.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                c00032 = c00032;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                break;
                break;
            case 1:
                String url3 = (String) c00032.L$0;
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
        Document document = ((NiceResponse) obj2).getDocument();
        Element elementSelectFirst = document.selectFirst("h1.radio-info__name");
        if (elementSelectFirst == null || (strText2 = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText2).toString()) == null) {
            Element elementSelectFirst2 = document.selectFirst("meta[property=og:title]");
            title = (elementSelectFirst2 == null || (strAttr = elementSelectFirst2.attr("content")) == null || (listSplit$default = StringsKt.split$default(strAttr, new String[]{":"}, false, 0, 6, (Object) null)) == null || (str = (String) CollectionsKt.firstOrNull(listSplit$default)) == null) ? "Unknown Radio" : StringsKt.trim(str).toString();
        }
        Element elementSelectFirst3 = document.selectFirst("meta[property=og:image]");
        String poster = elementSelectFirst3 != null ? elementSelectFirst3.attr("content") : null;
        Element elementSelectFirst4 = document.selectFirst(".radio-info__description");
        if (elementSelectFirst4 == null || (strText = elementSelectFirst4.text()) == null || (string = StringsKt.trim(strText).toString()) == null) {
            Element elementSelectFirst5 = document.selectFirst("meta[name=description]");
            string = (elementSelectFirst5 == null || (strAttr2 = elementSelectFirst5.attr("content")) == null) ? null : StringsKt.trim(strAttr2).toString();
        }
        String description = string;
        String title2 = title;
        C00042 c00042 = new C00042(poster, description, null);
        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url2);
        c00032.L$1 = SpillingKt.nullOutSpilledVariable(document);
        c00032.L$2 = SpillingKt.nullOutSpilledVariable(title2);
        c00032.L$3 = SpillingKt.nullOutSpilledVariable(poster);
        c00032.L$4 = SpillingKt.nullOutSpilledVariable(description);
        c00032.label = 2;
        Object objNewLiveStreamLoadResponse = MainAPIKt.newLiveStreamLoadResponse(this, title2, url2, url2, c00042, c00032);
        if (objNewLiveStreamLoadResponse == obj) {
            return obj;
        }
        return objNewLiveStreamLoadResponse;
    }

    /* JADX INFO: renamed from: com.cncverse.radioindia.RadioIndiaProvider$load$2 */
    /* JADX INFO: compiled from: RadioIndiaProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.radioindia.RadioIndiaProvider$load$2", f = "RadioIndiaProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(String str, String str2, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = RadioIndiaProvider.this.new C00042(this.$poster, this.$description, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(LiveStreamLoadResponse liveStreamLoadResponse, Continuation<? super Unit> continuation) {
            return create(liveStreamLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LiveStreamLoadResponse $this$newLiveStreamLoadResponse = (LiveStreamLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newLiveStreamLoadResponse.setPosterUrl(MainAPIKt.fixUrlNull(RadioIndiaProvider.this, this.$poster));
                    $this$newLiveStreamLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String genk(String str) {
        String hex = "";
        int j = 0;
        for (int i = 0; i < 32; i++) {
            int charCode = str.charAt(j);
            StringBuilder sbAppend = new StringBuilder().append(hex);
            String string = Integer.toString(charCode, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            hex = sbAppend.append(string).toString();
            j++;
            if (j >= str.length()) {
                j = 0;
            }
        }
        return hex;
    }

    private final byte[] parseHex(String hexStr) {
        int len = hexStr.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexStr.charAt(i), 16) << 4) + Character.digit(hexStr.charAt(i + 1), 16));
        }
        return data;
    }

    private final String decryptMytuner(String cipherTextBase64, String ivHex, String timestampData) {
        try {
            String standardizedBase64 = StringsKt.replace$default(StringsKt.replace$default(cipherTextBase64, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
            byte[] cipherData = Base64.decode(standardizedBase64, 0);
            try {
                String keyHex = genk(timestampData);
                byte[] keyBytes = parseHex(keyHex);
                try {
                    byte[] ivBytes = parseHex(ivHex);
                    SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
                    IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
                    Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
                    cipher.init(2, secretKey, ivSpec);
                    byte[] decryptedBytes = cipher.doFinal(cipherData);
                    return StringsKt.trim(StringsKt.trimEnd(new String(decryptedBytes, StandardCharsets.UTF_8), new char[]{0})).toString();
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return null;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x016a  */
    /* JADX WARN: Code duplicated, block: B:31:0x0196  */
    /* JADX WARN: Code duplicated, block: B:45:0x0295  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x024a -> B:43:0x0263). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r28, boolean r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r30, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r31, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r32) {
        /*
            Method dump skipped, instruction units count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.radioindia.RadioIndiaProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
