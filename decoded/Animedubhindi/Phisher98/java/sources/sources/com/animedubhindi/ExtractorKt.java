package com.animedubhindi;

import com.lagradost.cloudstream3.utils.Qualities;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animedubhindi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"getIndexQuality", "", "str", "", "resolveFinalUrl", "startUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Animedubhindi"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ExtractorKt {

    /* JADX INFO: renamed from: com.animedubhindi.ExtractorKt$resolveFinalUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animedubhindi.ExtractorKt", f = "Extractor.kt", i = {0, 0, 0, 0}, l = {500}, m = "resolveFinalUrl", n = {"startUrl", "currentUrl", "loopCount", "maxRedirects"}, nl = {501}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return ExtractorKt.resolveFinalUrl(null, (Continuation) this);
        }
    }

    public static final int getIndexQuality(@Nullable String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:27:0x00bc A[Catch: Exception -> 0x00f4, TryCatch #2 {Exception -> 0x00f4, blocks: (B:25:0x00b1, B:27:0x00bc, B:36:0x00cf, B:38:0x00de), top: B:57:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ce A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x00de A[Catch: Exception -> 0x00f4, TRY_LEAVE, TryCatch #2 {Exception -> 0x00f4, blocks: (B:25:0x00b1, B:27:0x00bc, B:36:0x00cf, B:38:0x00de), top: B:57:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:59:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ac -> B:57:0x00b1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object resolveFinalUrl(@org.jetbrains.annotations.NotNull java.lang.String r26, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r27) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animedubhindi.ExtractorKt.resolveFinalUrl(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
