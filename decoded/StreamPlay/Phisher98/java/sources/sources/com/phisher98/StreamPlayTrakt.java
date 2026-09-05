package com.phisher98;

import android.content.SharedPreferences;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.metaproviders.TraktProvider;
import com.lagradost.cloudstream3.syncproviders.SyncIdName;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: StreamPlayTrakt.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JF\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001a2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020%0#H\u0096@¢\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001aX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c¨\u0006)"}, d2 = {"Lcom/phisher98/StreamPlayTrakt;", "Lcom/lagradost/cloudstream3/metaproviders/TraktProvider;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "setSupportedTypes", "(Ljava/util/Set;)V", "lang", "getLang", "setLang", "supportedSyncNames", "Lcom/lagradost/cloudstream3/syncproviders/SyncIdName;", "getSupportedSyncNames", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStreamPlayTrakt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayTrakt.kt\ncom/phisher98/StreamPlayTrakt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1#2:97\n*E\n"})
public final class StreamPlayTrakt extends TraktProvider {
    private final boolean hasQuickSearch;

    @NotNull
    private final SharedPreferences sharedPref;

    @NotNull
    private String name = "StreamPlay";

    @NotNull
    private Set<? extends TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.AsianDrama, TvType.Anime});

    @NotNull
    private String lang = "en";

    @NotNull
    private final Set<SyncIdName> supportedSyncNames = SetsKt.setOf(SyncIdName.Trakt);
    private final boolean hasMainPage = true;

    /* JADX INFO: renamed from: com.phisher98.StreamPlayTrakt$loadLinks$1 */
    /* JADX INFO: compiled from: StreamPlayTrakt.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayTrakt", f = "StreamPlayTrakt.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {48, 92}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "jsonObj", "title", "year", "imdbIdRaw", "season", "episode", "tmdbId", "isAsian", "isBollywood", "jpTitle", "orgTitle", "type", "$this$loadLinks_u24lambda_u248", "isCasting", "isAnime", "isMovie", "data", "subtitleCallback", "callback", "jsonObj", "title", "year", "imdbIdRaw", "season", "episode", "tmdbId", "isAsian", "isBollywood", "jpTitle", "orgTitle", "type", "linkData", "tmdbData", "isCasting", "isAnime", "isMovie"}, nl = {49, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C02701 extends ContinuationImpl {
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

        C02701(Continuation<? super C02701> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayTrakt.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    public StreamPlayTrakt(@NotNull SharedPreferences sharedPref) {
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

    /* JADX WARN: Code duplicated, block: B:136:0x039b A[Catch: all -> 0x03ab, TryCatch #6 {all -> 0x03ab, blocks: (B:134:0x0395, B:136:0x039b, B:141:0x03bc, B:143:0x03c2), top: B:243:0x0395 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:141:0x03bc A[Catch: all -> 0x03ab, TryCatch #6 {all -> 0x03ab, blocks: (B:134:0x0395, B:136:0x039b, B:141:0x03bc, B:143:0x03c2), top: B:243:0x0395 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:147:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:151:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:153:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:157:0x040c  */
    /* JADX WARN: Code duplicated, block: B:159:0x0410  */
    /* JADX WARN: Code duplicated, block: B:166:0x0433 A[PHI: r0
      0x0433: PHI (r0v124 java.lang.String) = (r0v123 java.lang.String), (r0v136 java.lang.String) binds: [B:152:0x03f6, B:158:0x040e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:169:0x044b  */
    /* JADX WARN: Code duplicated, block: B:171:0x044f A[Catch: all -> 0x0417, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x0417, blocks: (B:160:0x0412, B:171:0x044f), top: B:263:0x0412 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x048b A[Catch: all -> 0x04cc, TryCatch #8 {all -> 0x04cc, blocks: (B:177:0x046f, B:179:0x048b, B:185:0x04ba), top: B:247:0x046f }] */
    /* JADX WARN: Code duplicated, block: B:184:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:220:0x0808  */
    /* JADX WARN: Code duplicated, block: B:221:0x080b  */
    /* JADX WARN: Code duplicated, block: B:224:0x081c  */
    /* JADX WARN: Code duplicated, block: B:225:0x081f  */
    /* JADX WARN: Code duplicated, block: B:228:0x08d8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:229:0x08d9  */
    /* JADX WARN: Code duplicated, block: B:243:0x0395 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0188  */
    /* JADX WARN: Code duplicated, block: B:46:0x019c  */
    /* JADX WARN: Code duplicated, block: B:55:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:75:0x0200  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0223  */
    /* JADX WARN: Code duplicated, block: B:93:0x0247  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 8 */
    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C02701 c02701;
        String str2;
        Object obj;
        String strOptString;
        Integer numBoxInt;
        String strOptString2;
        Integer numBoxInt2;
        Integer numBoxInt3;
        Ref.ObjectRef objectRef;
        Object obj2;
        String str3;
        Integer num;
        Integer num2;
        String str4;
        boolean z2;
        Ref.BooleanRef booleanRef;
        Ref.BooleanRef booleanRef2;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        JSONObject jSONObject;
        Ref.ObjectRef objectRef5;
        Integer num3;
        int i;
        int i2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String str5;
        String str6;
        Ref.ObjectRef objectRef6;
        Ref.BooleanRef booleanRef3;
        Ref.BooleanRef booleanRef4;
        Object[] objArr;
        Ref.ObjectRef objectRef7;
        String str7;
        boolean z3;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        Integer num4;
        Integer num5;
        Ref.ObjectRef objectRef8;
        Ref.BooleanRef booleanRef5;
        Ref.BooleanRef booleanRef6;
        Ref.ObjectRef objectRef9;
        Ref.ObjectRef objectRef10;
        Ref.ObjectRef objectRef11;
        Ref.ObjectRef objectRef12;
        Integer num6;
        int i3;
        String str8;
        Ref.ObjectRef objectRef13;
        Ref.ObjectRef objectRef14;
        String str9;
        int i4;
        Integer num7;
        boolean z4;
        boolean z5;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        JSONObject jSONObject2;
        Ref.ObjectRef objectRef15;
        Ref.ObjectRef objectRef16;
        String strOptString3;
        Ref.ObjectRef objectRef17;
        String strOptString4;
        String strOptString5;
        if (continuation instanceof C02701) {
            c02701 = (C02701) continuation;
            if ((c02701.label & Integer.MIN_VALUE) != 0) {
                c02701.label -= Integer.MIN_VALUE;
            } else {
                c02701 = new C02701(continuation);
            }
        } else {
            c02701 = new C02701(continuation);
        }
        C02701 c02702 = c02701;
        Object objLoadLinks = c02702.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02702.label) {
            case 0:
                ResultKt.throwOnFailure(objLoadLinks);
                try {
                    Result.Companion companion = Result.Companion;
                    StreamPlayTrakt streamPlayTrakt = this;
                    str2 = str;
                    try {
                        obj = Result.constructor-impl(new JSONObject(str2));
                    } catch (Throwable th) {
                        th = th;
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    break;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = str;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                JSONObject jSONObject3 = (JSONObject) obj;
                Ref.ObjectRef objectRef18 = new Ref.ObjectRef();
                if (jSONObject3 != null && (strOptString = jSONObject3.optString("title")) != null) {
                    if (StringsKt.isBlank(strOptString)) {
                        strOptString = null;
                    }
                    if (strOptString == null) {
                        if (jSONObject3 != null) {
                            strOptString = null;
                        } else {
                            strOptString = null;
                        }
                    }
                } else if (jSONObject3 != null || (strOptString = jSONObject3.optString("name")) == null || StringsKt.isBlank(strOptString)) {
                    strOptString = null;
                }
                objectRef18.element = strOptString;
                if (jSONObject3 != null) {
                    numBoxInt = Boxing.boxInt(jSONObject3.optInt("year"));
                    if ((numBoxInt.intValue() > 0 ? 1 : 0) == 0) {
                        numBoxInt = null;
                    }
                } else {
                    numBoxInt = null;
                }
                Integer num8 = numBoxInt;
                boolean zOptBoolean = jSONObject3 != null ? jSONObject3.optBoolean("is_anime", false) : false;
                if (jSONObject3 != null && (strOptString2 = jSONObject3.optString("imdb_id")) != null) {
                    if (StringsKt.isBlank(strOptString2)) {
                        strOptString2 = null;
                    }
                    if (strOptString2 == null) {
                        if (jSONObject3 != null) {
                            strOptString2 = null;
                        } else {
                            strOptString2 = null;
                        }
                    }
                } else if (jSONObject3 != null || (strOptString2 = jSONObject3.optString("imdbId")) == null || StringsKt.isBlank(strOptString2)) {
                    strOptString2 = null;
                }
                String str10 = strOptString2;
                if (jSONObject3 != null) {
                    numBoxInt2 = Boxing.boxInt(jSONObject3.optInt("season"));
                    if ((numBoxInt2.intValue() > 0 ? 1 : 0) == 0) {
                        numBoxInt2 = null;
                    }
                } else {
                    numBoxInt2 = null;
                }
                Integer num9 = numBoxInt2;
                if (jSONObject3 != null) {
                    numBoxInt3 = Boxing.boxInt(jSONObject3.optInt("episode"));
                    if ((numBoxInt3.intValue() > 0 ? 1 : 0) == 0) {
                        numBoxInt3 = null;
                    }
                } else {
                    numBoxInt3 = null;
                }
                Integer num10 = numBoxInt3;
                int i5 = (num9 == null || num10 == null) ? 1 : 0;
                objectRef = new Ref.ObjectRef();
                Ref.BooleanRef booleanRef7 = new Ref.BooleanRef();
                Ref.BooleanRef booleanRef8 = new Ref.BooleanRef();
                Ref.ObjectRef objectRef19 = new Ref.ObjectRef();
                Ref.ObjectRef objectRef20 = new Ref.ObjectRef();
                Ref.ObjectRef objectRef21 = new Ref.ObjectRef();
                if (str10 != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        StreamPlayTrakt streamPlayTrakt2 = this;
                        try {
                            Requests app = MainActivityKt.getApp();
                            String str11 = "https://api.themoviedb.org/3/find/" + str10 + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&external_source=imdb_id&language=en-US";
                            c02702.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                            c02702.L$1 = function1;
                            c02702.L$2 = function2;
                            c02702.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject3);
                            c02702.L$4 = objectRef18;
                            c02702.L$5 = num8;
                            c02702.L$6 = str10;
                            try {
                                c02702.L$7 = num9;
                                num9 = num9;
                                try {
                                    c02702.L$8 = num10;
                                    num10 = num10;
                                    try {
                                        c02702.L$9 = objectRef;
                                        objectRef = objectRef;
                                        try {
                                            c02702.L$10 = booleanRef7;
                                            booleanRef7 = booleanRef7;
                                            try {
                                                c02702.L$11 = booleanRef8;
                                                booleanRef8 = booleanRef8;
                                                try {
                                                    c02702.L$12 = objectRef19;
                                                    objectRef19 = objectRef19;
                                                    try {
                                                        c02702.L$13 = objectRef20;
                                                        objectRef20 = objectRef20;
                                                        try {
                                                            c02702.L$14 = objectRef21;
                                                            c02702.L$15 = SpillingKt.nullOutSpilledVariable(streamPlayTrakt2);
                                                            objectRef21 = objectRef21;
                                                            c02702.Z$0 = z;
                                                            c02702.I$0 = zOptBoolean ? 1 : 0;
                                                            try {
                                                                c02702.I$1 = i5;
                                                                c02702.label = 1;
                                                                str3 = str10;
                                                                str5 = "name";
                                                                str6 = "title";
                                                                obj2 = coroutine_suspended;
                                                                try {
                                                                    objLoadLinks = Requests.get$default(app, str11, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02702, 4094, (Object) null);
                                                                    c02702 = c02702;
                                                                    if (objLoadLinks == obj2) {
                                                                        return obj2;
                                                                    }
                                                                    num = num9;
                                                                    num2 = num10;
                                                                    z2 = z;
                                                                    objectRef6 = objectRef;
                                                                    booleanRef3 = booleanRef7;
                                                                    booleanRef4 = booleanRef8;
                                                                    objectRef2 = objectRef19;
                                                                    objectRef3 = objectRef20;
                                                                    objectRef4 = objectRef21;
                                                                    objArr = 0;
                                                                    jSONObject = jSONObject3;
                                                                    objectRef7 = objectRef18;
                                                                    num3 = num8;
                                                                    i = zOptBoolean ? 1 : 0;
                                                                    str7 = str3;
                                                                    i2 = i5;
                                                                    str4 = str;
                                                                    function3 = function1;
                                                                    function4 = function2;
                                                                    try {
                                                                        JSONObject jSONObject4 = new JSONObject(((NiceResponse) objLoadLinks).getText());
                                                                        jSONArrayOptJSONArray = jSONObject4.optJSONArray("movie_results");
                                                                        jSONArrayOptJSONArray2 = jSONObject4.optJSONArray("tv_results");
                                                                        if (jSONArrayOptJSONArray != null) {
                                                                            try {
                                                                                if (jSONArrayOptJSONArray.length() > 0) {
                                                                                    JSONObject jSONObject5 = jSONArrayOptJSONArray.getJSONObject(0);
                                                                                    objectRef4.element = "movie";
                                                                                    jSONObject2 = jSONObject5;
                                                                                } else if (jSONArrayOptJSONArray2 != null || jSONArrayOptJSONArray2.length() <= 0) {
                                                                                    jSONObject2 = null;
                                                                                } else {
                                                                                    JSONObject jSONObject6 = jSONArrayOptJSONArray2.getJSONObject(0);
                                                                                    objectRef4.element = "tv";
                                                                                    jSONObject2 = jSONObject6;
                                                                                }
                                                                                if (jSONObject2 != null) {
                                                                                    objectRef6.element = Boxing.boxInt(jSONObject2.optInt("id"));
                                                                                    strOptString3 = jSONObject2.optString(str6);
                                                                                    if (StringsKt.isBlank(strOptString3)) {
                                                                                        strOptString3 = null;
                                                                                    }
                                                                                    if (strOptString3 == null) {
                                                                                        try {
                                                                                            strOptString3 = jSONObject2.optString(str5);
                                                                                            if (StringsKt.isBlank(strOptString3)) {
                                                                                                strOptString3 = null;
                                                                                            }
                                                                                            if (strOptString3 == null) {
                                                                                                objectRef17 = objectRef7;
                                                                                                try {
                                                                                                    strOptString3 = (String) objectRef17.element;
                                                                                                } catch (Throwable th3) {
                                                                                                    th = th3;
                                                                                                    objectRef5 = objectRef17;
                                                                                                    booleanRef2 = booleanRef4;
                                                                                                    booleanRef = booleanRef3;
                                                                                                    str3 = str7;
                                                                                                    objectRef = objectRef6;
                                                                                                    Result.Companion companion4 = Result.Companion;
                                                                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                                                                    objectRef11 = objectRef4;
                                                                                                    booleanRef4 = booleanRef2;
                                                                                                    booleanRef3 = booleanRef;
                                                                                                    objectRef13 = objectRef;
                                                                                                    objectRef14 = objectRef5;
                                                                                                    str9 = str3;
                                                                                                    i4 = i;
                                                                                                    num7 = num3;
                                                                                                    i3 = i4;
                                                                                                    booleanRef5 = booleanRef3;
                                                                                                    num6 = num7;
                                                                                                    z3 = z2;
                                                                                                    num5 = num2;
                                                                                                    num4 = num;
                                                                                                    objectRef12 = objectRef14;
                                                                                                    booleanRef6 = booleanRef4;
                                                                                                    objectRef9 = objectRef2;
                                                                                                    str8 = str9;
                                                                                                    objectRef8 = objectRef13;
                                                                                                    objectRef10 = objectRef3;
                                                                                                    function6 = function4;
                                                                                                    function5 = function3;
                                                                                                    Integer num11 = (Integer) objectRef8.element;
                                                                                                    String str12 = (String) objectRef11.element;
                                                                                                    String str13 = (String) objectRef12.element;
                                                                                                    String str14 = (String) objectRef10.element;
                                                                                                    if (i3 != 0) {
                                                                                                        z4 = true;
                                                                                                    } else {
                                                                                                        z4 = false;
                                                                                                    }
                                                                                                    String str15 = (String) objectRef9.element;
                                                                                                    boolean z6 = booleanRef5.element;
                                                                                                    boolean z7 = booleanRef6.element;
                                                                                                    if (i2 != 0) {
                                                                                                        z5 = true;
                                                                                                    } else {
                                                                                                        z5 = false;
                                                                                                    }
                                                                                                    StreamPlay.LinkData linkData = new StreamPlay.LinkData(num11, str8, null, str12, num4, num5, null, null, null, str13, num6, str14, z4, null, null, null, str15, null, null, z6, z7, false, null, null, false, Boxing.boxBoolean(z5), 31908292, null);
                                                                                                    String json = AppUtils.INSTANCE.toJson(linkData);
                                                                                                    StreamPlay streamPlay = new StreamPlay(this.sharedPref);
                                                                                                    c02702.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                                                                                                    c02702.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                                                                    c02702.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                                                                                                    c02702.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject);
                                                                                                    c02702.L$4 = SpillingKt.nullOutSpilledVariable(objectRef12);
                                                                                                    c02702.L$5 = SpillingKt.nullOutSpilledVariable(num6);
                                                                                                    c02702.L$6 = SpillingKt.nullOutSpilledVariable(str8);
                                                                                                    c02702.L$7 = SpillingKt.nullOutSpilledVariable(num4);
                                                                                                    c02702.L$8 = SpillingKt.nullOutSpilledVariable(num5);
                                                                                                    c02702.L$9 = SpillingKt.nullOutSpilledVariable(objectRef8);
                                                                                                    c02702.L$10 = SpillingKt.nullOutSpilledVariable(booleanRef5);
                                                                                                    c02702.L$11 = SpillingKt.nullOutSpilledVariable(booleanRef6);
                                                                                                    c02702.L$12 = SpillingKt.nullOutSpilledVariable(objectRef9);
                                                                                                    c02702.L$13 = SpillingKt.nullOutSpilledVariable(objectRef10);
                                                                                                    c02702.L$14 = SpillingKt.nullOutSpilledVariable(objectRef11);
                                                                                                    c02702.L$15 = SpillingKt.nullOutSpilledVariable(linkData);
                                                                                                    c02702.L$16 = SpillingKt.nullOutSpilledVariable(json);
                                                                                                    c02702.Z$0 = z3;
                                                                                                    c02702.I$0 = i3;
                                                                                                    c02702.I$1 = i2;
                                                                                                    c02702.label = 2;
                                                                                                    objLoadLinks = streamPlay.loadLinks(json, z3, function5, function6, c02702);
                                                                                                    if (objLoadLinks == obj2) {
                                                                                                        return obj2;
                                                                                                    }
                                                                                                    return objLoadLinks;
                                                                                                }
                                                                                            } else {
                                                                                                objectRef17 = objectRef7;
                                                                                            }
                                                                                            try {
                                                                                                objectRef17.element = strOptString3;
                                                                                                String strOptString6 = jSONObject2.optString("original_title");
                                                                                                strOptString4 = StringsKt.isBlank(strOptString6) ? null : strOptString6;
                                                                                                if (strOptString4 == null) {
                                                                                                    strOptString4 = jSONObject2.optString("original_name");
                                                                                                }
                                                                                                objectRef3.element = strOptString4;
                                                                                                strOptString5 = jSONObject2.optString("original_language");
                                                                                                objectRef16 = objectRef17;
                                                                                                objectRef15 = objectRef6;
                                                                                                try {
                                                                                                    booleanRef3.element = CollectionsKt.listOf(new String[]{"ja", "ko", "zh", "th"}).contains(strOptString5);
                                                                                                    booleanRef4.element = Intrinsics.areEqual(strOptString5, "hi");
                                                                                                    if (Intrinsics.areEqual(strOptString5, "ja")) {
                                                                                                        objectRef2.element = objectRef3.element;
                                                                                                    }
                                                                                                } catch (Throwable th4) {
                                                                                                    th = th4;
                                                                                                    booleanRef2 = booleanRef4;
                                                                                                    objectRef5 = objectRef16;
                                                                                                    str3 = str7;
                                                                                                    objectRef = objectRef15;
                                                                                                    booleanRef = booleanRef3;
                                                                                                    Result.Companion companion5 = Result.Companion;
                                                                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                                                                    objectRef11 = objectRef4;
                                                                                                    booleanRef4 = booleanRef2;
                                                                                                    booleanRef3 = booleanRef;
                                                                                                    objectRef13 = objectRef;
                                                                                                    objectRef14 = objectRef5;
                                                                                                    str9 = str3;
                                                                                                    i4 = i;
                                                                                                    num7 = num3;
                                                                                                }
                                                                                            } catch (Throwable th5) {
                                                                                                th = th5;
                                                                                                booleanRef2 = booleanRef4;
                                                                                                objectRef5 = objectRef17;
                                                                                                str3 = str7;
                                                                                                objectRef = objectRef6;
                                                                                                booleanRef = booleanRef3;
                                                                                                Result.Companion companion6 = Result.Companion;
                                                                                                Result.constructor-impl(ResultKt.createFailure(th));
                                                                                                objectRef11 = objectRef4;
                                                                                                booleanRef4 = booleanRef2;
                                                                                                booleanRef3 = booleanRef;
                                                                                                objectRef13 = objectRef;
                                                                                                objectRef14 = objectRef5;
                                                                                                str9 = str3;
                                                                                                i4 = i;
                                                                                                num7 = num3;
                                                                                            }
                                                                                        } catch (Throwable th6) {
                                                                                            th = th6;
                                                                                            objectRef5 = objectRef7;
                                                                                            booleanRef2 = booleanRef4;
                                                                                            booleanRef = booleanRef3;
                                                                                            str3 = str7;
                                                                                            objectRef = objectRef6;
                                                                                            Result.Companion companion7 = Result.Companion;
                                                                                            Result.constructor-impl(ResultKt.createFailure(th));
                                                                                            objectRef11 = objectRef4;
                                                                                            booleanRef4 = booleanRef2;
                                                                                            booleanRef3 = booleanRef;
                                                                                            objectRef13 = objectRef;
                                                                                            objectRef14 = objectRef5;
                                                                                            str9 = str3;
                                                                                            i4 = i;
                                                                                            num7 = num3;
                                                                                            i3 = i4;
                                                                                            booleanRef5 = booleanRef3;
                                                                                            num6 = num7;
                                                                                            z3 = z2;
                                                                                            num5 = num2;
                                                                                            num4 = num;
                                                                                            objectRef12 = objectRef14;
                                                                                            booleanRef6 = booleanRef4;
                                                                                            objectRef9 = objectRef2;
                                                                                            str8 = str9;
                                                                                            objectRef8 = objectRef13;
                                                                                            objectRef10 = objectRef3;
                                                                                            function6 = function4;
                                                                                            function5 = function3;
                                                                                            Integer num12 = (Integer) objectRef8.element;
                                                                                            String str16 = (String) objectRef11.element;
                                                                                            String str17 = (String) objectRef12.element;
                                                                                            String str18 = (String) objectRef10.element;
                                                                                            if (i3 != 0) {
                                                                                                z4 = true;
                                                                                            } else {
                                                                                                z4 = false;
                                                                                            }
                                                                                            String str19 = (String) objectRef9.element;
                                                                                            boolean z8 = booleanRef5.element;
                                                                                            boolean z9 = booleanRef6.element;
                                                                                            if (i2 != 0) {
                                                                                                z5 = true;
                                                                                            } else {
                                                                                                z5 = false;
                                                                                            }
                                                                                            StreamPlay.LinkData linkData2 = new StreamPlay.LinkData(num12, str8, null, str16, num4, num5, null, null, null, str17, num6, str18, z4, null, null, null, str19, null, null, z8, z9, false, null, null, false, Boxing.boxBoolean(z5), 31908292, null);
                                                                                            String json2 = AppUtils.INSTANCE.toJson(linkData2);
                                                                                            StreamPlay streamPlay2 = new StreamPlay(this.sharedPref);
                                                                                            c02702.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                                                                                            c02702.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                                                            c02702.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                                                                                            c02702.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject);
                                                                                            c02702.L$4 = SpillingKt.nullOutSpilledVariable(objectRef12);
                                                                                            c02702.L$5 = SpillingKt.nullOutSpilledVariable(num6);
                                                                                            c02702.L$6 = SpillingKt.nullOutSpilledVariable(str8);
                                                                                            c02702.L$7 = SpillingKt.nullOutSpilledVariable(num4);
                                                                                            c02702.L$8 = SpillingKt.nullOutSpilledVariable(num5);
                                                                                            c02702.L$9 = SpillingKt.nullOutSpilledVariable(objectRef8);
                                                                                            c02702.L$10 = SpillingKt.nullOutSpilledVariable(booleanRef5);
                                                                                            c02702.L$11 = SpillingKt.nullOutSpilledVariable(booleanRef6);
                                                                                            c02702.L$12 = SpillingKt.nullOutSpilledVariable(objectRef9);
                                                                                            c02702.L$13 = SpillingKt.nullOutSpilledVariable(objectRef10);
                                                                                            c02702.L$14 = SpillingKt.nullOutSpilledVariable(objectRef11);
                                                                                            c02702.L$15 = SpillingKt.nullOutSpilledVariable(linkData2);
                                                                                            c02702.L$16 = SpillingKt.nullOutSpilledVariable(json2);
                                                                                            c02702.Z$0 = z3;
                                                                                            c02702.I$0 = i3;
                                                                                            c02702.I$1 = i2;
                                                                                            c02702.label = 2;
                                                                                            objLoadLinks = streamPlay2.loadLinks(json2, z3, function5, function6, c02702);
                                                                                            if (objLoadLinks == obj2) {
                                                                                                return obj2;
                                                                                            }
                                                                                            return objLoadLinks;
                                                                                        }
                                                                                    } else {
                                                                                        objectRef17 = objectRef7;
                                                                                        objectRef17.element = strOptString3;
                                                                                        String strOptString7 = jSONObject2.optString("original_title");
                                                                                        if (StringsKt.isBlank(strOptString7)) {
                                                                                        }
                                                                                        if (strOptString4 == null) {
                                                                                            strOptString4 = jSONObject2.optString("original_name");
                                                                                        }
                                                                                        objectRef3.element = strOptString4;
                                                                                        strOptString5 = jSONObject2.optString("original_language");
                                                                                        objectRef16 = objectRef17;
                                                                                        objectRef15 = objectRef6;
                                                                                        booleanRef3.element = CollectionsKt.listOf(new String[]{"ja", "ko", "zh", "th"}).contains(strOptString5);
                                                                                        booleanRef4.element = Intrinsics.areEqual(strOptString5, "hi");
                                                                                        if (Intrinsics.areEqual(strOptString5, "ja")) {
                                                                                            objectRef2.element = objectRef3.element;
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    objectRef15 = objectRef6;
                                                                                    objectRef16 = objectRef7;
                                                                                }
                                                                                Result.constructor-impl(Unit.INSTANCE);
                                                                                objectRef11 = objectRef4;
                                                                                objectRef14 = objectRef16;
                                                                                objectRef13 = objectRef15;
                                                                                str9 = str7;
                                                                                i4 = i;
                                                                                num7 = num3;
                                                                            } catch (Throwable th7) {
                                                                                th = th7;
                                                                                booleanRef2 = booleanRef4;
                                                                                booleanRef = booleanRef3;
                                                                                str3 = str7;
                                                                                objectRef5 = objectRef7;
                                                                                objectRef = objectRef6;
                                                                                Result.Companion companion8 = Result.Companion;
                                                                                Result.constructor-impl(ResultKt.createFailure(th));
                                                                                objectRef11 = objectRef4;
                                                                                booleanRef4 = booleanRef2;
                                                                                booleanRef3 = booleanRef;
                                                                                objectRef13 = objectRef;
                                                                                objectRef14 = objectRef5;
                                                                                str9 = str3;
                                                                                i4 = i;
                                                                                num7 = num3;
                                                                                i3 = i4;
                                                                                booleanRef5 = booleanRef3;
                                                                                num6 = num7;
                                                                                z3 = z2;
                                                                                num5 = num2;
                                                                                num4 = num;
                                                                                objectRef12 = objectRef14;
                                                                                booleanRef6 = booleanRef4;
                                                                                objectRef9 = objectRef2;
                                                                                str8 = str9;
                                                                                objectRef8 = objectRef13;
                                                                                objectRef10 = objectRef3;
                                                                                function6 = function4;
                                                                                function5 = function3;
                                                                                Integer num13 = (Integer) objectRef8.element;
                                                                                String str110 = (String) objectRef11.element;
                                                                                String str111 = (String) objectRef12.element;
                                                                                String str112 = (String) objectRef10.element;
                                                                                if (i3 != 0) {
                                                                                    z4 = true;
                                                                                } else {
                                                                                    z4 = false;
                                                                                }
                                                                                String str113 = (String) objectRef9.element;
                                                                                boolean z10 = booleanRef5.element;
                                                                                boolean z11 = booleanRef6.element;
                                                                                if (i2 != 0) {
                                                                                    z5 = true;
                                                                                } else {
                                                                                    z5 = false;
                                                                                }
                                                                                StreamPlay.LinkData linkData3 = new StreamPlay.LinkData(num13, str8, null, str110, num4, num5, null, null, null, str111, num6, str112, z4, null, null, null, str113, null, null, z10, z11, false, null, null, false, Boxing.boxBoolean(z5), 31908292, null);
                                                                                String json3 = AppUtils.INSTANCE.toJson(linkData3);
                                                                                StreamPlay streamPlay3 = new StreamPlay(this.sharedPref);
                                                                                c02702.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                                                                                c02702.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                                                c02702.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                                                                                c02702.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject);
                                                                                c02702.L$4 = SpillingKt.nullOutSpilledVariable(objectRef12);
                                                                                c02702.L$5 = SpillingKt.nullOutSpilledVariable(num6);
                                                                                c02702.L$6 = SpillingKt.nullOutSpilledVariable(str8);
                                                                                c02702.L$7 = SpillingKt.nullOutSpilledVariable(num4);
                                                                                c02702.L$8 = SpillingKt.nullOutSpilledVariable(num5);
                                                                                c02702.L$9 = SpillingKt.nullOutSpilledVariable(objectRef8);
                                                                                c02702.L$10 = SpillingKt.nullOutSpilledVariable(booleanRef5);
                                                                                c02702.L$11 = SpillingKt.nullOutSpilledVariable(booleanRef6);
                                                                                c02702.L$12 = SpillingKt.nullOutSpilledVariable(objectRef9);
                                                                                c02702.L$13 = SpillingKt.nullOutSpilledVariable(objectRef10);
                                                                                c02702.L$14 = SpillingKt.nullOutSpilledVariable(objectRef11);
                                                                                c02702.L$15 = SpillingKt.nullOutSpilledVariable(linkData3);
                                                                                c02702.L$16 = SpillingKt.nullOutSpilledVariable(json3);
                                                                                c02702.Z$0 = z3;
                                                                                c02702.I$0 = i3;
                                                                                c02702.I$1 = i2;
                                                                                c02702.label = 2;
                                                                                objLoadLinks = streamPlay3.loadLinks(json3, z3, function5, function6, c02702);
                                                                                if (objLoadLinks == obj2) {
                                                                                    return obj2;
                                                                                }
                                                                                return objLoadLinks;
                                                                            }
                                                                            i3 = i4;
                                                                            booleanRef5 = booleanRef3;
                                                                            num6 = num7;
                                                                            z3 = z2;
                                                                            num5 = num2;
                                                                            num4 = num;
                                                                            objectRef12 = objectRef14;
                                                                            booleanRef6 = booleanRef4;
                                                                            objectRef9 = objectRef2;
                                                                            str8 = str9;
                                                                            objectRef8 = objectRef13;
                                                                            objectRef10 = objectRef3;
                                                                            function6 = function4;
                                                                            function5 = function3;
                                                                        } else {
                                                                            if (jSONArrayOptJSONArray2 != null) {
                                                                                jSONObject2 = null;
                                                                            } else {
                                                                                jSONObject2 = null;
                                                                            }
                                                                            if (jSONObject2 != null) {
                                                                                objectRef6.element = Boxing.boxInt(jSONObject2.optInt("id"));
                                                                                strOptString3 = jSONObject2.optString(str6);
                                                                                if (StringsKt.isBlank(strOptString3)) {
                                                                                    strOptString3 = null;
                                                                                }
                                                                                if (strOptString3 == null) {
                                                                                    strOptString3 = jSONObject2.optString(str5);
                                                                                    if (StringsKt.isBlank(strOptString3)) {
                                                                                        strOptString3 = null;
                                                                                    }
                                                                                    if (strOptString3 == null) {
                                                                                        objectRef17 = objectRef7;
                                                                                        strOptString3 = (String) objectRef17.element;
                                                                                    } else {
                                                                                        objectRef17 = objectRef7;
                                                                                    }
                                                                                    objectRef17.element = strOptString3;
                                                                                    String strOptString8 = jSONObject2.optString("original_title");
                                                                                    if (StringsKt.isBlank(strOptString8)) {
                                                                                    }
                                                                                    if (strOptString4 == null) {
                                                                                        strOptString4 = jSONObject2.optString("original_name");
                                                                                    }
                                                                                    objectRef3.element = strOptString4;
                                                                                    strOptString5 = jSONObject2.optString("original_language");
                                                                                    objectRef16 = objectRef17;
                                                                                    objectRef15 = objectRef6;
                                                                                    booleanRef3.element = CollectionsKt.listOf(new String[]{"ja", "ko", "zh", "th"}).contains(strOptString5);
                                                                                    booleanRef4.element = Intrinsics.areEqual(strOptString5, "hi");
                                                                                    if (Intrinsics.areEqual(strOptString5, "ja")) {
                                                                                        objectRef2.element = objectRef3.element;
                                                                                    }
                                                                                } else {
                                                                                    objectRef17 = objectRef7;
                                                                                    objectRef17.element = strOptString3;
                                                                                    String strOptString9 = jSONObject2.optString("original_title");
                                                                                    if (StringsKt.isBlank(strOptString9)) {
                                                                                    }
                                                                                    if (strOptString4 == null) {
                                                                                        strOptString4 = jSONObject2.optString("original_name");
                                                                                    }
                                                                                    objectRef3.element = strOptString4;
                                                                                    strOptString5 = jSONObject2.optString("original_language");
                                                                                    objectRef16 = objectRef17;
                                                                                    objectRef15 = objectRef6;
                                                                                    booleanRef3.element = CollectionsKt.listOf(new String[]{"ja", "ko", "zh", "th"}).contains(strOptString5);
                                                                                    booleanRef4.element = Intrinsics.areEqual(strOptString5, "hi");
                                                                                    if (Intrinsics.areEqual(strOptString5, "ja")) {
                                                                                        objectRef2.element = objectRef3.element;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                objectRef15 = objectRef6;
                                                                                objectRef16 = objectRef7;
                                                                            }
                                                                            Result.constructor-impl(Unit.INSTANCE);
                                                                            objectRef11 = objectRef4;
                                                                            objectRef14 = objectRef16;
                                                                            objectRef13 = objectRef15;
                                                                            str9 = str7;
                                                                            i4 = i;
                                                                            num7 = num3;
                                                                            i3 = i4;
                                                                            booleanRef5 = booleanRef3;
                                                                            num6 = num7;
                                                                            z3 = z2;
                                                                            num5 = num2;
                                                                            num4 = num;
                                                                            objectRef12 = objectRef14;
                                                                            booleanRef6 = booleanRef4;
                                                                            objectRef9 = objectRef2;
                                                                            str8 = str9;
                                                                            objectRef8 = objectRef13;
                                                                            objectRef10 = objectRef3;
                                                                            function6 = function4;
                                                                            function5 = function3;
                                                                        }
                                                                        break;
                                                                    } catch (Throwable th8) {
                                                                        th = th8;
                                                                        booleanRef2 = booleanRef4;
                                                                        objectRef5 = objectRef7;
                                                                        str3 = str7;
                                                                        objectRef = objectRef6;
                                                                        booleanRef = booleanRef3;
                                                                    }
                                                                    return objLoadLinks;
                                                                } catch (Throwable th9) {
                                                                    th = th9;
                                                                    c02702 = c02702;
                                                                    num = num9;
                                                                    num2 = num10;
                                                                    str4 = str;
                                                                    z2 = z;
                                                                    booleanRef = booleanRef7;
                                                                    booleanRef2 = booleanRef8;
                                                                    objectRef2 = objectRef19;
                                                                    objectRef3 = objectRef20;
                                                                    objectRef4 = objectRef21;
                                                                    jSONObject = jSONObject3;
                                                                    objectRef5 = objectRef18;
                                                                    num3 = num8;
                                                                    i = zOptBoolean ? 1 : 0;
                                                                    i2 = i5;
                                                                    function3 = function1;
                                                                    function4 = function2;
                                                                    Result.Companion companion9 = Result.Companion;
                                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                                    objectRef11 = objectRef4;
                                                                    booleanRef4 = booleanRef2;
                                                                    booleanRef3 = booleanRef;
                                                                    objectRef13 = objectRef;
                                                                    objectRef14 = objectRef5;
                                                                    str9 = str3;
                                                                    i4 = i;
                                                                    num7 = num3;
                                                                    i3 = i4;
                                                                    booleanRef5 = booleanRef3;
                                                                    num6 = num7;
                                                                    z3 = z2;
                                                                    num5 = num2;
                                                                    num4 = num;
                                                                    objectRef12 = objectRef14;
                                                                    booleanRef6 = booleanRef4;
                                                                    objectRef9 = objectRef2;
                                                                    str8 = str9;
                                                                    objectRef8 = objectRef13;
                                                                    objectRef10 = objectRef3;
                                                                    function6 = function4;
                                                                    function5 = function3;
                                                                    Integer num14 = (Integer) objectRef8.element;
                                                                    String str114 = (String) objectRef11.element;
                                                                    String str115 = (String) objectRef12.element;
                                                                    String str116 = (String) objectRef10.element;
                                                                    if (i3 != 0) {
                                                                        z4 = true;
                                                                    } else {
                                                                        z4 = false;
                                                                    }
                                                                    String str117 = (String) objectRef9.element;
                                                                    boolean z12 = booleanRef5.element;
                                                                    boolean z13 = booleanRef6.element;
                                                                    if (i2 != 0) {
                                                                        z5 = true;
                                                                    } else {
                                                                        z5 = false;
                                                                    }
                                                                    StreamPlay.LinkData linkData4 = new StreamPlay.LinkData(num14, str8, null, str114, num4, num5, null, null, null, str115, num6, str116, z4, null, null, null, str117, null, null, z12, z13, false, null, null, false, Boxing.boxBoolean(z5), 31908292, null);
                                                                    String json4 = AppUtils.INSTANCE.toJson(linkData4);
                                                                    StreamPlay streamPlay4 = new StreamPlay(this.sharedPref);
                                                                    c02702.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                                                                    c02702.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                                    c02702.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                                                                    c02702.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject);
                                                                    c02702.L$4 = SpillingKt.nullOutSpilledVariable(objectRef12);
                                                                    c02702.L$5 = SpillingKt.nullOutSpilledVariable(num6);
                                                                    c02702.L$6 = SpillingKt.nullOutSpilledVariable(str8);
                                                                    c02702.L$7 = SpillingKt.nullOutSpilledVariable(num4);
                                                                    c02702.L$8 = SpillingKt.nullOutSpilledVariable(num5);
                                                                    c02702.L$9 = SpillingKt.nullOutSpilledVariable(objectRef8);
                                                                    c02702.L$10 = SpillingKt.nullOutSpilledVariable(booleanRef5);
                                                                    c02702.L$11 = SpillingKt.nullOutSpilledVariable(booleanRef6);
                                                                    c02702.L$12 = SpillingKt.nullOutSpilledVariable(objectRef9);
                                                                    c02702.L$13 = SpillingKt.nullOutSpilledVariable(objectRef10);
                                                                    c02702.L$14 = SpillingKt.nullOutSpilledVariable(objectRef11);
                                                                    c02702.L$15 = SpillingKt.nullOutSpilledVariable(linkData4);
                                                                    c02702.L$16 = SpillingKt.nullOutSpilledVariable(json4);
                                                                    c02702.Z$0 = z3;
                                                                    c02702.I$0 = i3;
                                                                    c02702.I$1 = i2;
                                                                    c02702.label = 2;
                                                                    objLoadLinks = streamPlay4.loadLinks(json4, z3, function5, function6, c02702);
                                                                    if (objLoadLinks == obj2) {
                                                                        return obj2;
                                                                    }
                                                                    return objLoadLinks;
                                                                }
                                                            } catch (Throwable th10) {
                                                                th = th10;
                                                                obj2 = coroutine_suspended;
                                                                str3 = str10;
                                                                num = num9;
                                                                num2 = num10;
                                                                str4 = str;
                                                                z2 = z;
                                                                booleanRef = booleanRef7;
                                                                booleanRef2 = booleanRef8;
                                                                objectRef2 = objectRef19;
                                                                objectRef3 = objectRef20;
                                                                objectRef4 = objectRef21;
                                                                jSONObject = jSONObject3;
                                                                objectRef5 = objectRef18;
                                                                num3 = num8;
                                                                i = zOptBoolean ? 1 : 0;
                                                                i2 = i5;
                                                                function3 = function1;
                                                                function4 = function2;
                                                            }
                                                        } catch (Throwable th11) {
                                                            th = th11;
                                                            obj2 = coroutine_suspended;
                                                            str3 = str10;
                                                            num = num9;
                                                            num2 = num10;
                                                            str4 = str;
                                                            z2 = z;
                                                            booleanRef = booleanRef7;
                                                            booleanRef2 = booleanRef8;
                                                            objectRef2 = objectRef19;
                                                            objectRef3 = objectRef20;
                                                            objectRef4 = objectRef21;
                                                            jSONObject = jSONObject3;
                                                            objectRef5 = objectRef18;
                                                            num3 = num8;
                                                            i = zOptBoolean ? 1 : 0;
                                                            i2 = i5;
                                                            function3 = function1;
                                                            function4 = function2;
                                                        }
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                        obj2 = coroutine_suspended;
                                                        str3 = str10;
                                                        num = num9;
                                                        num2 = num10;
                                                        str4 = str;
                                                        z2 = z;
                                                        booleanRef = booleanRef7;
                                                        booleanRef2 = booleanRef8;
                                                        objectRef2 = objectRef19;
                                                        objectRef3 = objectRef20;
                                                        objectRef4 = objectRef21;
                                                        jSONObject = jSONObject3;
                                                        objectRef5 = objectRef18;
                                                        num3 = num8;
                                                        i = zOptBoolean ? 1 : 0;
                                                        i2 = i5;
                                                        function3 = function1;
                                                        function4 = function2;
                                                    }
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    obj2 = coroutine_suspended;
                                                    str3 = str10;
                                                    num = num9;
                                                    num2 = num10;
                                                    str4 = str;
                                                    z2 = z;
                                                    booleanRef = booleanRef7;
                                                    booleanRef2 = booleanRef8;
                                                    objectRef2 = objectRef19;
                                                    objectRef3 = objectRef20;
                                                    objectRef4 = objectRef21;
                                                    jSONObject = jSONObject3;
                                                    objectRef5 = objectRef18;
                                                    num3 = num8;
                                                    i = zOptBoolean ? 1 : 0;
                                                    i2 = i5;
                                                    function3 = function1;
                                                    function4 = function2;
                                                }
                                            } catch (Throwable th14) {
                                                th = th14;
                                                obj2 = coroutine_suspended;
                                                str3 = str10;
                                                num = num9;
                                                num2 = num10;
                                                str4 = str;
                                                z2 = z;
                                                booleanRef = booleanRef7;
                                                booleanRef2 = booleanRef8;
                                                objectRef2 = objectRef19;
                                                objectRef3 = objectRef20;
                                                objectRef4 = objectRef21;
                                                jSONObject = jSONObject3;
                                                objectRef5 = objectRef18;
                                                num3 = num8;
                                                i = zOptBoolean ? 1 : 0;
                                                i2 = i5;
                                                function3 = function1;
                                                function4 = function2;
                                            }
                                        } catch (Throwable th15) {
                                            th = th15;
                                            obj2 = coroutine_suspended;
                                            str3 = str10;
                                            num = num9;
                                            num2 = num10;
                                            str4 = str;
                                            z2 = z;
                                            booleanRef = booleanRef7;
                                            booleanRef2 = booleanRef8;
                                            objectRef2 = objectRef19;
                                            objectRef3 = objectRef20;
                                            objectRef4 = objectRef21;
                                            jSONObject = jSONObject3;
                                            objectRef5 = objectRef18;
                                            num3 = num8;
                                            i = zOptBoolean ? 1 : 0;
                                            i2 = i5;
                                            function3 = function1;
                                            function4 = function2;
                                        }
                                    } catch (Throwable th16) {
                                        th = th16;
                                        obj2 = coroutine_suspended;
                                        objectRef = objectRef;
                                        str3 = str10;
                                        num = num9;
                                        num2 = num10;
                                        str4 = str;
                                        z2 = z;
                                        booleanRef = booleanRef7;
                                        booleanRef2 = booleanRef8;
                                        objectRef2 = objectRef19;
                                        objectRef3 = objectRef20;
                                        objectRef4 = objectRef21;
                                        jSONObject = jSONObject3;
                                        objectRef5 = objectRef18;
                                        num3 = num8;
                                        i = zOptBoolean ? 1 : 0;
                                        i2 = i5;
                                        function3 = function1;
                                        function4 = function2;
                                    }
                                } catch (Throwable th17) {
                                    th = th17;
                                    obj2 = coroutine_suspended;
                                    str3 = str10;
                                    num = num9;
                                    num2 = num10;
                                    str4 = str;
                                    z2 = z;
                                    booleanRef = booleanRef7;
                                    booleanRef2 = booleanRef8;
                                    objectRef2 = objectRef19;
                                    objectRef3 = objectRef20;
                                    objectRef4 = objectRef21;
                                    jSONObject = jSONObject3;
                                    objectRef5 = objectRef18;
                                    num3 = num8;
                                    i = zOptBoolean ? 1 : 0;
                                    i2 = i5;
                                    function3 = function1;
                                    function4 = function2;
                                }
                            } catch (Throwable th18) {
                                th = th18;
                                obj2 = coroutine_suspended;
                                str3 = str10;
                                num = num9;
                                num2 = num10;
                                str4 = str;
                                z2 = z;
                                booleanRef = booleanRef7;
                                booleanRef2 = booleanRef8;
                                objectRef2 = objectRef19;
                                objectRef3 = objectRef20;
                                objectRef4 = objectRef21;
                                jSONObject = jSONObject3;
                                objectRef5 = objectRef18;
                                num3 = num8;
                                i = zOptBoolean ? 1 : 0;
                                i2 = i5;
                                function3 = function1;
                                function4 = function2;
                            }
                        } catch (Throwable th19) {
                            th = th19;
                            obj2 = coroutine_suspended;
                            str3 = str10;
                            num = num9;
                            num2 = num10;
                            str4 = str;
                            z2 = z;
                            booleanRef = booleanRef7;
                            booleanRef2 = booleanRef8;
                            objectRef2 = objectRef19;
                            objectRef3 = objectRef20;
                            objectRef4 = objectRef21;
                            jSONObject = jSONObject3;
                            objectRef5 = objectRef18;
                            num3 = num8;
                            i = zOptBoolean ? 1 : 0;
                            i2 = i5;
                            function3 = function1;
                            function4 = function2;
                        }
                    } catch (Throwable th20) {
                        th = th20;
                        obj2 = coroutine_suspended;
                        str3 = str10;
                        num = num9;
                        num2 = num10;
                        str4 = str;
                        z2 = z;
                        booleanRef = booleanRef7;
                        booleanRef2 = booleanRef8;
                        objectRef2 = objectRef19;
                        objectRef3 = objectRef20;
                        objectRef4 = objectRef21;
                        jSONObject = jSONObject3;
                        objectRef5 = objectRef18;
                        num3 = num8;
                        i = zOptBoolean ? 1 : 0;
                        i2 = i5;
                        function3 = function1;
                        function4 = function2;
                    }
                } else {
                    obj2 = coroutine_suspended;
                    str4 = str;
                    z3 = z;
                    function5 = function1;
                    function6 = function2;
                    num4 = num9;
                    num5 = num10;
                    objectRef8 = objectRef;
                    booleanRef5 = booleanRef7;
                    booleanRef6 = booleanRef8;
                    objectRef9 = objectRef19;
                    objectRef10 = objectRef20;
                    objectRef11 = objectRef21;
                    jSONObject = jSONObject3;
                    objectRef12 = objectRef18;
                    num6 = num8;
                    i3 = zOptBoolean ? 1 : 0;
                    str8 = str10;
                    i2 = i5;
                }
                Integer num15 = (Integer) objectRef8.element;
                String str118 = (String) objectRef11.element;
                String str119 = (String) objectRef12.element;
                String str1110 = (String) objectRef10.element;
                if (i3 != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                String str1111 = (String) objectRef9.element;
                boolean z14 = booleanRef5.element;
                boolean z15 = booleanRef6.element;
                if (i2 != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                StreamPlay.LinkData linkData5 = new StreamPlay.LinkData(num15, str8, null, str118, num4, num5, null, null, null, str119, num6, str1110, z4, null, null, null, str1111, null, null, z14, z15, false, null, null, false, Boxing.boxBoolean(z5), 31908292, null);
                String json5 = AppUtils.INSTANCE.toJson(linkData5);
                StreamPlay streamPlay5 = new StreamPlay(this.sharedPref);
                c02702.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                c02702.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c02702.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                c02702.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject);
                c02702.L$4 = SpillingKt.nullOutSpilledVariable(objectRef12);
                c02702.L$5 = SpillingKt.nullOutSpilledVariable(num6);
                c02702.L$6 = SpillingKt.nullOutSpilledVariable(str8);
                c02702.L$7 = SpillingKt.nullOutSpilledVariable(num4);
                c02702.L$8 = SpillingKt.nullOutSpilledVariable(num5);
                c02702.L$9 = SpillingKt.nullOutSpilledVariable(objectRef8);
                c02702.L$10 = SpillingKt.nullOutSpilledVariable(booleanRef5);
                c02702.L$11 = SpillingKt.nullOutSpilledVariable(booleanRef6);
                c02702.L$12 = SpillingKt.nullOutSpilledVariable(objectRef9);
                c02702.L$13 = SpillingKt.nullOutSpilledVariable(objectRef10);
                c02702.L$14 = SpillingKt.nullOutSpilledVariable(objectRef11);
                c02702.L$15 = SpillingKt.nullOutSpilledVariable(linkData5);
                c02702.L$16 = SpillingKt.nullOutSpilledVariable(json5);
                c02702.Z$0 = z3;
                c02702.I$0 = i3;
                c02702.I$1 = i2;
                c02702.label = 2;
                objLoadLinks = streamPlay5.loadLinks(json5, z3, function5, function6, c02702);
                if (objLoadLinks == obj2) {
                    return obj2;
                }
                return objLoadLinks;
            case 1:
                i2 = c02702.I$1;
                i = c02702.I$0;
                z2 = c02702.Z$0;
                objectRef4 = (Ref.ObjectRef) c02702.L$14;
                objectRef3 = (Ref.ObjectRef) c02702.L$13;
                objectRef2 = (Ref.ObjectRef) c02702.L$12;
                booleanRef2 = (Ref.BooleanRef) c02702.L$11;
                booleanRef = (Ref.BooleanRef) c02702.L$10;
                Ref.ObjectRef objectRef22 = (Ref.ObjectRef) c02702.L$9;
                num2 = (Integer) c02702.L$8;
                num = (Integer) c02702.L$7;
                str7 = (String) c02702.L$6;
                num3 = (Integer) c02702.L$5;
                objectRef5 = (Ref.ObjectRef) c02702.L$4;
                jSONObject = (JSONObject) c02702.L$3;
                function4 = (Function1) c02702.L$2;
                function3 = (Function1) c02702.L$1;
                str4 = (String) c02702.L$0;
                try {
                    ResultKt.throwOnFailure(objLoadLinks);
                    obj2 = coroutine_suspended;
                    str5 = "name";
                    str6 = "title";
                    objArr = 0;
                    booleanRef4 = booleanRef2;
                    booleanRef3 = booleanRef;
                    objectRef6 = objectRef22;
                    objectRef7 = objectRef5;
                    JSONObject jSONObject7 = new JSONObject(((NiceResponse) objLoadLinks).getText());
                    jSONArrayOptJSONArray = jSONObject7.optJSONArray("movie_results");
                    jSONArrayOptJSONArray2 = jSONObject7.optJSONArray("tv_results");
                    if (jSONArrayOptJSONArray != null) {
                        if (jSONArrayOptJSONArray.length() > 0) {
                            JSONObject jSONObject8 = jSONArrayOptJSONArray.getJSONObject(0);
                            objectRef4.element = "movie";
                            jSONObject2 = jSONObject8;
                        } else if (jSONArrayOptJSONArray2 != null) {
                            jSONObject2 = null;
                        } else {
                            jSONObject2 = null;
                        }
                        if (jSONObject2 != null) {
                            objectRef6.element = Boxing.boxInt(jSONObject2.optInt("id"));
                            strOptString3 = jSONObject2.optString(str6);
                            if (StringsKt.isBlank(strOptString3)) {
                                strOptString3 = null;
                            }
                            if (strOptString3 == null) {
                                strOptString3 = jSONObject2.optString(str5);
                                if (StringsKt.isBlank(strOptString3)) {
                                    strOptString3 = null;
                                }
                                if (strOptString3 == null) {
                                    objectRef17 = objectRef7;
                                    strOptString3 = (String) objectRef17.element;
                                } else {
                                    objectRef17 = objectRef7;
                                }
                                objectRef17.element = strOptString3;
                                String strOptString10 = jSONObject2.optString("original_title");
                                if (StringsKt.isBlank(strOptString10)) {
                                }
                                if (strOptString4 == null) {
                                    strOptString4 = jSONObject2.optString("original_name");
                                }
                                objectRef3.element = strOptString4;
                                strOptString5 = jSONObject2.optString("original_language");
                                objectRef16 = objectRef17;
                                objectRef15 = objectRef6;
                                booleanRef3.element = CollectionsKt.listOf(new String[]{"ja", "ko", "zh", "th"}).contains(strOptString5);
                                booleanRef4.element = Intrinsics.areEqual(strOptString5, "hi");
                                if (Intrinsics.areEqual(strOptString5, "ja")) {
                                    objectRef2.element = objectRef3.element;
                                }
                            } else {
                                objectRef17 = objectRef7;
                                objectRef17.element = strOptString3;
                                String strOptString11 = jSONObject2.optString("original_title");
                                if (StringsKt.isBlank(strOptString11)) {
                                }
                                if (strOptString4 == null) {
                                    strOptString4 = jSONObject2.optString("original_name");
                                }
                                objectRef3.element = strOptString4;
                                strOptString5 = jSONObject2.optString("original_language");
                                objectRef16 = objectRef17;
                                objectRef15 = objectRef6;
                                booleanRef3.element = CollectionsKt.listOf(new String[]{"ja", "ko", "zh", "th"}).contains(strOptString5);
                                booleanRef4.element = Intrinsics.areEqual(strOptString5, "hi");
                                if (Intrinsics.areEqual(strOptString5, "ja")) {
                                    objectRef2.element = objectRef3.element;
                                }
                            }
                        } else {
                            objectRef15 = objectRef6;
                            objectRef16 = objectRef7;
                        }
                        Result.constructor-impl(Unit.INSTANCE);
                        objectRef11 = objectRef4;
                        objectRef14 = objectRef16;
                        objectRef13 = objectRef15;
                        str9 = str7;
                        i4 = i;
                        num7 = num3;
                        i3 = i4;
                        booleanRef5 = booleanRef3;
                        num6 = num7;
                        z3 = z2;
                        num5 = num2;
                        num4 = num;
                        objectRef12 = objectRef14;
                        booleanRef6 = booleanRef4;
                        objectRef9 = objectRef2;
                        str8 = str9;
                        objectRef8 = objectRef13;
                        objectRef10 = objectRef3;
                        function6 = function4;
                        function5 = function3;
                        Integer num16 = (Integer) objectRef8.element;
                        String str1112 = (String) objectRef11.element;
                        String str1113 = (String) objectRef12.element;
                        String str1114 = (String) objectRef10.element;
                        if (i3 != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        String str1115 = (String) objectRef9.element;
                        boolean z16 = booleanRef5.element;
                        boolean z17 = booleanRef6.element;
                        if (i2 != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        StreamPlay.LinkData linkData6 = new StreamPlay.LinkData(num16, str8, null, str1112, num4, num5, null, null, null, str1113, num6, str1114, z4, null, null, null, str1115, null, null, z16, z17, false, null, null, false, Boxing.boxBoolean(z5), 31908292, null);
                        String json6 = AppUtils.INSTANCE.toJson(linkData6);
                        StreamPlay streamPlay6 = new StreamPlay(this.sharedPref);
                        c02702.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                        c02702.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c02702.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                        c02702.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject);
                        c02702.L$4 = SpillingKt.nullOutSpilledVariable(objectRef12);
                        c02702.L$5 = SpillingKt.nullOutSpilledVariable(num6);
                        c02702.L$6 = SpillingKt.nullOutSpilledVariable(str8);
                        c02702.L$7 = SpillingKt.nullOutSpilledVariable(num4);
                        c02702.L$8 = SpillingKt.nullOutSpilledVariable(num5);
                        c02702.L$9 = SpillingKt.nullOutSpilledVariable(objectRef8);
                        c02702.L$10 = SpillingKt.nullOutSpilledVariable(booleanRef5);
                        c02702.L$11 = SpillingKt.nullOutSpilledVariable(booleanRef6);
                        c02702.L$12 = SpillingKt.nullOutSpilledVariable(objectRef9);
                        c02702.L$13 = SpillingKt.nullOutSpilledVariable(objectRef10);
                        c02702.L$14 = SpillingKt.nullOutSpilledVariable(objectRef11);
                        c02702.L$15 = SpillingKt.nullOutSpilledVariable(linkData6);
                        c02702.L$16 = SpillingKt.nullOutSpilledVariable(json6);
                        c02702.Z$0 = z3;
                        c02702.I$0 = i3;
                        c02702.I$1 = i2;
                        c02702.label = 2;
                        objLoadLinks = streamPlay6.loadLinks(json6, z3, function5, function6, c02702);
                        if (objLoadLinks == obj2) {
                            return obj2;
                        }
                    } else {
                        if (jSONArrayOptJSONArray2 != null) {
                            jSONObject2 = null;
                        } else {
                            jSONObject2 = null;
                        }
                        if (jSONObject2 != null) {
                            objectRef6.element = Boxing.boxInt(jSONObject2.optInt("id"));
                            strOptString3 = jSONObject2.optString(str6);
                            if (StringsKt.isBlank(strOptString3)) {
                                strOptString3 = null;
                            }
                            if (strOptString3 == null) {
                                strOptString3 = jSONObject2.optString(str5);
                                if (StringsKt.isBlank(strOptString3)) {
                                    strOptString3 = null;
                                }
                                if (strOptString3 == null) {
                                    objectRef17 = objectRef7;
                                    strOptString3 = (String) objectRef17.element;
                                } else {
                                    objectRef17 = objectRef7;
                                }
                                objectRef17.element = strOptString3;
                                String strOptString12 = jSONObject2.optString("original_title");
                                if (StringsKt.isBlank(strOptString12)) {
                                }
                                if (strOptString4 == null) {
                                    strOptString4 = jSONObject2.optString("original_name");
                                }
                                objectRef3.element = strOptString4;
                                strOptString5 = jSONObject2.optString("original_language");
                                objectRef16 = objectRef17;
                                objectRef15 = objectRef6;
                                booleanRef3.element = CollectionsKt.listOf(new String[]{"ja", "ko", "zh", "th"}).contains(strOptString5);
                                booleanRef4.element = Intrinsics.areEqual(strOptString5, "hi");
                                if (Intrinsics.areEqual(strOptString5, "ja")) {
                                    objectRef2.element = objectRef3.element;
                                }
                            } else {
                                objectRef17 = objectRef7;
                                objectRef17.element = strOptString3;
                                String strOptString13 = jSONObject2.optString("original_title");
                                if (StringsKt.isBlank(strOptString13)) {
                                }
                                if (strOptString4 == null) {
                                    strOptString4 = jSONObject2.optString("original_name");
                                }
                                objectRef3.element = strOptString4;
                                strOptString5 = jSONObject2.optString("original_language");
                                objectRef16 = objectRef17;
                                objectRef15 = objectRef6;
                                booleanRef3.element = CollectionsKt.listOf(new String[]{"ja", "ko", "zh", "th"}).contains(strOptString5);
                                booleanRef4.element = Intrinsics.areEqual(strOptString5, "hi");
                                if (Intrinsics.areEqual(strOptString5, "ja")) {
                                    objectRef2.element = objectRef3.element;
                                }
                            }
                        } else {
                            objectRef15 = objectRef6;
                            objectRef16 = objectRef7;
                        }
                        Result.constructor-impl(Unit.INSTANCE);
                        objectRef11 = objectRef4;
                        objectRef14 = objectRef16;
                        objectRef13 = objectRef15;
                        str9 = str7;
                        i4 = i;
                        num7 = num3;
                        i3 = i4;
                        booleanRef5 = booleanRef3;
                        num6 = num7;
                        z3 = z2;
                        num5 = num2;
                        num4 = num;
                        objectRef12 = objectRef14;
                        booleanRef6 = booleanRef4;
                        objectRef9 = objectRef2;
                        str8 = str9;
                        objectRef8 = objectRef13;
                        objectRef10 = objectRef3;
                        function6 = function4;
                        function5 = function3;
                        Integer num17 = (Integer) objectRef8.element;
                        String str1116 = (String) objectRef11.element;
                        String str1117 = (String) objectRef12.element;
                        String str1118 = (String) objectRef10.element;
                        if (i3 != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        String str1119 = (String) objectRef9.element;
                        boolean z18 = booleanRef5.element;
                        boolean z19 = booleanRef6.element;
                        if (i2 != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        StreamPlay.LinkData linkData7 = new StreamPlay.LinkData(num17, str8, null, str1116, num4, num5, null, null, null, str1117, num6, str1118, z4, null, null, null, str1119, null, null, z18, z19, false, null, null, false, Boxing.boxBoolean(z5), 31908292, null);
                        String json7 = AppUtils.INSTANCE.toJson(linkData7);
                        StreamPlay streamPlay7 = new StreamPlay(this.sharedPref);
                        c02702.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                        c02702.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c02702.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                        c02702.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject);
                        c02702.L$4 = SpillingKt.nullOutSpilledVariable(objectRef12);
                        c02702.L$5 = SpillingKt.nullOutSpilledVariable(num6);
                        c02702.L$6 = SpillingKt.nullOutSpilledVariable(str8);
                        c02702.L$7 = SpillingKt.nullOutSpilledVariable(num4);
                        c02702.L$8 = SpillingKt.nullOutSpilledVariable(num5);
                        c02702.L$9 = SpillingKt.nullOutSpilledVariable(objectRef8);
                        c02702.L$10 = SpillingKt.nullOutSpilledVariable(booleanRef5);
                        c02702.L$11 = SpillingKt.nullOutSpilledVariable(booleanRef6);
                        c02702.L$12 = SpillingKt.nullOutSpilledVariable(objectRef9);
                        c02702.L$13 = SpillingKt.nullOutSpilledVariable(objectRef10);
                        c02702.L$14 = SpillingKt.nullOutSpilledVariable(objectRef11);
                        c02702.L$15 = SpillingKt.nullOutSpilledVariable(linkData7);
                        c02702.L$16 = SpillingKt.nullOutSpilledVariable(json7);
                        c02702.Z$0 = z3;
                        c02702.I$0 = i3;
                        c02702.I$1 = i2;
                        c02702.label = 2;
                        objLoadLinks = streamPlay7.loadLinks(json7, z3, function5, function6, c02702);
                        if (objLoadLinks == obj2) {
                            return obj2;
                        }
                    }
                } catch (Throwable th21) {
                    th = th21;
                    obj2 = coroutine_suspended;
                    str3 = str7;
                    objectRef = objectRef22;
                    Result.Companion companion10 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                    objectRef11 = objectRef4;
                    booleanRef4 = booleanRef2;
                    booleanRef3 = booleanRef;
                    objectRef13 = objectRef;
                    objectRef14 = objectRef5;
                    str9 = str3;
                    i4 = i;
                    num7 = num3;
                    i3 = i4;
                    booleanRef5 = booleanRef3;
                    num6 = num7;
                    z3 = z2;
                    num5 = num2;
                    num4 = num;
                    objectRef12 = objectRef14;
                    booleanRef6 = booleanRef4;
                    objectRef9 = objectRef2;
                    str8 = str9;
                    objectRef8 = objectRef13;
                    objectRef10 = objectRef3;
                    function6 = function4;
                    function5 = function3;
                    Integer num18 = (Integer) objectRef8.element;
                    String str11110 = (String) objectRef11.element;
                    String str11111 = (String) objectRef12.element;
                    String str11112 = (String) objectRef10.element;
                    if (i3 != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    String str11113 = (String) objectRef9.element;
                    boolean z110 = booleanRef5.element;
                    boolean z111 = booleanRef6.element;
                    if (i2 != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    StreamPlay.LinkData linkData8 = new StreamPlay.LinkData(num18, str8, null, str11110, num4, num5, null, null, null, str11111, num6, str11112, z4, null, null, null, str11113, null, null, z110, z111, false, null, null, false, Boxing.boxBoolean(z5), 31908292, null);
                    String json8 = AppUtils.INSTANCE.toJson(linkData8);
                    StreamPlay streamPlay8 = new StreamPlay(this.sharedPref);
                    c02702.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                    c02702.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c02702.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                    c02702.L$3 = SpillingKt.nullOutSpilledVariable(jSONObject);
                    c02702.L$4 = SpillingKt.nullOutSpilledVariable(objectRef12);
                    c02702.L$5 = SpillingKt.nullOutSpilledVariable(num6);
                    c02702.L$6 = SpillingKt.nullOutSpilledVariable(str8);
                    c02702.L$7 = SpillingKt.nullOutSpilledVariable(num4);
                    c02702.L$8 = SpillingKt.nullOutSpilledVariable(num5);
                    c02702.L$9 = SpillingKt.nullOutSpilledVariable(objectRef8);
                    c02702.L$10 = SpillingKt.nullOutSpilledVariable(booleanRef5);
                    c02702.L$11 = SpillingKt.nullOutSpilledVariable(booleanRef6);
                    c02702.L$12 = SpillingKt.nullOutSpilledVariable(objectRef9);
                    c02702.L$13 = SpillingKt.nullOutSpilledVariable(objectRef10);
                    c02702.L$14 = SpillingKt.nullOutSpilledVariable(objectRef11);
                    c02702.L$15 = SpillingKt.nullOutSpilledVariable(linkData8);
                    c02702.L$16 = SpillingKt.nullOutSpilledVariable(json8);
                    c02702.Z$0 = z3;
                    c02702.I$0 = i3;
                    c02702.I$1 = i2;
                    c02702.label = 2;
                    objLoadLinks = streamPlay8.loadLinks(json8, z3, function5, function6, c02702);
                    if (objLoadLinks == obj2) {
                        return obj2;
                    }
                    return objLoadLinks;
                }
                return objLoadLinks;
            case 2:
                int i6 = c02702.I$1;
                int i7 = c02702.I$0;
                boolean z20 = c02702.Z$0;
                ResultKt.throwOnFailure(objLoadLinks);
                return objLoadLinks;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
