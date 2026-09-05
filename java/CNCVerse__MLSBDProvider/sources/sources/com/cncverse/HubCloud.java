package com.cncverse;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/MLSBDProvider/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/cncverse/HubCloud;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndexQuality", "", "str", "getBaseUrl", "cleanTitle", "title", "MLSBDProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/cncverse/HubCloud\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,606:1\n1#2:607\n1#2:626\n296#3,2:608\n1915#3,2:610\n1642#3,10:612\n1915#3:622\n1807#3,3:623\n1916#3:627\n1652#3:628\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/cncverse/HubCloud\n*L\n348#1:626\n132#1:608,2\n163#1:610,2\n348#1:612,10\n348#1:622\n354#1:623,3\n348#1:627\n348#1:628\n*E\n"})
public class HubCloud extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Hub-Cloud";

    @NotNull
    private final String mainUrl = "https://hubcloud.foo";

    /* JADX INFO: renamed from: com.cncverse.HubCloud$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.HubCloud", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12}, l = {129, 151, 172, 182, 191, 197, 215, 225, 235, 245, 255, 264, 301}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "$this$getUrl_u24lambda_u242", "$i$a$-runCatching-HubCloud$getUrl$href$1", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "$this$forEach$iv", "element$iv", "element", "link", "text", "label", "quality", "$i$f$forEach", "$i$a$-forEach-HubCloud$getUrl$2", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "$this$forEach$iv", "element$iv", "element", "link", "text", "label", "quality", "$i$f$forEach", "$i$a$-forEach-HubCloud$getUrl$2", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "$this$forEach$iv", "element$iv", "element", "link", "text", "label", "quality", "$i$f$forEach", "$i$a$-forEach-HubCloud$getUrl$2", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "$this$forEach$iv", "element$iv", "element", "link", "text", "label", "resp", "dlink", "quality", "$i$f$forEach", "$i$a$-forEach-HubCloud$getUrl$2", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "$this$forEach$iv", "element$iv", "element", "link", "text", "label", "base", "finalUrl", "quality", "$i$f$forEach", "$i$a$-forEach-HubCloud$getUrl$2", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "$this$forEach$iv", "element$iv", "element", "link", "text", "label", "quality", "$i$f$forEach", "$i$a$-forEach-HubCloud$getUrl$2", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "$this$forEach$iv", "element$iv", "element", "link", "text", "label", "quality", "$i$f$forEach", "$i$a$-forEach-HubCloud$getUrl$2", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "$this$forEach$iv", "element$iv", "element", "link", "text", "label", "quality", "$i$f$forEach", "$i$a$-forEach-HubCloud$getUrl$2", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "$this$forEach$iv", "element$iv", "element", "link", "text", "label", "quality", "$i$f$forEach", "$i$a$-forEach-HubCloud$getUrl$2", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "$this$forEach$iv", "element$iv", "element", "link", "text", "label", "quality", "$i$f$forEach", "$i$a$-forEach-HubCloud$getUrl$2", "$this", "url", "referer", "subtitleCallback", "callback", "tag", "ref", "uri", "realUrl", "baseUrl", "href", "document", "size", "header", "headerDetails", "labelExtras", "$this$forEach$iv", "element$iv", "element", "link", "text", "label", "quality", "$i$f$forEach", "$i$a$-forEach-HubCloud$getUrl$2"}, nl = {131, 152, 171, 181, 192, 196, 214, 224, 234, 244, 256, 263, 304}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "L$24", "L$25", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "L$24", "L$25", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HubCloud.getUrl$suspendImpl(HubCloud.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:178:0x0d49  */
    /* JADX WARN: Code duplicated, block: B:180:0x0d8f  */
    /* JADX WARN: Code duplicated, block: B:182:0x0e54 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:183:0x0e55  */
    /* JADX WARN: Code duplicated, block: B:185:0x0e9b  */
    /* JADX WARN: Code duplicated, block: B:187:0x0eb1  */
    /* JADX WARN: Code duplicated, block: B:189:0x0f67 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:190:0x0f68  */
    /* JADX WARN: Code duplicated, block: B:192:0x0fab  */
    /* JADX WARN: Code duplicated, block: B:194:0x0fc5  */
    /* JADX WARN: Code duplicated, block: B:196:0x1082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:197:0x1083  */
    /* JADX WARN: Code duplicated, block: B:200:0x10a5  */
    /* JADX WARN: Code duplicated, block: B:202:0x10b1  */
    /* JADX WARN: Code duplicated, block: B:203:0x10b4  */
    /* JADX WARN: Code duplicated, block: B:204:0x10b7  */
    /* JADX WARN: Code duplicated, block: B:207:0x10c5  */
    /* JADX WARN: Code duplicated, block: B:209:0x118d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:210:0x118e  */
    /* JADX WARN: Code duplicated, block: B:212:0x11a6  */
    /* JADX WARN: Code duplicated, block: B:214:0x11e6  */
    /* JADX WARN: Code duplicated, block: B:216:0x11fd  */
    /* JADX WARN: Code duplicated, block: B:284:0x195f A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:287:0x1985  */
    /* JADX WARN: Code duplicated, block: B:288:0x1988  */
    /* JADX WARN: Code duplicated, block: B:291:0x1a7c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:292:0x1a7d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.cncverse.HubCloud r63, java.lang.String r64, java.lang.String r65, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r66, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r67, kotlin.coroutines.Continuation<? super kotlin.Unit> r68) {
        /*
            Method dump skipped, instruction units count: 6960
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.HubCloud.getUrl$suspendImpl(com.cncverse.HubCloud, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int getIndexQuality(String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.P2160.getValue() : intOrNull.intValue();
    }

    private final String getBaseUrl(String url) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            HubCloud hubCloud = this;
            URI it = new URI(url);
            obj = Result.constructor-impl(it.getScheme() + "://" + it.getHost());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = "";
        }
        return (String) obj;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:53:0x01d1 A[SYNTHETIC] */
    private final String cleanTitle(String title) {
        List parts;
        Set sourceTags;
        Set codecTags;
        String str;
        boolean z;
        String str2;
        Object it$iv$iv = new Regex("\\.[a-zA-Z0-9]{2,4}$").replace(title, "");
        String normalized = new Regex("DDP[ .]?([0-9]\\.[0-9])", RegexOption.IGNORE_CASE).replace(new Regex("H[ .]?264", RegexOption.IGNORE_CASE).replace(new Regex("H[ .]?265", RegexOption.IGNORE_CASE).replace(new Regex("WEB[-_. ]?RIP", RegexOption.IGNORE_CASE).replace(new Regex("WEB[-_. ]?DL", RegexOption.IGNORE_CASE).replace((CharSequence) it$iv$iv, "WEB-DL"), "WEBRIP"), "H265"), "H264"), "DDP$1");
        List parts2 = StringsKt.split$default(normalized, new String[]{" ", "_", "."}, false, 0, 6, (Object) null);
        Set sourceTags2 = SetsKt.setOf(new String[]{"WEB-DL", "WEBRIP", "BLURAY", "HDRIP", "DVDRIP", "HDTV", "CAM", "TS", "BRRIP", "BDRIP"});
        Set codecTags2 = SetsKt.setOf(new String[]{"H264", "H265", "X264", "X265", "HEVC", "AVC"});
        Iterable audioTags = SetsKt.setOf(new String[]{"AAC", "AC3", "DTS", "MP3", "FLAC", "DD", "DDP", "EAC3"});
        Set audioExtras = SetsKt.setOf("ATMOS");
        Set hdrTags = SetsKt.setOf(new String[]{"SDR", "HDR", "HDR10", "HDR10+", "DV", "DOLBYVISION"});
        List $this$mapNotNull$iv = parts2;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Object name = it$iv$iv;
            String part = (String) element$iv$iv$iv;
            String normalized2 = normalized;
            String p = part.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(p, "toUpperCase(...)");
            if (sourceTags2.contains(p) || codecTags2.contains(p)) {
                parts = parts2;
                sourceTags = sourceTags2;
                codecTags = codecTags2;
            } else {
                Iterable $this$any$iv = audioTags;
                parts = parts2;
                if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                    sourceTags = sourceTags2;
                    codecTags = codecTags2;
                    z = false;
                    str = null;
                } else {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            sourceTags = sourceTags2;
                            codecTags = codecTags2;
                            str = null;
                            z = false;
                            break;
                        }
                        Object element$iv = it.next();
                        String it2 = (String) element$iv;
                        Iterator it3 = it;
                        sourceTags = sourceTags2;
                        codecTags = codecTags2;
                        str = null;
                        if (StringsKt.startsWith$default(p, it2, false, 2, (Object) null)) {
                            z = true;
                            break;
                        }
                        codecTags2 = codecTags;
                        it = it3;
                        sourceTags2 = sourceTags;
                    }
                }
                if (!z && !audioExtras.contains(p)) {
                    if (hdrTags.contains(p)) {
                        if (Intrinsics.areEqual(p, "DV") || Intrinsics.areEqual(p, "DOLBYVISION")) {
                            str2 = "DOLBYVISION";
                        }
                    } else if (!Intrinsics.areEqual(p, "NF") && !Intrinsics.areEqual(p, "CR")) {
                        str2 = str;
                    }
                }
                if (str2 != null) {
                    destination$iv$iv.add(str2);
                }
                it$iv$iv = name;
                normalized = normalized2;
                parts2 = parts;
                codecTags2 = codecTags;
                sourceTags2 = sourceTags;
            }
            str2 = p;
            if (str2 != null) {
                destination$iv$iv.add(str2);
            }
            it$iv$iv = name;
            normalized = normalized2;
            parts2 = parts;
            codecTags2 = codecTags;
            sourceTags2 = sourceTags;
        }
        List filtered = (List) destination$iv$iv;
        return CollectionsKt.joinToString$default(CollectionsKt.distinct(filtered), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
