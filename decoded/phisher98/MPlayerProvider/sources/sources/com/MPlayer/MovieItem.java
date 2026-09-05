package com.MPlayer;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bx\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bû\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020#\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0018\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0018\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0001\u0012\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0018\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010-\u001a\u00020\f\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010/\u001a\u00020\u000e:\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u000e\u0012\u0006\u00105\u001a\u000206\u0012\u0006\u00107\u001a\u00020\f\u0012\u0006\u00108\u001a\u00020\f\u0012\b\u00109\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010<\u001a\u00020\f\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0001\u0012\u0016\b\u0001\u0010@\u001a\u00020\u000e:\f\b0\u0012\b\b1\u0012\u0004\b\b(A¢\u0006\u0004\bB\u0010CJ\t\u0010{\u001a\u00020\u0003HÆ\u0003J\t\u0010|\u001a\u00020\u0003HÆ\u0003J\t\u0010}\u001a\u00020\u0003HÆ\u0003J\t\u0010~\u001a\u00020\u0007HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u000eHÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\fHÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0003J\u0010\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\fHÆ\u0003J\u0010\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0003J\u0010\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018HÆ\u0003J\u0012\u0010\u0091\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020#HÆ\u0003J\u0010\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020%0\u0018HÆ\u0003J\u0012\u0010\u0096\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0018HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0012\u0010\u0098\u0001\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0018HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010 \u0001\u001a\u000206HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\fHÆ\u0003J\n\u0010¢\u0001\u001a\u00020\fHÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\fHÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u000eHÆ\u0003JÚ\u0004\u0010«\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00182\b\b\u0002\u0010\u001b\u001a\u00020\f2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00182\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00182\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00182\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u00182\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010-\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\u00032\u0016\b\u0003\u0010/\u001a\u00020\u000e:\f\b0\u0012\b\b1\u0012\u0004\b\b(22\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\f2\b\b\u0002\u00108\u001a\u00020\f2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010<\u001a\u00020\f2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00012\u0016\b\u0003\u0010@\u001a\u00020\u000e:\f\b0\u0012\b\b1\u0012\u0004\b\b(AHÆ\u0001J\u0016\u0010¬\u0001\u001a\u00020\u000e2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\f\u0010®\u0001\u001a\u00030¯\u0001HÖ\u0081\u0004J\u000b\u0010°\u0001\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010ER\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010ER\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010ER\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bM\u0010LR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bR\u0010LR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bS\u0010LR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bT\u0010LR\u0011\u0010\u0012\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bU\u0010OR\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bV\u0010QR\u0011\u0010\u0014\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bW\u0010OR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bX\u0010LR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ER\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010[R\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b]\u0010OR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\b\n\u0000\u001a\u0004\b^\u0010[R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018¢\u0006\b\n\u0000\u001a\u0004\b_\u0010[R\u0019\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b`\u0010[R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\ba\u0010ER\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bb\u0010ER\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0018¢\u0006\b\n\u0000\u001a\u0004\be\u0010[R\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bf\u0010[R\u0013\u0010(\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bg\u0010LR\u0019\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\bh\u0010[R\u0013\u0010+\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bi\u0010LR\u0013\u0010,\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bj\u0010LR\u0011\u0010-\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bk\u0010OR\u0011\u0010.\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010ER\u0011\u0010/\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bm\u0010QR\u0011\u00103\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010ER\u0011\u00104\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010QR\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0011\u00107\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bq\u0010OR\u0011\u00108\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\br\u0010OR\u0013\u00109\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bs\u0010LR\u0013\u0010:\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bt\u0010LR\u0013\u0010;\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bu\u0010LR\u0011\u0010<\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bv\u0010OR\u0013\u0010=\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bw\u0010LR\u0013\u0010>\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bx\u0010LR\u0013\u0010?\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\by\u0010LR\u0011\u0010@\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bz\u0010Q¨\u0006±\u0001"}, d2 = {"Lcom/MPlayer/MovieItem;", "", "description", "", "title", "releaseDate", "stream", "Lcom/MPlayer/MovieStream;", "type", "tvodPackImageInfo", "tvodDetail", "watchAt", "", "lastWatched", "", "lastWatchedEpisodeId", "subtitleLanguageCode", "audioTrackLanguageCode", "statusCode", "lastTvShowEpisode", "rating", "descriptor", "id", "languages", "", "languagesDetails", "Lcom/MPlayer/MovieLanguagesDetail;", "duration", "genres", "genresDetails", "Lcom/MPlayer/MovieGenresDetail;", "secondaryGenres", "publishTime", "shareUrl", "image", "Lcom/MPlayer/MovieImage;", "imageInfo", "Lcom/MPlayer/MovieImageInfo;", "titleContentImageInfo", "Lcom/MPlayer/MovieTitleContentImageInfo;", "trailerPreview", "trailer", "Lcom/MPlayer/MovieTrailer;", "firstVideo", "container", "sequence", "subType", "canPreviewGifvideo", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "canPreviewGIFVideo", "webUrl", "isOptimizedDescription", "publisher", "Lcom/MPlayer/MoviePublisher2;", "childCount", "videoCount", "detailKey", "inlineData", "statistics", "viewCount", "overlayImages", "tabs", "goldBadgeImageInfo", "existInCw", "existInCW", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/MPlayer/MovieStream;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;JZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;JZJLjava/lang/Object;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/MPlayer/MovieImage;Ljava/util/List;Ljava/util/List;Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;JLjava/lang/String;ZLjava/lang/String;ZLcom/MPlayer/MoviePublisher2;JJLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Z)V", "getDescription", "()Ljava/lang/String;", "getTitle", "getReleaseDate", "getStream", "()Lcom/MPlayer/MovieStream;", "getType", "getTvodPackImageInfo", "()Ljava/lang/Object;", "getTvodDetail", "getWatchAt", "()J", "getLastWatched", "()Z", "getLastWatchedEpisodeId", "getSubtitleLanguageCode", "getAudioTrackLanguageCode", "getStatusCode", "getLastTvShowEpisode", "getRating", "getDescriptor", "getId", "getLanguages", "()Ljava/util/List;", "getLanguagesDetails", "getDuration", "getGenres", "getGenresDetails", "getSecondaryGenres", "getPublishTime", "getShareUrl", "getImage", "()Lcom/MPlayer/MovieImage;", "getImageInfo", "getTitleContentImageInfo", "getTrailerPreview", "getTrailer", "getFirstVideo", "getContainer", "getSequence", "getSubType", "getCanPreviewGifvideo", "getWebUrl", "getPublisher", "()Lcom/MPlayer/MoviePublisher2;", "getChildCount", "getVideoCount", "getDetailKey", "getInlineData", "getStatistics", "getViewCount", "getOverlayImages", "getTabs", "getGoldBadgeImageInfo", "getExistInCw", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "copy", "equals", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieItem {

    @Nullable
    private final Object audioTrackLanguageCode;
    private final boolean canPreviewGifvideo;
    private final long childCount;

    @Nullable
    private final Object container;

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
    private final List<MovieGenresDetail> genresDetails;

    @Nullable
    private final Object goldBadgeImageInfo;

    @NotNull
    private final String id;

    @NotNull
    private final MovieImage image;

    @NotNull
    private final List<MovieImageInfo> imageInfo;

    @Nullable
    private final Object inlineData;
    private final boolean isOptimizedDescription;

    @NotNull
    private final List<String> languages;

    @NotNull
    private final List<MovieLanguagesDetail> languagesDetails;
    private final boolean lastTvShowEpisode;
    private final boolean lastWatched;

    @Nullable
    private final Object lastWatchedEpisodeId;

    @Nullable
    private final Object overlayImages;

    @NotNull
    private final String publishTime;

    @NotNull
    private final MoviePublisher2 publisher;
    private final long rating;

    @NotNull
    private final String releaseDate;

    @Nullable
    private final List<String> secondaryGenres;
    private final long sequence;

    @NotNull
    private final String shareUrl;

    @Nullable
    private final Object statistics;
    private final long statusCode;

    @NotNull
    private final MovieStream stream;

    @NotNull
    private final String subType;

    @Nullable
    private final Object subtitleLanguageCode;

    @Nullable
    private final Object tabs;

    @NotNull
    private final String title;

    @Nullable
    private final List<MovieTitleContentImageInfo> titleContentImageInfo;

    @Nullable
    private final List<MovieTrailer> trailer;

    @Nullable
    private final Object trailerPreview;

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
    public static /* synthetic */ MovieItem copy$default(MovieItem movieItem, String str, String str2, String str3, MovieStream movieStream, String str4, Object obj, Object obj2, long j, boolean z, Object obj3, Object obj4, Object obj5, long j2, boolean z2, long j3, Object obj6, String str5, List list, List list2, long j4, List list3, List list4, List list5, String str6, String str7, MovieImage movieImage, List list6, List list7, Object obj7, List list8, Object obj8, Object obj9, long j5, String str8, boolean z3, String str9, boolean z4, MoviePublisher2 moviePublisher2, long j6, long j7, Object obj10, Object obj11, Object obj12, long j8, Object obj13, Object obj14, Object obj15, boolean z5, int i, int i2, Object obj16) {
        String str10 = (i & 1) != 0 ? movieItem.description : str;
        String str11 = (i & 2) != 0 ? movieItem.title : str2;
        String str12 = (i & 4) != 0 ? movieItem.releaseDate : str3;
        MovieStream movieStream2 = (i & 8) != 0 ? movieItem.stream : movieStream;
        String str13 = (i & 16) != 0 ? movieItem.type : str4;
        Object obj17 = (i & 32) != 0 ? movieItem.tvodPackImageInfo : obj;
        Object obj18 = (i & 64) != 0 ? movieItem.tvodDetail : obj2;
        long j9 = (i & 128) != 0 ? movieItem.watchAt : j;
        boolean z6 = (i & 256) != 0 ? movieItem.lastWatched : z;
        Object obj19 = (i & 512) != 0 ? movieItem.lastWatchedEpisodeId : obj3;
        Object obj20 = (i & 1024) != 0 ? movieItem.subtitleLanguageCode : obj4;
        Object obj21 = (i & 2048) != 0 ? movieItem.audioTrackLanguageCode : obj5;
        String str14 = str10;
        String str15 = str11;
        long j10 = (i & 4096) != 0 ? movieItem.statusCode : j2;
        boolean z7 = (i & 8192) != 0 ? movieItem.lastTvShowEpisode : z2;
        long j11 = (i & 16384) != 0 ? movieItem.rating : j3;
        Object obj22 = (i & 32768) != 0 ? movieItem.descriptor : obj6;
        String str16 = (i & 65536) != 0 ? movieItem.id : str5;
        List list9 = (i & 131072) != 0 ? movieItem.languages : list;
        List list10 = (i & 262144) != 0 ? movieItem.languagesDetails : list2;
        long j12 = j11;
        long j13 = (i & 524288) != 0 ? movieItem.duration : j4;
        List list11 = list10;
        List list12 = (i & 1048576) != 0 ? movieItem.genres : list3;
        List list13 = (i & 2097152) != 0 ? movieItem.genresDetails : list4;
        List list14 = (i & 4194304) != 0 ? movieItem.secondaryGenres : list5;
        String str17 = (i & 8388608) != 0 ? movieItem.publishTime : str6;
        String str18 = (i & 16777216) != 0 ? movieItem.shareUrl : str7;
        MovieImage movieImage2 = (i & 33554432) != 0 ? movieItem.image : movieImage;
        List list15 = (i & 67108864) != 0 ? movieItem.imageInfo : list6;
        List list16 = (i & 134217728) != 0 ? movieItem.titleContentImageInfo : list7;
        Object obj23 = (i & 268435456) != 0 ? movieItem.trailerPreview : obj7;
        List list17 = (i & 536870912) != 0 ? movieItem.trailer : list8;
        Object obj24 = (i & 1073741824) != 0 ? movieItem.firstVideo : obj8;
        Object obj25 = (i & Integer.MIN_VALUE) != 0 ? movieItem.container : obj9;
        long j14 = (i2 & 1) != 0 ? movieItem.sequence : j5;
        Object obj26 = obj25;
        String str19 = (i2 & 2) != 0 ? movieItem.subType : str8;
        boolean z8 = (i2 & 4) != 0 ? movieItem.canPreviewGifvideo : z3;
        String str20 = (i2 & 8) != 0 ? movieItem.webUrl : str9;
        boolean z9 = (i2 & 16) != 0 ? movieItem.isOptimizedDescription : z4;
        long j15 = j14;
        MoviePublisher2 moviePublisher3 = (i2 & 32) != 0 ? movieItem.publisher : moviePublisher2;
        long j16 = (i2 & 64) != 0 ? movieItem.childCount : j6;
        long j17 = (i2 & 128) != 0 ? movieItem.videoCount : j7;
        return movieItem.copy(str14, str15, str12, movieStream2, str13, obj17, obj18, j9, z6, obj19, obj20, obj21, j10, z7, j12, obj22, str16, list9, list11, j13, list12, list13, list14, str17, str18, movieImage2, list15, list16, obj23, list17, obj24, obj26, j15, str19, z8, str20, z9, moviePublisher3, j16, j17, (i2 & 256) != 0 ? movieItem.detailKey : obj10, (i2 & 512) != 0 ? movieItem.inlineData : obj11, (i2 & 1024) != 0 ? movieItem.statistics : obj12, (i2 & 2048) != 0 ? movieItem.viewCount : j8, (i2 & 4096) != 0 ? movieItem.overlayImages : obj13, (i2 & 8192) != 0 ? movieItem.tabs : obj14, (i2 & 16384) != 0 ? movieItem.goldBadgeImageInfo : obj15, (i2 & 32768) != 0 ? movieItem.existInCw : z5);
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
    public final List<MovieLanguagesDetail> component19() {
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
    public final List<MovieGenresDetail> component22() {
        return this.genresDetails;
    }

    @Nullable
    public final List<String> component23() {
        return this.secondaryGenres;
    }

    @NotNull
    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getPublishTime() {
        return this.publishTime;
    }

    @NotNull
    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component26, reason: from getter */
    public final MovieImage getImage() {
        return this.image;
    }

    @NotNull
    public final List<MovieImageInfo> component27() {
        return this.imageInfo;
    }

    @Nullable
    public final List<MovieTitleContentImageInfo> component28() {
        return this.titleContentImageInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component29, reason: from getter */
    public final Object getTrailerPreview() {
        return this.trailerPreview;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReleaseDate() {
        return this.releaseDate;
    }

    @Nullable
    public final List<MovieTrailer> component30() {
        return this.trailer;
    }

    @Nullable
    /* JADX INFO: renamed from: component31, reason: from getter */
    public final Object getFirstVideo() {
        return this.firstVideo;
    }

    @Nullable
    /* JADX INFO: renamed from: component32, reason: from getter */
    public final Object getContainer() {
        return this.container;
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

    @NotNull
    /* JADX INFO: renamed from: component38, reason: from getter */
    public final MoviePublisher2 getPublisher() {
        return this.publisher;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final long getChildCount() {
        return this.childCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MovieStream getStream() {
        return this.stream;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final long getVideoCount() {
        return this.videoCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component41, reason: from getter */
    public final Object getDetailKey() {
        return this.detailKey;
    }

    @Nullable
    /* JADX INFO: renamed from: component42, reason: from getter */
    public final Object getInlineData() {
        return this.inlineData;
    }

    @Nullable
    /* JADX INFO: renamed from: component43, reason: from getter */
    public final Object getStatistics() {
        return this.statistics;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final long getViewCount() {
        return this.viewCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component45, reason: from getter */
    public final Object getOverlayImages() {
        return this.overlayImages;
    }

    @Nullable
    /* JADX INFO: renamed from: component46, reason: from getter */
    public final Object getTabs() {
        return this.tabs;
    }

    @Nullable
    /* JADX INFO: renamed from: component47, reason: from getter */
    public final Object getGoldBadgeImageInfo() {
        return this.goldBadgeImageInfo;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
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
    public final MovieItem copy(@NotNull String description, @NotNull String title, @NotNull String releaseDate, @NotNull MovieStream stream, @NotNull String type, @Nullable Object tvodPackImageInfo, @Nullable Object tvodDetail, long watchAt, boolean lastWatched, @Nullable Object lastWatchedEpisodeId, @Nullable Object subtitleLanguageCode, @Nullable Object audioTrackLanguageCode, long statusCode, boolean lastTvShowEpisode, long rating, @Nullable Object descriptor, @NotNull String id, @NotNull List<String> languages, @NotNull List<MovieLanguagesDetail> languagesDetails, long duration, @NotNull List<String> genres, @NotNull List<MovieGenresDetail> genresDetails, @Nullable List<String> secondaryGenres, @NotNull String publishTime, @NotNull String shareUrl, @NotNull MovieImage image, @NotNull List<MovieImageInfo> imageInfo, @Nullable List<MovieTitleContentImageInfo> titleContentImageInfo, @Nullable Object trailerPreview, @Nullable List<MovieTrailer> trailer, @Nullable Object firstVideo, @Nullable Object container, long sequence, @NotNull String subType, @JsonProperty("canPreviewGIFVideo") boolean canPreviewGifvideo, @NotNull String webUrl, boolean isOptimizedDescription, @NotNull MoviePublisher2 publisher, long childCount, long videoCount, @Nullable Object detailKey, @Nullable Object inlineData, @Nullable Object statistics, long viewCount, @Nullable Object overlayImages, @Nullable Object tabs, @Nullable Object goldBadgeImageInfo, @JsonProperty("existInCW") boolean existInCw) {
        return new MovieItem(description, title, releaseDate, stream, type, tvodPackImageInfo, tvodDetail, watchAt, lastWatched, lastWatchedEpisodeId, subtitleLanguageCode, audioTrackLanguageCode, statusCode, lastTvShowEpisode, rating, descriptor, id, languages, languagesDetails, duration, genres, genresDetails, secondaryGenres, publishTime, shareUrl, image, imageInfo, titleContentImageInfo, trailerPreview, trailer, firstVideo, container, sequence, subType, canPreviewGifvideo, webUrl, isOptimizedDescription, publisher, childCount, videoCount, detailKey, inlineData, statistics, viewCount, overlayImages, tabs, goldBadgeImageInfo, existInCw);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieItem)) {
            return false;
        }
        MovieItem movieItem = (MovieItem) other;
        return Intrinsics.areEqual(this.description, movieItem.description) && Intrinsics.areEqual(this.title, movieItem.title) && Intrinsics.areEqual(this.releaseDate, movieItem.releaseDate) && Intrinsics.areEqual(this.stream, movieItem.stream) && Intrinsics.areEqual(this.type, movieItem.type) && Intrinsics.areEqual(this.tvodPackImageInfo, movieItem.tvodPackImageInfo) && Intrinsics.areEqual(this.tvodDetail, movieItem.tvodDetail) && this.watchAt == movieItem.watchAt && this.lastWatched == movieItem.lastWatched && Intrinsics.areEqual(this.lastWatchedEpisodeId, movieItem.lastWatchedEpisodeId) && Intrinsics.areEqual(this.subtitleLanguageCode, movieItem.subtitleLanguageCode) && Intrinsics.areEqual(this.audioTrackLanguageCode, movieItem.audioTrackLanguageCode) && this.statusCode == movieItem.statusCode && this.lastTvShowEpisode == movieItem.lastTvShowEpisode && this.rating == movieItem.rating && Intrinsics.areEqual(this.descriptor, movieItem.descriptor) && Intrinsics.areEqual(this.id, movieItem.id) && Intrinsics.areEqual(this.languages, movieItem.languages) && Intrinsics.areEqual(this.languagesDetails, movieItem.languagesDetails) && this.duration == movieItem.duration && Intrinsics.areEqual(this.genres, movieItem.genres) && Intrinsics.areEqual(this.genresDetails, movieItem.genresDetails) && Intrinsics.areEqual(this.secondaryGenres, movieItem.secondaryGenres) && Intrinsics.areEqual(this.publishTime, movieItem.publishTime) && Intrinsics.areEqual(this.shareUrl, movieItem.shareUrl) && Intrinsics.areEqual(this.image, movieItem.image) && Intrinsics.areEqual(this.imageInfo, movieItem.imageInfo) && Intrinsics.areEqual(this.titleContentImageInfo, movieItem.titleContentImageInfo) && Intrinsics.areEqual(this.trailerPreview, movieItem.trailerPreview) && Intrinsics.areEqual(this.trailer, movieItem.trailer) && Intrinsics.areEqual(this.firstVideo, movieItem.firstVideo) && Intrinsics.areEqual(this.container, movieItem.container) && this.sequence == movieItem.sequence && Intrinsics.areEqual(this.subType, movieItem.subType) && this.canPreviewGifvideo == movieItem.canPreviewGifvideo && Intrinsics.areEqual(this.webUrl, movieItem.webUrl) && this.isOptimizedDescription == movieItem.isOptimizedDescription && Intrinsics.areEqual(this.publisher, movieItem.publisher) && this.childCount == movieItem.childCount && this.videoCount == movieItem.videoCount && Intrinsics.areEqual(this.detailKey, movieItem.detailKey) && Intrinsics.areEqual(this.inlineData, movieItem.inlineData) && Intrinsics.areEqual(this.statistics, movieItem.statistics) && this.viewCount == movieItem.viewCount && Intrinsics.areEqual(this.overlayImages, movieItem.overlayImages) && Intrinsics.areEqual(this.tabs, movieItem.tabs) && Intrinsics.areEqual(this.goldBadgeImageInfo, movieItem.goldBadgeImageInfo) && this.existInCw == movieItem.existInCw;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.description.hashCode() * 31) + this.title.hashCode()) * 31) + this.releaseDate.hashCode()) * 31) + this.stream.hashCode()) * 31) + this.type.hashCode()) * 31) + (this.tvodPackImageInfo == null ? 0 : this.tvodPackImageInfo.hashCode())) * 31) + (this.tvodDetail == null ? 0 : this.tvodDetail.hashCode())) * 31) + MovieItem$$ExternalSyntheticBackport0.m19m(this.watchAt)) * 31) + MovieItem$$ExternalSyntheticBackport1.m20m(this.lastWatched)) * 31) + (this.lastWatchedEpisodeId == null ? 0 : this.lastWatchedEpisodeId.hashCode())) * 31) + (this.subtitleLanguageCode == null ? 0 : this.subtitleLanguageCode.hashCode())) * 31) + (this.audioTrackLanguageCode == null ? 0 : this.audioTrackLanguageCode.hashCode())) * 31) + MovieItem$$ExternalSyntheticBackport0.m19m(this.statusCode)) * 31) + MovieItem$$ExternalSyntheticBackport1.m20m(this.lastTvShowEpisode)) * 31) + MovieItem$$ExternalSyntheticBackport0.m19m(this.rating)) * 31) + (this.descriptor == null ? 0 : this.descriptor.hashCode())) * 31) + this.id.hashCode()) * 31) + this.languages.hashCode()) * 31) + this.languagesDetails.hashCode()) * 31) + MovieItem$$ExternalSyntheticBackport0.m19m(this.duration)) * 31) + this.genres.hashCode()) * 31) + this.genresDetails.hashCode()) * 31) + (this.secondaryGenres == null ? 0 : this.secondaryGenres.hashCode())) * 31) + this.publishTime.hashCode()) * 31) + this.shareUrl.hashCode()) * 31) + this.image.hashCode()) * 31) + this.imageInfo.hashCode()) * 31) + (this.titleContentImageInfo == null ? 0 : this.titleContentImageInfo.hashCode())) * 31) + (this.trailerPreview == null ? 0 : this.trailerPreview.hashCode())) * 31) + (this.trailer == null ? 0 : this.trailer.hashCode())) * 31) + (this.firstVideo == null ? 0 : this.firstVideo.hashCode())) * 31) + (this.container == null ? 0 : this.container.hashCode())) * 31) + MovieItem$$ExternalSyntheticBackport0.m19m(this.sequence)) * 31) + this.subType.hashCode()) * 31) + MovieItem$$ExternalSyntheticBackport1.m20m(this.canPreviewGifvideo)) * 31) + this.webUrl.hashCode()) * 31) + MovieItem$$ExternalSyntheticBackport1.m20m(this.isOptimizedDescription)) * 31) + this.publisher.hashCode()) * 31) + MovieItem$$ExternalSyntheticBackport0.m19m(this.childCount)) * 31) + MovieItem$$ExternalSyntheticBackport0.m19m(this.videoCount)) * 31) + (this.detailKey == null ? 0 : this.detailKey.hashCode())) * 31) + (this.inlineData == null ? 0 : this.inlineData.hashCode())) * 31) + (this.statistics == null ? 0 : this.statistics.hashCode())) * 31) + MovieItem$$ExternalSyntheticBackport0.m19m(this.viewCount)) * 31) + (this.overlayImages == null ? 0 : this.overlayImages.hashCode())) * 31) + (this.tabs == null ? 0 : this.tabs.hashCode())) * 31) + (this.goldBadgeImageInfo != null ? this.goldBadgeImageInfo.hashCode() : 0)) * 31) + MovieItem$$ExternalSyntheticBackport1.m20m(this.existInCw);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MovieItem(description=").append(this.description).append(", title=").append(this.title).append(", releaseDate=").append(this.releaseDate).append(", stream=").append(this.stream).append(", type=").append(this.type).append(", tvodPackImageInfo=").append(this.tvodPackImageInfo).append(", tvodDetail=").append(this.tvodDetail).append(", watchAt=").append(this.watchAt).append(", lastWatched=").append(this.lastWatched).append(", lastWatchedEpisodeId=").append(this.lastWatchedEpisodeId).append(", subtitleLanguageCode=").append(this.subtitleLanguageCode).append(", audioTrackLanguageCode=");
        sb.append(this.audioTrackLanguageCode).append(", statusCode=").append(this.statusCode).append(", lastTvShowEpisode=").append(this.lastTvShowEpisode).append(", rating=").append(this.rating).append(", descriptor=").append(this.descriptor).append(", id=").append(this.id).append(", languages=").append(this.languages).append(", languagesDetails=").append(this.languagesDetails).append(", duration=").append(this.duration).append(", genres=").append(this.genres).append(", genresDetails=").append(this.genresDetails).append(", secondaryGenres=").append(this.secondaryGenres);
        sb.append(", publishTime=").append(this.publishTime).append(", shareUrl=").append(this.shareUrl).append(", image=").append(this.image).append(", imageInfo=").append(this.imageInfo).append(", titleContentImageInfo=").append(this.titleContentImageInfo).append(", trailerPreview=").append(this.trailerPreview).append(", trailer=").append(this.trailer).append(", firstVideo=").append(this.firstVideo).append(", container=").append(this.container).append(", sequence=").append(this.sequence).append(", subType=").append(this.subType).append(", canPreviewGifvideo=");
        sb.append(this.canPreviewGifvideo).append(", webUrl=").append(this.webUrl).append(", isOptimizedDescription=").append(this.isOptimizedDescription).append(", publisher=").append(this.publisher).append(", childCount=").append(this.childCount).append(", videoCount=").append(this.videoCount).append(", detailKey=").append(this.detailKey).append(", inlineData=").append(this.inlineData).append(", statistics=").append(this.statistics).append(", viewCount=").append(this.viewCount).append(", overlayImages=").append(this.overlayImages).append(", tabs=").append(this.tabs);
        sb.append(", goldBadgeImageInfo=").append(this.goldBadgeImageInfo).append(", existInCw=").append(this.existInCw).append(')');
        return sb.toString();
    }

    public MovieItem(@NotNull String description, @NotNull String title, @NotNull String releaseDate, @NotNull MovieStream stream, @NotNull String type, @Nullable Object tvodPackImageInfo, @Nullable Object tvodDetail, long watchAt, boolean lastWatched, @Nullable Object lastWatchedEpisodeId, @Nullable Object subtitleLanguageCode, @Nullable Object audioTrackLanguageCode, long statusCode, boolean lastTvShowEpisode, long rating, @Nullable Object descriptor, @NotNull String id, @NotNull List<String> list, @NotNull List<MovieLanguagesDetail> list2, long duration, @NotNull List<String> list3, @NotNull List<MovieGenresDetail> list4, @Nullable List<String> list5, @NotNull String publishTime, @NotNull String shareUrl, @NotNull MovieImage image, @NotNull List<MovieImageInfo> list6, @Nullable List<MovieTitleContentImageInfo> list7, @Nullable Object trailerPreview, @Nullable List<MovieTrailer> list8, @Nullable Object firstVideo, @Nullable Object container, long sequence, @NotNull String subType, @JsonProperty("canPreviewGIFVideo") boolean canPreviewGifvideo, @NotNull String webUrl, boolean isOptimizedDescription, @NotNull MoviePublisher2 publisher, long childCount, long videoCount, @Nullable Object detailKey, @Nullable Object inlineData, @Nullable Object statistics, long viewCount, @Nullable Object overlayImages, @Nullable Object tabs, @Nullable Object goldBadgeImageInfo, @JsonProperty("existInCW") boolean existInCw) {
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
        this.secondaryGenres = list5;
        this.publishTime = publishTime;
        this.shareUrl = shareUrl;
        this.image = image;
        this.imageInfo = list6;
        this.titleContentImageInfo = list7;
        this.trailerPreview = trailerPreview;
        this.trailer = list8;
        this.firstVideo = firstVideo;
        this.container = container;
        this.sequence = sequence;
        this.subType = subType;
        this.canPreviewGifvideo = canPreviewGifvideo;
        this.webUrl = webUrl;
        this.isOptimizedDescription = isOptimizedDescription;
        this.publisher = publisher;
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
    public final MovieStream getStream() {
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
    public final List<MovieLanguagesDetail> getLanguagesDetails() {
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
    public final List<MovieGenresDetail> getGenresDetails() {
        return this.genresDetails;
    }

    @Nullable
    public final List<String> getSecondaryGenres() {
        return this.secondaryGenres;
    }

    @NotNull
    public final String getPublishTime() {
        return this.publishTime;
    }

    @NotNull
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @NotNull
    public final MovieImage getImage() {
        return this.image;
    }

    @NotNull
    public final List<MovieImageInfo> getImageInfo() {
        return this.imageInfo;
    }

    @Nullable
    public final List<MovieTitleContentImageInfo> getTitleContentImageInfo() {
        return this.titleContentImageInfo;
    }

    @Nullable
    public final Object getTrailerPreview() {
        return this.trailerPreview;
    }

    @Nullable
    public final List<MovieTrailer> getTrailer() {
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

    @NotNull
    public final MoviePublisher2 getPublisher() {
        return this.publisher;
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
