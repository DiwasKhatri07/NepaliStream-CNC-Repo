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
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
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
    static final class C00061 extends ContinuationImpl {
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

        C00061(Continuation<? super C00061> continuation) {
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
    static final class C00071<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
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

    /* JADX WARN: Code duplicated, block: B:101:0x0396 A[Catch: all -> 0x062b, TryCatch #5 {all -> 0x062b, blocks: (B:154:0x05f3, B:155:0x0605, B:157:0x060b, B:159:0x061e, B:160:0x0622, B:148:0x05b1, B:69:0x0281, B:70:0x02a1, B:72:0x02a7, B:77:0x0308, B:75:0x02dd, B:79:0x0318, B:81:0x0336, B:83:0x034e, B:85:0x0355, B:87:0x035f, B:89:0x0372, B:91:0x0379, B:93:0x0383, B:95:0x038a, B:101:0x0396, B:103:0x039b), top: B:198:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x039b A[Catch: all -> 0x062b, TRY_LEAVE, TryCatch #5 {all -> 0x062b, blocks: (B:154:0x05f3, B:155:0x0605, B:157:0x060b, B:159:0x061e, B:160:0x0622, B:148:0x05b1, B:69:0x0281, B:70:0x02a1, B:72:0x02a7, B:77:0x0308, B:75:0x02dd, B:79:0x0318, B:81:0x0336, B:83:0x034e, B:85:0x0355, B:87:0x035f, B:89:0x0372, B:91:0x0379, B:93:0x0383, B:95:0x038a, B:101:0x0396, B:103:0x039b), top: B:198:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:116:0x049c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:117:0x049d  */
    /* JADX WARN: Code duplicated, block: B:120:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:125:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:128:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:129:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:132:0x04ff A[Catch: all -> 0x0543, TRY_LEAVE, TryCatch #0 {all -> 0x0543, blocks: (B:118:0x04bb, B:126:0x04e7, B:130:0x04f9, B:132:0x04ff), top: B:190:0x04bb }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0518  */
    /* JADX WARN: Code duplicated, block: B:149:0x05d1  */
    /* JADX WARN: Code duplicated, block: B:150:0x05db  */
    /* JADX WARN: Code duplicated, block: B:153:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:157:0x060b A[Catch: all -> 0x062b, TryCatch #5 {all -> 0x062b, blocks: (B:154:0x05f3, B:155:0x0605, B:157:0x060b, B:159:0x061e, B:160:0x0622, B:148:0x05b1, B:69:0x0281, B:70:0x02a1, B:72:0x02a7, B:77:0x0308, B:75:0x02dd, B:79:0x0318, B:81:0x0336, B:83:0x034e, B:85:0x0355, B:87:0x035f, B:89:0x0372, B:91:0x0379, B:93:0x0383, B:95:0x038a, B:101:0x0396, B:103:0x039b), top: B:198:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:188:0x0671  */
    /* JADX WARN: Code duplicated, block: B:202:0x03a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x061e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:222:0x0605 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x030c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x01f6 A[Catch: all -> 0x0633, TryCatch #10 {all -> 0x0633, blocks: (B:58:0x01f2, B:60:0x01f6, B:62:0x01fb), top: B:208:0x01f2 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x01fb A[Catch: all -> 0x0633, TRY_LEAVE, TryCatch #10 {all -> 0x0633, blocks: (B:58:0x01f2, B:60:0x01f6, B:62:0x01fb), top: B:208:0x01f2 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0270 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:0x0271  */
    /* JADX WARN: Code duplicated, block: B:72:0x02a7 A[Catch: all -> 0x062b, TryCatch #5 {all -> 0x062b, blocks: (B:154:0x05f3, B:155:0x0605, B:157:0x060b, B:159:0x061e, B:160:0x0622, B:148:0x05b1, B:69:0x0281, B:70:0x02a1, B:72:0x02a7, B:77:0x0308, B:75:0x02dd, B:79:0x0318, B:81:0x0336, B:83:0x034e, B:85:0x0355, B:87:0x035f, B:89:0x0372, B:91:0x0379, B:93:0x0383, B:95:0x038a, B:101:0x0396, B:103:0x039b), top: B:198:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x02dd A[Catch: all -> 0x062b, TryCatch #5 {all -> 0x062b, blocks: (B:154:0x05f3, B:155:0x0605, B:157:0x060b, B:159:0x061e, B:160:0x0622, B:148:0x05b1, B:69:0x0281, B:70:0x02a1, B:72:0x02a7, B:77:0x0308, B:75:0x02dd, B:79:0x0318, B:81:0x0336, B:83:0x034e, B:85:0x0355, B:87:0x035f, B:89:0x0372, B:91:0x0379, B:93:0x0383, B:95:0x038a, B:101:0x0396, B:103:0x039b), top: B:198:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0308 A[Catch: all -> 0x062b, TryCatch #5 {all -> 0x062b, blocks: (B:154:0x05f3, B:155:0x0605, B:157:0x060b, B:159:0x061e, B:160:0x0622, B:148:0x05b1, B:69:0x0281, B:70:0x02a1, B:72:0x02a7, B:77:0x0308, B:75:0x02dd, B:79:0x0318, B:81:0x0336, B:83:0x034e, B:85:0x0355, B:87:0x035f, B:89:0x0372, B:91:0x0379, B:93:0x0383, B:95:0x038a, B:101:0x0396, B:103:0x039b), top: B:198:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:81:0x0336 A[Catch: all -> 0x062b, TryCatch #5 {all -> 0x062b, blocks: (B:154:0x05f3, B:155:0x0605, B:157:0x060b, B:159:0x061e, B:160:0x0622, B:148:0x05b1, B:69:0x0281, B:70:0x02a1, B:72:0x02a7, B:77:0x0308, B:75:0x02dd, B:79:0x0318, B:81:0x0336, B:83:0x034e, B:85:0x0355, B:87:0x035f, B:89:0x0372, B:91:0x0379, B:93:0x0383, B:95:0x038a, B:101:0x0396, B:103:0x039b), top: B:198:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x034e A[Catch: all -> 0x062b, TryCatch #5 {all -> 0x062b, blocks: (B:154:0x05f3, B:155:0x0605, B:157:0x060b, B:159:0x061e, B:160:0x0622, B:148:0x05b1, B:69:0x0281, B:70:0x02a1, B:72:0x02a7, B:77:0x0308, B:75:0x02dd, B:79:0x0318, B:81:0x0336, B:83:0x034e, B:85:0x0355, B:87:0x035f, B:89:0x0372, B:91:0x0379, B:93:0x0383, B:95:0x038a, B:101:0x0396, B:103:0x039b), top: B:198:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x035e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0372 A[Catch: all -> 0x062b, TryCatch #5 {all -> 0x062b, blocks: (B:154:0x05f3, B:155:0x0605, B:157:0x060b, B:159:0x061e, B:160:0x0622, B:148:0x05b1, B:69:0x0281, B:70:0x02a1, B:72:0x02a7, B:77:0x0308, B:75:0x02dd, B:79:0x0318, B:81:0x0336, B:83:0x034e, B:85:0x0355, B:87:0x035f, B:89:0x0372, B:91:0x0379, B:93:0x0383, B:95:0x038a, B:101:0x0396, B:103:0x039b), top: B:198:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0382  */
    /* JADX WARN: Code duplicated, block: B:95:0x038a A[Catch: all -> 0x062b, TryCatch #5 {all -> 0x062b, blocks: (B:154:0x05f3, B:155:0x0605, B:157:0x060b, B:159:0x061e, B:160:0x0622, B:148:0x05b1, B:69:0x0281, B:70:0x02a1, B:72:0x02a7, B:77:0x0308, B:75:0x02dd, B:79:0x0318, B:81:0x0336, B:83:0x034e, B:85:0x0355, B:87:0x035f, B:89:0x0372, B:91:0x0379, B:93:0x0383, B:95:0x038a, B:101:0x0396, B:103:0x039b), top: B:198:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0393  */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0109: MOVE (r24 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY] A[D('url' java.lang.String)]), block:B:29:0x0107 */
    @Nullable
    public static final Object generateZinkLinks(@NotNull String url, @NotNull Continuation<? super List<ZinkLink>> continuation) {
        C00061 c00061;
        Object obj;
        int i;
        int i2;
        String url2;
        String url3;
        MatchResult matchResultFind$default;
        List groupValues;
        String randomId;
        String ajaxEndpoint;
        String downloadBase;
        String randomId2;
        String ajaxEndpoint2;
        String downloadBase2;
        int i3;
        String url4;
        String firstHtml;
        Document firstDoc;
        String token;
        String downloadBase3;
        String generatedUrl;
        char c;
        String ajaxEndpoint3;
        String firstHtml2;
        Document firstDoc2;
        String downloadBase4;
        String firstHtml3;
        int i4;
        String downloadBase5;
        String token2;
        Document generatedDoc;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv;
        Iterable $this$mapNotNullTo$iv$iv;
        int $i$f$mapNotNullTo;
        Iterable $this$forEach$iv$iv$iv;
        List results;
        Element btn;
        MatchResult matchResultFind$default2;
        String str;
        String workerId;
        MatchResult matchResultFind$default3;
        String serverHandler;
        String str2;
        boolean z;
        String str3;
        boolean z2;
        List results2;
        String serverHandler2;
        int i5;
        Document generatedDoc2;
        String generatedUrl2;
        String serverHandler3;
        String randomId3;
        String token3;
        String downloadBase6;
        String firstHtml4;
        Document firstDoc3;
        Element btn2;
        String workerId2;
        Element btn3;
        Unit unit;
        String generatedUrl3;
        String generatedUrl4;
        String url5;
        int i6;
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
        int i7;
        Unit unit2;
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
        C00061 c00062 = c00061;
        Object $result = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00062.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Result.Companion companion = Result.Companion;
                        i = 0;
                        try {
                            Requests app = MainActivityKt.getApp();
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(url);
                            c00062.label = 1;
                            i2 = 0;
                            try {
                                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4094, (Object) null);
                                c00062 = c00062;
                                if ($result == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                url2 = url;
                                try {
                                    Document firstDoc4 = ((NiceResponse) $result).getDocument();
                                    String firstHtml5 = firstDoc4.html();
                                    url3 = null;
                                    matchResultFind$default = Regex.find$default(RANDOM_ID_REGEX, firstHtml5, i2, 2, (Object) null);
                                    if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (randomId = (String) CollectionsKt.getOrNull(groupValues, 1)) == null) {
                                        return CollectionsKt.emptyList();
                                    }
                                    MatchResult matchResultFind$default4 = Regex.find$default(AJAX_REGEX, firstHtml5, i2, 2, (Object) null);
                                    if (matchResultFind$default4 == null || (ajaxEndpoint = matchResultFind$default4.getValue()) == null) {
                                        return CollectionsKt.emptyList();
                                    }
                                    MatchResult matchResultFind$default5 = Regex.find$default(DL_REGEX, firstHtml5, i2, 2, (Object) null);
                                    if (matchResultFind$default5 == null || (downloadBase = matchResultFind$default5.getValue()) == null) {
                                        return CollectionsKt.emptyList();
                                    }
                                    UtilsKt$generateZinkLinks$2$token$1 utilsKt$generateZinkLinks$2$token$1 = new UtilsKt$generateZinkLinks$2$token$1(ajaxEndpoint, randomId, null);
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc4);
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml5);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint);
                                    c00062.L$4 = downloadBase;
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(randomId);
                                    c00062.label = 2;
                                    $result = retry$default(0, 0L, utilsKt$generateZinkLinks$2$token$1, c00062, 3, null);
                                    if ($result == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    randomId2 = randomId;
                                    ajaxEndpoint2 = ajaxEndpoint;
                                    downloadBase2 = downloadBase;
                                    i3 = i;
                                    url4 = url2;
                                    firstHtml = firstHtml5;
                                    firstDoc = firstDoc4;
                                    try {
                                        token = (String) $result;
                                        if (token == null) {
                                            return CollectionsKt.emptyList();
                                        }
                                        String generatedUrl5 = downloadBase2 + token;
                                        Requests app2 = MainActivityKt.getApp();
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc);
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint2);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(downloadBase2);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(token);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(randomId2);
                                        c00062.L$7 = generatedUrl5;
                                        c00062.label = 3;
                                        downloadBase3 = downloadBase2;
                                        generatedUrl = generatedUrl5;
                                        C00061 c00063 = c00062;
                                        c = 3;
                                        try {
                                            $result = Requests.get$default(app2, generatedUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00063, 4094, (Object) null);
                                            c00062 = c00063;
                                            if ($result == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            ajaxEndpoint3 = ajaxEndpoint2;
                                            firstHtml2 = firstHtml;
                                            firstDoc2 = firstDoc;
                                            downloadBase4 = downloadBase3;
                                            firstHtml3 = url4;
                                            i4 = i3;
                                            downloadBase5 = token;
                                            token2 = randomId2;
                                            try {
                                                generatedDoc = ((NiceResponse) $result).getDocument();
                                                $this$mapNotNull$iv = generatedDoc.select("#mirror-buttons a[href]");
                                                $i$f$mapNotNull = 0;
                                                destination$iv$iv = new ArrayList();
                                                $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                                                $i$f$mapNotNullTo = 0;
                                                $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                                                for (Object element$iv$iv$iv : $this$forEach$iv$iv$iv) {
                                                    element = (Element) element$iv$iv$iv;
                                                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                                    href = StringsKt.trim(element.attr("href")).toString();
                                                    if (StringsKt.isBlank(href)) {
                                                        zinkLink = null;
                                                    } else {
                                                        zinkLink = new ZinkLink(StringsKt.trim(StringsKt.replace(element.text(), "Generate", "", true)).toString(), href);
                                                    }
                                                    if (zinkLink != null) {
                                                        destination$iv$iv.add(zinkLink);
                                                    }
                                                    $i$f$mapNotNull = $i$f$mapNotNull;
                                                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                                                    $i$f$mapNotNullTo = $i$f$mapNotNullTo;
                                                    $this$forEach$iv$iv$iv = $this$forEach$iv$iv$iv;
                                                }
                                                results = CollectionsKt.toMutableList((List) destination$iv$iv);
                                                btn = generatedDoc.selectFirst("#worker-btn");
                                                if (btn != null) {
                                                    matchResultFind$default2 = Regex.find$default(WORKER_REGEX, btn.attr("onclick"), 0, 2, (Object) null);
                                                    if (matchResultFind$default2 != null || (groupValues3 = matchResultFind$default2.getGroupValues()) == null) {
                                                        str = null;
                                                    } else {
                                                        str = (String) CollectionsKt.getOrNull(groupValues3, 1);
                                                    }
                                                    workerId = str;
                                                    matchResultFind$default3 = Regex.find$default(SERVER_HANDLER_REGEX, generatedDoc.html(), 0, 2, (Object) null);
                                                    if (matchResultFind$default3 != null || (groupValues2 = matchResultFind$default3.getGroupValues()) == null) {
                                                        serverHandler = null;
                                                    } else {
                                                        serverHandler = (String) CollectionsKt.getOrNull(groupValues2, 1);
                                                    }
                                                    str2 = workerId;
                                                    if (str2 != null || StringsKt.isBlank(str2)) {
                                                        z = true;
                                                    } else {
                                                        z = false;
                                                    }
                                                    if (!z) {
                                                        str3 = serverHandler;
                                                        if (str3 != null || StringsKt.isBlank(str3)) {
                                                            z2 = true;
                                                        } else {
                                                            z2 = false;
                                                        }
                                                        if (!z2) {
                                                            try {
                                                                Result.Companion companion2 = Result.Companion;
                                                                try {
                                                                    Requests app3 = MainActivityKt.getApp();
                                                                    RequestBody requestBodyCreate$default = RequestBody.Companion.create$default(RequestBody.Companion, StringsKt.trimIndent("\n                                {\n                                    \"server\":\"worker\",\n                                    \"random_id\":\"" + workerId + "\"\n                                }\n                            "), (MediaType) null, 1, (Object) null);
                                                                    Pair[] pairArr = new Pair[4];
                                                                    pairArr[0] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                                                                    pairArr[1] = TuplesKt.to("Content-Type", "application/json");
                                                                    pairArr[2] = TuplesKt.to("Origin", StringsKt.substringBefore$default(generatedUrl, "/dl/", (String) null, 2, (Object) null));
                                                                    pairArr[c] = TuplesKt.to("Referer", generatedUrl);
                                                                    Map mapMapOf = MapsKt.mapOf(pairArr);
                                                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(firstHtml3);
                                                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc2);
                                                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml2);
                                                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint3);
                                                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(downloadBase4);
                                                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(downloadBase5);
                                                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(token2);
                                                                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(generatedUrl);
                                                                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(generatedDoc);
                                                                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(btn);
                                                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(serverHandler);
                                                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(workerId);
                                                                    c00062.L$12 = results;
                                                                    c00062.label = 4;
                                                                    unit = null;
                                                                    generatedUrl3 = generatedUrl;
                                                                    generatedUrl4 = serverHandler;
                                                                    try {
                                                                        $result = Requests.post$default(app3, generatedUrl4, mapMapOf, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate$default, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 65276, (Object) null);
                                                                        if ($result == coroutine_suspended) {
                                                                            return coroutine_suspended;
                                                                        }
                                                                        results2 = results;
                                                                        serverHandler2 = generatedUrl4;
                                                                        url5 = firstHtml3;
                                                                        i5 = i4;
                                                                        generatedDoc2 = generatedDoc;
                                                                        generatedUrl2 = generatedUrl3;
                                                                        serverHandler3 = ajaxEndpoint3;
                                                                        randomId3 = token2;
                                                                        token3 = downloadBase5;
                                                                        downloadBase6 = downloadBase4;
                                                                        i6 = 0;
                                                                        firstHtml4 = firstHtml2;
                                                                        firstDoc3 = firstDoc2;
                                                                        btn2 = null;
                                                                        workerId2 = workerId;
                                                                        btn3 = btn;
                                                                        try {
                                                                            workerJson = new JSONObject(((NiceResponse) $result).getText());
                                                                            unitOptString = workerJson.optString("url");
                                                                            if (StringsKt.isBlank(unitOptString)) {
                                                                                try {
                                                                                    unitOptString2 = workerJson.optString("download");
                                                                                } catch (Throwable th) {
                                                                                    th = th;
                                                                                    Result.Companion companion3 = Result.Companion;
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
                                                                                i7 = i5;
                                                                                try {
                                                                                    results2.add(new ZinkLink("WORKER", it3));
                                                                                    unit2 = Unit.INSTANCE;
                                                                                } catch (Throwable th2) {
                                                                                    th = th2;
                                                                                    i5 = i7;
                                                                                    Result.Companion companion4 = Result.Companion;
                                                                                    Result.constructor-impl(ResultKt.createFailure(th));
                                                                                    results = results2;
                                                                                }
                                                                            } else {
                                                                                i7 = i5;
                                                                                unit2 = unit;
                                                                            }
                                                                            Result.constructor-impl(unit2);
                                                                            results = results2;
                                                                        } catch (Throwable th3) {
                                                                            th = th3;
                                                                        }
                                                                    } catch (Throwable th4) {
                                                                        th = th4;
                                                                        results2 = results;
                                                                        serverHandler2 = generatedUrl4;
                                                                        i5 = i4;
                                                                        generatedDoc2 = generatedDoc;
                                                                        generatedUrl2 = generatedUrl3;
                                                                        serverHandler3 = ajaxEndpoint3;
                                                                        randomId3 = token2;
                                                                        token3 = downloadBase5;
                                                                        downloadBase6 = downloadBase4;
                                                                        firstHtml4 = firstHtml2;
                                                                        firstDoc3 = firstDoc2;
                                                                        btn2 = null;
                                                                        workerId2 = workerId;
                                                                        btn3 = btn;
                                                                        Result.Companion companion5 = Result.Companion;
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
                                                                } catch (Throwable th5) {
                                                                    th = th5;
                                                                    String str4 = generatedUrl;
                                                                    results2 = results;
                                                                    serverHandler2 = serverHandler;
                                                                    i5 = i4;
                                                                    generatedDoc2 = generatedDoc;
                                                                    generatedUrl2 = str4;
                                                                    serverHandler3 = ajaxEndpoint3;
                                                                    randomId3 = token2;
                                                                    token3 = downloadBase5;
                                                                    downloadBase6 = downloadBase4;
                                                                    firstHtml4 = firstHtml2;
                                                                    firstDoc3 = firstDoc2;
                                                                    btn2 = null;
                                                                    workerId2 = workerId;
                                                                    btn3 = btn;
                                                                }
                                                            } catch (Throwable th6) {
                                                                th = th6;
                                                                String str5 = generatedUrl;
                                                                results2 = results;
                                                                serverHandler2 = serverHandler;
                                                                i5 = i4;
                                                                generatedDoc2 = generatedDoc;
                                                                generatedUrl2 = str5;
                                                                serverHandler3 = ajaxEndpoint3;
                                                                randomId3 = token2;
                                                                token3 = downloadBase5;
                                                                downloadBase6 = downloadBase4;
                                                                firstHtml4 = firstHtml2;
                                                                firstDoc3 = firstDoc2;
                                                                btn2 = null;
                                                                workerId2 = workerId;
                                                                btn3 = btn;
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
                                            } catch (Throwable th7) {
                                                th = th7;
                                                Result.Companion companion6 = Result.Companion;
                                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                            if (Result.exceptionOrNull-impl(obj) == null) {
                                                return obj;
                                            }
                                            return CollectionsKt.emptyList();
                                        } catch (Throwable th8) {
                                            th = th8;
                                            Result.Companion companion7 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    Result.Companion companion8 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    if (Result.exceptionOrNull-impl(obj) == null) {
                                        return obj;
                                    }
                                    return CollectionsKt.emptyList();
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                Result.Companion companion9 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                if (Result.exceptionOrNull-impl(obj) == null) {
                                    return obj;
                                }
                                return CollectionsKt.emptyList();
                            }
                        } catch (Throwable th12) {
                            th = th12;
                        }
                    } catch (Throwable th13) {
                        th = th13;
                    }
                    break;
                case 1:
                    String url6 = (String) c00062.L$0;
                    ResultKt.throwOnFailure($result);
                    i = 0;
                    url2 = url6;
                    i2 = 0;
                    Document firstDoc5 = ((NiceResponse) $result).getDocument();
                    String firstHtml6 = firstDoc5.html();
                    url3 = null;
                    matchResultFind$default = Regex.find$default(RANDOM_ID_REGEX, firstHtml6, i2, 2, (Object) null);
                    if (matchResultFind$default != null) {
                        break;
                    }
                    return CollectionsKt.emptyList();
                case 2:
                    String randomId4 = (String) c00062.L$5;
                    String downloadBase7 = (String) c00062.L$4;
                    String ajaxEndpoint4 = (String) c00062.L$3;
                    String firstHtml7 = (String) c00062.L$2;
                    Document firstDoc6 = (Document) c00062.L$1;
                    String url7 = (String) c00062.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        i3 = 0;
                        randomId2 = randomId4;
                        downloadBase2 = downloadBase7;
                        ajaxEndpoint2 = ajaxEndpoint4;
                        url4 = url7;
                        url3 = null;
                        firstHtml = firstHtml7;
                        firstDoc = firstDoc6;
                        token = (String) $result;
                        if (token == null) {
                            return CollectionsKt.emptyList();
                        }
                        String generatedUrl6 = downloadBase2 + token;
                        Requests app4 = MainActivityKt.getApp();
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint2);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(downloadBase2);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(token);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(randomId2);
                        c00062.L$7 = generatedUrl6;
                        c00062.label = 3;
                        downloadBase3 = downloadBase2;
                        generatedUrl = generatedUrl6;
                        C00061 c00064 = c00062;
                        c = 3;
                        $result = Requests.get$default(app4, generatedUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00064, 4094, (Object) null);
                        c00062 = c00064;
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ajaxEndpoint3 = ajaxEndpoint2;
                        firstHtml2 = firstHtml;
                        firstDoc2 = firstDoc;
                        downloadBase4 = downloadBase3;
                        firstHtml3 = url4;
                        i4 = i3;
                        downloadBase5 = token;
                        token2 = randomId2;
                        generatedDoc = ((NiceResponse) $result).getDocument();
                        $this$mapNotNull$iv = generatedDoc.select("#mirror-buttons a[href]");
                        $i$f$mapNotNull = 0;
                        destination$iv$iv = new ArrayList();
                        $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                        $i$f$mapNotNullTo = 0;
                        $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                        while (r12.hasNext()) {
                            element = (Element) element$iv$iv$iv;
                            Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                            href = StringsKt.trim(element.attr("href")).toString();
                            if (StringsKt.isBlank(href)) {
                                zinkLink = null;
                            } else {
                                zinkLink = new ZinkLink(StringsKt.trim(StringsKt.replace(element.text(), "Generate", "", true)).toString(), href);
                            }
                            if (zinkLink != null) {
                                destination$iv$iv.add(zinkLink);
                            }
                            $i$f$mapNotNull = $i$f$mapNotNull;
                            $this$mapNotNull$iv = $this$mapNotNull$iv3;
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                            $i$f$mapNotNullTo = $i$f$mapNotNullTo;
                            $this$forEach$iv$iv$iv = $this$forEach$iv$iv$iv;
                        }
                        results = CollectionsKt.toMutableList((List) destination$iv$iv);
                        btn = generatedDoc.selectFirst("#worker-btn");
                        if (btn != null) {
                            matchResultFind$default2 = Regex.find$default(WORKER_REGEX, btn.attr("onclick"), 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                str = null;
                            } else {
                                str = null;
                            }
                            workerId = str;
                            matchResultFind$default3 = Regex.find$default(SERVER_HANDLER_REGEX, generatedDoc.html(), 0, 2, (Object) null);
                            if (matchResultFind$default3 != null) {
                                serverHandler = null;
                            } else {
                                serverHandler = null;
                            }
                            str2 = workerId;
                            if (str2 != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                str3 = serverHandler;
                                if (str3 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    Result.Companion companion10 = Result.Companion;
                                    Requests app5 = MainActivityKt.getApp();
                                    RequestBody requestBodyCreate$default2 = RequestBody.Companion.create$default(RequestBody.Companion, StringsKt.trimIndent("\n                                {\n                                    \"server\":\"worker\",\n                                    \"random_id\":\"" + workerId + "\"\n                                }\n                            "), (MediaType) null, 1, (Object) null);
                                    Pair[] pairArr2 = new Pair[4];
                                    pairArr2[0] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                                    pairArr2[1] = TuplesKt.to("Content-Type", "application/json");
                                    pairArr2[2] = TuplesKt.to("Origin", StringsKt.substringBefore$default(generatedUrl, "/dl/", (String) null, 2, (Object) null));
                                    pairArr2[c] = TuplesKt.to("Referer", generatedUrl);
                                    Map mapMapOf2 = MapsKt.mapOf(pairArr2);
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(firstHtml3);
                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc2);
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml2);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint3);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(downloadBase4);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(downloadBase5);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(token2);
                                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(generatedUrl);
                                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(generatedDoc);
                                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(btn);
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(serverHandler);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(workerId);
                                    c00062.L$12 = results;
                                    c00062.label = 4;
                                    unit = null;
                                    generatedUrl3 = generatedUrl;
                                    generatedUrl4 = serverHandler;
                                    $result = Requests.post$default(app5, generatedUrl4, mapMapOf2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate$default2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 65276, (Object) null);
                                    if ($result == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    results2 = results;
                                    serverHandler2 = generatedUrl4;
                                    url5 = firstHtml3;
                                    i5 = i4;
                                    generatedDoc2 = generatedDoc;
                                    generatedUrl2 = generatedUrl3;
                                    serverHandler3 = ajaxEndpoint3;
                                    randomId3 = token2;
                                    token3 = downloadBase5;
                                    downloadBase6 = downloadBase4;
                                    i6 = 0;
                                    firstHtml4 = firstHtml2;
                                    firstDoc3 = firstDoc2;
                                    btn2 = null;
                                    workerId2 = workerId;
                                    btn3 = btn;
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
                                        i7 = i5;
                                        results2.add(new ZinkLink("WORKER", it3));
                                        unit2 = Unit.INSTANCE;
                                    } else {
                                        i7 = i5;
                                        unit2 = unit;
                                    }
                                    Result.constructor-impl(unit2);
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
                    } catch (Throwable th14) {
                        th = th14;
                        Result.Companion companion11 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            return obj;
                        }
                        return CollectionsKt.emptyList();
                    }
                case 3:
                    String generatedUrl7 = (String) c00062.L$7;
                    String randomId5 = (String) c00062.L$6;
                    String token4 = (String) c00062.L$5;
                    String downloadBase8 = (String) c00062.L$4;
                    String ajaxEndpoint5 = (String) c00062.L$3;
                    String firstHtml8 = (String) c00062.L$2;
                    Document firstDoc7 = (Document) c00062.L$1;
                    String url8 = (String) c00062.L$0;
                    ResultKt.throwOnFailure($result);
                    i4 = 0;
                    firstHtml3 = url8;
                    generatedUrl = generatedUrl7;
                    token2 = randomId5;
                    downloadBase5 = token4;
                    downloadBase4 = downloadBase8;
                    ajaxEndpoint3 = ajaxEndpoint5;
                    firstHtml2 = firstHtml8;
                    firstDoc2 = firstDoc7;
                    c = 3;
                    generatedDoc = ((NiceResponse) $result).getDocument();
                    $this$mapNotNull$iv = generatedDoc.select("#mirror-buttons a[href]");
                    $i$f$mapNotNull = 0;
                    destination$iv$iv = new ArrayList();
                    $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                    $i$f$mapNotNullTo = 0;
                    $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                    while (r12.hasNext()) {
                        element = (Element) element$iv$iv$iv;
                        Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                        href = StringsKt.trim(element.attr("href")).toString();
                        if (StringsKt.isBlank(href)) {
                            zinkLink = null;
                        } else {
                            zinkLink = new ZinkLink(StringsKt.trim(StringsKt.replace(element.text(), "Generate", "", true)).toString(), href);
                        }
                        if (zinkLink != null) {
                            destination$iv$iv.add(zinkLink);
                        }
                        $i$f$mapNotNull = $i$f$mapNotNull;
                        $this$mapNotNull$iv = $this$mapNotNull$iv4;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                        $i$f$mapNotNullTo = $i$f$mapNotNullTo;
                        $this$forEach$iv$iv$iv = $this$forEach$iv$iv$iv;
                    }
                    results = CollectionsKt.toMutableList((List) destination$iv$iv);
                    btn = generatedDoc.selectFirst("#worker-btn");
                    if (btn != null) {
                        matchResultFind$default2 = Regex.find$default(WORKER_REGEX, btn.attr("onclick"), 0, 2, (Object) null);
                        if (matchResultFind$default2 != null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        workerId = str;
                        matchResultFind$default3 = Regex.find$default(SERVER_HANDLER_REGEX, generatedDoc.html(), 0, 2, (Object) null);
                        if (matchResultFind$default3 != null) {
                            serverHandler = null;
                        } else {
                            serverHandler = null;
                        }
                        str2 = workerId;
                        if (str2 != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            str3 = serverHandler;
                            if (str3 != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (!z2) {
                                Result.Companion companion12 = Result.Companion;
                                Requests app6 = MainActivityKt.getApp();
                                RequestBody requestBodyCreate$default3 = RequestBody.Companion.create$default(RequestBody.Companion, StringsKt.trimIndent("\n                                {\n                                    \"server\":\"worker\",\n                                    \"random_id\":\"" + workerId + "\"\n                                }\n                            "), (MediaType) null, 1, (Object) null);
                                Pair[] pairArr3 = new Pair[4];
                                pairArr3[0] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                                pairArr3[1] = TuplesKt.to("Content-Type", "application/json");
                                pairArr3[2] = TuplesKt.to("Origin", StringsKt.substringBefore$default(generatedUrl, "/dl/", (String) null, 2, (Object) null));
                                pairArr3[c] = TuplesKt.to("Referer", generatedUrl);
                                Map mapMapOf3 = MapsKt.mapOf(pairArr3);
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(firstHtml3);
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(firstDoc2);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(firstHtml2);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(ajaxEndpoint3);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(downloadBase4);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(downloadBase5);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(token2);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(generatedUrl);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(generatedDoc);
                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(btn);
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(serverHandler);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(workerId);
                                c00062.L$12 = results;
                                c00062.label = 4;
                                unit = null;
                                generatedUrl3 = generatedUrl;
                                generatedUrl4 = serverHandler;
                                $result = Requests.post$default(app6, generatedUrl4, mapMapOf3, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate$default3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 65276, (Object) null);
                                if ($result == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                results2 = results;
                                serverHandler2 = generatedUrl4;
                                url5 = firstHtml3;
                                i5 = i4;
                                generatedDoc2 = generatedDoc;
                                generatedUrl2 = generatedUrl3;
                                serverHandler3 = ajaxEndpoint3;
                                randomId3 = token2;
                                token3 = downloadBase5;
                                downloadBase6 = downloadBase4;
                                i6 = 0;
                                firstHtml4 = firstHtml2;
                                firstDoc3 = firstDoc2;
                                btn2 = null;
                                workerId2 = workerId;
                                btn3 = btn;
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
                                    i7 = i5;
                                    results2.add(new ZinkLink("WORKER", it3));
                                    unit2 = Unit.INSTANCE;
                                } else {
                                    i7 = i5;
                                    unit2 = unit;
                                }
                                Result.constructor-impl(unit2);
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
                    i5 = 0;
                    btn2 = null;
                    results2 = (List) c00062.L$12;
                    workerId2 = (String) c00062.L$11;
                    serverHandler2 = (String) c00062.L$10;
                    btn3 = (Element) c00062.L$9;
                    generatedDoc2 = (Document) c00062.L$8;
                    generatedUrl2 = (String) c00062.L$7;
                    randomId3 = (String) c00062.L$6;
                    token3 = (String) c00062.L$5;
                    downloadBase6 = (String) c00062.L$4;
                    serverHandler3 = (String) c00062.L$3;
                    firstHtml4 = (String) c00062.L$2;
                    firstDoc3 = (Document) c00062.L$1;
                    url5 = (String) c00062.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        i6 = 0;
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
                            i7 = i5;
                            results2.add(new ZinkLink("WORKER", it3));
                            unit2 = Unit.INSTANCE;
                        } else {
                            i7 = i5;
                            unit2 = unit;
                        }
                        Result.constructor-impl(unit2);
                        results = results2;
                        break;
                    } catch (Throwable th15) {
                        th = th15;
                        Result.Companion companion13 = Result.Companion;
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
        } catch (Throwable th16) {
            th = th16;
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
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
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

    /* JADX WARN: Code duplicated, block: B:31:0x00c4 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:29:0x00ac, B:31:0x00c4, B:34:0x00cc, B:50:0x00ff, B:37:0x00d9, B:39:0x00e5, B:40:0x00eb, B:42:0x00f0), top: B:63:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cc A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:29:0x00ac, B:31:0x00c4, B:34:0x00cc, B:50:0x00ff, B:37:0x00d9, B:39:0x00e5, B:40:0x00eb, B:42:0x00f0), top: B:63:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d9 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:29:0x00ac, B:31:0x00c4, B:34:0x00cc, B:50:0x00ff, B:37:0x00d9, B:39:0x00e5, B:40:0x00eb, B:42:0x00f0), top: B:63:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e5 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:29:0x00ac, B:31:0x00c4, B:34:0x00cc, B:50:0x00ff, B:37:0x00d9, B:39:0x00e5, B:40:0x00eb, B:42:0x00f0), top: B:63:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00f0 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:29:0x00ac, B:31:0x00c4, B:34:0x00cc, B:50:0x00ff, B:37:0x00d9, B:39:0x00e5, B:40:0x00eb, B:42:0x00f0), top: B:63:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:49:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:61:0x0121  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public static final Object bypassShortlink(@NotNull String url, @NotNull Continuation<? super String> continuation) {
        C00051 c00051;
        String url2;
        String link;
        Object obj;
        String docText;
        MatchResult matchResultFind$default;
        String match;
        Element elementSelectFirst;
        String str;
        boolean z;
        String decodedUrl;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = new C00051(continuation);
            }
        } else {
            c00051 = new C00051(continuation);
        }
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!StringsKt.contains$default(url, "tpi.li", false, 2, (Object) null) && !StringsKt.contains$default(url, "oii.la", false, 2, (Object) null)) {
                    return url;
                }
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    c00052.L$0 = url;
                    c00052.label = 1;
                    link = null;
                    try {
                        $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4094, (Object) null);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url2 = url;
                        try {
                            docText = ((NiceResponse) $result).getText();
                            Regex base64Regex = new Regex("aHR0c[a-zA-Z0-9+/=]+");
                            matchResultFind$default = Regex.find$default(base64Regex, docText, 0, 2, link);
                            if (matchResultFind$default != null) {
                                match = matchResultFind$default.getValue();
                            } else {
                                match = link;
                            }
                            if (match != null) {
                                decodedUrl = MainAPIKt.base64Decode(match);
                                if (StringsKt.startsWith$default(decodedUrl, "http", false, 2, link)) {
                                    Document parsedDoc = Jsoup.parse(docText);
                                    elementSelectFirst = parsedDoc.selectFirst("a.get-link");
                                    if (elementSelectFirst != null) {
                                        link = elementSelectFirst.attr("href");
                                    }
                                    str = link;
                                    if (str != null || StringsKt.isBlank(str)) {
                                        z = true;
                                    } else {
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
                                elementSelectFirst = parsedDoc2.selectFirst("a.get-link");
                                if (elementSelectFirst != null) {
                                    link = elementSelectFirst.attr("href");
                                }
                                str = link;
                                if (str != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    decodedUrl = link;
                                } else {
                                    decodedUrl = url2;
                                }
                            }
                            obj = Result.constructor-impl(decodedUrl);
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            return url2;
                        }
                        return obj;
                    } catch (Throwable th2) {
                        th = th2;
                        url2 = url;
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj)) {
                            return url2;
                        }
                        return obj;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    url2 = url;
                }
                break;
            case 1:
                url2 = (String) c00052.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    link = null;
                    docText = ((NiceResponse) $result).getText();
                    Regex base64Regex2 = new Regex("aHR0c[a-zA-Z0-9+/=]+");
                    matchResultFind$default = Regex.find$default(base64Regex2, docText, 0, 2, link);
                    if (matchResultFind$default != null) {
                        match = matchResultFind$default.getValue();
                    } else {
                        match = link;
                    }
                    if (match != null) {
                        decodedUrl = MainAPIKt.base64Decode(match);
                        if (StringsKt.startsWith$default(decodedUrl, "http", false, 2, link)) {
                            Document parsedDoc3 = Jsoup.parse(docText);
                            elementSelectFirst = parsedDoc3.selectFirst("a.get-link");
                            if (elementSelectFirst != null) {
                                link = elementSelectFirst.attr("href");
                            }
                            str = link;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (z) {
                                decodedUrl = link;
                            } else {
                                decodedUrl = url2;
                            }
                        }
                    } else {
                        Document parsedDoc4 = Jsoup.parse(docText);
                        elementSelectFirst = parsedDoc4.selectFirst("a.get-link");
                        if (elementSelectFirst != null) {
                            link = elementSelectFirst.attr("href");
                        }
                        str = link;
                        if (str != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            decodedUrl = link;
                        } else {
                            decodedUrl = url2;
                        }
                    }
                    obj = Result.constructor-impl(decodedUrl);
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj)) {
                        return url2;
                    }
                    return obj;
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
