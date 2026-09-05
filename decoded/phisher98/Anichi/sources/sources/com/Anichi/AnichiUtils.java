package com.Anichi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import io.ktor.http.HttpUrlEncodedKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anichi/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\rJ8\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u0013J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u001bJ\n\u0010\u001c\u001a\u00020\u0007*\u00020\u0007J\n\u0010\u001d\u001a\u00020\u0007*\u00020\u0007J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0007R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/Anichi/AnichiUtils;", "", "<init>", "()V", "getTracker", "Lcom/Anichi/AnichiParser$AniMedia;", "name", "", "altName", "year", "", "season", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchId", "title", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aniToMal", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "embedBlackList", "", "getM3u8Qualities", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "m3u8Link", "referer", "qualityName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHost", "fixUrlPath", "fixSourceUrls", "url", "source", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnichiUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnichiUtils.kt\ncom/Anichi/AnichiUtils\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,580:1\n73#2,5:581\n73#2,5:612\n2198#3,5:586\n1960#3,3:592\n1960#3,3:595\n2204#3,2:598\n1960#3,3:600\n1960#3,3:603\n2206#3,6:606\n1#4:591\n1#4:620\n93#5,2:617\n63#5:619\n64#5,15:621\n95#5,2:638\n50#6:636\n43#6:637\n*S KotlinDebug\n*F\n+ 1 AnichiUtils.kt\ncom/Anichi/AnichiUtils\n*L\n101#1:581,5\n143#1:612,5\n107#1:586,5\n126#1:592,3\n129#1:595,3\n107#1:598,2\n126#1:600,3\n129#1:603,3\n107#1:606,6\n189#1:620\n189#1:617,2\n189#1:619\n189#1:621,15\n189#1:638,2\n189#1:636\n189#1:637\n*E\n"})
public final class AnichiUtils {

    @NotNull
    public static final AnichiUtils INSTANCE = new AnichiUtils();

    @NotNull
    private static final List<String> embedBlackList = CollectionsKt.listOf(new String[]{"https://mp4upload.com/", "https://streamsb.net/", "https://dood.to/", "https://videobin.co/", "https://ok.ru", "https://streamlare.com", "https://filemoon", "streaming.php"});

    /* JADX INFO: renamed from: com.Anichi.AnichiUtils$aniToMal$1 */
    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiUtils", f = "AnichiUtils.kt", i = {0}, l = {136}, m = "aniToMal", n = {"id"}, nl = {143}, s = {"L$0"}, v = 2)
    static final class C00201 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00201(Continuation<? super C00201> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnichiUtils.this.aniToMal(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.AnichiUtils$fetchId$1 */
    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiUtils", f = "AnichiUtils.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {100}, m = "fetchId", n = {"title", "year", "season", "type", "query", "variables", "body"}, nl = {101}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00211 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00211(Continuation<? super C00211> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnichiUtils.this.fetchId(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.AnichiUtils$getTracker$1 */
    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiUtils", f = "AnichiUtils.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {60, 63}, m = "getTracker", n = {"name", "altName", "year", "season", "type", "name", "altName", "year", "season", "type", "primary"}, nl = {61, 64}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00221 extends ContinuationImpl {
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
            return AnichiUtils.this.getTracker(null, null, null, null, null, (Continuation) this);
        }
    }

    private AnichiUtils() {
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0099  */
    /* JADX WARN: Code duplicated, block: B:21:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:26:0x00d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ec A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public final Object getTracker(@Nullable String name, @Nullable String altName, @Nullable Integer year, @Nullable String season, @Nullable String type, @NotNull Continuation<? super AnichiParser.AniMedia> continuation) {
        C00221 c00221;
        Object objFetchId;
        Integer year2;
        String season2;
        String type2;
        String season3;
        AnichiParser.AniMedia primary;
        Integer numBoxInt;
        Object objFetchId2;
        AnichiParser.AniMedia secondary;
        Integer numBoxInt2;
        if (continuation instanceof C00221) {
            c00221 = (C00221) continuation;
            if ((c00221.label & Integer.MIN_VALUE) != 0) {
                c00221.label -= Integer.MIN_VALUE;
            } else {
                c00221 = new C00221(continuation);
            }
        } else {
            c00221 = new C00221(continuation);
        }
        C00221 c00222 = c00221;
        Object $result = c00222.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00222.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00222.L$0 = SpillingKt.nullOutSpilledVariable(name);
                c00222.L$1 = altName;
                c00222.L$2 = year;
                c00222.L$3 = season;
                c00222.L$4 = type;
                c00222.label = 1;
                objFetchId = fetchId(name, year, season, type, c00222);
                if (objFetchId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                year2 = year;
                season2 = season;
                type2 = type;
                season3 = altName;
                primary = (AnichiParser.AniMedia) objFetchId;
                if (primary != null) {
                    numBoxInt = Boxing.boxInt(primary.getId());
                } else {
                    numBoxInt = null;
                }
                if (numBoxInt != null) {
                    return primary;
                }
                c00222.L$0 = SpillingKt.nullOutSpilledVariable(name);
                c00222.L$1 = SpillingKt.nullOutSpilledVariable(season3);
                c00222.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                c00222.L$3 = SpillingKt.nullOutSpilledVariable(season2);
                c00222.L$4 = SpillingKt.nullOutSpilledVariable(type2);
                c00222.L$5 = SpillingKt.nullOutSpilledVariable(primary);
                c00222.label = 2;
                objFetchId2 = fetchId(season3, year2, season2, type2, c00222);
                if (objFetchId2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                secondary = (AnichiParser.AniMedia) objFetchId2;
                if (secondary != null) {
                    numBoxInt2 = Boxing.boxInt(secondary.getId());
                } else {
                    numBoxInt2 = null;
                }
                if (numBoxInt2 != null) {
                    return secondary;
                }
                return null;
            case 1:
                String type3 = (String) c00222.L$4;
                String season4 = (String) c00222.L$3;
                year2 = (Integer) c00222.L$2;
                String altName2 = (String) c00222.L$1;
                name = (String) c00222.L$0;
                ResultKt.throwOnFailure($result);
                objFetchId = $result;
                type2 = type3;
                season2 = season4;
                season3 = altName2;
                primary = (AnichiParser.AniMedia) objFetchId;
                if (primary != null) {
                    numBoxInt = Boxing.boxInt(primary.getId());
                } else {
                    numBoxInt = null;
                }
                if (numBoxInt != null) {
                    return primary;
                }
                c00222.L$0 = SpillingKt.nullOutSpilledVariable(name);
                c00222.L$1 = SpillingKt.nullOutSpilledVariable(season3);
                c00222.L$2 = SpillingKt.nullOutSpilledVariable(year2);
                c00222.L$3 = SpillingKt.nullOutSpilledVariable(season2);
                c00222.L$4 = SpillingKt.nullOutSpilledVariable(type2);
                c00222.L$5 = SpillingKt.nullOutSpilledVariable(primary);
                c00222.label = 2;
                objFetchId2 = fetchId(season3, year2, season2, type2, c00222);
                if (objFetchId2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                secondary = (AnichiParser.AniMedia) objFetchId2;
                if (secondary != null) {
                    numBoxInt2 = Boxing.boxInt(secondary.getId());
                } else {
                    numBoxInt2 = null;
                }
                if (numBoxInt2 != null) {
                    return secondary;
                }
                return null;
            case 2:
                ResultKt.throwOnFailure($result);
                objFetchId2 = $result;
                secondary = (AnichiParser.AniMedia) objFetchId2;
                if (secondary != null) {
                    numBoxInt2 = Boxing.boxInt(secondary.getId());
                } else {
                    numBoxInt2 = null;
                }
                if (numBoxInt2 != null) {
                    return secondary;
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0258  */
    /* JADX WARN: Code duplicated, block: B:105:0x026d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0282  */
    /* JADX WARN: Code duplicated, block: B:113:0x029d  */
    /* JADX WARN: Code duplicated, block: B:116:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:119:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:122:0x02c9 A[LOOP:4: B:117:0x02ac->B:122:0x02c9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:125:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:128:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:131:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:134:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:137:0x0313 A[LOOP:3: B:132:0x02ef->B:137:0x0313, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:140:0x031f  */
    /* JADX WARN: Code duplicated, block: B:144:0x032f  */
    /* JADX WARN: Code duplicated, block: B:147:0x033e  */
    /* JADX WARN: Code duplicated, block: B:150:0x0347  */
    /* JADX WARN: Code duplicated, block: B:153:0x0350  */
    /* JADX WARN: Code duplicated, block: B:157:0x0359  */
    /* JADX WARN: Code duplicated, block: B:159:0x035c  */
    /* JADX WARN: Code duplicated, block: B:161:0x0362  */
    /* JADX WARN: Code duplicated, block: B:164:0x036b  */
    /* JADX WARN: Code duplicated, block: B:166:0x036e  */
    /* JADX WARN: Code duplicated, block: B:169:0x037d  */
    /* JADX WARN: Code duplicated, block: B:172:0x0393  */
    /* JADX WARN: Code duplicated, block: B:175:0x039b  */
    /* JADX WARN: Code duplicated, block: B:180:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:185:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:188:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:191:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:194:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:197:0x040c A[LOOP:2: B:192:0x03ef->B:197:0x040c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:200:0x0416  */
    /* JADX WARN: Code duplicated, block: B:203:0x0423  */
    /* JADX WARN: Code duplicated, block: B:206:0x042f  */
    /* JADX WARN: Code duplicated, block: B:209:0x0439  */
    /* JADX WARN: Code duplicated, block: B:212:0x0457 A[LOOP:1: B:207:0x0433->B:212:0x0457, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:215:0x0464  */
    /* JADX WARN: Code duplicated, block: B:218:0x046a  */
    /* JADX WARN: Code duplicated, block: B:236:0x045e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:237:0x0455 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:238:0x0411 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:239:0x040a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:240:0x031a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:241:0x0311 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x02ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:0x02c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x017f  */
    /* JADX WARN: Code duplicated, block: B:60:0x01c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:63:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:64:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:67:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:69:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:72:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:75:0x0206  */
    /* JADX WARN: Code duplicated, block: B:78:0x020d  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0216  */
    /* JADX WARN: Code duplicated, block: B:84:0x0219  */
    /* JADX WARN: Code duplicated, block: B:86:0x021f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0228  */
    /* JADX WARN: Code duplicated, block: B:91:0x022b  */
    /* JADX WARN: Code duplicated, block: B:94:0x023a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0250  */
    @Nullable
    public final Object fetchId(@Nullable String title, @Nullable Integer year, @Nullable String season, @Nullable String type, @NotNull Continuation<? super AnichiParser.AniMedia> continuation) {
        C00211 c00211;
        String title2;
        Integer year2;
        String type2;
        ArrayList media;
        Iterator iterator$iv;
        AnichiParser.AniMedia media2;
        int score;
        String str;
        boolean z;
        List $this$fetchId_u24lambda_u240_u240;
        AnichiParser.Title title3;
        AnichiParser.Title title4;
        AnichiParser.Title title5;
        List<String> synonyms;
        Iterable $this$any$iv;
        Iterator it;
        boolean z2;
        Iterator it2;
        String it3;
        Iterable $this$any$iv2;
        Iterable $this$any$iv3;
        Iterator it4;
        boolean z3;
        String it5;
        Iterable $this$any$iv4;
        Iterator it6;
        int maxValue$iv;
        Object e$iv;
        AnichiParser.AniMedia media3;
        int score2;
        Object e$iv2;
        AnichiParser.AniMedia media4;
        String str2;
        boolean z4;
        List $this$fetchId_u24lambda_u240_u241;
        AnichiParser.Title title6;
        AnichiParser.Title title7;
        AnichiParser.Title title8;
        List<String> synonyms2;
        Iterable $this$any$iv5;
        Iterator it7;
        boolean z5;
        Iterator it8;
        String it9;
        Iterable $this$any$iv6;
        Iterable $this$any$iv7;
        Iterator it10;
        boolean z6;
        String it11;
        Iterable $this$any$iv8;
        Iterator it12;
        String it13;
        String it14;
        String it15;
        String format;
        boolean z7;
        Integer seasonYear;
        String it16;
        String it17;
        String it18;
        String format2;
        boolean z8;
        Integer seasonYear2;
        Object safe;
        AnichiParser.AniSearch aniSearch;
        AnichiParser.AniData data;
        AnichiParser.AniPage page;
        if (continuation instanceof C00211) {
            c00211 = (C00211) continuation;
            if ((c00211.label & Integer.MIN_VALUE) != 0) {
                c00211.label -= Integer.MIN_VALUE;
            } else {
                c00211 = new C00211(continuation);
            }
        } else {
            c00211 = new C00211(continuation);
        }
        C00211 c00212 = c00211;
        Object $result = c00212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object maxElem$iv = null;
        switch (c00212.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str3 = title;
                if (str3 == null || StringsKt.isBlank(str3)) {
                    return null;
                }
                Map variables = MapsKt.mapOf(new Pair[]{TuplesKt.to("search", title), TuplesKt.to("type", "ANIME")});
                RequestBody body = RequestBody.Companion.create(AppUtils.INSTANCE.toJson(MapsKt.mapOf(new Pair[]{TuplesKt.to("query", "query ($search: String, $type: MediaType) {\n  Page(perPage: 10) {\n    media(search: $search, type: $type) {\n      id\n      idMal\n      seasonYear\n      format\n      title { romaji english native }\n      synonyms\n      coverImage { extraLarge large }\n      bannerImage\n    }\n  }\n}"), TuplesKt.to("variables", variables)})), MediaType.Companion.parse("application/json;charset=utf-8"));
                try {
                    Requests app = MainActivityKt.getApp();
                    try {
                        c00212.L$0 = title;
                        c00212.L$1 = year;
                        c00212.L$2 = SpillingKt.nullOutSpilledVariable(season);
                        c00212.L$3 = type;
                        c00212.L$4 = SpillingKt.nullOutSpilledVariable("query ($search: String, $type: MediaType) {\n  Page(perPage: 10) {\n    media(search: $search, type: $type) {\n      id\n      idMal\n      seasonYear\n      format\n      title { romaji english native }\n      synonyms\n      coverImage { extraLarge large }\n      bannerImage\n    }\n  }\n}");
                        c00212.L$5 = SpillingKt.nullOutSpilledVariable(variables);
                        c00212.L$6 = SpillingKt.nullOutSpilledVariable(body);
                        c00212.label = 1;
                        try {
                            $result = Requests.post$default(app, Anichi.anilistApi, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, body, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00212, 65278, (Object) null);
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            title2 = title;
                            year2 = year;
                            type2 = type;
                            try {
                                NiceResponse this_$iv = (NiceResponse) $result;
                                try {
                                    ResponseParser parser = this_$iv.getParser();
                                    Intrinsics.checkNotNull(parser);
                                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AnichiParser.AniSearch.class));
                                } catch (Exception e$iv3) {
                                    e$iv3.printStackTrace();
                                    safe = null;
                                }
                                aniSearch = (AnichiParser.AniSearch) safe;
                                if (aniSearch != null || (data = aniSearch.getData()) == null || (page = data.getPage()) == null) {
                                    media = null;
                                } else {
                                    media = page.getMedia();
                                }
                                break;
                            } catch (Throwable th) {
                                media = null;
                            }
                            if (media == null) {
                                return null;
                            }
                            ArrayList $this$maxByOrNull$iv = media;
                            iterator$iv = $this$maxByOrNull$iv.iterator();
                            if (!iterator$iv.hasNext()) {
                                maxElem$iv = iterator$iv.next();
                                if (!iterator$iv.hasNext()) {
                                    media2 = (AnichiParser.AniMedia) maxElem$iv;
                                    score = 0;
                                    if (year2 != null) {
                                        seasonYear2 = media2.getSeasonYear();
                                        int iIntValue = year2.intValue();
                                        if (seasonYear2 != null && seasonYear2.intValue() == iIntValue) {
                                            score = 0 + 3;
                                        }
                                    }
                                    str = type2;
                                    if (str != null || StringsKt.isBlank(str)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (!z) {
                                        format2 = media2.getFormat();
                                        if (format2 == null && StringsKt.equals(format2, type2, true)) {
                                            z8 = true;
                                        } else {
                                            z8 = false;
                                        }
                                        if (z8) {
                                            score += 2;
                                        }
                                    }
                                    $this$fetchId_u24lambda_u240_u240 = CollectionsKt.createListBuilder();
                                    title3 = media2.getTitle();
                                    if (title3 == null && (it18 = title3.getRomaji()) != null) {
                                        Boxing.boxBoolean($this$fetchId_u24lambda_u240_u240.add(it18));
                                    }
                                    title4 = media2.getTitle();
                                    if (title4 != null && (it17 = title4.getEnglish()) != null) {
                                        Boxing.boxBoolean($this$fetchId_u24lambda_u240_u240.add(it17));
                                    }
                                    title5 = media2.getTitle();
                                    if (title5 != null && (it16 = title5.getNative()) != null) {
                                        Boxing.boxBoolean($this$fetchId_u24lambda_u240_u240.add(it16));
                                    }
                                    synonyms = media2.getSynonyms();
                                    if (synonyms != null) {
                                        $this$fetchId_u24lambda_u240_u240.addAll(synonyms);
                                    }
                                    Iterable titles = CollectionsKt.build($this$fetchId_u24lambda_u240_u240);
                                    $this$any$iv = titles;
                                    if (($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                                        it = $this$any$iv.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                Object element$iv = it.next();
                                                it2 = it;
                                                it3 = (String) element$iv;
                                                $this$any$iv2 = $this$any$iv;
                                                if (StringsKt.equals(it3, title2, true)) {
                                                    z2 = true;
                                                } else {
                                                    it = it2;
                                                    $this$any$iv = $this$any$iv2;
                                                }
                                            } else {
                                                z2 = false;
                                            }
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        score += 5;
                                    }
                                    $this$any$iv3 = titles;
                                    if (($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
                                        it4 = $this$any$iv3.iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                Object element$iv2 = it4.next();
                                                it5 = (String) element$iv2;
                                                $this$any$iv4 = $this$any$iv3;
                                                it6 = it4;
                                                if (StringsKt.contains(it5, title2, true)) {
                                                    z3 = true;
                                                } else {
                                                    $this$any$iv3 = $this$any$iv4;
                                                    it4 = it6;
                                                }
                                            } else {
                                                z3 = false;
                                            }
                                        }
                                    } else {
                                        z3 = false;
                                    }
                                    if (z3) {
                                        score += 2;
                                    }
                                    maxValue$iv = score;
                                    do {
                                        e$iv = iterator$iv.next();
                                        media3 = (AnichiParser.AniMedia) e$iv;
                                        score2 = 0;
                                        if (year2 != null) {
                                            seasonYear = media3.getSeasonYear();
                                            e$iv2 = e$iv;
                                            int iIntValue2 = year2.intValue();
                                            media4 = media3;
                                            if (seasonYear != null && seasonYear.intValue() == iIntValue2) {
                                                score2 = 0 + 3;
                                            }
                                        } else {
                                            e$iv2 = e$iv;
                                            media4 = media3;
                                        }
                                        str2 = type2;
                                        if (str2 != null || StringsKt.isBlank(str2)) {
                                            z4 = true;
                                        } else {
                                            z4 = false;
                                        }
                                        if (!z4) {
                                            format = media4.getFormat();
                                            if (format == null && StringsKt.equals(format, type2, true)) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            if (z7) {
                                                score2 += 2;
                                            }
                                        }
                                        $this$fetchId_u24lambda_u240_u241 = CollectionsKt.createListBuilder();
                                        title6 = media4.getTitle();
                                        if (title6 == null && (it15 = title6.getRomaji()) != null) {
                                            Boxing.boxBoolean($this$fetchId_u24lambda_u240_u241.add(it15));
                                        }
                                        title7 = media4.getTitle();
                                        if (title7 != null && (it14 = title7.getEnglish()) != null) {
                                            Boxing.boxBoolean($this$fetchId_u24lambda_u240_u241.add(it14));
                                        }
                                        title8 = media4.getTitle();
                                        if (title8 != null && (it13 = title8.getNative()) != null) {
                                            Boxing.boxBoolean($this$fetchId_u24lambda_u240_u241.add(it13));
                                        }
                                        synonyms2 = media4.getSynonyms();
                                        if (synonyms2 != null) {
                                            $this$fetchId_u24lambda_u240_u241.addAll(synonyms2);
                                        }
                                        Iterable titles2 = CollectionsKt.build($this$fetchId_u24lambda_u240_u241);
                                        $this$any$iv5 = titles2;
                                        if (($this$any$iv5 instanceof Collection) || !((Collection) $this$any$iv5).isEmpty()) {
                                            it7 = $this$any$iv5.iterator();
                                            while (true) {
                                                if (it7.hasNext()) {
                                                    Object element$iv3 = it7.next();
                                                    it8 = it7;
                                                    it9 = (String) element$iv3;
                                                    $this$any$iv6 = $this$any$iv5;
                                                    if (StringsKt.equals(it9, title2, true)) {
                                                        z5 = true;
                                                    } else {
                                                        it7 = it8;
                                                        $this$any$iv5 = $this$any$iv6;
                                                    }
                                                } else {
                                                    z5 = false;
                                                }
                                            }
                                        } else {
                                            z5 = false;
                                        }
                                        if (z5) {
                                            score2 += 5;
                                        }
                                        $this$any$iv7 = titles2;
                                        if (($this$any$iv7 instanceof Collection) || !((Collection) $this$any$iv7).isEmpty()) {
                                            it10 = $this$any$iv7.iterator();
                                            while (true) {
                                                if (it10.hasNext()) {
                                                    Object element$iv4 = it10.next();
                                                    it11 = (String) element$iv4;
                                                    $this$any$iv8 = $this$any$iv7;
                                                    it12 = it10;
                                                    if (StringsKt.contains(it11, title2, true)) {
                                                        z6 = true;
                                                    } else {
                                                        $this$any$iv7 = $this$any$iv8;
                                                        it10 = it12;
                                                    }
                                                } else {
                                                    z6 = false;
                                                }
                                            }
                                        } else {
                                            z6 = false;
                                        }
                                        if (z6) {
                                            score2 += 2;
                                        }
                                        if (maxValue$iv < score2) {
                                            Object maxElem$iv2 = e$iv2;
                                            maxValue$iv = score2;
                                            maxElem$iv = maxElem$iv2;
                                        }
                                    } while (iterator$iv.hasNext());
                                }
                            }
                            return maxElem$iv;
                        } catch (Throwable th2) {
                            title2 = title;
                            year2 = year;
                            type2 = type;
                            media = null;
                            if (media == null) {
                                return null;
                            }
                            ArrayList $this$maxByOrNull$iv2 = media;
                            iterator$iv = $this$maxByOrNull$iv2.iterator();
                            if (!iterator$iv.hasNext()) {
                                maxElem$iv = iterator$iv.next();
                                if (!iterator$iv.hasNext()) {
                                    media2 = (AnichiParser.AniMedia) maxElem$iv;
                                    score = 0;
                                    if (year2 != null) {
                                        seasonYear2 = media2.getSeasonYear();
                                        int iIntValue3 = year2.intValue();
                                        if (seasonYear2 != null) {
                                            score = 0 + 3;
                                        }
                                    }
                                    str = type2;
                                    if (str != null) {
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                    if (!z) {
                                        format2 = media2.getFormat();
                                        if (format2 == null) {
                                            z8 = false;
                                        } else {
                                            z8 = false;
                                        }
                                        if (z8) {
                                            score += 2;
                                        }
                                    }
                                    $this$fetchId_u24lambda_u240_u240 = CollectionsKt.createListBuilder();
                                    title3 = media2.getTitle();
                                    if (title3 == null) {
                                    }
                                    title4 = media2.getTitle();
                                    if (title4 != null) {
                                        Boxing.boxBoolean($this$fetchId_u24lambda_u240_u240.add(it17));
                                    }
                                    title5 = media2.getTitle();
                                    if (title5 != null) {
                                        Boxing.boxBoolean($this$fetchId_u24lambda_u240_u240.add(it16));
                                    }
                                    synonyms = media2.getSynonyms();
                                    if (synonyms != null) {
                                        $this$fetchId_u24lambda_u240_u240.addAll(synonyms);
                                    }
                                    Iterable titles3 = CollectionsKt.build($this$fetchId_u24lambda_u240_u240);
                                    $this$any$iv = titles3;
                                    if ($this$any$iv instanceof Collection) {
                                        it = $this$any$iv.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                Object element$iv5 = it.next();
                                                it2 = it;
                                                it3 = (String) element$iv5;
                                                $this$any$iv2 = $this$any$iv;
                                                if (StringsKt.equals(it3, title2, true)) {
                                                    z2 = true;
                                                } else {
                                                    it = it2;
                                                    $this$any$iv = $this$any$iv2;
                                                }
                                            } else {
                                                z2 = false;
                                            }
                                        }
                                    } else {
                                        it = $this$any$iv.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                Object element$iv6 = it.next();
                                                it2 = it;
                                                it3 = (String) element$iv6;
                                                $this$any$iv2 = $this$any$iv;
                                                if (StringsKt.equals(it3, title2, true)) {
                                                    z2 = true;
                                                } else {
                                                    it = it2;
                                                    $this$any$iv = $this$any$iv2;
                                                }
                                            } else {
                                                z2 = false;
                                            }
                                        }
                                    }
                                    if (z2) {
                                        score += 5;
                                    }
                                    $this$any$iv3 = titles3;
                                    if ($this$any$iv3 instanceof Collection) {
                                        it4 = $this$any$iv3.iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                Object element$iv7 = it4.next();
                                                it5 = (String) element$iv7;
                                                $this$any$iv4 = $this$any$iv3;
                                                it6 = it4;
                                                if (StringsKt.contains(it5, title2, true)) {
                                                    z3 = true;
                                                } else {
                                                    $this$any$iv3 = $this$any$iv4;
                                                    it4 = it6;
                                                }
                                            } else {
                                                z3 = false;
                                            }
                                        }
                                    } else {
                                        it4 = $this$any$iv3.iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                Object element$iv8 = it4.next();
                                                it5 = (String) element$iv8;
                                                $this$any$iv4 = $this$any$iv3;
                                                it6 = it4;
                                                if (StringsKt.contains(it5, title2, true)) {
                                                    z3 = true;
                                                } else {
                                                    $this$any$iv3 = $this$any$iv4;
                                                    it4 = it6;
                                                }
                                            } else {
                                                z3 = false;
                                            }
                                        }
                                    }
                                    if (z3) {
                                        score += 2;
                                    }
                                    maxValue$iv = score;
                                    do {
                                        e$iv = iterator$iv.next();
                                        media3 = (AnichiParser.AniMedia) e$iv;
                                        score2 = 0;
                                        if (year2 != null) {
                                            seasonYear = media3.getSeasonYear();
                                            e$iv2 = e$iv;
                                            int iIntValue4 = year2.intValue();
                                            media4 = media3;
                                            if (seasonYear != null) {
                                                score2 = 0 + 3;
                                            }
                                        } else {
                                            e$iv2 = e$iv;
                                            media4 = media3;
                                        }
                                        str2 = type2;
                                        if (str2 != null) {
                                            z4 = true;
                                        } else {
                                            z4 = true;
                                        }
                                        if (!z4) {
                                            format = media4.getFormat();
                                            if (format == null) {
                                                z7 = false;
                                            } else {
                                                z7 = false;
                                            }
                                            if (z7) {
                                                score2 += 2;
                                            }
                                        }
                                        $this$fetchId_u24lambda_u240_u241 = CollectionsKt.createListBuilder();
                                        title6 = media4.getTitle();
                                        if (title6 == null) {
                                        }
                                        title7 = media4.getTitle();
                                        if (title7 != null) {
                                            Boxing.boxBoolean($this$fetchId_u24lambda_u240_u241.add(it14));
                                        }
                                        title8 = media4.getTitle();
                                        if (title8 != null) {
                                            Boxing.boxBoolean($this$fetchId_u24lambda_u240_u241.add(it13));
                                        }
                                        synonyms2 = media4.getSynonyms();
                                        if (synonyms2 != null) {
                                            $this$fetchId_u24lambda_u240_u241.addAll(synonyms2);
                                        }
                                        Iterable titles4 = CollectionsKt.build($this$fetchId_u24lambda_u240_u241);
                                        $this$any$iv5 = titles4;
                                        if ($this$any$iv5 instanceof Collection) {
                                            it7 = $this$any$iv5.iterator();
                                            while (true) {
                                                if (it7.hasNext()) {
                                                    Object element$iv9 = it7.next();
                                                    it8 = it7;
                                                    it9 = (String) element$iv9;
                                                    $this$any$iv6 = $this$any$iv5;
                                                    if (StringsKt.equals(it9, title2, true)) {
                                                        z5 = true;
                                                    } else {
                                                        it7 = it8;
                                                        $this$any$iv5 = $this$any$iv6;
                                                    }
                                                } else {
                                                    z5 = false;
                                                }
                                            }
                                        } else {
                                            it7 = $this$any$iv5.iterator();
                                            while (true) {
                                                if (it7.hasNext()) {
                                                    Object element$iv10 = it7.next();
                                                    it8 = it7;
                                                    it9 = (String) element$iv10;
                                                    $this$any$iv6 = $this$any$iv5;
                                                    if (StringsKt.equals(it9, title2, true)) {
                                                        z5 = true;
                                                    } else {
                                                        it7 = it8;
                                                        $this$any$iv5 = $this$any$iv6;
                                                    }
                                                } else {
                                                    z5 = false;
                                                }
                                            }
                                        }
                                        if (z5) {
                                            score2 += 5;
                                        }
                                        $this$any$iv7 = titles4;
                                        if ($this$any$iv7 instanceof Collection) {
                                            it10 = $this$any$iv7.iterator();
                                            while (true) {
                                                if (it10.hasNext()) {
                                                    Object element$iv11 = it10.next();
                                                    it11 = (String) element$iv11;
                                                    $this$any$iv8 = $this$any$iv7;
                                                    it12 = it10;
                                                    if (StringsKt.contains(it11, title2, true)) {
                                                        z6 = true;
                                                    } else {
                                                        $this$any$iv7 = $this$any$iv8;
                                                        it10 = it12;
                                                    }
                                                } else {
                                                    z6 = false;
                                                }
                                            }
                                        } else {
                                            it10 = $this$any$iv7.iterator();
                                            while (true) {
                                                if (it10.hasNext()) {
                                                    Object element$iv12 = it10.next();
                                                    it11 = (String) element$iv12;
                                                    $this$any$iv8 = $this$any$iv7;
                                                    it12 = it10;
                                                    if (StringsKt.contains(it11, title2, true)) {
                                                        z6 = true;
                                                    } else {
                                                        $this$any$iv7 = $this$any$iv8;
                                                        it10 = it12;
                                                    }
                                                } else {
                                                    z6 = false;
                                                }
                                            }
                                        }
                                        if (z6) {
                                            score2 += 2;
                                        }
                                        if (maxValue$iv < score2) {
                                            Object maxElem$iv3 = e$iv2;
                                            maxValue$iv = score2;
                                            maxElem$iv = maxElem$iv3;
                                        }
                                    } while (iterator$iv.hasNext());
                                }
                            }
                            return maxElem$iv;
                        }
                    } catch (Throwable th3) {
                        title2 = title;
                        year2 = year;
                        type2 = type;
                    }
                } catch (Throwable th4) {
                    title2 = title;
                    year2 = year;
                    type2 = type;
                }
                break;
            case 1:
                type2 = (String) c00212.L$3;
                year2 = (Integer) c00212.L$1;
                String title9 = (String) c00212.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    title2 = title9;
                    NiceResponse this_$iv2 = (NiceResponse) $result;
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(AnichiParser.AniSearch.class));
                    aniSearch = (AnichiParser.AniSearch) safe;
                    if (aniSearch != null) {
                        media = null;
                    } else {
                        media = null;
                    }
                } catch (Throwable th5) {
                    title2 = title9;
                    media = null;
                    if (media == null) {
                        return null;
                    }
                    ArrayList $this$maxByOrNull$iv3 = media;
                    iterator$iv = $this$maxByOrNull$iv3.iterator();
                    if (!iterator$iv.hasNext()) {
                        maxElem$iv = iterator$iv.next();
                        if (!iterator$iv.hasNext()) {
                            media2 = (AnichiParser.AniMedia) maxElem$iv;
                            score = 0;
                            if (year2 != null) {
                                seasonYear2 = media2.getSeasonYear();
                                int iIntValue5 = year2.intValue();
                                if (seasonYear2 != null) {
                                    score = 0 + 3;
                                }
                            }
                            str = type2;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                format2 = media2.getFormat();
                                if (format2 == null) {
                                    z8 = false;
                                } else {
                                    z8 = false;
                                }
                                if (z8) {
                                    score += 2;
                                }
                            }
                            $this$fetchId_u24lambda_u240_u240 = CollectionsKt.createListBuilder();
                            title3 = media2.getTitle();
                            if (title3 == null) {
                            }
                            title4 = media2.getTitle();
                            if (title4 != null) {
                                Boxing.boxBoolean($this$fetchId_u24lambda_u240_u240.add(it17));
                            }
                            title5 = media2.getTitle();
                            if (title5 != null) {
                                Boxing.boxBoolean($this$fetchId_u24lambda_u240_u240.add(it16));
                            }
                            synonyms = media2.getSynonyms();
                            if (synonyms != null) {
                                $this$fetchId_u24lambda_u240_u240.addAll(synonyms);
                            }
                            Iterable titles5 = CollectionsKt.build($this$fetchId_u24lambda_u240_u240);
                            $this$any$iv = titles5;
                            if ($this$any$iv instanceof Collection) {
                                it = $this$any$iv.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Object element$iv13 = it.next();
                                        it2 = it;
                                        it3 = (String) element$iv13;
                                        $this$any$iv2 = $this$any$iv;
                                        if (StringsKt.equals(it3, title2, true)) {
                                            z2 = true;
                                        } else {
                                            it = it2;
                                            $this$any$iv = $this$any$iv2;
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                }
                            } else {
                                it = $this$any$iv.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Object element$iv14 = it.next();
                                        it2 = it;
                                        it3 = (String) element$iv14;
                                        $this$any$iv2 = $this$any$iv;
                                        if (StringsKt.equals(it3, title2, true)) {
                                            z2 = true;
                                        } else {
                                            it = it2;
                                            $this$any$iv = $this$any$iv2;
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                }
                            }
                            if (z2) {
                                score += 5;
                            }
                            $this$any$iv3 = titles5;
                            if ($this$any$iv3 instanceof Collection) {
                                it4 = $this$any$iv3.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        Object element$iv15 = it4.next();
                                        it5 = (String) element$iv15;
                                        $this$any$iv4 = $this$any$iv3;
                                        it6 = it4;
                                        if (StringsKt.contains(it5, title2, true)) {
                                            z3 = true;
                                        } else {
                                            $this$any$iv3 = $this$any$iv4;
                                            it4 = it6;
                                        }
                                    } else {
                                        z3 = false;
                                    }
                                }
                            } else {
                                it4 = $this$any$iv3.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        Object element$iv16 = it4.next();
                                        it5 = (String) element$iv16;
                                        $this$any$iv4 = $this$any$iv3;
                                        it6 = it4;
                                        if (StringsKt.contains(it5, title2, true)) {
                                            z3 = true;
                                        } else {
                                            $this$any$iv3 = $this$any$iv4;
                                            it4 = it6;
                                        }
                                    } else {
                                        z3 = false;
                                    }
                                }
                            }
                            if (z3) {
                                score += 2;
                            }
                            maxValue$iv = score;
                            do {
                                e$iv = iterator$iv.next();
                                media3 = (AnichiParser.AniMedia) e$iv;
                                score2 = 0;
                                if (year2 != null) {
                                    seasonYear = media3.getSeasonYear();
                                    e$iv2 = e$iv;
                                    int iIntValue6 = year2.intValue();
                                    media4 = media3;
                                    if (seasonYear != null) {
                                        score2 = 0 + 3;
                                    }
                                } else {
                                    e$iv2 = e$iv;
                                    media4 = media3;
                                }
                                str2 = type2;
                                if (str2 != null) {
                                    z4 = true;
                                } else {
                                    z4 = true;
                                }
                                if (!z4) {
                                    format = media4.getFormat();
                                    if (format == null) {
                                        z7 = false;
                                    } else {
                                        z7 = false;
                                    }
                                    if (z7) {
                                        score2 += 2;
                                    }
                                }
                                $this$fetchId_u24lambda_u240_u241 = CollectionsKt.createListBuilder();
                                title6 = media4.getTitle();
                                if (title6 == null) {
                                }
                                title7 = media4.getTitle();
                                if (title7 != null) {
                                    Boxing.boxBoolean($this$fetchId_u24lambda_u240_u241.add(it14));
                                }
                                title8 = media4.getTitle();
                                if (title8 != null) {
                                    Boxing.boxBoolean($this$fetchId_u24lambda_u240_u241.add(it13));
                                }
                                synonyms2 = media4.getSynonyms();
                                if (synonyms2 != null) {
                                    $this$fetchId_u24lambda_u240_u241.addAll(synonyms2);
                                }
                                Iterable titles6 = CollectionsKt.build($this$fetchId_u24lambda_u240_u241);
                                $this$any$iv5 = titles6;
                                if ($this$any$iv5 instanceof Collection) {
                                    it7 = $this$any$iv5.iterator();
                                    while (true) {
                                        if (it7.hasNext()) {
                                            Object element$iv17 = it7.next();
                                            it8 = it7;
                                            it9 = (String) element$iv17;
                                            $this$any$iv6 = $this$any$iv5;
                                            if (StringsKt.equals(it9, title2, true)) {
                                                z5 = true;
                                            } else {
                                                it7 = it8;
                                                $this$any$iv5 = $this$any$iv6;
                                            }
                                        } else {
                                            z5 = false;
                                        }
                                    }
                                } else {
                                    it7 = $this$any$iv5.iterator();
                                    while (true) {
                                        if (it7.hasNext()) {
                                            Object element$iv18 = it7.next();
                                            it8 = it7;
                                            it9 = (String) element$iv18;
                                            $this$any$iv6 = $this$any$iv5;
                                            if (StringsKt.equals(it9, title2, true)) {
                                                z5 = true;
                                            } else {
                                                it7 = it8;
                                                $this$any$iv5 = $this$any$iv6;
                                            }
                                        } else {
                                            z5 = false;
                                        }
                                    }
                                }
                                if (z5) {
                                    score2 += 5;
                                }
                                $this$any$iv7 = titles6;
                                if ($this$any$iv7 instanceof Collection) {
                                    it10 = $this$any$iv7.iterator();
                                    while (true) {
                                        if (it10.hasNext()) {
                                            Object element$iv19 = it10.next();
                                            it11 = (String) element$iv19;
                                            $this$any$iv8 = $this$any$iv7;
                                            it12 = it10;
                                            if (StringsKt.contains(it11, title2, true)) {
                                                z6 = true;
                                            } else {
                                                $this$any$iv7 = $this$any$iv8;
                                                it10 = it12;
                                            }
                                        } else {
                                            z6 = false;
                                        }
                                    }
                                } else {
                                    it10 = $this$any$iv7.iterator();
                                    while (true) {
                                        if (it10.hasNext()) {
                                            Object element$iv110 = it10.next();
                                            it11 = (String) element$iv110;
                                            $this$any$iv8 = $this$any$iv7;
                                            it12 = it10;
                                            if (StringsKt.contains(it11, title2, true)) {
                                                z6 = true;
                                            } else {
                                                $this$any$iv7 = $this$any$iv8;
                                                it10 = it12;
                                            }
                                        } else {
                                            z6 = false;
                                        }
                                    }
                                }
                                if (z6) {
                                    score2 += 2;
                                }
                                if (maxValue$iv < score2) {
                                    Object maxElem$iv4 = e$iv2;
                                    maxValue$iv = score2;
                                    maxElem$iv = maxElem$iv4;
                                }
                            } while (iterator$iv.hasNext());
                        }
                    }
                    return maxElem$iv;
                }
                if (media == null) {
                    return null;
                }
                ArrayList $this$maxByOrNull$iv4 = media;
                iterator$iv = $this$maxByOrNull$iv4.iterator();
                if (!iterator$iv.hasNext()) {
                    maxElem$iv = iterator$iv.next();
                    if (!iterator$iv.hasNext()) {
                        media2 = (AnichiParser.AniMedia) maxElem$iv;
                        score = 0;
                        if (year2 != null) {
                            seasonYear2 = media2.getSeasonYear();
                            int iIntValue7 = year2.intValue();
                            if (seasonYear2 != null) {
                                score = 0 + 3;
                            }
                        }
                        str = type2;
                        if (str != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            format2 = media2.getFormat();
                            if (format2 == null) {
                                z8 = false;
                            } else {
                                z8 = false;
                            }
                            if (z8) {
                                score += 2;
                            }
                        }
                        $this$fetchId_u24lambda_u240_u240 = CollectionsKt.createListBuilder();
                        title3 = media2.getTitle();
                        if (title3 == null) {
                        }
                        title4 = media2.getTitle();
                        if (title4 != null) {
                            Boxing.boxBoolean($this$fetchId_u24lambda_u240_u240.add(it17));
                        }
                        title5 = media2.getTitle();
                        if (title5 != null) {
                            Boxing.boxBoolean($this$fetchId_u24lambda_u240_u240.add(it16));
                        }
                        synonyms = media2.getSynonyms();
                        if (synonyms != null) {
                            $this$fetchId_u24lambda_u240_u240.addAll(synonyms);
                        }
                        Iterable titles7 = CollectionsKt.build($this$fetchId_u24lambda_u240_u240);
                        $this$any$iv = titles7;
                        if ($this$any$iv instanceof Collection) {
                            it = $this$any$iv.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object element$iv111 = it.next();
                                    it2 = it;
                                    it3 = (String) element$iv111;
                                    $this$any$iv2 = $this$any$iv;
                                    if (StringsKt.equals(it3, title2, true)) {
                                        z2 = true;
                                    } else {
                                        it = it2;
                                        $this$any$iv = $this$any$iv2;
                                    }
                                } else {
                                    z2 = false;
                                }
                            }
                        } else {
                            it = $this$any$iv.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object element$iv112 = it.next();
                                    it2 = it;
                                    it3 = (String) element$iv112;
                                    $this$any$iv2 = $this$any$iv;
                                    if (StringsKt.equals(it3, title2, true)) {
                                        z2 = true;
                                    } else {
                                        it = it2;
                                        $this$any$iv = $this$any$iv2;
                                    }
                                } else {
                                    z2 = false;
                                }
                            }
                        }
                        if (z2) {
                            score += 5;
                        }
                        $this$any$iv3 = titles7;
                        if ($this$any$iv3 instanceof Collection) {
                            it4 = $this$any$iv3.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    Object element$iv113 = it4.next();
                                    it5 = (String) element$iv113;
                                    $this$any$iv4 = $this$any$iv3;
                                    it6 = it4;
                                    if (StringsKt.contains(it5, title2, true)) {
                                        z3 = true;
                                    } else {
                                        $this$any$iv3 = $this$any$iv4;
                                        it4 = it6;
                                    }
                                } else {
                                    z3 = false;
                                }
                            }
                        } else {
                            it4 = $this$any$iv3.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    Object element$iv114 = it4.next();
                                    it5 = (String) element$iv114;
                                    $this$any$iv4 = $this$any$iv3;
                                    it6 = it4;
                                    if (StringsKt.contains(it5, title2, true)) {
                                        z3 = true;
                                    } else {
                                        $this$any$iv3 = $this$any$iv4;
                                        it4 = it6;
                                    }
                                } else {
                                    z3 = false;
                                }
                            }
                        }
                        if (z3) {
                            score += 2;
                        }
                        maxValue$iv = score;
                        do {
                            e$iv = iterator$iv.next();
                            media3 = (AnichiParser.AniMedia) e$iv;
                            score2 = 0;
                            if (year2 != null) {
                                seasonYear = media3.getSeasonYear();
                                e$iv2 = e$iv;
                                int iIntValue8 = year2.intValue();
                                media4 = media3;
                                if (seasonYear != null) {
                                    score2 = 0 + 3;
                                }
                            } else {
                                e$iv2 = e$iv;
                                media4 = media3;
                            }
                            str2 = type2;
                            if (str2 != null) {
                                z4 = true;
                            } else {
                                z4 = true;
                            }
                            if (!z4) {
                                format = media4.getFormat();
                                if (format == null) {
                                    z7 = false;
                                } else {
                                    z7 = false;
                                }
                                if (z7) {
                                    score2 += 2;
                                }
                            }
                            $this$fetchId_u24lambda_u240_u241 = CollectionsKt.createListBuilder();
                            title6 = media4.getTitle();
                            if (title6 == null) {
                            }
                            title7 = media4.getTitle();
                            if (title7 != null) {
                                Boxing.boxBoolean($this$fetchId_u24lambda_u240_u241.add(it14));
                            }
                            title8 = media4.getTitle();
                            if (title8 != null) {
                                Boxing.boxBoolean($this$fetchId_u24lambda_u240_u241.add(it13));
                            }
                            synonyms2 = media4.getSynonyms();
                            if (synonyms2 != null) {
                                $this$fetchId_u24lambda_u240_u241.addAll(synonyms2);
                            }
                            Iterable titles8 = CollectionsKt.build($this$fetchId_u24lambda_u240_u241);
                            $this$any$iv5 = titles8;
                            if ($this$any$iv5 instanceof Collection) {
                                it7 = $this$any$iv5.iterator();
                                while (true) {
                                    if (it7.hasNext()) {
                                        Object element$iv115 = it7.next();
                                        it8 = it7;
                                        it9 = (String) element$iv115;
                                        $this$any$iv6 = $this$any$iv5;
                                        if (StringsKt.equals(it9, title2, true)) {
                                            z5 = true;
                                        } else {
                                            it7 = it8;
                                            $this$any$iv5 = $this$any$iv6;
                                        }
                                    } else {
                                        z5 = false;
                                    }
                                }
                            } else {
                                it7 = $this$any$iv5.iterator();
                                while (true) {
                                    if (it7.hasNext()) {
                                        Object element$iv116 = it7.next();
                                        it8 = it7;
                                        it9 = (String) element$iv116;
                                        $this$any$iv6 = $this$any$iv5;
                                        if (StringsKt.equals(it9, title2, true)) {
                                            z5 = true;
                                        } else {
                                            it7 = it8;
                                            $this$any$iv5 = $this$any$iv6;
                                        }
                                    } else {
                                        z5 = false;
                                    }
                                }
                            }
                            if (z5) {
                                score2 += 5;
                            }
                            $this$any$iv7 = titles8;
                            if ($this$any$iv7 instanceof Collection) {
                                it10 = $this$any$iv7.iterator();
                                while (true) {
                                    if (it10.hasNext()) {
                                        Object element$iv117 = it10.next();
                                        it11 = (String) element$iv117;
                                        $this$any$iv8 = $this$any$iv7;
                                        it12 = it10;
                                        if (StringsKt.contains(it11, title2, true)) {
                                            z6 = true;
                                        } else {
                                            $this$any$iv7 = $this$any$iv8;
                                            it10 = it12;
                                        }
                                    } else {
                                        z6 = false;
                                    }
                                }
                            } else {
                                it10 = $this$any$iv7.iterator();
                                while (true) {
                                    if (it10.hasNext()) {
                                        Object element$iv118 = it10.next();
                                        it11 = (String) element$iv118;
                                        $this$any$iv8 = $this$any$iv7;
                                        it12 = it10;
                                        if (StringsKt.contains(it11, title2, true)) {
                                            z6 = true;
                                        } else {
                                            $this$any$iv7 = $this$any$iv8;
                                            it10 = it12;
                                        }
                                    } else {
                                        z6 = false;
                                    }
                                }
                            }
                            if (z6) {
                                score2 += 2;
                            }
                            if (maxValue$iv < score2) {
                                Object maxElem$iv5 = e$iv2;
                                maxValue$iv = score2;
                                maxElem$iv = maxElem$iv5;
                            }
                        } while (iterator$iv.hasNext());
                    }
                }
                return maxElem$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object aniToMal(@NotNull String id, @NotNull Continuation<? super String> continuation) {
        C00201 c00201;
        Object safe;
        AnichiParser.MediaAni data;
        AnichiParser.IdMal media;
        if (continuation instanceof C00201) {
            c00201 = (C00201) continuation;
            if ((c00201.label & Integer.MIN_VALUE) != 0) {
                c00201.label -= Integer.MIN_VALUE;
            } else {
                c00201 = new C00201(continuation);
            }
        } else {
            c00201 = new C00201(continuation);
        }
        C00201 c00202 = c00201;
        Object $result = c00202.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00202.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("query", "{Media(id:" + id + ",type:ANIME){idMal}}"));
                c00202.L$0 = SpillingKt.nullOutSpilledVariable(id);
                c00202.label = 1;
                $result = Requests.post$default(app, Anichi.anilistApi, (Map) null, (String) null, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 65502, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AnichiParser.DataAni.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        AnichiParser.DataAni dataAni = (AnichiParser.DataAni) safe;
        if (dataAni == null || (data = dataAni.getData()) == null || (media = data.getMedia()) == null) {
            return null;
        }
        return media.getIdMal();
    }

    @Nullable
    public final Object getM3u8Qualities(@NotNull String m3u8Link, @NotNull String referer, @NotNull String qualityName, @NotNull Continuation<? super List<? extends ExtractorLink>> continuation) {
        return M3u8Helper.Companion.generateM3u8$default(M3u8Helper.Companion, qualityName, m3u8Link, referer, (Integer) null, (Map) null, (String) null, continuation, 56, (Object) null);
    }

    @NotNull
    public final String getHost(@NotNull String $this$getHost) {
        return MainAPIKt.fixTitle(StringsKt.substringAfterLast$default(StringsKt.substringBeforeLast$default(URLUtilsKt.Url($this$getHost).getHost(), ".", (String) null, 2, (Object) null), ".", (String) null, 2, (Object) null));
    }

    @NotNull
    public final String fixUrlPath(@NotNull String $this$fixUrlPath) {
        if (StringsKt.contains$default($this$fixUrlPath, ".json?", false, 2, (Object) null)) {
            return Anichi.apiEndPoint + $this$fixUrlPath;
        }
        Url u = URLUtilsKt.Url($this$fixUrlPath);
        return Anichi.apiEndPoint + u.getEncodedPath() + ".json?" + HttpUrlEncodedKt.formUrlEncode(u.getParameters());
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00bc A[Catch: Exception -> 0x00d2, TRY_LEAVE, TryCatch #5 {Exception -> 0x00d2, blocks: (B:22:0x006d, B:29:0x009a, B:32:0x00a1, B:41:0x00bc, B:40:0x00b6, B:28:0x008f, B:21:0x0063, B:18:0x004a, B:25:0x0074, B:35:0x00a7), top: B:57:0x004a, inners: #1, #4, #6 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public final String fixSourceUrls(@NotNull String url, @Nullable String source) {
        Object objDecodeFromString;
        Object obj;
        DeserializationStrategy deserializationStrategy;
        String idUrl = null;
        if (StringsKt.startsWith$default(url, "--", false, 2, (Object) null)) {
            return url;
        }
        if (Intrinsics.areEqual(source, "Ak") || StringsKt.contains$default(url, "/player/vitemb", false, 2, (Object) null)) {
            try {
                AppUtils appUtils = AppUtils.INSTANCE;
                String value$iv = MainAPIKt.base64Decode(StringsKt.substringAfter$default(url, "=", (String) null, 2, (Object) null));
                if (value$iv == null) {
                    objDecodeFromString = null;
                } else {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(AnichiParser.AkIframe.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnichiParser.AkIframe.class), (List) null, 2, (Object) null));
                            } catch (Throwable th2) {
                                Result.Companion companion4 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(value$iv, new TypeReference<AnichiParser.AkIframe>() { // from class: com.Anichi.AnichiUtils$fixSourceUrls$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(value$iv, new TypeReference<AnichiParser.AkIframe>() { // from class: com.Anichi.AnichiUtils$fixSourceUrls$$inlined$tryParseJson$1
                                    });
                                } catch (Throwable th3) {
                                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(value$iv, new TypeReference<AnichiParser.AkIframe>() { // from class: com.Anichi.AnichiUtils$fixSourceUrls$$inlined$tryParseJson$1
                                    });
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(value$iv, new TypeReference<AnichiParser.AkIframe>() { // from class: com.Anichi.AnichiUtils$fixSourceUrls$$inlined$tryParseJson$1
                                });
                            }
                        }
                    } catch (Exception e2) {
                        objDecodeFromString = null;
                    }
                }
                AnichiParser.AkIframe akIframe = (AnichiParser.AkIframe) objDecodeFromString;
                if (akIframe != null) {
                    idUrl = akIframe.getIdUrl();
                }
            } catch (Exception e3) {
            }
            return idUrl;
        }
        return StringsKt.replace$default(url, " ", "%20", false, 4, (Object) null);
    }
}
