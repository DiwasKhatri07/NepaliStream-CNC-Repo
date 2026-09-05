package com.cncverse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: PlayZTVProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PlayZTVProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1", f = "PlayZTVProviderManager.kt", i = {0, 0, 0, 0, 0}, l = {215}, m = "invokeSuspend", n = {"cat", "serverName", "api", "catType", "categoryEntries"}, nl = {216}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
@SourceDebugExtension({"SMAP\nPlayZTVProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchProviders$2$results$1$1$1\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,427:1\n63#2:428\n64#2,15:430\n63#2:447\n64#2,15:449\n63#2:477\n64#2,15:479\n1#3:429\n1#3:448\n1#3:478\n1#3:496\n50#4:445\n43#4:446\n50#4:464\n43#4:465\n50#4:494\n43#4:495\n1642#5,10:466\n1915#5:476\n1916#5:497\n1652#5:498\n777#5:499\n873#5,2:500\n1807#5,3:502\n*S KotlinDebug\n*F\n+ 1 PlayZTVProviderManager.kt\ncom/cncverse/PlayZTVProviderManager$fetchProviders$2$results$1$1$1\n*L\n205#1:428\n205#1:430,15\n220#1:447\n220#1:449,15\n223#1:477\n223#1:479,15\n205#1:429\n220#1:448\n223#1:478\n221#1:496\n205#1:445\n205#1:446\n220#1:464\n220#1:465\n223#1:494\n223#1:495\n221#1:466,10\n221#1:476\n221#1:497\n221#1:498\n225#1:499\n225#1:500,2\n227#1:502,3\n*E\n"})
final class PlayZTVProviderManager$fetchProviders$2$results$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>>, Object> {
    final /* synthetic */ PlayZTVCategoryWrapper $wrapper;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayZTVProviderManager$fetchProviders$2$results$1$1$1(PlayZTVCategoryWrapper playZTVCategoryWrapper, Continuation<? super PlayZTVProviderManager$fetchProviders$2$results$1$1$1> continuation) {
        super(2, continuation);
        this.$wrapper = playZTVCategoryWrapper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayZTVProviderManager$fetchProviders$2$results$1$1$1(this.$wrapper, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0253  */
    /* JADX WARN: Code duplicated, block: B:119:0x027a  */
    /* JADX WARN: Code duplicated, block: B:124:0x02ba A[Catch: Exception -> 0x059e, TRY_LEAVE, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0302  */
    /* JADX WARN: Code duplicated, block: B:150:0x034f  */
    /* JADX WARN: Code duplicated, block: B:167:0x0376  */
    /* JADX WARN: Code duplicated, block: B:178:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:180:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:185:0x03da A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x03f8 A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x0400 A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x0409  */
    /* JADX WARN: Code duplicated, block: B:195:0x040c  */
    /* JADX WARN: Code duplicated, block: B:196:0x040e  */
    /* JADX WARN: Code duplicated, block: B:198:0x0411 A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:199:0x0417  */
    /* JADX WARN: Code duplicated, block: B:204:0x0434 A[Catch: Exception -> 0x059e, TRY_ENTER, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x0442 A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x044c A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x046a A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:214:0x0470 A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:216:0x047f  */
    /* JADX WARN: Code duplicated, block: B:217:0x0481  */
    /* JADX WARN: Code duplicated, block: B:220:0x0486 A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x048c A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:225:0x049a  */
    /* JADX WARN: Code duplicated, block: B:227:0x049d  */
    /* JADX WARN: Code duplicated, block: B:228:0x049e  */
    /* JADX WARN: Code duplicated, block: B:229:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:233:0x04a7 A[LOOP:3: B:208:0x0446->B:233:0x04a7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:237:0x04b8 A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:240:0x04c3 A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:242:0x04cf A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:244:0x04db  */
    /* JADX WARN: Code duplicated, block: B:247:0x0504 A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:248:0x050f  */
    /* JADX WARN: Code duplicated, block: B:250:0x0512  */
    /* JADX WARN: Code duplicated, block: B:253:0x0527 A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:255:0x0537 A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:259:0x0548  */
    /* JADX WARN: Code duplicated, block: B:263:0x055b A[Catch: Exception -> 0x059e, TryCatch #12 {Exception -> 0x059e, blocks: (B:100:0x024d, B:103:0x0254, B:121:0x0297, B:122:0x02b4, B:124:0x02ba, B:179:0x03a6, B:182:0x03b6, B:183:0x03d4, B:185:0x03da, B:187:0x03f8, B:189:0x0400, B:198:0x0411, B:201:0x041e, B:204:0x0434, B:237:0x04b8, B:238:0x04bd, B:240:0x04c3, B:242:0x04cf, B:245:0x04dd, B:247:0x0504, B:251:0x0513, B:253:0x0527, B:255:0x0537, B:261:0x054b, B:263:0x055b, B:266:0x0562, B:270:0x057b, B:207:0x0442, B:208:0x0446, B:210:0x044c, B:212:0x046a, B:214:0x0470, B:220:0x0486, B:222:0x048c, B:120:0x027c, B:118:0x0273, B:99:0x0243), top: B:307:0x0243 }] */
    /* JADX WARN: Code duplicated, block: B:268:0x0576  */
    /* JADX WARN: Code duplicated, block: B:269:0x0579  */
    /* JADX WARN: Code duplicated, block: B:273:0x059b  */
    /* JADX WARN: Code duplicated, block: B:281:0x05d0  */
    /* JADX WARN: Code duplicated, block: B:283:0x05d7 A[Catch: Exception -> 0x0614, TryCatch #21 {Exception -> 0x0614, blocks: (B:7:0x003d, B:69:0x01bf, B:71:0x01c7, B:283:0x05d7, B:287:0x05e8, B:280:0x05a9, B:10:0x004d, B:16:0x0079, B:28:0x00b5, B:31:0x00bc, B:41:0x00f0, B:43:0x0101, B:45:0x0106, B:47:0x012a, B:50:0x0137, B:52:0x0144, B:54:0x014f, B:56:0x0157, B:59:0x0160, B:63:0x0172, B:65:0x01a1, B:40:0x00d7, B:39:0x00d1, B:27:0x00ab, B:15:0x006f, B:12:0x0057, B:34:0x00c2), top: B:325:0x001c, inners: #6, #23 }] */
    /* JADX WARN: Code duplicated, block: B:285:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:286:0x05e7  */
    /* JADX WARN: Code duplicated, block: B:309:0x030a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:315:0x021c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:328:0x0356 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:332:0x025a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:343:0x04ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:344:0x04a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:90:0x0219  */
    public final Object invokeSuspend(Object $result) {
        char c;
        Object obj;
        Object objDecodeFromString;
        String serverName;
        String api;
        String catType;
        ArrayList categoryEntries;
        String str;
        Object objFetchDecrypted;
        String catType2;
        PlayZTVCategoryData cat;
        String channelContent;
        boolean hasExpandedPlaylists;
        String str2;
        boolean z;
        PlayZTVCategoryData cat2;
        Object obj2;
        DeserializationStrategy deserializationStrategy;
        String value$iv;
        Object objDecodeFromString2;
        List channelWrappers;
        Iterable destination$iv$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv2;
        Iterable $this$filter$iv;
        int $i$f$filter;
        Collection destination$iv$iv3;
        List validChannels;
        List $this$any$iv;
        int $i$f$any;
        String str3;
        Iterator it;
        List validChannels2;
        boolean containsPlaylists;
        PlayZTVChannelData it2;
        Iterable $this$any$iv2;
        int $i$f$any2;
        boolean z2;
        String links;
        boolean z3;
        String links2;
        boolean z4;
        Iterator it3;
        PlayZTVChannelData ch;
        String name;
        String chName;
        String links3;
        String rawLinks;
        String str4;
        boolean isPl;
        String logo;
        String str5;
        PlayZTVChannelData it4;
        boolean z5;
        String links4;
        boolean z6;
        List channelWrappers2;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull2;
        PlayZTVChannelData playZTVChannelData;
        Collection destination$iv$iv4;
        String value$iv2;
        Object obj3;
        Iterable $this$mapNotNull$iv2;
        DeserializationStrategy deserializationStrategy2;
        String value$iv3;
        Object objDecodeFromString3;
        String logo2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str6 = "";
        try {
            switch (this.label) {
                case 0:
                    c = 3;
                    ResultKt.throwOnFailure($result);
                    AppUtils appUtils = AppUtils.INSTANCE;
                    String value$iv4 = this.$wrapper.getCat();
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(PlayZTVCategoryData.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        break;
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            try {
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayZTVCategoryData.class), (List) null, 2, (Object) null));
                            } catch (Throwable th2) {
                                th = th2;
                                Result.Companion companion4 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        break;
                    }
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    DeserializationStrategy deserializationStrategy3 = (KSerializer) obj;
                    if (deserializationStrategy3 != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy3, value$iv4);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv4, new TypeReference<PlayZTVCategoryData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$$inlined$parseJson$1
                            });
                        } catch (Throwable th4) {
                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv4, new TypeReference<PlayZTVCategoryData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$$inlined$parseJson$1
                            });
                        }
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv4, new TypeReference<PlayZTVCategoryData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$$inlined$parseJson$1
                        });
                    }
                    PlayZTVCategoryData cat3 = (PlayZTVCategoryData) objDecodeFromString;
                    if (Intrinsics.areEqual(cat3.getVisible(), Boxing.boxBoolean(false))) {
                        return CollectionsKt.emptyList();
                    }
                    serverName = StringsKt.trim(cat3.getName()).toString();
                    api = StringsKt.trim(cat3.getApi()).toString();
                    String type = cat3.getType();
                    if (type == null || (catType = StringsKt.trim(type).toString()) == null) {
                        catType = "custom";
                    }
                    categoryEntries = new ArrayList();
                    if (Intrinsics.areEqual(catType, "custom")) {
                        str = "custom";
                    } else {
                        str = "custom";
                        if (!StringsKt.startsWith(api, "channels/", true) && (!StringsKt.endsWith(api, ".txt", true) || StringsKt.startsWith(api, "http", true))) {
                            Pair[] pairArr = new Pair[5];
                            pairArr[0] = TuplesKt.to("title", serverName);
                            String logo3 = cat3.getLogo();
                            if (logo3 != null) {
                                str6 = logo3;
                            }
                            pairArr[1] = TuplesKt.to("image", str6);
                            pairArr[2] = TuplesKt.to("catLink", api);
                            pairArr[3] = TuplesKt.to("type", catType);
                            pairArr[4] = TuplesKt.to("server", serverName);
                            Boxing.boxBoolean(categoryEntries.add(MapsKt.mapOf(pairArr)));
                            return categoryEntries;
                        }
                    }
                    this.L$0 = cat3;
                    this.L$1 = serverName;
                    this.L$2 = api;
                    this.L$3 = catType;
                    this.L$4 = categoryEntries;
                    this.label = 1;
                    objFetchDecrypted = PlayZTVProviderManager.INSTANCE.fetchDecrypted(api, (Continuation) this);
                    if (objFetchDecrypted == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    catType2 = catType;
                    cat = cat3;
                    channelContent = (String) objFetchDecrypted;
                    hasExpandedPlaylists = false;
                    str2 = channelContent;
                    if (str2 != null || StringsKt.isBlank(str2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        try {
                            AppUtils appUtils2 = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion5 = Result.Companion;
                                try {
                                    KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayZTVChannelWrapper.class)));
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                    break;
                                } catch (Throwable th5) {
                                    th = th5;
                                    try {
                                        Result.Companion companion6 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e2) {
                                        e = e2;
                                        cat2 = cat;
                                        System.out.println((Object) ("PlayZTV: Error parsing custom channels for " + serverName + " – " + e.getMessage()));
                                        if (!hasExpandedPlaylists) {
                                            Pair[] pairArr2 = new Pair[5];
                                            pairArr2[0] = TuplesKt.to("title", serverName);
                                            logo2 = cat2.getLogo();
                                            if (logo2 != null) {
                                                str6 = logo2;
                                            }
                                            pairArr2[1] = TuplesKt.to("image", str6);
                                            pairArr2[2] = TuplesKt.to("catLink", api);
                                            pairArr2[c] = TuplesKt.to("type", catType2);
                                            pairArr2[4] = TuplesKt.to("server", serverName);
                                            categoryEntries.add(MapsKt.mapOf(pairArr2));
                                        }
                                        return categoryEntries;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                            if (Result.exceptionOrNull-impl(obj2) != null) {
                                cat2 = cat;
                            } else {
                                try {
                                    Result.Companion companion7 = Result.Companion;
                                    cat2 = cat;
                                    try {
                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                        break;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        try {
                                            Result.Companion companion8 = Result.Companion;
                                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e3) {
                                            e = e3;
                                            System.out.println((Object) ("PlayZTV: Error parsing custom channels for " + serverName + " – " + e.getMessage()));
                                        }
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    cat2 = cat;
                                }
                            }
                            if (Result.isFailure-impl(obj2)) {
                                obj2 = null;
                            }
                            deserializationStrategy = (KSerializer) obj2;
                            if (deserializationStrategy != null) {
                                try {
                                    value$iv = channelContent;
                                    try {
                                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                    } catch (SerializationException e4) {
                                        e$iv = e4;
                                        ArchComponentExtKt.logError((Throwable) e$iv);
                                        ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                        String content$iv$iv = value$iv;
                                        objDecodeFromString2 = $this$readValue$iv$iv4.readValue(content$iv$iv, new TypeReference<List<? extends PlayZTVChannelWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$$inlined$parseJson$2
                                        });
                                    } catch (Throwable th9) {
                                        ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                        String content$iv$iv2 = value$iv;
                                        objDecodeFromString2 = $this$readValue$iv$iv5.readValue(content$iv$iv2, new TypeReference<List<? extends PlayZTVChannelWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$$inlined$parseJson$2
                                        });
                                    }
                                } catch (SerializationException e5) {
                                    e$iv = e5;
                                    value$iv = channelContent;
                                } catch (Throwable th10) {
                                    value$iv = channelContent;
                                }
                                channelWrappers = (List) objDecodeFromString2;
                                destination$iv$iv = channelWrappers;
                                $i$f$mapNotNull = 0;
                                destination$iv$iv2 = new ArrayList();
                                for (Object element$iv$iv$iv : destination$iv$iv) {
                                    PlayZTVChannelWrapper cw = (PlayZTVChannelWrapper) element$iv$iv$iv;
                                    try {
                                        AppUtils appUtils3 = AppUtils.INSTANCE;
                                        value$iv2 = cw.getChannel();
                                        try {
                                            Result.Companion companion9 = Result.Companion;
                                            KType kTypeTypeOf3 = Reflection.typeOf(PlayZTVChannelData.class);
                                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                        } catch (Throwable th11) {
                                            Result.Companion companion10 = Result.Companion;
                                            obj3 = Result.constructor-impl(ResultKt.createFailure(th11));
                                        }
                                        if (Result.exceptionOrNull-impl(obj3) != null) {
                                            channelWrappers2 = channelWrappers;
                                            $this$mapNotNull$iv = destination$iv$iv;
                                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                                            $this$mapNotNull$iv2 = null;
                                        } else {
                                            try {
                                                Result.Companion companion11 = Result.Companion;
                                                channelWrappers2 = channelWrappers;
                                                try {
                                                    $this$mapNotNull$iv = destination$iv$iv;
                                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                    $this$mapNotNull$iv2 = null;
                                                    try {
                                                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayZTVChannelData.class), (List) null, 2, (Object) null));
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                        Result.Companion companion12 = Result.Companion;
                                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    }
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    $this$mapNotNull$iv = destination$iv$iv;
                                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                    $this$mapNotNull$iv2 = null;
                                                }
                                            } catch (Throwable th14) {
                                                th = th14;
                                                channelWrappers2 = channelWrappers;
                                                $this$mapNotNull$iv = destination$iv$iv;
                                                $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                $this$mapNotNull$iv2 = null;
                                            }
                                        }
                                        try {
                                            if (Result.isFailure-impl(obj3)) {
                                                obj3 = $this$mapNotNull$iv2;
                                            }
                                            deserializationStrategy2 = (KSerializer) obj3;
                                            if (deserializationStrategy2 != null) {
                                                try {
                                                    value$iv3 = value$iv2;
                                                    try {
                                                        objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
                                                    } catch (SerializationException e6) {
                                                        e$iv = e6;
                                                        ArchComponentExtKt.logError((Throwable) e$iv);
                                                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                                        String content$iv$iv3 = value$iv3;
                                                        objDecodeFromString3 = $this$readValue$iv$iv6.readValue(content$iv$iv3, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                        });
                                                    } catch (Throwable th15) {
                                                        ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                                                        String content$iv$iv4 = value$iv3;
                                                        objDecodeFromString3 = $this$readValue$iv$iv7.readValue(content$iv$iv4, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                        });
                                                    }
                                                } catch (SerializationException e7) {
                                                    e$iv = e7;
                                                    value$iv3 = value$iv2;
                                                } catch (Throwable th16) {
                                                    value$iv3 = value$iv2;
                                                }
                                                playZTVChannelData = (PlayZTVChannelData) objDecodeFromString3;
                                                if (playZTVChannelData != null) {
                                                    destination$iv$iv4 = destination$iv$iv2;
                                                    destination$iv$iv4.add(playZTVChannelData);
                                                } else {
                                                    destination$iv$iv4 = destination$iv$iv2;
                                                }
                                                destination$iv$iv2 = destination$iv$iv4;
                                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                                destination$iv$iv = $this$mapNotNull$iv;
                                                channelWrappers = channelWrappers2;
                                            } else {
                                                value$iv3 = value$iv2;
                                            }
                                            ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                                            String content$iv$iv5 = value$iv3;
                                            objDecodeFromString3 = $this$readValue$iv$iv8.readValue(content$iv$iv5, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$lambda$0$$inlined$parseJson$1
                                            });
                                            playZTVChannelData = (PlayZTVChannelData) objDecodeFromString3;
                                        } catch (Exception e8) {
                                            playZTVChannelData = null;
                                        }
                                    } catch (Exception e9) {
                                        channelWrappers2 = channelWrappers;
                                        $this$mapNotNull$iv = destination$iv$iv;
                                        $i$f$mapNotNull2 = $i$f$mapNotNull;
                                        playZTVChannelData = null;
                                        if (playZTVChannelData != null) {
                                            destination$iv$iv4 = destination$iv$iv2;
                                            destination$iv$iv4.add(playZTVChannelData);
                                        } else {
                                            destination$iv$iv4 = destination$iv$iv2;
                                        }
                                        destination$iv$iv2 = destination$iv$iv4;
                                        $i$f$mapNotNull = $i$f$mapNotNull2;
                                        destination$iv$iv = $this$mapNotNull$iv;
                                        channelWrappers = channelWrappers2;
                                    }
                                    if (playZTVChannelData != null) {
                                        destination$iv$iv4 = destination$iv$iv2;
                                        destination$iv$iv4.add(playZTVChannelData);
                                    } else {
                                        destination$iv$iv4 = destination$iv$iv2;
                                    }
                                    destination$iv$iv2 = destination$iv$iv4;
                                    $i$f$mapNotNull = $i$f$mapNotNull2;
                                    destination$iv$iv = $this$mapNotNull$iv;
                                    channelWrappers = channelWrappers2;
                                    break;
                                }
                                Iterable $this$mapNotNull$iv3 = destination$iv$iv2;
                                $this$filter$iv = (List) $this$mapNotNull$iv3;
                                $i$f$filter = 0;
                                destination$iv$iv3 = new ArrayList();
                                for (Object element$iv$iv : $this$filter$iv) {
                                    it4 = (PlayZTVChannelData) element$iv$iv;
                                    Iterable $this$filter$iv2 = $this$filter$iv;
                                    int $i$f$filter2 = $i$f$filter;
                                    if (Intrinsics.areEqual(it4.getVisible(), Boxing.boxBoolean(false))) {
                                        z5 = false;
                                    } else {
                                        links4 = it4.getLinks();
                                        if (links4 != null || StringsKt.isBlank(links4)) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        if (z6) {
                                            z5 = false;
                                        } else {
                                            z5 = true;
                                        }
                                    }
                                    if (z5) {
                                        destination$iv$iv3.add(element$iv$iv);
                                    }
                                    $this$filter$iv = $this$filter$iv2;
                                    $i$f$filter = $i$f$filter2;
                                }
                                validChannels = (List) destination$iv$iv3;
                                $this$any$iv = validChannels;
                                $i$f$any = 0;
                                str3 = ".m3u8";
                                if (($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                                    it = $this$any$iv.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            Object element$iv = it.next();
                                            it2 = (PlayZTVChannelData) element$iv;
                                            validChannels2 = validChannels;
                                            $this$any$iv2 = $this$any$iv;
                                            if (Intrinsics.areEqual(it2.is_playlist(), Boxing.boxBoolean(true))) {
                                                $i$f$any2 = $i$f$any;
                                            } else {
                                                links = it2.getLinks();
                                                if (links != null) {
                                                    $i$f$any2 = $i$f$any;
                                                    z3 = StringsKt.contains(links, ".m3u", true);
                                                    if (z3) {
                                                        links2 = it2.getLinks();
                                                        if (links2 == null && StringsKt.contains(links2, ".m3u8", true)) {
                                                            z4 = true;
                                                        } else {
                                                            z4 = false;
                                                        }
                                                        if (z4) {
                                                            z2 = false;
                                                        }
                                                    }
                                                    if (z2) {
                                                        containsPlaylists = true;
                                                    } else {
                                                        validChannels = validChannels2;
                                                        $this$any$iv = $this$any$iv2;
                                                        $i$f$any = $i$f$any2;
                                                    }
                                                } else {
                                                    $i$f$any2 = $i$f$any;
                                                }
                                                if (z3) {
                                                    links2 = it2.getLinks();
                                                    if (links2 == null) {
                                                        z4 = false;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    if (z4) {
                                                        z2 = false;
                                                    }
                                                }
                                                if (z2) {
                                                    containsPlaylists = true;
                                                } else {
                                                    validChannels = validChannels2;
                                                    $this$any$iv = $this$any$iv2;
                                                    $i$f$any = $i$f$any2;
                                                }
                                            }
                                            z2 = true;
                                            if (z2) {
                                                containsPlaylists = true;
                                            } else {
                                                validChannels = validChannels2;
                                                $this$any$iv = $this$any$iv2;
                                                $i$f$any = $i$f$any2;
                                            }
                                        } else {
                                            validChannels2 = validChannels;
                                            containsPlaylists = false;
                                        }
                                    }
                                } else {
                                    validChannels2 = validChannels;
                                    containsPlaylists = false;
                                }
                                if (containsPlaylists) {
                                    hasExpandedPlaylists = true;
                                    it3 = validChannels2.iterator();
                                    while (it3.hasNext()) {
                                        ch = (PlayZTVChannelData) it3.next();
                                        name = ch.getName();
                                        if (name != null || (chName = StringsKt.trim(name).toString()) == null) {
                                            chName = "Channel";
                                        }
                                        boolean containsPlaylists2 = containsPlaylists;
                                        Iterator it5 = it3;
                                        String providerTitle = chName + " (" + serverName + ')';
                                        links3 = ch.getLinks();
                                        if (links3 != null) {
                                            rawLinks = StringsKt.trim(links3).toString();
                                        } else {
                                            rawLinks = null;
                                        }
                                        if (rawLinks == null) {
                                            rawLinks = "";
                                        }
                                        if (Intrinsics.areEqual(ch.is_playlist(), Boxing.boxBoolean(true))) {
                                            str4 = str3;
                                        } else {
                                            str4 = str3;
                                            if (StringsKt.contains(rawLinks, ".m3u", true) && !StringsKt.contains(rawLinks, str4, true)) {
                                                isPl = false;
                                            }
                                            Pair[] pairArr3 = new Pair[5];
                                            pairArr3[0] = TuplesKt.to("title", providerTitle);
                                            logo = ch.getLogo();
                                            if (logo == null && (logo = cat2.getLogo()) == null) {
                                                logo = "";
                                            }
                                            pairArr3[1] = TuplesKt.to("image", logo);
                                            pairArr3[2] = TuplesKt.to("catLink", rawLinks);
                                            if (isPl) {
                                                str5 = "m3u";
                                            } else {
                                                str5 = str;
                                            }
                                            pairArr3[c] = TuplesKt.to("type", str5);
                                            pairArr3[4] = TuplesKt.to("server", serverName);
                                            categoryEntries.add(MapsKt.mapOf(pairArr3));
                                            containsPlaylists = containsPlaylists2;
                                            it3 = it5;
                                            str3 = str4;
                                        }
                                        isPl = true;
                                        Pair[] pairArr4 = new Pair[5];
                                        pairArr4[0] = TuplesKt.to("title", providerTitle);
                                        logo = ch.getLogo();
                                        if (logo == null) {
                                            logo = "";
                                        }
                                        pairArr4[1] = TuplesKt.to("image", logo);
                                        pairArr4[2] = TuplesKt.to("catLink", rawLinks);
                                        if (isPl) {
                                            str5 = "m3u";
                                        } else {
                                            str5 = str;
                                        }
                                        pairArr4[c] = TuplesKt.to("type", str5);
                                        pairArr4[4] = TuplesKt.to("server", serverName);
                                        categoryEntries.add(MapsKt.mapOf(pairArr4));
                                        containsPlaylists = containsPlaylists2;
                                        it3 = it5;
                                        str3 = str4;
                                        break;
                                    }
                                }
                            } else {
                                value$iv = channelContent;
                            }
                            ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                            String content$iv$iv6 = value$iv;
                            objDecodeFromString2 = $this$readValue$iv$iv9.readValue(content$iv$iv6, new TypeReference<List<? extends PlayZTVChannelWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$$inlined$parseJson$2
                            });
                            channelWrappers = (List) objDecodeFromString2;
                            destination$iv$iv = channelWrappers;
                            $i$f$mapNotNull = 0;
                            destination$iv$iv2 = new ArrayList();
                            while (r30.hasNext()) {
                                PlayZTVChannelWrapper cw2 = (PlayZTVChannelWrapper) element$iv$iv$iv;
                                AppUtils appUtils4 = AppUtils.INSTANCE;
                                value$iv2 = cw2.getChannel();
                                Result.Companion companion13 = Result.Companion;
                                KType kTypeTypeOf4 = Reflection.typeOf(PlayZTVChannelData.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                                if (Result.exceptionOrNull-impl(obj3) != null) {
                                    Result.Companion companion14 = Result.Companion;
                                    channelWrappers2 = channelWrappers;
                                    $this$mapNotNull$iv = destination$iv$iv;
                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                    $this$mapNotNull$iv2 = null;
                                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayZTVChannelData.class), (List) null, 2, (Object) null));
                                } else {
                                    channelWrappers2 = channelWrappers;
                                    $this$mapNotNull$iv = destination$iv$iv;
                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                    $this$mapNotNull$iv2 = null;
                                }
                                if (Result.isFailure-impl(obj3)) {
                                    obj3 = $this$mapNotNull$iv2;
                                }
                                deserializationStrategy2 = (KSerializer) obj3;
                                if (deserializationStrategy2 != null) {
                                    value$iv3 = value$iv2;
                                    objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
                                    playZTVChannelData = (PlayZTVChannelData) objDecodeFromString3;
                                    if (playZTVChannelData != null) {
                                        destination$iv$iv4 = destination$iv$iv2;
                                        destination$iv$iv4.add(playZTVChannelData);
                                    } else {
                                        destination$iv$iv4 = destination$iv$iv2;
                                    }
                                    destination$iv$iv2 = destination$iv$iv4;
                                    $i$f$mapNotNull = $i$f$mapNotNull2;
                                    destination$iv$iv = $this$mapNotNull$iv;
                                    channelWrappers = channelWrappers2;
                                } else {
                                    value$iv3 = value$iv2;
                                }
                                ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                                String content$iv$iv7 = value$iv3;
                                objDecodeFromString3 = $this$readValue$iv$iv10.readValue(content$iv$iv7, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$lambda$0$$inlined$parseJson$1
                                });
                                playZTVChannelData = (PlayZTVChannelData) objDecodeFromString3;
                                if (playZTVChannelData != null) {
                                    destination$iv$iv4 = destination$iv$iv2;
                                    destination$iv$iv4.add(playZTVChannelData);
                                } else {
                                    destination$iv$iv4 = destination$iv$iv2;
                                }
                                destination$iv$iv2 = destination$iv$iv4;
                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                destination$iv$iv = $this$mapNotNull$iv;
                                channelWrappers = channelWrappers2;
                                break;
                            }
                            Iterable $this$mapNotNull$iv4 = destination$iv$iv2;
                            $this$filter$iv = (List) $this$mapNotNull$iv4;
                            $i$f$filter = 0;
                            destination$iv$iv3 = new ArrayList();
                            while (r21.hasNext()) {
                                it4 = (PlayZTVChannelData) element$iv$iv;
                                Iterable $this$filter$iv3 = $this$filter$iv;
                                int $i$f$filter3 = $i$f$filter;
                                if (Intrinsics.areEqual(it4.getVisible(), Boxing.boxBoolean(false))) {
                                    z5 = false;
                                } else {
                                    links4 = it4.getLinks();
                                    if (links4 != null) {
                                        z6 = true;
                                    } else {
                                        z6 = true;
                                    }
                                    if (z6) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                }
                                if (z5) {
                                    destination$iv$iv3.add(element$iv$iv);
                                }
                                $this$filter$iv = $this$filter$iv3;
                                $i$f$filter = $i$f$filter3;
                            }
                            validChannels = (List) destination$iv$iv3;
                            $this$any$iv = validChannels;
                            $i$f$any = 0;
                            str3 = ".m3u8";
                            if ($this$any$iv instanceof Collection) {
                                it = $this$any$iv.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Object element$iv2 = it.next();
                                        it2 = (PlayZTVChannelData) element$iv2;
                                        validChannels2 = validChannels;
                                        $this$any$iv2 = $this$any$iv;
                                        if (Intrinsics.areEqual(it2.is_playlist(), Boxing.boxBoolean(true))) {
                                            links = it2.getLinks();
                                            if (links != null) {
                                                $i$f$any2 = $i$f$any;
                                                if (StringsKt.contains(links, ".m3u", true)) {
                                                }
                                                if (z3) {
                                                    links2 = it2.getLinks();
                                                    if (links2 == null) {
                                                        z4 = false;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    if (z4) {
                                                        z2 = false;
                                                    }
                                                }
                                                if (z2) {
                                                    containsPlaylists = true;
                                                } else {
                                                    validChannels = validChannels2;
                                                    $this$any$iv = $this$any$iv2;
                                                    $i$f$any = $i$f$any2;
                                                }
                                            } else {
                                                $i$f$any2 = $i$f$any;
                                            }
                                            if (z3) {
                                                links2 = it2.getLinks();
                                                if (links2 == null) {
                                                    z4 = false;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (z4) {
                                                    z2 = false;
                                                }
                                            }
                                            if (z2) {
                                                containsPlaylists = true;
                                            } else {
                                                validChannels = validChannels2;
                                                $this$any$iv = $this$any$iv2;
                                                $i$f$any = $i$f$any2;
                                            }
                                        } else {
                                            $i$f$any2 = $i$f$any;
                                        }
                                        z2 = true;
                                        if (z2) {
                                            containsPlaylists = true;
                                        } else {
                                            validChannels = validChannels2;
                                            $this$any$iv = $this$any$iv2;
                                            $i$f$any = $i$f$any2;
                                        }
                                    } else {
                                        validChannels2 = validChannels;
                                        containsPlaylists = false;
                                    }
                                }
                            } else {
                                it = $this$any$iv.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Object element$iv3 = it.next();
                                        it2 = (PlayZTVChannelData) element$iv3;
                                        validChannels2 = validChannels;
                                        $this$any$iv2 = $this$any$iv;
                                        if (Intrinsics.areEqual(it2.is_playlist(), Boxing.boxBoolean(true))) {
                                            links = it2.getLinks();
                                            if (links != null) {
                                                $i$f$any2 = $i$f$any;
                                                if (StringsKt.contains(links, ".m3u", true)) {
                                                }
                                                if (z3) {
                                                    links2 = it2.getLinks();
                                                    if (links2 == null) {
                                                        z4 = false;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    if (z4) {
                                                        z2 = false;
                                                    }
                                                }
                                                if (z2) {
                                                    containsPlaylists = true;
                                                } else {
                                                    validChannels = validChannels2;
                                                    $this$any$iv = $this$any$iv2;
                                                    $i$f$any = $i$f$any2;
                                                }
                                            } else {
                                                $i$f$any2 = $i$f$any;
                                            }
                                            if (z3) {
                                                links2 = it2.getLinks();
                                                if (links2 == null) {
                                                    z4 = false;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (z4) {
                                                    z2 = false;
                                                }
                                            }
                                            if (z2) {
                                                containsPlaylists = true;
                                            } else {
                                                validChannels = validChannels2;
                                                $this$any$iv = $this$any$iv2;
                                                $i$f$any = $i$f$any2;
                                            }
                                        } else {
                                            $i$f$any2 = $i$f$any;
                                        }
                                        z2 = true;
                                        if (z2) {
                                            containsPlaylists = true;
                                        } else {
                                            validChannels = validChannels2;
                                            $this$any$iv = $this$any$iv2;
                                            $i$f$any = $i$f$any2;
                                        }
                                    } else {
                                        validChannels2 = validChannels;
                                        containsPlaylists = false;
                                    }
                                }
                            }
                            if (containsPlaylists) {
                                hasExpandedPlaylists = true;
                                it3 = validChannels2.iterator();
                                while (it3.hasNext()) {
                                    ch = (PlayZTVChannelData) it3.next();
                                    name = ch.getName();
                                    if (name != null) {
                                        chName = "Channel";
                                    } else {
                                        chName = "Channel";
                                    }
                                    boolean containsPlaylists3 = containsPlaylists;
                                    Iterator it6 = it3;
                                    String providerTitle2 = chName + " (" + serverName + ')';
                                    links3 = ch.getLinks();
                                    if (links3 != null) {
                                        rawLinks = StringsKt.trim(links3).toString();
                                    } else {
                                        rawLinks = null;
                                    }
                                    if (rawLinks == null) {
                                        rawLinks = "";
                                    }
                                    if (Intrinsics.areEqual(ch.is_playlist(), Boxing.boxBoolean(true))) {
                                        str4 = str3;
                                        if (StringsKt.contains(rawLinks, ".m3u", true)) {
                                        }
                                        Pair[] pairArr5 = new Pair[5];
                                        pairArr5[0] = TuplesKt.to("title", providerTitle2);
                                        logo = ch.getLogo();
                                        if (logo == null) {
                                            logo = "";
                                        }
                                        pairArr5[1] = TuplesKt.to("image", logo);
                                        pairArr5[2] = TuplesKt.to("catLink", rawLinks);
                                        if (isPl) {
                                            str5 = "m3u";
                                        } else {
                                            str5 = str;
                                        }
                                        pairArr5[c] = TuplesKt.to("type", str5);
                                        pairArr5[4] = TuplesKt.to("server", serverName);
                                        categoryEntries.add(MapsKt.mapOf(pairArr5));
                                        containsPlaylists = containsPlaylists3;
                                        it3 = it6;
                                        str3 = str4;
                                    } else {
                                        str4 = str3;
                                    }
                                    isPl = true;
                                    Pair[] pairArr6 = new Pair[5];
                                    pairArr6[0] = TuplesKt.to("title", providerTitle2);
                                    logo = ch.getLogo();
                                    if (logo == null) {
                                        logo = "";
                                    }
                                    pairArr6[1] = TuplesKt.to("image", logo);
                                    pairArr6[2] = TuplesKt.to("catLink", rawLinks);
                                    if (isPl) {
                                        str5 = "m3u";
                                    } else {
                                        str5 = str;
                                    }
                                    pairArr6[c] = TuplesKt.to("type", str5);
                                    pairArr6[4] = TuplesKt.to("server", serverName);
                                    categoryEntries.add(MapsKt.mapOf(pairArr6));
                                    containsPlaylists = containsPlaylists3;
                                    it3 = it6;
                                    str3 = str4;
                                    break;
                                }
                            }
                        } catch (Exception e10) {
                            e = e10;
                            cat2 = cat;
                        }
                        break;
                    } else {
                        cat2 = cat;
                    }
                    if (!hasExpandedPlaylists) {
                        Pair[] pairArr7 = new Pair[5];
                        pairArr7[0] = TuplesKt.to("title", serverName);
                        logo2 = cat2.getLogo();
                        if (logo2 != null) {
                            str6 = logo2;
                        }
                        pairArr7[1] = TuplesKt.to("image", str6);
                        pairArr7[2] = TuplesKt.to("catLink", api);
                        pairArr7[c] = TuplesKt.to("type", catType2);
                        pairArr7[4] = TuplesKt.to("server", serverName);
                        categoryEntries.add(MapsKt.mapOf(pairArr7));
                    }
                    return categoryEntries;
                case 1:
                    List categoryEntries2 = (List) this.L$4;
                    catType2 = (String) this.L$3;
                    c = 3;
                    api = (String) this.L$2;
                    serverName = (String) this.L$1;
                    cat = (PlayZTVCategoryData) this.L$0;
                    ResultKt.throwOnFailure($result);
                    categoryEntries = categoryEntries2;
                    str = "custom";
                    objFetchDecrypted = $result;
                    channelContent = (String) objFetchDecrypted;
                    hasExpandedPlaylists = false;
                    str2 = channelContent;
                    if (str2 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        AppUtils appUtils5 = AppUtils.INSTANCE;
                        Result.Companion companion15 = Result.Companion;
                        KType kTypeTypeOf5 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PlayZTVChannelWrapper.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                        if (Result.exceptionOrNull-impl(obj2) != null) {
                            Result.Companion companion16 = Result.Companion;
                            cat2 = cat;
                            obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        } else {
                            cat2 = cat;
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = null;
                        }
                        deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            value$iv = channelContent;
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            channelWrappers = (List) objDecodeFromString2;
                            destination$iv$iv = channelWrappers;
                            $i$f$mapNotNull = 0;
                            destination$iv$iv2 = new ArrayList();
                            while (r30.hasNext()) {
                                PlayZTVChannelWrapper cw3 = (PlayZTVChannelWrapper) element$iv$iv$iv;
                                AppUtils appUtils6 = AppUtils.INSTANCE;
                                value$iv2 = cw3.getChannel();
                                Result.Companion companion17 = Result.Companion;
                                KType kTypeTypeOf6 = Reflection.typeOf(PlayZTVChannelData.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                                if (Result.exceptionOrNull-impl(obj3) != null) {
                                    Result.Companion companion18 = Result.Companion;
                                    channelWrappers2 = channelWrappers;
                                    $this$mapNotNull$iv = destination$iv$iv;
                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                    $this$mapNotNull$iv2 = null;
                                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayZTVChannelData.class), (List) null, 2, (Object) null));
                                } else {
                                    channelWrappers2 = channelWrappers;
                                    $this$mapNotNull$iv = destination$iv$iv;
                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                    $this$mapNotNull$iv2 = null;
                                }
                                if (Result.isFailure-impl(obj3)) {
                                    obj3 = $this$mapNotNull$iv2;
                                }
                                deserializationStrategy2 = (KSerializer) obj3;
                                if (deserializationStrategy2 != null) {
                                    value$iv3 = value$iv2;
                                    objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
                                    playZTVChannelData = (PlayZTVChannelData) objDecodeFromString3;
                                    if (playZTVChannelData != null) {
                                        destination$iv$iv4 = destination$iv$iv2;
                                        destination$iv$iv4.add(playZTVChannelData);
                                    } else {
                                        destination$iv$iv4 = destination$iv$iv2;
                                    }
                                    destination$iv$iv2 = destination$iv$iv4;
                                    $i$f$mapNotNull = $i$f$mapNotNull2;
                                    destination$iv$iv = $this$mapNotNull$iv;
                                    channelWrappers = channelWrappers2;
                                } else {
                                    value$iv3 = value$iv2;
                                }
                                ObjectMapper $this$readValue$iv$iv11 = MainAPIKt.getMapper();
                                String content$iv$iv8 = value$iv3;
                                objDecodeFromString3 = $this$readValue$iv$iv11.readValue(content$iv$iv8, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$lambda$0$$inlined$parseJson$1
                                });
                                playZTVChannelData = (PlayZTVChannelData) objDecodeFromString3;
                                if (playZTVChannelData != null) {
                                    destination$iv$iv4 = destination$iv$iv2;
                                    destination$iv$iv4.add(playZTVChannelData);
                                } else {
                                    destination$iv$iv4 = destination$iv$iv2;
                                }
                                destination$iv$iv2 = destination$iv$iv4;
                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                destination$iv$iv = $this$mapNotNull$iv;
                                channelWrappers = channelWrappers2;
                                break;
                            }
                            Iterable $this$mapNotNull$iv5 = destination$iv$iv2;
                            $this$filter$iv = (List) $this$mapNotNull$iv5;
                            $i$f$filter = 0;
                            destination$iv$iv3 = new ArrayList();
                            while (r21.hasNext()) {
                                it4 = (PlayZTVChannelData) element$iv$iv;
                                Iterable $this$filter$iv4 = $this$filter$iv;
                                int $i$f$filter4 = $i$f$filter;
                                if (Intrinsics.areEqual(it4.getVisible(), Boxing.boxBoolean(false))) {
                                    z5 = false;
                                } else {
                                    links4 = it4.getLinks();
                                    if (links4 != null) {
                                        z6 = true;
                                    } else {
                                        z6 = true;
                                    }
                                    if (z6) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                }
                                if (z5) {
                                    destination$iv$iv3.add(element$iv$iv);
                                }
                                $this$filter$iv = $this$filter$iv4;
                                $i$f$filter = $i$f$filter4;
                            }
                            validChannels = (List) destination$iv$iv3;
                            $this$any$iv = validChannels;
                            $i$f$any = 0;
                            str3 = ".m3u8";
                            if ($this$any$iv instanceof Collection) {
                                it = $this$any$iv.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Object element$iv4 = it.next();
                                        it2 = (PlayZTVChannelData) element$iv4;
                                        validChannels2 = validChannels;
                                        $this$any$iv2 = $this$any$iv;
                                        if (Intrinsics.areEqual(it2.is_playlist(), Boxing.boxBoolean(true))) {
                                            links = it2.getLinks();
                                            if (links != null) {
                                                $i$f$any2 = $i$f$any;
                                                if (StringsKt.contains(links, ".m3u", true)) {
                                                }
                                                if (z3) {
                                                    links2 = it2.getLinks();
                                                    if (links2 == null) {
                                                        z4 = false;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    if (z4) {
                                                        z2 = false;
                                                    }
                                                }
                                                if (z2) {
                                                    containsPlaylists = true;
                                                } else {
                                                    validChannels = validChannels2;
                                                    $this$any$iv = $this$any$iv2;
                                                    $i$f$any = $i$f$any2;
                                                }
                                            } else {
                                                $i$f$any2 = $i$f$any;
                                            }
                                            if (z3) {
                                                links2 = it2.getLinks();
                                                if (links2 == null) {
                                                    z4 = false;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (z4) {
                                                    z2 = false;
                                                }
                                            }
                                            if (z2) {
                                                containsPlaylists = true;
                                            } else {
                                                validChannels = validChannels2;
                                                $this$any$iv = $this$any$iv2;
                                                $i$f$any = $i$f$any2;
                                            }
                                        } else {
                                            $i$f$any2 = $i$f$any;
                                        }
                                        z2 = true;
                                        if (z2) {
                                            containsPlaylists = true;
                                        } else {
                                            validChannels = validChannels2;
                                            $this$any$iv = $this$any$iv2;
                                            $i$f$any = $i$f$any2;
                                        }
                                    } else {
                                        validChannels2 = validChannels;
                                        containsPlaylists = false;
                                    }
                                }
                            } else {
                                it = $this$any$iv.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Object element$iv5 = it.next();
                                        it2 = (PlayZTVChannelData) element$iv5;
                                        validChannels2 = validChannels;
                                        $this$any$iv2 = $this$any$iv;
                                        if (Intrinsics.areEqual(it2.is_playlist(), Boxing.boxBoolean(true))) {
                                            links = it2.getLinks();
                                            if (links != null) {
                                                $i$f$any2 = $i$f$any;
                                                if (StringsKt.contains(links, ".m3u", true)) {
                                                }
                                                if (z3) {
                                                    links2 = it2.getLinks();
                                                    if (links2 == null) {
                                                        z4 = false;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    if (z4) {
                                                        z2 = false;
                                                    }
                                                }
                                                if (z2) {
                                                    containsPlaylists = true;
                                                } else {
                                                    validChannels = validChannels2;
                                                    $this$any$iv = $this$any$iv2;
                                                    $i$f$any = $i$f$any2;
                                                }
                                            } else {
                                                $i$f$any2 = $i$f$any;
                                            }
                                            if (z3) {
                                                links2 = it2.getLinks();
                                                if (links2 == null) {
                                                    z4 = false;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (z4) {
                                                    z2 = false;
                                                }
                                            }
                                            if (z2) {
                                                containsPlaylists = true;
                                            } else {
                                                validChannels = validChannels2;
                                                $this$any$iv = $this$any$iv2;
                                                $i$f$any = $i$f$any2;
                                            }
                                        } else {
                                            $i$f$any2 = $i$f$any;
                                        }
                                        z2 = true;
                                        if (z2) {
                                            containsPlaylists = true;
                                        } else {
                                            validChannels = validChannels2;
                                            $this$any$iv = $this$any$iv2;
                                            $i$f$any = $i$f$any2;
                                        }
                                    } else {
                                        validChannels2 = validChannels;
                                        containsPlaylists = false;
                                    }
                                }
                            }
                            if (containsPlaylists) {
                                hasExpandedPlaylists = true;
                                it3 = validChannels2.iterator();
                                while (it3.hasNext()) {
                                    ch = (PlayZTVChannelData) it3.next();
                                    name = ch.getName();
                                    if (name != null) {
                                        chName = "Channel";
                                    } else {
                                        chName = "Channel";
                                    }
                                    boolean containsPlaylists4 = containsPlaylists;
                                    Iterator it7 = it3;
                                    String providerTitle3 = chName + " (" + serverName + ')';
                                    links3 = ch.getLinks();
                                    if (links3 != null) {
                                        rawLinks = StringsKt.trim(links3).toString();
                                    } else {
                                        rawLinks = null;
                                    }
                                    if (rawLinks == null) {
                                        rawLinks = "";
                                    }
                                    if (Intrinsics.areEqual(ch.is_playlist(), Boxing.boxBoolean(true))) {
                                        str4 = str3;
                                        if (StringsKt.contains(rawLinks, ".m3u", true)) {
                                        }
                                        Pair[] pairArr8 = new Pair[5];
                                        pairArr8[0] = TuplesKt.to("title", providerTitle3);
                                        logo = ch.getLogo();
                                        if (logo == null) {
                                            logo = "";
                                        }
                                        pairArr8[1] = TuplesKt.to("image", logo);
                                        pairArr8[2] = TuplesKt.to("catLink", rawLinks);
                                        if (isPl) {
                                            str5 = "m3u";
                                        } else {
                                            str5 = str;
                                        }
                                        pairArr8[c] = TuplesKt.to("type", str5);
                                        pairArr8[4] = TuplesKt.to("server", serverName);
                                        categoryEntries.add(MapsKt.mapOf(pairArr8));
                                        containsPlaylists = containsPlaylists4;
                                        it3 = it7;
                                        str3 = str4;
                                    } else {
                                        str4 = str3;
                                    }
                                    isPl = true;
                                    Pair[] pairArr9 = new Pair[5];
                                    pairArr9[0] = TuplesKt.to("title", providerTitle3);
                                    logo = ch.getLogo();
                                    if (logo == null) {
                                        logo = "";
                                    }
                                    pairArr9[1] = TuplesKt.to("image", logo);
                                    pairArr9[2] = TuplesKt.to("catLink", rawLinks);
                                    if (isPl) {
                                        str5 = "m3u";
                                    } else {
                                        str5 = str;
                                    }
                                    pairArr9[c] = TuplesKt.to("type", str5);
                                    pairArr9[4] = TuplesKt.to("server", serverName);
                                    categoryEntries.add(MapsKt.mapOf(pairArr9));
                                    containsPlaylists = containsPlaylists4;
                                    it3 = it7;
                                    str3 = str4;
                                    break;
                                }
                            }
                        } else {
                            value$iv = channelContent;
                        }
                        ObjectMapper $this$readValue$iv$iv12 = MainAPIKt.getMapper();
                        String content$iv$iv9 = value$iv;
                        objDecodeFromString2 = $this$readValue$iv$iv12.readValue(content$iv$iv9, new TypeReference<List<? extends PlayZTVChannelWrapper>>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$$inlined$parseJson$2
                        });
                        channelWrappers = (List) objDecodeFromString2;
                        destination$iv$iv = channelWrappers;
                        $i$f$mapNotNull = 0;
                        destination$iv$iv2 = new ArrayList();
                        while (r30.hasNext()) {
                            PlayZTVChannelWrapper cw4 = (PlayZTVChannelWrapper) element$iv$iv$iv;
                            AppUtils appUtils7 = AppUtils.INSTANCE;
                            value$iv2 = cw4.getChannel();
                            Result.Companion companion19 = Result.Companion;
                            KType kTypeTypeOf7 = Reflection.typeOf(PlayZTVChannelData.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                            if (Result.exceptionOrNull-impl(obj3) != null) {
                                Result.Companion companion110 = Result.Companion;
                                channelWrappers2 = channelWrappers;
                                $this$mapNotNull$iv = destination$iv$iv;
                                $i$f$mapNotNull2 = $i$f$mapNotNull;
                                $this$mapNotNull$iv2 = null;
                                obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayZTVChannelData.class), (List) null, 2, (Object) null));
                            } else {
                                channelWrappers2 = channelWrappers;
                                $this$mapNotNull$iv = destination$iv$iv;
                                $i$f$mapNotNull2 = $i$f$mapNotNull;
                                $this$mapNotNull$iv2 = null;
                            }
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = $this$mapNotNull$iv2;
                            }
                            deserializationStrategy2 = (KSerializer) obj3;
                            if (deserializationStrategy2 != null) {
                                value$iv3 = value$iv2;
                                objDecodeFromString3 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv3);
                                playZTVChannelData = (PlayZTVChannelData) objDecodeFromString3;
                                if (playZTVChannelData != null) {
                                    destination$iv$iv4 = destination$iv$iv2;
                                    destination$iv$iv4.add(playZTVChannelData);
                                } else {
                                    destination$iv$iv4 = destination$iv$iv2;
                                }
                                destination$iv$iv2 = destination$iv$iv4;
                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                destination$iv$iv = $this$mapNotNull$iv;
                                channelWrappers = channelWrappers2;
                            } else {
                                value$iv3 = value$iv2;
                            }
                            ObjectMapper $this$readValue$iv$iv13 = MainAPIKt.getMapper();
                            String content$iv$iv10 = value$iv3;
                            objDecodeFromString3 = $this$readValue$iv$iv13.readValue(content$iv$iv10, new TypeReference<PlayZTVChannelData>() { // from class: com.cncverse.PlayZTVProviderManager$fetchProviders$2$results$1$1$1$invokeSuspend$lambda$0$$inlined$parseJson$1
                            });
                            playZTVChannelData = (PlayZTVChannelData) objDecodeFromString3;
                            if (playZTVChannelData != null) {
                                destination$iv$iv4 = destination$iv$iv2;
                                destination$iv$iv4.add(playZTVChannelData);
                            } else {
                                destination$iv$iv4 = destination$iv$iv2;
                            }
                            destination$iv$iv2 = destination$iv$iv4;
                            $i$f$mapNotNull = $i$f$mapNotNull2;
                            destination$iv$iv = $this$mapNotNull$iv;
                            channelWrappers = channelWrappers2;
                            break;
                        }
                        Iterable $this$mapNotNull$iv6 = destination$iv$iv2;
                        $this$filter$iv = (List) $this$mapNotNull$iv6;
                        $i$f$filter = 0;
                        destination$iv$iv3 = new ArrayList();
                        while (r21.hasNext()) {
                            it4 = (PlayZTVChannelData) element$iv$iv;
                            Iterable $this$filter$iv5 = $this$filter$iv;
                            int $i$f$filter5 = $i$f$filter;
                            if (Intrinsics.areEqual(it4.getVisible(), Boxing.boxBoolean(false))) {
                                z5 = false;
                            } else {
                                links4 = it4.getLinks();
                                if (links4 != null) {
                                    z6 = true;
                                } else {
                                    z6 = true;
                                }
                                if (z6) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                            }
                            if (z5) {
                                destination$iv$iv3.add(element$iv$iv);
                            }
                            $this$filter$iv = $this$filter$iv5;
                            $i$f$filter = $i$f$filter5;
                        }
                        validChannels = (List) destination$iv$iv3;
                        $this$any$iv = validChannels;
                        $i$f$any = 0;
                        str3 = ".m3u8";
                        if ($this$any$iv instanceof Collection) {
                            it = $this$any$iv.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object element$iv6 = it.next();
                                    it2 = (PlayZTVChannelData) element$iv6;
                                    validChannels2 = validChannels;
                                    $this$any$iv2 = $this$any$iv;
                                    if (Intrinsics.areEqual(it2.is_playlist(), Boxing.boxBoolean(true))) {
                                        links = it2.getLinks();
                                        if (links != null) {
                                            $i$f$any2 = $i$f$any;
                                            if (StringsKt.contains(links, ".m3u", true)) {
                                            }
                                            if (z3) {
                                                links2 = it2.getLinks();
                                                if (links2 == null) {
                                                    z4 = false;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (z4) {
                                                    z2 = false;
                                                }
                                            }
                                            if (z2) {
                                                containsPlaylists = true;
                                            } else {
                                                validChannels = validChannels2;
                                                $this$any$iv = $this$any$iv2;
                                                $i$f$any = $i$f$any2;
                                            }
                                        } else {
                                            $i$f$any2 = $i$f$any;
                                        }
                                        if (z3) {
                                            links2 = it2.getLinks();
                                            if (links2 == null) {
                                                z4 = false;
                                            } else {
                                                z4 = false;
                                            }
                                            if (z4) {
                                                z2 = false;
                                            }
                                        }
                                        if (z2) {
                                            containsPlaylists = true;
                                        } else {
                                            validChannels = validChannels2;
                                            $this$any$iv = $this$any$iv2;
                                            $i$f$any = $i$f$any2;
                                        }
                                    } else {
                                        $i$f$any2 = $i$f$any;
                                    }
                                    z2 = true;
                                    if (z2) {
                                        containsPlaylists = true;
                                    } else {
                                        validChannels = validChannels2;
                                        $this$any$iv = $this$any$iv2;
                                        $i$f$any = $i$f$any2;
                                    }
                                } else {
                                    validChannels2 = validChannels;
                                    containsPlaylists = false;
                                }
                            }
                        } else {
                            it = $this$any$iv.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Object element$iv7 = it.next();
                                    it2 = (PlayZTVChannelData) element$iv7;
                                    validChannels2 = validChannels;
                                    $this$any$iv2 = $this$any$iv;
                                    if (Intrinsics.areEqual(it2.is_playlist(), Boxing.boxBoolean(true))) {
                                        links = it2.getLinks();
                                        if (links != null) {
                                            $i$f$any2 = $i$f$any;
                                            if (StringsKt.contains(links, ".m3u", true)) {
                                            }
                                            if (z3) {
                                                links2 = it2.getLinks();
                                                if (links2 == null) {
                                                    z4 = false;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (z4) {
                                                    z2 = false;
                                                }
                                            }
                                            if (z2) {
                                                containsPlaylists = true;
                                            } else {
                                                validChannels = validChannels2;
                                                $this$any$iv = $this$any$iv2;
                                                $i$f$any = $i$f$any2;
                                            }
                                        } else {
                                            $i$f$any2 = $i$f$any;
                                        }
                                        if (z3) {
                                            links2 = it2.getLinks();
                                            if (links2 == null) {
                                                z4 = false;
                                            } else {
                                                z4 = false;
                                            }
                                            if (z4) {
                                                z2 = false;
                                            }
                                        }
                                        if (z2) {
                                            containsPlaylists = true;
                                        } else {
                                            validChannels = validChannels2;
                                            $this$any$iv = $this$any$iv2;
                                            $i$f$any = $i$f$any2;
                                        }
                                    } else {
                                        $i$f$any2 = $i$f$any;
                                    }
                                    z2 = true;
                                    if (z2) {
                                        containsPlaylists = true;
                                    } else {
                                        validChannels = validChannels2;
                                        $this$any$iv = $this$any$iv2;
                                        $i$f$any = $i$f$any2;
                                    }
                                } else {
                                    validChannels2 = validChannels;
                                    containsPlaylists = false;
                                }
                            }
                        }
                        if (containsPlaylists) {
                            hasExpandedPlaylists = true;
                            it3 = validChannels2.iterator();
                            while (it3.hasNext()) {
                                ch = (PlayZTVChannelData) it3.next();
                                name = ch.getName();
                                if (name != null) {
                                    chName = "Channel";
                                } else {
                                    chName = "Channel";
                                }
                                boolean containsPlaylists5 = containsPlaylists;
                                Iterator it8 = it3;
                                String providerTitle4 = chName + " (" + serverName + ')';
                                links3 = ch.getLinks();
                                if (links3 != null) {
                                    rawLinks = StringsKt.trim(links3).toString();
                                } else {
                                    rawLinks = null;
                                }
                                if (rawLinks == null) {
                                    rawLinks = "";
                                }
                                if (Intrinsics.areEqual(ch.is_playlist(), Boxing.boxBoolean(true))) {
                                    str4 = str3;
                                    if (StringsKt.contains(rawLinks, ".m3u", true)) {
                                    }
                                    Pair[] pairArr10 = new Pair[5];
                                    pairArr10[0] = TuplesKt.to("title", providerTitle4);
                                    logo = ch.getLogo();
                                    if (logo == null) {
                                        logo = "";
                                    }
                                    pairArr10[1] = TuplesKt.to("image", logo);
                                    pairArr10[2] = TuplesKt.to("catLink", rawLinks);
                                    if (isPl) {
                                        str5 = "m3u";
                                    } else {
                                        str5 = str;
                                    }
                                    pairArr10[c] = TuplesKt.to("type", str5);
                                    pairArr10[4] = TuplesKt.to("server", serverName);
                                    categoryEntries.add(MapsKt.mapOf(pairArr10));
                                    containsPlaylists = containsPlaylists5;
                                    it3 = it8;
                                    str3 = str4;
                                } else {
                                    str4 = str3;
                                }
                                isPl = true;
                                Pair[] pairArr11 = new Pair[5];
                                pairArr11[0] = TuplesKt.to("title", providerTitle4);
                                logo = ch.getLogo();
                                if (logo == null) {
                                    logo = "";
                                }
                                pairArr11[1] = TuplesKt.to("image", logo);
                                pairArr11[2] = TuplesKt.to("catLink", rawLinks);
                                if (isPl) {
                                    str5 = "m3u";
                                } else {
                                    str5 = str;
                                }
                                pairArr11[c] = TuplesKt.to("type", str5);
                                pairArr11[4] = TuplesKt.to("server", serverName);
                                categoryEntries.add(MapsKt.mapOf(pairArr11));
                                containsPlaylists = containsPlaylists5;
                                it3 = it8;
                                str3 = str4;
                                break;
                            }
                        }
                        break;
                    } else {
                        cat2 = cat;
                    }
                    if (!hasExpandedPlaylists) {
                        Pair[] pairArr12 = new Pair[5];
                        pairArr12[0] = TuplesKt.to("title", serverName);
                        logo2 = cat2.getLogo();
                        if (logo2 != null) {
                            str6 = logo2;
                        }
                        pairArr12[1] = TuplesKt.to("image", str6);
                        pairArr12[2] = TuplesKt.to("catLink", api);
                        pairArr12[c] = TuplesKt.to("type", catType2);
                        pairArr12[4] = TuplesKt.to("server", serverName);
                        categoryEntries.add(MapsKt.mapOf(pairArr12));
                    }
                    return categoryEntries;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e11) {
            System.out.println((Object) ("PlayZTV: Failed parsing category – " + e11.getMessage()));
            return CollectionsKt.emptyList();
        }
    }
}
