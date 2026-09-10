package com.zinkmovies;

import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Zinkmovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\r\u001aJ\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001e\u0010\u0014\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000f0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0082@¢\u0006\u0002\u0010\u0018\u001a\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001\u001a\u0016\u0010\u001b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\r\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"cleanTitle", "", "raw", "RANDOM_ID_REGEX", "Lkotlin/text/Regex;", "AJAX_REGEX", "DL_REGEX", "SERVER_HANDLER_REGEX", "WORKER_REGEX", "generateZinkLinks", "", "Lcom/zinkmovies/ZinkLink;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retry", "T", "times", "", "delayMs", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(IJLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndexQuality", "str", "bypassShortlink", "Zinkmovies"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/zinkmovies/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,251:1\n1#2:252\n1#2:264\n1795#3,10:253\n2068#3:263\n2069#3:265\n1805#3:266\n1849#3,8:267\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/zinkmovies/UtilsKt\n*L\n127#1:264\n127#1:253,10\n127#1:263\n127#1:265\n127#1:266\n195#1:267,8\n*E\n"})
public final class UtilsKt {

    @NotNull
    private static final Regex RANDOM_ID_REGEX = new Regex("generateDownloadLink\\(['\"]([^'\"]+)");

    @NotNull
    private static final Regex AJAX_REGEX = new Regex("https://[^\"'\\\\s]+ajax_generate_token\\.php");

    @NotNull
    private static final Regex DL_REGEX = new Regex("https://[^\"'\\\\s]+/dl/");

    @NotNull
    private static final Regex SERVER_HANDLER_REGEX = new Regex("SERVER_HANDLER_URL\\s*=\\s*[\"']([^\"']+)");

    @NotNull
    private static final Regex WORKER_REGEX = new Regex("handleServerRequest\\(['\"]worker['\"]\\s*,\\s*['\"]([^'\"]+)");

    /* JADX INFO: renamed from: com.zinkmovies.UtilsKt$bypassShortlink$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.UtilsKt", f = "Utils.kt", i = {0}, l = {231}, m = "bypassShortlink", n = {"url"}, nl = {232}, s = {"L$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.bypassShortlink(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.zinkmovies.UtilsKt$generateZinkLinks$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.UtilsKt", f = "Utils.kt", i = {0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {89, 108, 123, 162}, m = "generateZinkLinks", n = {"url", "url", "firstDoc", "firstHtml", "ajaxEndpoint", "downloadBase", "randomId", "url", "firstDoc", "firstHtml", "ajaxEndpoint", "downloadBase", "token", "randomId", "generatedUrl", "url", "firstDoc", "firstHtml", "ajaxEndpoint", "downloadBase", "token", "randomId", "generatedUrl", "generatedDoc", "btn", "serverHandler", "workerId", "results"}, nl = {90, 119, 125, 176}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.generateZinkLinks(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.zinkmovies.UtilsKt$retry$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {210, 215, 219}, m = "retry", n = {"block", "times", "delayMs", "it", "block", "times", "delayMs", "it", "block", "times", "delayMs"}, nl = {209, 216, 218}, s = {"L$0", "I$0", "J$0", "I$3", "L$0", "I$0", "J$0", "I$3", "L$0", "I$0", "J$0"}, v = 2)
    static final class C00121<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.retry(0, 0L, null, (Continuation) this);
        }
    }

    @NotNull
    public static final String cleanTitle(@NotNull String raw) {
        String season;
        String name = new Regex("\\s+").replace(StringsKt.trim(StringsKt.substringBefore$default(raw, "(", (String) null, 2, (Object) null)).toString(), " ");
        if (name.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char it = name.charAt(0);
            StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(it) ? CharsKt.titlecase(it) : String.valueOf(it)));
            String strSubstring = name.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            name = sbAppend.append(strSubstring).toString();
        }
        Regex seasonRegex = new Regex("Season\\s*\\d+", RegexOption.IGNORE_CASE);
        Regex yearRegex = new Regex("\\b(19|20)\\d{2}\\b");
        MatchResult matchResultFind$default = Regex.find$default(seasonRegex, raw, 0, 2, (Object) null);
        if (matchResultFind$default == null || (season = matchResultFind$default.getValue()) == null) {
            season = null;
        } else {
            if (season.length() > 0) {
                StringBuilder sb2 = new StringBuilder();
                String strValueOf = String.valueOf(season.charAt(0));
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend2 = sb2.append((Object) upperCase);
                String strSubstring2 = season.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                season = sbAppend2.append(strSubstring2).toString();
            }
        }
        MatchResult matchResultFind$default2 = Regex.find$default(yearRegex, raw, 0, 2, (Object) null);
        String year = matchResultFind$default2 != null ? matchResultFind$default2.getValue() : null;
        List parts = new ArrayList();
        if (season != null) {
            parts.add(season);
        }
        if (year != null) {
            parts.add(year);
        }
        if (parts.isEmpty()) {
            return name;
        }
        return name + CollectionsKt.joinToString$default(parts, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.zinkmovies.UtilsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return UtilsKt.cleanTitle$lambda$2((String) obj);
            }
        }, 30, (Object) null);
    }

    static final CharSequence cleanTitle$lambda$2(String it) {
        return " (" + it + ')';
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0345  */
    /* JADX WARN: Code duplicated, block: B:105:0x0348 A[Catch: all -> 0x05f5, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x05f5, blocks: (B:66:0x0238, B:67:0x0258, B:79:0x02d5, B:81:0x02e8, B:89:0x0313, B:97:0x0337, B:105:0x0348), top: B:220:0x0238 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x034d A[Catch: all -> 0x02c9, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x02c9, blocks: (B:69:0x025e, B:74:0x02b9, B:72:0x0292, B:83:0x0300, B:85:0x0307, B:91:0x0325, B:93:0x032c, B:99:0x033c, B:107:0x034d), top: B:205:0x025e }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0356  */
    /* JADX WARN: Code duplicated, block: B:120:0x0455 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:121:0x0456  */
    /* JADX WARN: Code duplicated, block: B:124:0x048e  */
    /* JADX WARN: Code duplicated, block: B:129:0x049d  */
    /* JADX WARN: Code duplicated, block: B:132:0x04af  */
    /* JADX WARN: Code duplicated, block: B:133:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:136:0x04b8 A[Catch: all -> 0x0505, TRY_LEAVE, TryCatch #0 {all -> 0x0505, blocks: (B:122:0x0474, B:130:0x04a0, B:134:0x04b2, B:136:0x04b8), top: B:203:0x0474 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:159:0x0594  */
    /* JADX WARN: Code duplicated, block: B:160:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:163:0x05b6  */
    /* JADX WARN: Code duplicated, block: B:167:0x05d4 A[Catch: all -> 0x0591, TryCatch #6 {all -> 0x0591, blocks: (B:164:0x05bc, B:165:0x05ce, B:167:0x05d4, B:169:0x05e7, B:170:0x05eb, B:156:0x0573), top: B:215:0x0573 }] */
    /* JADX WARN: Code duplicated, block: B:201:0x0653  */
    /* JADX WARN: Code duplicated, block: B:205:0x025e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:213:0x0359 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:240:0x05e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x05ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:246:0x02bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x01cb A[Catch: all -> 0x00ba, TRY_ENTER, TRY_LEAVE, TryCatch #13 {all -> 0x00ba, blocks: (B:18:0x00a4, B:60:0x01cb), top: B:228:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x01d0 A[Catch: all -> 0x05f9, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x05f9, blocks: (B:58:0x01c7, B:62:0x01d0), top: B:226:0x01c7 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0227 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0228  */
    /* JADX WARN: Code duplicated, block: B:71:0x028a  */
    /* JADX WARN: Code duplicated, block: B:72:0x0292 A[Catch: all -> 0x02c9, TryCatch #1 {all -> 0x02c9, blocks: (B:69:0x025e, B:74:0x02b9, B:72:0x0292, B:83:0x0300, B:85:0x0307, B:91:0x0325, B:93:0x032c, B:99:0x033c, B:107:0x034d), top: B:205:0x025e }] */
    /* JADX WARN: Code duplicated, block: B:74:0x02b9 A[Catch: all -> 0x02c9, TRY_LEAVE, TryCatch #1 {all -> 0x02c9, blocks: (B:69:0x025e, B:74:0x02b9, B:72:0x0292, B:83:0x0300, B:85:0x0307, B:91:0x0325, B:93:0x032c, B:99:0x033c, B:107:0x034d), top: B:205:0x025e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:81:0x02e8 A[Catch: all -> 0x05f5, TRY_LEAVE, TryCatch #9 {all -> 0x05f5, blocks: (B:66:0x0238, B:67:0x0258, B:79:0x02d5, B:81:0x02e8, B:89:0x0313, B:97:0x0337, B:105:0x0348), top: B:220:0x0238 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0300 A[Catch: all -> 0x02c9, TRY_ENTER, TryCatch #1 {all -> 0x02c9, blocks: (B:69:0x025e, B:74:0x02b9, B:72:0x0292, B:83:0x0300, B:85:0x0307, B:91:0x0325, B:93:0x032c, B:99:0x033c, B:107:0x034d), top: B:205:0x025e }] */
    /* JADX WARN: Code duplicated, block: B:87:0x030f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0325 A[Catch: all -> 0x02c9, TRY_ENTER, TryCatch #1 {all -> 0x02c9, blocks: (B:69:0x025e, B:74:0x02b9, B:72:0x0292, B:83:0x0300, B:85:0x0307, B:91:0x0325, B:93:0x032c, B:99:0x033c, B:107:0x034d), top: B:205:0x025e }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0334  */
    /* JADX WARN: Code duplicated, block: B:99:0x033c A[Catch: all -> 0x02c9, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x02c9, blocks: (B:69:0x025e, B:74:0x02b9, B:72:0x0292, B:83:0x0300, B:85:0x0307, B:91:0x0325, B:93:0x032c, B:99:0x033c, B:107:0x034d), top: B:205:0x025e }] */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00bd: MOVE (r23 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]), block:B:21:0x00bb */
    @Nullable
    public static final Object generateZinkLinks(@NotNull String url, @NotNull Continuation<? super List<ZinkLink>> continuation) {
        C00111 c00111;
        Object obj;
        int i;
        Object objAppGet$default;
        String url2;
        String firstHtml;
        MatchResult matchResultFind$default;
        List groupValues;
        String randomId;
        String ajaxEndpoint;
        String downloadBase;
        String ajaxEndpoint2;
        String randomId2;
        Object objRetry$default;
        String randomId3;
        Document firstDoc;
        int i2;
        String url3;
        String token;
        String downloadBase2;
        String generatedUrl;
        Object objAppGet$default2;
        int i3;
        String firstHtml2;
        String randomId4;
        Document firstDoc2;
        String ajaxEndpoint3;
        String token2;
        String downloadBase3;
        String downloadBase4;
        Document generatedDoc;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv;
        Iterable $this$mapNotNullTo$iv$iv;
        List results;
        Element btn;
        MatchResult matchResultFind$default2;
        String workerId;
        MatchResult matchResultFind$default3;
        String serverHandler;
        String str;
        boolean z;
        String str2;
        boolean z2;
        List results2;
        int i4;
        String randomId5;
        String token3;
        String downloadBase5;
        String ajaxEndpoint4;
        String firstHtml3;
        Document firstDoc3;
        Element btn2;
        String generatedUrl2;
        String generatedUrl3;
        Document generatedDoc2;
        String generatedUrl4;
        Unit unit;
        String url4;
        int i5;
        List groupValues2;
        List groupValues3;
        Element element;
        String href;
        ZinkLink zinkLink;
        HashSet set$iv;
        ArrayList list$iv;
        ZinkLink it;
        JSONObject workerJson;
        Unit unitOptString;
        Unit unitOptString2;
        String it2;
        String it3;
        int i6;
        String str3;
        if (continuation instanceof C00111) {
            c00111 = (C00111) continuation;
            if ((c00111.label & Integer.MIN_VALUE) != 0) {
                c00111.label -= Integer.MIN_VALUE;
            } else {
                c00111 = new C00111(continuation);
            }
        } else {
            c00111 = new C00111(continuation);
        }
        C00111 c00112 = c00111;
        Object $result = c00112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00112.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Result.Companion companion = Result.Companion;
                        i = 0;
                        Zinkmovies.Companion companion2 = Zinkmovies.INSTANCE;
                        c00112.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        c00112.label = 1;
                        objAppGet$default = Zinkmovies.Companion.appGet$default(companion2, url, null, 0, false, c00112, 14, null);
                        if (objAppGet$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url2 = url;
                        try {
                            Document firstDoc4 = ((NiceResponse) objAppGet$default).getDocument();
                            firstHtml = firstDoc4.html();
                            matchResultFind$default = Regex.find$default(RANDOM_ID_REGEX, firstHtml, 0, 2, (Object) null);
                            try {
                                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (randomId = (String) CollectionsKt.getOrNull(groupValues, 1)) == null) {
                                    return CollectionsKt.emptyList();
                                }
                                MatchResult matchResultFind$default4 = Regex.find$default(AJAX_REGEX, firstHtml, 0, 2, (Object) null);
                                if (matchResultFind$default4 == null || (ajaxEndpoint = matchResultFind$default4.getValue()) == null) {
                                    return CollectionsKt.emptyList();
                                }
                                MatchResult matchResultFind$default5 = Regex.find$default(DL_REGEX, firstHtml, 0, 2, (Object) null);
                                if (matchResultFind$default5 == null || (downloadBase = matchResultFind$default5.getValue()) == null) {
                                    return CollectionsKt.emptyList();
                                }
                                UtilsKt$generateZinkLinks$2$token$1 utilsKt$generateZinkLinks$2$token$1 = new UtilsKt$generateZinkLinks$2$token$1(ajaxEndpoint, randomId, null);
                                c00112.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                c00112.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc4);
                                c00112.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml);
                                c00112.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint);
                                c00112.L$4 = downloadBase;
                                c00112.L$5 = SpillingKt.nullOutSpilledVariable(randomId);
                                c00112.label = 2;
                                ajaxEndpoint2 = ajaxEndpoint;
                                randomId2 = randomId;
                                try {
                                    objRetry$default = retry$default(0, 0L, utilsKt$generateZinkLinks$2$token$1, c00112, 3, null);
                                    c00112 = c00112;
                                    if (objRetry$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    randomId3 = downloadBase;
                                    firstDoc = firstDoc4;
                                    i2 = i;
                                    url3 = url2;
                                    try {
                                        token = (String) objRetry$default;
                                        if (token == null) {
                                            return CollectionsKt.emptyList();
                                        }
                                        String generatedUrl5 = randomId3 + token;
                                        Zinkmovies.Companion companion3 = Zinkmovies.INSTANCE;
                                        c00112.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                                        c00112.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc);
                                        c00112.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml);
                                        c00112.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint2);
                                        c00112.L$4 = SpillingKt.nullOutSpilledVariable(randomId3);
                                        c00112.L$5 = SpillingKt.nullOutSpilledVariable(token);
                                        c00112.L$6 = SpillingKt.nullOutSpilledVariable(randomId2);
                                        c00112.L$7 = generatedUrl5;
                                        c00112.label = 3;
                                        downloadBase2 = randomId3;
                                        generatedUrl = generatedUrl5;
                                        objAppGet$default2 = Zinkmovies.Companion.appGet$default(companion3, generatedUrl, null, 0, false, c00112, 14, null);
                                        if (objAppGet$default2 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        i3 = i2;
                                        firstHtml2 = firstHtml;
                                        randomId4 = randomId2;
                                        firstDoc2 = firstDoc;
                                        ajaxEndpoint3 = ajaxEndpoint2;
                                        token2 = token;
                                        downloadBase3 = downloadBase2;
                                        downloadBase4 = url3;
                                        try {
                                            generatedDoc = ((NiceResponse) objAppGet$default2).getDocument();
                                            $this$mapNotNull$iv = generatedDoc.select("#mirror-buttons a[href]");
                                            $i$f$mapNotNull = 0;
                                            destination$iv$iv = new ArrayList();
                                            $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                                            for (Object element$iv$iv$iv : $this$mapNotNullTo$iv$iv) {
                                                try {
                                                    element = (Element) element$iv$iv$iv;
                                                    href = StringsKt.trim(element.attr("href")).toString();
                                                    if (StringsKt.isBlank(href)) {
                                                        zinkLink = null;
                                                    } else {
                                                        zinkLink = new ZinkLink(StringsKt.trim(StringsKt.replace(element.text(), "Generate", "", true)).toString(), href);
                                                    }
                                                    if (zinkLink != null) {
                                                        destination$iv$iv.add(zinkLink);
                                                    }
                                                    $this$mapNotNull$iv = $this$mapNotNull$iv;
                                                    $i$f$mapNotNull = $i$f$mapNotNull;
                                                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                                                } catch (Throwable th) {
                                                    th = th;
                                                }
                                            }
                                            results = CollectionsKt.toMutableList((List) destination$iv$iv);
                                            btn = generatedDoc.selectFirst("#worker-btn");
                                            if (btn != null) {
                                                matchResultFind$default2 = Regex.find$default(WORKER_REGEX, btn.attr("onclick"), 0, 2, (Object) null);
                                                if (matchResultFind$default2 != null || (groupValues3 = matchResultFind$default2.getGroupValues()) == null) {
                                                    workerId = null;
                                                } else {
                                                    workerId = (String) CollectionsKt.getOrNull(groupValues3, 1);
                                                }
                                                matchResultFind$default3 = Regex.find$default(SERVER_HANDLER_REGEX, generatedDoc.html(), 0, 2, (Object) null);
                                                if (matchResultFind$default3 != null || (groupValues2 = matchResultFind$default3.getGroupValues()) == null) {
                                                    serverHandler = null;
                                                } else {
                                                    serverHandler = (String) CollectionsKt.getOrNull(groupValues2, 1);
                                                }
                                                str = workerId;
                                                if (str != null || StringsKt.isBlank(str)) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                if (!z) {
                                                    str2 = serverHandler;
                                                    if (str2 != null || StringsKt.isBlank(str2)) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    if (!z2) {
                                                        try {
                                                            Result.Companion companion4 = Result.Companion;
                                                            try {
                                                                Requests app = MainActivityKt.getApp();
                                                                RequestBody requestBodyCreate$default = RequestBody.Companion.create$default(RequestBody.Companion, StringsKt.trimIndent("\n                                {\n                                    \"server\":\"worker\",\n                                    \"random_id\":\"" + workerId + "\"\n                                }\n                            "), (MediaType) null, 1, (Object) null);
                                                                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Requested-With", "XMLHttpRequest"), TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("Origin", StringsKt.substringBefore$default(generatedUrl, "/dl/", (String) null, 2, (Object) null)), TuplesKt.to("Referer", generatedUrl)});
                                                                c00112.L$0 = SpillingKt.nullOutSpilledVariable(downloadBase4);
                                                                c00112.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc2);
                                                                c00112.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml2);
                                                                c00112.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint3);
                                                                c00112.L$4 = SpillingKt.nullOutSpilledVariable(downloadBase3);
                                                                c00112.L$5 = SpillingKt.nullOutSpilledVariable(token2);
                                                                c00112.L$6 = SpillingKt.nullOutSpilledVariable(randomId4);
                                                                c00112.L$7 = SpillingKt.nullOutSpilledVariable(generatedUrl);
                                                                c00112.L$8 = SpillingKt.nullOutSpilledVariable(generatedDoc);
                                                                c00112.L$9 = SpillingKt.nullOutSpilledVariable(btn);
                                                                c00112.L$10 = SpillingKt.nullOutSpilledVariable(serverHandler);
                                                                c00112.L$11 = SpillingKt.nullOutSpilledVariable(workerId);
                                                                c00112.L$12 = results;
                                                                c00112.label = 4;
                                                                generatedUrl4 = generatedUrl;
                                                                unit = null;
                                                                try {
                                                                    $result = Requests.post$default(app, serverHandler, mapMapOf, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate$default, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 65276, (Object) null);
                                                                    if ($result == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    results2 = results;
                                                                    url4 = downloadBase4;
                                                                    i4 = i3;
                                                                    randomId5 = randomId4;
                                                                    token3 = token2;
                                                                    downloadBase5 = downloadBase3;
                                                                    ajaxEndpoint4 = ajaxEndpoint3;
                                                                    firstHtml3 = firstHtml2;
                                                                    firstDoc3 = firstDoc2;
                                                                    btn2 = btn;
                                                                    generatedUrl2 = null;
                                                                    i5 = 0;
                                                                    generatedUrl3 = generatedUrl4;
                                                                    generatedDoc2 = generatedDoc;
                                                                    try {
                                                                        workerJson = new JSONObject(((NiceResponse) $result).getText());
                                                                        unitOptString = workerJson.optString("url");
                                                                        if (StringsKt.isBlank(unitOptString)) {
                                                                            try {
                                                                                unitOptString2 = workerJson.optString("download");
                                                                            } catch (Throwable th2) {
                                                                                th = th2;
                                                                                try {
                                                                                    Result.Companion companion5 = Result.Companion;
                                                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                                                    results = results2;
                                                                                    List $this$distinctBy$iv = results;
                                                                                    set$iv = new HashSet();
                                                                                    list$iv = new ArrayList();
                                                                                    for (Object e$iv : $this$distinctBy$iv) {
                                                                                        it = (ZinkLink) e$iv;
                                                                                        if (set$iv.add(it.getUrl())) {
                                                                                            list$iv.add(e$iv);
                                                                                        }
                                                                                    }
                                                                                    obj = Result.constructor-impl(list$iv);
                                                                                    break;
                                                                                } catch (Throwable th3) {
                                                                                    th = th3;
                                                                                    Result.Companion companion6 = Result.Companion;
                                                                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                }
                                                                                if (Result.exceptionOrNull-impl(obj) == null) {
                                                                                    return obj;
                                                                                }
                                                                                return CollectionsKt.emptyList();
                                                                            }
                                                                        } else {
                                                                            unitOptString2 = unitOptString;
                                                                        }
                                                                        it2 = (String) unitOptString2;
                                                                        if (!StringsKt.isBlank(it2)) {
                                                                            unitOptString2 = unit;
                                                                        }
                                                                        it3 = (String) unitOptString2;
                                                                        if (it3 != null) {
                                                                            i6 = i4;
                                                                            try {
                                                                                str3 = generatedUrl2;
                                                                                try {
                                                                                    results2.add(new ZinkLink("WORKER", it3));
                                                                                    unit = Unit.INSTANCE;
                                                                                } catch (Throwable th4) {
                                                                                    th = th4;
                                                                                    i4 = i6;
                                                                                    generatedUrl2 = str3;
                                                                                    Result.Companion companion7 = Result.Companion;
                                                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                                                    results = results2;
                                                                                }
                                                                            } catch (Throwable th5) {
                                                                                th = th5;
                                                                                i4 = i6;
                                                                                Result.Companion companion8 = Result.Companion;
                                                                                Result.constructor-impl(ResultKt.createFailure(th));
                                                                                results = results2;
                                                                            }
                                                                        } else {
                                                                            i6 = i4;
                                                                            str3 = generatedUrl2;
                                                                        }
                                                                        Result.constructor-impl(unit);
                                                                        results = results2;
                                                                    } catch (Throwable th6) {
                                                                        th = th6;
                                                                    }
                                                                } catch (Throwable th7) {
                                                                    th = th7;
                                                                    results2 = results;
                                                                    i4 = i3;
                                                                    randomId5 = randomId4;
                                                                    token3 = token2;
                                                                    downloadBase5 = downloadBase3;
                                                                    ajaxEndpoint4 = ajaxEndpoint3;
                                                                    firstHtml3 = firstHtml2;
                                                                    firstDoc3 = firstDoc2;
                                                                    btn2 = btn;
                                                                    generatedUrl2 = null;
                                                                    generatedUrl3 = generatedUrl4;
                                                                    generatedDoc2 = generatedDoc;
                                                                    Result.Companion companion9 = Result.Companion;
                                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                                    results = results2;
                                                                    List $this$distinctBy$iv2 = results;
                                                                    set$iv = new HashSet();
                                                                    list$iv = new ArrayList();
                                                                    while (r8.hasNext()) {
                                                                        it = (ZinkLink) e$iv;
                                                                        if (set$iv.add(it.getUrl())) {
                                                                            list$iv.add(e$iv);
                                                                        }
                                                                    }
                                                                    obj = Result.constructor-impl(list$iv);
                                                                    if (Result.exceptionOrNull-impl(obj) == null) {
                                                                        return obj;
                                                                    }
                                                                    return CollectionsKt.emptyList();
                                                                }
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                String str4 = generatedUrl;
                                                                results2 = results;
                                                                i4 = i3;
                                                                randomId5 = randomId4;
                                                                token3 = token2;
                                                                downloadBase5 = downloadBase3;
                                                                ajaxEndpoint4 = ajaxEndpoint3;
                                                                firstHtml3 = firstHtml2;
                                                                firstDoc3 = firstDoc2;
                                                                btn2 = btn;
                                                                generatedUrl2 = null;
                                                                generatedUrl3 = str4;
                                                                generatedDoc2 = generatedDoc;
                                                            }
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                            String str5 = generatedUrl;
                                                            results2 = results;
                                                            i4 = i3;
                                                            randomId5 = randomId4;
                                                            token3 = token2;
                                                            downloadBase5 = downloadBase3;
                                                            ajaxEndpoint4 = ajaxEndpoint3;
                                                            firstHtml3 = firstHtml2;
                                                            firstDoc3 = firstDoc2;
                                                            btn2 = btn;
                                                            generatedUrl2 = null;
                                                            generatedUrl3 = str5;
                                                            generatedDoc2 = generatedDoc;
                                                        }
                                                        break;
                                                    }
                                                }
                                            }
                                            List $this$distinctBy$iv3 = results;
                                            set$iv = new HashSet();
                                            list$iv = new ArrayList();
                                            while (r8.hasNext()) {
                                                it = (ZinkLink) e$iv;
                                                if (set$iv.add(it.getUrl())) {
                                                    list$iv.add(e$iv);
                                                }
                                            }
                                            obj = Result.constructor-impl(list$iv);
                                            break;
                                        } catch (Throwable th10) {
                                            th = th10;
                                        }
                                        if (Result.exceptionOrNull-impl(obj) == null) {
                                            return obj;
                                        }
                                        return CollectionsKt.emptyList();
                                    } catch (Throwable th11) {
                                        th = th11;
                                    }
                                } catch (Throwable th12) {
                                    th = th12;
                                }
                            } catch (Throwable th13) {
                                th = th13;
                            }
                        } catch (Throwable th14) {
                            th = th14;
                        }
                        Result.Companion companion10 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            return obj;
                        }
                        return CollectionsKt.emptyList();
                    } catch (Throwable th15) {
                        th = th15;
                    }
                    break;
                case 1:
                    String url5 = (String) c00112.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        i = 0;
                        url2 = url5;
                        objAppGet$default = $result;
                        Document firstDoc5 = ((NiceResponse) objAppGet$default).getDocument();
                        firstHtml = firstDoc5.html();
                        matchResultFind$default = Regex.find$default(RANDOM_ID_REGEX, firstHtml, 0, 2, (Object) null);
                        if (matchResultFind$default != null) {
                        }
                        return CollectionsKt.emptyList();
                    } catch (Throwable th16) {
                        th = th16;
                    }
                    break;
                case 2:
                    String randomId6 = (String) c00112.L$5;
                    String downloadBase6 = (String) c00112.L$4;
                    String ajaxEndpoint5 = (String) c00112.L$3;
                    String firstHtml4 = (String) c00112.L$2;
                    Document firstDoc6 = (Document) c00112.L$1;
                    String url6 = (String) c00112.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        i2 = 0;
                        randomId2 = randomId6;
                        randomId3 = downloadBase6;
                        ajaxEndpoint2 = ajaxEndpoint5;
                        firstHtml = firstHtml4;
                        firstDoc = firstDoc6;
                        objRetry$default = $result;
                        url3 = url6;
                        token = (String) objRetry$default;
                        if (token == null) {
                            return CollectionsKt.emptyList();
                        }
                        String generatedUrl6 = randomId3 + token;
                        Zinkmovies.Companion companion11 = Zinkmovies.INSTANCE;
                        c00112.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00112.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc);
                        c00112.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml);
                        c00112.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint2);
                        c00112.L$4 = SpillingKt.nullOutSpilledVariable(randomId3);
                        c00112.L$5 = SpillingKt.nullOutSpilledVariable(token);
                        c00112.L$6 = SpillingKt.nullOutSpilledVariable(randomId2);
                        c00112.L$7 = generatedUrl6;
                        c00112.label = 3;
                        downloadBase2 = randomId3;
                        generatedUrl = generatedUrl6;
                        objAppGet$default2 = Zinkmovies.Companion.appGet$default(companion11, generatedUrl, null, 0, false, c00112, 14, null);
                        if (objAppGet$default2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i3 = i2;
                        firstHtml2 = firstHtml;
                        randomId4 = randomId2;
                        firstDoc2 = firstDoc;
                        ajaxEndpoint3 = ajaxEndpoint2;
                        token2 = token;
                        downloadBase3 = downloadBase2;
                        downloadBase4 = url3;
                        generatedDoc = ((NiceResponse) objAppGet$default2).getDocument();
                        $this$mapNotNull$iv = generatedDoc.select("#mirror-buttons a[href]");
                        $i$f$mapNotNull = 0;
                        destination$iv$iv = new ArrayList();
                        $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                        while (r18.hasNext()) {
                            element = (Element) element$iv$iv$iv;
                            href = StringsKt.trim(element.attr("href")).toString();
                            if (StringsKt.isBlank(href)) {
                                zinkLink = null;
                            } else {
                                zinkLink = new ZinkLink(StringsKt.trim(StringsKt.replace(element.text(), "Generate", "", true)).toString(), href);
                            }
                            if (zinkLink != null) {
                                destination$iv$iv.add(zinkLink);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv;
                            $i$f$mapNotNull = $i$f$mapNotNull;
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                        }
                        results = CollectionsKt.toMutableList((List) destination$iv$iv);
                        btn = generatedDoc.selectFirst("#worker-btn");
                        if (btn != null) {
                            matchResultFind$default2 = Regex.find$default(WORKER_REGEX, btn.attr("onclick"), 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                workerId = null;
                            } else {
                                workerId = null;
                            }
                            matchResultFind$default3 = Regex.find$default(SERVER_HANDLER_REGEX, generatedDoc.html(), 0, 2, (Object) null);
                            if (matchResultFind$default3 != null) {
                                serverHandler = null;
                            } else {
                                serverHandler = null;
                            }
                            str = workerId;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                str2 = serverHandler;
                                if (str2 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    Result.Companion companion12 = Result.Companion;
                                    Requests app2 = MainActivityKt.getApp();
                                    RequestBody requestBodyCreate$default2 = RequestBody.Companion.create$default(RequestBody.Companion, StringsKt.trimIndent("\n                                {\n                                    \"server\":\"worker\",\n                                    \"random_id\":\"" + workerId + "\"\n                                }\n                            "), (MediaType) null, 1, (Object) null);
                                    Map mapMapOf2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Requested-With", "XMLHttpRequest"), TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("Origin", StringsKt.substringBefore$default(generatedUrl, "/dl/", (String) null, 2, (Object) null)), TuplesKt.to("Referer", generatedUrl)});
                                    c00112.L$0 = SpillingKt.nullOutSpilledVariable(downloadBase4);
                                    c00112.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc2);
                                    c00112.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml2);
                                    c00112.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint3);
                                    c00112.L$4 = SpillingKt.nullOutSpilledVariable(downloadBase3);
                                    c00112.L$5 = SpillingKt.nullOutSpilledVariable(token2);
                                    c00112.L$6 = SpillingKt.nullOutSpilledVariable(randomId4);
                                    c00112.L$7 = SpillingKt.nullOutSpilledVariable(generatedUrl);
                                    c00112.L$8 = SpillingKt.nullOutSpilledVariable(generatedDoc);
                                    c00112.L$9 = SpillingKt.nullOutSpilledVariable(btn);
                                    c00112.L$10 = SpillingKt.nullOutSpilledVariable(serverHandler);
                                    c00112.L$11 = SpillingKt.nullOutSpilledVariable(workerId);
                                    c00112.L$12 = results;
                                    c00112.label = 4;
                                    generatedUrl4 = generatedUrl;
                                    unit = null;
                                    $result = Requests.post$default(app2, serverHandler, mapMapOf2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate$default2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 65276, (Object) null);
                                    if ($result == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    results2 = results;
                                    url4 = downloadBase4;
                                    i4 = i3;
                                    randomId5 = randomId4;
                                    token3 = token2;
                                    downloadBase5 = downloadBase3;
                                    ajaxEndpoint4 = ajaxEndpoint3;
                                    firstHtml3 = firstHtml2;
                                    firstDoc3 = firstDoc2;
                                    btn2 = btn;
                                    generatedUrl2 = null;
                                    i5 = 0;
                                    generatedUrl3 = generatedUrl4;
                                    generatedDoc2 = generatedDoc;
                                    workerJson = new JSONObject(((NiceResponse) $result).getText());
                                    unitOptString = workerJson.optString("url");
                                    if (StringsKt.isBlank(unitOptString)) {
                                        unitOptString2 = workerJson.optString("download");
                                    } else {
                                        unitOptString2 = unitOptString;
                                    }
                                    it2 = (String) unitOptString2;
                                    if (!StringsKt.isBlank(it2)) {
                                        unitOptString2 = unit;
                                    }
                                    it3 = (String) unitOptString2;
                                    if (it3 != null) {
                                        i6 = i4;
                                        str3 = generatedUrl2;
                                        results2.add(new ZinkLink("WORKER", it3));
                                        unit = Unit.INSTANCE;
                                    } else {
                                        i6 = i4;
                                        str3 = generatedUrl2;
                                    }
                                    Result.constructor-impl(unit);
                                    results = results2;
                                    break;
                                }
                            }
                        }
                        List $this$distinctBy$iv4 = results;
                        set$iv = new HashSet();
                        list$iv = new ArrayList();
                        while (r8.hasNext()) {
                            it = (ZinkLink) e$iv;
                            if (set$iv.add(it.getUrl())) {
                                list$iv.add(e$iv);
                            }
                        }
                        obj = Result.constructor-impl(list$iv);
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            return obj;
                        }
                        return CollectionsKt.emptyList();
                    } catch (Throwable th17) {
                        th = th17;
                    }
                    Result.Companion companion13 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.exceptionOrNull-impl(obj) == null) {
                        return obj;
                    }
                    return CollectionsKt.emptyList();
                case 3:
                    generatedUrl = (String) c00112.L$7;
                    String randomId7 = (String) c00112.L$6;
                    String token4 = (String) c00112.L$5;
                    String downloadBase7 = (String) c00112.L$4;
                    String ajaxEndpoint6 = (String) c00112.L$3;
                    String firstHtml5 = (String) c00112.L$2;
                    Document firstDoc7 = (Document) c00112.L$1;
                    String url7 = (String) c00112.L$0;
                    ResultKt.throwOnFailure($result);
                    i3 = 0;
                    randomId4 = randomId7;
                    token2 = token4;
                    downloadBase3 = downloadBase7;
                    ajaxEndpoint3 = ajaxEndpoint6;
                    firstHtml2 = firstHtml5;
                    objAppGet$default2 = $result;
                    firstDoc2 = firstDoc7;
                    downloadBase4 = url7;
                    generatedDoc = ((NiceResponse) objAppGet$default2).getDocument();
                    $this$mapNotNull$iv = generatedDoc.select("#mirror-buttons a[href]");
                    $i$f$mapNotNull = 0;
                    destination$iv$iv = new ArrayList();
                    $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                    while (r18.hasNext()) {
                        element = (Element) element$iv$iv$iv;
                        href = StringsKt.trim(element.attr("href")).toString();
                        if (StringsKt.isBlank(href)) {
                            zinkLink = null;
                        } else {
                            zinkLink = new ZinkLink(StringsKt.trim(StringsKt.replace(element.text(), "Generate", "", true)).toString(), href);
                        }
                        if (zinkLink != null) {
                            destination$iv$iv.add(zinkLink);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv;
                        $i$f$mapNotNull = $i$f$mapNotNull;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                    }
                    results = CollectionsKt.toMutableList((List) destination$iv$iv);
                    btn = generatedDoc.selectFirst("#worker-btn");
                    if (btn != null) {
                        matchResultFind$default2 = Regex.find$default(WORKER_REGEX, btn.attr("onclick"), 0, 2, (Object) null);
                        if (matchResultFind$default2 != null) {
                            workerId = null;
                        } else {
                            workerId = null;
                        }
                        matchResultFind$default3 = Regex.find$default(SERVER_HANDLER_REGEX, generatedDoc.html(), 0, 2, (Object) null);
                        if (matchResultFind$default3 != null) {
                            serverHandler = null;
                        } else {
                            serverHandler = null;
                        }
                        str = workerId;
                        if (str != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            str2 = serverHandler;
                            if (str2 != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (!z2) {
                                Result.Companion companion14 = Result.Companion;
                                Requests app3 = MainActivityKt.getApp();
                                RequestBody requestBodyCreate$default3 = RequestBody.Companion.create$default(RequestBody.Companion, StringsKt.trimIndent("\n                                {\n                                    \"server\":\"worker\",\n                                    \"random_id\":\"" + workerId + "\"\n                                }\n                            "), (MediaType) null, 1, (Object) null);
                                Map mapMapOf3 = MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Requested-With", "XMLHttpRequest"), TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("Origin", StringsKt.substringBefore$default(generatedUrl, "/dl/", (String) null, 2, (Object) null)), TuplesKt.to("Referer", generatedUrl)});
                                c00112.L$0 = SpillingKt.nullOutSpilledVariable(downloadBase4);
                                c00112.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc2);
                                c00112.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml2);
                                c00112.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint3);
                                c00112.L$4 = SpillingKt.nullOutSpilledVariable(downloadBase3);
                                c00112.L$5 = SpillingKt.nullOutSpilledVariable(token2);
                                c00112.L$6 = SpillingKt.nullOutSpilledVariable(randomId4);
                                c00112.L$7 = SpillingKt.nullOutSpilledVariable(generatedUrl);
                                c00112.L$8 = SpillingKt.nullOutSpilledVariable(generatedDoc);
                                c00112.L$9 = SpillingKt.nullOutSpilledVariable(btn);
                                c00112.L$10 = SpillingKt.nullOutSpilledVariable(serverHandler);
                                c00112.L$11 = SpillingKt.nullOutSpilledVariable(workerId);
                                c00112.L$12 = results;
                                c00112.label = 4;
                                generatedUrl4 = generatedUrl;
                                unit = null;
                                $result = Requests.post$default(app3, serverHandler, mapMapOf3, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate$default3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 65276, (Object) null);
                                if ($result == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                results2 = results;
                                url4 = downloadBase4;
                                i4 = i3;
                                randomId5 = randomId4;
                                token3 = token2;
                                downloadBase5 = downloadBase3;
                                ajaxEndpoint4 = ajaxEndpoint3;
                                firstHtml3 = firstHtml2;
                                firstDoc3 = firstDoc2;
                                btn2 = btn;
                                generatedUrl2 = null;
                                i5 = 0;
                                generatedUrl3 = generatedUrl4;
                                generatedDoc2 = generatedDoc;
                                workerJson = new JSONObject(((NiceResponse) $result).getText());
                                unitOptString = workerJson.optString("url");
                                if (StringsKt.isBlank(unitOptString)) {
                                    unitOptString2 = workerJson.optString("download");
                                } else {
                                    unitOptString2 = unitOptString;
                                }
                                it2 = (String) unitOptString2;
                                if (!StringsKt.isBlank(it2)) {
                                    unitOptString2 = unit;
                                }
                                it3 = (String) unitOptString2;
                                if (it3 != null) {
                                    i6 = i4;
                                    str3 = generatedUrl2;
                                    results2.add(new ZinkLink("WORKER", it3));
                                    unit = Unit.INSTANCE;
                                } else {
                                    i6 = i4;
                                    str3 = generatedUrl2;
                                }
                                Result.constructor-impl(unit);
                                results = results2;
                                break;
                            }
                        }
                    }
                    List $this$distinctBy$iv5 = results;
                    set$iv = new HashSet();
                    list$iv = new ArrayList();
                    while (r8.hasNext()) {
                        it = (ZinkLink) e$iv;
                        if (set$iv.add(it.getUrl())) {
                            list$iv.add(e$iv);
                        }
                    }
                    obj = Result.constructor-impl(list$iv);
                    if (Result.exceptionOrNull-impl(obj) == null) {
                        return obj;
                    }
                    return CollectionsKt.emptyList();
                case 4:
                    i4 = 0;
                    generatedUrl2 = null;
                    results2 = (List) c00112.L$12;
                    btn2 = (Element) c00112.L$9;
                    generatedDoc2 = (Document) c00112.L$8;
                    generatedUrl3 = (String) c00112.L$7;
                    randomId5 = (String) c00112.L$6;
                    token3 = (String) c00112.L$5;
                    downloadBase5 = (String) c00112.L$4;
                    ajaxEndpoint4 = (String) c00112.L$3;
                    firstHtml3 = (String) c00112.L$2;
                    firstDoc3 = (Document) c00112.L$1;
                    url4 = (String) c00112.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        i5 = 0;
                        unit = null;
                        workerJson = new JSONObject(((NiceResponse) $result).getText());
                        unitOptString = workerJson.optString("url");
                        if (StringsKt.isBlank(unitOptString)) {
                            unitOptString2 = workerJson.optString("download");
                        } else {
                            unitOptString2 = unitOptString;
                        }
                        it2 = (String) unitOptString2;
                        if (!StringsKt.isBlank(it2)) {
                            unitOptString2 = unit;
                        }
                        it3 = (String) unitOptString2;
                        if (it3 != null) {
                            i6 = i4;
                            str3 = generatedUrl2;
                            results2.add(new ZinkLink("WORKER", it3));
                            unit = Unit.INSTANCE;
                        } else {
                            i6 = i4;
                            str3 = generatedUrl2;
                        }
                        Result.constructor-impl(unit);
                        results = results2;
                        break;
                    } catch (Throwable th18) {
                        th = th18;
                        Result.Companion companion15 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                        results = results2;
                        List $this$distinctBy$iv6 = results;
                        set$iv = new HashSet();
                        list$iv = new ArrayList();
                        while (r8.hasNext()) {
                            it = (ZinkLink) e$iv;
                            if (set$iv.add(it.getUrl())) {
                                list$iv.add(e$iv);
                            }
                        }
                        obj = Result.constructor-impl(list$iv);
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            return obj;
                        }
                        return CollectionsKt.emptyList();
                    }
                    List $this$distinctBy$iv7 = results;
                    set$iv = new HashSet();
                    list$iv = new ArrayList();
                    while (r8.hasNext()) {
                        it = (ZinkLink) e$iv;
                        if (set$iv.add(it.getUrl())) {
                            list$iv.add(e$iv);
                        }
                    }
                    obj = Result.constructor-impl(list$iv);
                    if (Result.exceptionOrNull-impl(obj) == null) {
                        return obj;
                    }
                    return CollectionsKt.emptyList();
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th19) {
            th = th19;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x0095  */
    /* JADX WARN: Code duplicated, block: B:28:0x00af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:42:0x0102  */
    /* JADX WARN: Code duplicated, block: B:44:0x0104  */
    /* JADX WARN: Code duplicated, block: B:46:0x0123 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x0124  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0124 -> B:48:0x0130). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:730)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final <T> java.lang.Object retry(int r20, long r21, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r23, kotlin.coroutines.Continuation<? super T> r24) {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zinkmovies.UtilsKt.retry(int, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object retry$default(int i, long j, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 3;
        }
        if ((i2 & 2) != 0) {
            j = 1000;
        }
        return retry(i, j, function1, continuation);
    }

    public static final int getIndexQuality(@Nullable String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0091 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:13:0x003b, B:27:0x007b, B:29:0x0091, B:32:0x0099, B:47:0x00ca, B:35:0x00a6, B:37:0x00b2, B:38:0x00b8, B:40:0x00bd), top: B:56:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0096  */
    /* JADX WARN: Code duplicated, block: B:32:0x0099 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:13:0x003b, B:27:0x007b, B:29:0x0091, B:32:0x0099, B:47:0x00ca, B:35:0x00a6, B:37:0x00b2, B:38:0x00b8, B:40:0x00bd), top: B:56:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a6 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:13:0x003b, B:27:0x007b, B:29:0x0091, B:32:0x0099, B:47:0x00ca, B:35:0x00a6, B:37:0x00b2, B:38:0x00b8, B:40:0x00bd), top: B:56:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b2 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:13:0x003b, B:27:0x007b, B:29:0x0091, B:32:0x0099, B:47:0x00ca, B:35:0x00a6, B:37:0x00b2, B:38:0x00b8, B:40:0x00bd), top: B:56:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00bd A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:13:0x003b, B:27:0x007b, B:29:0x0091, B:32:0x0099, B:47:0x00ca, B:35:0x00a6, B:37:0x00b2, B:38:0x00b8, B:40:0x00bd), top: B:56:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public static final Object bypassShortlink(@NotNull String url, @NotNull Continuation<? super String> continuation) {
        C00101 c00101;
        String url2;
        Object objAppGet$default;
        Object obj;
        String docText;
        MatchResult matchResultFind$default;
        String match;
        String link;
        String str;
        String decodedUrl;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = new C00101(continuation);
            }
        } else {
            c00101 = new C00101(continuation);
        }
        C00101 c00102 = c00101;
        Object $result = c00102.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (c00102.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!StringsKt.contains$default(url, "tpi.li", false, 2, (Object) null) && !StringsKt.contains$default(url, "oii.la", false, 2, (Object) null)) {
                    return url;
                }
                try {
                    Result.Companion companion = Result.Companion;
                    Zinkmovies.Companion companion2 = Zinkmovies.INSTANCE;
                    c00102.L$0 = url;
                    c00102.label = 1;
                    objAppGet$default = Zinkmovies.Companion.appGet$default(companion2, url, null, 0, false, c00102, 14, null);
                    if (objAppGet$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url2 = url;
                    docText = ((NiceResponse) objAppGet$default).getText();
                    Regex base64Regex = new Regex("aHR0c[a-zA-Z0-9+/=]+");
                    matchResultFind$default = Regex.find$default(base64Regex, docText, 0, 2, (Object) null);
                    if (matchResultFind$default != null) {
                        match = matchResultFind$default.getValue();
                    } else {
                        match = null;
                    }
                    if (match != null) {
                        decodedUrl = MainAPIKt.base64Decode(match);
                        if (StringsKt.startsWith$default(decodedUrl, "http", false, 2, (Object) null)) {
                            Document parsedDoc = Jsoup.parse(docText);
                            Element elementSelectFirst = parsedDoc.selectFirst("a.get-link");
                            link = elementSelectFirst != null ? elementSelectFirst.attr("href") : null;
                            str = link;
                            if (str != null && !StringsKt.isBlank(str)) {
                                z = false;
                            }
                            if (z) {
                                decodedUrl = url2;
                            } else {
                                decodedUrl = link;
                            }
                        }
                    } else {
                        Document parsedDoc2 = Jsoup.parse(docText);
                        Element elementSelectFirst2 = parsedDoc2.selectFirst("a.get-link");
                        if (elementSelectFirst2 != null) {
                        }
                        str = link;
                        if (str != null) {
                            z = false;
                        }
                        if (z) {
                            decodedUrl = link;
                        } else {
                            decodedUrl = url2;
                        }
                    }
                    obj = Result.constructor-impl(decodedUrl);
                    if (Result.isFailure-impl(obj)) {
                        return url2;
                    }
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    url2 = url;
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                break;
            case 1:
                url2 = (String) c00102.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objAppGet$default = $result;
                    docText = ((NiceResponse) objAppGet$default).getText();
                    Regex base64Regex2 = new Regex("aHR0c[a-zA-Z0-9+/=]+");
                    matchResultFind$default = Regex.find$default(base64Regex2, docText, 0, 2, (Object) null);
                    if (matchResultFind$default != null) {
                        match = matchResultFind$default.getValue();
                    } else {
                        match = null;
                    }
                    if (match != null) {
                        decodedUrl = MainAPIKt.base64Decode(match);
                        if (StringsKt.startsWith$default(decodedUrl, "http", false, 2, (Object) null)) {
                            Document parsedDoc3 = Jsoup.parse(docText);
                            Element elementSelectFirst3 = parsedDoc3.selectFirst("a.get-link");
                            if (elementSelectFirst3 != null) {
                            }
                            str = link;
                            if (str != null) {
                                z = false;
                            }
                            if (z) {
                                decodedUrl = link;
                            } else {
                                decodedUrl = url2;
                            }
                        }
                    } else {
                        Document parsedDoc4 = Jsoup.parse(docText);
                        Element elementSelectFirst4 = parsedDoc4.selectFirst("a.get-link");
                        if (elementSelectFirst4 != null) {
                        }
                        str = link;
                        if (str != null) {
                            z = false;
                        }
                        if (z) {
                            decodedUrl = link;
                        } else {
                            decodedUrl = url2;
                        }
                    }
                    obj = Result.constructor-impl(decodedUrl);
                    break;
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    return url2;
                }
                return obj;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
