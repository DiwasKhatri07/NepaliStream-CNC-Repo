package com.MPlayer;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\by\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bé\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020#\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0018\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0001\u0012\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018\u0012\u0006\u0010+\u001a\u00020\f\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010-\u001a\u00020\u000e:\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00102\u001a\u00020\u000e\u0012\u0006\u00103\u001a\u00020\f\u0012\u0006\u00104\u001a\u00020\f\u0012\b\u00105\u001a\u0004\u0018\u00010\u0001\u0012\b\u00106\u001a\u0004\u0018\u00010\u0001\u0012\b\u00107\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u00108\u001a\u00020\f\u0012\b\u00109\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0001\u0012\u0016\b\u0001\u0010<\u001a\u00020\u000e:\f\b.\u0012\b\b/\u0012\u0004\b\b(=¢\u0006\u0004\b>\u0010?J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0007HÆ\u0003J\t\u0010y\u001a\u00020\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010|\u001a\u00020\fHÆ\u0003J\t\u0010}\u001a\u00020\u000eHÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\fHÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0003J\u0010\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\fHÆ\u0003J\u0010\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0003J\u0010\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020#HÆ\u0003J\u0010\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020%0\u0018HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0012\u0010\u0094\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\fHÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\fHÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u000eHÆ\u0003JÆ\u0004\u0010¤\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00182\b\b\u0002\u0010\u001b\u001a\u00020\f2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00182\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00182\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00182\b\b\u0002\u0010+\u001a\u00020\f2\b\b\u0002\u0010,\u001a\u00020\u00032\u0016\b\u0003\u0010-\u001a\u00020\u000e:\f\b.\u0012\b\b/\u0012\u0004\b\b(02\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\f2\b\b\u0002\u00104\u001a\u00020\f2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u00108\u001a\u00020\f2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00012\u0016\b\u0003\u0010<\u001a\u00020\u000e:\f\b.\u0012\b\b/\u0012\u0004\b\b(=HÆ\u0001J\u0016\u0010¥\u0001\u001a\u00020\u000e2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\f\u0010§\u0001\u001a\u00030¨\u0001HÖ\u0081\u0004J\u000b\u0010©\u0001\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010AR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010AR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010AR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bI\u0010HR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bN\u0010HR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bO\u0010HR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bP\u0010HR\u0011\u0010\u0012\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010KR\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bR\u0010MR\u0011\u0010\u0014\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bS\u0010KR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bT\u0010HR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u0010AR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\b\n\u0000\u001a\u0004\bX\u0010WR\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bY\u0010KR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010WR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018¢\u0006\b\n\u0000\u001a\u0004\b[\u0010WR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010HR\u0013\u0010 \u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b]\u0010HR\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u0010AR\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0018¢\u0006\b\n\u0000\u001a\u0004\ba\u0010WR\u0013\u0010&\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bb\u0010HR\u0013\u0010'\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bc\u0010HR\u0013\u0010(\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bd\u0010HR\u0013\u0010)\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\be\u0010HR\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bf\u0010WR\u0011\u0010+\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bg\u0010KR\u0011\u0010,\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bh\u0010AR\u0011\u0010-\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bi\u0010MR\u0011\u00101\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bj\u0010AR\u0011\u00102\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010MR\u0011\u00103\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bk\u0010KR\u0011\u00104\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bl\u0010KR\u0013\u00105\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bm\u0010HR\u0013\u00106\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bn\u0010HR\u0013\u00107\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bo\u0010HR\u0011\u00108\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bp\u0010KR\u0013\u00109\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bq\u0010HR\u0013\u0010:\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\br\u0010HR\u0013\u0010;\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bs\u0010HR\u0011\u0010<\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bt\u0010M¨\u0006ª\u0001"}, d2 = {"Lcom/MPlayer/Trailer;", "", "description", "", "title", "releaseDate", "stream", "Lcom/MPlayer/Stream;", "type", "tvodPackImageInfo", "tvodDetail", "watchAt", "", "lastWatched", "", "lastWatchedEpisodeId", "subtitleLanguageCode", "audioTrackLanguageCode", "statusCode", "lastTvShowEpisode", "rating", "descriptor", "id", "languages", "", "languagesDetails", "Lcom/MPlayer/LanguagesDetail2;", "duration", "genres", "genresDetails", "Lcom/MPlayer/GenresDetail2;", "secondaryGenres", "publishTime", "shareUrl", "image", "Lcom/MPlayer/Image2;", "imageInfo", "Lcom/MPlayer/ImageInfo2;", "titleContentImageInfo", "trailer", "firstVideo", "container", "contributors", "sequence", "subType", "canPreviewGifvideo", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "canPreviewGIFVideo", "webUrl", "isOptimizedDescription", "childCount", "videoCount", "detailKey", "inlineData", "statistics", "viewCount", "overlayImages", "tabs", "goldBadgeImageInfo", "existInCw", "existInCW", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/MPlayer/Stream;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;JZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;JZJLjava/lang/Object;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JLjava/util/List;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Lcom/MPlayer/Image2;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/List;JLjava/lang/String;ZLjava/lang/String;ZJJLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Z)V", "getDescription", "()Ljava/lang/String;", "getTitle", "getReleaseDate", "getStream", "()Lcom/MPlayer/Stream;", "getType", "getTvodPackImageInfo", "()Ljava/lang/Object;", "getTvodDetail", "getWatchAt", "()J", "getLastWatched", "()Z", "getLastWatchedEpisodeId", "getSubtitleLanguageCode", "getAudioTrackLanguageCode", "getStatusCode", "getLastTvShowEpisode", "getRating", "getDescriptor", "getId", "getLanguages", "()Ljava/util/List;", "getLanguagesDetails", "getDuration", "getGenres", "getGenresDetails", "getSecondaryGenres", "getPublishTime", "getShareUrl", "getImage", "()Lcom/MPlayer/Image2;", "getImageInfo", "getTitleContentImageInfo", "getTrailer", "getFirstVideo", "getContainer", "getContributors", "getSequence", "getSubType", "getCanPreviewGifvideo", "getWebUrl", "getChildCount", "getVideoCount", "getDetailKey", "getInlineData", "getStatistics", "getViewCount", "getOverlayImages", "getTabs", "getGoldBadgeImageInfo", "getExistInCw", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "copy", "equals", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Trailer {

    @Nullable
    private final Object audioTrackLanguageCode;
    private final boolean canPreviewGifvideo;
    private final long childCount;

    @Nullable
    private final Object container;

    @NotNull
    private final List<Object> contributors;

    @NotNull
    private final String description;

    @Nullable
    private final Object descriptor;

    @Nullable
    private final Object detailKey;
    private final long duration;
    private final boolean existInCw;

    @Nullable
    private final Object firstVideo;

    @NotNull
    private final List<String> genres;

    @NotNull
    private final List<GenresDetail2> genresDetails;

    @Nullable
    private final Object goldBadgeImageInfo;

    @NotNull
    private final String id;

    @NotNull
    private final Image2 image;

    @NotNull
    private final List<ImageInfo2> imageInfo;

    @Nullable
    private final Object inlineData;
    private final boolean isOptimizedDescription;

    @NotNull
    private final List<String> languages;

    @NotNull
    private final List<LanguagesDetail2> languagesDetails;
    private final boolean lastTvShowEpisode;
    private final boolean lastWatched;

    @Nullable
    private final Object lastWatchedEpisodeId;

    @Nullable
    private final Object overlayImages;

    @Nullable
    private final Object publishTime;
    private final long rating;

    @NotNull
    private final String releaseDate;

    @Nullable
    private final Object secondaryGenres;
    private final long sequence;

    @NotNull
    private final String shareUrl;

    @Nullable
    private final Object statistics;
    private final long statusCode;

    @NotNull
    private final Stream stream;

    @NotNull
    private final String subType;

    @Nullable
    private final Object subtitleLanguageCode;

    @Nullable
    private final Object tabs;

    @NotNull
    private final String title;

    @Nullable
    private final Object titleContentImageInfo;

    @Nullable
    private final Object trailer;

    @Nullable
    private final Object tvodDetail;

    @Nullable
    private final Object tvodPackImageInfo;

    @NotNull
    private final String type;
    private final long videoCount;
    private final long viewCount;
    private final long watchAt;

    @NotNull
    private final String webUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Trailer copy$default(Trailer trailer, String str, String str2, String str3, Stream stream, String str4, Object obj, Object obj2, long j, boolean z, Object obj3, Object obj4, Object obj5, long j2, boolean z2, long j3, Object obj6, String str5, List list, List list2, long j4, List list3, List list4, Object obj7, Object obj8, String str6, Image2 image2, List list5, Object obj9, Object obj10, Object obj11, Object obj12, List list6, long j5, String str7, boolean z3, String str8, boolean z4, long j6, long j7, Object obj13, Object obj14, Object obj15, long j8, Object obj16, Object obj17, Object obj18, boolean z5, int i, int i2, Object obj19) {
        String str9 = (i & 1) != 0 ? trailer.description : str;
        String str10 = (i & 2) != 0 ? trailer.title : str2;
        String str11 = (i & 4) != 0 ? trailer.releaseDate : str3;
        Stream stream2 = (i & 8) != 0 ? trailer.stream : stream;
        String str12 = (i & 16) != 0 ? trailer.type : str4;
        Object obj20 = (i & 32) != 0 ? trailer.tvodPackImageInfo : obj;
        Object obj21 = (i & 64) != 0 ? trailer.tvodDetail : obj2;
        long j9 = (i & 128) != 0 ? trailer.watchAt : j;
        boolean z6 = (i & 256) != 0 ? trailer.lastWatched : z;
        Object obj22 = (i & 512) != 0 ? trailer.lastWatchedEpisodeId : obj3;
        Object obj23 = (i & 1024) != 0 ? trailer.subtitleLanguageCode : obj4;
        Object obj24 = (i & 2048) != 0 ? trailer.audioTrackLanguageCode : obj5;
        String str13 = str9;
        String str14 = str10;
        long j10 = (i & 4096) != 0 ? trailer.statusCode : j2;
        boolean z7 = (i & 8192) != 0 ? trailer.lastTvShowEpisode : z2;
        long j11 = (i & 16384) != 0 ? trailer.rating : j3;
        Object obj25 = (i & 32768) != 0 ? trailer.descriptor : obj6;
        String str15 = (i & 65536) != 0 ? trailer.id : str5;
        List list7 = (i & 131072) != 0 ? trailer.languages : list;
        List list8 = (i & 262144) != 0 ? trailer.languagesDetails : list2;
        long j12 = j11;
        long j13 = (i & 524288) != 0 ? trailer.duration : j4;
        List list9 = list8;
        List list10 = (i & 1048576) != 0 ? trailer.genres : list3;
        List list11 = (i & 2097152) != 0 ? trailer.genresDetails : list4;
        Object obj26 = (i & 4194304) != 0 ? trailer.secondaryGenres : obj7;
        Object obj27 = (i & 8388608) != 0 ? trailer.publishTime : obj8;
        String str16 = (i & 16777216) != 0 ? trailer.shareUrl : str6;
        Image2 image3 = (i & 33554432) != 0 ? trailer.image : image2;
        List list12 = (i & 67108864) != 0 ? trailer.imageInfo : list5;
        Object obj28 = (i & 134217728) != 0 ? trailer.titleContentImageInfo : obj9;
        Object obj29 = (i & 268435456) != 0 ? trailer.trailer : obj10;
        Object obj30 = (i & 536870912) != 0 ? trailer.firstVideo : obj11;
        Object obj31 = (i & 1073741824) != 0 ? trailer.container : obj12;
        List list13 = (i & Integer.MIN_VALUE) != 0 ? trailer.contributors : list6;
        long j14 = (i2 & 1) != 0 ? trailer.sequence : j5;
        List list14 = list13;
        String str17 = (i2 & 2) != 0 ? trailer.subType : str7;
        boolean z8 = (i2 & 4) != 0 ? trailer.canPreviewGifvideo : z3;
        String str18 = (i2 & 8) != 0 ? trailer.webUrl : str8;
        boolean z9 = (i2 & 16) != 0 ? trailer.isOptimizedDescription : z4;
        long j15 = j14;
        long j16 = (i2 & 32) != 0 ? trailer.childCount : j6;
        long j17 = (i2 & 64) != 0 ? trailer.videoCount : j7;
        return trailer.copy(str13, str14, str11, stream2, str12, obj20, obj21, j9, z6, obj22, obj23, obj24, j10, z7, j12, obj25, str15, list7, list9, j13, list10, list11, obj26, obj27, str16, image3, list12, obj28, obj29, obj30, obj31, list14, j15, str17, z8, str18, z9, j16, j17, (i2 & 128) != 0 ? trailer.detailKey : obj13, (i2 & 256) != 0 ? trailer.inlineData : obj14, (i2 & 512) != 0 ? trailer.statistics : obj15, (i2 & 1024) != 0 ? trailer.viewCount : j8, (i2 & 2048) != 0 ? trailer.overlayImages : obj16, (i2 & 4096) != 0 ? trailer.tabs : obj17, (i2 & 8192) != 0 ? trailer.goldBadgeImageInfo : obj18, (i2 & 16384) != 0 ? trailer.existInCw : z5);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Object getLastWatchedEpisodeId() {
        return this.lastWatchedEpisodeId;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Object getSubtitleLanguageCode() {
        return this.subtitleLanguageCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Object getAudioTrackLanguageCode() {
        return this.audioTrackLanguageCode;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getStatusCode() {
        return this.statusCode;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getLastTvShowEpisode() {
        return this.lastTvShowEpisode;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getRating() {
        return this.rating;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Object getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<String> component18() {
        return this.languages;
    }

    @NotNull
    public final List<LanguagesDetail2> component19() {
        return this.languagesDetails;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final List<String> component21() {
        return this.genres;
    }

    @NotNull
    public final List<GenresDetail2> component22() {
        return this.genresDetails;
    }

    @Nullable
    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Object getSecondaryGenres() {
        return this.secondaryGenres;
    }

    @Nullable
    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Object getPublishTime() {
        return this.publishTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component26, reason: from getter */
    public final Image2 getImage() {
        return this.image;
    }

    @NotNull
    public final List<ImageInfo2> component27() {
        return this.imageInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component28, reason: from getter */
    public final Object getTitleContentImageInfo() {
        return this.titleContentImageInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component29, reason: from getter */
    public final Object getTrailer() {
        return this.trailer;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component30, reason: from getter */
    public final Object getFirstVideo() {
        return this.firstVideo;
    }

    @Nullable
    /* JADX INFO: renamed from: component31, reason: from getter */
    public final Object getContainer() {
        return this.container;
    }

    @NotNull
    public final List<Object> component32() {
        return this.contributors;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final long getSequence() {
        return this.sequence;
    }

    @NotNull
    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getSubType() {
        return this.subType;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final boolean getCanPreviewGifvideo() {
        return this.canPreviewGifvideo;
    }

    @NotNull
    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getWebUrl() {
        return this.webUrl;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final boolean getIsOptimizedDescription() {
        return this.isOptimizedDescription;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final long getChildCount() {
        return this.childCount;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final long getVideoCount() {
        return this.videoCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Stream getStream() {
        return this.stream;
    }

    @Nullable
    /* JADX INFO: renamed from: component40, reason: from getter */
    public final Object getDetailKey() {
        return this.detailKey;
    }

    @Nullable
    /* JADX INFO: renamed from: component41, reason: from getter */
    public final Object getInlineData() {
        return this.inlineData;
    }

    @Nullable
    /* JADX INFO: renamed from: component42, reason: from getter */
    public final Object getStatistics() {
        return this.statistics;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final long getViewCount() {
        return this.viewCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component44, reason: from getter */
    public final Object getOverlayImages() {
        return this.overlayImages;
    }

    @Nullable
    /* JADX INFO: renamed from: component45, reason: from getter */
    public final Object getTabs() {
        return this.tabs;
    }

    @Nullable
    /* JADX INFO: renamed from: component46, reason: from getter */
    public final Object getGoldBadgeImageInfo() {
        return this.goldBadgeImageInfo;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final boolean getExistInCw() {
        return this.existInCw;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Object getTvodPackImageInfo() {
        return this.tvodPackImageInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Object getTvodDetail() {
        return this.tvodDetail;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getWatchAt() {
        return this.watchAt;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getLastWatched() {
        return this.lastWatched;
    }

    @NotNull
    public final Trailer copy(@NotNull String description, @NotNull String title, @NotNull String releaseDate, @NotNull Stream stream, @NotNull String type, @Nullable Object tvodPackImageInfo, @Nullable Object tvodDetail, long watchAt, boolean lastWatched, @Nullable Object lastWatchedEpisodeId, @Nullable Object subtitleLanguageCode, @Nullable Object audioTrackLanguageCode, long statusCode, boolean lastTvShowEpisode, long rating, @Nullable Object descriptor, @NotNull String id, @NotNull List<String> languages, @NotNull List<LanguagesDetail2> languagesDetails, long duration, @NotNull List<String> genres, @NotNull List<GenresDetail2> genresDetails, @Nullable Object secondaryGenres, @Nullable Object publishTime, @NotNull String shareUrl, @NotNull Image2 image, @NotNull List<ImageInfo2> imageInfo, @Nullable Object titleContentImageInfo, @Nullable Object trailer, @Nullable Object firstVideo, @Nullable Object container, @NotNull List<? extends Object> contributors, long sequence, @NotNull String subType, @JsonProperty("canPreviewGIFVideo") boolean canPreviewGifvideo, @NotNull String webUrl, boolean isOptimizedDescription, long childCount, long videoCount, @Nullable Object detailKey, @Nullable Object inlineData, @Nullable Object statistics, long viewCount, @Nullable Object overlayImages, @Nullable Object tabs, @Nullable Object goldBadgeImageInfo, @JsonProperty("existInCW") boolean existInCw) {
        return new Trailer(description, title, releaseDate, stream, type, tvodPackImageInfo, tvodDetail, watchAt, lastWatched, lastWatchedEpisodeId, subtitleLanguageCode, audioTrackLanguageCode, statusCode, lastTvShowEpisode, rating, descriptor, id, languages, languagesDetails, duration, genres, genresDetails, secondaryGenres, publishTime, shareUrl, image, imageInfo, titleContentImageInfo, trailer, firstVideo, container, contributors, sequence, subType, canPreviewGifvideo, webUrl, isOptimizedDescription, childCount, videoCount, detailKey, inlineData, statistics, viewCount, overlayImages, tabs, goldBadgeImageInfo, existInCw);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Trailer)) {
            return false;
        }
        Trailer trailer = (Trailer) other;
        return Intrinsics.areEqual(this.description, trailer.description) && Intrinsics.areEqual(this.title, trailer.title) && Intrinsics.areEqual(this.releaseDate, trailer.releaseDate) && Intrinsics.areEqual(this.stream, trailer.stream) && Intrinsics.areEqual(this.type, trailer.type) && Intrinsics.areEqual(this.tvodPackImageInfo, trailer.tvodPackImageInfo) && Intrinsics.areEqual(this.tvodDetail, trailer.tvodDetail) && this.watchAt == trailer.watchAt && this.lastWatched == trailer.lastWatched && Intrinsics.areEqual(this.lastWatchedEpisodeId, trailer.lastWatchedEpisodeId) && Intrinsics.areEqual(this.subtitleLanguageCode, trailer.subtitleLanguageCode) && Intrinsics.areEqual(this.audioTrackLanguageCode, trailer.audioTrackLanguageCode) && this.statusCode == trailer.statusCode && this.lastTvShowEpisode == trailer.lastTvShowEpisode && this.rating == trailer.rating && Intrinsics.areEqual(this.descriptor, trailer.descriptor) && Intrinsics.areEqual(this.id, trailer.id) && Intrinsics.areEqual(this.languages, trailer.languages) && Intrinsics.areEqual(this.languagesDetails, trailer.languagesDetails) && this.duration == trailer.duration && Intrinsics.areEqual(this.genres, trailer.genres) && Intrinsics.areEqual(this.genresDetails, trailer.genresDetails) && Intrinsics.areEqual(this.secondaryGenres, trailer.secondaryGenres) && Intrinsics.areEqual(this.publishTime, trailer.publishTime) && Intrinsics.areEqual(this.shareUrl, trailer.shareUrl) && Intrinsics.areEqual(this.image, trailer.image) && Intrinsics.areEqual(this.imageInfo, trailer.imageInfo) && Intrinsics.areEqual(this.titleContentImageInfo, trailer.titleContentImageInfo) && Intrinsics.areEqual(this.trailer, trailer.trailer) && Intrinsics.areEqual(this.firstVideo, trailer.firstVideo) && Intrinsics.areEqual(this.container, trailer.container) && Intrinsics.areEqual(this.contributors, trailer.contributors) && this.sequence == trailer.sequence && Intrinsics.areEqual(this.subType, trailer.subType) && this.canPreviewGifvideo == trailer.canPreviewGifvideo && Intrinsics.areEqual(this.webUrl, trailer.webUrl) && this.isOptimizedDescription == trailer.isOptimizedDescription && this.childCount == trailer.childCount && this.videoCount == trailer.videoCount && Intrinsics.areEqual(this.detailKey, trailer.detailKey) && Intrinsics.areEqual(this.inlineData, trailer.inlineData) && Intrinsics.areEqual(this.statistics, trailer.statistics) && this.viewCount == trailer.viewCount && Intrinsics.areEqual(this.overlayImages, trailer.overlayImages) && Intrinsics.areEqual(this.tabs, trailer.tabs) && Intrinsics.areEqual(this.goldBadgeImageInfo, trailer.goldBadgeImageInfo) && this.existInCw == trailer.existInCw;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.description.hashCode() * 31) + this.title.hashCode()) * 31) + this.releaseDate.hashCode()) * 31) + this.stream.hashCode()) * 31) + this.type.hashCode()) * 31) + (this.tvodPackImageInfo == null ? 0 : this.tvodPackImageInfo.hashCode())) * 31) + (this.tvodDetail == null ? 0 : this.tvodDetail.hashCode())) * 31) + Trailer$$ExternalSyntheticBackport0.m35m(this.watchAt)) * 31) + Trailer$$ExternalSyntheticBackport1.m36m(this.lastWatched)) * 31) + (this.lastWatchedEpisodeId == null ? 0 : this.lastWatchedEpisodeId.hashCode())) * 31) + (this.subtitleLanguageCode == null ? 0 : this.subtitleLanguageCode.hashCode())) * 31) + (this.audioTrackLanguageCode == null ? 0 : this.audioTrackLanguageCode.hashCode())) * 31) + Trailer$$ExternalSyntheticBackport0.m35m(this.statusCode)) * 31) + Trailer$$ExternalSyntheticBackport1.m36m(this.lastTvShowEpisode)) * 31) + Trailer$$ExternalSyntheticBackport0.m35m(this.rating)) * 31) + (this.descriptor == null ? 0 : this.descriptor.hashCode())) * 31) + this.id.hashCode()) * 31) + this.languages.hashCode()) * 31) + this.languagesDetails.hashCode()) * 31) + Trailer$$ExternalSyntheticBackport0.m35m(this.duration)) * 31) + this.genres.hashCode()) * 31) + this.genresDetails.hashCode()) * 31) + (this.secondaryGenres == null ? 0 : this.secondaryGenres.hashCode())) * 31) + (this.publishTime == null ? 0 : this.publishTime.hashCode())) * 31) + this.shareUrl.hashCode()) * 31) + this.image.hashCode()) * 31) + this.imageInfo.hashCode()) * 31) + (this.titleContentImageInfo == null ? 0 : this.titleContentImageInfo.hashCode())) * 31) + (this.trailer == null ? 0 : this.trailer.hashCode())) * 31) + (this.firstVideo == null ? 0 : this.firstVideo.hashCode())) * 31) + (this.container == null ? 0 : this.container.hashCode())) * 31) + this.contributors.hashCode()) * 31) + Trailer$$ExternalSyntheticBackport0.m35m(this.sequence)) * 31) + this.subType.hashCode()) * 31) + Trailer$$ExternalSyntheticBackport1.m36m(this.canPreviewGifvideo)) * 31) + this.webUrl.hashCode()) * 31) + Trailer$$ExternalSyntheticBackport1.m36m(this.isOptimizedDescription)) * 31) + Trailer$$ExternalSyntheticBackport0.m35m(this.childCount)) * 31) + Trailer$$ExternalSyntheticBackport0.m35m(this.videoCount)) * 31) + (this.detailKey == null ? 0 : this.detailKey.hashCode())) * 31) + (this.inlineData == null ? 0 : this.inlineData.hashCode())) * 31) + (this.statistics == null ? 0 : this.statistics.hashCode())) * 31) + Trailer$$ExternalSyntheticBackport0.m35m(this.viewCount)) * 31) + (this.overlayImages == null ? 0 : this.overlayImages.hashCode())) * 31) + (this.tabs == null ? 0 : this.tabs.hashCode())) * 31) + (this.goldBadgeImageInfo != null ? this.goldBadgeImageInfo.hashCode() : 0)) * 31) + Trailer$$ExternalSyntheticBackport1.m36m(this.existInCw);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trailer(description=").append(this.description).append(", title=").append(this.title).append(", releaseDate=").append(this.releaseDate).append(", stream=").append(this.stream).append(", type=").append(this.type).append(", tvodPackImageInfo=").append(this.tvodPackImageInfo).append(", tvodDetail=").append(this.tvodDetail).append(", watchAt=").append(this.watchAt).append(", lastWatched=").append(this.lastWatched).append(", lastWatchedEpisodeId=").append(this.lastWatchedEpisodeId).append(", subtitleLanguageCode=").append(this.subtitleLanguageCode).append(", audioTrackLanguageCode=");
        sb.append(this.audioTrackLanguageCode).append(", statusCode=").append(this.statusCode).append(", lastTvShowEpisode=").append(this.lastTvShowEpisode).append(", rating=").append(this.rating).append(", descriptor=").append(this.descriptor).append(", id=").append(this.id).append(", languages=").append(this.languages).append(", languagesDetails=").append(this.languagesDetails).append(", duration=").append(this.duration).append(", genres=").append(this.genres).append(", genresDetails=").append(this.genresDetails).append(", secondaryGenres=").append(this.secondaryGenres);
        sb.append(", publishTime=").append(this.publishTime).append(", shareUrl=").append(this.shareUrl).append(", image=").append(this.image).append(", imageInfo=").append(this.imageInfo).append(", titleContentImageInfo=").append(this.titleContentImageInfo).append(", trailer=").append(this.trailer).append(", firstVideo=").append(this.firstVideo).append(", container=").append(this.container).append(", contributors=").append(this.contributors).append(", sequence=").append(this.sequence).append(", subType=").append(this.subType).append(", canPreviewGifvideo=");
        sb.append(this.canPreviewGifvideo).append(", webUrl=").append(this.webUrl).append(", isOptimizedDescription=").append(this.isOptimizedDescription).append(", childCount=").append(this.childCount).append(", videoCount=").append(this.videoCount).append(", detailKey=").append(this.detailKey).append(", inlineData=").append(this.inlineData).append(", statistics=").append(this.statistics).append(", viewCount=").append(this.viewCount).append(", overlayImages=").append(this.overlayImages).append(", tabs=").append(this.tabs).append(", goldBadgeImageInfo=").append(this.goldBadgeImageInfo);
        sb.append(", existInCw=").append(this.existInCw).append(')');
        return sb.toString();
    }

    public Trailer(@NotNull String description, @NotNull String title, @NotNull String releaseDate, @NotNull Stream stream, @NotNull String type, @Nullable Object tvodPackImageInfo, @Nullable Object tvodDetail, long watchAt, boolean lastWatched, @Nullable Object lastWatchedEpisodeId, @Nullable Object subtitleLanguageCode, @Nullable Object audioTrackLanguageCode, long statusCode, boolean lastTvShowEpisode, long rating, @Nullable Object descriptor, @NotNull String id, @NotNull List<String> list, @NotNull List<LanguagesDetail2> list2, long duration, @NotNull List<String> list3, @NotNull List<GenresDetail2> list4, @Nullable Object secondaryGenres, @Nullable Object publishTime, @NotNull String shareUrl, @NotNull Image2 image, @NotNull List<ImageInfo2> list5, @Nullable Object titleContentImageInfo, @Nullable Object trailer, @Nullable Object firstVideo, @Nullable Object container, @NotNull List<? extends Object> list6, long sequence, @NotNull String subType, @JsonProperty("canPreviewGIFVideo") boolean canPreviewGifvideo, @NotNull String webUrl, boolean isOptimizedDescription, long childCount, long videoCount, @Nullable Object detailKey, @Nullable Object inlineData, @Nullable Object statistics, long viewCount, @Nullable Object overlayImages, @Nullable Object tabs, @Nullable Object goldBadgeImageInfo, @JsonProperty("existInCW") boolean existInCw) {
        this.description = description;
        this.title = title;
        this.releaseDate = releaseDate;
        this.stream = stream;
        this.type = type;
        this.tvodPackImageInfo = tvodPackImageInfo;
        this.tvodDetail = tvodDetail;
        this.watchAt = watchAt;
        this.lastWatched = lastWatched;
        this.lastWatchedEpisodeId = lastWatchedEpisodeId;
        this.subtitleLanguageCode = subtitleLanguageCode;
        this.audioTrackLanguageCode = audioTrackLanguageCode;
        this.statusCode = statusCode;
        this.lastTvShowEpisode = lastTvShowEpisode;
        this.rating = rating;
        this.descriptor = descriptor;
        this.id = id;
        this.languages = list;
        this.languagesDetails = list2;
        this.duration = duration;
        this.genres = list3;
        this.genresDetails = list4;
        this.secondaryGenres = secondaryGenres;
        this.publishTime = publishTime;
        this.shareUrl = shareUrl;
        this.image = image;
        this.imageInfo = list5;
        this.titleContentImageInfo = titleContentImageInfo;
        this.trailer = trailer;
        this.firstVideo = firstVideo;
        this.container = container;
        this.contributors = list6;
        this.sequence = sequence;
        this.subType = subType;
        this.canPreviewGifvideo = canPreviewGifvideo;
        this.webUrl = webUrl;
        this.isOptimizedDescription = isOptimizedDescription;
        this.childCount = childCount;
        this.videoCount = videoCount;
        this.detailKey = detailKey;
        this.inlineData = inlineData;
        this.statistics = statistics;
        this.viewCount = viewCount;
        this.overlayImages = overlayImages;
        this.tabs = tabs;
        this.goldBadgeImageInfo = goldBadgeImageInfo;
        this.existInCw = existInCw;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @NotNull
    public final Stream getStream() {
        return this.stream;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Object getTvodPackImageInfo() {
        return this.tvodPackImageInfo;
    }

    @Nullable
    public final Object getTvodDetail() {
        return this.tvodDetail;
    }

    public final long getWatchAt() {
        return this.watchAt;
    }

    public final boolean getLastWatched() {
        return this.lastWatched;
    }

    @Nullable
    public final Object getLastWatchedEpisodeId() {
        return this.lastWatchedEpisodeId;
    }

    @Nullable
    public final Object getSubtitleLanguageCode() {
        return this.subtitleLanguageCode;
    }

    @Nullable
    public final Object getAudioTrackLanguageCode() {
        return this.audioTrackLanguageCode;
    }

    public final long getStatusCode() {
        return this.statusCode;
    }

    public final boolean getLastTvShowEpisode() {
        return this.lastTvShowEpisode;
    }

    public final long getRating() {
        return this.rating;
    }

    @Nullable
    public final Object getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<String> getLanguages() {
        return this.languages;
    }

    @NotNull
    public final List<LanguagesDetail2> getLanguagesDetails() {
        return this.languagesDetails;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final List<String> getGenres() {
        return this.genres;
    }

    @NotNull
    public final List<GenresDetail2> getGenresDetails() {
        return this.genresDetails;
    }

    @Nullable
    public final Object getSecondaryGenres() {
        return this.secondaryGenres;
    }

    @Nullable
    public final Object getPublishTime() {
        return this.publishTime;
    }

    @NotNull
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    public final Image2 getImage() {
        return this.image;
    }

    @NotNull
    public final List<ImageInfo2> getImageInfo() {
        return this.imageInfo;
    }

    @Nullable
    public final Object getTitleContentImageInfo() {
        return this.titleContentImageInfo;
    }

    @Nullable
    public final Object getTrailer() {
        return this.trailer;
    }

    @Nullable
    public final Object getFirstVideo() {
        return this.firstVideo;
    }

    @Nullable
    public final Object getContainer() {
        return this.container;
    }

    @NotNull
    public final List<Object> getContributors() {
        return this.contributors;
    }

    public final long getSequence() {
        return this.sequence;
    }

    @NotNull
    public final String getSubType() {
        return this.subType;
    }

    public final boolean getCanPreviewGifvideo() {
        return this.canPreviewGifvideo;
    }

    @NotNull
    public final String getWebUrl() {
        return this.webUrl;
    }

    public final boolean isOptimizedDescription() {
        return this.isOptimizedDescription;
    }

    public final long getChildCount() {
        return this.childCount;
    }

    public final long getVideoCount() {
        return this.videoCount;
    }

    @Nullable
    public final Object getDetailKey() {
        return this.detailKey;
    }

    @Nullable
    public final Object getInlineData() {
        return this.inlineData;
    }

    @Nullable
    public final Object getStatistics() {
        return this.statistics;
    }

    public final long getViewCount() {
        return this.viewCount;
    }

    @Nullable
    public final Object getOverlayImages() {
        return this.overlayImages;
    }

    @Nullable
    public final Object getTabs() {
        return this.tabs;
    }

    @Nullable
    public final Object getGoldBadgeImageInfo() {
        return this.goldBadgeImageInfo;
    }

    public final boolean getExistInCw() {
        return this.existInCw;
    }
}
