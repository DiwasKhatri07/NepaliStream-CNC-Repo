package com.Fibwatch;

import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;
import okhttp3.Interceptor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Fibwatch.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Fibwatch/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/Episode;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.Fibwatch.Fibwatch$load$2$episodes$1$1$1", f = "Fibwatch.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {364, 215, 223}, m = "invokeSuspend", n = {"$this$async", "$this$withPermit$iv", "$this$async", "$this$withPermit$iv", "epTitle", "epUrl", "lower", "season", "episodeNum", "$this$invokeSuspend_u24lambda_u240_u242", "$this$async", "$this$withPermit$iv", "epTitle", "epUrl", "lower", "season", "episodeNum", "allqualities", "innerVideoId", "$this$invokeSuspend_u24lambda_u240_u244", "shouldRequestResSwitcher"}, nl = {365, 215, 368}, s = {"L$0", "L$1", "L$0", "L$1", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0"}, v = 2)
@SourceDebugExtension({"SMAP\nFibwatch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2$episodes$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,363:1\n81#2,3:364\n85#2,2:407\n1#3:367\n1#3:384\n1#3:398\n73#4,5:368\n1795#5,10:373\n2068#5:383\n2069#5:385\n1805#5:386\n1795#5,10:387\n2068#5:397\n2069#5:399\n1805#5:400\n777#5:401\n873#5:402\n2945#5,3:403\n874#5:406\n*S KotlinDebug\n*F\n+ 1 Fibwatch.kt\ncom/Fibwatch/Fibwatch$load$2$episodes$1$1$1\n*L\n196#1:364,3\n196#1:407,2\n228#1:384\n232#1:398\n223#1:368,5\n228#1:373,10\n228#1:383\n228#1:385\n228#1:386\n232#1:387,10\n232#1:397\n232#1:399\n232#1:400\n236#1:401\n236#1:402\n236#1:403,3\n236#1:406\n*E\n"})
final class Fibwatch$load$2$episodes$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Episode>, Object> {
    final /* synthetic */ Function1<List<LoadItem>, List<LoadItem>> $dedupeByUrl;
    final /* synthetic */ EpisodeItem $ep;
    final /* synthetic */ String $poster;
    final /* synthetic */ Semaphore $semaphore;
    final /* synthetic */ Function3<String, String, Boolean, LoadItem> $toLoadItem;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ Fibwatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Fibwatch$load$2$episodes$1$1$1(Semaphore semaphore, EpisodeItem episodeItem, Function1<? super List<LoadItem>, ? extends List<LoadItem>> function1, Function3<? super String, ? super String, ? super Boolean, LoadItem> function3, Fibwatch fibwatch, String str, Continuation<? super Fibwatch$load$2$episodes$1$1$1> continuation) {
        super(2, continuation);
        this.$semaphore = semaphore;
        this.$ep = episodeItem;
        this.$dedupeByUrl = function1;
        this.$toLoadItem = function3;
        this.this$0 = fibwatch;
        this.$poster = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fibwatch$load$2$episodes$1$1$1 = new Fibwatch$load$2$episodes$1$1$1(this.$semaphore, this.$ep, this.$dedupeByUrl, this.$toLoadItem, this.this$0, this.$poster, continuation);
        fibwatch$load$2$episodes$1$1$1.L$0 = obj;
        return fibwatch$load$2$episodes$1$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Episode> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:105:0x03db  */
    /* JADX WARN: Code duplicated, block: B:106:0x03e0 A[Catch: all -> 0x0955, TryCatch #20 {all -> 0x0955, blocks: (B:100:0x03d0, B:103:0x03d7, B:106:0x03e0, B:110:0x03f1), top: B:376:0x03d0 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:109:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:114:0x0402 A[Catch: all -> 0x040e, TRY_LEAVE, TryCatch #19 {all -> 0x040e, blocks: (B:112:0x03fa, B:114:0x0402), top: B:374:0x03fa }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0415  */
    /* JADX WARN: Code duplicated, block: B:123:0x041f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:167:0x0612  */
    /* JADX WARN: Code duplicated, block: B:170:0x061a A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:191:0x0686  */
    /* JADX WARN: Code duplicated, block: B:192:0x0687  */
    /* JADX WARN: Code duplicated, block: B:194:0x068b A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:195:0x06a4  */
    /* JADX WARN: Code duplicated, block: B:197:0x06a9 A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:198:0x06b0  */
    /* JADX WARN: Code duplicated, block: B:202:0x06d0 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:206:0x06dd A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:227:0x0746  */
    /* JADX WARN: Code duplicated, block: B:228:0x0747  */
    /* JADX WARN: Code duplicated, block: B:230:0x074b A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:231:0x0765  */
    /* JADX WARN: Code duplicated, block: B:233:0x076a A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0785 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:242:0x07ad A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:244:0x07cb A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:247:0x07d6 A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:250:0x07e0 A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:253:0x07fe A[LOOP:3: B:248:0x07da->B:253:0x07fe, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:257:0x0809 A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:258:0x0813  */
    /* JADX WARN: Code duplicated, block: B:262:0x082f A[Catch: all -> 0x094b, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:264:0x0835  */
    /* JADX WARN: Code duplicated, block: B:267:0x0844 A[Catch: all -> 0x094b, TRY_LEAVE, TryCatch #16 {all -> 0x094b, blocks: (B:165:0x060c, B:168:0x0613, B:170:0x061a, B:172:0x0620, B:173:0x0639, B:175:0x063f, B:177:0x0653, B:181:0x0666, B:194:0x068b, B:197:0x06a9, B:200:0x06bc, B:206:0x06dd, B:208:0x06e3, B:209:0x06fa, B:211:0x0700, B:213:0x0714, B:217:0x0727, B:230:0x074b, B:233:0x076a, B:235:0x0775, B:239:0x078b, B:240:0x07a7, B:242:0x07ad, B:244:0x07cb, B:257:0x0809, B:247:0x07d6, B:248:0x07da, B:250:0x07e0, B:260:0x081c, B:262:0x082f, B:265:0x0837, B:267:0x0844, B:321:0x0938, B:238:0x0787, B:203:0x06d4), top: B:368:0x060c }] */
    /* JADX WARN: Code duplicated, block: B:28:0x012f  */
    /* JADX WARN: Code duplicated, block: B:309:0x08ef  */
    /* JADX WARN: Code duplicated, block: B:311:0x08f3 A[Catch: all -> 0x0920, TRY_LEAVE, TryCatch #0 {all -> 0x0920, blocks: (B:273:0x0868, B:275:0x086e, B:277:0x0874, B:281:0x087f, B:283:0x088e, B:285:0x0897, B:287:0x08a0, B:289:0x08a9, B:291:0x08b2, B:293:0x08ba, B:295:0x08c8, B:303:0x08df, B:305:0x08e5, B:311:0x08f3), top: B:337:0x0868 }] */
    /* JADX WARN: Code duplicated, block: B:319:0x0930  */
    /* JADX WARN: Code duplicated, block: B:31:0x0134  */
    /* JADX WARN: Code duplicated, block: B:351:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x013f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0141  */
    /* JADX WARN: Code duplicated, block: B:374:0x03fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0144  */
    /* JADX WARN: Code duplicated, block: B:395:0x076e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:399:0x0803 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0149 A[Catch: all -> 0x0965, TRY_LEAVE, TryCatch #3 {all -> 0x0965, blocks: (B:22:0x0119, B:33:0x0136, B:39:0x0149, B:48:0x0160, B:54:0x01c0, B:58:0x01ec), top: B:343:0x0119 }] */
    /* JADX WARN: Code duplicated, block: B:400:0x07fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x014f A[Catch: all -> 0x012a, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x012a, blocks: (B:24:0x011f, B:41:0x014f, B:51:0x0194, B:57:0x01d9, B:61:0x0201), top: B:351:0x011f }] */
    /* JADX WARN: Code duplicated, block: B:43:0x015a  */
    /* JADX WARN: Code duplicated, block: B:46:0x015e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0193  */
    /* JADX WARN: Code duplicated, block: B:53:0x01be  */
    /* JADX WARN: Code duplicated, block: B:56:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:60:0x0200  */
    /* JADX WARN: Code duplicated, block: B:63:0x0215  */
    /* JADX WARN: Code duplicated, block: B:78:0x029f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x02a0  */
    public final Object invokeSuspend(Object $result) {
        EpisodeItem episodeItem;
        Function1<List<LoadItem>, List<LoadItem>> function1;
        String str;
        Function3<String, String, Boolean, LoadItem> function3;
        Fibwatch fibwatch;
        int $i$f$withPermit;
        Semaphore $this$withPermit$iv;
        String url;
        String string;
        String epUrl;
        boolean z;
        String title;
        String string2;
        String epTitle;
        String lower;
        Ref.ObjectRef season;
        Ref.ObjectRef episodeNum;
        String str2;
        MatchResult m;
        Fibwatch fibwatch2;
        MatchResult m2;
        MatchResult m3;
        String str3;
        Fibwatch fibwatch3;
        Fibwatch$load$2$episodes$1$1$1 fibwatch$load$2$episodes$1$1$1;
        Object obj;
        int $i$f$withPermit2;
        int i;
        String lower2;
        String epUrl2;
        Function3<String, String, Boolean, LoadItem> function4;
        Function1<List<LoadItem>, List<LoadItem>> function2;
        String str4;
        Semaphore $this$withPermit$iv2;
        Ref.ObjectRef season2;
        String epUrl3;
        Ref.ObjectRef episodeNum2;
        Fibwatch fibwatch4;
        Fibwatch fibwatch5;
        Function3<String, String, Boolean, LoadItem> function5;
        Function1<List<LoadItem>, List<LoadItem>> function6;
        Semaphore $this$withPermit$iv3;
        Object obj2;
        Episode episodeNewEpisode;
        Object obj3;
        int $i$f$withPermit3;
        int i2;
        Ref.ObjectRef episodeNum3;
        Ref.ObjectRef season3;
        String epTitle2;
        String str5;
        Fibwatch fibwatch6;
        Function3<String, String, Boolean, LoadItem> function7;
        Function1<List<LoadItem>, List<LoadItem>> function8;
        Object obj4;
        String epUrl4;
        Document allqualities;
        int i3;
        int i4;
        Element elementSelectFirst;
        String it;
        String innerVideoId;
        int $i$f$withPermit4;
        int i5;
        String epUrl5;
        final String epTitle3;
        Document allqualities2;
        String innerVideoId2;
        Semaphore $this$withPermit$iv4;
        int i6;
        final Ref.ObjectRef season4;
        Function1<List<LoadItem>, List<LoadItem>> function9;
        Fibwatch fibwatch7;
        final Ref.ObjectRef episodeNum4;
        Function3<String, String, Boolean, LoadItem> function10;
        String str6;
        String str7;
        Links links;
        Object obj5;
        final String str8;
        String innerVideoId3;
        Function1<List<LoadItem>, List<LoadItem>> function11;
        Object obj6;
        Function3<String, String, Boolean, LoadItem> function12;
        Links epLinks;
        List epCurrentRaw;
        Object element$iv$iv;
        List epCurrentList;
        Collection destination$iv$iv;
        LoadlinksOut epOut;
        String status;
        LoadlinksOut epOut2;
        LoadlinksOut epOut3;
        String it2;
        String str9;
        boolean z2;
        String strAttr;
        String strSubstringAfter$default;
        String strSubstringBefore$default;
        String strSubstringBefore$default2;
        String strSubstringBefore$default3;
        List groupValues;
        LoadItem item;
        Iterable $this$none$iv;
        Iterator it3;
        boolean z3;
        Object element$iv;
        Iterable $this$none$iv2;
        Iterator it4;
        Iterable popup;
        int $i$f$mapNotNull;
        boolean z4;
        LoadItem loadItem;
        Iterable current;
        Iterable $this$mapNotNull$iv;
        boolean z5;
        LoadItem loadItem2;
        Collection destination$iv$iv2;
        Object safe;
        CoroutineScope $this$async = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str10 = "yes";
        String innerVideoId4 = "pop_up_18";
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore $this$withPermit$iv5 = this.$semaphore;
                episodeItem = this.$ep;
                Function1<List<LoadItem>, List<LoadItem>> function13 = this.$dedupeByUrl;
                Function3<String, String, Boolean, LoadItem> function14 = this.$toLoadItem;
                Fibwatch fibwatch8 = this.this$0;
                String str11 = this.$poster;
                this.L$0 = $this$async;
                this.L$1 = $this$withPermit$iv5;
                this.L$2 = episodeItem;
                this.L$3 = function13;
                this.L$4 = function14;
                this.L$5 = fibwatch8;
                this.L$6 = str11;
                this.label = 1;
                if ($this$withPermit$iv5.acquire((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function1 = function13;
                str = str11;
                function3 = function14;
                fibwatch = fibwatch8;
                $i$f$withPermit = 0;
                $this$withPermit$iv = $this$withPermit$iv5;
                try {
                    url = episodeItem.getUrl();
                    if (url != null) {
                        try {
                            string = StringsKt.trim(url).toString();
                        } catch (Throwable th) {
                            episodeNewEpisode = null;
                            $this$withPermit$iv.release();
                            return episodeNewEpisode;
                        }
                    } else {
                        string = null;
                    }
                    if (string == null) {
                        string = "";
                    }
                    epUrl = string;
                    if (epUrl.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        episodeNewEpisode = null;
                    } else {
                        title = episodeItem.getTitle();
                        if (title != null) {
                            string2 = StringsKt.trim(title).toString();
                        } else {
                            string2 = null;
                        }
                        epTitle = string2 != null ? string2 : "";
                        lower = epTitle.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
                        season = new Ref.ObjectRef();
                        episodeNum = new Ref.ObjectRef();
                        str2 = str;
                        m = Regex.find$default(new Regex("s(\\d{1,2})e(\\d{1,3})(?:-(\\d{1,3}))?"), lower, 0, 2, (Object) null);
                        if (m != null) {
                            season.element = StringsKt.toIntOrNull((String) m.getGroupValues().get(1));
                            episodeNum.element = StringsKt.toIntOrNull((String) m.getGroupValues().get(2));
                            Unit unit = Unit.INSTANCE;
                            fibwatch2 = fibwatch;
                        } else {
                            fibwatch2 = fibwatch;
                            m2 = Regex.find$default(new Regex("\\bs(\\d{1,2})\\b"), lower, 0, 2, (Object) null);
                            if (m2 != null) {
                                season.element = StringsKt.toIntOrNull((String) m2.getGroupValues().get(1));
                                Unit unit2 = Unit.INSTANCE;
                            }
                            m3 = Regex.find$default(new Regex("\\be(\\d{1,3})\\b"), lower, 0, 2, (Object) null);
                            if (m3 != null) {
                                episodeNum.element = StringsKt.toIntOrNull((String) m3.getGroupValues().get(1));
                                Unit unit3 = Unit.INSTANCE;
                            }
                        }
                        try {
                            Result.Companion companion = Result.Companion;
                            Requests app = MainActivityKt.getApp();
                            String strFixUrl = MainAPIKt.fixUrl(fibwatch2, epUrl);
                            Map mapMapOf = MapsKt.mapOf(TuplesKt.to("pop_up_18", "yes"));
                            this.L$0 = $this$async;
                            this.L$1 = $this$withPermit$iv;
                            this.L$2 = function1;
                            this.L$3 = function3;
                            fibwatch5 = fibwatch2;
                            try {
                                this.L$4 = fibwatch5;
                                try {
                                    this.L$5 = str2;
                                    $this$async = $this$async;
                                    try {
                                        this.L$6 = epTitle;
                                        this.L$7 = SpillingKt.nullOutSpilledVariable(epUrl);
                                        this.L$8 = SpillingKt.nullOutSpilledVariable(lower);
                                        this.L$9 = season;
                                        this.L$10 = episodeNum;
                                        this.L$11 = SpillingKt.nullOutSpilledVariable($this$async);
                                        try {
                                            this.label = 2;
                                            function5 = function3;
                                            function6 = function1;
                                            $this$withPermit$iv3 = $this$withPermit$iv;
                                            str10 = "yes";
                                            innerVideoId4 = "pop_up_18";
                                            obj = coroutine_suspended;
                                            try {
                                                obj2 = Requests.get$default(app, strFixUrl, (Map) null, (String) null, (Map) null, mapMapOf, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4078, (Object) null);
                                                fibwatch$load$2$episodes$1$1$1 = this;
                                                if (obj2 == obj) {
                                                    return obj;
                                                }
                                                $i$f$withPermit2 = $i$f$withPermit;
                                                i = 0;
                                                lower2 = lower;
                                                epUrl2 = epTitle;
                                                function4 = function5;
                                                function2 = function6;
                                                str4 = str2;
                                                $this$withPermit$iv2 = $this$withPermit$iv3;
                                                season2 = season;
                                                epUrl3 = epUrl;
                                                episodeNum2 = episodeNum;
                                                fibwatch4 = fibwatch5;
                                                try {
                                                    obj3 = Result.constructor-impl(((NiceResponse) obj2).getDocument());
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    try {
                                                        Result.Companion companion2 = Result.Companion;
                                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    } catch (Throwable th3) {
                                                        $this$withPermit$iv = $this$withPermit$iv2;
                                                        episodeNewEpisode = null;
                                                        $this$withPermit$iv.release();
                                                        return episodeNewEpisode;
                                                    }
                                                }
                                                $i$f$withPermit3 = $i$f$withPermit2;
                                                i2 = i;
                                                episodeNum3 = episodeNum2;
                                                season3 = season2;
                                                epTitle2 = epUrl2;
                                                str5 = str4;
                                                fibwatch6 = fibwatch4;
                                                function7 = function4;
                                                function8 = function2;
                                                obj4 = obj3;
                                                String lower3 = lower2;
                                                epUrl4 = epUrl3;
                                                $this$withPermit$iv = $this$withPermit$iv2;
                                                try {
                                                    if (Result.isFailure-impl(obj4)) {
                                                        obj4 = null;
                                                    }
                                                    allqualities = (Document) obj4;
                                                    if (allqualities == null) {
                                                        episodeNewEpisode = null;
                                                    } else {
                                                        if (allqualities.select("div.available-res:contains(Available in Other Parts:)").isEmpty()) {
                                                            i3 = 0;
                                                        } else {
                                                            i3 = 1;
                                                        }
                                                        i4 = i3;
                                                        elementSelectFirst = allqualities.selectFirst("input#video-id");
                                                        if (elementSelectFirst != null) {
                                                            try {
                                                                it = elementSelectFirst.attr("value");
                                                                if (it != null || StringsKt.isBlank(it)) {
                                                                    it = null;
                                                                }
                                                            } catch (Throwable th4) {
                                                                episodeNewEpisode = null;
                                                                $this$withPermit$iv.release();
                                                                return episodeNewEpisode;
                                                            }
                                                        } else {
                                                            it = null;
                                                        }
                                                        innerVideoId = it;
                                                        try {
                                                            Result.Companion companion3 = Result.Companion;
                                                            CoroutineScope $this$invokeSuspend_u24lambda_u240_u244 = $this$async;
                                                            try {
                                                                try {
                                                                    if (i4 != 0 || innerVideoId == null) {
                                                                        str7 = str5;
                                                                        $i$f$withPermit4 = $i$f$withPermit3;
                                                                        i5 = i2;
                                                                        epUrl5 = epUrl4;
                                                                        epTitle3 = epTitle2;
                                                                        allqualities2 = allqualities;
                                                                        innerVideoId2 = innerVideoId;
                                                                        $this$withPermit$iv4 = $this$withPermit$iv;
                                                                        i6 = i4;
                                                                        season4 = season3;
                                                                        function9 = function8;
                                                                        fibwatch7 = fibwatch6;
                                                                        episodeNum4 = episodeNum3;
                                                                        function10 = function7;
                                                                        links = null;
                                                                        try {
                                                                            str8 = str7;
                                                                            obj6 = Result.constructor-impl(links);
                                                                            innerVideoId3 = innerVideoId2;
                                                                            function12 = function10;
                                                                            function11 = function9;
                                                                            $this$withPermit$iv = $this$withPermit$iv4;
                                                                        } catch (Throwable th5) {
                                                                            th = th5;
                                                                            str6 = str7;
                                                                            Result.Companion companion4 = Result.Companion;
                                                                            str8 = str6;
                                                                            innerVideoId3 = innerVideoId2;
                                                                            function11 = function9;
                                                                            $this$withPermit$iv = $this$withPermit$iv4;
                                                                            obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                            function12 = function10;
                                                                        }
                                                                        if (Result.isFailure-impl(obj6)) {
                                                                            obj6 = null;
                                                                        }
                                                                        epLinks = (Links) obj6;
                                                                        if (epLinks != null || (current = epLinks.getCurrent()) == null) {
                                                                            epCurrentRaw = CollectionsKt.emptyList();
                                                                        } else {
                                                                            Iterable $this$mapNotNull$iv2 = current;
                                                                            Collection destination$iv$iv3 = new ArrayList();
                                                                            Collection destination$iv$iv4 = destination$iv$iv3;
                                                                            for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
                                                                                Current c = (Current) element$iv$iv$iv;
                                                                                String url2 = c.getUrl();
                                                                                String it5 = url2 != null ? StringsKt.trim(url2).toString() : null;
                                                                                String it6 = it5;
                                                                                if (it6 != null) {
                                                                                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                                                                    z5 = it6.length() > 0;
                                                                                    if (z5) {
                                                                                        it5 = null;
                                                                                    }
                                                                                    if (it5 != null) {
                                                                                        loadItem2 = (LoadItem) function12.invoke(c.getRes(), it5, Boxing.boxBoolean(c.getSelected()));
                                                                                    } else {
                                                                                        loadItem2 = null;
                                                                                    }
                                                                                    if (loadItem2 != null) {
                                                                                        destination$iv$iv2 = destination$iv$iv4;
                                                                                        destination$iv$iv2.add(loadItem2);
                                                                                    } else {
                                                                                        destination$iv$iv2 = destination$iv$iv4;
                                                                                    }
                                                                                    destination$iv$iv4 = destination$iv$iv2;
                                                                                    i6 = i6;
                                                                                    innerVideoId3 = innerVideoId3;
                                                                                    $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                                                                } else {
                                                                                    innerVideoId3 = innerVideoId3;
                                                                                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                                                                }
                                                                                if (z5) {
                                                                                    it5 = null;
                                                                                }
                                                                                if (it5 != null) {
                                                                                    loadItem2 = (LoadItem) function12.invoke(c.getRes(), it5, Boxing.boxBoolean(c.getSelected()));
                                                                                } else {
                                                                                    loadItem2 = null;
                                                                                }
                                                                                if (loadItem2 != null) {
                                                                                    destination$iv$iv2 = destination$iv$iv4;
                                                                                    destination$iv$iv2.add(loadItem2);
                                                                                } else {
                                                                                    destination$iv$iv2 = destination$iv$iv4;
                                                                                }
                                                                                destination$iv$iv4 = destination$iv$iv2;
                                                                                i6 = i6;
                                                                                innerVideoId3 = innerVideoId3;
                                                                                $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                                                            }
                                                                            epCurrentRaw = (List) destination$iv$iv4;
                                                                        }
                                                                        if (epLinks != null || (popup = epLinks.getPopup()) == null) {
                                                                            element$iv$iv = CollectionsKt.emptyList();
                                                                        } else {
                                                                            Iterable $this$mapNotNull$iv3 = popup;
                                                                            int $i$f$mapNotNull2 = 0;
                                                                            Collection destination$iv$iv5 = new ArrayList();
                                                                            for (Object element$iv$iv$iv2 : $this$mapNotNull$iv3) {
                                                                                Popup p = (Popup) element$iv$iv$iv2;
                                                                                String url3 = p.getUrl();
                                                                                String it7 = url3 != null ? StringsKt.trim(url3).toString() : null;
                                                                                String it8 = it7;
                                                                                if (it8 != null) {
                                                                                    $i$f$mapNotNull = $i$f$mapNotNull2;
                                                                                    z4 = it8.length() > 0;
                                                                                    if (z4) {
                                                                                        it7 = null;
                                                                                    }
                                                                                    if (it7 != null) {
                                                                                        loadItem = (LoadItem) function12.invoke(p.getRes(), it7, Boxing.boxBoolean(p.getSelected()));
                                                                                    } else {
                                                                                        loadItem = null;
                                                                                    }
                                                                                    if (loadItem != null) {
                                                                                        destination$iv$iv5.add(loadItem);
                                                                                    }
                                                                                    epUrl5 = epUrl5;
                                                                                    $this$mapNotNull$iv3 = $this$mapNotNull$iv3;
                                                                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                                                } else {
                                                                                    $this$mapNotNull$iv3 = $this$mapNotNull$iv3;
                                                                                    $i$f$mapNotNull = $i$f$mapNotNull2;
                                                                                }
                                                                                if (z4) {
                                                                                    it7 = null;
                                                                                }
                                                                                if (it7 != null) {
                                                                                    loadItem = (LoadItem) function12.invoke(p.getRes(), it7, Boxing.boxBoolean(p.getSelected()));
                                                                                } else {
                                                                                    loadItem = null;
                                                                                }
                                                                                if (loadItem != null) {
                                                                                    destination$iv$iv5.add(loadItem);
                                                                                }
                                                                                epUrl5 = epUrl5;
                                                                                $this$mapNotNull$iv3 = $this$mapNotNull$iv3;
                                                                                $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                                            }
                                                                            element$iv$iv = (List) destination$iv$iv5;
                                                                        }
                                                                        epCurrentList = (List) function11.invoke(epCurrentRaw);
                                                                        Iterable $this$filter$iv = (Iterable) element$iv$iv;
                                                                        destination$iv$iv = new ArrayList();
                                                                        for (Object element$iv$iv2 : $this$filter$iv) {
                                                                            item = (LoadItem) element$iv$iv2;
                                                                            List epCurrentRaw2 = epCurrentRaw;
                                                                            $this$none$iv = epCurrentList;
                                                                            Object $this$none$iv3 = element$iv$iv;
                                                                            if (($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
                                                                                it3 = $this$none$iv.iterator();
                                                                                while (true) {
                                                                                    if (it3.hasNext()) {
                                                                                        element$iv = it3.next();
                                                                                        $this$none$iv2 = $this$none$iv;
                                                                                        it4 = it3;
                                                                                        if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                                                                            z3 = false;
                                                                                        } else {
                                                                                            $this$none$iv = $this$none$iv2;
                                                                                            it3 = it4;
                                                                                        }
                                                                                    } else {
                                                                                        z3 = true;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                z3 = true;
                                                                            }
                                                                            if (z3) {
                                                                                Collection destination$iv$iv6 = destination$iv$iv;
                                                                                destination$iv$iv6.add(element$iv$iv2);
                                                                                destination$iv$iv = destination$iv$iv6;
                                                                            }
                                                                            element$iv$iv = $this$none$iv3;
                                                                            epCurrentRaw = epCurrentRaw2;
                                                                        }
                                                                        List epCurrentRaw3 = (List) destination$iv$iv;
                                                                        List epPopupList = (List) function11.invoke(epCurrentRaw3);
                                                                        if (epLinks != null || (status = epLinks.getStatus()) == null) {
                                                                            status = "error";
                                                                        }
                                                                        epOut = new LoadlinksOut(status, epCurrentList, epPopupList);
                                                                        if (epOut.getCurrent().isEmpty() || !epOut.getPopup().isEmpty()) {
                                                                            epOut2 = epOut;
                                                                        } else {
                                                                            try {
                                                                                String epText = allqualities2.html();
                                                                                try {
                                                                                    Regex epRegex = new Regex("var\\s+VIDEO_URL\\s*=\\s*[\"']([^\"']+)[\"']");
                                                                                    epOut2 = epOut;
                                                                                    try {
                                                                                        MatchResult matchResultFind$default = Regex.find$default(epRegex, epText, 0, 2, (Object) null);
                                                                                        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (it2 = (String) groupValues.get(1)) == null) {
                                                                                            Element elementSelectFirst2 = allqualities2.selectFirst("a#fwDownloadBtn, a.hidden-button.buttonDownloadnew, a[href*=url=]");
                                                                                            if (elementSelectFirst2 == null || (strAttr = elementSelectFirst2.attr("href")) == null || (strSubstringAfter$default = StringsKt.substringAfter$default(strAttr, "url=", (String) null, 2, (Object) null)) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(strSubstringAfter$default, "',", (String) null, 2, (Object) null)) == null || (strSubstringBefore$default2 = StringsKt.substringBefore$default(strSubstringBefore$default, "\"", (String) null, 2, (Object) null)) == null || (strSubstringBefore$default3 = StringsKt.substringBefore$default(strSubstringBefore$default2, "&", (String) null, 2, (Object) null)) == null || (it2 = StringsKt.trim(strSubstringBefore$default3).toString()) == null) {
                                                                                                it2 = null;
                                                                                            } else if (!(it2.length() > 0)) {
                                                                                                it2 = null;
                                                                                            }
                                                                                            str9 = it2;
                                                                                            if (str9 != null || StringsKt.isBlank(str9)) {
                                                                                                z2 = true;
                                                                                            } else {
                                                                                                z2 = false;
                                                                                            }
                                                                                            if (!z2) {
                                                                                                LoadItem dlItem = (LoadItem) function12.invoke((Object) null, StringsKt.trim(it2).toString(), Boxing.boxBoolean(false));
                                                                                                List current2 = (List) function11.invoke(CollectionsKt.listOf(dlItem));
                                                                                                epOut3 = new LoadlinksOut("success", current2, CollectionsKt.emptyList());
                                                                                            }
                                                                                        } else {
                                                                                            str9 = it2;
                                                                                            if (str9 != null) {
                                                                                                z2 = true;
                                                                                            } else {
                                                                                                z2 = true;
                                                                                            }
                                                                                            if (!z2) {
                                                                                                LoadItem dlItem2 = (LoadItem) function12.invoke((Object) null, StringsKt.trim(it2).toString(), Boxing.boxBoolean(false));
                                                                                                List current3 = (List) function11.invoke(CollectionsKt.listOf(dlItem2));
                                                                                                epOut3 = new LoadlinksOut("success", current3, CollectionsKt.emptyList());
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    } catch (Throwable th6) {
                                                                                    }
                                                                                } catch (Throwable th7) {
                                                                                    epOut2 = epOut;
                                                                                }
                                                                            } catch (Throwable th8) {
                                                                                epOut2 = epOut;
                                                                            }
                                                                            episodeNewEpisode = MainAPIKt.newEpisode(fibwatch7, AppUtils.INSTANCE.toJson(epOut3), new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$episodes$1$1$1$$ExternalSyntheticLambda0
                                                                                public final Object invoke(Object obj7) {
                                                                                    return Fibwatch$load$2$episodes$1$1$1.invokeSuspend$lambda$0$9(epTitle3, season4, episodeNum4, str8, (Episode) obj7);
                                                                                }
                                                                            });
                                                                        }
                                                                        epOut3 = epOut2;
                                                                        episodeNewEpisode = MainAPIKt.newEpisode(fibwatch7, AppUtils.INSTANCE.toJson(epOut3), new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$episodes$1$1$1$$ExternalSyntheticLambda0
                                                                            public final Object invoke(Object obj7) {
                                                                                return Fibwatch$load$2$episodes$1$1$1.invokeSuspend$lambda$0$9(epTitle3, season4, episodeNum4, str8, (Episode) obj7);
                                                                            }
                                                                        });
                                                                    } else {
                                                                        Requests app2 = MainActivityKt.getApp();
                                                                        String epTitle4 = fibwatch6.getMainUrl() + "/ajax/resolution_switcher.php?video_id=" + innerVideoId;
                                                                        try {
                                                                            Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(innerVideoId4, str10));
                                                                            fibwatch$load$2$episodes$1$1$1.L$0 = SpillingKt.nullOutSpilledVariable($this$async);
                                                                            fibwatch$load$2$episodes$1$1$1.L$1 = $this$withPermit$iv;
                                                                            fibwatch$load$2$episodes$1$1$1.L$2 = function8;
                                                                            fibwatch$load$2$episodes$1$1$1.L$3 = function7;
                                                                            fibwatch$load$2$episodes$1$1$1.L$4 = fibwatch6;
                                                                            fibwatch$load$2$episodes$1$1$1.L$5 = str5;
                                                                            fibwatch$load$2$episodes$1$1$1.L$6 = epTitle2;
                                                                            fibwatch$load$2$episodes$1$1$1.L$7 = SpillingKt.nullOutSpilledVariable(epUrl4);
                                                                            fibwatch$load$2$episodes$1$1$1.L$8 = SpillingKt.nullOutSpilledVariable(lower3);
                                                                            fibwatch$load$2$episodes$1$1$1.L$9 = season3;
                                                                            fibwatch$load$2$episodes$1$1$1.L$10 = episodeNum3;
                                                                            fibwatch$load$2$episodes$1$1$1.L$11 = allqualities;
                                                                            fibwatch$load$2$episodes$1$1$1.L$12 = SpillingKt.nullOutSpilledVariable(innerVideoId);
                                                                            fibwatch$load$2$episodes$1$1$1.L$13 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240_u244);
                                                                            fibwatch$load$2$episodes$1$1$1.I$0 = i4;
                                                                            fibwatch$load$2$episodes$1$1$1.label = 3;
                                                                            try {
                                                                                obj5 = Requests.get$default(app2, epTitle4, (Map) null, (String) null, (Map) null, mapMapOf2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4078, (Object) null);
                                                                                if (obj5 == obj) {
                                                                                    return obj;
                                                                                }
                                                                                $i$f$withPermit4 = $i$f$withPermit3;
                                                                                i5 = i2;
                                                                                epUrl5 = epUrl4;
                                                                                epTitle3 = epTitle2;
                                                                                allqualities2 = allqualities;
                                                                                innerVideoId2 = innerVideoId;
                                                                                $this$withPermit$iv4 = $this$withPermit$iv;
                                                                                i6 = i4;
                                                                                season4 = season3;
                                                                                function9 = function8;
                                                                                fibwatch7 = fibwatch6;
                                                                                episodeNum4 = episodeNum3;
                                                                                function10 = function7;
                                                                                str6 = str5;
                                                                                try {
                                                                                    NiceResponse this_$iv = (NiceResponse) obj5;
                                                                                    try {
                                                                                        ResponseParser parser = this_$iv.getParser();
                                                                                        Intrinsics.checkNotNull(parser);
                                                                                        try {
                                                                                            try {
                                                                                                safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Links.class));
                                                                                            } catch (Exception e) {
                                                                                                e$iv = e;
                                                                                                e$iv.printStackTrace();
                                                                                                safe = null;
                                                                                            }
                                                                                        } catch (Exception e2) {
                                                                                            e$iv = e2;
                                                                                        }
                                                                                    } catch (Exception e3) {
                                                                                        e$iv = e3;
                                                                                    }
                                                                                    str7 = str6;
                                                                                    links = (Links) safe;
                                                                                    str8 = str7;
                                                                                    obj6 = Result.constructor-impl(links);
                                                                                    innerVideoId3 = innerVideoId2;
                                                                                    function12 = function10;
                                                                                    function11 = function9;
                                                                                    $this$withPermit$iv = $this$withPermit$iv4;
                                                                                } catch (Throwable th9) {
                                                                                    th = th9;
                                                                                }
                                                                                if (Result.isFailure-impl(obj6)) {
                                                                                    obj6 = null;
                                                                                }
                                                                                epLinks = (Links) obj6;
                                                                                if (epLinks != null) {
                                                                                }
                                                                                epCurrentRaw = CollectionsKt.emptyList();
                                                                                if (epLinks != null) {
                                                                                }
                                                                                element$iv$iv = CollectionsKt.emptyList();
                                                                                epCurrentList = (List) function11.invoke(epCurrentRaw);
                                                                                Iterable $this$filter$iv2 = (Iterable) element$iv$iv;
                                                                                destination$iv$iv = new ArrayList();
                                                                                while (r19.hasNext()) {
                                                                                    item = (LoadItem) element$iv$iv2;
                                                                                    List epCurrentRaw4 = epCurrentRaw;
                                                                                    $this$none$iv = epCurrentList;
                                                                                    Object $this$none$iv4 = element$iv$iv;
                                                                                    if ($this$none$iv instanceof Collection) {
                                                                                        it3 = $this$none$iv.iterator();
                                                                                        while (true) {
                                                                                            if (it3.hasNext()) {
                                                                                                element$iv = it3.next();
                                                                                                $this$none$iv2 = $this$none$iv;
                                                                                                it4 = it3;
                                                                                                if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                                                                                    z3 = false;
                                                                                                } else {
                                                                                                    $this$none$iv = $this$none$iv2;
                                                                                                    it3 = it4;
                                                                                                }
                                                                                            } else {
                                                                                                z3 = true;
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        it3 = $this$none$iv.iterator();
                                                                                        while (true) {
                                                                                            if (it3.hasNext()) {
                                                                                                element$iv = it3.next();
                                                                                                $this$none$iv2 = $this$none$iv;
                                                                                                it4 = it3;
                                                                                                if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                                                                                    z3 = false;
                                                                                                } else {
                                                                                                    $this$none$iv = $this$none$iv2;
                                                                                                    it3 = it4;
                                                                                                }
                                                                                            } else {
                                                                                                z3 = true;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    if (z3) {
                                                                                        Collection destination$iv$iv7 = destination$iv$iv;
                                                                                        destination$iv$iv7.add(element$iv$iv2);
                                                                                        destination$iv$iv = destination$iv$iv7;
                                                                                    }
                                                                                    element$iv$iv = $this$none$iv4;
                                                                                    epCurrentRaw = epCurrentRaw4;
                                                                                }
                                                                                List epCurrentRaw5 = (List) destination$iv$iv;
                                                                                List epPopupList2 = (List) function11.invoke(epCurrentRaw5);
                                                                                if (epLinks != null) {
                                                                                    status = "error";
                                                                                } else {
                                                                                    status = "error";
                                                                                }
                                                                                epOut = new LoadlinksOut(status, epCurrentList, epPopupList2);
                                                                                if (epOut.getCurrent().isEmpty()) {
                                                                                    epOut2 = epOut;
                                                                                    epOut3 = epOut2;
                                                                                } else {
                                                                                    epOut2 = epOut;
                                                                                    epOut3 = epOut2;
                                                                                }
                                                                                episodeNewEpisode = MainAPIKt.newEpisode(fibwatch7, AppUtils.INSTANCE.toJson(epOut3), new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$episodes$1$1$1$$ExternalSyntheticLambda0
                                                                                    public final Object invoke(Object obj7) {
                                                                                        return Fibwatch$load$2$episodes$1$1$1.invokeSuspend$lambda$0$9(epTitle3, season4, episodeNum4, str8, (Episode) obj7);
                                                                                    }
                                                                                });
                                                                            } catch (Throwable th10) {
                                                                                th = th10;
                                                                                $i$f$withPermit4 = $i$f$withPermit3;
                                                                                i5 = i2;
                                                                                epUrl5 = epUrl4;
                                                                                epTitle3 = epTitle2;
                                                                                allqualities2 = allqualities;
                                                                                innerVideoId2 = innerVideoId;
                                                                                $this$withPermit$iv4 = $this$withPermit$iv;
                                                                                i6 = i4;
                                                                                season4 = season3;
                                                                                function9 = function8;
                                                                                fibwatch7 = fibwatch6;
                                                                                episodeNum4 = episodeNum3;
                                                                                function10 = function7;
                                                                                str6 = str5;
                                                                            }
                                                                        } catch (Throwable th11) {
                                                                            th = th11;
                                                                            $i$f$withPermit4 = $i$f$withPermit3;
                                                                            i5 = i2;
                                                                            epUrl5 = epUrl4;
                                                                            epTitle3 = epTitle2;
                                                                            allqualities2 = allqualities;
                                                                            innerVideoId2 = innerVideoId;
                                                                            $this$withPermit$iv4 = $this$withPermit$iv;
                                                                            i6 = i4;
                                                                            season4 = season3;
                                                                            function9 = function8;
                                                                            fibwatch7 = fibwatch6;
                                                                            episodeNum4 = episodeNum3;
                                                                            function10 = function7;
                                                                            str6 = str5;
                                                                        }
                                                                    }
                                                                    if (Result.isFailure-impl(obj6)) {
                                                                        obj6 = null;
                                                                    }
                                                                    epLinks = (Links) obj6;
                                                                    if (epLinks != null) {
                                                                    }
                                                                    epCurrentRaw = CollectionsKt.emptyList();
                                                                    if (epLinks != null) {
                                                                    }
                                                                    element$iv$iv = CollectionsKt.emptyList();
                                                                    epCurrentList = (List) function11.invoke(epCurrentRaw);
                                                                    Iterable $this$filter$iv3 = (Iterable) element$iv$iv;
                                                                    destination$iv$iv = new ArrayList();
                                                                    while (r19.hasNext()) {
                                                                        item = (LoadItem) element$iv$iv2;
                                                                        List epCurrentRaw6 = epCurrentRaw;
                                                                        $this$none$iv = epCurrentList;
                                                                        Object $this$none$iv5 = element$iv$iv;
                                                                        if ($this$none$iv instanceof Collection) {
                                                                            it3 = $this$none$iv.iterator();
                                                                            while (true) {
                                                                                if (it3.hasNext()) {
                                                                                    element$iv = it3.next();
                                                                                    $this$none$iv2 = $this$none$iv;
                                                                                    it4 = it3;
                                                                                    if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                                                                        z3 = false;
                                                                                    } else {
                                                                                        $this$none$iv = $this$none$iv2;
                                                                                        it3 = it4;
                                                                                    }
                                                                                } else {
                                                                                    z3 = true;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            it3 = $this$none$iv.iterator();
                                                                            while (true) {
                                                                                if (it3.hasNext()) {
                                                                                    element$iv = it3.next();
                                                                                    $this$none$iv2 = $this$none$iv;
                                                                                    it4 = it3;
                                                                                    if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                                                                        z3 = false;
                                                                                    } else {
                                                                                        $this$none$iv = $this$none$iv2;
                                                                                        it3 = it4;
                                                                                    }
                                                                                } else {
                                                                                    z3 = true;
                                                                                }
                                                                            }
                                                                        }
                                                                        if (z3) {
                                                                            Collection destination$iv$iv8 = destination$iv$iv;
                                                                            destination$iv$iv8.add(element$iv$iv2);
                                                                            destination$iv$iv = destination$iv$iv8;
                                                                        }
                                                                        element$iv$iv = $this$none$iv5;
                                                                        epCurrentRaw = epCurrentRaw6;
                                                                    }
                                                                    List epCurrentRaw7 = (List) destination$iv$iv;
                                                                    List epPopupList3 = (List) function11.invoke(epCurrentRaw7);
                                                                    if (epLinks != null) {
                                                                        status = "error";
                                                                    } else {
                                                                        status = "error";
                                                                    }
                                                                    epOut = new LoadlinksOut(status, epCurrentList, epPopupList3);
                                                                    if (epOut.getCurrent().isEmpty()) {
                                                                        epOut2 = epOut;
                                                                        epOut3 = epOut2;
                                                                    } else {
                                                                        epOut2 = epOut;
                                                                        epOut3 = epOut2;
                                                                    }
                                                                    episodeNewEpisode = MainAPIKt.newEpisode(fibwatch7, AppUtils.INSTANCE.toJson(epOut3), new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$episodes$1$1$1$$ExternalSyntheticLambda0
                                                                        public final Object invoke(Object obj7) {
                                                                            return Fibwatch$load$2$episodes$1$1$1.invokeSuspend$lambda$0$9(epTitle3, season4, episodeNum4, str8, (Episode) obj7);
                                                                        }
                                                                    });
                                                                } catch (Throwable th12) {
                                                                    episodeNewEpisode = null;
                                                                }
                                                                Result.Companion companion5 = Result.Companion;
                                                                str8 = str6;
                                                                innerVideoId3 = innerVideoId2;
                                                                function11 = function9;
                                                                $this$withPermit$iv = $this$withPermit$iv4;
                                                                obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                function12 = function10;
                                                            } catch (Throwable th13) {
                                                                $this$withPermit$iv = $this$withPermit$iv4;
                                                                episodeNewEpisode = null;
                                                                $this$withPermit$iv.release();
                                                                return episodeNewEpisode;
                                                            }
                                                        } catch (Throwable th14) {
                                                            th = th14;
                                                            $i$f$withPermit4 = $i$f$withPermit3;
                                                            i5 = i2;
                                                            epUrl5 = epUrl4;
                                                            epTitle3 = epTitle2;
                                                            allqualities2 = allqualities;
                                                            innerVideoId2 = innerVideoId;
                                                            $this$withPermit$iv4 = $this$withPermit$iv;
                                                            i6 = i4;
                                                            season4 = season3;
                                                            function9 = function8;
                                                            fibwatch7 = fibwatch6;
                                                            episodeNum4 = episodeNum3;
                                                            function10 = function7;
                                                            str6 = str5;
                                                        }
                                                    }
                                                    break;
                                                } catch (Throwable th15) {
                                                }
                                            } catch (Throwable th16) {
                                                th = th16;
                                                fibwatch$load$2$episodes$1$1$1 = this;
                                                $i$f$withPermit2 = $i$f$withPermit;
                                                i = 0;
                                                lower2 = lower;
                                                epUrl2 = epTitle;
                                                function4 = function5;
                                                function2 = function6;
                                                str4 = str2;
                                                $this$withPermit$iv2 = $this$withPermit$iv3;
                                                season2 = season;
                                                epUrl3 = epUrl;
                                                episodeNum2 = episodeNum;
                                                fibwatch4 = fibwatch5;
                                                Result.Companion companion6 = Result.Companion;
                                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                                $i$f$withPermit3 = $i$f$withPermit2;
                                                i2 = i;
                                                episodeNum3 = episodeNum2;
                                                season3 = season2;
                                                epTitle2 = epUrl2;
                                                str5 = str4;
                                                fibwatch6 = fibwatch4;
                                                function7 = function4;
                                                function8 = function2;
                                                obj4 = obj3;
                                                String lower4 = lower2;
                                                epUrl4 = epUrl3;
                                                $this$withPermit$iv = $this$withPermit$iv2;
                                                if (Result.isFailure-impl(obj4)) {
                                                    obj4 = null;
                                                }
                                                allqualities = (Document) obj4;
                                                if (allqualities == null) {
                                                    episodeNewEpisode = null;
                                                } else {
                                                    if (allqualities.select("div.available-res:contains(Available in Other Parts:)").isEmpty()) {
                                                        i3 = 1;
                                                    } else {
                                                        i3 = 0;
                                                    }
                                                    i4 = i3;
                                                    elementSelectFirst = allqualities.selectFirst("input#video-id");
                                                    if (elementSelectFirst != null) {
                                                        it = elementSelectFirst.attr("value");
                                                        if (it != null) {
                                                            it = null;
                                                        } else {
                                                            it = null;
                                                        }
                                                    } else {
                                                        it = null;
                                                    }
                                                    innerVideoId = it;
                                                    Result.Companion companion7 = Result.Companion;
                                                    CoroutineScope $this$invokeSuspend_u24lambda_u240_u245 = $this$async;
                                                    if (i4 != 0) {
                                                    }
                                                    str7 = str5;
                                                    $i$f$withPermit4 = $i$f$withPermit3;
                                                    i5 = i2;
                                                    epUrl5 = epUrl4;
                                                    epTitle3 = epTitle2;
                                                    allqualities2 = allqualities;
                                                    innerVideoId2 = innerVideoId;
                                                    $this$withPermit$iv4 = $this$withPermit$iv;
                                                    i6 = i4;
                                                    season4 = season3;
                                                    function9 = function8;
                                                    fibwatch7 = fibwatch6;
                                                    episodeNum4 = episodeNum3;
                                                    function10 = function7;
                                                    links = null;
                                                    str8 = str7;
                                                    obj6 = Result.constructor-impl(links);
                                                    innerVideoId3 = innerVideoId2;
                                                    function12 = function10;
                                                    function11 = function9;
                                                    $this$withPermit$iv = $this$withPermit$iv4;
                                                    if (Result.isFailure-impl(obj6)) {
                                                        obj6 = null;
                                                    }
                                                    epLinks = (Links) obj6;
                                                    if (epLinks != null) {
                                                    }
                                                    epCurrentRaw = CollectionsKt.emptyList();
                                                    if (epLinks != null) {
                                                    }
                                                    element$iv$iv = CollectionsKt.emptyList();
                                                    epCurrentList = (List) function11.invoke(epCurrentRaw);
                                                    Iterable $this$filter$iv4 = (Iterable) element$iv$iv;
                                                    destination$iv$iv = new ArrayList();
                                                    while (r19.hasNext()) {
                                                        item = (LoadItem) element$iv$iv2;
                                                        List epCurrentRaw8 = epCurrentRaw;
                                                        $this$none$iv = epCurrentList;
                                                        Object $this$none$iv6 = element$iv$iv;
                                                        if ($this$none$iv instanceof Collection) {
                                                            it3 = $this$none$iv.iterator();
                                                            while (true) {
                                                                if (it3.hasNext()) {
                                                                    element$iv = it3.next();
                                                                    $this$none$iv2 = $this$none$iv;
                                                                    it4 = it3;
                                                                    if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                                                        z3 = false;
                                                                    } else {
                                                                        $this$none$iv = $this$none$iv2;
                                                                        it3 = it4;
                                                                    }
                                                                } else {
                                                                    z3 = true;
                                                                }
                                                            }
                                                        } else {
                                                            it3 = $this$none$iv.iterator();
                                                            while (true) {
                                                                if (it3.hasNext()) {
                                                                    element$iv = it3.next();
                                                                    $this$none$iv2 = $this$none$iv;
                                                                    it4 = it3;
                                                                    if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                                                        z3 = false;
                                                                    } else {
                                                                        $this$none$iv = $this$none$iv2;
                                                                        it3 = it4;
                                                                    }
                                                                } else {
                                                                    z3 = true;
                                                                }
                                                            }
                                                        }
                                                        if (z3) {
                                                            Collection destination$iv$iv9 = destination$iv$iv;
                                                            destination$iv$iv9.add(element$iv$iv2);
                                                            destination$iv$iv = destination$iv$iv9;
                                                        }
                                                        element$iv$iv = $this$none$iv6;
                                                        epCurrentRaw = epCurrentRaw8;
                                                    }
                                                    List epCurrentRaw9 = (List) destination$iv$iv;
                                                    List epPopupList4 = (List) function11.invoke(epCurrentRaw9);
                                                    if (epLinks != null) {
                                                        status = "error";
                                                    } else {
                                                        status = "error";
                                                    }
                                                    epOut = new LoadlinksOut(status, epCurrentList, epPopupList4);
                                                    if (epOut.getCurrent().isEmpty()) {
                                                        epOut2 = epOut;
                                                        epOut3 = epOut2;
                                                    } else {
                                                        epOut2 = epOut;
                                                        epOut3 = epOut2;
                                                    }
                                                    episodeNewEpisode = MainAPIKt.newEpisode(fibwatch7, AppUtils.INSTANCE.toJson(epOut3), new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$episodes$1$1$1$$ExternalSyntheticLambda0
                                                        public final Object invoke(Object obj7) {
                                                            return Fibwatch$load$2$episodes$1$1$1.invokeSuspend$lambda$0$9(epTitle3, season4, episodeNum4, str8, (Episode) obj7);
                                                        }
                                                    });
                                                }
                                                $this$withPermit$iv.release();
                                                return episodeNewEpisode;
                                            }
                                        } catch (Throwable th17) {
                                            th = th17;
                                            fibwatch$load$2$episodes$1$1$1 = this;
                                            str10 = "yes";
                                            innerVideoId4 = "pop_up_18";
                                            Semaphore semaphore = $this$withPermit$iv;
                                            obj = coroutine_suspended;
                                            $i$f$withPermit2 = $i$f$withPermit;
                                            i = 0;
                                            lower2 = lower;
                                            epUrl2 = epTitle;
                                            function4 = function3;
                                            function2 = function1;
                                            str4 = str2;
                                            $this$withPermit$iv2 = semaphore;
                                            season2 = season;
                                            epUrl3 = epUrl;
                                            episodeNum2 = episodeNum;
                                            fibwatch4 = fibwatch5;
                                        }
                                    } catch (Throwable th18) {
                                        th = th18;
                                        str10 = "yes";
                                        innerVideoId4 = "pop_up_18";
                                        Semaphore semaphore2 = $this$withPermit$iv;
                                        fibwatch$load$2$episodes$1$1$1 = this;
                                        obj = coroutine_suspended;
                                        $i$f$withPermit2 = $i$f$withPermit;
                                        i = 0;
                                        lower2 = lower;
                                        epUrl2 = epTitle;
                                        function4 = function3;
                                        function2 = function1;
                                        str4 = str2;
                                        $this$withPermit$iv2 = semaphore2;
                                        season2 = season;
                                        epUrl3 = epUrl;
                                        episodeNum2 = episodeNum;
                                        fibwatch4 = fibwatch5;
                                    }
                                } catch (Throwable th19) {
                                    th = th19;
                                    fibwatch3 = fibwatch5;
                                    str3 = str2;
                                    fibwatch$load$2$episodes$1$1$1 = this;
                                    obj = coroutine_suspended;
                                    $i$f$withPermit2 = $i$f$withPermit;
                                    i = 0;
                                    lower2 = lower;
                                    epUrl2 = epTitle;
                                    function4 = function3;
                                    function2 = function1;
                                    str4 = str3;
                                    $this$withPermit$iv2 = $this$withPermit$iv;
                                    season2 = season;
                                    epUrl3 = epUrl;
                                    episodeNum2 = episodeNum;
                                    fibwatch4 = fibwatch3;
                                    Result.Companion companion8 = Result.Companion;
                                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                    $i$f$withPermit3 = $i$f$withPermit2;
                                    i2 = i;
                                    episodeNum3 = episodeNum2;
                                    season3 = season2;
                                    epTitle2 = epUrl2;
                                    str5 = str4;
                                    fibwatch6 = fibwatch4;
                                    function7 = function4;
                                    function8 = function2;
                                    obj4 = obj3;
                                    String lower5 = lower2;
                                    epUrl4 = epUrl3;
                                    $this$withPermit$iv = $this$withPermit$iv2;
                                    if (Result.isFailure-impl(obj4)) {
                                        obj4 = null;
                                    }
                                    allqualities = (Document) obj4;
                                    if (allqualities == null) {
                                        episodeNewEpisode = null;
                                    } else {
                                        if (allqualities.select("div.available-res:contains(Available in Other Parts:)").isEmpty()) {
                                            i3 = 1;
                                        } else {
                                            i3 = 0;
                                        }
                                        i4 = i3;
                                        elementSelectFirst = allqualities.selectFirst("input#video-id");
                                        if (elementSelectFirst != null) {
                                            it = elementSelectFirst.attr("value");
                                            if (it != null) {
                                                it = null;
                                            } else {
                                                it = null;
                                            }
                                        } else {
                                            it = null;
                                        }
                                        innerVideoId = it;
                                        Result.Companion companion9 = Result.Companion;
                                        CoroutineScope $this$invokeSuspend_u24lambda_u240_u246 = $this$async;
                                        if (i4 != 0) {
                                        }
                                        str7 = str5;
                                        $i$f$withPermit4 = $i$f$withPermit3;
                                        i5 = i2;
                                        epUrl5 = epUrl4;
                                        epTitle3 = epTitle2;
                                        allqualities2 = allqualities;
                                        innerVideoId2 = innerVideoId;
                                        $this$withPermit$iv4 = $this$withPermit$iv;
                                        i6 = i4;
                                        season4 = season3;
                                        function9 = function8;
                                        fibwatch7 = fibwatch6;
                                        episodeNum4 = episodeNum3;
                                        function10 = function7;
                                        links = null;
                                        str8 = str7;
                                        obj6 = Result.constructor-impl(links);
                                        innerVideoId3 = innerVideoId2;
                                        function12 = function10;
                                        function11 = function9;
                                        $this$withPermit$iv = $this$withPermit$iv4;
                                        if (Result.isFailure-impl(obj6)) {
                                            obj6 = null;
                                        }
                                        epLinks = (Links) obj6;
                                        if (epLinks != null) {
                                        }
                                        epCurrentRaw = CollectionsKt.emptyList();
                                        if (epLinks != null) {
                                        }
                                        element$iv$iv = CollectionsKt.emptyList();
                                        epCurrentList = (List) function11.invoke(epCurrentRaw);
                                        Iterable $this$filter$iv5 = (Iterable) element$iv$iv;
                                        destination$iv$iv = new ArrayList();
                                        while (r19.hasNext()) {
                                            item = (LoadItem) element$iv$iv2;
                                            List epCurrentRaw10 = epCurrentRaw;
                                            $this$none$iv = epCurrentList;
                                            Object $this$none$iv7 = element$iv$iv;
                                            if ($this$none$iv instanceof Collection) {
                                                it3 = $this$none$iv.iterator();
                                                while (true) {
                                                    if (it3.hasNext()) {
                                                        element$iv = it3.next();
                                                        $this$none$iv2 = $this$none$iv;
                                                        it4 = it3;
                                                        if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                                            z3 = false;
                                                        } else {
                                                            $this$none$iv = $this$none$iv2;
                                                            it3 = it4;
                                                        }
                                                    } else {
                                                        z3 = true;
                                                    }
                                                }
                                            } else {
                                                it3 = $this$none$iv.iterator();
                                                while (true) {
                                                    if (it3.hasNext()) {
                                                        element$iv = it3.next();
                                                        $this$none$iv2 = $this$none$iv;
                                                        it4 = it3;
                                                        if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                                            z3 = false;
                                                        } else {
                                                            $this$none$iv = $this$none$iv2;
                                                            it3 = it4;
                                                        }
                                                    } else {
                                                        z3 = true;
                                                    }
                                                }
                                            }
                                            if (z3) {
                                                Collection destination$iv$iv10 = destination$iv$iv;
                                                destination$iv$iv10.add(element$iv$iv2);
                                                destination$iv$iv = destination$iv$iv10;
                                            }
                                            element$iv$iv = $this$none$iv7;
                                            epCurrentRaw = epCurrentRaw10;
                                        }
                                        List epCurrentRaw11 = (List) destination$iv$iv;
                                        List epPopupList5 = (List) function11.invoke(epCurrentRaw11);
                                        if (epLinks != null) {
                                            status = "error";
                                        } else {
                                            status = "error";
                                        }
                                        epOut = new LoadlinksOut(status, epCurrentList, epPopupList5);
                                        if (epOut.getCurrent().isEmpty()) {
                                            epOut2 = epOut;
                                            epOut3 = epOut2;
                                        } else {
                                            epOut2 = epOut;
                                            epOut3 = epOut2;
                                        }
                                        episodeNewEpisode = MainAPIKt.newEpisode(fibwatch7, AppUtils.INSTANCE.toJson(epOut3), new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$episodes$1$1$1$$ExternalSyntheticLambda0
                                            public final Object invoke(Object obj7) {
                                                return Fibwatch$load$2$episodes$1$1$1.invokeSuspend$lambda$0$9(epTitle3, season4, episodeNum4, str8, (Episode) obj7);
                                            }
                                        });
                                    }
                                    $this$withPermit$iv.release();
                                    return episodeNewEpisode;
                                }
                            } catch (Throwable th20) {
                                th = th20;
                                str10 = "yes";
                                innerVideoId4 = "pop_up_18";
                                fibwatch3 = fibwatch5;
                                function3 = function3;
                                function1 = function1;
                                $this$withPermit$iv = $this$withPermit$iv;
                                season = season;
                                epUrl = epUrl;
                                episodeNum = episodeNum;
                                str3 = str2;
                                $this$async = $this$async;
                                fibwatch$load$2$episodes$1$1$1 = this;
                                obj = coroutine_suspended;
                                $i$f$withPermit2 = $i$f$withPermit;
                                i = 0;
                                lower2 = lower;
                                epUrl2 = epTitle;
                                function4 = function3;
                                function2 = function1;
                                str4 = str3;
                                $this$withPermit$iv2 = $this$withPermit$iv;
                                season2 = season;
                                epUrl3 = epUrl;
                                episodeNum2 = episodeNum;
                                fibwatch4 = fibwatch3;
                                Result.Companion companion10 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                $i$f$withPermit3 = $i$f$withPermit2;
                                i2 = i;
                                episodeNum3 = episodeNum2;
                                season3 = season2;
                                epTitle2 = epUrl2;
                                str5 = str4;
                                fibwatch6 = fibwatch4;
                                function7 = function4;
                                function8 = function2;
                                obj4 = obj3;
                                String lower6 = lower2;
                                epUrl4 = epUrl3;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                if (Result.isFailure-impl(obj4)) {
                                    obj4 = null;
                                }
                                allqualities = (Document) obj4;
                                if (allqualities == null) {
                                    episodeNewEpisode = null;
                                } else {
                                    if (allqualities.select("div.available-res:contains(Available in Other Parts:)").isEmpty()) {
                                        i3 = 1;
                                    } else {
                                        i3 = 0;
                                    }
                                    i4 = i3;
                                    elementSelectFirst = allqualities.selectFirst("input#video-id");
                                    if (elementSelectFirst != null) {
                                        it = elementSelectFirst.attr("value");
                                        if (it != null) {
                                            it = null;
                                        } else {
                                            it = null;
                                        }
                                    } else {
                                        it = null;
                                    }
                                    innerVideoId = it;
                                    Result.Companion companion11 = Result.Companion;
                                    CoroutineScope $this$invokeSuspend_u24lambda_u240_u247 = $this$async;
                                    if (i4 != 0) {
                                    }
                                    str7 = str5;
                                    $i$f$withPermit4 = $i$f$withPermit3;
                                    i5 = i2;
                                    epUrl5 = epUrl4;
                                    epTitle3 = epTitle2;
                                    allqualities2 = allqualities;
                                    innerVideoId2 = innerVideoId;
                                    $this$withPermit$iv4 = $this$withPermit$iv;
                                    i6 = i4;
                                    season4 = season3;
                                    function9 = function8;
                                    fibwatch7 = fibwatch6;
                                    episodeNum4 = episodeNum3;
                                    function10 = function7;
                                    links = null;
                                    str8 = str7;
                                    obj6 = Result.constructor-impl(links);
                                    innerVideoId3 = innerVideoId2;
                                    function12 = function10;
                                    function11 = function9;
                                    $this$withPermit$iv = $this$withPermit$iv4;
                                    if (Result.isFailure-impl(obj6)) {
                                        obj6 = null;
                                    }
                                    epLinks = (Links) obj6;
                                    if (epLinks != null) {
                                    }
                                    epCurrentRaw = CollectionsKt.emptyList();
                                    if (epLinks != null) {
                                    }
                                    element$iv$iv = CollectionsKt.emptyList();
                                    epCurrentList = (List) function11.invoke(epCurrentRaw);
                                    Iterable $this$filter$iv6 = (Iterable) element$iv$iv;
                                    destination$iv$iv = new ArrayList();
                                    while (r19.hasNext()) {
                                        item = (LoadItem) element$iv$iv2;
                                        List epCurrentRaw12 = epCurrentRaw;
                                        $this$none$iv = epCurrentList;
                                        Object $this$none$iv8 = element$iv$iv;
                                        if ($this$none$iv instanceof Collection) {
                                            it3 = $this$none$iv.iterator();
                                            while (true) {
                                                if (it3.hasNext()) {
                                                    element$iv = it3.next();
                                                    $this$none$iv2 = $this$none$iv;
                                                    it4 = it3;
                                                    if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                                        z3 = false;
                                                    } else {
                                                        $this$none$iv = $this$none$iv2;
                                                        it3 = it4;
                                                    }
                                                } else {
                                                    z3 = true;
                                                }
                                            }
                                        } else {
                                            it3 = $this$none$iv.iterator();
                                            while (true) {
                                                if (it3.hasNext()) {
                                                    element$iv = it3.next();
                                                    $this$none$iv2 = $this$none$iv;
                                                    it4 = it3;
                                                    if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                                        z3 = false;
                                                    } else {
                                                        $this$none$iv = $this$none$iv2;
                                                        it3 = it4;
                                                    }
                                                } else {
                                                    z3 = true;
                                                }
                                            }
                                        }
                                        if (z3) {
                                            Collection destination$iv$iv11 = destination$iv$iv;
                                            destination$iv$iv11.add(element$iv$iv2);
                                            destination$iv$iv = destination$iv$iv11;
                                        }
                                        element$iv$iv = $this$none$iv8;
                                        epCurrentRaw = epCurrentRaw12;
                                    }
                                    List epCurrentRaw13 = (List) destination$iv$iv;
                                    List epPopupList6 = (List) function11.invoke(epCurrentRaw13);
                                    if (epLinks != null) {
                                        status = "error";
                                    } else {
                                        status = "error";
                                    }
                                    epOut = new LoadlinksOut(status, epCurrentList, epPopupList6);
                                    if (epOut.getCurrent().isEmpty()) {
                                        epOut2 = epOut;
                                        epOut3 = epOut2;
                                    } else {
                                        epOut2 = epOut;
                                        epOut3 = epOut2;
                                    }
                                    episodeNewEpisode = MainAPIKt.newEpisode(fibwatch7, AppUtils.INSTANCE.toJson(epOut3), new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$episodes$1$1$1$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj7) {
                                            return Fibwatch$load$2$episodes$1$1$1.invokeSuspend$lambda$0$9(epTitle3, season4, episodeNum4, str8, (Episode) obj7);
                                        }
                                    });
                                }
                                $this$withPermit$iv.release();
                                return episodeNewEpisode;
                            }
                        } catch (Throwable th21) {
                            th = th21;
                            str3 = str2;
                            fibwatch3 = fibwatch2;
                        }
                    }
                    break;
                } catch (Throwable th22) {
                }
                $this$withPermit$iv.release();
                return episodeNewEpisode;
            case 1:
                str = (String) this.L$6;
                fibwatch = (Fibwatch) this.L$5;
                function3 = (Function3) this.L$4;
                function1 = (Function1) this.L$3;
                episodeItem = (EpisodeItem) this.L$2;
                $this$withPermit$iv = (Semaphore) this.L$1;
                ResultKt.throwOnFailure($result);
                $i$f$withPermit = 0;
                url = episodeItem.getUrl();
                if (url != null) {
                    string = StringsKt.trim(url).toString();
                } else {
                    string = null;
                }
                if (string == null) {
                    string = "";
                }
                epUrl = string;
                if (epUrl.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    episodeNewEpisode = null;
                } else {
                    title = episodeItem.getTitle();
                    if (title != null) {
                        string2 = StringsKt.trim(title).toString();
                    } else {
                        string2 = null;
                    }
                    epTitle = string2 != null ? string2 : "";
                    lower = epTitle.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
                    season = new Ref.ObjectRef();
                    episodeNum = new Ref.ObjectRef();
                    str2 = str;
                    m = Regex.find$default(new Regex("s(\\d{1,2})e(\\d{1,3})(?:-(\\d{1,3}))?"), lower, 0, 2, (Object) null);
                    if (m != null) {
                        season.element = StringsKt.toIntOrNull((String) m.getGroupValues().get(1));
                        episodeNum.element = StringsKt.toIntOrNull((String) m.getGroupValues().get(2));
                        Unit unit4 = Unit.INSTANCE;
                        fibwatch2 = fibwatch;
                    } else {
                        fibwatch2 = fibwatch;
                        m2 = Regex.find$default(new Regex("\\bs(\\d{1,2})\\b"), lower, 0, 2, (Object) null);
                        if (m2 != null) {
                            season.element = StringsKt.toIntOrNull((String) m2.getGroupValues().get(1));
                            Unit unit5 = Unit.INSTANCE;
                        }
                        m3 = Regex.find$default(new Regex("\\be(\\d{1,3})\\b"), lower, 0, 2, (Object) null);
                        if (m3 != null) {
                            episodeNum.element = StringsKt.toIntOrNull((String) m3.getGroupValues().get(1));
                            Unit unit6 = Unit.INSTANCE;
                        }
                    }
                    Result.Companion companion12 = Result.Companion;
                    Requests app3 = MainActivityKt.getApp();
                    String strFixUrl2 = MainAPIKt.fixUrl(fibwatch2, epUrl);
                    Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to("pop_up_18", "yes"));
                    this.L$0 = $this$async;
                    this.L$1 = $this$withPermit$iv;
                    this.L$2 = function1;
                    this.L$3 = function3;
                    fibwatch5 = fibwatch2;
                    this.L$4 = fibwatch5;
                    this.L$5 = str2;
                    $this$async = $this$async;
                    this.L$6 = epTitle;
                    this.L$7 = SpillingKt.nullOutSpilledVariable(epUrl);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(lower);
                    this.L$9 = season;
                    this.L$10 = episodeNum;
                    this.L$11 = SpillingKt.nullOutSpilledVariable($this$async);
                    this.label = 2;
                    function5 = function3;
                    function6 = function1;
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    str10 = "yes";
                    innerVideoId4 = "pop_up_18";
                    obj = coroutine_suspended;
                    obj2 = Requests.get$default(app3, strFixUrl2, (Map) null, (String) null, (Map) null, mapMapOf3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4078, (Object) null);
                    fibwatch$load$2$episodes$1$1$1 = this;
                    if (obj2 == obj) {
                        return obj;
                    }
                    $i$f$withPermit2 = $i$f$withPermit;
                    i = 0;
                    lower2 = lower;
                    epUrl2 = epTitle;
                    function4 = function5;
                    function2 = function6;
                    str4 = str2;
                    $this$withPermit$iv2 = $this$withPermit$iv3;
                    season2 = season;
                    epUrl3 = epUrl;
                    episodeNum2 = episodeNum;
                    fibwatch4 = fibwatch5;
                    obj3 = Result.constructor-impl(((NiceResponse) obj2).getDocument());
                    $i$f$withPermit3 = $i$f$withPermit2;
                    i2 = i;
                    episodeNum3 = episodeNum2;
                    season3 = season2;
                    epTitle2 = epUrl2;
                    str5 = str4;
                    fibwatch6 = fibwatch4;
                    function7 = function4;
                    function8 = function2;
                    obj4 = obj3;
                    String lower7 = lower2;
                    epUrl4 = epUrl3;
                    $this$withPermit$iv = $this$withPermit$iv2;
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = null;
                    }
                    allqualities = (Document) obj4;
                    if (allqualities == null) {
                        episodeNewEpisode = null;
                    } else {
                        if (allqualities.select("div.available-res:contains(Available in Other Parts:)").isEmpty()) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        i4 = i3;
                        elementSelectFirst = allqualities.selectFirst("input#video-id");
                        if (elementSelectFirst != null) {
                            it = elementSelectFirst.attr("value");
                            if (it != null) {
                                it = null;
                            } else {
                                it = null;
                            }
                        } else {
                            it = null;
                        }
                        innerVideoId = it;
                        Result.Companion companion13 = Result.Companion;
                        CoroutineScope $this$invokeSuspend_u24lambda_u240_u248 = $this$async;
                        if (i4 != 0) {
                        }
                        str7 = str5;
                        $i$f$withPermit4 = $i$f$withPermit3;
                        i5 = i2;
                        epUrl5 = epUrl4;
                        epTitle3 = epTitle2;
                        allqualities2 = allqualities;
                        innerVideoId2 = innerVideoId;
                        $this$withPermit$iv4 = $this$withPermit$iv;
                        i6 = i4;
                        season4 = season3;
                        function9 = function8;
                        fibwatch7 = fibwatch6;
                        episodeNum4 = episodeNum3;
                        function10 = function7;
                        links = null;
                        str8 = str7;
                        obj6 = Result.constructor-impl(links);
                        innerVideoId3 = innerVideoId2;
                        function12 = function10;
                        function11 = function9;
                        $this$withPermit$iv = $this$withPermit$iv4;
                        if (Result.isFailure-impl(obj6)) {
                            obj6 = null;
                        }
                        epLinks = (Links) obj6;
                        if (epLinks != null) {
                        }
                        epCurrentRaw = CollectionsKt.emptyList();
                        if (epLinks != null) {
                        }
                        element$iv$iv = CollectionsKt.emptyList();
                        epCurrentList = (List) function11.invoke(epCurrentRaw);
                        Iterable $this$filter$iv7 = (Iterable) element$iv$iv;
                        destination$iv$iv = new ArrayList();
                        while (r19.hasNext()) {
                            item = (LoadItem) element$iv$iv2;
                            List epCurrentRaw14 = epCurrentRaw;
                            $this$none$iv = epCurrentList;
                            Object $this$none$iv9 = element$iv$iv;
                            if ($this$none$iv instanceof Collection) {
                                it3 = $this$none$iv.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        element$iv = it3.next();
                                        $this$none$iv2 = $this$none$iv;
                                        it4 = it3;
                                        if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                            z3 = false;
                                        } else {
                                            $this$none$iv = $this$none$iv2;
                                            it3 = it4;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                }
                            } else {
                                it3 = $this$none$iv.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        element$iv = it3.next();
                                        $this$none$iv2 = $this$none$iv;
                                        it4 = it3;
                                        if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                            z3 = false;
                                        } else {
                                            $this$none$iv = $this$none$iv2;
                                            it3 = it4;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                }
                            }
                            if (z3) {
                                Collection destination$iv$iv12 = destination$iv$iv;
                                destination$iv$iv12.add(element$iv$iv2);
                                destination$iv$iv = destination$iv$iv12;
                            }
                            element$iv$iv = $this$none$iv9;
                            epCurrentRaw = epCurrentRaw14;
                        }
                        List epCurrentRaw15 = (List) destination$iv$iv;
                        List epPopupList7 = (List) function11.invoke(epCurrentRaw15);
                        if (epLinks != null) {
                            status = "error";
                        } else {
                            status = "error";
                        }
                        epOut = new LoadlinksOut(status, epCurrentList, epPopupList7);
                        if (epOut.getCurrent().isEmpty()) {
                            epOut2 = epOut;
                            epOut3 = epOut2;
                        } else {
                            epOut2 = epOut;
                            epOut3 = epOut2;
                        }
                        episodeNewEpisode = MainAPIKt.newEpisode(fibwatch7, AppUtils.INSTANCE.toJson(epOut3), new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$episodes$1$1$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj7) {
                                return Fibwatch$load$2$episodes$1$1$1.invokeSuspend$lambda$0$9(epTitle3, season4, episodeNum4, str8, (Episode) obj7);
                            }
                        });
                    }
                }
                $this$withPermit$iv.release();
                return episodeNewEpisode;
            case 2:
                $i$f$withPermit2 = 0;
                i = 0;
                episodeNum2 = (Ref.ObjectRef) this.L$10;
                season2 = (Ref.ObjectRef) this.L$9;
                lower2 = (String) this.L$8;
                epUrl3 = (String) this.L$7;
                epUrl2 = (String) this.L$6;
                str4 = (String) this.L$5;
                fibwatch4 = (Fibwatch) this.L$4;
                function4 = (Function3) this.L$3;
                function2 = (Function1) this.L$2;
                $this$withPermit$iv2 = (Semaphore) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    obj2 = $result;
                    $this$async = $this$async;
                    str10 = "yes";
                    innerVideoId4 = "pop_up_18";
                    fibwatch$load$2$episodes$1$1$1 = this;
                    obj = coroutine_suspended;
                    obj3 = Result.constructor-impl(((NiceResponse) obj2).getDocument());
                    break;
                } catch (Throwable th23) {
                    th = th23;
                    $this$async = $this$async;
                    str10 = "yes";
                    innerVideoId4 = "pop_up_18";
                    fibwatch$load$2$episodes$1$1$1 = this;
                    obj = coroutine_suspended;
                    Result.Companion companion14 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                    $i$f$withPermit3 = $i$f$withPermit2;
                    i2 = i;
                    episodeNum3 = episodeNum2;
                    season3 = season2;
                    epTitle2 = epUrl2;
                    str5 = str4;
                    fibwatch6 = fibwatch4;
                    function7 = function4;
                    function8 = function2;
                    obj4 = obj3;
                    String lower8 = lower2;
                    epUrl4 = epUrl3;
                    $this$withPermit$iv = $this$withPermit$iv2;
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = null;
                    }
                    allqualities = (Document) obj4;
                    if (allqualities == null) {
                        episodeNewEpisode = null;
                    } else {
                        if (allqualities.select("div.available-res:contains(Available in Other Parts:)").isEmpty()) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        i4 = i3;
                        elementSelectFirst = allqualities.selectFirst("input#video-id");
                        if (elementSelectFirst != null) {
                            it = elementSelectFirst.attr("value");
                            if (it != null) {
                                it = null;
                            } else {
                                it = null;
                            }
                        } else {
                            it = null;
                        }
                        innerVideoId = it;
                        Result.Companion companion15 = Result.Companion;
                        CoroutineScope $this$invokeSuspend_u24lambda_u240_u249 = $this$async;
                        if (i4 != 0) {
                        }
                        str7 = str5;
                        $i$f$withPermit4 = $i$f$withPermit3;
                        i5 = i2;
                        epUrl5 = epUrl4;
                        epTitle3 = epTitle2;
                        allqualities2 = allqualities;
                        innerVideoId2 = innerVideoId;
                        $this$withPermit$iv4 = $this$withPermit$iv;
                        i6 = i4;
                        season4 = season3;
                        function9 = function8;
                        fibwatch7 = fibwatch6;
                        episodeNum4 = episodeNum3;
                        function10 = function7;
                        links = null;
                        str8 = str7;
                        obj6 = Result.constructor-impl(links);
                        innerVideoId3 = innerVideoId2;
                        function12 = function10;
                        function11 = function9;
                        $this$withPermit$iv = $this$withPermit$iv4;
                        if (Result.isFailure-impl(obj6)) {
                            obj6 = null;
                        }
                        epLinks = (Links) obj6;
                        if (epLinks != null) {
                        }
                        epCurrentRaw = CollectionsKt.emptyList();
                        if (epLinks != null) {
                        }
                        element$iv$iv = CollectionsKt.emptyList();
                        epCurrentList = (List) function11.invoke(epCurrentRaw);
                        Iterable $this$filter$iv8 = (Iterable) element$iv$iv;
                        destination$iv$iv = new ArrayList();
                        while (r19.hasNext()) {
                            item = (LoadItem) element$iv$iv2;
                            List epCurrentRaw16 = epCurrentRaw;
                            $this$none$iv = epCurrentList;
                            Object $this$none$iv10 = element$iv$iv;
                            if ($this$none$iv instanceof Collection) {
                                it3 = $this$none$iv.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        element$iv = it3.next();
                                        $this$none$iv2 = $this$none$iv;
                                        it4 = it3;
                                        if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                            z3 = false;
                                        } else {
                                            $this$none$iv = $this$none$iv2;
                                            it3 = it4;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                }
                            } else {
                                it3 = $this$none$iv.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        element$iv = it3.next();
                                        $this$none$iv2 = $this$none$iv;
                                        it4 = it3;
                                        if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                            z3 = false;
                                        } else {
                                            $this$none$iv = $this$none$iv2;
                                            it3 = it4;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                }
                            }
                            if (z3) {
                                Collection destination$iv$iv13 = destination$iv$iv;
                                destination$iv$iv13.add(element$iv$iv2);
                                destination$iv$iv = destination$iv$iv13;
                            }
                            element$iv$iv = $this$none$iv10;
                            epCurrentRaw = epCurrentRaw16;
                        }
                        List epCurrentRaw17 = (List) destination$iv$iv;
                        List epPopupList8 = (List) function11.invoke(epCurrentRaw17);
                        if (epLinks != null) {
                            status = "error";
                        } else {
                            status = "error";
                        }
                        epOut = new LoadlinksOut(status, epCurrentList, epPopupList8);
                        if (epOut.getCurrent().isEmpty()) {
                            epOut2 = epOut;
                            epOut3 = epOut2;
                        } else {
                            epOut2 = epOut;
                            epOut3 = epOut2;
                        }
                        episodeNewEpisode = MainAPIKt.newEpisode(fibwatch7, AppUtils.INSTANCE.toJson(epOut3), new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$episodes$1$1$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj7) {
                                return Fibwatch$load$2$episodes$1$1$1.invokeSuspend$lambda$0$9(epTitle3, season4, episodeNum4, str8, (Episode) obj7);
                            }
                        });
                    }
                    $this$withPermit$iv.release();
                    return episodeNewEpisode;
                }
                $i$f$withPermit3 = $i$f$withPermit2;
                i2 = i;
                episodeNum3 = episodeNum2;
                season3 = season2;
                epTitle2 = epUrl2;
                str5 = str4;
                fibwatch6 = fibwatch4;
                function7 = function4;
                function8 = function2;
                obj4 = obj3;
                String lower9 = lower2;
                epUrl4 = epUrl3;
                $this$withPermit$iv = $this$withPermit$iv2;
                if (Result.isFailure-impl(obj4)) {
                    obj4 = null;
                }
                allqualities = (Document) obj4;
                if (allqualities == null) {
                    episodeNewEpisode = null;
                } else {
                    if (allqualities.select("div.available-res:contains(Available in Other Parts:)").isEmpty()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    i4 = i3;
                    elementSelectFirst = allqualities.selectFirst("input#video-id");
                    if (elementSelectFirst != null) {
                        it = elementSelectFirst.attr("value");
                        if (it != null) {
                            it = null;
                        } else {
                            it = null;
                        }
                    } else {
                        it = null;
                    }
                    innerVideoId = it;
                    Result.Companion companion16 = Result.Companion;
                    CoroutineScope $this$invokeSuspend_u24lambda_u240_u2410 = $this$async;
                    if (i4 != 0) {
                    }
                    str7 = str5;
                    $i$f$withPermit4 = $i$f$withPermit3;
                    i5 = i2;
                    epUrl5 = epUrl4;
                    epTitle3 = epTitle2;
                    allqualities2 = allqualities;
                    innerVideoId2 = innerVideoId;
                    $this$withPermit$iv4 = $this$withPermit$iv;
                    i6 = i4;
                    season4 = season3;
                    function9 = function8;
                    fibwatch7 = fibwatch6;
                    episodeNum4 = episodeNum3;
                    function10 = function7;
                    links = null;
                    str8 = str7;
                    obj6 = Result.constructor-impl(links);
                    innerVideoId3 = innerVideoId2;
                    function12 = function10;
                    function11 = function9;
                    $this$withPermit$iv = $this$withPermit$iv4;
                    if (Result.isFailure-impl(obj6)) {
                        obj6 = null;
                    }
                    epLinks = (Links) obj6;
                    if (epLinks != null) {
                    }
                    epCurrentRaw = CollectionsKt.emptyList();
                    if (epLinks != null) {
                    }
                    element$iv$iv = CollectionsKt.emptyList();
                    epCurrentList = (List) function11.invoke(epCurrentRaw);
                    Iterable $this$filter$iv9 = (Iterable) element$iv$iv;
                    destination$iv$iv = new ArrayList();
                    while (r19.hasNext()) {
                        item = (LoadItem) element$iv$iv2;
                        List epCurrentRaw18 = epCurrentRaw;
                        $this$none$iv = epCurrentList;
                        Object $this$none$iv11 = element$iv$iv;
                        if ($this$none$iv instanceof Collection) {
                            it3 = $this$none$iv.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    element$iv = it3.next();
                                    $this$none$iv2 = $this$none$iv;
                                    it4 = it3;
                                    if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                        z3 = false;
                                    } else {
                                        $this$none$iv = $this$none$iv2;
                                        it3 = it4;
                                    }
                                } else {
                                    z3 = true;
                                }
                            }
                        } else {
                            it3 = $this$none$iv.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    element$iv = it3.next();
                                    $this$none$iv2 = $this$none$iv;
                                    it4 = it3;
                                    if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                        z3 = false;
                                    } else {
                                        $this$none$iv = $this$none$iv2;
                                        it3 = it4;
                                    }
                                } else {
                                    z3 = true;
                                }
                            }
                        }
                        if (z3) {
                            Collection destination$iv$iv14 = destination$iv$iv;
                            destination$iv$iv14.add(element$iv$iv2);
                            destination$iv$iv = destination$iv$iv14;
                        }
                        element$iv$iv = $this$none$iv11;
                        epCurrentRaw = epCurrentRaw18;
                    }
                    List epCurrentRaw19 = (List) destination$iv$iv;
                    List epPopupList9 = (List) function11.invoke(epCurrentRaw19);
                    if (epLinks != null) {
                        status = "error";
                    } else {
                        status = "error";
                    }
                    epOut = new LoadlinksOut(status, epCurrentList, epPopupList9);
                    if (epOut.getCurrent().isEmpty()) {
                        epOut2 = epOut;
                        epOut3 = epOut2;
                    } else {
                        epOut2 = epOut;
                        epOut3 = epOut2;
                    }
                    episodeNewEpisode = MainAPIKt.newEpisode(fibwatch7, AppUtils.INSTANCE.toJson(epOut3), new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$episodes$1$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj7) {
                            return Fibwatch$load$2$episodes$1$1$1.invokeSuspend$lambda$0$9(epTitle3, season4, episodeNum4, str8, (Episode) obj7);
                        }
                    });
                }
                $this$withPermit$iv.release();
                return episodeNewEpisode;
            case 3:
                $i$f$withPermit4 = 0;
                i5 = 0;
                i6 = this.I$0;
                innerVideoId2 = (String) this.L$12;
                allqualities2 = (Document) this.L$11;
                episodeNum4 = (Ref.ObjectRef) this.L$10;
                season4 = (Ref.ObjectRef) this.L$9;
                epUrl5 = (String) this.L$7;
                epTitle3 = (String) this.L$6;
                str6 = (String) this.L$5;
                fibwatch7 = (Fibwatch) this.L$4;
                function10 = (Function3) this.L$3;
                function9 = (Function1) this.L$2;
                $this$withPermit$iv4 = (Semaphore) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    obj5 = $result;
                    NiceResponse this_$iv2 = (NiceResponse) obj5;
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Links.class));
                    str7 = str6;
                    links = (Links) safe;
                    str8 = str7;
                    obj6 = Result.constructor-impl(links);
                    innerVideoId3 = innerVideoId2;
                    function12 = function10;
                    function11 = function9;
                    $this$withPermit$iv = $this$withPermit$iv4;
                } catch (Throwable th24) {
                    th = th24;
                    break;
                }
                if (Result.isFailure-impl(obj6)) {
                    obj6 = null;
                }
                epLinks = (Links) obj6;
                if (epLinks != null) {
                }
                epCurrentRaw = CollectionsKt.emptyList();
                if (epLinks != null) {
                }
                element$iv$iv = CollectionsKt.emptyList();
                epCurrentList = (List) function11.invoke(epCurrentRaw);
                Iterable $this$filter$iv10 = (Iterable) element$iv$iv;
                destination$iv$iv = new ArrayList();
                while (r19.hasNext()) {
                    item = (LoadItem) element$iv$iv2;
                    List epCurrentRaw110 = epCurrentRaw;
                    $this$none$iv = epCurrentList;
                    Object $this$none$iv12 = element$iv$iv;
                    if ($this$none$iv instanceof Collection) {
                        it3 = $this$none$iv.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                element$iv = it3.next();
                                $this$none$iv2 = $this$none$iv;
                                it4 = it3;
                                if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                    z3 = false;
                                } else {
                                    $this$none$iv = $this$none$iv2;
                                    it3 = it4;
                                }
                            } else {
                                z3 = true;
                            }
                        }
                    } else {
                        it3 = $this$none$iv.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                element$iv = it3.next();
                                $this$none$iv2 = $this$none$iv;
                                it4 = it3;
                                if (Intrinsics.areEqual(((LoadItem) element$iv).getUrl(), item.getUrl())) {
                                    z3 = false;
                                } else {
                                    $this$none$iv = $this$none$iv2;
                                    it3 = it4;
                                }
                            } else {
                                z3 = true;
                            }
                        }
                    }
                    if (z3) {
                        Collection destination$iv$iv15 = destination$iv$iv;
                        destination$iv$iv15.add(element$iv$iv2);
                        destination$iv$iv = destination$iv$iv15;
                    }
                    element$iv$iv = $this$none$iv12;
                    epCurrentRaw = epCurrentRaw110;
                }
                List epCurrentRaw111 = (List) destination$iv$iv;
                List epPopupList10 = (List) function11.invoke(epCurrentRaw111);
                if (epLinks != null) {
                    status = "error";
                } else {
                    status = "error";
                }
                epOut = new LoadlinksOut(status, epCurrentList, epPopupList10);
                if (epOut.getCurrent().isEmpty()) {
                    epOut2 = epOut;
                    epOut3 = epOut2;
                } else {
                    epOut2 = epOut;
                    epOut3 = epOut2;
                }
                episodeNewEpisode = MainAPIKt.newEpisode(fibwatch7, AppUtils.INSTANCE.toJson(epOut3), new Function1() { // from class: com.Fibwatch.Fibwatch$load$2$episodes$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj7) {
                        return Fibwatch$load$2$episodes$1$1$1.invokeSuspend$lambda$0$9(epTitle3, season4, episodeNum4, str8, (Episode) obj7);
                    }
                });
                $this$withPermit$iv.release();
                return episodeNewEpisode;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$9(String $epTitle, Ref.ObjectRef $season, Ref.ObjectRef $episodeNum, String $poster, Episode $this$newEpisode) {
        $this$newEpisode.setName($epTitle);
        Integer num = (Integer) $season.element;
        if (num != null) {
            int it = num.intValue();
            $this$newEpisode.setSeason(Integer.valueOf(it));
        }
        Integer num2 = (Integer) $episodeNum.element;
        if (num2 != null) {
            int it2 = num2.intValue();
            $this$newEpisode.setEpisode(Integer.valueOf(it2));
        }
        $this$newEpisode.setPosterUrl($poster);
        return Unit.INSTANCE;
    }
}
