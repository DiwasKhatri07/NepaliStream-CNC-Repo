package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aR\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u000b\u001aR\u0010\f\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u000b\u001aF\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"invokeUindex", "", "title", "", "year", "", "season", "episode", "callback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeKnaben", "invokeTorrentio", "id", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StremioX"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStremioC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioCKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,1058:1\n1739#2:1059\n1814#2,3:1060\n2068#2,2:1064\n2068#2,2:1071\n1#3:1063\n73#4,5:1066\n*S KotlinDebug\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioCKt\n*L\n854#1:1059\n854#1:1060,3\n950#1:1064,2\n1025#1:1071,2\n1024#1:1066,5\n*E\n"})
public final class StremioCKt {

    /* JADX INFO: renamed from: com.phisher98.StremioCKt$invokeKnaben$1 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioCKt", f = "StremioC.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {948, 993}, m = "invokeKnaben", n = {"title", "year", "season", "episode", "callback", "knaben", "host", "baseQuery", "category", "url", "isTv", "page", "title", "year", "season", "episode", "callback", "knaben", "host", "baseQuery", "category", "url", "doc", "$this$forEach$iv", "element$iv", "row", "titleElement", "infoTd", "rawTitle", "magnet", "source", "tds", "sizeText", "seedsText", "qualityMatch", "formattedTitleName", "isTv", "page", "seeds"}, nl = {950, 992}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00141 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
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
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioCKt.invokeKnaben(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioCKt$invokeTorrentio$1 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioCKt", f = "StremioC.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {1024, 1043, 1046}, m = "invokeTorrentio", n = {"id", "season", "episode", "callback", "url", "headers", "id", "season", "episode", "callback", "url", "headers", "res", "$this$forEach$iv", "element$iv", "stream", "qualityMatch", "formattedTitleName", "id", "season", "episode", "callback", "url", "headers", "res", "$this$forEach$iv", "element$iv", "stream", "qualityMatch", "magnet", "formattedTitleName"}, nl = {1059, 1045, 1045}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$11", "L$12", "L$13"}, v = 2)
    static final class C00151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
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

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioCKt.invokeTorrentio(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioCKt$invokeUindex$1 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioCKt", f = "StremioC.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {844, 861}, m = "invokeUindex", n = {"title", "year", "season", "episode", "callback", "uindex", "searchQuery", "url", "headers", "isTv", "title", "year", "season", "episode", "callback", "uindex", "searchQuery", "url", "headers", "rows", "episodePatterns", "isTv"}, nl = {846, 908}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0"}, v = 2)
    static final class C00161 extends ContinuationImpl {
        int I$0;
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
        /* synthetic */ Object result;

        C00161(Continuation<? super C00161> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioCKt.invokeUindex(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:54:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:55:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:58:0x0336 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x0337  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public static final Object invokeUindex(@Nullable String title, @Nullable Integer year, @Nullable Integer season, @Nullable Integer episode, @NotNull Function1<? super ExtractorLink, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        C00161 c00161;
        int i;
        char c;
        Object obj;
        C00161 c00162;
        Integer year2;
        Integer episode2;
        Function1<? super ExtractorLink, Unit> function2;
        String url;
        Map headers;
        String url2;
        int i2;
        String searchQuery;
        Object obj2;
        Integer season2;
        String title2;
        Integer season3;
        List listEmptyList;
        List list;
        boolean z;
        C00172 c00172;
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
                int i3 = season != null ? 1 : 0;
                StringBuilder $this$invokeUindex_u24lambda_u240 = new StringBuilder();
                String str = title;
                if (!(str == null || StringsKt.isBlank(str))) {
                    $this$invokeUindex_u24lambda_u240.append(title);
                }
                if (year != null) {
                    if ($this$invokeUindex_u24lambda_u240.length() > 0) {
                        $this$invokeUindex_u24lambda_u240.append(' ');
                    }
                    $this$invokeUindex_u24lambda_u240.append(year.intValue());
                }
                String searchQuery2 = StringsKt.replace$default($this$invokeUindex_u24lambda_u240.toString(), ' ', '+', false, 4, (Object) null);
                String url3 = "https://uindex.org/search.php?search=" + searchQuery2 + "&c=" + (i3 != 0 ? 2 : 1);
                Map headers2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8"), TuplesKt.to("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36")});
                Requests app = MainActivityKt.getApp();
                c00161.L$0 = SpillingKt.nullOutSpilledVariable(title);
                c00161.L$1 = SpillingKt.nullOutSpilledVariable(year);
                c00161.L$2 = season;
                c00161.L$3 = episode;
                c00161.L$4 = function1;
                c00161.L$5 = SpillingKt.nullOutSpilledVariable("https://uindex.org");
                c00161.L$6 = SpillingKt.nullOutSpilledVariable(searchQuery2);
                c00161.L$7 = SpillingKt.nullOutSpilledVariable(url3);
                c00161.L$8 = SpillingKt.nullOutSpilledVariable(headers2);
                c00161.I$0 = i3;
                c00161.label = 1;
                int i4 = i3;
                i = 2;
                c = 1;
                C00161 c00163 = c00161;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, url3, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00163, 4092, (Object) null);
                c00162 = c00163;
                if (obj3 == obj) {
                    return obj;
                }
                year2 = year;
                episode2 = episode;
                function2 = function1;
                url = url3;
                headers = headers2;
                url2 = searchQuery2;
                i2 = i4;
                searchQuery = "https://uindex.org";
                obj2 = obj3;
                season2 = season;
                title2 = title;
                List episodePatterns = ((NiceResponse) obj2).getDocument().select("tr");
                if (i2 != 0 || episode2 == null) {
                    season3 = season2;
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Locale locale = Locale.US;
                    Object[] objArr = new Object[i];
                    objArr[0] = season2;
                    objArr[c] = episode2;
                    String str2 = String.format(locale, "S%02dE%02d", Arrays.copyOf(objArr, i));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    String string = new StringBuilder().append('S').append(season2.intValue()).append('E').append(episode2.intValue()).toString();
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    Locale locale2 = Locale.US;
                    season3 = season2;
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = season3;
                    objArr2[c] = episode2;
                    String str3 = String.format(locale2, "S%02dE%d", Arrays.copyOf(objArr2, 2));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    Locale locale3 = Locale.US;
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = season3;
                    objArr3[c] = episode2;
                    String str4 = String.format(locale3, "S%dE%02d", Arrays.copyOf(objArr3, 2));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    List rawPatterns = CollectionsKt.listOf(new String[]{str2, string, str3, str4});
                    Iterable $this$map$iv = CollectionsKt.distinct(rawPatterns);
                    int $i$f$map = 0;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    Iterable $this$mapTo$iv$iv = $this$map$iv;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        List rawPatterns2 = rawPatterns;
                        String it = (String) item$iv$iv;
                        destination$iv$iv.add(new Regex("\\b" + it + "\\b", RegexOption.IGNORE_CASE));
                        rawPatterns = rawPatterns2;
                        $this$map$iv = $this$map$iv;
                        $i$f$map = $i$f$map;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    }
                    listEmptyList = (List) destination$iv$iv;
                }
                List episodePatterns2 = listEmptyList;
                list = episodePatterns;
                if (i2 != 0) {
                    z = true;
                } else {
                    z = false;
                }
                c00172 = new C00172(z, episodePatterns2, function2, null);
                c00162.L$0 = SpillingKt.nullOutSpilledVariable(title2);
                c00162.L$1 = SpillingKt.nullOutSpilledVariable(year2);
                c00162.L$2 = SpillingKt.nullOutSpilledVariable(season3);
                c00162.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00162.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                c00162.L$5 = SpillingKt.nullOutSpilledVariable(searchQuery);
                c00162.L$6 = SpillingKt.nullOutSpilledVariable(url2);
                c00162.L$7 = SpillingKt.nullOutSpilledVariable(url);
                c00162.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                c00162.L$9 = SpillingKt.nullOutSpilledVariable(episodePatterns);
                c00162.L$10 = SpillingKt.nullOutSpilledVariable(episodePatterns2);
                c00162.I$0 = i2;
                c00162.label = 2;
                if (ParCollectionsKt.amap(list, c00172, c00162) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 1:
                int i5 = c00161.I$0;
                Map headers3 = (Map) c00161.L$8;
                String url4 = (String) c00161.L$7;
                String searchQuery3 = (String) c00161.L$6;
                String uindex = (String) c00161.L$5;
                function2 = (Function1) c00161.L$4;
                episode2 = (Integer) c00161.L$3;
                Integer season4 = (Integer) c00161.L$2;
                year2 = (Integer) c00161.L$1;
                String title3 = (String) c00161.L$0;
                ResultKt.throwOnFailure($result);
                c00162 = c00161;
                obj = coroutine_suspended;
                i2 = i5;
                headers = headers3;
                url = url4;
                url2 = searchQuery3;
                searchQuery = uindex;
                c = 1;
                season2 = season4;
                obj2 = $result;
                title2 = title3;
                i = 2;
                List episodePatterns3 = ((NiceResponse) obj2).getDocument().select("tr");
                if (i2 != 0) {
                    season3 = season2;
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    season3 = season2;
                    listEmptyList = CollectionsKt.emptyList();
                }
                List episodePatterns4 = listEmptyList;
                list = episodePatterns3;
                if (i2 != 0) {
                    z = true;
                } else {
                    z = false;
                }
                c00172 = new C00172(z, episodePatterns4, function2, null);
                c00162.L$0 = SpillingKt.nullOutSpilledVariable(title2);
                c00162.L$1 = SpillingKt.nullOutSpilledVariable(year2);
                c00162.L$2 = SpillingKt.nullOutSpilledVariable(season3);
                c00162.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c00162.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                c00162.L$5 = SpillingKt.nullOutSpilledVariable(searchQuery);
                c00162.L$6 = SpillingKt.nullOutSpilledVariable(url2);
                c00162.L$7 = SpillingKt.nullOutSpilledVariable(url);
                c00162.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                c00162.L$9 = SpillingKt.nullOutSpilledVariable(episodePatterns3);
                c00162.L$10 = SpillingKt.nullOutSpilledVariable(episodePatterns4);
                c00162.I$0 = i2;
                c00162.label = 2;
                if (ParCollectionsKt.amap(list, c00172, c00162) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 2:
                int i6 = c00161.I$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object invokeUindex$default(String str, Integer num, Integer num2, Integer num3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            num3 = null;
        }
        return invokeUindex(str, num, num2, num3, function1, continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.StremioCKt$invokeUindex$2 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "row", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioCKt$invokeUindex$2", f = "StremioC.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {898}, m = "invokeSuspend", n = {"row", "rowTitle", "magnet", "qualityMatch", "seeder", "fileSize", "formattedTitleName"}, nl = {897}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    @SourceDebugExtension({"SMAP\nStremioC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioCKt$invokeUindex$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1058:1\n2945#2,3:1059\n1#3:1062\n*S KotlinDebug\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioCKt$invokeUindex$2\n*L\n868#1:1059,3\n*E\n"})
    static final class C00172 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ List<Regex> $episodePatterns;
        final /* synthetic */ boolean $isTv;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00172(boolean z, List<Regex> list, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00172> continuation) {
            super(2, continuation);
            this.$isTv = z;
            this.$episodePatterns = list;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00172 = new C00172(this.$isTv, this.$episodePatterns, this.$callback, continuation);
            c00172.L$0 = obj;
            return c00172;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function1;
            boolean z;
            Element row = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String rowTitle = row.select("td:nth-child(2) > a:nth-child(2)").text();
                    String magnet = row.select("td:nth-child(2) > a:nth-child(1)").attr("href");
                    if (StringsKt.isBlank(rowTitle) || StringsKt.isBlank(magnet)) {
                        return Unit.INSTANCE;
                    }
                    if (this.$isTv && !this.$episodePatterns.isEmpty()) {
                        Iterable $this$none$iv = this.$episodePatterns;
                        if (($this$none$iv instanceof Collection) && ((Collection) $this$none$iv).isEmpty()) {
                            z = true;
                        } else {
                            Iterator it = $this$none$iv.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object element$iv = it.next();
                                    Regex it2 = (Regex) element$iv;
                                    if (it2.containsMatchIn(rowTitle)) {
                                        z = false;
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        }
                        if (z) {
                            return Unit.INSTANCE;
                        }
                    }
                    MatchResult matchResultFind$default = Regex.find$default(new Regex("(2160p|1080p|720p)", RegexOption.IGNORE_CASE), rowTitle, 0, 2, (Object) null);
                    String qualityMatch = matchResultFind$default != null ? matchResultFind$default.getValue() : null;
                    String strReplace$default = StringsKt.replace$default(row.select("td:nth-child(4) > span").text(), ",", "", false, 4, (Object) null);
                    if (StringsKt.isBlank(strReplace$default)) {
                        strReplace$default = "0";
                    }
                    String seeder = strReplace$default;
                    String fileSize = row.select("td:nth-child(3)").text();
                    Regex qualityTermsRegex = new Regex("(WEBRip|WEB-DL|x265|x264|10bit|HEVC|H264)", RegexOption.IGNORE_CASE);
                    String tags = SequencesKt.joinToString$default(SequencesKt.distinct(SequencesKt.map(Regex.findAll$default(qualityTermsRegex, rowTitle, 0, 2, (Object) null), new Function1() { // from class: com.phisher98.StremioCKt$invokeUindex$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return StremioCKt.C00172.invokeSuspend$lambda$2$0((MatchResult) obj);
                        }
                    })), " | ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    String formattedTitleName = StringsKt.trim("UIndex | " + tags + " | Seeder: " + seeder + " | FileSize: " + fileSize).toString();
                    Function1<ExtractorLink, Unit> function2 = this.$callback;
                    String str = formattedTitleName;
                    if (StringsKt.isBlank(str)) {
                        str = rowTitle;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(row);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(rowTitle);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(magnet);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(qualityMatch);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(seeder);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(fileSize);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(formattedTitleName);
                    this.L$7 = function2;
                    this.label = 1;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink("UIndex", str, magnet, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass3(qualityMatch, null), (Continuation) this);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = function2;
                    break;
                    break;
                case 1:
                    function1 = (Function1) this.L$7;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1.invoke(objNewExtractorLink);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2$0(MatchResult it) {
            String upperCase = it.getValue().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }

        /* JADX INFO: renamed from: com.phisher98.StremioCKt$invokeUindex$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: StremioC.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.StremioCKt$invokeUindex$2$3", f = "StremioC.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $qualityMatch;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(String str, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$qualityMatch = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.$qualityMatch, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$qualityMatch));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0566 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:116:0x058e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0229  */
    /* JADX WARN: Code duplicated, block: B:47:0x02d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:52:0x030f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0325  */
    /* JADX WARN: Code duplicated, block: B:55:0x0336  */
    /* JADX WARN: Code duplicated, block: B:57:0x0340  */
    /* JADX WARN: Code duplicated, block: B:58:0x034f  */
    /* JADX WARN: Code duplicated, block: B:60:0x035f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0370  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x0527 -> B:112:0x054a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x0577 -> B:115:0x058a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeKnaben(@org.jetbrains.annotations.Nullable java.lang.String r42, @org.jetbrains.annotations.Nullable java.lang.Integer r43, @org.jetbrains.annotations.Nullable java.lang.Integer r44, @org.jetbrains.annotations.Nullable java.lang.Integer r45, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r46, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r47) {
        /*
            Method dump skipped, instruction units count: 1480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StremioCKt.invokeKnaben(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeKnaben$default(String str, Integer num, Integer num2, Integer num3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            num3 = null;
        }
        return invokeKnaben(str, num, num2, num3, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x027c  */
    /* JADX WARN: Code duplicated, block: B:50:0x028e  */
    /* JADX WARN: Code duplicated, block: B:52:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:57:0x0306  */
    /* JADX WARN: Code duplicated, block: B:61:0x031f  */
    /* JADX WARN: Code duplicated, block: B:68:0x033b  */
    /* JADX WARN: Code duplicated, block: B:71:0x0370  */
    /* JADX WARN: Code duplicated, block: B:74:0x0391  */
    /* JADX WARN: Code duplicated, block: B:77:0x039f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:83:0x0405 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:84:0x0406  */
    /* JADX WARN: Code duplicated, block: B:87:0x042d  */
    /* JADX WARN: Code duplicated, block: B:89:0x0433  */
    /* JADX WARN: Code duplicated, block: B:90:0x0436  */
    /* JADX WARN: Code duplicated, block: B:91:0x0439  */
    /* JADX WARN: Code duplicated, block: B:94:0x04a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:95:0x04a6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x04a6 -> B:96:0x04b6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object invokeTorrentio(@org.jetbrains.annotations.Nullable java.lang.String r36, @org.jetbrains.annotations.Nullable java.lang.Integer r37, @org.jetbrains.annotations.Nullable java.lang.Integer r38, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r39, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r40) {
        /*
            Method dump skipped, instruction units count: 1276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StremioCKt.invokeTorrentio(java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object invokeTorrentio$default(String str, Integer num, Integer num2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        return invokeTorrentio(str, num, num2, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeTorrentio$lambda$0$0$0(MatchResult it) {
        String upperCase = it.getValue().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
